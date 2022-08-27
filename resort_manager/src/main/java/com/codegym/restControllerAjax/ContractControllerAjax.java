package com.codegym.restControllerAjax;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.AttachServiceService;
import com.codegym.service.contract.ContractDetailService;
import com.codegym.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contractAjax")
public class ContractControllerAjax {

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServiceService attachServiceService;

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/showListAttachService/{id}")
    public ResponseEntity<?> showListAttachService(@PathVariable("id") Integer id) {
        List<ContractDetail> contractDetailList = contractDetailService.findByIdOfContract(id);
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @GetMapping("/showListAttachServiceCreate")
    public ResponseEntity<?> showListAttachServiceCreate() {
        List<AttachService> attachServiceList = attachServiceService.findAllAttachService();
        return new ResponseEntity<>(attachServiceList, HttpStatus.OK);
    }

    @GetMapping("/totalPayAddNew/{id}")
    public ResponseEntity<?> totalPayCal(@PathVariable("id") Integer id) {
        Facility facility = serviceService.findById(id);
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @GetMapping("/totalPayAddNew2/{id}")
    public ResponseEntity<?> totalPayCal2(@PathVariable("id") Integer id) {
        List<AttachService> attachServiceList = attachServiceService.findAllAttachService();
        Facility facility = serviceService.findById(id);
        List<Object> result = new ArrayList<>();
        result.add(attachServiceList);
        result.add(facility);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
