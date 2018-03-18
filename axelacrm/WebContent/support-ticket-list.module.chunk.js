webpackJsonp(["support-ticket-list.module"],{

/***/ "../../../../../src/app/theme/pages/portal/support-ticket-list/support-ticket-list.component.html":
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\r\n\t  \r\n<div class=\"m-subheader\">\r\n    <div class=\"d-flex align-items-center\">\r\n      <div class=\"mr-auto\">\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\"> Support Ticket List </h3>\r\n        <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n          <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/home\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/manager\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Portal </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/support-ticket-list\" class=\"m-nav__link\"><span class=\"m-nav__link-text\"> Support Ticket List:</span></a> </li>\r\n        </ul>\r\n      </div>\r\n      <div>  \r\n       \r\n         \r\n\t\t<button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add Ticket\r\n\t\t</button>\r\n         \r\n        <a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n        <div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\"> <a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\"> <i class=\"la la-plus m--hide\"></i> <i class=\"la la-ellipsis-h\"></i> </a>\r\n          <div class=\"m-dropdown__wrapper\"> <span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n            <div class=\"m-dropdown__inner\">\r\n              <div class=\"m-dropdown__body\">\r\n                <div class=\"m-dropdown__content\">\r\n                  <ul class=\"m-nav\">\r\n                    <li class=\"m-nav__section m-nav__section--first m--hide\"> <span class=\"m-nav__section-text\"> Quick Actions </span> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-share\"></i> <span class=\"m-nav__link-text\"> Activity </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-chat-1\"></i> <span class=\"m-nav__link-text\"> Messages </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-info\"></i> <span class=\"m-nav__link-text\"> FAQ </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-lifebuoy\"></i> <span class=\"m-nav__link-text\"> Support </span> </a> </li>\r\n                    <li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n                    <li class=\"m-nav__item\"> <a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\"> Submit </a> </li>\r\n                  </ul>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  \r\n  \r\n<smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\"></smart-search>\r\n  \r\n  \r\n<div class=\"m-content\">\r\n\t<div class=\"m-portlet__body\">\r\n\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>  "

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/support-ticket-list/support-ticket-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupportTicketListComponent; });
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








var SupportTicketListComponent = (function () {
    function SupportTicketListComponent(_router, http) {
        this._router = _router;
        this.http = http;
        this.flyInOutTrigger = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.ticketId = 0;
    }
    SupportTicketListComponent.prototype.ngOnInit = function () {
        this.smart.smartUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/portal/support-ticket-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/portal/support-ticket-list";
    };
    SupportTicketListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    SupportTicketListComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/support-ticket-list/ticket-add'], { queryParams: { ticketId: this.ticketId } });
    };
    SupportTicketListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    SupportTicketListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'updateticket') {
            this.ticketId = listParam[1];
            this.toggleAnimation();
        }
    };
    return SupportTicketListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], SupportTicketListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], SupportTicketListComponent.prototype, "toast", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], SupportTicketListComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _c || Object)
], SupportTicketListComponent.prototype, "smart", void 0);
SupportTicketListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/support-ticket-list/support-ticket-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]]
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _e || Object])
], SupportTicketListComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=support-ticket-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/support-ticket-list/support-ticket-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SupportTicketListModule", function() { return SupportTicketListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__support_ticket_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/support-ticket-list/support-ticket-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ticket_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/support-ticket-list/ticket-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__support_ticket_list_component__["a" /* SupportTicketListComponent */]
            }
        ]
    }, {
        "path": "ticket-add",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__ticket_add_component__["a" /* SupportTicketAddComponent */],
            }
        ]
    }
];
var SupportTicketListModule = (function () {
    function SupportTicketListModule() {
    }
    return SupportTicketListModule;
}());
SupportTicketListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_8__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_10__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_12__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__support_ticket_list_component__["a" /* SupportTicketListComponent */], __WEBPACK_IMPORTED_MODULE_4__ticket_add_component__["a" /* SupportTicketAddComponent */]],
    })
], SupportTicketListModule);

