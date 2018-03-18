webpackJsonp(["locationlist.module"],{

/***/ "../../../../../src/app/theme/pages/Inventory/locationlist/location-add.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/* CSS Document */\r\n\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/theme/pages/Inventory/locationlist/location-add.component.html":
/***/ (function(module, exports) {

module.exports = "<toast></toast>\r\n<!--<div [hidden]=\"addHide\" [@roundAntiClockTrigger]=\"animateAdd\" class=\"example-scrolling-content\">\r\n  <div class=\"col-xl-4 order-1 order-xl-2 m--align-left\">\r\n    <a (click)=\"toggleAnimation()\" class=\"btn btn-primary m-btn m-btn--custom m-btn--icon m-btn--air m-btn--pill\"> <span> <i class=\"la flaticon-user\"></i> <span> List Locations </span> </span> </a>\r\n    <div class=\"m-separator m-separator--dashed d-xl-none\"></div>\r\n  </div>\r\n-->\r\n  <div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t{{status}} {{ configDetails.configInventoryLocationName  }}\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/inventory/inventory-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tInventory\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tList {{ configDetails.configInventoryLocationName  }}\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n  <div class=\"m-portlet m-portlet--mobile\">\r\n   <div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t\t{{status}} {{ configDetails.configInventoryLocationName }} \r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n    <form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" [formGroup]=\"locationForm\" id=\"m_form_1\">\r\n      <div class=\"m-portlet__body\">\r\n        <div class='col-md-12 row'>\r\n          <div class='col-md-6'>\r\n            <mat-form-field>\r\n              <mat-select placeholder=\"Select Branch\" [(ngModel)]=\"location.locationBranchId\" formControlName=\"locationBranchId\" required>\r\n                <mat-option *ngFor=\"let  branch of  branchs\" [value]=\" branch.key\"> {{  branch.name }} </mat-option>\r\n              </mat-select>\r\n              <mat-error *ngIf=\"locationBranchId.hasError('required')\"> Please Select Branch </mat-error>\r\n            </mat-form-field>\r\n          </div>\r\n          <div class='col-md-3'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"{{ configDetails.configInventoryLocationName }} Name\" [(ngModel)]=\"location.locationName\" formControlName=\"locationName\" maxlength=\"255\" required >\r\n              <mat-error *ngIf=\"locationName.hasError('required')\"> Please enter Name </mat-error>\r\n            </mat-form-field>\r\n          </div>\r\n          <div class='col-md-3'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"{{ configDetails.configInventoryLocationName }} Code\" [(ngModel)]=\"location.locationCode\" formControlName=\"locationCode\" maxlength=\"50\" required>\r\n              <mat-error *ngIf=\"locationCode.hasError('required')\"> Please enter Code </mat-error>\r\n            </mat-form-field>\r\n          </div>\r\n        </div>\r\n        <div class='col-md-12 row'>\r\n          <div class='col-md-3'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Mobile 1\"  [(ngModel)]=\"location.locationMobile1\" formControlName=\"locationMobile1\" maxlength=\"20\">\r\n              <mat-error *ngIf=\"locationMobile1.hasError('required')\"> Please enter Mobile 1 </mat-error>\r\n              <mat-error *ngIf=\"locationMobile1.hasError('pattern')\"> Please enter valid Mobile 1 </mat-error>\r\n              <mat-hint>(91-9999999999)</mat-hint>\r\n            </mat-form-field>\r\n          </div>\r\n          <div class='col-md-3'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Mobile 2\" [(ngModel)]=\"location.locationMobile2\" formControlName=\"locationMobile2\" maxlength=\"20\">\r\n              <mat-hint>(91-9999999999)</mat-hint>\r\n            </mat-form-field>\r\n          </div>\r\n          <div class='col-md-3'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Phone 1\" [(ngModel)]=\"location.locationPhone1\" formControlName=\"locationPhone1\" maxlength=\"20\">\r\n              <mat-hint>(91-80-33333333)</mat-hint>\r\n            </mat-form-field>\r\n          </div>\r\n          <div class='col-md-3'>\r\n            <mat-form-field >\r\n              <input matInput placeholder=\"Phone 2\" [(ngModel)]=\"location.locationPhone2\" formControlName=\"locationPhone2\" maxlength=\"20\">\r\n              <mat-hint>(91-80-33333333)</mat-hint>\r\n            </mat-form-field>\r\n          </div>\r\n        </div>\r\n        <div class='col-md-12 row'>\r\n          <div class='col-md-6'>\r\n            <mat-form-field>\r\n              <textarea matInput placeholder=\"Address\" matAutosizeMinRows=\"2\" [(ngModel)]=\"location.locationAddress\" formControlName=\"locationAddress\" maxlength=\"255\" required>\t\t\t\t\t\t\t\t\t\t\t\r\n    \t\t  </textarea>\r\n              <mat-error *ngIf=\"locationAddress.hasError('required')\"> Please enter Address </mat-error>\r\n            </mat-form-field>\r\n          </div> \r\n          <div class='col-md-3'>\r\n            <mat-form-field>\r\n              <mat-select placeholder=\"Select City\" [(ngModel)]=\"location.locationCityId\" formControlName=\"locationCityId\" required>\r\n                <mat-option *ngFor=\"let  city of  city\" [value]=\" city.key\"> {{  city.name }} </mat-option>\r\n              </mat-select>\r\n            </mat-form-field>\r\n          </div>\r\n          <div class='col-md-3'>\r\n            <mat-form-field>\r\n              <input matInput placeholder=\"Pin/Zip\" [(ngModel)]=\"location.locationPin\" formControlName=\"locationPin\" maxlength=\"6\" required>\r\n               </mat-form-field>\r\n          </div> \r\n        </div>\r\n        \r\n         <div class=\"row\" *ngIf=\"this.location.locationEntryId\">\r\n          <div class='col-md-6'>\r\n            <label>Entry By:</label>\r\n            {{location.locationEntryBy}} \r\n            </div>\r\n          <div class='col-md-6'>\r\n            <label>Entry Date:</label>\r\n            {{location.locationEntryDate}} \r\n            </div>\r\n\t\t  </div>\r\n           <div class=\"row\" *ngIf=\"this.location.locationModifiedId\">\r\n            \r\n          <div class='col-md-6'>\r\n            <label>Modified By: </label>\r\n            {{location.locationModifiedBy}} </div>\r\n          <div class='col-md-6'>\r\n            <label>Modified Date: </label>\r\n            {{location.locationModifiedDate}} </div>\r\n        </div>\r\n        \r\n        <div class='col-md-12 text-center' >\r\n         \r\n         <div class='btn-row' *ngIf=\"this.locationId == '0'\">\r\n              <button mat-button class=\"btn btn-primary\" > Add </button>\r\n              <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\"> Cancel </button>\r\n            </div>\r\n            \r\n            <div class='btn-row'  *ngIf=\"this.locationId != '0'\">\r\n             <button mat-button class=\"btn btn-primary\"> Update </button>\r\n              <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button>\r\n              \r\n              <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\"> Cancel </button>\r\n            </div>\r\n          </div>\r\n        \r\n        \r\n      </div>\r\n    </form>\r\n\t</div>\r\n<!--</div>-->"

/***/ }),

/***/ "../../../../../src/app/theme/pages/Inventory/locationlist/location-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LocationAddComponent; });
/* unused harmony export LocationData */
/* unused harmony export ConfigDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_filter__);
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
var LocationAddComponent = (function () {
    function LocationAddComponent(_script, router, route, http) {
        var _this = this;
        this._script = _script;
        this.router = router;
        this.route = route;
        this.http = http;
        this.listHide = true;
        this.addHide = false;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.passwordFormControl = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]);
        this.locationId = 0;
        this.pageValue = "1";
        this.sortField = "";
        this.sortDirection = "";
        this.length = 10;
        this.pageSize = 5;
        this.pageSizeOptions = [5, 10, 25, 100];
        this.pageIndex = 1;
        this.location = new LocationData();
        this.configDetails = new ConfigDetails();
        this.configInventoryLocationName = '';
        this.Status = "";
        this.branchs = [];
        this.city = [
            { key: '1', name: 'Bangalore' },
            { key: '2', name: 'Mysore' },
            { key: '3', name: 'Kerala' }
        ];
        this.msg = [];
        this.getConfigDetails();
        this.route.queryParams.filter(function (params) { return params.locationId; }).subscribe(function (params) {
            if (params.locationId != undefined) {
                _this.locationId = params.locationId;
            }
        });
        if (this.locationId == 0) {
            this.populateDropDownData();
            this.status = "Add";
        }
        else {
            this.status = "Update";
            this.populateData();
            this.listHide = true;
        }
    }
    LocationAddComponent.prototype.ngOnInit = function () {
        this.locationForm = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormGroup"]({
            'locationName': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'locationCode': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'locationBranchId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'locationMobile1': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'locationMobile2': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'locationPhone1': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'locationPhone2': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'locationPin': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'locationAddress': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'locationCityId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required])
        });
    };
    Object.defineProperty(LocationAddComponent.prototype, "locationName", {
        get: function () { return this.locationForm.get('locationName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationCode", {
        get: function () { return this.locationForm.get('locationCode'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationBranchId", {
        get: function () { return this.locationForm.get('locationBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationAddress", {
        get: function () { return this.locationForm.get('locationAddress'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationCityId", {
        get: function () { return this.locationForm.get('locationCityId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationPin", {
        get: function () { return this.locationForm.get('locationPin'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationMobile1", {
        get: function () { return this.locationForm.get('locationMobile1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationMobile2", {
        get: function () { return this.locationForm.get('locationMobile2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationPhone1", {
        get: function () { return this.locationForm.get('locationPhone1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(LocationAddComponent.prototype, "locationPhone2", {
        get: function () { return this.locationForm.get('locationPhone2'); },
        enumerable: true,
        configurable: true
    });
    ;
    LocationAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', JSON.stringify({ emp_id: '0' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branchs = data['populateBranch'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configDetails = data['populateconfigdetails'][0];
            console.log(_this.configDetails);
        });
    };
    LocationAddComponent.prototype.getConfigDetails = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configDetails = data['populateconfigdetails'][0];
            console.log(_this.configDetails);
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
        });
    };
    LocationAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/inventory/location-data', JSON.stringify({ locationId: this.locationId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.location = data['populateData'][0];
            console.log(_this.location);
        }, function (err) {
            /* this function is executed when there's an ERROR */
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
        });
    };
    LocationAddComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['/Inventory/locationlist']);
    };
    LocationAddComponent.prototype.onSubmit = function () {
        var _this = this;
        if (!this.locationForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.locationId == 0) {
                this.location['requestType'] = 'add';
            }
            else {
                this.location['requestType'] = 'update';
                this.location['locationId'] = this.locationId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/inventory/location', JSON.stringify(this.location), { headers: headers, withCredentials: true }).subscribe(function (data) {
                //			                                            this.toast.showtoast(this.msg);										
                //			                                            this.toggleAnimation();
                //			 											this.locationForm.reset();
                //			 											this.list.getData();
                //														});
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
                    _this.toggleAnimation();
                    _this.locationForm.reset();
                    //this.list.getData();
                }
            }, function (err) {
                console.log(err['error']['desc']);
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    LocationAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.location['requestType'] = 'delete';
        this.location['locationId'] = this.locationId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/inventory/location', JSON.stringify(this.location), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (data['msg'].includes('Successfully')) {
                _this.msg[0] = 'success';
                _this.msg[1] = data['msg'];
            }
            else {
                _this.msg[0] = 'Error';
                _this.msg[1] = data['msg'];
            }
            _this.toast.showtoast(_this.msg);
            _this.toggleAnimation();
            _this.locationForm.reset();
            //   this.list.getData();
        }, function (err) {
            console.log(err['error']['desc']);
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return LocationAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_8__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_8__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_8__list_list_component__["a" /* ListComponent */]) === "function" && _a || Object)
], LocationAddComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _b || Object)
], LocationAddComponent.prototype, "toast", void 0);
LocationAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/Inventory/locationlist/location-add.component.html"),
        styles: [__webpack_require__("../../../../../src/app/theme/pages/Inventory/locationlist/location-add.component.css")],
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_4__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_5__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _f || Object])
], LocationAddComponent);

