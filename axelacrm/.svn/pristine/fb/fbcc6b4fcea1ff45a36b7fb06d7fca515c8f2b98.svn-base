webpackJsonp(["ticket-list.module"],{

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket/ticket-add.component.html":
/***/ (function(module, exports) {

module.exports = "\t\r\n\t<toast></toast>\r\n\t\r\n\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t{{status}} Ticket \r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/service/helpdesk-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHelp desk\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/ticket\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tTickets\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tTicket List\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t\t{{status}} Ticket\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\r\n\t\t<form class=\"m-form m-form--fit m-form--label-align-right\" (ngSubmit)=\"onSubmit()\"  id=\"m_form_1\" [formGroup]=\"ticketForm\">\r\n\t\t\r\n\t\t  <div class=\"m-portlet__body row\">\t \t \r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Subject\" required [(ngModel)]=\"ticket.ticketSubject\" formControlName=\"ticketSubject\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t\t \r\n\t\t\t\t\t <mat-error *ngIf=\"ticketSubject.hasError('required')\"> Enter Subject </mat-error>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<mat-error *ngIf=\"ticketSubject.hasError('minLength')\"> Enter Atleast 5 char </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field > \r\n\t\t\t\t\t<input matInput class=\"datetimepicker\" placeholder=\"Report Time\" required [value]=\"ticket.ticketReportTime\" name=\"ticketReportTime\">\r\n\t\t \t\t</mat-form-field>\r\n\t\t \t\t<span [innerHTML]=\"reportMsg\"></span>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.configServiceTicketCat=='1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<mat-select placeholder=\"Category\" [(ngModel)]=\"ticket.ticketTicketcatId\" formControlName=\"ticketTicketcatId\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let cat of category\" [value]=\"cat.key\">\r\n\t\t\t\t\t  {{ cat.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\" *ngIf=\"config.configServiceTicketType=='1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t<mat-select placeholder=\"Type\" [(ngModel)]=\"ticket.ticketTickettypeId\" formControlName=\"ticketTickettypeId\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let type of type\" [value]=\"type.key\">\r\n\t\t\t\t\t  {{ type.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\r\n\t\t\t<div class=\"col-md-6\" *ngIf=\"compModulePm=='1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t<mat-select placeholder=\"Project\" [(ngModel)]=\"ticket.ticketPmId\" formControlName=\"ticketPmId\"> \r\n\t\t\t\t\t<mat-option *ngFor=\"let project of project\" [value]=\"project.key\">\r\n\t\t\t\t\t  {{ project.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t  <mat-select placeholder=\"Source\" required [(ngModel)]=\"ticket.ticketTicketsourceId\" formControlName=\"ticketTicketsourceId\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let source of source\" [value]=\"source.key\">\r\n\t\t\t\t\t  {{ source.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t\t\r\n\t\t\t\t   <mat-error *ngIf=\"ticketTicketsourceId.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Source\r\n\t\t\t\t\t</mat-error>\t\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Priority\" required [(ngModel)]=\"ticket.ticketPriorityticketId\" formControlName=\"ticketPriorityticketId\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let priority of priority\" [value]=\"priority.key\">\r\n\t\t\t\t\t  {{ priority.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  \r\n\t\t\t\t  <mat-error *ngIf=\"ticketPriorityticketId.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Priority\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Queue\" required [(ngModel)]=\"ticket.ticketTicketqueueId\" formControlName=\"ticketTicketqueueId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let queue of queue\" [value]=\"queue.key\">\r\n\t\t\t\t\t\t  {{ queue.name }}\r\n\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<mat-error *ngIf=\"ticketTicketqueueId.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Queue\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"!ticketContactId=='' && !ticketContactId=='0'\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Executive\" required [(ngModel)]=\"ticket.ticketEmpId\" formControlName=\"ticketEmpId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let executive of executive\" [value]=\"executive.key\">\r\n\t\t\t\t\t\t  {{ executive.name }}\r\n\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t</mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"ticketContactId=='' && ticketContactId=='0'\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"All Executive\" required [(ngModel)]=\"ticket.ticketEmpId\" formControlName=\"ticketEmpId\" #allexec>\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let allexecutive of allexecutive\" [value]=\"allexecutive.key\">\r\n\t\t\t\t\t\t\t{{ allexecutive.name }}\r\n\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t</mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.configServiceTicketRefno=='1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Reference No.\" required [(ngModel)]=\"ticket.ticketRefno\" formControlName=\"ticketRefno\" \r\n\t\t\t\t\tmaxlength=\"25\">\r\n\t\t\t\t\t<mat-error *ngIf=\"ticketRefno.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Reference No.\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"ticketRefno.hasError('pattern')\">\r\n\t\t\t\t\t\t\tReference No. must be Numeric\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t \r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<textarea matInput placeholder=\"Description\" required [(ngModel)]=\"ticket.ticketDesc\" formControlName=\"ticketDesc\" \r\n\t\t\t\t\tmatAutosizeMinRows=\"2\" >{{ ticket.ticketDesc }}</textarea>\r\n\t\t\t\t\t<mat-error *ngIf=\"ticketDesc.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Description\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>max char 8000</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class='col-md-12 row' *ngIf=\"ticket.ticketEntryBy\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Entry By:</label> \r\n\t\t\t\t\t\t<a href=\"\"> {{ticket.ticketEntryBy}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'> \r\n\t\t\t\t\t\t<label>Entry Date:</label> {{ticket.ticketEntryDate}}\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-12 row' *ngIf=\"ticket.ticketModifiedBy\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Modified By:</label> \r\n\t\t\t\t\t\t<a href=\"\"> {{ticket.ticketModifiedBy}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Modified Date:</label> {{ticket.ticketModifiedDate}}\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t <div class=\"col-md-12 btn-row\" *ngIf=\"this.status == 'Add'\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Add </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t \r\n\t\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.status == 'Update'\"> \r\n\t\t\t\t\t  <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button>\r\n\t\t\t\t\t  <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\t\r\n\t\t\t\t\r\n\t\t\t</div>\t\t\t\t\t\r\n\t\t</form>\r\n\t</div>\t\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket/ticket-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TicketAddComponent; });
/* unused harmony export TicketData */
/* unused harmony export configDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var NUM_REGEX = /[0-9]/;
var WORD_REGEX = /w{5,}/;
var TicketAddComponent = (function () {
    function TicketAddComponent(http, _router, route) {
        var _this = this;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.ticketId = 0;
        this.ticket = new TicketData();
        this.config = new configDetails();
        this.msg = [];
        this.category = [];
        this.type = [];
        this.source = [];
        this.priority = [];
        this.project = [];
        this.executive = [];
        this.allexecutive = [];
        this.queue = [];
        this.compModulePm = sessionStorage.getItem('compModulePm');
        this.bootstrapFormValues = [];
        this.reportMsg = '';
        this.route.queryParams.filter(function (params) { return params.ticketId; }).subscribe(function (params) {
            if (params.ticketId != undefined) {
                _this.ticketId = params.ticketId;
            }
        });
        if (this.ticketId == 0) {
            this.populateDropDownData();
            this.status = "Add";
        }
        else {
            this.populateData();
            this.status = "Update";
        }
    }
    TicketAddComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    TicketAddComponent.prototype.ngOnInit = function () {
        this.ticketForm = new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormGroup"]({
            'ticketSubject': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].minLength(5)]),
            'ticketContactId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'ticketReportTime': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'ticketRefno': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].pattern(NUM_REGEX)]),
            'ticketDesc': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketTicketcatId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'ticketTickettypeId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'ticketTicketsourceId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketPriorityticketId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketTicketqueueId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
            'ticketPmId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'ticketEmpId': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["Validators"].required]),
        });
    };
    Object.defineProperty(TicketAddComponent.prototype, "ticketSubject", {
        get: function () { return this.ticketForm.get('ticketSubject'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketContactId", {
        get: function () { return this.ticketForm.get('ticketContactId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketReportTime", {
        get: function () { return this.ticketForm.get('ticketReportTime'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketRefno", {
        get: function () { return this.ticketForm.get('ticketRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketDesc", {
        get: function () { return this.ticketForm.get('ticketDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketTicketcatId", {
        get: function () { return this.ticketForm.get('ticketTicketcatId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketTickettypeId", {
        get: function () { return this.ticketForm.get('ticketTickettypeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketTicketsourceId", {
        get: function () { return this.ticketForm.get('ticketTicketsourceId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketPriorityticketId", {
        get: function () { return this.ticketForm.get('ticketPriorityticketId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketTicketqueueId", {
        get: function () { return this.ticketForm.get('ticketTicketqueueId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketPmId", {
        get: function () { return this.ticketForm.get('ticketPmId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TicketAddComponent.prototype, "ticketEmpId", {
        get: function () { return this.ticketForm.get('ticketEmpId'); },
        enumerable: true,
        configurable: true
    });
    ;
    TicketAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/populateTicketCategory', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.category = data['populateTicketCategory'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/ticket-type', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.type = data['populateTickettype'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/ticket-source', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.source = data['populateSource'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/ticket-priority', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.priority = data['populateTicketPriority'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/populateproject', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.project = data['populateProject'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/queue', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.queue = data['populateQueue'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/allexecutive', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.allexecutive = data['populateallexecutive'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/executive', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executive = data['populateExecutive'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/serviceconfigdetails', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.config = data['populateConfigTicketDetails'][0];
            console.log(_this.config);
        });
    };
    TicketAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-data', JSON.stringify({ ticketId: this.ticketId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.ticket = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
        });
    };
    TicketAddComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['helpdesk/ticket-list']);
    };
    TicketAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.ticket[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
        }
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            if (this.bootstrapFormValues[i].name == "ticketReportTime") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.reportMsg = "<font class='errorMsg'>Enter Report Time</font>";
                }
                else {
                    this.reportMsg = "";
                }
            }
        }
        if (!this.ticketForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.ticketId == 0) {
                this.ticket['requestType'] = 'add';
            }
            else {
                this.ticket['requestType'] = 'update';
                this.ticket['ticketId'] = this.ticketId + '';
            }
            alert(this.ticketId);
            console.log(this.ticketForm.value);
            this.http.post(sessionStorage.getItem('requestUrl') + "/axelacrm/helpdesk/ticket", JSON.stringify(this.ticket), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                _this.ticketForm.reset();
            }, function (err) {
                console.log(err['error']['desc']);
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    TicketAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.ticket['requestType'] = 'delete';
        this.ticket['ticketId'] = this.ticketId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + "/axelacrm/helpdesk/ticket", JSON.stringify({ requestType: 'delete',
            'ticketId': this.ticketId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
            _this.ticketForm.reset();
        }, function (err) {
            console.log(err['error']['desc']);
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return TicketAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], TicketAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], TicketAddComponent.prototype, "toast", void 0);
TicketAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket/ticket-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"]) === "function" && _d || Object])
], TicketAddComponent);

var TicketData = (function () {
    function TicketData() {
        this.ticketReportTime = '';
    }
    return TicketData;
}());

var configDetails = (function () {
    function configDetails() {
    }
    return configDetails;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=ticket-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket/ticket-dash.component.html":
/***/ (function(module, exports) {

module.exports = "\t\r\n\t\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t\tTicket Dash\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t\t>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/helpdesk-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHelpdesk\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t\t>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"helpdesk/ticket-list\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tList Ticket: \r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\r\n\t<mat-tab-group class=\"bg-white\" (selectedTabChange)=\"onLinkClick($event)\">\r\n\t\t\r\n\t\t<mat-tab label='Ticket'>\r\n\t\t\t<mat-card>\r\n\t\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption \">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tTicket Details\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t<div class=\"m-portlet__body \">\r\n\r\n\t\t\t\t<div class=\"row\">\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<label> Ticket ID :</label> {{ticketId}}\r\n\t\t\t\t\t\t<b><a *ngIf=\"ticketCustomerId == '0' && ticketParentId == '0'\" href=\"javascript:\">New Child Ticket</a></b>\r\n\t\t\t\t\t\t<b><a *ngIf=\"ticketParentId == '0'\" href=\"javascript:\">New Child Ticket</a></b>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\" *ngIf=\"childTickets == ''\">\r\n\t\t\t\t\t\t<label> Child Tickets:</label>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\" *ngIf=\"ticketParentId != '' && ticketParentId != '0'\">\r\n\t\t\t\t\t\t<label>Parent Ticket:&nbsp;</label>\r\n\t\t\t\t\t</div>\t\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<mat-form-field><!-- *ngIf=\"ticketdash.empTicketEdit == '1'; else elseblock\"-->\r\n\t\t\t\t\t\t\t<input matInput  class='datetimepicker' placeholder=\"Report Time\"   name=\"ticketReportTime\" #ticketReportTime (change)=\"securityCheck(ticketReportTime.value, 'ticketReportTime')\">\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"reportmsg\"></span>\r\n\t\t\t\t\t</div>\t\t\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Source\" (change)=\"securityCheck(ticketTicketsourceId.value, 'ticketReportTime')\" [(ngModel)]=\"ticketdash.ticketTicketsourceId\" name=\"ticketTicketsourceId\" #ticketTicketsourceId>\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  src of  source\" [value]=\"src.key\">\r\n\t\t\t\t\t\t\t\t  {{ src.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"sourcemsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\" *ngIf=\"config.configServiceTicketCat=='1'\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Category\" (change)=\"securityCheck(ticketTicketcatId.value, 'ticketTicketcatId')\" #ticketTicketcatId [(ngModel)]=\"ticketdash.ticketTicketcatId\" name=\"ticketTicketcatId\">\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  cat of  category\" [value]=\"cat.key\">\r\n\t\t\t\t\t\t\t\t  {{ cat.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\" *ngIf=\"config.configServiceTicketType=='1'\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Type\"  (change)=\"securityCheck(ticketTickettypeId.value, 'ticketTicketcatId')\" #ticketTickettypeId [(ngModel)]=\"ticketdash.ticketTickettypeId\" name=\"ticketTickettypeId\">\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  type of  type\" [value]=\"type.key\">\r\n\t\t\t\t\t\t\t\t  {{ type.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\" *ngIf=\"config.compModulePm=='1'\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Project\" (change)=\"securityCheck(ticketPmId.value, 'ticketPmId')\" #ticketPmId [(ngModel)]=\"ticketdash.ticketPmId\" name=\"ticketPmId\">\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  project of  project\" [value]=\"project.key\">\r\n\t\t\t\t\t\t\t\t  {{ project.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"projectmsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Status\" (change)=\"securityCheck(ticketTicketstatusId.value, 'ticketTicketstatusId')\" #ticketTicketstatusId [(ngModel)]=\"ticketdash.ticketTicketstatusId\" name=\"ticketTicketstatusId\">\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  status of  status\" [value]=\"status.key\">\r\n\t\t\t\t\t\t\t\t  {{ status.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"statusmsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Priority\" (change)=\"securityCheck(ticketPriorityticketId.value, 'ticketPriorityticketId')\" #ticketPriorityticketId [(ngModel)]=\"ticketdash.ticketPriorityticketId\" name=\"ticketPriorityticketId\">\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  priority of  priority\" [value]=\"priority.key\">\r\n\t\t\t\t\t\t\t\t  {{ priority.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"prioritymsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Queue\" (change)=\"securityCheck(ticketTicketqueueId.value, 'ticketTicketqueueId')\" #ticketTicketqueueId [(ngModel)]=\"ticketdash.ticketTicketqueueId\" name=\"ticketTicketqueueId\">\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  queue of  queue\" [value]=\"queue.key\">\r\n\t\t\t\t\t\t\t\t  {{ queue.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"queuemsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<mat-select placeholder=\"Executive\" (change)=\"securityCheck(ticketEmpId.value, 'ticketEmpId')\" #ticketEmpId [(ngModel)]=\"ticketdash.ticketEmpId\" name=\"ticketEmpId\">\r\n\t\t\t\t\t\t\t\t<mat-option *ngFor=\"let  exe of  executive\" [value]=\"exe.key\">\r\n\t\t\t\t\t\t\t\t  {{ exe.name }}\r\n\t\t\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"exemsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class='col-md-6'> <!-- *ngIf=\"config.configServiceTicketRefno=='1'\"-->\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<input matInput  type=\"text\" placeholder=\"Reference No\" [(ngModel)]=\"ticketdash.ticketRefno\"  maxlength=\"25\" #ticketRefno (change)=\"securityCheck(ticketRefno.value,'ticketRefno');\" name=\"ticketRefno\" [value]=\"ticketdash.ticketRefno\">\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"refmsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class='col-md-6' *ngIf=\"ticketdash.ticketContactId=='0' && ticketdash.ticketContactId==''\"> \r\n\t\t\t\t\t\t<label>Contact</label>\r\n\t\t\t\t\t\t<label>{{config.config_customer_name}}</label>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"col-md-6\" *ngIf=\"ticketdash.ticketJcId=='0'\">\r\n\t\t\t\t\t\t<label> JobCard ID :</label> \r\n\t\t\t\t\t\t<b><a href=\"javascript:\" routerLink=\"\">{{ticketJcId}}</a></b>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class='col-md-6'> \r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<input matInput  type=\"text\" placeholder=\"Subject\" [(ngModel)]=\"ticketdash.ticketSubject\"  maxlength=\"25\" #ticketSubject (change)=\"securityCheck(ticketSubject.value,'ticketSubject')\" [value]=\"ticketdash.ticketSubject\" name=\"ticketSubject\">\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"submsg\"></span>\r\n\t\t\t\t\t\t<b><a href=\"\">KB</a></b>\r\n\t\t\t\t\t\t<b><a href=\"\">FAQ</a></b>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<textarea matInput placeholder=\"Description\" matAuNsizeMinRows=\"2\" maxlength=\"8000\" \t[(ngModel)]=\"ticketdash.ticketDesc\"  name=\"ticketDesc\" #ticketDesc (change)=\"securityCheck(ticketDesc.value, 'ticketDesc')\" [value]=\"ticketdash.ticketDesc\">\t\r\n\t\t\t\t\t\t\t</textarea>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"descmsg\"></span>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t\t<textarea matInput placeholder=\"Solution/ Closing Summary\" matAuNsizeMinRows=\"2\" maxlength=\"8000\" \t[(ngModel)]=\"ticketdash.ticketClosedComments\"  name=\"ticketicketClosedCommentstDesc\" #ticketClosedComments (change)=\"securityCheck(ticketClosedComments.value, 'ticketClosedComments')\" [value]=\"ticketdash.ticketClosedComments\">\t\r\n\t\t\t\t\t\t\t</textarea>\r\n\t\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span [innerHTML]=\"cmtmsg\"></span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"col-md-12\"></div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<label> Due Date :</label> {{ ticketdash.ticketDueTime }}\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t\t<label> Contract ID :</label> \r\n\t\t\t\t\t\t<b>(<a href=\"\">Select Contact</a>)</b>\r\n\t\t\t\t\t\t<b>(<a href=\"\">Delete Contact</a>)</b>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"col-md-4\">\r\n\t\t\t\t\t\t<label> Asset ID :</label> \r\n\t\t\t\t\t\t<b>(<a href=\"\">Select Asset</a>)</b>  \r\n\t\t\t\t\t\t<b>(<a href=\"\">Delete Asset</a>)</b>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t<b><a href=\"javascript:\">Previous Tickets</a></b>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div *ngIf=\"!ticketdash.ticketJcpsfId == '0'\" class=\"col-md-6\">\r\n\t\t\t\t\t\t<label> PSF Followup :</label> \r\n\t\t\t\t\t\t<b><a href=\"\">fgjfg</a></b>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div *ngIf=\"!ticketdash.ticketJcpsfId == '0'\" class=\"col-md-6\">\r\n\t\t\t\t\t\t<label> JC ID :</label> \r\n\t\t\t\t\t\t<b><a href=\"\">fgjhf</a></b>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div *ngIf=\"!ticketdash.ticketJcpsfId == '0'\" class=\"col-md-6\">\r\n\t\t\t\t\t\t<label> PSF Days :</label> \r\n\t\t\t\t\t\t<b>{{ticketdash.psfdaysDaycount}}</b>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div *ngIf=\"!ticketdash.ticketJcpsfId == '0'\" class=\"col-md-6\">\r\n\t\t\t\t\t\t<label> PSF Executive :</label> \r\n\t\t\t\t\t\t<b>{{ticketdash.psfempName}}</b>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div *ngIf=\"!ticketdash.ticketJcpsfId == '0'\" class=\"col-md-6\">\r\n\t\t\t\t\t\t<label>Serial No. :</label> \r\n\t\t\t\t\t\t<b>{{ticketdash.ticketJcSerialno}}</b>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class=\"row\"></div>\r\n\t\t\t\t\t<div class=\"col-md-12 row\" *ngIf=\"ticketdash.ticketEntryId\">\r\n\t\t\t\t\t\t<div class='col-md-6' style=\"padding-left: 0em;\">\r\n\t\t\t\t\t\t\t<label>Entry By:</label> \r\n\t\t\t\t\t\t\t<a href=\"\"> {{ticketdash.ticketEntryBy}}</a>\r\n\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t\t<label>Entry Date:</label> {{ticketdash.ticketEntryDate}}\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\r\n\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\t</mat-card>\t\r\n\t\t</mat-tab>\r\n\t\r\n\t\t<mat-tab label='Follow-up'>\r\n\t\t\t<mat-card style=\"margin-left:25px;\">\r\n\r\n\t\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption \">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tFollow-Up\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"m--align-right\">\r\n\t\t\t\t\t<button type=\"button\" (click)=\"toggleDocument()\"  class=\"btn m-btn--pill m-btn--air btn-outline-primary align-right\">\r\n\t\t\t\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i>  Add Follow-Up\r\n\t\t\t\t\t</button>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t<div class=\"m-portlet__body \">\r\n\t\t\t\t\t\r\n\t\t\t\t\t<table class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t\t\t\t<thead>\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<th style=\"text-align:center\">#</th>\r\n\t\t\t\t\t\t\t\t<th style=\"text-align:center\"> Follow-up Description</th>\r\n\t\t\t\t\t\t\t\t<th style=\"text-align:center\">Next  Follow-up Time</th>\r\n\t\t\t\t\t\t\t\t<th style=\"text-align:center\">Entry By</th>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</thead>\r\n\t\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t\t<tr *ngFor=\"let followupDatas of followupData\">\r\n\t\t\t\t\t\t\t\t<td style=\"text-align:center \">1</td>\r\n\t\t\t\t\t\t\t\t<td>Testing</td>\r\n\t\t\t\t\t\t\t\t<td>{{followupDatas.tickettransNextfollowupTime}}</td>\r\n\t\t\t\t\t\t\t\t<td><a href=\"\">{{followupDatas.entryBy}}</a></td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</tbody>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t</mat-card>\t\r\n\t\t</mat-tab>\r\n\t\t\r\n\t\t<mat-tab label='Client'>\r\n\t\t<mat-card>\r\n       <div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption \">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t{{config.configCustomerName}} \r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\r\n\t\t<div class=\"m--align-right\">\r\n\t\t\t<button type=\"button\" (click)=\"toggleContact()\" class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add New Contact\r\n\t\t\t</button>\r\n\t\t</div>\r\n\t\t\t\t\r\n\t\t<div class=\"m-portlet__body \" style=\"padding-top: 0em;\">\r\n       \r\n\t    <table class=\"table table-bordered table-hover data-filter=#filter\" style=\"width:100%\" align=\"center\">\r\n        <thead class =\"bg-primary\">\r\n\t\t\t <tr>\r\n\t\t\t  <th colspan=\"2\" style='text-align:center'><a href=\"\">XYZZZZZZ</a></th>\r\n\t\t\t</tr>\r\n        </thead>\r\n        <tbody>\r\n        <tr>\r\n\t\t\t<td align=\"right\"  style=\"width: 25%\" class=\"col-md-6\"> Communication: </td>\r\n\t\t\t<td align=\"left\">{{populateCustomerData.customerMobile1}}<br><a href=\"\">{{populateCustomerData.customerEmail1}}</a></td>\r\n\t\t  </tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Address : </td>\r\n\t\t\t<td align=\"left\">{{populateCustomerData.address}}<br>{{populateCustomerData.cityName}}-{{populateCustomerData.customerPin}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Landmark : </td>\r\n\t\t\t<td align=\"left\">Ramdev Hotel</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Sales Consultant : </td>\r\n\t\t\t<td align=\"left\">Administrator</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Active : </td>\r\n\t\t\t<td align=\"left\">Active</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t</tbody>\r\n\t  \t</table>\r\n\t\t</div>\r\n\t\t</div>\r\n\t    \r\n\t\t<div class=\"table\">\r\n\t\t  \t<table class=\"table table-bordered table-hover   data-filter=#filter\">\r\n\t\t\t  \t<thead>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th style=\"text-align: center\">#</th>\r\n\t\t\t\t\t\t<th style=\"text-align: center\">ID</th>\r\n\t\t\t\t\t\t<th style=\"text-align: center\">Contact Person</th>\r\n\t\t\t\t\t\t<th style=\"text-align: center\">Communication</th>\r\n\t\t\t\t\t\t<th style=\"text-align: center\">Address</th>\r\n\t\t\t\t\t\t<th style=\"text-align: center\">Action</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t</thead>\r\n\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t<tr *ngFor=\"let populateContactData of populateContactData\">\r\n\t\t\t\t\t\t\t<td style=\"text-align: center\">1</td>\r\n\t\t\t\t\t\t\t<td style=\"text-align: center\">{{populateContactData.contactId}}</td>\r\n\t\t\t\t\t\t\t<td>{{populateContactData.contactName}}</td>\r\n\t\t\t\t\t\t\t<td>{{populateContactData.contactMobile1}} <br>{{populateContactData.contactEmail1}}</td>\r\n\t\t\t\t\t\t\t<td>{{populateContactData.contactAddress}}</td>\r\n\t\t\t\t\t\t\t<td (click)=\"toggleAnimation()\"><a href=\"javascript::\">Update Contact Person</a></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</tbody>\r\n\t\t\t</table>\r\n\t\t</div>\r\n\t    \r\n\t\t</mat-card>\t\r\n\t\t</mat-tab>\r\n\t\t\r\n\t\t<mat-tab label='Documents'>\r\n\t\t\t<mat-card style=\"margin-left:25px;\">\r\n\r\n\t\t<div> <!--  *ngIf=\"jcDocuments.length!='0'\"-->\r\n\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption \">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tDocument\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"m--align-right\">\r\n\t\t\t<button type=\"button\" (click)=\"toggleDocument()\"  class=\"btn m-btn--pill m-btn--air btn-outline-primary align-right\">\r\n\t\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> New Document\r\n\t\t\t</button>\r\n\t\t\t</div>\r\n\r\n\r\n\t\t\t<div class=\"m-portlet__body \" style=\"padding-top:0em\">\r\n\t\t\t\t\t<table class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t\t\t<thead class=\"bg-primary\">\r\n\t\t\t\t\t\t<tr>  \t \t \t \t\r\n\t\t\t\t\t\t\t<th style=\"text-align: center\">#</th>\r\n\t\t\t\t\t\t\t<th style=\"text-align: center\">Document Details</th>\r\n\t\t\t\t\t\t\t<th style=\"text-align: center\">Action</th>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</thead>\r\n\t\t\t\t\t<tbody>\r\n\t\t\t\t\t  <tr><!--  *ngFor=\"let jcDocuments of jcDocuments\"-->\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td><br></td>\r\n\t\t\t\t\t\t\t<td><a href=\"\">Update Document</a><br><a href=\"\">Update Title</a></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</tbody>\r\n\t\t\t\t  </table>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div ><!--  *ngIf=\"jcDocuments.length=='0'\"-->\r\n\t\t<span style=\"color:red;padding-left:41em;\">No Document(s) Found!</span>\r\n\t\t</div>\t\r\n\t\t\t</mat-card>\r\n\t\t\t</mat-tab>\r\n\t\r\n\t\t<mat-tab label='History'>\r\n\t\t\r\n\t\t<mat-card  style=\"margin-left:25px;\">\r\n\t\t\t\r\n\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption \">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tHistory\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t   <div class=\"m-portlet__body \">\r\n\t\t  \t<table class=\"table table-bordered table-hover   data-filter=#filter\">\r\n\t\t\t  \t<thead>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th>Date</th>\r\n\t\t\t\t\t\t<th>Action By</th>\r\n\t\t\t\t\t\t<th>Type of Action</th>\r\n\t\t\t\t\t\t<th>New Value</th>\r\n\t\t\t\t\t\t<th>Old Value</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t</thead>\r\n\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t<tr *ngFor=\"let ticketHistoryData of ticketHistoryData\" >\r\n\t\t\t\t\t\t\t<td>{{ticketHistoryData.historyDatetime}}</td>\r\n\t\t\t\t\t\t\t<td><a href=\"\">werwert</a></td>\r\n\t\t\t\t\t\t\t<td>ertret</td>\r\n\t\t\t\t\t\t\t<td>{{ticketHistoryData.historyNewvalue}}</td>\r\n\t\t\t\t\t\t\t<td>ertet</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</tbody>\r\n\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t</mat-card>\t\r\n\t\t</mat-tab>\r\n\t\r\n\t\t<mat-tab label='Summary'>\r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t  <div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption \">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tSummary\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\r\n\t\t<div class=\"m-portlet__body \">\r\n\t    <table class=\"table table-bordered table-hover data-filter=#filter\" style=\"width:100%\" align=\"center\">\r\n        <thead class =\"bg-primary\">\r\n\t\t\t <tr>\r\n\t\t\t  <th colspan=\"2\" style='text-align:center'>Ticket Summary</th>\r\n\t\t\t</tr>\r\n        </thead>\r\n        <tbody>\r\n        <tr>\r\n\t\t\t<td align=\"right\"  style=\"width: 25%\" class=\"col-md-6\"> Ticket ID: </td>\r\n\t\t\t<td align=\"left\">46</td>\r\n\t\t  </tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Subject : </td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.ticketSubject}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Description : </td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.ticketDesc}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Status : </td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.ticketStatusName}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Department :</td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.ticketDepartment}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Level :</td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.level}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Priority :</td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.priorityName}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Report Time :</td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.reportTime}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Due Time : </td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.dueTime}}</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Executive : </td>\r\n\t\t\t<td align=\"left\"><a href=\"\">Admin</a></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Type : </td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.typeName}}</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Source : </td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.sourceName}}</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Entry By</td>\r\n\t\t\t<td align=\"left\"><a href=\"\">{{ticketSummaryData.entryBy}}</a></td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">Entry Time</td>\r\n\t\t\t<td align=\"left\">{{ticketSummaryData.entryDate}}</td>\r\n\t\t\t\r\n\t\t</tr>\r\n\t\t</tbody>\r\n\t  \t</table>\r\n\t\t</div>\r\n\t\t</div>\r\n \t\t</mat-card>\r\n\t\t</mat-tab>\r\n\t\t\r\n\t</mat-tab-group>\t\t\r\n\t\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket/ticket-dash.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TicketDashComponent; });
/* unused harmony export followupData */
/* unused harmony export ConfigDetails */
/* unused harmony export ticketHistoryData */
/* unused harmony export ticketDashData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_filter__);
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
var TicketDashComponent = (function () {
    function TicketDashComponent(http, _router, route) {
        this.http = http;
        this._router = _router;
        this.route = route;
        this.tab = 1;
        this.ticketdash = new ticketDashData();
        this.config = new ConfigDetails();
        this.configdetails = [];
        this.source = [];
        this.category = [];
        this.type = [];
        this.status = [];
        this.priority = [];
        this.queue = [];
        this.executive = [];
        this.project = [];
        this.documentData = [];
        this.followupData = [];
        this.ticketHistoryData = [];
        this.ticketSummaryData = [];
        this.populateCustomerData = [];
        this.populateContactData = [];
    }
    TicketDashComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.queryParams.filter(function (params) { return params.ticketId; }).subscribe(function (params) {
            _this.ticketId = params.ticketId;
        });
        this.populateDropDownData();
        if (this.tab != 2) {
            this.populateData();
        }
    };
    TicketDashComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/demo/default/custom/components/forms/widgets/select2.js', function () {
        });
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    TicketDashComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/ticket-source', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.source = data['populateSource'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/category', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.category = data['populateCategory'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/type', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.type = data['populateType'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/status', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.status = data['populateStatus'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/ticket-priority', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.priority = data['populateTicketPriority'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/queue', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.queue = data['populateQueue'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/executive', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executive = data['populateExecutive'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/projectmanager', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.project = data['populateProjectManager'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.config = data['populateconfigdetails'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.config = data['populateconfigdetails'][0];
        });
    };
    TicketDashComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-dash', JSON.stringify({ requestType: 'populateData',
            tab: this.tab,
            ticketId: this.ticketId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.ticketdash = data['populateTicketData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
        });
    };
    TicketDashComponent.prototype.onLinkClick = function (event) {
        var _this = this;
        this.tab = event.index + 1;
        if (this.tab == 2) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-dash', JSON.stringify({ requestType: 'populateData',
                ticketId: this.ticketId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.followupData = data['populateListFollowup'];
            });
        }
        else if (this.tab == 3) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-dash', JSON.stringify({ requestType: 'populateData',
                ticketId: this.ticketId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.populateCustomerData = data['populateCustomer'][0];
                _this.populateContactData = data['populateContact'];
            });
        }
        else if (this.tab == 4) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-dash', JSON.stringify({ requestType: 'populateData',
                ticketId: this.ticketId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.documentData = data['populateDocument'][0];
            });
        }
        else if (this.tab == 5) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-dash', JSON.stringify({ requestType: 'populateData',
                ticketId: this.ticketId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.ticketHistoryData = data['populateHistory'];
            });
        }
        else if (this.tab == 6) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-dash', JSON.stringify({ requestType: 'populateData',
                historyTicketId: this.ticketId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.ticketSummaryData = data['populateData'][0];
            });
        }
    };
    TicketDashComponent.prototype.securityCheck = function (value, name) {
        var _this = this;
        //		alert('00');
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket-dash', JSON.stringify({ requestType: 'update',
            ticketId: this.ticketId,
            tab: this.tab,
            name: name,
            value: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (name == 'ticketReportTime') {
                if (data['msg'].includes("Updated!")) {
                    _this.reportmsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.reportmsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketTicketsourceId') {
                if (data['msg'].includes("Updated!")) {
                    _this.sourcemsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.sourcemsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketTicketstatusId') {
                if (data['msg'].includes("Updated!")) {
                    _this.statusmsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.statusmsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketPriorityticketId') {
                if (data['msg'].includes("Updated!")) {
                    _this.prioritymsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.prioritymsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketTicketqueueId') {
                if (data['msg'].includes("Updated!")) {
                    _this.queuemsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.queuemsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketEmpId') {
                if (data['msg'].includes("Updated!")) {
                    _this.exemsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.exemsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketRefno') {
                if (data['msg'].includes("Updated!")) {
                    _this.refmsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.refmsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketTicketcatId') {
                if (data['msg'].includes("Updated!")) {
                    _this.categorymsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.categorymsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketTickettypeId') {
                if (data['msg'].includes("Updated!")) {
                    _this.typemsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.typemsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketPmId') {
                if (data['msg'].includes("Updated!")) {
                    _this.projectmsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.projectmsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketDesc') {
                if (data['msg'].includes("Updated!")) {
                    _this.descmsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.descmsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketClosedComments') {
                if (data['msg'].includes("Updated!")) {
                    _this.cmtmsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.cmtmsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
            else if (name == 'ticketSubject') {
                if (data['msg'].includes("Updated!")) {
                    _this.submsg = "<font color=green>" + data['msg'] + "</font>";
                }
                else {
                    _this.submsg = "<font color=red>" + data['msg'] + "</font>";
                }
            }
        });
    };
    TicketDashComponent.prototype.toggleDocument = function () {
        this._router.navigate(['portal/document']);
    };
    TicketDashComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['customer/customercontactlist/customercontact-add'], { queryParams: { contactId: '158' } });
    };
    TicketDashComponent.prototype.toggleContact = function () {
        this._router.navigate(['helpdesk/follow-up'], { queryParams: { ticketId: this.ticketId } });
    };
    TicketDashComponent.prototype.toggleFollowup = function () {
        this._router.navigate(['customer/customer-list/contact-add']);
    };
    return TicketDashComponent;
}());
TicketDashComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket/ticket-dash.component.html"),
        //	styleUrls: ["./ticket-dash.component.css"],
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _c || Object])
], TicketDashComponent);

var followupData = (function () {
    function followupData() {
    }
    return followupData;
}());

var ConfigDetails = (function () {
    function ConfigDetails() {
        this.empOpportunityEdit = "0";
        this.configSalesOpprRefno = "0";
        this.compModuleInventory = '1';
    }
    return ConfigDetails;
}());

var ticketHistoryData = (function () {
    function ticketHistoryData() {
    }
    return ticketHistoryData;
}());

var ticketDashData = (function () {
    function ticketDashData() {
    }
    return ticketDashData;
}());

var _a, _b, _c;
//# sourceMappingURL=ticket-dash.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket/ticket-list.component.html":
/***/ (function(module, exports) {

module.exports = " \t<base href = \"/\">\r\n         \r\n<!--\t<toast></toast>-->\r\n\t<router-outlet></router-outlet>\r\n\t\r\n\t<div class=\"m-subheader\">\r\n\t<div class=\"d-flex align-items-center\">\r\n\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tTickets List\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/helpdesk-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHelp desk\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/helpdesk/ticket\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tTickets\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tTickets List:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t<div>\r\n\t\t\r\n\t\t<button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add Ticket\r\n\t\t</button>\r\n\t\t\t\r\n\t\t<!-- (click)=\"smartsearch.showsmart();\"-->\r\n\t\t\t<a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n\t\t\t<div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\">\r\n\t\t\t\t<a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\">\r\n\t\t\t\t\t<i class=\"la la-plus m--hide\"></i>\r\n\t\t\t\t\t<i class=\"la la-ellipsis-h\"></i>\r\n\t\t\t\t</a>\r\n\t\t\t\t<div class=\"m-dropdown__wrapper\">\r\n\t\t\t\t\t<span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n\t\t\t\t\t<div class=\"m-dropdown__inner\">\r\n\t\t\t\t\t\t<div class=\"m-dropdown__body\">\r\n\t\t\t\t\t\t\t<div class=\"m-dropdown__content\">\r\n\t\t\t\t\t\t\t\t<ul class=\"m-nav\">\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__section m-nav__section--first m--hide\">\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__section-text\">\r\n\t\t\t\t\t\t\t\t\t\t\tQuick Actions\r\n\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-share\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tActivity\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-chat-1\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tMessages\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-info\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tFAQ\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-lifebuoy\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tSupport\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\">\r\n\t\t\t\t\t\t\t\t\t\t\tSubmit\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n\t\r\n\t<smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\" ></smart-search>\r\n\t\r\n<div class=\"m-content\">\r\n\t<div class=\"m-portlet__body\">\r\n\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n\r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket/ticket-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TicketListComponent; });
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








var TicketListComponent = (function () {
    function TicketListComponent(_router, http) {
        this._router = _router;
        this.http = http;
        this.flyInOutTrigger = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.ticketId = 0;
    }
    TicketListComponent.prototype.ngOnInit = function () {
        /*this.route.queryParams.filter(params => params.ticketId, params.customerId, params.contactId).subscribe(params=>{
            this.ticketId = params.ticketId;
            this.customerId = params.customerId;
            this.contactId = params.contactId;
        }); */
        this.smart.smartUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/helpdesk/ticket-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/helpdesk/ticket-list";
    };
    TicketListComponent.prototype.ngAfterViewInit = function () { };
    TicketListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    TicketListComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['helpdesk/ticket-list/ticket-add'], { queryParams: { ticketId: this.ticketId } });
    };
    TicketListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    TicketListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'updateticket') {
            this.ticketId = listParam[1];
            this.toggleAnimation();
        }
        if (listParam[0] == 'ticketDash') {
            this.ticketId = listParam[1];
            this._router.navigate(['helpdesk/ticket-list/ticket-dash'], { queryParams: { ticketId: this.ticketId } });
        }
    };
    return TicketListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], TicketListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], TicketListComponent.prototype, "toast", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], TicketListComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _c || Object)
], TicketListComponent.prototype, "smart", void 0);
TicketListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket/ticket-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]]
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _e || Object])
], TicketListComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=ticket-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket/ticket-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TicketListModule", function() { return TicketListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__ticket_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket/ticket-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__ticket_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket/ticket-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__ticket_dash_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket/ticket-dash.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
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
                "component": __WEBPACK_IMPORTED_MODULE_7__ticket_list_component__["a" /* TicketListComponent */]
            }
        ]
    }, {
        "path": "ticket-add",
        "component": __WEBPACK_IMPORTED_MODULE_4__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_8__ticket_add_component__["a" /* TicketAddComponent */]
            }
        ]
    },
    {
        "path": "ticket-dash",
        "component": __WEBPACK_IMPORTED_MODULE_4__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_9__ticket_dash_component__["a" /* TicketDashComponent */],
            }
        ]
    }
];
var TicketListModule = (function () {
    function TicketListModule() {
    }
    return TicketListModule;
}());
TicketListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_5__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_6__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_10__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_12__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_13__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["w" /* MatRadioModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["H" /* MatTabsModule */]
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_7__ticket_list_component__["a" /* TicketListComponent */], __WEBPACK_IMPORTED_MODULE_8__ticket_add_component__["a" /* TicketAddComponent */], __WEBPACK_IMPORTED_MODULE_9__ticket_dash_component__["a" /* TicketDashComponent */]]
    })
], TicketListModule);

//# sourceMappingURL=ticket-list.module.js.map

/***/ })

});
//# sourceMappingURL=ticket-list.module.chunk.js.map