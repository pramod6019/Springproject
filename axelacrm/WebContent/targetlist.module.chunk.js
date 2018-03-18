webpackJsonp(["targetlist.module"],{

/***/ "../../../../../src/app/theme/pages/sales/targetlist/targetlist.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".table thead th {\r\n/*    border-bottom: 1px solid #ccc7c7;*/\r\n    color: black;\r\n    font-weight: bolder;\r\n}\r\n\r\n.mat-card{\r\n\tpadding: 0px;\r\n}\r\n\r\nmat-card{\r\n\tmargin: 0px;\r\n}\r\n\r\n.container-fluid{\r\n\tpadding-left: 0px;\r\n\tpadding-right: 0px;\r\n}\r\n\r\ntable\r\n{\r\n\tdisplay: table;\r\n}\r\n\r\ntable {\r\n    border-collapse: unset;\r\n\tbackground-color: white;\r\n}\r\n\r\n.table-bordered td, .table-bordered th {\r\n    border: 0px solid white;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/targetlist/targetlist.component.html":
/***/ (function(module, exports) {

module.exports = "<!-- BEGIN: Subheader -->\r\n  <ng-template #add >\r\n  <div  [@roundAntiClockTrigger]=\"animateAdd\" class=\"example-scrolling-content\">\r\n  <div class=\"container-fluid\">\r\n    <div  class=\"m-portlet__body\" style=\"background-color: white;margin: 5px;\" > \r\n    <form (ngSubmit)=\"onSubmit($event)\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"targetUpdateForm\" id=\"m_form_1\">\r\n  <table *ngIf=\"targetFormControlName.length == targetCountData.length\" class=\"table table-responsive table-bordered table-striped table-hover\">\r\n  \t<thead>\r\n\t   <tr>\r\n<!--\r\n\t   \t <th>#</th>\r\n\t   \t <th>Modal</th>\r\n-->\r\n\t\t <th style=\"text-align:center\" *ngFor=\"let th1 of targetThead\" >{{th1}}</th>\r\n  \t\t</tr>\r\n  \t</thead>\r\n  \t<tbody>\r\n  \t\t<tr *ngFor=\"let modal of targetCountData; let j = index;\">\r\n  \t\t\t<td>{{j+1}}</td>\r\n  \t\t\t<td>{{modal.modelName}}</td>\r\n  \t\t\t<td><input class=\"form-control\" [value]=\"modal.opprCount\" [formControlName]=\"targetFormControlName[j].fc[0]\" type=\"text\"></td>\r\n  \t\t\t<td><input class=\"form-control\" [value]=\"modal.opprCall\" [formControlName]=\"targetFormControlName[j].fc[1]\" type=\"text\"></td>\r\n  \t\t\t<td><input class=\"form-control\" [value]=\"modal.opprMeeting\" [formControlName]=\"targetFormControlName[j].fc[2]\" type=\"text\"></td>\r\n  \t\t\t<td><input class=\"form-control\" [value]=\"modal.opprDemo\" [formControlName]=\"targetFormControlName[j].fc[3]\" type=\"text\"></td>\r\n  \t\t\t<td><input class=\"form-control\" [value]=\"modal.opprHot\" [formControlName]=\"targetFormControlName[j].fc[4]\" type=\"text\"></td>\r\n  \t\t\t<td><input class=\"form-control\" [value]=\"modal.opprSo\" [formControlName]=\"targetFormControlName[j].fc[5]\" type=\"text\"></td>\r\n  \t\t\t<td><input class=\"form-control\" [value]=\"modal.opprSOAmount\" [formControlName]=\"targetFormControlName[j].fc[6]\" type=\"text\"></td>\r\n  \t\t\t<td><input class=\"form-control\" [(ngModel)]=\"modal.modelId\" [value]=\"modal.modelId\" [formControlName]=\"targetFormControlName[j].fc[7]\" type=\"text\" hidden=\"\"></td>\r\n<!--  \t\t\t<td *ngFor=\"let modal1 of targetFormControlName; let k = index;\" ></td>-->\r\n  \t\t</tr>\r\n  \t\t\r\n  \t\t<tr>\r\n\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t<td align='right'>Total</td>\r\n\t\t\t  \t\t\t<td align='center'>{{targetCount.totalOpprCount}}</td>\r\n\t\t\t  \t\t\t<td align='center'>{{targetCount.totalOpprCallsCount}}</td>\r\n\t\t\t  \t\t\t<td align='center'>{{targetCount.totalOpprMeetingsCount}}</td>\r\n\t\t\t  \t\t\t<td align='center'>{{targetCount.totalOpprDemosCount}}</td>\r\n\t\t\t  \t\t\t<td align='center'>{{targetCount.totalOpprHotCount}}</td>\r\n\t\t\t  \t\t\t<td align='center'>{{targetCount.totalSoCount}}</td>\r\n\t\t\t  \t\t\t<td align='center'>{{targetCount.totalSoAmount}}</td>\r\n\t\t\t\t\t</tr>\r\n  \t</tbody>\r\n  \t\r\n  </table>\r\n  <div class='col-md-12 text-center' style=\"margin: 15px\">\r\n\t\t <button  class=\"btn btn-primary\" type=\"submit\">Update Target</button> \r\n\t\t<button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\r\n\t</div>\r\n\t\t</form>\r\n  \r\n\t  </div>\r\n\t  </div>\r\n  </div>\r\n  </ng-template>\r\n  <div class=\"m-subheader\">\r\n\t<div class=\"d-flex align-items-center\">\r\n\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tList Targets \r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tSales\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tList Targets\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t  </div>\r\n\t  </div>\r\n  <div [hidden]=\"listPageHide\"   [@roundAntiClockTrigger]=\"animateList\" class=\"example-scrolling-content\">\r\n    <div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t\tSearch\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"targetForm\" id=\"m_form_1\" >\r\n        <div class='row'>\r\n           <div class='col-md-6'>\r\n            <mat-form-field>\r\n              <mat-select placeholder=\"Executive*\" [(ngModel)]=\"target.execuitiveId\"  formControlName=\"execuitiveId\"  \r\n               (change)=\"onSelect(execuitiveId.value, year.value)\">\r\n                <mat-option *ngFor=\"let  targetemp of  targetemp\" [value]=\"targetemp.key\"> {{  targetemp.name }} </mat-option>\r\n              </mat-select>\r\n              <mat-error *ngIf=\"execuitiveId.hasError('required')\"> Select Executive </mat-error>\r\n            </mat-form-field>\r\n          </div>\r\n          <div class='col-md-6'>\r\n            <mat-form-field>\r\n              <mat-select placeholder=\"Year*\" (change)=\"onSelectYear(year.value,execuitiveId.value)\" [(ngModel)]=\"target.year\" \r\n               formControlName=\"year\">\r\n                <mat-option *ngFor=\"let  targetyear of  targetyear\" [value]=\" targetyear.name\"> {{  targetyear.name }} </mat-option>\r\n              </mat-select>\r\n              <mat-error *ngIf=\"year.hasError('required')\"> Select Year </mat-error>\r\n            </mat-form-field>\r\n          </div>\r\n        </div>\r\n        </form>\r\n\t\t\t</div>\r\n\r\n\r\n\r\n\r\n</div>\r\n\r\n\r\n<div *ngIf=\"!listHide; else add\"  class=\"example-scrolling-content\">\r\n  <div class=\"m-content\">\r\n    <div class=\"m-portlet__body\" style=\"background-color: white;\" > \r\n       \r\n      <div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n        <div class=\"row align-items-center\">\r\n          <div class=\"col-xl-12 order-2 order-xl-1\">\r\n            <div class=\"example-container mat-elevation-z8\">\r\n              <table class=\"table table-responsive table-bordered table-striped table-hover\" >\r\n\t\t\t  \t<thead>\r\n\t\t\t  \t\t<tr >\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">#</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Month</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Oppr Count</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Oppr Calls</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Oppr Meeting</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Oppr Demos</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Oppr Hot</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Oppr So</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Oppr So Amount</th>\r\n\t\t\t  \t\t\t<th style=\"text-align:center\">Actions</th>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t\t<tr *ngFor=\"let target of targetList; let i = index;\">\r\n\t\t\t  \t\t\t<td>{{i+1}}</td>\r\n\t\t\t  \t\t\t<td>{{target.month}}</td>\r\n\t\t\t  \t\t\t<td>{{target.targetOpprCount}}</td>\r\n\t\t\t  \t\t\t<td>{{target.targetOpprCallsCount}}</td>\r\n\t\t\t  \t\t\t<td>{{target.targetOpprMeetingsCount}}</td>\r\n\t\t\t  \t\t\t<td>{{target.targetOpprDemosCount}}</td>\r\n\t\t\t  \t\t\t<td>{{target.targetOpprHotCount}}</td>\r\n\t\t\t  \t\t\t<td>{{target.targetSoCount}}</td>\r\n\t\t\t  \t\t\t<td>{{target.targetSoAmount}}</td>\r\n\t\t\t\t\t\t<td><a href='' (click)=\"onClick(i)\">Update Target</a></td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t<td align='right'>{{targetCount.month}}</td>\r\n\t\t\t  \t\t\t<td>{{targetCount.totalOpprCount}}</td>\r\n\t\t\t  \t\t\t<td>{{targetCount.totalOpprCallsCount}}</td>\r\n\t\t\t  \t\t\t<td>{{targetCount.totalOpprMeetingsCount}}</td>\r\n\t\t\t  \t\t\t<td>{{targetCount.totalOpprDemosCount}}</td>\r\n\t\t\t  \t\t\t<td>{{targetCount.totalOpprHotCount}}</td>\r\n\t\t\t  \t\t\t<td>{{targetCount.totalSoCount}}</td>\r\n\t\t\t  \t\t\t<td>{{targetCount.totalSoAmount}}</td>\r\n\t\t\t  \t\t\t<td></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/targetlist/targetlist.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TargetListComponent; });
/* unused harmony export TargetList */
/* unused harmony export TargetRouting */
/* unused harmony export TargetFormControl */
/* unused harmony export targetData */
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














//import { SmartSearchComponent } from '../../../layouts/smart-search/smart-search.component';
var EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var MOBILE_REGEX = /^[91]{2}-\d{10}$/;
var TargetListComponent = (function () {
    function TargetListComponent(_script, http) {
        this._script = _script;
        this.http = http;
        this.demo = [];
        this.targetResponseObj = [];
        this.targetCount = {};
        this.targetThead = [];
        this.formVariables = ["opprCount", "opprCalls", "opprMeeting", "opprDemos", "opprHot", "opprSo", "opprSOAmount", "modelId"];
        this.targetModal = ["Model1", "fastrack", "new1", "mine", "Swift", "Omni", "i20"];
        this.targetFormControlName = [];
        this.targetCountData = [];
        this.listHide = true;
        this.listPageHide = true;
        this.addPageHide = true;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.targetId = 0;
        this.pageValue = "1";
        this.sortField = "";
        this.sortDirection = "";
        this.length = 10;
        this.pageIndex = 1;
        this.target = new targetData();
        this.targetemp = [];
        this.targetyear = [
            { key: '1', name: '2007' },
            { key: '2', name: '2008' },
            { key: '3', name: '2009' },
            { key: '4', name: '2010' },
            { key: '5', name: '2011' },
            { key: '6', name: '2012' },
            { key: '7', name: '2013' },
            { key: '8', name: '2014' },
            { key: '9', name: '2015' },
            { key: '10', name: '2016' },
            { key: '11', name: '2017' },
            { key: '12', name: '2018' },
            { key: '13', name: '2019' },
            { key: '14', name: '2020' },
        ];
    }
    TargetListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.listPageHide = false;
        this.listHide = true;
        var jobGroup = new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormGroup"]({});
        this.targetUpdateForm = jobGroup;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        var demo = this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/executive', JSON.stringify({ execuitiveId: '1' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.targetemp = data['populateExecutive'];
        });
        this.targetForm = new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormGroup"]({
            'execuitiveId': new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_6__angular_forms__["Validators"].required]),
            'year': new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_6__angular_forms__["Validators"].required]),
        });
    };
    Object.defineProperty(TargetListComponent.prototype, "execuitiveId", {
        get: function () { return this.targetForm.get('execuitiveId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(TargetListComponent.prototype, "year", {
        get: function () { return this.targetForm.get('year'); },
        enumerable: true,
        configurable: true
    });
    ;
    TargetListComponent.prototype.toggleAnimation = function () {
        alert();
        if (this.animateAdd == 'out' || this.animateList == 'in') {
            this.listPageHide = true;
            this.listHide = true;
            this.addPageHide = false;
            //			if(this.targetId == 0){
            //				this.populateDropDownData();
            //			}else{
            //				this.populateData();
            //			}
            this.animateList = 'out';
            this.animateAdd = 'in';
        }
        else {
            this.addPageHide = true;
            this.listPageHide = false;
            this.listHide = false;
            this.targetForm.reset();
            this.animateAdd = 'out';
            this.animateList = 'in';
        }
    };
    TargetListComponent.prototype.ngAfterViewInit = function () {
        //	  	this.list.listUrl="http://192.168.0.14:8060/axelacrm/sales/target-list";
        /*{modal:"Model1",'fc':["fc1","fc2","fc3","fc4","fc5","fc6","fc7"]},
                            {modal:"fastrack",'fc':["fc8","fc9","fc10","fc11","fc12","fc13","fc14"]},
                            {modal:"new1",'fc':["fc15","fc16","f17","f18","f19","fc20","fc21"]},
                            {modal:"mine",'fc':["fc22","fc23","fc24","fc25","fc26","fc27","fc28"]},
                            {modal:"Swift",'fc':["fc29","fc30","fc31","fc32","fc33","fc34","fc35"]},
                            {modal:"Omni",'fc':["fc36","fc37","fc38","fc39","fc40","fc41","fc42"]},
                            {modal:"i20",'fc':["fc43","fc44","fc45","fc46","fc47","fc48","fc49"]}*/
    };
    TargetListComponent.prototype.onSelectYear = function (year, executiveId) {
        var _this = this;
        //		  this.targetForm.submit();
        if (!this.targetForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.target.year = year;
            this.target.execuitiveId = executiveId;
            this.target.year = year;
            //		    alert("year=="+year+"exe==="+executiveId);
            this.listHide = false;
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/target-list', JSON.stringify({ 'year': year, 'executiveId': executiveId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.listHide = false;
                _this.targetThead = data['heading'];
                _this.targetList = data['targetList'];
                _this.targetRouting = data['targetRouting'];
                _this.targetCount = data['targetCount'][0];
            });
        }
    };
    TargetListComponent.prototype.onSelect = function (executiveId, year) {
        var _this = this;
        if (!this.targetForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.target.execuitiveId = executiveId;
            this.target.year = year;
            this.listHide = false;
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/target-list', JSON.stringify({ 'year': year, 'executiveId': executiveId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                console.log(_this.target.execuitiveId);
                _this.listHide = false;
                _this.targetList = data['targetList'];
                _this.targetRouting = data['targetRouting'];
                _this.targetCount = data['targetCount'][0];
            });
        }
    };
    TargetListComponent.prototype.onClick = function (index) {
        this.targetFormControlName = [];
        var jobGroup = new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormGroup"]({});
        for (var i = 0; i < 68; i++) {
            this.targetFormControlName.push({ modal: "", fc: [] });
            for (var j = 0; j < this.formVariables.length; j++) {
                this.targetFormControlName[i].fc[j] = this.formVariables[j] + i;
                this.demo[j] = this.formVariables[j] + i;
                var control = new __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormControl"]('');
                jobGroup.addControl(this.demo[j], control);
            }
        }
        this.targetUpdateForm = jobGroup;
        this.getFormControl(index);
        this.toggleAnimation();
    };
    TargetListComponent.prototype.getFormControl = function (index) {
        var _this = this;
        this.targetResponseObj[0] = this.targetRouting[index];
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/target-model-list', JSON.stringify(this.targetRouting[index]), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.targetCountData = data['targetPopulate'];
            _this.targetThead = data['heading'];
            _this.targetCount = data['targetCount'];
        });
    };
    TargetListComponent.prototype.onSubmit = function (event) {
        var _this = this;
        this.targetResponseObj[1] = this.targetUpdateForm.value;
        this.targetResponseObj[2] = { requestType: 'update' };
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post('http://192.168.0.15:7040/axelacrm/sales/sales-target', JSON.stringify(this.targetResponseObj), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.toggleAnimation();
            _this.getListData(_this.targetResponseObj[0].executiveId, _this.targetResponseObj[0].year);
        });
        //		  this.toggleAnimation();
    };
    TargetListComponent.prototype.getListData = function (executiveId, year) {
        var _this = this;
        alert("executiveId====" + executiveId + ";;;;;;;;;;" + "year========" + year);
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.target.execuitiveId = executiveId;
        this.target.year = year;
        this.listHide = false;
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/target-list', JSON.stringify({ 'year': year, 'executiveId': executiveId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            console.log(_this.target.execuitiveId);
            _this.listHide = false;
            _this.targetList = data['targetList'];
            _this.targetRouting = data['targetRouting'];
            _this.targetCount = data['targetCount'][0];
        });
    };
    return TargetListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */]) === "function" && _a || Object)
], TargetListComponent.prototype, "sort", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__list_list_component__["a" /* ListComponent */])
    //	 private list: ListComponent;
    ,
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormGroup"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormGroup"]) === "function" && _b || Object)
], TargetListComponent.prototype, "targetForm", void 0);
TargetListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/sales/targetlist/targetlist.component.html"),
        styles: [__webpack_require__("../../../../../src/app/theme/pages/sales/targetlist/targetlist.component.css")],
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object])
], TargetListComponent);

