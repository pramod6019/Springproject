webpackJsonp(["customer-title-list.module"],{

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-add.component.html":
/***/ (function(module, exports) {

module.exports = "<toast></toast>\r\n\r\n\r\n  <div class=\"m-subheader\">\r\n  <div class=\"mr-auto\">\r\n    <h3 class=\"m-subheader__title m-subheader__title--separator\"> {{status}} Title </h3>\r\n    <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n<!--\r\n      <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n      <li class=\"m-nav__separator\"> > </li>\r\n-->\r\n      <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n      <li class=\"m-nav__separator\"> > </li>\r\n      <li class=\"m-nav__item\"> <a routerLink=\"/portal/manager\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Business Manager </span> </a> </li>\r\n      <li class=\"m-nav__separator\"> > </li>\r\n      <li class=\"m-nav__item\"> <a href=\"portal/customer-title-list\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\">  List Title:</span> </a> </li>\r\n    </ul>\r\n  </div>\r\n</div>\r\n  \r\n  <div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title \">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t{{status}} Title \r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n   \r\n    <form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\"\tid=\"m_form_1\" [formGroup]=\"titleForm\">\r\n      <div class=\"m-portlet__body row\"> \r\n        <div class='col-md-3'></div>\r\n        <div class='col-md-6'>\r\n          <mat-form-field>\r\n            <input matInput placeholder=\"Title\" required [(ngModel)]=\"customertitle.titleDesc\" formControlName=\"titleDesc\" maxlength=\"255\">\r\n            <mat-error *ngIf=\"titleDesc.hasError('required')\"> Enter Title </mat-error>\r\n          </mat-form-field>\r\n        </div>\r\n         <div class='col-md-3'></div>\r\n       \r\n          \r\n        <div class=\"col-md-12 row\" *ngIf=\"this.customertitle.titleEntryId\">\r\n         <div class=\"col-md-2\"></div>\r\n          <div class='col-md-4'>\r\n            <label style=\"margin-left: 8.9em;\">Entry By:</label>\r\n\t\t\t  <a href=\"\">{{customertitle.titleEntryBy}}</a> \r\n            </div>\r\n          <div class='col-md-4'>\r\n            <label style=\"margin-left: 15em;\">Entry Date:</label>\r\n            {{customertitle.titleEntryDate}} \r\n            </div>\r\n            <div class=\"col-md-2\"></div>\r\n\t\t  </div>\r\n           <div class=\"col-md-12 row\" *ngIf=\"this.customertitle.titleModifiedId\">\r\n            <div class=\"col-md-2\"></div>\r\n          <div class='col-md-4'>\r\n            <label style=\"margin-left: 8.9em;\">Modified By: </label>\r\n\t\t\t  <a href=\"\">{{customertitle.titleModifiedBy}} </a></div>\r\n          <div class='col-md-4'>\r\n            <label style=\"margin-left: 15em;\">Modified Date: </label>\r\n            {{customertitle.titleModifiedDate}} </div>\r\n            <div class=\"col-md-2\"></div>\r\n        </div>\r\n           \r\n            <div class='col-md-12  btn-row' *ngIf=\"this.titleId == '0'\">\r\n              <button mat-button [disabled]=\"false\" class=\"btn btn-primary\" > Add </button>\r\n              <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\"> Cancel </button>\r\n            </div>\r\n            \r\n            <div class='col-md-12  btn-row' *ngIf=\"this.titleId != '0'\">\r\n             <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button>\r\n              <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button>\r\n              <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\"> Cancel </button>\r\n            </div>\r\n      </div>\r\n    </form>\r\n\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CustomerTitleAddComponent; });
/* unused harmony export CustomerTitleData */
/* unused harmony export configDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
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









var EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var MOBILE_REGEX = /^[91]{2}-\d{10}$/;
var PIN_REGEX = /^\d{6}$/;
var NUM_REGAX = /[0-9]/;
var CustomerTitleAddComponent = (function () {
    function CustomerTitleAddComponent(_script, http, _router, route) {
        var _this = this;
        this._script = _script;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.titleId = 0;
        this.customertitle = new CustomerTitleData();
        this.config = new configDetails();
        this.msg = [];
        this.bootstrapFromValues = [];
        this.route.queryParams.filter(function (params) { return params.titleId; }).subscribe(function (params) {
            if (params.titleId != undefined) {
                _this.titleId = params.titleId;
            }
        });
        if (this.titleId == 0) {
            this.status = "Add";
        }
        else {
            this.status = "Update";
            this.populateData();
        }
    }
    CustomerTitleAddComponent.prototype.ngOnInit = function () {
        this.titleForm = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormGroup"]({
            'titleId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'titleDesc': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'titleEntryId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'titleEntryDate': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'titleModifiedId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'titleModifiedDate': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(CustomerTitleAddComponent.prototype, "titleDesc", {
        get: function () { return this.titleForm.get('titleDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(CustomerTitleAddComponent.prototype, "titleEntryId", {
        get: function () { return this.titleForm.get('titleEntryId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(CustomerTitleAddComponent.prototype, "titleEntryDate", {
        get: function () { return this.titleForm.get('titleEntryDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(CustomerTitleAddComponent.prototype, "titleModifiedId", {
        get: function () { return this.titleForm.get('titleModifiedId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(CustomerTitleAddComponent.prototype, "titleModifiedDate", {
        get: function () { return this.titleForm.get('titleModifiedDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    CustomerTitleAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer/title-data', JSON.stringify({ titleId: this.titleId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.customertitle = data['populateData'][0];
            console.log(_this.customertitle);
        }, function (err) {
            /* this function is executed when there's an ERROR */
            console.log("ERROR: " + err);
        });
    };
    CustomerTitleAddComponent.prototype.ngAfterViewInit = function () { };
    CustomerTitleAddComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/customer-title-list']);
    };
    CustomerTitleAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.customertitle[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        if (!this.titleForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.titleId == 0) {
                this.customertitle['requestType'] = 'add';
            }
            else {
                this.customertitle['requestType'] = 'update';
                this.customertitle['titleId'] = this.titleId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer/title', JSON.stringify(this.customertitle), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                _this.titleForm.reset();
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
        console.log(this.customertitle);
    };
    CustomerTitleAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.customertitle['requestType'] = 'delete';
        this.customertitle['titleId'] = this.titleId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer/title', JSON.stringify(this.customertitle), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (data['successmsg'].includes('Successfully')) {
                _this.msg[0] = 'success';
                _this.msg[1] = data['successmsg'];
            }
            else {
                _this.msg[0] = 'Error';
                _this.msg[1] = data['successmsg'];
            }
            _this.toast.showtoast(_this.msg);
            _this.toggleAnimation();
            _this.titleForm.reset();
            //			 											this.list.getData();
        }, function (err) {
            console.log(err['error']['desc']);
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return CustomerTitleAddComponent;
}());
CustomerTitleAddComponent.SerialnoMandatory = "0";
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], CustomerTitleAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], CustomerTitleAddComponent.prototype, "toast", void 0);
CustomerTitleAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_4__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_5__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _e || Object])
], CustomerTitleAddComponent);

