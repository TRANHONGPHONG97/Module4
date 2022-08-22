class Customer {
    constructor(id, fullName, email, phone, address, balance, deleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.deleted = deleted;
    }
}
class Deposit {
    constructor(id, customerId, transactionAmount) {
        this.id = id;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
    }
}

class Withdraw extends Deposit {
    constructor() {
        super();
    }
}
class Transfer {
    constructor(id, senderId, repcipientId, fess, fessAmount, transferAmount, transactionAmount ){
        this.id = id;
        this.senderId = senderId;
        this.repcipientId = repcipientId;
        this.fess = fess;
        this.fessAmount = fessAmount;
        this.transferAmount = transferAmount;
        this.transactionAmount = transactionAmount
    }
}

class Sender extends Customer {
    constructor() {
        super()
    }
}

class Recipient extends Customer {
    constructor() {
        super()
    }
}