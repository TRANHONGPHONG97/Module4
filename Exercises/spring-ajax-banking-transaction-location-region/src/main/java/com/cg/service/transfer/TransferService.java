package com.cg.service.transfer;

import com.cg.model.Transfer;
import com.cg.model.dto.ITransferHistoryDTO;
import com.cg.model.dto.TransferHistoryDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface TransferService extends IGeneralService<Transfer> {

    List<Transfer> findAll();

    List<TransferHistoryDTO> findAllHistories();

    List<TransferHistoryDTO> getAllHistory();

    List<ITransferHistoryDTO> getAllHistoryItf();

    void doTransfer(Transfer transfer);
}