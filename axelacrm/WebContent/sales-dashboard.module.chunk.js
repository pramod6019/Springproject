webpackJsonp(["sales-dashboard.module"],{

/***/ "../../../../../src/app/theme/pages/sales/sales-dashboard/sales-dashboard.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"m-subheader mr-auto\" >\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tSales \r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tSales:\r\n\t\t\t\t\t</span>\r\n\t\t\t</li>\r\n\t\t</ul>\r\n\t</div>\r\n\t\t\r\n<div class=\"row\">\t\r\n\r\n\r\n<div class=\"col-md-4 col-sm-6 col-xs-12\">\r\n<div class=\"m-portlet m-portlet--mobile\"  >\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tEscalations\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t<div class=\"m-portlet__body row\">\r\n\r\n\t</div>\r\n</div>\r\n</div>\r\n\r\n<div class=\"col-md-4 col-sm-6 col-xs-12\">\r\n<div class=\"m-portlet m-portlet--mobile\"  >\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tSales Open Pipeline\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div class=\"m-portlet__body row\">\r\n\t</div>\r\n</div>\r\n</div>\r\n\r\n<div class=\"col-md-4 col-sm-6 col-xs-12\">\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\" >\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tSales Reports\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t<div class=\"m-portlet__body row\">\t\r\n\t\t\t<table class=\"table table-responsive data-filter='#filter''\">\r\n\t\t\t\t<tbody>\r\n\t\t\t\t\t<tr *ngFor=\"let salesRepotLinks of salesRepotLinks\">\r\n\t\t\t\t\t\t<td><a [routerLink]=\"salesRepotLinks.reportUrl\">{{salesRepotLinks.reportName}}</a></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</tbody>\r\n\t\t\t</table>\r\n\t\t</div>\r\n</div>\r\n</div>\r\n\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/sales-dashboard/sales-dashboard.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SalesDashboardComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var SalesDashboardComponent = (function () {
    function SalesDashboardComponent(http, router) {
        this.http = http;
        this.router = router;
        this.flyInOutTrigger = 'in';
        this.salesRepotLinks = [];
    }
    SalesDashboardComponent.prototype.ngOnInit = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/sales-dashboard', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.salesRepotLinks = data['listReports'];
            console.log(_this.salesRepotLinks);
        });
    };
    return SalesDashboardComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], SalesDashboardComponent.prototype, "flyInOutTrigger", void 0);
SalesDashboardComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/sales/sales-dashboard/sales-dashboard.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _b || Object])
], SalesDashboardComponent);

var _a, _b;
//# sourceMappingURL=sales-dashboard.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/sales-dashboard/sales-dashboard.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SalesDashboardModule", function() { return SalesDashboardModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__sales_dashboard_component__ = __webpack_require__("../../../../../src/app/theme/pages/sales/sales-dashboard/sales-dashboard.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
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
        "component": __WEBPACK_IMPORTED_MODULE_5__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_3__sales_dashboard_component__["a" /* SalesDashboardComponent */]
            }
        ]
    }
];
var SalesDashboardModule = (function () {
    function SalesDashboardModule() {
    }
    return SalesDashboardModule;
}());
SalesDashboardModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_8__angular_material__["t" /* MatPaginatorModule */]
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__sales_dashboard_component__["a" /* SalesDashboardComponent */]],
    })
], SalesDashboardModule);

//# sourceMappingURL=sales-dashboard.module.js.map

/***/ })

});
//# sourceMappingURL=sales-dashboard.module.chunk.js.map