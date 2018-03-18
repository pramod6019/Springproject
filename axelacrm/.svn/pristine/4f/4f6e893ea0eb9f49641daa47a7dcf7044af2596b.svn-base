webpackJsonp(["configure-customer.module"],{

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/configure-customer/configure-customer.component.html":
/***/ (function(module, exports) {

module.exports = " \t<toast></toast>\r\n\t\t\r\n\t<div class=\"m-subheader\">\t\t\t\r\n\t\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tConfigure Customer\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/home\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBusiness Manager\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/configure-customer\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tConfigure Customer:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tConfigure Customer\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\t\r\n\t\t\r\n\t\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"configcustomerForm\" id=\"m_form_1\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n\t\t\r\n\t\t<div class='col-md-4'></div>\r\n\t\t<div class='col-md-4' style=\"padding: .5em;\"> Enable Source of Enquiry:  \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configCustomer.configCustomerSoe)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configCustomer, objKey:'configCustomerSoe'})\" formControlName=\"configCustomerSoe\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-3'></div>\r\n        \r\n        <div class='col-md-4'></div>\r\n\t\t <div class='col-md-4' style=\"padding: .5em;\"> Enable Source of Business:  \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configCustomer.configCustomerSob)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configCustomer, objKey:'configCustomerSob'})\" formControlName=\"configCustomerSob\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-3'></div>\r\n        \r\n        <div class='col-md-4'></div>\r\n        <div class='col-md-4' style=\"padding: .5em;\"> Address is Mandatory:  \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configCustomer.configCustomerAddress)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configCustomer, objKey:'configCustomerAddress'})\" formControlName=\"configCustomerAddress\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-3'></div>\r\n        \r\n        <div class='col-md-4'></div>\r\n\t\t <div class='col-md-4' style=\"padding: .5em;\"> Allow Duplicate Names:  \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configCustomer.configCustomerDupNames)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configCustomer, objKey:'configCustomerDupNames'})\" formControlName=\"configCustomerDupNames\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-3'></div>\r\n        \r\n        <div class='col-md-4'></div>\r\n\t\t <div class=\"col-md-6\">\r\n\t\t\t <mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Customer Name\" [(ngModel)]=\"configCustomer.configCustomerName\" formControlName=\"configCustomerName\" required>\r\n\t\t\t\t<mat-error *ngIf=\"configCustomerName.hasError('required')\">\r\n\t\t\t\t\t\tEnter Admin Email-Id\r\n\t\t\t\t</mat-error>\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class=\"col-md-12  btn-row\" > \r\n\t\t\t \t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n\t</form>\t\r\n\r\n\t</div>\r\n\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/configure-customer/configure-customer.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ConfigCustomerComponent; });
/* unused harmony export ConfigCustomerData */
/* unused harmony export ConfigDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__services_validate_service__ = __webpack_require__("../../../../../src/app/_services/validate.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var ConfigCustomerComponent = (function () {
    function ConfigCustomerComponent(http, _router, globalValid) {
        this.http = http;
        this._router = _router;
        this.globalValid = globalValid;
        this.flyInOutTrigger = 'in';
        this.configCustomer = new ConfigCustomerData();
        this.configId = '1';
        this.status = "";
        this.msg = [];
        this.bootstrapFromValues = [];
        this.status = "Update";
        this.populateData();
    }
    ConfigCustomerComponent.prototype.ngOnInit = function () {
        this.configcustomerForm = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormGroup"]({
            'configCustomerSoe': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configCustomerSob': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configCustomerAddress': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configCustomerDupNames': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configCustomerName': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(ConfigCustomerComponent.prototype, "configCustomerSoe", {
        get: function () { return this.configcustomerForm.get('configCustomerSoe'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigCustomerComponent.prototype, "configCustomerSob", {
        get: function () { return this.configcustomerForm.get('configCustomerSob'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigCustomerComponent.prototype, "configCustomerAddress", {
        get: function () { return this.configcustomerForm.get('configCustomerAddress'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigCustomerComponent.prototype, "configCustomerDupNames", {
        get: function () { return this.configcustomerForm.get('configCustomerDupNames'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigCustomerComponent.prototype, "configCustomerName", {
        get: function () { return this.configcustomerForm.get('configCustomerName'); },
        enumerable: true,
        configurable: true
    });
    ;
    ConfigCustomerComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configCustomer = data['populateconfigdetails'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        });
    };
    ConfigCustomerComponent.prototype.ngAfterViewInit = function () { };
    ConfigCustomerComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/manager']);
    };
    ConfigCustomerComponent.prototype.getCheckValues = function (temp) {
        return this.globalValid.getCheckValue(temp);
    };
    ConfigCustomerComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.configCustomer[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        if (!this.configcustomerForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.configCustomer['requestType'] = 'update';
            this.configCustomer['configId'] = this.configId + '';
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/config-customer', JSON.stringify(this.configCustomer), { headers: headers, withCredentials: true }).subscribe(function (data) {
                if (data['successmsg'] == undefined) {
                    _this.msg[0] = 'Error';
                    _this.msg[1] = data['errormsg'];
                }
                else {
                    if (data['successmsg'].includes('Successfully')) {
                        _this.msg[0] = 'success';
                        _this.msg[1] = data['successmsg'];
                    }
                }
                _this.toast.showtoast(_this.msg);
                if (_this.msg[0] != 'Error') {
                    _this.configcustomerForm.reset();
                    _this.toggleAnimation();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
        console.log(this.configCustomer);
    };
    return ConfigCustomerComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ConfigCustomerComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ConfigCustomerComponent.prototype, "toast", void 0);
ConfigCustomerComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/manager/customer/configure-customer/configure-customer.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_4__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */]) === "function" && _d || Object])
], ConfigCustomerComponent);

var ConfigCustomerData = (function () {
    function ConfigCustomerData() {
    }
    return ConfigCustomerData;
}());

var ConfigDetails = (function () {
    function ConfigDetails() {
    }
    return ConfigDetails;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=configure-customer.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/configure-customer/configure-customer.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ConfigCustomerModule", function() { return ConfigCustomerModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configure_customer_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/manager/customer/configure-customer/configure-customer.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var routes = [
    {
        "path": "",
        "component": __WEBPACK_IMPORTED_MODULE_4__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_5__configure_customer_component__["a" /* ConfigCustomerComponent */]
            }
        ]
    }
];
var ConfigCustomerModule = (function () {
    function ConfigCustomerModule() {
    }
    return ConfigCustomerModule;
}());
ConfigCustomerModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["l" /* MatExpansionModule */], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_module__["a" /* ToastModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["z" /* MatSidenavModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_5__configure_customer_component__["a" /* ConfigCustomerComponent */]]
    })
], ConfigCustomerModule);

//# sourceMappingURL=configure-customer.module.js.map

/***/ })

});
//# sourceMappingURL=configure-customer.module.chunk.js.map