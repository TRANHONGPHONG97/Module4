package com.codegym.service.contract;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TotalPay implements ITotalPay{

    @Autowired
    private ContractDetailService contractDetailService;

    @Override
    public List<Double> getTotalPay(List<Contract> contractList, List<AttachService> attachServiceList, List<ContractDetail> contractDetailList, List<Facility> facilityList) {
        List<Double> totalPay = new ArrayList<>();
        for (int i = 0; i < contractList.size(); i++) {
            double pay = contractList.get(i).getFacility().getCost() - Double.parseDouble(contractList.get(i).getDeposit());
            List<ContractDetail> contractDetailList1 = contractDetailService.findByIdOfContract(contractList.get(i).getContractId());
            if (contractDetailList1.isEmpty()) {

            } else {
                for (int j = 0; j < contractDetailList1.size(); j++) {
                    pay += contractDetailList1.get(j).getAttachService().getAttachServiceCost() * contractDetailList1.get(j).getQuantity();
                }
            }
            totalPay.add(pay);
        }
        return totalPay;
    }
}
