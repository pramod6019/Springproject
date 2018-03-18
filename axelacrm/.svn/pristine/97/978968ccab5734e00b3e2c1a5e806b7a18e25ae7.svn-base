webpackJsonp(["monitoring-board.module"],{

/***/ "../../../../../src/app/theme/pages/service/service-dashboard/monitoring-board/monitoring-board.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"m-subheader mr-auto\" >\r\n\t\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tService Monitoring Board\r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"/service/service-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tService\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"/service/monitoring-board\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tService Monitoring Board:\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t\r\n\t\t</ul>\r\n\t</div>\r\n\t\t\r\n<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t Service Monitoring Board\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"MonitoringBoardForm\" id=\"m_form_1\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n          \r\n          <div class='col-md-3'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Start Date\" name=\"startDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n           <div class='col-md-3'>\r\n            <mat-form-field>\r\n              <input matInput placeholder=\"End Date\" name=\"endDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n\t\t\t</div>\r\n          \r\n           <div class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Total By\" [(ngModel)]=\"monitoringBoard.totalById\" formControlName=\"totalById\">\r\n                <mat-option *ngFor=\"let  totalBy of  totalBy\" [value]=\" totalBy.key\"> {{  totalBy.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Order By\" [(ngModel)]=\"monitoringBoard.orderById\" formControlName=\"orderById\">\r\n                <mat-option *ngFor=\"let  orderBy of  orderBy\" [value]=\" orderBy.key\"> {{  orderBy.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n\r\n          <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Regions\" [(ngModel)]=\"monitoringBoard.regionIds\" (change)=\"regionOnChange($event)\" formControlName=\"regionIds\" multiple>\r\n                <mat-option *ngFor=\"let  brands of  brands\" [value]=\" brands.key\"> {{  brands.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n           <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Zone\" [(ngModel)]=\"monitoringBoard.zoneIds\" (change)=\"zoneOnChange($event)\" formControlName=\"zoneIds\" multiple>\r\n                <mat-option *ngFor=\"let  zones of  zones\" [value]=\" zones.key\"> {{  zones.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Branches\" [(ngModel)]=\"monitoringBoard.branchsIds\" (change)=\"branchOnChange($event)\" formControlName=\"branchsIds\" multiple>\r\n                <mat-option *ngFor=\"let  branches of  branches\" [value]=\" branches.key\"> {{  branches.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n           <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Service Advisor\" [(ngModel)]=\"monitoringBoard.serviceadvisorIds\" formControlName=\"serviceadvisorIds\" multiple>\r\n                <mat-option *ngFor=\"let  serviceadvisors of  serviceadvisors\" [value]=\" serviceadvisors.key\"> {{  serviceadvisors.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Service Technician\" [(ngModel)]=\"monitoringBoard.serviceadvisorIds\" formControlName=\"serviceadvisorIds\" multiple>\r\n                <mat-option *ngFor=\"let  servicetechnician of  servicetechnician\" [value]=\" servicetechnician.key\"> {{  servicetechnician.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Job Card Category\" [(ngModel)]=\"monitoringBoard.jcCatIds\" formControlName=\"jcCatIds\" multiple>\r\n                <mat-option *ngFor=\"let  jccategories of  jccategories\" [value]=\" advisors.key\"> {{  jccategories.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n\t\t\r\n\t\t <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Job Card Type\" [(ngModel)]=\"monitoringBoard.jcTypeIds\" formControlName=\"jcTypeIds\" multiple>\r\n                <mat-option *ngFor=\"let  jctypes of  jctypes\" [value]=\" jctypes.key\"> {{  jctypes.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Data Fields\" [(ngModel)]=\"monitoringBoard.datafieldIds\" formControlName=\"datafieldIds\" multiple>\r\n                <mat-option *ngFor=\"let  datafields of  datafields\" [value]=\" datafields.key\"> {{  datafields.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n         <div class='col-md-6' style=\"padding-top: 30px\">\r\n\t\t\t<label>In-Active Executive:</label>\r\n\t\t\t<mat-checkbox  [(ngModel)]=\"monitoringBoard.exeActive\"  formControlName=\"exeActive\"></mat-checkbox>\r\n\t\t </div>\r\n\t\t\r\n\t\t <div class=\"col-md-12 btn-row\">\r\n\t\t\t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Go </button> \r\n\t\t </div>\t\t\r\n\t\t</div>\r\n\t</form>\r\n</div>\r\n\r\n\r\n<div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t<div >\r\n\t\t<div style=\"overflow-x: scroll;\">\r\n\t\t<table style='margin: 10px' class=\"table table-responsive table-striped\">\r\n\t\t\t<thead>         \r\n\t\t\t\t<tr style=\"background-color: #438bcb;\">\r\n\t\t\t\t\t<th >#</th>\r\n\t\t\t\t\t<th >RO</th>\r\n\t\t\t\t\t<th >Labour</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t\t<td>1</td>\r\n\t\t\t\t<td>YES</td>\r\n\t\t\t\t<td>NO</td>\r\n\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/service-dashboard/monitoring-board/monitoring-board.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MonitoringBoardComponent; });
/* unused harmony export MonitoringBoardData */
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
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};














var MonitoringBoardComponent = (function () {
    function MonitoringBoardComponent(http, router, route) {
        this.http = http;
        this.router = router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.listHide = true;
        this.animateList = 'in';
        this.monitoringBoard = new MonitoringBoardData();
        this.totalBy = [];
        this.orderBy = [];
        this.brands = [];
        this.regions = [];
        this.branches = [];
        this.models = [];
        this.jccategories = [];
        this.jctypes = [];
        this.zones = [];
        this.serviceadvisors = [];
        this.servicetechnician = [];
        this.bootstrapFromValues = [];
        this.monitoringBoardDataSummary = [];
        this.datafields = [
            { key: '1', name: 'RO' },
            { key: '2', name: 'Labour' },
            { key: '3', name: 'Parts' },
            { key: '4', name: 'VAS' },
            { key: '5', name: 'Oil' },
            { key: '6', name: 'Brake' },
            { key: '7', name: 'Tyre' },
            { key: '8', name: 'Battery' },
            { key: '9', name: 'Accessories' },
            { key: '10', name: 'Ext. Warranty' },
        ];
    }
    MonitoringBoardComponent.prototype.ngOnInit = function () {
        this.listHide = true;
        this.animateList = 'out';
        this.populateDropDownData();
        this.MonitoringBoardForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'startDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'endDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'totalById': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'orderById': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'regionIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'zoneIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchsIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'modelIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'serviceadvisorIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'jcCatIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'jcTypeIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'datafieldIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'exeActive': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(MonitoringBoardComponent.prototype, "startDate", {
        get: function () { return this.MonitoringBoardForm.get('startDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "endDate", {
        get: function () { return this.MonitoringBoardForm.get('endDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "totalById", {
        get: function () { return this.MonitoringBoardForm.get('totalById'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "orderById", {
        get: function () { return this.MonitoringBoardForm.get('orderById'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "regionIds", {
        get: function () { return this.MonitoringBoardForm.get('regionIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "zoneIds", {
        get: function () { return this.MonitoringBoardForm.get('zoneIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "branchsIds", {
        get: function () { return this.MonitoringBoardForm.get('branchsIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "modelIds", {
        get: function () { return this.MonitoringBoardForm.get('modelIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "serviceadvisorIds", {
        get: function () { return this.MonitoringBoardForm.get('serviceadvisorIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "jcCatIds", {
        get: function () { return this.MonitoringBoardForm.get('jcCatIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "jcTypeIds", {
        get: function () { return this.MonitoringBoardForm.get('jcTypeIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "datafieldIds", {
        get: function () { return this.MonitoringBoardForm.get('datafieldIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(MonitoringBoardComponent.prototype, "exeActive", {
        get: function () { return this.MonitoringBoardForm.get('exeActive'); },
        enumerable: true,
        configurable: true
    });
    ;
    MonitoringBoardComponent.prototype.populateData = function () {
    };
    MonitoringBoardComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.totalBy = data['populateBranch'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.brands = data['populateTeam'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.regions = data['populateTeam'];
        });
    };
    MonitoringBoardComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () { });
    };
    MonitoringBoardComponent.prototype.toggleAnimation = function () {
    };
    MonitoringBoardComponent.prototype.onSubmit = function () {
        var _this = this;
        this.listHide = false;
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.monitoringBoard[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/soedash', JSON.stringify(this.monitoringBoard), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.monitoringBoardDataSummary = data['OpprSummaryHeader'];
        });
    };
    MonitoringBoardComponent.prototype.regionOnChange = function (event) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({ regionIds: event.value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.zones = data['populateExecutive'][0];
            _this.branches = data['populateExecutive'][1];
        });
    };
    MonitoringBoardComponent.prototype.zoneOnChange = function (event) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({ zoneIds: event.value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branches = data['populateExecutive'];
        });
    };
    MonitoringBoardComponent.prototype.branchOnChange = function (event) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({ branchsIds: event.value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.serviceadvisors = data['populateExecutive'][0];
            _this.servicetechnician = data['populateExecutive'][1];
        });
    };
    return MonitoringBoardComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], MonitoringBoardComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], MonitoringBoardComponent.prototype, "toast", void 0);
MonitoringBoardComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/service/service-dashboard/monitoring-board/monitoring-board.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _d || Object])
], MonitoringBoardComponent);

var MonitoringBoardData = (function () {
    function MonitoringBoardData() {
    }
    return MonitoringBoardData;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=monitoring-board.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/service-dashboard/monitoring-board/monitoring-board.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonitoringBoardModule", function() { return MonitoringBoardModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__monitoring_board_component__ = __webpack_require__("../../../../../src/app/theme/pages/service/service-dashboard/monitoring-board/monitoring-board.component.ts");
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












var routes = [
    {
        "path": "",
        "component": __WEBPACK_IMPORTED_MODULE_5__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_3__monitoring_board_component__["a" /* MonitoringBoardComponent */]
            }
        ]
    }
];
var MonitoringBoardModule = (function () {
    function MonitoringBoardModule() {
    }
    return MonitoringBoardModule;
}());
MonitoringBoardModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_11__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [__WEBPACK_IMPORTED_MODULE_3__monitoring_board_component__["a" /* MonitoringBoardComponent */]],
    })
], MonitoringBoardModule);

//# sourceMappingURL=monitoring-board.module.js.map

/***/ })

});
//# sourceMappingURL=monitoring-board.module.chunk.js.map