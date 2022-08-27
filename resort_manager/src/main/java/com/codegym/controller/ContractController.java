package com.codegym.controller;

import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.AttachServiceService;
import com.codegym.service.contract.ContractDetailService;
import com.codegym.service.contract.ContractService;
import com.codegym.service.contract.TotalPay;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private AttachServiceService attachServiceService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private TotalPay totalPay;

    @GetMapping("/list")
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("contract_id");

        Page<Contract> contractList = contractService.findAllContract(PageRequest.of(page, 5, sort));
        List<AttachService> attachServiceList = attachServiceService.findAllAttachService();
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        List<Facility> facilityList = serviceService.findAll();
        List<Double> totalPayList = totalPay.getTotalPay(contractList.getContent(), attachServiceList, contractDetailList, facilityList);

        List<ContractDto> contractDtoList = new ArrayList<>();
        for (int i = 0; i < contractList.getContent().size(); i++) {
            ContractDto contractDto = new ContractDto();

            contractDto.setContractId(contractList.getContent().get(i).getContractId());
            contractDto.setCustomer(contractList.getContent().get(i).getCustomer());
            contractDto.setDeposit(contractList.getContent().get(i).getDeposit());
            contractDto.setEmployee(contractList.getContent().get(i).getEmployee());
            contractDto.setEndDate(contractList.getContent().get(i).getEndDate());
            contractDto.setStartDate(contractList.getContent().get(i).getStartDate());
            contractDto.setFacility(contractList.getContent().get(i).getFacility());

            contractDto.setTotalPay(totalPayList.get(i));
            contractDtoList.add(contractDto);
        }
        model.addAttribute("contractDtoList", contractDtoList);
        model.addAttribute("contractList", contractList);
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachServiceList", attachServiceList);
        model.addAttribute("totalPay", contractService.getTotalPay());
        return "/contract/ContractList";
    }

    @PostMapping("/createContractDetail")
    public String contractDetail(@RequestParam(name = "allAttachService", required = false) String[] allAttachService,
                                 @RequestParam(name = "unitOfAttachService", required = false) String[] unitOfAttachService,
                                 @RequestParam(name = "idContract", required = false) String idContract,
                                 Model model) {
        if (allAttachService == null) {
            return "redirect:/contract/list";
        }
        int contractID = Integer.parseInt(idContract);
        for (int i = 0; i < allAttachService.length; i++) {
            for (int j = 0; j < unitOfAttachService.length; j++) {
                if (Integer.parseInt(allAttachService[i]) == (j + 1)) {
                    Contract contract = contractService.findById(contractID);
                    AttachService attachService = attachServiceService.findById(Integer.parseInt(allAttachService[i]));
                    ContractDetail contractDetail = new ContractDetail();
                    contractDetail.setAttachService(attachService);
                    contractDetail.setContract(contract);
                    contractDetail.setQuantity(Integer.parseInt(unitOfAttachService[j]));
                    contractDetailService.Save(contractDetail);
                }
            }
        }
        return "redirect:/contract/list";
    }

    @GetMapping("/create")
    public String showPageAddNewContract(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerList", customerService.findAll2());
        model.addAttribute("facilityList", serviceService.findAll());
        return "/contract/ContractAdd";
    }

    @PostMapping("/createContractDetail2")
    public String contractDetail2(@RequestParam(name = "allAttachService", required = false) String[] allAttachService,
                                  @RequestParam(name = "unitOfAttachService", required = false) String[] unitOfAttachService,
                                  @ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        if (allAttachService != null) {
            for (int i = 0; i < allAttachService.length; i++) {
                for (int j = 0; j < unitOfAttachService.length; j++) {
                    if (Integer.parseInt(allAttachService[i]) == (j + 1)) {
                        AttachService attachService = attachServiceService.findById(Integer.parseInt(allAttachService[i]));
                        ContractDetail contractDetail = new ContractDetail();
                        contractDetail.setAttachService(attachService);
                        contractDetail.setContract(contract);
                        contractDetail.setQuantity(Integer.parseInt(unitOfAttachService[j]));
                        contractDetailService.Save(contractDetail);
                    }
                }
            }
        }
        return "redirect:/contract/list";
    }
}
