package com.cg.service.withdraw;

import com.cg.model.Customer;
import com.cg.model.Withdraw;
import com.cg.service.IGeneralService;

public interface WithdrawService extends IGeneralService<Withdraw> {
    Customer withdraw(Withdraw withdraw);
}