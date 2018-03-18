webpackJsonp(["jc-status-list.module"],{

/***/ "../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-add.component.html":
/***/ (function(module, exports) {

module.exports = "<toast></toast>\r\n\t\t\r\n\t\t<div class=\"m-subheader\">\t\t\t\r\n\t\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t{{status}} Job Card Status\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBusiness Manager\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"service/jc-status-list\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tList Job Card Status:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\r\n\t<mat-card>\r\n\t\t\t\t\r\n\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"jcStatusForm\" id=\"m_form_1\">\r\n\t\t\t \r\n\t\t<div class=\"m-portlet__body row\">\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Name\" [(ngModel)]=\"jcStatus.jcstatusName\" formControlName=\"jcstatusName\" required>\r\n\t\t\t\t<mat-error *ngIf=\"jcstatusName.hasError('required')\">\r\n      \t\t\t\t\tEnter Job Card Status Name\r\n   \t\t\t\t </mat-error>\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6 text-center'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Description\" [(ngModel)]=\"jcStatus.jcstatusDesc\" formControlName=\"jcstatusDesc\" required>\r\n\t\t\t\t<mat-error *ngIf=\"jcstatusDesc.hasError('required')\">\r\n      \t\t\t\t\tEnter Job Card Status Description\r\n   \t\t\t\t </mat-error>\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6 text-center'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Due Hours\" [(ngModel)]=\"jcStatus.jcstatusDuehrs\" formControlName=\"jcstatusDuehrs\" required>\r\n\t\t\t\t<mat-error *ngIf=\"jcstatusDuehrs.hasError('required')\">\r\n      \t\t\t\t\tEnter Job Card Status Due Hours\r\n   \t\t\t\t </mat-error>\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6 text-center'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Level-1 Hours\" [(ngModel)]=\"jcStatus.jcstatusTrigger1Hrs\" formControlName=\"jcstatusTrigger1Hrs\" >\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6 text-center'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Level-2 Hours\" [(ngModel)]=\"jcStatus.jcstatusTrigger2Hrs\" formControlName=\"jcstatusTrigger2Hrs\" >\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6 text-center'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Level-3 Hours\" [(ngModel)]=\"jcStatus.jcstatusTrigger3Hrs\" formControlName=\"jcstatusTrigger3Hrs\" >\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6 text-center'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Level-4 Hours\" [(ngModel)]=\"jcStatus.jcstatusTrigger4Hrs\" formControlName=\"jcstatusTrigger4Hrs\">\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t<div class='col-md-6 text-center'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Level-5 Hours\" [(ngModel)]=\"jcStatus.jcstatusTrigger5Hrs\" formControlName=\"jcstatusTrigger5Hrs\" >\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t\r\n\t\t<div class='col-md-12 row' *ngIf=\"this.jcStatus.jcstatusEntryId \" style=\"margin-top: 2em;\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label>Entry By:</label> <a href=\"\">{{jcStatus.jcstatusEntryId}}</a>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label>Entry Date:</label> {{jcStatus.jcstatusEntryDate}}\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-12 row' *ngIf=\"this.jcStatus.jcstatusModifiedId \" style=\"margin-top: 2em;\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label>Modified By:</label> <a href=\"\">{{jcStatus.jcstatusModifiedId}}</a>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label>Modified Date:</label> {{jcStatus.jcstatusModifiedDate}}\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t\r\n\t\t <div class=\"col-md-12  btn-row\" *ngIf=\"this.jcstatusId=='0'\">\r\n\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Add </button> \r\n\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class=\"col-md-12  btn-row\" *ngIf=\"this.jcstatusId!='0'\"> \r\n\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button>\r\n\t\t\t <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button> \r\n\t\t\t <button  mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t</div>\r\n\t\t</div>\r\n\t</form>\t\r\n\t</mat-card>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return JcStatusAddComponent; });
/* unused harmony export JcStatusData */
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
var JcStatusAddComponent = (function () {
    function JcStatusAddComponent(_script, http, _router, route) {
        var _this = this;
        this._script = _script;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.jcstatusId = 0;
        this.jcStatus = new JcStatusData();
        this.msg = [];
        this.bootstrapFromValues = [];
        this.route.queryParams.filter(function (params) { return params.jcstatusId; }).subscribe(function (params) {
            if (params.jcstatusId != undefined) {
                _this.jcstatusId = params.jcstatusId;
            }
        });
        console.log("jcstatusId==" + this.jcstatusId);
        if (this.jcstatusId == 0) {
            this.status = "Add";
        }
        else {
            this.status = "Update";
            this.populateData();
        }
    }
    JcStatusAddComponent.prototype.ngOnInit = function () {
        this.jcStatusForm = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormGroup"]({
            'jcstatusName': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'jcstatusDesc': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'jcstatusDuehrs': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'jcstatusTrigger1Hrs': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusTrigger2Hrs': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusTrigger3Hrs': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusTrigger4Hrs': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusTrigger5Hrs': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusEntryId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusEntryDate': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusModifiedId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'jcstatusModifiedDate': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusName", {
        get: function () { return this.jcStatusForm.get('jcstatusName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusDesc", {
        get: function () { return this.jcStatusForm.get('jcstatusDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusDuehrs", {
        get: function () { return this.jcStatusForm.get('jcstatusDuehrs'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusTrigger1Hrs", {
        get: function () { return this.jcStatusForm.get('jcstatusTrigger1Hrs'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusTrigger2Hrs", {
        get: function () { return this.jcStatusForm.get('jcstatusTrigger2Hrs'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusTrigger3Hrs", {
        get: function () { return this.jcStatusForm.get('jcstatusTrigger3Hrs'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusTrigger4Hrs", {
        get: function () { return this.jcStatusForm.get('jcstatusTrigger4Hrs'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusTrigger5Hrs", {
        get: function () { return this.jcStatusForm.get('jcstatusTrigger5Hrs'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusEntryId", {
        get: function () { return this.jcStatusForm.get('jcsatusEntryId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusEntryDate", {
        get: function () { return this.jcStatusForm.get('jcsatusEntryDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusModifiedId", {
        get: function () { return this.jcStatusForm.get('jcstatusModifiedId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(JcStatusAddComponent.prototype, "jcstatusModifiedDate", {
        get: function () { return this.jcStatusForm.get('jcstatusModifiedDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    JcStatusAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/jcstatus-data ', JSON.stringify({ 'jcstatusId': this.jcstatusId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.jcStatus = data['populateData'][0];
            console.log("jcstatusModifiedId==" + _this.jcStatus.jcstatusModifiedId);
        }, function (err) {
            /* this function is executed when there's an ERROR */
            console.log("ERROR: " + err);
        });
    };
    JcStatusAddComponent.prototype.ngAfterViewInit = function () { };
    JcStatusAddComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/customer-group-list']); //path should be changed
    };
    JcStatusAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.jcStatus[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        if (!this.jcStatusForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.jcstatusId == 0) {
                this.jcStatus['requestType'] = 'add';
            }
            else {
                this.jcStatus['requestType'] = 'update';
                this.jcStatus['jcstatusId'] = this.jcstatusId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/jcstatus', JSON.stringify(this.jcStatus), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.jcStatusForm.reset();
                    _this.toggleAnimation();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
        console.log(this.jcStatus);
    };
    JcStatusAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.jcStatus['requestType'] = 'delete';
        this.jcStatus['jcstatusId'] = this.jcstatusId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/jcstatus', JSON.stringify(this.jcStatus), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
            _this.jcStatusForm.reset();
            //			 											this.list.getData();
        }, function (err) {
            console.log(err['error']['desc']);
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return JcStatusAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], JcStatusAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], JcStatusAddComponent.prototype, "toast", void 0);
JcStatusAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_4__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_5__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _e || Object])
], JcStatusAddComponent);

var JcStatusData = (function () {
    function JcStatusData() {
    }
    return JcStatusData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=jc-status-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-list.component.html":
/***/ (function(module, exports) {

module.exports = "   <router-outlet></router-outlet>\r\n   \r\n\t\t<div class=\"m-subheader\">\r\n\t \r\n\t\t\t<div class=\"d-flex align-items-center\">\r\n\t\t\t<div class=\"mr-auto\">\r\n\t\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tList Job Card Status\r\n\t\t\t\t</h3>\r\n\t\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\t<li class=\"m-nav__item m-nav__item--home\">\r\n\t\t\t\t\t\t<a href=\"#\" class=\"m-nav__link m-nav__link--icon\">\r\n\t\t\t\t\t\t\t<i class=\"m-nav__link-icon la la-home\"></i>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t\t-\r\n\t\t\t\t\t</li>\r\n\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t\t-\r\n\t\t\t\t\t</li>\r\n\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t<a href=\"/portal/manager/\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\tBusiness Manager\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t\t-\r\n\t\t\t\t\t</li>\r\n\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\tList  Job Card Status:\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t</ul>\r\n\t\t\t</div>\r\n\t\t\t<div>\r\n\t\t\t\r\n\t\t\t<button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add Job Card Status\r\n\t\t\t</button>\r\n<!--\t\t\t (click)=\"smartsearch.showsmart();\"-->\r\n\t\t\t\t<a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\r\n\t\t\t\t<div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\">\r\n\t\t\t\t\t<a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\">\r\n\t\t\t\t\t\t<i class=\"la la-plus m--hide\"></i>\r\n\t\t\t\t\t\t<i class=\"la la-ellipsis-h\"></i>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t\t<div class=\"m-dropdown__wrapper\">\r\n\t\t\t\t\t\t<span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n\t\t\t\t\t\t<div class=\"m-dropdown__inner\">\r\n\t\t\t\t\t\t\t<div class=\"m-dropdown__body\">\r\n\t\t\t\t\t\t\t\t<div class=\"m-dropdown__content\">\r\n\t\t\t\t\t\t\t\t\t<ul class=\"m-nav\">\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"m-nav__section m-nav__section--first m--hide\">\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__section-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tQuick Actions\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-share\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tActivity\r\n\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-chat-1\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tMessages\r\n\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-info\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tFAQ\r\n\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-lifebuoy\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tSupport\r\n\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tSubmit\r\n\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t</div>\r\n\r\n\t\r\n\t\t<div class=\"m-content\">\r\n\t\t<div class=\"m-portlet__body\">\r\n\r\n\r\n\t\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\" >\r\n\t\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\r\n\t\t\t\t\t\t\t<div class=\"example-container mat-elevation-z8\">\r\n\t\t\t\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\r\n\t\t</div>\r\n\t</div>\r\n\r\n\r\n\t "

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return JcStatusListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};















var JcStatusListComponent = (function () {
    function JcStatusListComponent(_script, http, _router) {
        this._script = _script;
        this.http = http;
        this._router = _router;
        //	@ViewChild(SmartSearchComponent)smart: SmartSearchComponent;
        this.flyInOutTrigger = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.jcstatusId = 0;
        this.msg = [];
    }
    JcStatusListComponent.prototype.ngAfterViewInit = function () {
    };
    JcStatusListComponent.prototype.ngOnInit = function () {
        this.list.listUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/service/jcstatus-list";
    };
    JcStatusListComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['service/jc-status-list/JCStatusadd'], { queryParams: { jcstatusId: this.jcstatusId } });
    };
    JcStatusListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    JcStatusListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    JcStatusListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'updateJCStatus') {
            this.jcstatusId = listParam[1];
            this.toggleAnimation();
            //			this.jcStatusForm.reset();
        }
    };
    return JcStatusListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], JcStatusListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]) === "function" && _a || Object)
], JcStatusListComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _b || Object)
], JcStatusListComponent.prototype, "toast", void 0);
JcStatusListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_14__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__angular_router__["Router"]) === "function" && _e || Object])
], JcStatusListComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=jc-status-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JcStatusListModule", function() { return JcStatusListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__jc_status_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__jc_status_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/service/job-card/jc-status/jc-status-add.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__jc_status_list_component__["a" /* JcStatusListComponent */]
            }
        ]
    }, {
        "path": "JCStatusadd",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__jc_status_add_component__["a" /* JcStatusAddComponent */],
            }
        ]
    }
];
var JcStatusListModule = (function () {
    function JcStatusListModule() {
    }
    return JcStatusListModule;
}());
JcStatusListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_8__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_9__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_12__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__jc_status_list_component__["a" /* JcStatusListComponent */], __WEBPACK_IMPORTED_MODULE_4__jc_status_add_component__["a" /* JcStatusAddComponent */]
        ],
    })
], JcStatusListModule);

//# sourceMappingURL=jc-status-list.module.js.map

/***/ })

});
//# sourceMappingURL=jc-status-list.module.chunk.js.map