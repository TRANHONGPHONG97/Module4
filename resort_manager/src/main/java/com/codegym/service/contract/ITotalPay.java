package com.codegym.service.contract;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;

import java.util.List;

public interface ITotalPay {

    List<Double> getTotalPay(List<Contract> contractList,
                       List<AttachService> attachServiceList,
                       List<ContractDetail> contractDetailList,
                       List<Facility> facilityList
                       );
}
