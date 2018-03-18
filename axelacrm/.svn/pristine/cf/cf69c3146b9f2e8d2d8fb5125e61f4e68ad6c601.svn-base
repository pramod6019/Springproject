webpackJsonp(["faq.module"],{

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"m-subheader mr-auto\" >\r\n\t\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tFAQ\r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a routerLink=\"/helpdesk/helpdesk-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHelp Desk\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\tFAQ:\r\n\t\t\t\t</span>\r\n\t\t\t</li>\r\n\t\t\t\r\n\t\t</ul>\r\n\t</div>\r\n\t\t\r\n<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tSearch\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"ticketFaqForm\" id=\"m_form_1\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n          \r\n\t\t   <div class='col-md-6'>\r\n\t\t\t <mat-form-field >\r\n\t\t\t    <input matInput placeholder=\"Start Date\" name=\"startDate\" [value]=\"ticketFaq.startDate\" class=\"datepicker\" >\r\n\t\t\t </mat-form-field>\r\n\t\t   </div>\r\n          \r\n           <div class='col-md-6'>\r\n            <mat-form-field>\r\n              <input matInput placeholder=\"End Date\" name=\"endDate\" [value]=\"ticketFaq.endDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n\t\t\t</div>\r\n          \r\n\t\t   <div class=\"col-md-12 btn-row\">\r\n\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Go </button> \r\n\t\t   </div>\t\r\n\t\t \t\r\n\t\t</div>\r\n\t</form>\r\n</div>\r\n\r\n<div *ngIf=\"faqSummaryDetailsData.length!='0'\">\r\n\r\n    <div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tFAQ Summary\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div >\r\n\t\t<br>\r\n\t\t<div class=\"table\">\r\n\t\t<table style='' class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t<thead>         \r\n\t\t\t\t<tr>\r\n\t\t\t\t    <th></th>\r\n\t\t\t\t\t<th>Total</th>\r\n\t\t\t\t\t<th>Active</th>\r\n\t\t\t\t\t<th>Inactive</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\r\n\t\t\t<tr *ngFor=\"let faqSummaryData of faqSummaryDetailsData\">\r\n\t\t\t\t<td>FAQs</td>\r\n\t\t\t\t<td>{{faqSummaryData.Total}}</td>\r\n\t\t\t\t<td>{{faqSummaryData.Active}}</td>\r\n\t\t\t\t<td>{{faqSummaryData.Inactive}}</td>\r\n\t\t\t</tr>\r\n\r\n\t\t  </tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>\r\n\t<div class=\"col-md-12\">\r\n\t\t\t<a style=\"padding-left: 43em;\" href=\"/service/assets-list\">Click heret to List FAQs</a>\r\n\t\t</div>\r\n</div>\r\n\r\n\r\n<!--\r\n<div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tExport\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n <form  (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"ticketFaqForm\">\r\n\t<div class=\"m-portlet__body row\">\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Report Type\" [(ngModel)]=\"ticketFaq.reporttype\" \r\n\t\t\t\t \tformControlName=\"reporttype\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  reporttypes of  reporttypes\" [value]=\"reporttypes.key\">\r\n\t\t\t\t  {{  reporttypes.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Export Format\" [(ngModel)]=\"ticketFaq.exportformat\" \r\n\t\t\t\t \tformControlName=\"exportformat\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  exportformats of  exportformats\" [value]=\"exportformats.key\">\r\n\t\t\t\t  {{  exportformats.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t <br>\r\n\t\t\t <div class=\"col-md-12 btn-row\" style=\"padding-bottom: 1em;\">\r\n\t\t\t\t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Export</button> \r\n\t\t\t </div>\r\n\t\t\t  <br>\r\n\t\t\t</div>\t\r\n\t\t</form>\r\n\t</div>\r\n-->\r\n</div>\r\n\r\n<div *ngIf=\"faqSummaryDetailsData.length=='0'\" >\r\n<span style=\"color:red;padding-left: 41em;\" class=\"errorMsg\" >No Record(s) Found!</span>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FaqComponent; });
/* unused harmony export TicketFaqData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.component.ts");
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









var NUM_REGEX = /[0-9]/;
var WORD_REGEX = /w{5,}/;
var FaqComponent = (function () {
    function FaqComponent(http, route, router) {
        this.http = http;
        this.route = route;
        this.router = router;
        this.flyInOutTrigger = 'in';
        this.faqSummaryDetailsData = [];
        this.listHide = true;
        this.animateList = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.contractId = 0;
        this.ticketFaq = new TicketFaqData();
        this.msg = [];
        this.branches = [];
        this.bootstrapFormValues = [];
        this.reporttypes = [
            { key: '1', name: 'Contract Details' }
        ];
        this.exportformats = [
            { key: '1', name: 'MS Excel' },
            { key: '12', name: 'HTML' }
        ];
    }
    FaqComponent.prototype.ngOnInit = function () {
        this.listHide = true;
        this.animateList = 'out';
        this.populateDropDownData();
        this.getTodaysDate();
        this.populateData();
        console.log(this.faqSummaryDetailsData.length);
        if (this.faqSummaryDetailsData.length > 0) {
            this.listHide = false;
        }
        this.ticketFaqForm = new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormGroup"]({
            'branchsIds': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'exportformat': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'reporttype': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(FaqComponent.prototype, "exportformat", {
        get: function () { return this.ticketFaqForm.get('exportformat'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(FaqComponent.prototype, "reporttype", {
        get: function () { return this.ticketFaqForm.get('reporttype'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(FaqComponent.prototype, "branchsIds", {
        get: function () { return this.ticketFaqForm.get('branchsIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    FaqComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branches = data['populateBranch'];
        });
    };
    FaqComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    FaqComponent.prototype.onSubmit = function () {
        var _this = this;
        this.listHide = false;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.ticketFaq[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
        }
        this.ticketFaq['requestType'] = 'landing';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/faq', JSON.stringify(this.ticketFaq), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.faqSummaryDetailsData = data['populateLandingDetails'];
        });
    };
    FaqComponent.prototype.getTodaysDate = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/currentdate', JSON.stringify({ requestType: 'shortDate' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.ticketFaq.startDate = data['date'];
            _this.ticketFaq.endDate = data['date'];
        });
    };
    FaqComponent.prototype.populateData = function () {
        var _this = this;
        this.ticketFaq['requestType'] = 'landing';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/faq', JSON.stringify(this.ticketFaq), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.faqSummaryDetailsData = data['populateLandingDetails'];
        });
    };
    return FaqComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _a || Object)
], FaqComponent.prototype, "smart", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], FaqComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], FaqComponent.prototype, "list", void 0);
FaqComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/faq/faq.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _e || Object])
], FaqComponent);

var TicketFaqData = (function () {
    function TicketFaqData() {
        this.startDate = '';
        this.endDate = '';
    }
    return TicketFaqData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=faq.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/faq/faq.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FaqModule", function() { return FaqModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__faq_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/faq/faq.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
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
                "component": __WEBPACK_IMPORTED_MODULE_7__faq_component__["a" /* FaqComponent */],
            }
        ]
    }
];
var FaqModule = (function () {
    function FaqModule() {
    }
    return FaqModule;
}());
FaqModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_5__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_6__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_11__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["w" /* MatRadioModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["H" /* MatTabsModule */]
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_7__faq_component__["a" /* FaqComponent */]]
    })
], FaqModule);

//# sourceMappingURL=faq.module.js.map

/***/ })

});
//# sourceMappingURL=faq.module.chunk.js.map