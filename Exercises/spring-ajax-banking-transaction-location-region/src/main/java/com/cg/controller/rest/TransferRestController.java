package com.cg.controller.rest;

import com.cg.model.dto.ITransferHistoryDTO;
import com.cg.model.dto.TransferHistoryDTO;
import com.cg.service.transfer.TransferService;
import com.cg.model.Transfer;
import com.cg.model.dto.ITransferHistoryDTO;
import com.cg.model.dto.TransferHistoryDTO;
import com.cg.service.transfer.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferRestController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/histories")
    public ResponseEntity<?> getAllTransferHistory() {

        List<TransferHistoryDTO> transferHistoryDTOS = transferService.getAllHistory();

        return new ResponseEntity<>(transferHistoryDTOS, HttpStatus.OK);
    }

    @GetMapping("/histories-inf")
    public ResponseEntity<?> getAllTransferHistoryInf() {

        List<ITransferHistoryDTO> transferDTOSInf = transferService.getAllHistoryItf();

        return new ResponseEntity<>(transferDTOSInf, HttpStatus.OK);
    }

}
