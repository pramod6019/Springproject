webpackJsonp(["report-jobcard-productivity.module"],{

/***/ "../../../../../src/app/theme/pages/service/service-dashboard/jobcard-productivity/report-jobcard-productivity.component.html":
/***/ (function(module, exports) {

module.exports = "<toast></toast>\r\n<div class=\"m-subheader mr-auto\" >\r\n\t\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tJob Card Productivity\r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t<li class=\"m-nav__item m-nav__item--home\">\r\n\t\t\t\t<a href=\"#\" class=\"m-nav__link m-nav__link--icon\">\r\n\t\t\t\t\t<i class=\"m-nav__link-icon la la-home\"></i>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n<!--\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n-->\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"/service/service-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tMIS\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>   \r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"/service/monitoring-board\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tJob Card Productivity:\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t\r\n\t\t</ul>\r\n\t</div>\r\n\t\t\r\n<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t Job Card Productivity\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"ReportJobCardProductivityForm\" id=\"m_form_1\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n          \r\n          \r\n          <div  class='col-md-6' *ngIf=\"compdetails.compBranchCount!='0'\">\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Branch\" [(ngModel)]=\"reportJobCardProductivity.jcBranchIds\" formControlName=\"jctypeIds\" multiple>\r\n                <mat-option *ngFor=\"let  branches of  branches\" [value]=\" branches.key\"> {{  branches.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-6' *ngIf=\"compdetails.compFranchiseeCount!='0'\">\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Franchisee\" [(ngModel)]=\"reportJobCardProductivity.jcFrancheseeIds\" formControlName=\"jctypeIds\" multiple>\r\n                <mat-option *ngFor=\"let  franchisees of  franchisees\" [value]=\" franchisees.key\"> {{  franchisees.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-4'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Type\" [(ngModel)]=\"reportJobCardProductivity.jctypeIds\" formControlName=\"jctypeIds\" multiple>\r\n                <mat-option *ngFor=\"let  jcTypes of  jcTypes\" [value]=\" jcTypes.key\"> {{  jcTypes.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-4'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Category\" [(ngModel)]=\"reportJobCardProductivity.jccatIds\" formControlName=\"jccatIds\" multiple>\r\n                <mat-option *ngFor=\"let  jcCategories of  jcCategories\" [value]=\" jcCategories.key\"> {{  jcCategories.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div  class='col-md-4'>\r\n            <mat-form-field>\r\n              <mat-select  placeholder=\"Status\" [(ngModel)]=\"reportJobCardProductivity.jcstatusIds\" formControlName=\"jcstatusIds\" multiple>\r\n                <mat-option *ngFor=\"let  jcStatus of  jcStatus\" [value]=\" jcStatus.key\"> {{  jcStatus.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          \r\n          <div class='col-md-6'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Start Date*\" name=\"startDate\" [value]=\"reportJobCardProductivity.startDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n            <span [innerHTML]=\"jcstartdatemsg\"></span>\r\n          </div>\r\n          \r\n           <div class='col-md-6'>\r\n            <mat-form-field>\r\n              <input matInput placeholder=\"End Date*\" name=\"endDate\" [value]=\"reportJobCardProductivity.endDate\" class=\"datepicker\" >\r\n            </mat-form-field>\r\n             <span [innerHTML]=\"jcenddatemsg\"></span>\r\n\t\t\t</div>\r\n          \r\n\t\t <div class=\"col-md-12 btn-row\">\r\n\t\t\t<button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Go </button> \r\n\t\t </div>\t\t\r\n\t\t</div>\r\n\t</form>\r\n</div>\r\n\r\n<div *ngIf=\"listJobCardExecutiveData.length!='0'\">\r\n<div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tService Advisor\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div >\r\n\t\t<br>\r\n\t\t<div>\r\n\t\t<table style='' class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t<thead>         \r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th>#</th>\r\n\t\t\t\t\t<th>Name</th>\r\n\t\t\t\t\t<th align=\"center\">Job Card</th>\r\n\t\t\t\t\t<th align=\"center\">Ammount</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t<tr *ngFor=\"let listJobCardExecutiveDatas of listJobCardExecutiveData\">\r\n\t\t\t\t<td>{{listJobCardExecutiveDatas.empId}}</td>\r\n\t\t\t\t<td>{{listJobCardExecutiveDatas.empName}}</td>\r\n\t\t\t\t<td><a href=\"\">{{listJobCardExecutiveDatas.empId}}</a></td>\r\n\t\t\t\t<td align=\"right\">{{listJobCardExecutiveDatas.jcCount}}</td>\r\n\t\t\t</tr>\r\n\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n</div>\r\n\r\n<div *ngIf=\"technicianDetailsData.length!='0'\">\r\n<div [hidden]=\"listHide\" class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tTechnician\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div >\r\n\t\t<br>\r\n\t\t<div>\r\n\t\t<table style='' class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t<thead>         \r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th>#</th>\r\n\t\t\t\t\t<th>Name</th>\r\n\t\t\t\t\t<th align=\"center\">Job Card</th>\r\n\t\t\t\t\t<th align=\"center\">Amount</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t<tr *ngFor=\"let technicianDetailsData of technicianDetailsData\">\r\n\t\t\t\t<td>{{technicianDetailsData.empId}}</td>\r\n\t\t\t\t<td>{{technicianDetailsData.empName}}</td>\r\n\t\t\t\t<td><a href=\"\">{{technicianDetailsData.empId}}</a></td>\r\n\t\t\t\t<td align=\"right\">{{technicianDetailsData.jcCount}}</td>\r\n\t\t\t</tr>\r\n\t\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n</div>\r\n\r\n<div *ngIf=\"listJobCardExecutiveData.length=='0'\">\r\n<span style=\"color:red;padding-left:41em\">No Record(s) Found!</span>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/service-dashboard/jobcard-productivity/report-jobcard-productivity.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ReportJobCardComponent; });
/* unused harmony export ReportJobCardProductivityData */
/* unused harmony export CompDetails */
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














var ReportJobCardComponent = (function () {
    function ReportJobCardComponent(http, router, route) {
        this.http = http;
        this.router = router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.listHide = true;
        this.animateList = 'in';
        this.reportJobCardProductivity = new ReportJobCardProductivityData();
        this.compdetails = new CompDetails();
        this.jcTypes = [];
        this.jcCategories = [];
        this.jcStatus = [];
        this.bootsjcStatus = [];
        this.msg = [];
        this.bootstrapFormValues = [];
        this.listJobCardExecutiveData = [];
        this.technicianDetailsData = [];
        this.branches = [];
        this.franchisees = [];
        this.bootstrapMsg = '';
        this.ReportJobCardProductivityDataSummary = [];
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
        this.compdetails.compBranchCount = sessionStorage.getItem('compBranchCount');
        this.compdetails.compFranchiseeCount = sessionStorage.getItem('compFranchiseeCount');
        console.log(this.compdetails.compBranchCount);
        console.log(this.compdetails.compFranchiseeCount);
    }
    ReportJobCardComponent.prototype.ngOnInit = function () {
        this.listHide = true;
        this.getTodaysDate();
        this.populateDropDownData();
        this.ReportJobCardProductivityForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'jctypeIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'jccatIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'jcstatusIds': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(ReportJobCardComponent.prototype, "jctypeIds", {
        get: function () { return this.ReportJobCardProductivityForm.get('jctypeIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ReportJobCardComponent.prototype, "jccatIds", {
        get: function () { return this.ReportJobCardProductivityForm.get('jccatIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ReportJobCardComponent.prototype, "jcstatusIds", {
        get: function () { return this.ReportJobCardProductivityForm.get('jcstatusIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    ReportJobCardComponent.prototype.populateData = function () {
    };
    ReportJobCardComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/jobcard-type', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.jcTypes = data['populateJcType'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/jobcard-status', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.jcStatus = data['populateJcStatus'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/jobcard-category', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.jcCategories = data['populateJcCategory'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branches = data['populateBranch'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/franchisee', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.franchisees = data['populateFranchisee'];
        });
    };
    ReportJobCardComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () { });
    };
    ReportJobCardComponent.prototype.toggleAnimation = function () {
    };
    ReportJobCardComponent.prototype.getTodaysDate = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/currentdate', JSON.stringify({ requestType: 'shortDate' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.reportJobCardProductivity.startDate = data['date'];
            _this.reportJobCardProductivity.endDate = data['date'];
        });
    };
    ReportJobCardComponent.prototype.onSubmit = function () {
        var _this = this;
        this.listHide = false;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            console.log(this.bootstrapFormValues[i].name);
            this.reportJobCardProductivity[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
        }
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            if (this.bootstrapFormValues[i].name == "startDate") {
                console.log(this.bootstrapFormValues[i].value);
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter Start Date!<br>';
                    this.jcstartdatemsg = "<font class='errorMsg'>Enter Start Date</font>";
                }
                else {
                    this.jcstartdatemsg = "";
                }
            }
            if (this.bootstrapFormValues[i].name == "endDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter End Date!<br>';
                    this.jcenddatemsg = "<font class='errorMsg'>Enter End Date</font>";
                }
                else {
                    this.jcenddatemsg = "";
                }
            }
        }
        if (this.bootstrapMsg != '') {
            this.msg[0] = 'Error';
            this.msg[1] = 'Enter the Mandatory Fields';
            this.toast.showtoast(this.msg);
            this.bootstrapMsg = '';
        }
        if (!this.ReportJobCardProductivityForm.invalid && this.bootstrapMsg == '') {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/service/report-jobcardproductivity', JSON.stringify(this.reportJobCardProductivity), { headers: headers, withCredentials: true }).subscribe(function (data) {
                //			   						if(data['errormessage']==''){
                _this.listJobCardExecutiveData = data['listJobCardExecutive'];
                _this.technicianDetailsData = data['technicianDetails'];
                //									}
                console.log(_this.listJobCardExecutiveData.length);
                console.log(_this.technicianDetailsData.length);
                if (data['errormsg'] != undefined) {
                    _this.msg[0] = 'Error';
                    _this.msg[1] = data['errormessage'];
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    return ReportJobCardComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ReportJobCardComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ReportJobCardComponent.prototype, "toast", void 0);
ReportJobCardComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/service/service-dashboard/jobcard-productivity/report-jobcard-productivity.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _d || Object])
], ReportJobCardComponent);

var ReportJobCardProductivityData = (function () {
    function ReportJobCardProductivityData() {
        this.startDate = '';
        this.endDate = '';
    }
    return ReportJobCardProductivityData;
}());

var CompDetails = (function () {
    function CompDetails() {
        this.compFranchiseeCount = '0';
        this.compBranchCount = '0';
    }
    return CompDetails;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=report-jobcard-productivity.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/service-dashboard/jobcard-productivity/report-jobcard-productivity.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReportJobCardProductivityModule", function() { return ReportJobCardProductivityModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__report_jobcard_productivity_component__ = __webpack_require__("../../../../../src/app/theme/pages/service/service-dashboard/jobcard-productivity/report-jobcard-productivity.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__report_jobcard_productivity_component__["a" /* ReportJobCardComponent */]
            }
        ]
    }
];
var ReportJobCardProductivityModule = (function () {
    function ReportJobCardProductivityModule() {
    }
    return ReportJobCardProductivityModule;
}());
ReportJobCardProductivityModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_11__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [__WEBPACK_IMPORTED_MODULE_3__report_jobcard_productivity_component__["a" /* ReportJobCardComponent */]],
    })
], ReportJobCardProductivityModule);

//# sourceMappingURL=report-jobcard-productivity.module.js.map

/***/ })

});
//# sourceMappingURL=report-jobcard-productivity.module.chunk.js.map