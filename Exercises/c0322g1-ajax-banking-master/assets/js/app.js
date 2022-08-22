
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
