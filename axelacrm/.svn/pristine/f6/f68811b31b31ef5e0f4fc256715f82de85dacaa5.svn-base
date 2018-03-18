webpackJsonp(["top-customers.module"],{

/***/ "../../../../../src/app/theme/pages/customer/customer-dashboard/top-customers/top-customer.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"m-subheader mr-auto\" >\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\tTop {{configCustomerName}}\r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a routerLink=\"/customer/customer-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t{{Customers}}\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a routerLink=\"/customer/customer-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tTop Customers:\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t</ul>\r\n\t</div>\r\n\t\t\r\n<div class=\"m-portlet m-portlet--mobile\">\r\n\t\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t Top Customers\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"topCustomerForm\" id=\"m_form_1\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n          \r\n          \r\n           <div  class='col-md-3' *ngIf=\"compdetails.compBranchCount!='0'\">\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Branch\" [(ngModel)]=\"topcustomers.branchIds\" formControlName=\"branchIds\" multiple>\r\n                <mat-option *ngFor=\"let  branches of  branches\" [value]=\" branches.key\"> {{  branches.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-3' *ngIf=\"compdetails.compFranchiseeCount!='0'\">\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Franchisee\" [(ngModel)]=\"topcustomers.franchiseeIds\" formControlName=\"franchiseeIds\" multiple>\r\n                <mat-option *ngFor=\"let  franchisees of  franchisees\" [value]=\" franchisees.key\"> {{  franchisees.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          \r\n           <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Teams\" [(ngModel)]=\"topcustomers.teamIds\"  formControlName=\"teamIds\" multiple>\r\n                <mat-option *ngFor=\"let  teams of  teams\" [value]=\" teams.key\"> {{  teams.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n           <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Executives\" [(ngModel)]=\"topcustomers.exeIds\" formControlName=\"exeIds\" multiple>\r\n                <mat-option *ngFor=\"let  executives of  executives\" [value]=\" executives.key\"> {{  executives.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n           <div class='col-md-6'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Start Date\" name=\"startDate\" [value]=\"topcustomers.startDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n           <div class='col-md-6'>\r\n            <mat-form-field>\r\n              <input matInput placeholder=\"End Date\" name=\"endDate\" [value]=\"topcustomers.endDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n\t\t\t</div>\r\n          \r\n\t\t <div class=\"col-md-12 btn-row\">\r\n\t\t\t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Go </button> \r\n\t\t </div>\t\t\r\n\t\t</div>\r\n\t</form>\r\n</div>\r\n\r\n\r\n<div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div >\r\n\t\t<br>\r\n\t\t<div>\r\n\t\t<table class=\"table-hover data-filter=#filter table table-responsive table-bordered\">\r\n\t\t\t<thead>         \r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th >#</th>\r\n\t\t\t\t\t<th >{{configCustomerName}}</th>\r\n\t\t\t\t\t<th >Sales</th>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<th >#</th>\r\n\t\t\t\t\t<th >{{configCustomerName}}</th>\r\n\t\t\t\t\t<th >Invoices</th>\r\n\t\t\t\t\r\n\t\t\t\t\t<th >#</th>\r\n\t\t\t\t\t<th >{{configCustomerName}}</th>\r\n\t\t\t\t\t<th >Receipts</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t\t<td>1</td>\r\n\t\t\t\t<td><a href=\"\">Guru123</a></td>\r\n\t\t\t\t<td>71,550.0</td>\r\n\t\t\t\t<td>1</td>\r\n\t\t\t\t<td><a href=\"\">Pavi</a></td>\r\n\t\t\t\t<td>64,700.0</td>\r\n\t\t\t\t<td>1</td>\r\n\t\t\t\t<td><a href=\"\">Anil A</a></td>\r\n\t\t\t\t<td>73,569.0</td>\r\n\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/customer/customer-dashboard/top-customers/top-customers.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TopCustomersComponent; });
/* unused harmony export TopCustomerData */
/* unused harmony export CompDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_startWith__ = __webpack_require__("../../../../rxjs/add/operator/startWith.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_startWith___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_startWith__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_observable_merge__ = __webpack_require__("../../../../rxjs/add/observable/merge.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_observable_merge___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_rxjs_add_observable_merge__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_debounceTime__ = __webpack_require__("../../../../rxjs/add/operator/debounceTime.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_debounceTime___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_debounceTime__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_distinctUntilChanged__ = __webpack_require__("../../../../rxjs/add/operator/distinctUntilChanged.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_distinctUntilChanged___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_distinctUntilChanged__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_observable_fromEvent__ = __webpack_require__("../../../../rxjs/add/observable/fromEvent.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_observable_fromEvent___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_rxjs_add_observable_fromEvent__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};














var TopCustomersComponent = (function () {
    function TopCustomersComponent(_script, http) {
        this._script = _script;
        this.http = http;
        this.listHide = true;
        this.addHide = false;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.pageValue = "1";
        this.sortField = "";
        this.sortDirection = "";
        this.length = 10;
        this.topcustomers = new TopCustomerData();
        this.topcustomerSummary = [];
        this.recieptsSegment = [];
        this.salesSegment = [];
        this.invoiceSegment = [];
        this.branches = [];
        this.teams = [];
        this.executives = [];
        this.franchisees = [];
        this.bootstrapFormValues = [];
        this.compdetails = new CompDetails();
        this.configCustomerName = sessionStorage.getItem('configCustomerName');
        this.compdetails.compFranchiseeCount = sessionStorage.getItem('compFranchiseeCount');
        this.compdetails.compBranchCount = sessionStorage.getItem('compBranchCount');
    }
    TopCustomersComponent.prototype.ngOnInit = function () {
        this.listHide = true;
        this.animateList = 'out';
        this.populateDropDownData();
        this.getTodaysDate();
        this.topCustomerForm = new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormGroup"]({
            'branchIds': new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormControl"](''),
            'teamIds': new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormControl"](''),
            'exeIds': new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormControl"](''),
            'franchiseeIds': new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(TopCustomersComponent.prototype, "branchIds", {
        get: function () { return this.topCustomerForm.get('branchIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TopCustomersComponent.prototype, "teamIds", {
        get: function () { return this.topCustomerForm.get('teamIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TopCustomersComponent.prototype, "exeIds", {
        get: function () { return this.topCustomerForm.get('exeIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TopCustomersComponent.prototype, "franchiseeIds", {
        get: function () { return this.topCustomerForm.get('franchiseeIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    TopCustomersComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () { });
    };
    TopCustomersComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branches = data['populateBranch'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.teams = data['populateTeam'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/franchisee', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.franchisees = data['populateFranchisee'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executives = data['populateExecutive'];
        });
    };
    TopCustomersComponent.prototype.getTodaysDate = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/currentdate', JSON.stringify({ requestType: 'shortDate' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.topcustomers.startDate = data['date'];
            _this.topcustomers.endDate = data['date'];
        });
    };
    TopCustomersComponent.prototype.onSubmit = function () {
        var _this = this;
        this.listHide = false;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.topcustomers[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
        }
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer/report-topcustomers', JSON.stringify(this.topcustomers), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.recieptsSegment = data['recieptsSegment'];
            _this.salesSegment = data['salesSegment'];
            _this.invoiceSegment = data['invoiceSegment'];
        });
    };
    TopCustomersComponent.prototype.branchOnChange = function (event) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', JSON.stringify({ branchIds: event.value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.teams = data['populateTeam'];
        });
    };
    return TopCustomersComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */]) === "function" && _a || Object)
], TopCustomersComponent.prototype, "sort", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_13__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], TopCustomersComponent.prototype, "list", void 0);
TopCustomersComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/customer/customer-dashboard/top-customers/top-customer.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object])
], TopCustomersComponent);

var TopCustomerData = (function () {
    function TopCustomerData() {
        this.startDate = '';
        this.endDate = '';
    }
    return TopCustomerData;
}());

var CompDetails = (function () {
    function CompDetails() {
        this.compFranchiseeCount = '0';
        this.compBranchCount = '0';
    }
    return CompDetails;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=top-customers.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/customer/customer-dashboard/top-customers/top-customers.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TopCustomersModule", function() { return TopCustomersModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__top_customers_component__ = __webpack_require__("../../../../../src/app/theme/pages/customer/customer-dashboard/top-customers/top-customers.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__top_customers_component__["a" /* TopCustomersComponent */]
            }
        ]
    }
];
var TopCustomersModule = (function () {
    function TopCustomersModule() {
    }
    return TopCustomersModule;
}());
TopCustomersModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */],
            __WEBPACK_IMPORTED_MODULE_9__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [__WEBPACK_IMPORTED_MODULE_3__top_customers_component__["a" /* TopCustomersComponent */]],
    })
], TopCustomersModule);

//# sourceMappingURL=top-customers.module.js.map

/***/ })

});
//# sourceMappingURL=top-customers.module.chunk.js.map