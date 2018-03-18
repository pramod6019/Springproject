webpackJsonp(["faq-list.module"],{

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq-add.component.html":
/***/ (function(module, exports) {

module.exports = "<toast></toast>\r\n\t\t\r\n\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t{{status}} FAQ \r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/help-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHelp Desk \r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/faq\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tFAQ\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tFAQ List:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t\t{{status}} FAQ \r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t<form  (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"faqForm\">\r\n\t\t\t\t<div class=\"m-portlet__body row\">\r\n\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Queue*\" (change)=\"populateCat(faq.faqserviceTicketqueueId)\" [(ngModel)]=\"faq.faqserviceTicketqueueId\" \r\n\t\t\t\t\t\t\tformControlName=\"faqserviceTicketqueueId\">\r\n\t\t\t\t\t\t\t<mat-option *ngFor=\"let queue of queue\" [value]=\"queue.key\">\r\n\t\t\t\t\t\t\t  {{ queue.name }}\r\n\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t  </mat-select>\r\n\t\t\t\t\t\t\t <mat-error *ngIf=\"faqserviceTicketqueueId.hasError('required')\">\r\n\t\t\t\t\t\t\t\t\t select Queue\r\n\t\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t</div>\r\n\r\n\r\n\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"Category*\" [(ngModel)]=\"faq.ticketfaqFaqserviceId\" formControlName=\"ticketfaqFaqserviceId\">\r\n\t\t\t\t\t\t\t<mat-option *ngFor=\"let cat of category\" [value]=\"cat.key\">\r\n\t\t\t\t\t\t\t  {{ cat.name }}\r\n\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t  </mat-select>\r\n\t\t\t\t\t  <mat-error *ngIf=\"ticketfaqFaqserviceId.hasError('required')\">\r\n\t\t\t\t\t\t\t\t\t Select category\r\n\t\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<mat-form-field> \r\n\t\t\t\t\t\t\t<textarea matInput placeholder=\"Question*\" [(ngModel)]=\"faq.ticketfaqQuestion\" formControlName=\"ticketfaqQuestion\"\r\n\t\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\">{{ faq.ticketfaqQuestion }}</textarea>\r\n\t\t\t\t\t\t\t<mat-error *ngIf=\"ticketfaqQuestion.hasError('required')\">\r\n\t\t\t\t\t\t\t\t\t Enter Question\r\n\t\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t\t\t<mat-hint>Max char 255</mat-hint>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t</div>\r\n\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<textarea matInput placeholder=\"Answer*\" [(ngModel)]=\"faq.ticketfaqAnswer\" formControlName=\"ticketfaqAnswer\" \r\n\t\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\">{{ faq.ticketfaqAnswer }}</textarea>\r\n\t\t\t\t\t\t\t<mat-error *ngIf=\"ticketfaqAnswer.hasError('required')\">\r\n\t\t\t\t\t\t\t\t\t Enter Answer\r\n\t\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t\t\t<mat-hint>Max char 8000</mat-hint>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<label>Active :</label>\r\n\t\t\t\t\t\t<mat-checkbox id=\"active\" name=\"check_ticketfaqActive\" [ngModel]=\"globalValid.getCheckValue(faq.ticketfaqActive)\"(change)=\"globalValid.fetchCheckValue({event:$event, obj:faq, objKey:'ticketfaqActive'})\" formControlName=\"ticketfaqActive\"></mat-checkbox>\r\n\t\t\t\t\t</div>\t\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-12 row' *ngIf=\"faq.ticketfaqEntryBy\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Entry By:</label> \r\n\t\t\t\t\t\t<a href=\"\"> {{faq.ticketfaqEntryBy}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Entry Date:</label> {{faq.ticketfaqEntryDate}}\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-12 row' *ngIf=\"faq.ticketfaqModifiedBy\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Modified By:</label> \r\n\t\t\t\t\t\t<a href=\"\"> {{faq.ticketfaqModifiedBy}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Modified Date:</label> {{faq.ticketfaqModifiedDate}}\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.status=='Add'\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Add </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t \r\n\t\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.status=='Update'\"> \r\n\t\t\t\t\t  <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button>\r\n\t\t\t\t\t  <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button>  \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t</div>\r\n\t\t</form>\r\n\t </div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FAQAddComponent; });
/* unused harmony export FAQData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__services_validate_service__ = __webpack_require__("../../../../../src/app/_services/validate.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var FAQAddComponent = (function () {
    function FAQAddComponent(http, _router, route, globalValid) {
        var _this = this;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.globalValid = globalValid;
        this.flyInOutTrigger = 'in';
        this.ticketfaqId = 0;
        this.QueueId = 0;
        this.faq = new FAQData();
        this.msg = [];
        this.queue = [];
        this.category = [];
        this.bootstrapFormValues = [];
        this.route.queryParams.filter(function (params) { return params.ticketfaqId; }).subscribe(function (params) {
            if (params.ticketfaqId != undefined) {
                _this.ticketfaqId = params.ticketfaqId;
            }
        });
        if (this.ticketfaqId == 0) {
            this.populateDropDownData();
            this.status = "Add";
        }
        else {
            this.populateData();
            this.status = "Update";
        }
    }
    FAQAddComponent.prototype.ngOnInit = function () {
        this.faqForm = new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormGroup"]({
            'faqserviceTicketqueueId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketfaqFaqserviceId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketfaqQuestion': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketfaqAnswer': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketfaqActive': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(FAQAddComponent.prototype, "faqserviceTicketqueueId", {
        get: function () { return this.faqForm.get('faqserviceTicketqueueId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(FAQAddComponent.prototype, "ticketfaqFaqserviceId", {
        get: function () { return this.faqForm.get('ticketfaqFaqserviceId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(FAQAddComponent.prototype, "ticketfaqQuestion", {
        get: function () { return this.faqForm.get('ticketfaqQuestion'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(FAQAddComponent.prototype, "ticketfaqAnswer", {
        get: function () { return this.faqForm.get('ticketfaqAnswer'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(FAQAddComponent.prototype, "ticketfaqActive", {
        get: function () { return this.faqForm.get('ticketfaqActive'); },
        enumerable: true,
        configurable: true
    });
    ;
    FAQAddComponent.prototype.populateCat = function (QueueId) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/faq-category', { 'ticketqueueId': QueueId }, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.category = data['populateFaqCategory'];
        });
    };
    FAQAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/queue', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.queue = data['populateQueue'];
        });
        this.populateCat(this.QueueId);
    };
    FAQAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/faq-data', JSON.stringify({ ticketfaqId: this.ticketfaqId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.faq = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
        });
    };
    FAQAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.faq['requestType'] = 'delete';
        this.faq['ticketfaqId'] = this.ticketfaqId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/faq', JSON.stringify({ requestType: 'delete',
            'ticketfaqId': this.ticketfaqId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (data['successmsg'].includes('Successfully')) {
                _this.msg[0] = 'success';
                _this.msg[1] = data['successmsg'];
            }
            else {
                _this.msg[0] = 'Error';
                _this.msg[1] = data['errormsg'];
            }
            _this.toast.showtoast(_this.msg);
            _this.toggleAnimation();
            _this.faqForm.reset();
        }, function (err) {
            console.log(err['error']['desc']);
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    FAQAddComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['helpdesk/faq-list']);
    };
    FAQAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.faq[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
            if (this.bootstrapFormValues[i].name.includes('check_')) {
                this.faq[this.bootstrapFormValues[i].name.split('_')[1]] = "1";
            }
            else {
                this.faq[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
            }
        }
        console.log(this.faq);
        if (!this.faqForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.ticketfaqId == 0) {
                this.faq['requestType'] = 'add';
            }
            else {
                this.faq['requestType'] = 'update';
                this.faq['ticketfaqId'] = this.ticketfaqId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/faq', JSON.stringify(this.faq), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.faqForm.reset();
                    _this.toggleAnimation();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    return FAQAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], FAQAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], FAQAddComponent.prototype, "toast", void 0);
FAQAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/faq/faq-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_8__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_8__services_validate_service__["a" /* GlobalValidate */]) === "function" && _e || Object])
], FAQAddComponent);

