webpackJsonp(["executive-email.module"],{

/***/ "../../../../../src/app/theme/pages/portal/email/executive-email/executive-email.component.html":
/***/ (function(module, exports) {

module.exports = "\t<toast></toast>\r\n\t\r\n    <div class=\"m-subheader mr-auto\" >\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tUpdate Email Settings\r\n\t\t\t</h3>\r\n         <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/email\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tEmail\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/email-list\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tEmail List:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\t\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tUpdate Email Settings\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\"\tid=\"m_form_1\"  [formGroup]=\"emailForm\">\r\n\t\t\t<div class=\"m-portlet__body row\">\r\n\t\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t\t<input matInput placeholder=\"Email Server*\" [(ngModel)]=\"email.empEmailServer\" formControlName=\"empEmailServer\" maxlength=\"50\">\r\n\t\t\t\t\t\t <mat-error *ngIf=\"empEmailServer.hasError('required')\">\r\n\t\t\t\t\t\t\t\tEnter Email server\r\n\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t\t<input matInput placeholder=\"Email Username*\" [(ngModel)]=\"email.empEmailUsername\" formControlName=\"empEmailUsername\" maxlength=\"50\">\r\n\t\t\t\t\t\t <mat-error *ngIf=\"empEmailUsername.hasError('required')\">\r\n\t\t\t\t\t\t\t\tEnter Email Username\r\n\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t\t<input matInput placeholder=\"Email Password*\" [(ngModel)]=\"email.empEmailPassword\" formControlName=\"empEmailPassword\" maxlength=\"50\">\r\n\t\t\t\t\t\t <mat-error *ngIf=\"empEmailPassword.hasError('required')\">\r\n\t\t\t\t\t\t\t\tEnter Email Password\r\n\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t\t<input matInput placeholder=\"Port*\" [(ngModel)]=\"email.empEmailPort\" formControlName=\"empEmailPort\" maxlength=\"50\">\r\n\t\t\t\t\t\t <mat-error *ngIf=\"empEmailPort.hasError('required')\">\r\n\t\t\t\t\t\t\t\tEnter Port\r\n\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>SSL:</label>\r\n\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(email.empEmailSsl)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:email, objKey:'empEmailSsl'})\" formControlName=\"empEmailSsl\"></mat-checkbox>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"col-md-12 btn-row\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" routerLink=\"/portal/executive-list\" id=\"reset\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t</div>\r\n\t\t</form>\t\r\n\t</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/email/executive-email/executive-email.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ExecutiveEmailComponent; });
/* unused harmony export emailData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__services_validate_service__ = __webpack_require__("../../../../../src/app/_services/validate.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_filter__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var EMAIL_REGEX = /^[a-zA-Z0-9.!#$%'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var ExecutiveEmailComponent = (function () {
    function ExecutiveEmailComponent(http, router, route, globalValid) {
        var _this = this;
        this.http = http;
        this.router = router;
        this.route = route;
        this.globalValid = globalValid;
        this.flyInOutTrigger = 'in';
        this.email = new emailData();
        this.emailId = 0;
        this.msg = [];
        this.bootstrapFormValues = [];
        this.route.queryParams.filter(function (params) { return params.empId; }).subscribe(function (params) {
            if (params.empId != undefined) {
                _this.emailId = params.empId;
            }
        });
        if (this.emailId != 0) {
            this.status = "Update";
            this.populateData();
        }
    }
    ExecutiveEmailComponent.prototype.ngAfterViewInit = function () {
    };
    ExecutiveEmailComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['portal/email-list']);
    };
    ExecutiveEmailComponent.prototype.getCheckValues = function (temp) {
        return this.globalValid.getCheckValue(temp);
    };
    ExecutiveEmailComponent.prototype.ngOnInit = function () {
        this.emailForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'empEmailServer': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empEmailUsername': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empEmailPassword': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empEmailPort': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empEmailSsl': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
        });
    };
    Object.defineProperty(ExecutiveEmailComponent.prototype, "empEmailServer", {
        get: function () { return this.emailForm.get('empEmailServer'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveEmailComponent.prototype, "empEmailUsername", {
        get: function () { return this.emailForm.get('empEmailUsername'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveEmailComponent.prototype, "empEmailPassword", {
        get: function () { return this.emailForm.get('empEmailPassword'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveEmailComponent.prototype, "empEmailPort", {
        get: function () { return this.emailForm.get('empEmailPort'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveEmailComponent.prototype, "empEmailSsl", {
        get: function () { return this.emailForm.get('empEmailSsl'); },
        enumerable: true,
        configurable: true
    });
    ;
    ExecutiveEmailComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/email-data', JSON.stringify({ emailId: this.emailId,
            requestType: "update" }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.email = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            //this.populateDropDownData();
        });
    };
    ExecutiveEmailComponent.prototype.onSubmit = function () {
        var _this = this;
        console.log(this.email);
        if (!this.emailForm.invalid) {
            console.log("valid");
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.emailId == 0) {
                this.email['requestType'] = 'add';
            }
            else {
                this.email['requestType'] = 'update';
                this.email['emailId'] = this.emailId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/email', JSON.stringify(this.email), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.emailForm.reset();
                    _this.toggleAnimation();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    return ExecutiveEmailComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ExecutiveEmailComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ExecutiveEmailComponent.prototype, "toast", void 0);
ExecutiveEmailComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/email/executive-email/executive-email.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */]) === "function" && _e || Object])
], ExecutiveEmailComponent);

var emailData = (function () {
    function emailData() {
    }
    return emailData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=executive-email.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/email/executive-email/executive-email.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ExecutiveEmailModule", function() { return ExecutiveEmailModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__executive_email_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/email/executive-email/executive-email.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var routes = [
    {
        "path": "",
        "component": __WEBPACK_IMPORTED_MODULE_5__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_3__executive_email_component__["a" /* ExecutiveEmailComponent */]
            }
        ]
    }
];
var ExecutiveEmailModule = (function () {
    function ExecutiveEmailModule() {
    }
    return ExecutiveEmailModule;
}());
ExecutiveEmailModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["w" /* MatRadioModule */],
            __WEBPACK_IMPORTED_MODULE_10__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["h" /* MatDatepickerModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [__WEBPACK_IMPORTED_MODULE_3__executive_email_component__["a" /* ExecutiveEmailComponent */]],
    })
], ExecutiveEmailModule);

//# sourceMappingURL=executive-email.module.js.map

/***/ })

});
//# sourceMappingURL=executive-email.module.chunk.js.map