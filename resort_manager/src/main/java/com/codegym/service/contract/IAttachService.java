package com.codegym.service.contract;

import com.codegym.model.contract.AttachService;

import java.util.List;

public interface IAttachService {

    List<AttachService> findAllAttachService();

    AttachService findById(Integer id);


}
