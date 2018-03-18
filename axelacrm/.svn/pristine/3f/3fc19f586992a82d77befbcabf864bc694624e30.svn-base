webpackJsonp(["customer-contact.module"],{

/***/ "../../../../../src/app/theme/pages/customer/customer-contact/customer-contact.component.html":
/***/ (function(module, exports) {

module.exports = "  \r\n  <div class=\"m-subheader mr-auto\">\r\n    <h3 class=\"m-subheader__title m-subheader__title--separator\"> {{configCustomerName}} Contacts </h3>\r\n    <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n      <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n      <li class=\"m-nav__separator\"> > </li>\r\n      <li class=\"m-nav__item\"> <a routerLink=\"/portal/home\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n      <li class=\"m-nav__separator\"> > </li>\r\n      <li class=\"m-nav__item\"> <a routerLink=\"/customer/index\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\">{{configCustomerName}} </span> </a> </li>\r\n       <li class=\"m-nav__separator\"> > </li>\r\n       <li class=\"m-nav__item\"> <a routerLink=\"/customer/customer-landing\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\">{{configCustomerName}} Contacts:  </span> </a> </li>\r\n      </ul>\r\n  </div>\r\n \r\n  <div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t Search\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"customerContactForm\" id=\"m_form_1\">\r\n\t\r\n\t\t<div class=\"m-portlet__body row\">\r\n          \r\n          <div class='col-md-4'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t  <mat-select multiple placeholder=\"Select Branch\" [(ngModel)]=\"customercontact.customerContactBranchIds\" formControlName=\"customerContactBranchIds\">\r\n\t\t\t\t<mat-option *ngFor=\"let  branch of  branchs\" [value]=\" branch.key\"> {{  branch.name }} </mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t  </div>\r\n\t\t\t\r\n           <div class='col-md-4'>\r\n            <mat-form-field >\r\n              <input required matInput placeholder=\"Start Date\" name=\"startDate\" class=\"datepicker\" [value]='customercontact.startDate' >\r\n          \t</mat-form-field>\r\n          \t<span [innerHtml]=\"customerstartdatemsg\"></span>\r\n          </div>\r\n          \r\n           <div class='col-md-4'>\r\n            <mat-form-field>\r\n              <input required matInput placeholder=\"End Date\" name=\"endDate\" class=\"datepicker\" [value]='customercontact.endDate' >\r\n          \t</mat-form-field>\r\n          \t<span [innerHtml]=\"customerenddatemsg\"></span>\r\n          </div>\r\n          <br>\r\n         <div class=\"col-md-12 btn-row\">\r\n            <button class=\"btn btn-primary txt-align\" style=\"margin-top: 18px;\" >Go</button>\r\n          </div>\r\n       </div>\r\n\t</form>\r\n</div>\r\n\r\n<div *ngIf=\"customerContactSummaryData!='0'\">\r\n  <div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tContact Summary\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div >\r\n\t\t<br>\r\n\t\t<div class=\"table\">\r\n\t\t<table style='' class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t<thead>         \r\n\t\t\t\t<tr >\r\n\t\t\t\t\t<th style=\"text-align: center;\" style=\"text-align: center;\">Branch</th>\r\n\t\t\t\t\t<th style=\"text-align: center;\" width=20% style=\"text-align: center;\">Contact Count</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t<tr *ngFor=\"let customerContactSummaryData of customerContactSummaryData\">\r\n\t\t\t\t<td><a href=\"\">{{customerContactSummaryData.branchName}}</a></td>\r\n\t\t\t\t<td style=\"text-align: right;\">{{customerContactSummaryData.contactsCount}}</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr rowspan=\"3\"><td style=\"text-align: right;\" >Total</td>\r\n\t\t\t<td style=\"text-align: right;\" >{{grandTotal}}</td>\r\n\t\t\t</tr>\r\n\t\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>\r\n\t<div class=\"col-md-12\">\r\n\t\t\t<a style=\"padding-left: 43em;\" href=\"/service/assets-list\">Click heret to List Contacts</a>\r\n\t\t</div>\r\n</div>\r\n\t\r\n\r\n  <div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tExport\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n <form  (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"customerContactForm\">\r\n\t<div class=\"m-portlet__body row\">\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Report Type\" [(ngModel)]=\"customercontact.reporttype\" \r\n\t\t\t\t \tformControlName=\"reporttype\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  reporttypes of  reporttypes\" [value]=\"reporttypes.key\">\r\n\t\t\t\t  {{  reporttypes.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Export Format\" [(ngModel)]=\"customercontact.exportformat\" \r\n\t\t\t\t \tformControlName=\"exportformat\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  exportformats of  exportformats\" [value]=\"exportformats.key\">\r\n\t\t\t\t  {{  exportformats.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t <br>\r\n\t\t\t <div class=\"col-md-12 btn-row\" style=\"padding-bottom: 1em;\">\r\n\t\t\t\t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Export</button> \r\n\t\t\t </div>\r\n\t\t\t  <br>\r\n\t\t\t</div>\t\r\n\t\t</form>\r\n\t</div>\r\n\r\n</div>\r\n\r\n<div *ngIf=\"customerContactSummaryData.length=='0'\">\r\n<span style=\"color:red;padding-left:41em\">No Record(s) Found!</span>\r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/customer/customer-contact/customer-contact.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CustomerContactComponent; });
/* unused harmony export CustomerContactData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__amcharts_amcharts3_angular__ = __webpack_require__("../../../../@amcharts/amcharts3-angular/es2015/index.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};














var CustomerContactComponent = (function () {
    function CustomerContactComponent(_script, http, AmCharts) {
        this._script = _script;
        this.http = http;
        this.AmCharts = AmCharts;
        this.listHide = true;
        this.addHide = false;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.configCustomerName = '';
        this.bootstrapFormValues = [];
        this.bootstrapMsg = '';
        this.msg = [];
        this.branchs = [];
        this.customerContactSummaryData = [];
        this.reporttypes = [
            { key: '1', name: 'Contract Details' }
        ];
        this.exportformats = [
            { key: '1', name: 'MS Excel' },
            { key: '12', name: 'HTML' }
        ];
        this.pageIndex = 1;
        this.customercontact = new CustomerContactData();
        this.configCustomerName = sessionStorage.getItem('configCustomerName');
    }
    CustomerContactComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.listHide = true;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.getTodaysDate();
        this.customerContactForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'customerContactBranchIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'exportformat': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'reporttype': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branchs = data['populateBranch'];
        });
    };
    Object.defineProperty(CustomerContactComponent.prototype, "customerContactBranchIds", {
        get: function () { return this.customerContactForm.get('customerContactBranchIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(CustomerContactComponent.prototype, "exportformat", {
        get: function () { return this.customerContactForm.get('exportformat'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(CustomerContactComponent.prototype, "reporttype", {
        get: function () { return this.customerContactForm.get('reporttype'); },
        enumerable: true,
        configurable: true
    });
    ;
    CustomerContactComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    CustomerContactComponent.prototype.getTodaysDate = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/currentdate', JSON.stringify({ requestType: 'shortDate' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.customercontact.startDate = data['date'];
            _this.customercontact.endDate = data['date'];
        });
    };
    CustomerContactComponent.prototype.onSubmit = function () {
        var _this = this;
        //	  this.listHide = false;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.customercontact[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
            if (this.bootstrapFormValues[i].name == "CustomerContactStartDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter Start Date!<br>';
                    this.customerstartdatemsg = "<font class='select2ErrorMsg'>Enter Start Date</font>";
                }
                else {
                    this.bootstrapMsg = '';
                    this.customerstartdatemsg = "";
                }
            }
            if (this.bootstrapFormValues[i].name == "CustomerContactEndDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter End Date!<br>';
                    this.customerenddatemsg = "<font class='errorMsg'>Enter End Date</font>";
                }
                else {
                    this.bootstrapMsg = '';
                    this.customerenddatemsg = "";
                }
            }
        }
        console.log("uyty1===" + this.bootstrapMsg);
        if (this.bootstrapMsg != '') {
            console.log("invalid");
            this.msg[0] = 'Error';
            this.msg[1] = 'Enter the Mandatory Fields';
            //				this.toast.showtoast(this.msg);
            //				this.bootstrapMsg='';
        }
        console.log("uyty22===" + this.bootstrapMsg);
        console.log(this.customerContactForm.invalid);
        if (this.bootstrapMsg == '') {
            this.customercontact['requestType'] = 'landing';
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer/contact', JSON.stringify(this.customercontact), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.customerContactSummaryData = data['contactSummary'];
                _this.grandTotal = data['total'];
                console.log(_this.customerContactSummaryData.length);
                if (_this.customerContactSummaryData.length != 0) {
                    _this.listHide = false;
                }
            });
        }
    };
    return CustomerContactComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_12__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_12__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_12__list_list_component__["a" /* ListComponent */]) === "function" && _a || Object)
], CustomerContactComponent.prototype, "list", void 0);
CustomerContactComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/customer/customer-contact/customer-contact.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_13__amcharts_amcharts3_angular__["b" /* AmChartsService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__amcharts_amcharts3_angular__["b" /* AmChartsService */]) === "function" && _d || Object])
], CustomerContactComponent);

var CustomerContactData = (function () {
    function CustomerContactData() {
        this.startDate = '';
        this.endDate = '';
    }
    return CustomerContactData;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=customer-contact.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/customer/customer-contact/customer-contact.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CustomerContactModule", function() { return CustomerContactModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__customer_contact_component__ = __webpack_require__("../../../../../src/app/theme/pages/customer/customer-contact/customer-contact.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__amcharts_amcharts3_angular__ = __webpack_require__("../../../../@amcharts/amcharts3-angular/es2015/index.js");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__customer_contact_component__["a" /* CustomerContactComponent */]
            }
        ]
    }
];
var CustomerContactModule = (function () {
    function CustomerContactModule() {
    }
    return CustomerContactModule;
}());
CustomerContactModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__amcharts_amcharts3_angular__["a" /* AmChartsModule */],
            __WEBPACK_IMPORTED_MODULE_10__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__customer_contact_component__["a" /* CustomerContactComponent */]
        ],
    })
], CustomerContactModule);

//# sourceMappingURL=customer-contact.module.js.map

/***/ })

});
//# sourceMappingURL=customer-contact.module.chunk.js.map