//# sourceMappingURL=support-ticket-list.module.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/support-ticket-list/ticket-add.component.html":
/***/ (function(module, exports) {

module.exports = "\t<toast></toast>\r\n\t\r\n\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t{{status}} Ticket\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tPortal\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/support-ticket-list\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tSupport Ticket List: \r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t{{status}} Ticket\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n    \t\t\r\n    \t<form class=\"m-form m-form--fit m-form--label-align-right\" (ngSubmit)=\"onSubmit()\"  id=\"m_form_1\" [formGroup]=\"ticketForm\">\r\n\t\t\t \r\n\t\t<!--<div class=\"m-portlet__body row\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Name*\" [(ngModel)]=\"branch.branchName\" formControlName=\"branchName\"\r\n\t\t\t\t\t maxlength=\"255\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchName.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter name\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchName.hasError('minLength')\">\r\n\t\t\t\t\t\t\tEnter  Minimum of 3 characters\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>(Enter Minimum of 3 characters)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Name on Invoice*\" [(ngModel)]=\"branch.branchInvoiceName\" formControlName=\"branchInvoiceName\" maxlength=\"50\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchInvoiceName.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Name on Invoice\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Code*\" [(ngModel)]=\"branch.branchCode\" formControlName=\"branchCode\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchCode.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter code\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>(Only alphanumeric characters) are allowed!</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"GST*\" [(ngModel)]=\"branch.branchGst\" formControlName=\"branchGst\"\r\n\t\t\t\t\t maxlength=\"15\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchGst.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter GST\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchGst.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid GST\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>Example:22AAAAA0000A1Z5</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"VAT*\" [(ngModel)]=\"branch.branchVat\" formControlName=\"branchVat\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchVat.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter VAT\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"CST*\" [(ngModel)]=\"branch.branchCst\" formControlName=\"branchCst\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchCst.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter CST\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"type*\" [(ngModel)]=\"branch.branchBranchtypeId\" \r\n\t\t\t\t\t\tformControlName=\"branchBranchtypeId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let branch of branchtype\" [value]=\"branch.key\">{{ branch.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<mat-error *ngIf=\"branchBranchtypeId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect type\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t  \t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"Franchisee*\" [(ngModel)]=\"branch.branchFranchiseeId\" \r\n\t\t\t\t\t\tformControlName=\"branchFranchiseeId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let franch of franchisee\" [value]=\"franch.key\">{{ franch.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<mat-error *ngIf=\"branchFranchiseeId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Franchisee\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t  \t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"Rate Class*\" [(ngModel)]=\"branch.branchRateclassId\" \r\n\t\t\t\t\t\tformControlName=\"branchRateclassId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let rate of rateclass\" [value]=\"rate.key\">{{ rate.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t<mat-error *ngIf=\"branchRateclassId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Rate Class\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"branchId!='0'\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Inventory Location*\" [(ngModel)]=\"branch.branchLocationId\" formControlName=\"branchLocationId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let loc of location\" [value]=\"loc.key\" selected>{{ loc.name}}</mat-option>\r\n\t\t\t\t\t</mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Mobile 1*\" [(ngModel)]=\"branch.branchMobile1\" formControlName=\"branchMobile1\"\r\n\t\t\t\t\t maxlength=\"13\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchMobile1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Mobile 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchMobile1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Mobile 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-9999999999)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Mobile 2\" [(ngModel)]=\"branch.branchMobile2\" formControlName=\"branchMobile2\"\r\n\t\t\t\t\t maxlength=\"13\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchMobile1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Mobile 2\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-9999999999)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Phone 1*\" [(ngModel)]=\"branch.branchPhone1\" formControlName=\"branchPhone1\"\r\n\t\t\t\t\t maxlength=\"14\" >\r\n\t\t\t\t\t <mat-error *ngIf=\"branchPhone1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Phone 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPhone1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter Phone 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-80-33333333)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Phone 2\" [(ngModel)]=\"branch.branchPhone2\" formControlName=\"branchPhone2\"\r\n\t\t\t\t\t maxlength=\"14\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchPhone2.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter Phone 2\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-80-33333333)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Email 1*\" [(ngModel)]=\"branch.branchEmail1\" formControlName=\"branchEmail1\"\r\n\t\t\t\t\t maxlength=\"100\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchEmail1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Email 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchEmail1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Email 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Email 2\" [(ngModel)]=\"branch.branchEmail2\" formControlName=\"branchEmail2\"\r\n\t\t\t\t\t maxlength=\"100\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchEmail2.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Email 2\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<textarea matInput placeholder=\"Address*\" [(ngModel)]=\"branch.branchAdd\" formControlName=\"branchAdd\" \r\n\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\"></textarea>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchAdd.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Address\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>max char 255</mat-hint>\r\n\t\t\t\t</mat-form-field >\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\" style=\"padding: 1em;\">\r\n\t\t\t\t<select class='form-control txt-align' id='city' name='branchCityId'></select>\r\n\t\t\t\t<span [innerHtml]=\"branchCityIdMsg\"></span>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Pin/Zip*\" [(ngModel)]=\"branch.branchPin\" formControlName=\"branchPin\"\r\n\t\t\t\t\t maxlength=\"6\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPin.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Pin/Zip\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPin.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Pin/Zip\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"PAN\" [(ngModel)]=\"branch.branchPanNo\" formControlName=\"branchPanNo\"\r\n\t\t\t\t\t maxlength=\"10\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPanNo.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid PAN No.\r\n\t\t\t\t\t</mat-error> \r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"TAN\" [(ngModel)]=\"branch.branchTanNo\" formControlName=\"branchTanNo\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"TIN\" [(ngModel)]=\"branch.branchTinNo\" formControlName=\"branchTinNo\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Service Tax No.\" [(ngModel)]=\"branch.branchServiceTaxNo\" formControlName=\"branchServiceTaxNo\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<span class=\"row\" style=\"padding: 0 1em;\" *ngIf=\"compModulePos=='1'\">\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Bill Header:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchBillHeader\" formControlName=\"branchBillHeader\" \r\n\t\t\t\t\t\t\t maxlength=\"1000\">{{ branch.branchBillHeader }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Bill Footer:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchBillFooter\" formControlName=\"branchBillFooter\" \r\n\t\t\t\t\t\t\t maxlength=\"1000\">{{ branch.branchBillFooter }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t</span>\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<div class=\"row\" style=\"padding: 0 1em;\" *ngIf=\"compModuleInvoice=='1'\">\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Quote Description:</label>\r\n\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchQuoteDesc\" formControlName=\"branchQuoteDesc\">\r\n\t\t\t\t\t\t{{ branch.branchQuoteDesc }}\r\n\t\t\t\t\t</textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t\t<label>Quote Terms & Conditions:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchQuoteTerms\" \r\n\t\t\t\t\t\tformControlName=\"branchQuoteTerms\" maxlength=\"1000\">{{ branch.branchQuoteTerms }}</textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Sales Order Description:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchSoDesc\" \r\n\t\t\t\t\t\tformControlName=\"branchSoDesc\"  maxlength=\"1000\"> {{ branch.branchSoDesc }} </textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Invoice Description:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchInvoiceDesc\" \r\n\t\t\t\t\t\t\tformControlName=\"branchInvoiceDesc\" maxlength=\"1000\">{{ branch.branchInvoiceDesc }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Invoice Terms & Conditions:</label>\r\n\t\t\t\t\t\t<textarea  cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchInvoiceTerms\" \r\n\t\t\t\t\t\tformControlName=\"branchInvoiceTerms\" matAutosizeMinRows=\"2\" maxlength=\"1000\">{{ branch.branchInvoiceTerms }}</textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Receipt Description:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchReceiptDesc\" \r\n\t\t\t\t\t\tformControlName=\"branchReceiptDesc\" maxlength=\"1000\">{{ branch.branchReceiptDesc }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\" *ngIf=\"compModuleSales=='1'\">\r\n\t\t\t\t\t\t<label>Sales Order Terms & Conditions:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchSoTerms\" \r\n\t\t\t\t\t\t formControlName=\"branchSoTerms\" maxlength=\"1000\">{{ branch.branchSoTerms }}</textarea> \r\n\t\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t<label>Active:</label>\r\n\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(branch.branchActive)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:branch, objKey:'branchActive'})\" formControlName=\"branchActive\"></mat-checkbox>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<textarea matInput placeholder=\"Notes\" [(ngModel)]=\"branch.branchNotes\" formControlName=\"branchNotes\" \r\n\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"5000\"></textarea>\r\n\t\t\t\t</mat-form-field >\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-12 row' *ngIf=\"this.branch.branchEntryBy\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Entry By:</label> <a href=\"\">{{branch.branchEntryBy}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Entry Date:</label> {{branch.branchEntryDate}}\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-12 row' *ngIf=\"this.branch.branchModifiedBy\"  style=\"margin-top: 2em;\">\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<label>Modified By:</label> <a href=\"\">{{branch.branchModifiedBy}}</a>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<label>Modified Date:</label> {{branch.branchModifiedDate}}\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.branchId=='0'\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Add </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" id=\"reset\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t \r\n\t\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.branchId!='0'\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button> \r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\"  type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\t\r\n\t</div>-->\t\t\r\n\t\r\n\t\t</form>\r\n\t</div>\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/support-ticket-list/ticket-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupportTicketAddComponent; });
/* unused harmony export ticketData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_startWith__ = __webpack_require__("../../../../rxjs/add/operator/startWith.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_startWith___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_startWith__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_observable_merge__ = __webpack_require__("../../../../rxjs/add/observable/merge.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_observable_merge___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_observable_merge__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_debounceTime__ = __webpack_require__("../../../../rxjs/add/operator/debounceTime.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_debounceTime___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_debounceTime__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_distinctUntilChanged__ = __webpack_require__("../../../../rxjs/add/operator/distinctUntilChanged.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_distinctUntilChanged___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_distinctUntilChanged__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_observable_fromEvent__ = __webpack_require__("../../../../rxjs/add/observable/fromEvent.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_observable_fromEvent___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_rxjs_add_observable_fromEvent__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_rxjs_add_operator_filter__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__services_validate_service__ = __webpack_require__("../../../../../src/app/_services/validate.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};















var SupportTicketAddComponent = (function () {
    function SupportTicketAddComponent(http, router, route, globalValid) {
        var _this = this;
        this.http = http;
        this.router = router;
        this.route = route;
        this.globalValid = globalValid;
        this.flyInOutTrigger = 'in';
        this.ticket = new ticketData();
        this.ticketId = 0;
        this.msg = [];
        this.bootstrapFormValues = [];
        this.queue = [];
        this.type = [];
        this.Module = [];
        this.route.queryParams.filter(function (params) { return params.ticketId; }).subscribe(function (params) {
            if (params.ticketId != undefined) {
                _this.ticketId = params.ticketId;
            }
        });
        if (this.ticketId == 0) {
            this.status = "Add";
            //			this.populateDropDownData();
        }
        else {
            this.status = "Update";
            this.populateData();
        }
    }
    SupportTicketAddComponent.prototype.ngAfterViewInit = function () {
    };
    SupportTicketAddComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['portal/support-ticket-list']);
    };
    SupportTicketAddComponent.prototype.ngOnInit = function () {
        this.ticketForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({});
    };
    //	  get branchName(){ return this.branchForm.get('branchName')};
    //	  get branchInvoiceName(){ return this.branchForm.get('branchInvoiceName')};
    //	  get branchCode(){ return this.branchForm.get('branchCode')};
    SupportTicketAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/queue', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.queue = data['populateQueue'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/type', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.type = data['populateType'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/module', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.Module = data['populateModule'];
        });
    };
    SupportTicketAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/ticket-data', JSON.stringify({ ticketId: this.ticketId,
            requestType: "update" }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.ticket = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
        });
    };
    SupportTicketAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.ticket[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
        }
        console.log(this.ticket);
        if (!this.ticketForm.invalid) {
            console.log("valid");
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.ticketId == 0) {
                this.ticket['requestType'] = 'add';
            }
            else {
                this.ticket['requestType'] = 'update';
                this.ticket['ticketId'] = this.ticketId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/ticket', JSON.stringify(this.ticket), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.ticketForm.reset();
                    _this.toggleAnimation();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    SupportTicketAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.ticket['requestType'] = 'delete';
        this.ticket['empId'] = this.ticketId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/ticket', JSON.stringify({ requestType: 'delete',
            'ticketId': this.ticketId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                _this.ticketForm.reset();
                _this.toggleAnimation();
            }
        }, function (err) {
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return SupportTicketAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], SupportTicketAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], SupportTicketAddComponent.prototype, "toast", void 0);
SupportTicketAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/support-ticket-list/ticket-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_14__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__services_validate_service__["a" /* GlobalValidate */]) === "function" && _e || Object])
], SupportTicketAddComponent);

var ticketData = (function () {
    function ticketData() {
    }
    return ticketData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=ticket-add.component.js.map

/***/ })

});
//# sourceMappingURL=support-ticket-list.module.chunk.js.map