var FAQData = (function () {
    function FAQData() {
        this.ticketfaqActive = '1';
    }
    return FAQData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=faq-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq-list.component.html":
/***/ (function(module, exports) {

module.exports = "\r\n    <base href = \"/\">\r\n      \r\n    <router-outlet></router-outlet>\r\n\t\t\r\n\t<div class=\"m-subheader\">\r\n\t<div class=\"d-flex align-items-center\">\r\n\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tFAQ List\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/helpdesk-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHelp Desk\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/faq\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tFAQ\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tFAQ List:\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t<div>\r\n\t\t<button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-outline-primary\">\r\n\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add FAQ\r\n\t\t</button>\r\n\t\t\t<a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n\t\t\t<div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\">\r\n\t\t\t\t<a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\">\r\n\t\t\t\t\t<i class=\"la la-plus m--hide\"></i>\r\n\t\t\t\t\t<i class=\"la la-ellipsis-h\"></i>\r\n\t\t\t\t</a>\r\n\t\t\t\t<div class=\"m-dropdown__wrapper\">\r\n\t\t\t\t\t<span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n\t\t\t\t\t<div class=\"m-dropdown__inner\">\r\n\t\t\t\t\t\t<div class=\"m-dropdown__body\">\r\n\t\t\t\t\t\t\t<div class=\"m-dropdown__content\">\r\n\t\t\t\t\t\t\t\t<ul class=\"m-nav\">\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__section m-nav__section--first m--hide\">\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__section-text\">\r\n\t\t\t\t\t\t\t\t\t\t\tQuick Actions\r\n\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-share\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tActivity\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-chat-1\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tMessages\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-info\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tFAQ\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-lifebuoy\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tSupport\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\">\r\n\t\t\t\t\t\t\t\t\t\t\tSubmit\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n\r\n\t<smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\" ></smart-search>\r\n\r\n\t<div class=\"m-content\">\r\n\t\r\n\t<div class=\"m-portlet__body\">\r\n\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t<div class=\"m--align-right\">\r\n\t\t\t</div>\r\n<!--\r\n\t\t\t\t<div class=\"m--align-right\">\r\n\t\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"btn btn-primary  m-btn m-btn--custom m-btn--icon m-btn--air m-btn--pill\">\r\n\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t<i class=\"la flaticon-user-add \"></i>\r\n\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\tNew FAQ\r\n\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<div class=\"m-separator m-separator--dashed d-xl-none\"></div>\r\n\t\t\t\t\t</div>\r\n-->\r\n\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FAQListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var FAQListComponent = (function () {
    function FAQListComponent(http, _router) {
        this.http = http;
        this._router = _router;
        this.flyInOutTrigger = 'in';
        this.ticketfaqId = 0;
        this.smartHide = true;
        this.animateSmart = 'out';
    }
    FAQListComponent.prototype.ngOnInit = function () {
        this.smart.smartUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/helpdesk/faq-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/helpdesk/faq-list";
    };
    FAQListComponent.prototype.ngAfterViewInit = function () {
    };
    FAQListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    FAQListComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['helpdesk/faq-list/faq-add'], { queryParams: { ticketfaqId: this.ticketfaqId } });
    };
    FAQListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    FAQListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'Update FAQ') {
            this.ticketfaqId = listParam[1];
            this.toggleAnimation();
        }
        if (listParam[0] == 'listDocuments') {
            this.ticketfaqId = listParam[1];
            this._router.navigate(['/helpdesk/ticket-faq-doc-list']);
        }
    };
    return FAQListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], FAQListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], FAQListComponent.prototype, "toast", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], FAQListComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _c || Object)
], FAQListComponent.prototype, "smart", void 0);
FAQListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/faq/faq-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]],
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _e || Object])
], FAQListComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=faq-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FAQListModule", function() { return FAQListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__faq_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/faq/faq-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__faq_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/faq/faq-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};













var routes = [
    {
        "path": "",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_3__faq_list_component__["a" /* FAQListComponent */]
            }
        ]
    }, {
        "path": "faq-add",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__faq_add_component__["a" /* FAQAddComponent */]
            }
        ]
    }
];
var FAQListModule = (function () {
    function FAQListModule() {
    }
    return FAQListModule;
}());
FAQListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_8__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_9__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_12__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__faq_list_component__["a" /* FAQListComponent */], __WEBPACK_IMPORTED_MODULE_4__faq_add_component__["a" /* FAQAddComponent */]]
    })
], FAQListModule);

//# sourceMappingURL=faq-list.module.js.map

/***/ })

});
//# sourceMappingURL=faq-list.module.chunk.js.map