var CustomerTitleData = (function () {
    function CustomerTitleData() {
    }
    return CustomerTitleData;
}());

var configDetails = (function () {
    function configDetails() {
    }
    return configDetails;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=customer-title-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-list.component.html":
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\r\n\t\r\n      <div class=\"m-subheader\">\r\n      <div class=\"d-flex align-items-center\">\r\n      <div class=\"mr-auto\">\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\"> List Title  </h3>\r\n        <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n          <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/manager\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Business Manager </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\">  List Title:</span> </a> </li>\r\n        </ul>\r\n      </div>\r\n      <div> \r\n       \r\n\t\t<button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add Title\r\n\t\t</button>\r\n         \r\n        <a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n        <div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\"> <a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\"> <i class=\"la la-plus m--hide\"></i> <i class=\"la la-ellipsis-h\"></i> </a>\r\n          <div class=\"m-dropdown__wrapper\"> <span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n            <div class=\"m-dropdown__inner\">\r\n              <div class=\"m-dropdown__body\">\r\n                <div class=\"m-dropdown__content\">\r\n                  <ul class=\"m-nav\">\r\n                    <li class=\"m-nav__section m-nav__section--first m--hide\"> <span class=\"m-nav__section-text\"> Quick Actions </span> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-share\"></i> <span class=\"m-nav__link-text\"> Activity </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-chat-1\"></i> <span class=\"m-nav__link-text\"> Messages </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-info\"></i> <span class=\"m-nav__link-text\"> FAQ </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-lifebuoy\"></i> <span class=\"m-nav__link-text\"> Support </span> </a> </li>\r\n                    <li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n                    <li class=\"m-nav__item\"> <a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\"> Submit </a> </li>\r\n                  </ul>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      \r\n    </div>\r\n  </div>\r\n  \r\n  <smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\"></smart-search>\r\n  \r\n  <div class=\"m-content\">\r\n   <div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n    <div class=\"row align-items-center\">\r\n      <div class=\"col-xl-12 order-2 order-xl-1\">\r\n        <div class=\"example-container mat-elevation-z8\">\r\n          <listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\t\r\n \t \r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CustomerTitleListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__layouts_smart_search_smart_search_component__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};















var CustomerTitleListComponent = (function () {
    function CustomerTitleListComponent(_script, http, _router) {
        this._script = _script;
        this.http = http;
        this._router = _router;
        this.flyInOutTrigger = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.titleId = 0;
        this.msg = [];
    }
    CustomerTitleListComponent.prototype.ngOnInit = function () {
        this.smart.smartUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/customer/title-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/customer/title-list";
    };
    CustomerTitleListComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/customer-title-list/Titleadd'], { queryParams: { titleId: this.titleId } });
    };
    CustomerTitleListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    CustomerTitleListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    CustomerTitleListComponent.prototype.listClickListener = function (listParam) {
        console.log("outside update");
        if (listParam[0] == 'updateTitle') {
            console.log("inside update");
            this.titleId = listParam[1];
            this.toggleAnimation();
            //			this.titleForm.reset();
        }
    };
    CustomerTitleListComponent.prototype.ngAfterViewInit = function () {
    };
    return CustomerTitleListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_14__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_14__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _a || Object)
], CustomerTitleListComponent.prototype, "smart", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], CustomerTitleListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], CustomerTitleListComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _c || Object)
], CustomerTitleListComponent.prototype, "toast", void 0);
CustomerTitleListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _f || Object])
], CustomerTitleListComponent);

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=customer-title-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CustomerTitleListModule", function() { return CustomerTitleListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__customer_title_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__customer_title_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/manager/customer/title/customer-title-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__customer_title_list_component__["a" /* CustomerTitleListComponent */]
            }
        ]
    }, {
        "path": "Titleadd",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__customer_title_add_component__["a" /* CustomerTitleAddComponent */],
            }
        ]
    }
];
var CustomerTitleListModule = (function () {
    function CustomerTitleListModule() {
    }
    return CustomerTitleListModule;
}());
CustomerTitleListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_8__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_9__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_12__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__customer_title_list_component__["a" /* CustomerTitleListComponent */], __WEBPACK_IMPORTED_MODULE_4__customer_title_add_component__["a" /* CustomerTitleAddComponent */]
            //		SmartSearchComponent
        ],
    })
], CustomerTitleListModule);

//# sourceMappingURL=customer-title-list.module.js.map

/***/ })

});
//# sourceMappingURL=customer-title-list.module.chunk.js.map