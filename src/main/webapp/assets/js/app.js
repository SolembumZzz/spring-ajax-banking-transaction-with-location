class App {
    static DOMAIN = location.origin;

    static BASE_URL_CUSTOMER = this.DOMAIN + "/api/customers";
    static BASE_URL_TRANSFER = this.DOMAIN + "/api/transfers";
    static BASE_URL_PROVINCE = "https://vapi.vnappmob.com/api/province";

    static ERROR_400 = "Transaction uncompleted, please check your data";
    static ERROR_404 = "An error occurred. Please try again later!";
    static ERROR_500 = "Data saved unsuccessfully, please contact administrators";
    static SUCCESS_CREATED = "Data generated successfully!";
    static SUCCESS_UPDATED = "Data updated successfully!";
    static SUCCESS_DEPOSIT = "Deposit successfully!";
    static SUCCESS_WITHDRAW = "Withdraw successfully!";
    static SUCCESS_TRANSFER = "Transfer successfully!";
    static SUCCESS_SUSPEND = "Deactivate successfully!";

    static SweetAlert = class {
        static showSuspendConfirmDialog() {
            return Swal.fire({
                icon: 'warning',
                text: 'Are you sure to suspend the selected customer?',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#5a6268',
                confirmButtonText: 'Hell yeah!',
                cancelButtonText: 'Yeah, nah',
            })
        }

        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'center',
                showConfirmButton: false,
                timer: 1500,
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
                timer: 2000,
            })
        }
    }

    static IziToast = class {
        static showSuccessAlert(t) {
            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 2500,
                message: t
            });
        }

        static showErrorAlert(t) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 3500,
                message: t
            });
        }
    }

    static formatNumber() {
        $(".num-space").number(true, 0, ',', ' ');
        $(".num-point").number(true, 0, ',', '.');
        $(".num-comma").number(true, 0, ',', ',');
    }

    static formatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "").replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    }

    static removeFormatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "")
    }

    static formatTooltip() {
        $('[data-toggle="tooltip"]').tooltip();
    }
}

class Customer {
    constructor(id, fullName, email, phone, locationDTO, balance, isDeleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationDTO = locationDTO;
        this.balance = balance;
        this.isDeleted = isDeleted;
    }
}

class Whereabouts {
    constructor(id, provinceId, provinceName, districtId, districtName, wardId, wardName, address) {
        this.id = id;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.wardId = wardId;
        this.wardName = wardName;
        this.address = address;
    }
}

class Deposit {
    constructor(id, customerId, transactionAmount, createdAt, createdBy) {
        this.id = id;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}

class Withdraw {
    constructor(id, customerId, transactionAmount, createdAt, createdBy) {
        this.id = id;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}

class Transfer {
    constructor(id, senderId, recipientId, transactionAmount, fee, feeAmount, createdAt, createdBy) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transactionAmount = transactionAmount;
        this.fee = fee;
        this.feeAmount = feeAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}

class Sender extends Customer {
    constructor() {
        super();
    }
}

class Recipient extends Customer {
    constructor() {
        super();
    }
}