var LocationData = (function () {
    function LocationData() {
    }
    return LocationData;
}());

var ConfigDetails = (function () {
    function ConfigDetails() {
    }
    return ConfigDetails;
}());

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=location-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/Inventory/locationlist/locationlist.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\r\n\r\nng-sidebar-container {\r\n    height: calc(100vh - 18px) !important;\r\n  }\r\n  \r\n.mat-drawer{\r\n\tbackground-color: #F8F9F9;\r\n}\r\n\r\n  mat-sidenav {\r\n    background-color: #F8F9F9;\r\n    width: 100%;\r\n    height: auto;\r\n    margin:10px;\r\n/*     margin-right:10px; */\r\n/*    margin-top:13px;*/\r\n  }\r\n  \r\n.example-form {\r\n  min-width: 150px;\r\n/*  max-width: 500px;*/\r\n  width: 100%;\r\n}\r\n\r\n.example-full-width {\r\n  width: 100%;\r\n}\r\n\r\nmat-card {\r\n\twidth: 100%;\r\n\tmargin: 10px;\r\n\theight: auto;\r\n\tbox-shadow: (-4px, -3px, 4px, -1px, grey);\r\n}\r\n  \r\n.example-container {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n  min-width: 300px;\r\n}\r\n\r\n.mat-form-field {\r\n  font-size: 15px;\r\n  -webkit-box-flex: 1;\r\n      -ms-flex-positive: 1;\r\n          flex-grow: 1;\r\n  margin-left: 32px;\r\n  width: 97%; \r\n\tpadding-top: 18px;\r\n}\r\n.mat-checkbox {\r\n\t\r\n  font-size: 14px;\r\n  -webkit-box-flex: 12;\r\n      -ms-flex-positive: 12;\r\n          flex-grow: 12;\r\n  margin-left: 32px;\r\n  width: 400px;\r\n}\r\n\r\n.button-row{\r\n\tdisplay: -webkit-box;\r\n\tdisplay: -ms-flexbox;\r\n\tdisplay: flex;\r\n\t-webkit-box-align: center;\r\n\t    -ms-flex-align: center;\r\n\t        align-items: center;\r\n/*\tjustify-content: space-around;*/\r\n}\r\n\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/theme/pages/Inventory/locationlist/locationlist.component.html":
/***/ (function(module, exports) {

module.exports = "\r\n<div [hidden]=\"listHide\" [@roundAntiClockTrigger]=\"animateList\" class=\"example-scrolling-content\">\r\n  <div class=\"m-subheader\">\r\n    <div class=\"d-flex align-items-center\">\r\n      <div class=\"mr-auto\">\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\"> List {{ configDetails.configInventoryLocationName }}</h3>\r\n        <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n<!--          <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>-->\r\n          <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/inventory/inventory-dashboard\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Inventory </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a href=\"/Inventory/locationlist\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\">  List {{ configDetails.configInventoryLocationName }}: </span> </a> </li>\r\n        </ul>\r\n      </div>\r\n      <div>\r\n      <button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> \r\n\t\t\t\t\tAdd {{ configDetails.configInventoryLocationName }}\r\n\t\t</button>\r\n      <a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\">\r\n      <i class=\"fa fa-search\"></i></a>\r\n\t  <a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\">\r\n\t  <i class=\"fa fa-share\"></i></a>\r\n\t\t\t   \r\n        <div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" \r\n        data-dropdown-toggle=\"hover\" aria-expanded=\"true\"> <a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  \r\n        m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\"> \r\n        <i class=\"la la-plus m--hide\"></i> <i class=\"la la-ellipsis-h\"></i> </a>\r\n          <div class=\"m-dropdown__wrapper\"> <span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n            <div class=\"m-dropdown__inner\">\r\n              <div class=\"m-dropdown__body\">\r\n                <div class=\"m-dropdown__content\">\r\n                  <ul class=\"m-nav\">\r\n                    <li class=\"m-nav__section m-nav__section--first m--hide\"> <span class=\"m-nav__section-text\"> Quick Actions </span> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-share\"></i> \r\n                    <span class=\"m-nav__link-text\"> Activity </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-chat-1\"></i>\r\n                     <span class=\"m-nav__link-text\"> Messages </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-info\"></i>\r\n                     <span class=\"m-nav__link-text\"> FAQ </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-lifebuoy\"></i>\r\n                     <span class=\"m-nav__link-text\"> Support </span> </a> </li>\r\n                    <li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n                    <li class=\"m-nav__item\"> <a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\"> Submit </a> </li>\r\n                  </ul>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <!-- END: Subheader -->\r\n  \r\n<div class=\"m-content\">\r\n\t<div class=\"m-portlet__body\">\r\n\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>  \r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/Inventory/locationlist/locationlist.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LocationListComponent; });
/* unused harmony export ConfigDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_startWith__ = __webpack_require__("../../../../rxjs/add/operator/startWith.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_startWith___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_startWith__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_observable_merge__ = __webpack_require__("../../../../rxjs/add/observable/merge.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_observable_merge___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_rxjs_add_observable_merge__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_debounceTime__ = __webpack_require__("../../../../rxjs/add/operator/debounceTime.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_debounceTime___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_debounceTime__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_operator_distinctUntilChanged__ = __webpack_require__("../../../../rxjs/add/operator/distinctUntilChanged.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_operator_distinctUntilChanged___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_rxjs_add_operator_distinctUntilChanged__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_rxjs_add_observable_fromEvent__ = __webpack_require__("../../../../rxjs/add/observable/fromEvent.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_rxjs_add_observable_fromEvent___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_13_rxjs_add_observable_fromEvent__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
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
var LocationListComponent = (function () {
    function LocationListComponent(_script, router, http) {
        this._script = _script;
        this.router = router;
        this.http = http;
        this.listHide = true;
        this.addHide = false;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.configDetails = new ConfigDetails();
        this.configInventoryLocationName = ' ';
        this.locationId = 0;
        this.getConfigDetails();
    }
    LocationListComponent.prototype.ngOnInit = function () {
        this.listHide = false;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.list.listUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/inventory/location-list";
    };
    LocationListComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['Inventory/locationlist/location-add'], { queryParams: { locationId: this.locationId } });
        //		if(this.animateAdd == 'out' || this.animateList == 'in'){
        //			this.listHide = true;
        //			this.addHide = false;
        //			if(this.locationId == 0){
        //				this.populateDropDownData();
        //				this.location = new LocationData();
        //				this.Status ='Add';
        //			}else{
        //				this.populateData();
        //				this.Status ='Update';
        //			}
        //			this.animateList = 'out';
        //			this.animateAdd = 'in';
        //		}else{
        //			this.addHide = true;
        //			this.listHide = false;
        //			this.locationForm.reset();
        //			this.list.getData();
        //			this.animateAdd= 'out';
        //			this.animateList = 'in';
        //		}
    };
    LocationListComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configDetails = data['populateconfigdetails'][0];
            console.log(_this.configDetails);
        });
        //		  this.http.post<any[]>(sessionStorage.getItem('requestUrl')+'/axelacrm/customer-populate/configdetails',{},
        //									{ headers, withCredentials: true }).subscribe(data =>{
        //				  														this.configDetails = data['populateconfigdetails'][0];
        //				  														console.log(this.configDetails);
        //			  															});
        //			  this.http.post<any[]>(sessionStorage.getItem('requestUrl')+'/axelacrm/customer-populate/city',
        //							 			JSON.stringify({ emp_id :'0'}),
        //									{ headers, withCredentials: true }).subscribe(data =>{
        //				  														this.branchs = data['populatecity']
        //			  															});
    };
    LocationListComponent.prototype.getConfigDetails = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configDetails = data['populateconfigdetails'][0];
            console.log(_this.configDetails);
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
        });
    };
    LocationListComponent.prototype.populateData = function () {
        //			  	const headers = new HttpHeaders({'Content-Type':'application/json'});
        //			   this.http.post<LocationData>(sessionStorage.getItem('requestUrl')+'/axelacrm/inventory/location-data',
        //							 			JSON.stringify({ locationId :this.locationId}),
        //									{ headers, withCredentials: true }).subscribe(data =>{
        //				  														this.location = data['populateData'][0];
        //																		console.log(this.location);
        //			  															},
        //															 (err) => {
        //																	/* this function is executed when there's an ERROR */
        //																	console.log("ERROR: "+err);
        //															 },
        //															 () => {
        //			  														this.populateDropDownData();								
        //															 });
    };
    LocationListComponent.prototype.ngAfterViewInit = function () {
        if (!this.addHide) {
            this.addHide = true;
        }
        else {
            this.addHide = false;
        }
    };
    LocationListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'updateWarehouse') {
            this.locationId = listParam[1];
            this.toggleAnimation();
        }
    };
    LocationListComponent.prototype.onDelete = function () {
        //		  this.location['requestType'] = 'delete';
        //		 this.location['locationId'] = this.locationId+'';
        //		 const headers = new HttpHeaders({'Content-Type':'application/json'});
        //		 this.http.post(sessionStorage.getItem('requestUrl')+'/axelacrm/inventory/location',
        //									JSON.stringify(this.location),
        //						{ headers, withCredentials: true }).subscribe(data => { 
        //		                           if(data['msg'].includes('Successfully')){
        //															this.msg[0]='success';
        //				 											this.msg[1]=data['msg'];
        //															}else{
        //															this.msg[0]='Error';
        //				 											this.msg[1]=data['msg'];
        //															}
        //				 											this.toast.showtoast(this.msg);
        //				 											this.toggleAnimation();
        //				 											this.locationForm.reset();
        //		                                                     this.list.getData();
        //															},
        //															err =>{
        //				 												console.log(err['error']['desc']);
        //				 												this.msg[0]='Error';
        //				 												this.msg[1]=err['error'];
        //				 												this.toast.showtoast(this.msg);
        //			 												});
    };
    LocationListComponent.prototype.onSubmit = function () {
        //		  if(!this.locationForm.invalid){
        //			  const headers = new HttpHeaders({'Content-Type':'application/json'});
        // 		if(this.locationId == 0){
        //			this.location['requestType'] = 'add';
        //		}else{
        //			this.location['requestType'] = 'update';
        //			this.location['locationId'] = this.locationId+'';
        //		}
        //		 this.http.post(sessionStorage.getItem('requestUrl')+'/axelacrm/inventory/location',
        //									JSON.stringify(this.location),
        //						{ headers, withCredentials: true }).subscribe(data => {
        ////			                                            this.toast.showtoast(this.msg);										
        ////			                                            this.toggleAnimation();
        ////			 											this.locationForm.reset();
        ////			 											this.list.getData();
        ////														});
        //			  
        //			  if(data['successmsg'] == undefined){
        //														this.msg[0]='Error';
        //			 											this.msg[1]=data['errormsg'];
        //														}else{
        //														if(data['successmsg'].includes('Successfully')){
        //														this.msg[0]='success';
        //			 											this.msg[1]=data['successmsg'];
        //														
        //														}
        //														}
        //			  											this.toast.showtoast(this.msg);
        //			  											if(this.msg[0]!='Error'){
        //														this.toggleAnimation();
        //			 											this.locationForm.reset();
        //														this.list.getData();
        //														}
        //														},
        //														err =>{
        //			 												console.log(err['error']['desc']);
        //			 												this.msg[0]='Error';
        //			 												this.msg[1]=err['error'];
        //			 												this.toast.showtoast(this.msg);
        //		 												});
        //			  
        //		  }
    };
    return LocationListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__angular_material__["D" /* MatSort */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__angular_material__["D" /* MatSort */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_material__["D" /* MatSort */]) === "function" && _a || Object)
], LocationListComponent.prototype, "sort", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_14__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_14__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], LocationListComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _c || Object)
], LocationListComponent.prototype, "toast", void 0);
LocationListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/Inventory/locationlist/locationlist.component.html"),
        styles: [__webpack_require__("../../../../../src/app/theme/pages/Inventory/locationlist/locationlist.component.css")],
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _f || Object])
], LocationListComponent);

var ConfigDetails = (function () {
    function ConfigDetails() {
    }
    return ConfigDetails;
}());

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=locationlist.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/Inventory/locationlist/locationlist.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LocationListModule", function() { return LocationListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__locationlist_component__ = __webpack_require__("../../../../../src/app/theme/pages/Inventory/locationlist/locationlist.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__location_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/Inventory/locationlist/location-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
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
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_3__locationlist_component__["a" /* LocationListComponent */]
            }
        ]
    }, {
        "path": "location-add",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__location_add_component__["a" /* LocationAddComponent */],
            }
        ]
    }
];
var LocationListModule = (function () {
    function LocationListModule() {
    }
    return LocationListModule;
}());
LocationListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_8__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_8__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_9__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__["a" /* ToastModule */],
            __WEBPACK_IMPORTED_MODULE_11__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["w" /* MatRadioModule */],
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__locationlist_component__["a" /* LocationListComponent */], __WEBPACK_IMPORTED_MODULE_4__location_add_component__["a" /* LocationAddComponent */],
        ],
    })
], LocationListModule);

//# sourceMappingURL=locationlist.module.js.map

/***/ })

});
//# sourceMappingURL=locationlist.module.chunk.js.map