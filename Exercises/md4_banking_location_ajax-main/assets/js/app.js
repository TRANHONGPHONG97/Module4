class App {

    static SweetAlert = class {

        static showAlertSuccess(t) {
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: t,
                showConfirmButton: false,
                timer: 9000
            })
        }

        static showAlertError(t) {
            Swal.fire({
                position: 'top-end',
                icon: 'error',
                title: t,
                showConfirmButton: false,
                timer: 4000
            })
        }

        static showConfirmDelete() {
            return Swal.fire({
                title: 'Bạn Có Chắc Chắn Muốn Xóa ?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, deactive it!'
            });
        }

    }
    static IziToast = class {
        static showAlertSuccess(t) {
            return iziToast.success({
                    title: 'SUCCESS',
                    position: 'topRight',
                    timeout: 2000,
                    message: t
                });
        }
        static showAlertError(t){
            return  iziToast.error({
                        title: 'ERROR',
                        position: 'topRight',
                        timeout: 2000,
                        message: t
                    });
        }
    }
}


class Customer {
    constructor(id, fullName, email, phone, locationRegion, balance = 0, deleted = 0) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.balance = balance;
        this.deleted = deleted;
    }
}

class Sender {
    constructor(id, fullName, email, phone, locationRegion, balance , deleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.balance = balance;
        this.deleted = deleted;
    }
}

class Recipient {
    constructor(id, fullName, email, phone, locationRegion, balance , deleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.balance = balance;
        this.deleted = deleted;
    }
}

class LocationRegion {
    constructor(address,provinceId,provinceName,districtId,districtName,wardId,wardName){
        this.address = address;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.wardId = wardId;
        this.wardName = wardName;
    }
}

class Deposit {
    constructor(id, customerId, transactionAmount, createdAt, createdBy = "", updatedAT = "", updatedBy = "", deleted = 0) {
        this.id = id;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAT;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
    }
}

class Withdraw {
    constructor(id, customerId, transactionAmount, createdAt, createdBy = "", updatedAT = "", updatedBy = "", deleted = 0) {
        this.id = id;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAT;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
    }
}

class Transfer{
    constructor(id,createdAt,createdBy = "",deleted = 0,updatedAt = "",updatedBy = "",fees = 10,feesAmount,transactionAmount,transferAmount,recipientId,senderId){
        this.id = id;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.deleted = deleted;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transactionAmount = transactionAmount;
        this.transferAmount = transferAmount;
        this.recipientId = recipientId;
        this.senderId = senderId;
    }
}