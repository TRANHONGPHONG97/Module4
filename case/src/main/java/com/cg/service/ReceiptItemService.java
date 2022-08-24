package com.cg.service;

import com.cg.model.ReceiptItem;

import java.util.List;

/**
 *
 * @author TVD
 */
public interface ReceiptItemService {
    
    // create
    public boolean create(ReceiptItem object);

    // update
    public boolean update(ReceiptItem object);

    // delete
    public boolean delete(ReceiptItem object);

    // find by id
    public ReceiptItem findById(long receiptItemId);

    // load list receipt item
    public List<ReceiptItem> getListByReceipt(int receiptId);
    
}
