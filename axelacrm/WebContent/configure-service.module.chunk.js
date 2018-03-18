webpackJsonp(["configure-service.module"],{

/***/ "../../../../../src/app/theme/pages/portal/manager/service/configure-service/configure-service.component.html":
/***/ (function(module, exports) {

module.exports = " \t<toast></toast>\r\n\t\t\r\n\t<div class=\"m-subheader\">\t\t\t\r\n\t\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tConfigure Service\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/home\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBusiness Manager\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/configure-service\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tConfigure Service:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row theme\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tConfigure Service\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<form class=\"m-form m-form--fit m-form--label-align-right\" (ngSubmit)=\"onSubmit()\"  id=\"m_form_1\" [formGroup]=\"configserviceForm\">\r\n\t\t\t \r\n\t\t\t<div class=\"m-portlet__body row\">\r\n\t\t\t\t\r\n\t\t<div class='col-md-4' style=\"padding-top: 34px\"> Enable Ticket:  \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configserviceTicket)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configserviceTicket'})\" formControlName=\"configserviceTicket\"  ></mat-checkbox>\r\n        </div>\r\n\t\t <div class='col-md-4' style=\"padding-top: 34px\"> Enable Contract: \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configServiceContract)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configServiceContract'})\" formControlName=\"configServiceContract\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-4' style=\"padding-top: 34px\"> Enable Ticket Category: \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configserviceTicketCat)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configserviceTicketCat'})\" formControlName=\"configserviceTicketCat\"  ></mat-checkbox>\r\n        </div>\r\n\t\t <div class='col-md-4' style=\"padding-top: 34px\"> Enable Ticket Type:\r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configServiceJobcardType)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configServiceJobcardType'})\" formControlName=\"configServiceJobcardType\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-4' style=\"padding-top: 34px\"> Enable Job Card Category:\r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configServiceJobcardCat)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configServiceJobcardCat'})\" formControlName=\"configServiceJobcardCat\"  ></mat-checkbox>\r\n        </div>\r\n\t\t <div class='col-md-4' style=\"padding-top: 34px\"> Enable Job Card Type:\r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configServiceJobcardRefno)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configServiceJobcardRefno'})\" formControlName=\"configServiceJobcardRefno\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-4' style=\"padding-top: 34px\"> Contract Ref No.:\r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configServiceContractRefno)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configServiceContractRefno'})\" formControlName=\"configServiceContractRefno\"  ></mat-checkbox>\r\n        </div>\r\n\t\t <div class='col-md-4' style=\"padding-top: 34px\"> Jobcard Ref No.:\r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configserviceJobcardRefno)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configserviceJobcardRefno'})\" formControlName=\"configserviceJobcardRefno\"  ></mat-checkbox>\r\n        </div>\r\n        <div class='col-md-4' style=\"padding-top: 34px\"> Ticket Ref No.: \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configserviceTicketRefno)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configserviceTicketRefno'})\" formControlName=\"configserviceTicketRefno\"  ></mat-checkbox>\r\n        </div>\r\n\t\t <div class='col-md-4' style=\"padding-top: 34px\"> Serial No. Mandatory: \r\n            <mat-checkbox  [ngModel]=\"globalValid.getCheckValue(configservice.configServiceJobcardSerialnoMandatory)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configServiceJobcardSerialnoMandatory'})\" formControlName=\"configServiceJobcardSerialnoMandatory\"  ></mat-checkbox>\r\n        </div>\r\n         <div class=\" table col-md-12\" *ngIf=\"this.psfdaysId!='0'\">\r\n\t\t<label> Automated Tasks:&nbsp;</label>\r\n\t\t\r\n\t\t<table class=\"table table-bordered table-hover data-filter=#filter\" style=\"width:150%\" >\r\n\t\t\t<thead class =\"bg-primary\" style='text-align:center'>\r\n\t\t\t <tr>\r\n\t\t\t\t<th>Task Type </th>\r\n\t\t\t\t<th>Send Email</th>\r\n\t\t\t\t<th>Format Email</th>\r\n\t\t\t\t<th>Send SMS</th>\r\n\t\t\t\t<th>Format SMS</th>\r\n\t\t\t </tr>\r\n\t\t\t</thead>\r\n\t\t  <tbody>\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"left\">New Job Card:</td>\r\n\t\t\t\t<td align=\"center\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configJcNewEmailEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configServiceJobcardSerialnoMandatory'})\" formControlName=\"configJcNewEmailEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configJcNewSmsEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configJcNewSmsEnable'})\" formControlName=\"configJcNewSmsEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a href=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"left\">Ready Job Card:</td>\r\n\t\t\t\t<td align=\"center\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configJcReadyEmailEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configJcReadyEmailEnable'})\" formControlName=\"configJcReadyEmailEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configJcReadySmsEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configJcReadySmsEnable'})\" formControlName=\"configJcReadySmsEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"left\">Delivered Job Card:</td>\r\n\t\t\t\t<td align=\"center\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configJcDeliveredEmailEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configJcDeliveredEmailEnable'})\" formControlName=\"configJcDeliveredEmailEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configJcDeliveredSmsEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configJcDeliveredSmsEnable'})\" formControlName=\"configJcDeliveredSmsEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket Contact:</td>\r\n\t\t\t\t<td align=\"center\" rowspan=\"2\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configticketNewEmailEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configticketNewEmailEnable'})\" formControlName=\"configticketNewEmailEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"service-format.jsp?email=yes&status=Ticket&opt=config_ticket_new_email_format\">Format</a></td>\r\n\t\t\t\t<td align=\"center\" rowspan=\"2\">\r\n             \t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configticketNewSMSEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configticketNewSMSEnable'})\" formControlName=\"configticketNewSMSEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket Executive:</td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket Follow Up:</td>\r\n\t\t\t\t<td align=\"center\" rowspan=\"2\">\r\n\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configticketFollowupEmailEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configticketFollowupEmailEnable'})\" formControlName=\"configticketFollowupEmailEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\" rowspan=\"2\">\r\n\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configticketFollowupSMSEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configticketFollowupSMSEnable'})\" formControlName=\"configticketFollowupSMSEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket Follow Up Executive:</td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket Closed:</td>\r\n\t\t\t\t<td align=\"center\" rowspan=\"2\">\r\n\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configticketClosedEmailEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configticketClosedEmailEnable'})\" formControlName=\"configticketClosedEmailEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\" rowspan=\"2\">\r\n\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(configservice.configticketClosedSMSEnable)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configservice, objKey:'configticketClosedSMSEnable'})\" formControlName=\"configticketClosedSMSEnable\"></mat-checkbox></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket Closed Executive:</td>\r\n\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket CRM:</td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket PBF:</td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket PSF:</td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Ticket JCPSF:</td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"><a\r\n\t\t\t\t\thref=\"\">Format</a></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t\t<td align=\"center\"></td>\r\n\t\t\t</tr>\r\n\t\t</tbody>\r\n\t</table>\r\n\t\t\r\n\t\t  </div>\r\n\t\t\r\n\t\t<div class=\"col-md-12  btn-row\" > \r\n\t\t\t \t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n\t\t</form>\t\r\n\t</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/service/configure-service/configure-service.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ConfigServiceComponent; });
/* unused harmony export ConfigServiceData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
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









var EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var MOBILE_REGEX = /^[91]{2}-\d{10}$/;
var PIN_REGEX = /^\d{6}$/;
var NUM_REGAX = /[0-9]/;
var ConfigServiceComponent = (function () {
    function ConfigServiceComponent(globalValid, http, _router, route) {
        this.globalValid = globalValid;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.configservice = new ConfigServiceData();
        this.status = "";
        this.msg = [];
        this.bootstrapFromValues = [];
        this.status = "Update";
        this.populateData();
    }
    ConfigServiceComponent.prototype.ngOnInit = function () {
        this.configserviceForm = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormGroup"]({
            'configserviceTicket': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configServiceContract': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configserviceTicketCat': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configServiceJobcardType': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configServiceJobcardCat': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configServiceJobcardRefno': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configServiceContractRefno': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configserviceTicketRefno': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configserviceJobcardRefno': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configServiceJobcardSerialnoMandatory': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configticketNewEmailEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configticketNewSMSEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configticketFollowupEmailEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configticketFollowupSMSEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configticketClosedEmailEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configticketClosedSMSEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configJcNewEmailEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configJcNewSmsEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configJcReadyEmailEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configJcReadySmsEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configJcDeliveredEmailEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'configJcDeliveredSmsEnable': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('')
        });
    };
    Object.defineProperty(ConfigServiceComponent.prototype, "configserviceTicket", {
        get: function () { return this.configserviceForm.get('configserviceTicket'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configServiceContract", {
        get: function () { return this.configserviceForm.get('configServiceContract'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configserviceTicketCat", {
        get: function () { return this.configserviceForm.get('configserviceTicketCat'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configServiceJobcardType", {
        get: function () { return this.configserviceForm.get('configServiceJobcardType'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configServiceJobcardCat", {
        get: function () { return this.configserviceForm.get('configserviceJobcardCat'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configServiceJobcardRefno", {
        get: function () { return this.configserviceForm.get('configServiceJobcardRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configServiceContractRefno", {
        get: function () { return this.configserviceForm.get('configServiceContractRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configserviceTicketRefno", {
        get: function () { return this.configserviceForm.get('configserviceTicketRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configserviceJobcardRefno", {
        get: function () { return this.configserviceForm.get('configserviceJobcardRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configServiceJobcardSerialnoMandatory", {
        get: function () { return this.configserviceForm.get('configServiceJobcardSerialnoMandatory'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configticketNewEmailEnable", {
        get: function () { return this.configserviceForm.get('configticketNewEmailEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configticketNewSMSEnable", {
        get: function () { return this.configserviceForm.get('configticketNewSMSEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configticketFollowupEmailEnable", {
        get: function () { return this.configserviceForm.get('configticketFollowupEmailEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configticketFollowupSMSEnable", {
        get: function () { return this.configserviceForm.get('configticketFollowupSMSEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configticketClosedEmailEnable", {
        get: function () { return this.configserviceForm.get('configticketClosedEmailEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configticketClosedSMSEnable", {
        get: function () { return this.configserviceForm.get('configticketClosedSMSEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configJcNewEmailEnable", {
        get: function () { return this.configserviceForm.get('configJcNewEmailEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configJcNewSmsEnable", {
        get: function () { return this.configserviceForm.get('configJcNewSmsEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configJcReadyEmailEnable", {
        get: function () { return this.configserviceForm.get('configJcReadyEmailEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configJcReadySmsEnable", {
        get: function () { return this.configserviceForm.get('configJcReadySmsEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configJcDeliveredEmailEnable", {
        get: function () { return this.configserviceForm.get('configJcDeliveredEmailEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigServiceComponent.prototype, "configJcDeliveredSmsEnable", {
        get: function () { return this.configserviceForm.get('configJcDeliveredSmsEnable'); },
        enumerable: true,
        configurable: true
    });
    ;
    ConfigServiceComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/service/config-service-data ', JSON.stringify({ configId: '1' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configservice = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        });
    };
    ConfigServiceComponent.prototype.ngAfterViewInit = function () { };
    ConfigServiceComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/manager']);
    };
    ConfigServiceComponent.prototype.getCheckValues = function (temp) {
        return this.globalValid.getCheckValue(temp);
    };
    ConfigServiceComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.configservice[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        if (!this.configserviceForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.configservice['requestType'] = 'update';
            this.configservice['configId'] = '1';
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/service/config-service', JSON.stringify(this.configservice), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.configserviceForm.reset();
                    _this.toggleAnimation();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
        console.log(this.configservice);
    };
    return ConfigServiceComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ConfigServiceComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ConfigServiceComponent.prototype, "toast", void 0);
ConfigServiceComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/manager/service/configure-service/configure-service.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_4__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"]) === "function" && _e || Object])
], ConfigServiceComponent);

var ConfigServiceData = (function () {
    function ConfigServiceData() {
    }
    return ConfigServiceData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=configure-service.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/service/configure-service/configure-service.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ConfigServiceModule", function() { return ConfigServiceModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configure_service_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/manager/service/configure-service/configure-service.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_5__configure_service_component__["a" /* ConfigServiceComponent */]
            }
        ]
    }
];
var ConfigServiceModule = (function () {
    function ConfigServiceModule() {
    }
    return ConfigServiceModule;
}());
ConfigServiceModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["l" /* MatExpansionModule */], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_module__["a" /* ToastModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["z" /* MatSidenavModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_5__configure_service_component__["a" /* ConfigServiceComponent */]]
    })
], ConfigServiceModule);

//# sourceMappingURL=configure-service.module.js.map

/***/ })

});
//# sourceMappingURL=configure-service.module.chunk.js.map