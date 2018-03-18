webpackJsonp(["asset.module"],{

/***/ "../../../../../src/app/theme/pages/service/assets/asset.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"m-subheader mr-auto\" >\r\n\t\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tAssets\r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"/service/service-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tService\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"/service/asset\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tAssets:\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t\r\n\t\t</ul>\r\n\t</div>\r\n\t\t\t\t\r\n<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tSearch\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"assetForm\" id=\"m_form_1\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n          \r\n          <div class='col-md-4'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Start Date\" name=\"startDate\" [value]=\"asset.startDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n           <div class='col-md-4'>\r\n            <mat-form-field>\r\n              <input matInput placeholder=\"End Date\" name=\"endDate\" [value]=\"asset.endDate\"  class=\"datepicker\" >\r\n            </mat-form-field>\r\n\t\t\t</div>\r\n          \r\n          \r\n             <div  class='col-md-4'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Branches\" [(ngModel)]=\"asset.branchsIds\"  formControlName=\"branchsIds\" multiple>\r\n                <mat-option *ngFor=\"let  branches of  branches\" [value]=\" branches.key\"> {{  branches.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          \r\n\t\t\r\n\t\t <div class=\"col-md-12 btn-row\">\r\n\t\t\t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Go </button> \r\n\t\t </div>\t\t\r\n\t\t</div>\r\n\t</form>\r\n</div>\r\n\r\n<div *ngIf=\"assetSummaryData.length!='0'\">\r\n<div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tAsset Summary\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div >\r\n\t\t<br>\r\n\t\t<div class=\"table\">\r\n\t\t<table style='' class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t<thead>         \r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th style=\"text-align: center;\">Branch</th>\r\n\t\t\t\t\t<th width=20% style=\"text-align: center;\">Asset Count</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t<tr *ngFor=\"let assetSummaryData of assetSummaryData\">\r\n\t\t\t\t<td><a href=\"\">{{assetSummaryData.branchName}}</a></td>\r\n\t\t\t\t<td style=\"text-align: right;\">{{assetSummaryData.assetCount}}</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr  rowspan=\"3\"><td style=\"text-align: right;\">Total</td>\r\n\t\t\t<td style=\"text-align: right;\">{{grandTotal}}</td>\r\n\t\t\t</tr>\r\n\t\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>\r\n\t<div class=\"col-md-12\">\r\n\t\t\t<a style=\"padding-left: 43em;\" href=\"/service/assets-list\">Click heret to List Assets</a>\r\n\t\t</div>\r\n</div>\r\n\r\n<div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tExport\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t <form  (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"assetForm\">\r\n\t<div class=\"m-portlet__body row\">\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Report Type\" [(ngModel)]=\"asset.reporttype\" \r\n\t\t\t\t \tformControlName=\"reporttype\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  reporttypes of  reporttypes\" [value]=\"reporttypes.key\">\r\n\t\t\t\t  {{  reporttypes.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Export Format\" [(ngModel)]=\"asset.exportfromat\" \r\n\t\t\t\t \tformControlName=\"exportfromat\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  exportformats of  exportformats\" [value]=\"exportformats.key\">\r\n\t\t\t\t  {{  exportformats.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t <br>\r\n\t\t\t <div class=\"col-md-12 btn-row\" style=\"padding-bottom: 1em;\">\r\n\t\t\t\t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Export</button> \r\n\t\t\t </div>\r\n\t\t\t</div>\t\r\n\t\t</form>\r\n\t</div>\r\n</div>\r\n\r\n<div *ngIf=\"assetSummaryData.length=='0'\">\r\n<span style=\"color:red;padding-left:41em\">No Record(s) Found!</span>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/assets/asset.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssetComponent; });
/* unused harmony export AssetData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&â€™*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var MOBILE_REGEX = /^[91]{2}-\d{10}$/;
var PIN_REGEX = /[0-9]{6}/;
var PHONE_REGEX = /^[91]{2}-[80]{2}-[0-9]{6}$/;
var AMOUNT = /[0-9]/;
var AssetComponent = (function () {
    function AssetComponent(http, route, router) {
        this.http = http;
        this.route = route;
        this.router = router;
        this.flyInOutTrigger = 'in';
        this.listHide = true;
        this.animateList = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.contractId = 0;
        this.asset = new AssetData();
        this.msg = [];
        this.branches = [];
        this.bootstrapFromValues = [];
        this.assetSummaryData = [];
        this.reporttypes = [
            { key: '1', name: 'Contract Details' }
        ];
        this.exportformats = [
            { key: '1', name: 'MS Excel' },
            { key: '12', name: 'HTML' }
        ];
    }
    AssetComponent.prototype.ngOnInit = function () {
        this.populateDropDownData();
        this.getTodaysDate();
        this.assetForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'branchsIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'reporttype': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'exportfromat': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(AssetComponent.prototype, "branchsIds", {
        get: function () { return this.assetForm.get('branchsIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetComponent.prototype, "reporttype", {
        get: function () { return this.assetForm.get('reporttype'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetComponent.prototype, "exportfromat", {
        get: function () { return this.assetForm.get('exportfromat'); },
        enumerable: true,
        configurable: true
    });
    ;
    AssetComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['service/contracts-list/contractAdd'], { queryParams: { contractId: this.contractId } });
    };
    AssetComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branches = data['populateBranch'];
        });
    };
    AssetComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    AssetComponent.prototype.getTodaysDate = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/currentdate', JSON.stringify({ requestType: 'shortDate' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.asset.startDate = data['date'];
            _this.asset.endDate = data['date'];
        });
    };
    AssetComponent.prototype.onSubmit = function () {
        var _this = this;
        this.listHide = false;
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.asset[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        this.asset['requestType'] = 'landing';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/service/asset', JSON.stringify(this.asset), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.assetSummaryData = data['populateLandingData'];
            _this.grandTotal = data['grandTotal'];
        });
    };
    return AssetComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _a || Object)
], AssetComponent.prototype, "smart", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], AssetComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], AssetComponent.prototype, "list", void 0);
AssetComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/service/assets/asset.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _e || Object])
], AssetComponent);

var AssetData = (function () {
    function AssetData() {
        this.startDate = '';
        this.endDate = '';
    }
    return AssetData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=asset.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/assets/asset.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AssetModule", function() { return AssetModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__asset_component__ = __webpack_require__("../../../../../src/app/theme/pages/service/assets/asset.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
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











//import { SmartSearchComponent } from '../../../layouts/smart-search/smart-search.component';

var routes = [
    {
        "path": "",
        "component": __WEBPACK_IMPORTED_MODULE_5__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_3__asset_component__["a" /* AssetComponent */]
            }
        ]
    }
];
var AssetModule = (function () {
    function AssetModule() {
    }
    return AssetModule;
}());
AssetModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_11__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__asset_component__["a" /* AssetComponent */]
        ],
    })
], AssetModule);

//# sourceMappingURL=asset.module.js.map

/***/ })

});
//# sourceMappingURL=asset.module.chunk.js.map