var TargetList = (function () {
    function TargetList() {
        this.targetSoAmount = "";
        this.month = "";
        this.targetOpprDemosCount = "";
        this.targetOpprCallsCount = "";
        this.targetOpprCount = "";
        this.targetOpprMeetingsCount = "";
        this.targetOpprHotCount = "";
        this.targetSoCount = "";
    }
    return TargetList;
}());

var TargetRouting = (function () {
    function TargetRouting() {
        this.targetId = "";
        this.month = "";
        this.year = "";
        this.executiveId = "";
    }
    return TargetRouting;
}());

var TargetFormControl = (function () {
    function TargetFormControl() {
        this.modal = "";
    }
    return TargetFormControl;
}());

var targetData = (function () {
    function targetData() {
        this.year = new Date().getFullYear().toString();
    }
    return targetData;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=targetlist.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/targetlist/targetlist.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TargetListModule", function() { return TargetListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__targetlist_component__ = __webpack_require__("../../../../../src/app/theme/pages/sales/targetlist/targetlist.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__targetlist_component__["a" /* TargetListComponent */]
            }
        ]
    }
];
var TargetListModule = (function () {
    function TargetListModule() {
    }
    return TargetListModule;
}());
TargetListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */],
            __WEBPACK_IMPORTED_MODULE_9__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__targetlist_component__["a" /* TargetListComponent */]
        ],
    })
], TargetListModule);

//# sourceMappingURL=targetlist.module.js.map

/***/ })

});
//# sourceMappingURL=targetlist.module.chunk.js.map