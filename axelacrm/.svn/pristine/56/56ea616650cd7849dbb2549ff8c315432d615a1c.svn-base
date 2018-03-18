webpackJsonp(["assets-list.module"],{

/***/ "../../../../../src/app/theme/pages/service/assets/assets-add.component.html":
/***/ (function(module, exports) {

module.exports = "<toast></toast>\r\n\t<div class=\"m-subheader mr-auto\" >\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t{{status}} Asset\r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a routerLink=\"/service/service-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tService\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a routerLink=\"/service/asset\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tAssets\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tAssets List:\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t</ul>\r\n\t</div>\r\n\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t{{status}} Asset\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t  \t\t<form  (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"assetForm\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n\t\t<div class='col-md-6' style=\"padding-top: 1.6em\">\r\n\t\t\t<select class='form-control' style=\"margin-top:1em\" id='customer' name='assetCustomerId' placeholder=\"Customer Name\">\r\n\t\t\t</select>\r\n\t\t\t<span [innerHTML]=\"assetcustomermsg\"></span>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Asset Name\" [(ngModel)]=\"asset.assetName\" formControlName=\"assetName\"  maxlength=\"255\" required>\t\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\r\n\t\t<div class='col-md-6'>\r\n\t\t<mat-form-field>\r\n\t\t\t<textarea matInput placeholder=\"Description\" matAutosizeMinRows=\"2\" [(ngModel)]=\"asset.assetDesc\" formControlName=\"assetDesc\" \r\n\t\t\t\t maxlength=\"2000\">\r\n\t\t\t\t{{asset.assetDesc}}\r\n\t\t\t</textarea>\r\n\t\t\t<mat-hint>(2000 Characters)</mat-hint>\r\n\t\t\t\r\n\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Serial\" [(ngModel)]=\"asset.assetSerial\" formControlName=\"assetSerial\"  maxlength=\"50\" required>\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Tag\" [(ngModel)]=\"asset.assetTag\" formControlName=\"assetTag\"  maxlength=\"50\">\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Type\" [(ngModel)]=\"asset.assetContractassettypeId\" \r\n\t\t\t\t \tformControlName=\"assetContractassettypeId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  type of  type\" [value]=\"type.key\">\r\n\t\t\t\t  {{  type.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<mat-select placeholder=\"Select Brand\" [(ngModel)]=\"asset.assetAssetbrandId\" formControlName=\"assetAssetbrandId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  brand of  brand\" [value]=\"brand.key\">\r\n\t\t\t\t  {{  brand.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Location\" [(ngModel)]=\"asset.assetContractlocId\" formControlName=\"assetContractlocId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let location of  location\" [value]=\"location.key\">\r\n\t\t\t\t  {{  location.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput class='datepicker' placeholder=\"Aquired Date\" [value]=\"asset.assetPurchaseDate\"\r\n\t\t\t\t\tname=\"assetPurchaseDate\"  maxlength=\"10\">\r\n\t\t\t  </mat-form-field>\r\n\t\t\t  <span [innerHTML]=\"assetpurchasedatemsg\"></span>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t<mat-form-field>\r\n\t\t\t<textarea matInput placeholder=\"Notes\" matAutosizeMinRows=\"2\" [(ngModel)]=\"asset.assetNotes\" formControlName=\"assetNotes\" \r\n\t\t\tmaxlength=\"255\" >\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t</textarea>\r\n\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<br>\r\n\t\t<div class='col-md-12 row' *ngIf=\"asset.assetEntryId\" style=\"margin-top: 2em;\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label>Entry By :</label> <a href=\"\">{{asset.assetEntryBy}}</a>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label> Entry Date :</label> {{asset.assetEntryDate}}\r\n\t\t\t</div>\r\n\t\t</div>\r\n       \r\n       <br>\r\n         <div class='col-md-12 row' *ngIf=\"asset.assetModifiedBy\" style=\"margin-top: 2em;\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label>Modified By : </label><a href=\"\">{{asset.assetModifiedBy}}</a>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<label>Modified Date : </label>{{asset.assetModifiedDate}}\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t <input  id=\"hidden\" #hidden (blur)=\"populateLocation(hidden.value)\" style=\"width: 0px;height: 0px;border: 0px\" >\r\n\t\t <br>\r\n\t\t\t <div class=\"col-md-12 btn-row\" *ngIf=\"status=='Add'\" style=\"padding-bottom: 1em;\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Add </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t \r\n\t\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"status=='Update'\" style=\"padding-bottom: 1em;\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button> \r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t</div>\t\r\n\t\t</form>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/assets/assets-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssetAddComponent; });
/* unused harmony export AssetData */
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
var AssetAddComponent = (function () {
    function AssetAddComponent(_script, http, _router, route) {
        var _this = this;
        this._script = _script;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.assetId = 0;
        this.asset = new AssetData();
        this.msg = [];
        this.bootstrapFormValues = [];
        this.bootstrapMsg = '';
        this.customer = [];
        this.location = [];
        this.type = [];
        this.brand = [];
        this.route.queryParams.filter(function (params) { return params.assetId; }).subscribe(function (params) {
            if (params.assetId != undefined) {
                _this.assetId = params.assetId;
            }
        });
        if (this.assetId == 0) {
            this.status = "Add";
            this.populateDropDownData();
        }
        else {
            this.status = "Update";
            this.populateData();
        }
    }
    AssetAddComponent.prototype.ngOnInit = function () {
        this.assetForm = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormGroup"]({
            'assetContractassettypeId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'assetAssetbrandId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'assetContractlocId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'assetName': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'assetSerial': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'assetTag': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'assetDesc': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'assetPurchaseDate': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'assetNotes': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(AssetAddComponent.prototype, "assetContractassettypeId", {
        get: function () { return this.assetForm.get('assetContractassettypeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetAssetbrandId", {
        get: function () { return this.assetForm.get('assetAssetbrandId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetContractlocId", {
        get: function () { return this.assetForm.get('assetContractlocId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetName", {
        get: function () { return this.assetForm.get('assetName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetSerial", {
        get: function () { return this.assetForm.get('assetSerial'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetTag", {
        get: function () { return this.assetForm.get('assetTag'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetDesc", {
        get: function () { return this.assetForm.get('assetDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetPurchaseDate", {
        get: function () { return this.assetForm.get('assetPurchaseDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(AssetAddComponent.prototype, "assetNotes", {
        get: function () { return this.assetForm.get('assetNotes'); },
        enumerable: true,
        configurable: true
    });
    ;
    AssetAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/servicecontractlocation', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.location = data['populateServiceContractLocation'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/type', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.type = data['populateType'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/brand', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.brand = data['populateBrand'];
        });
    };
    AssetAddComponent.prototype.populateLocation = function (value) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/servicecontractlocation', JSON.stringify({ assetCustomerId: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.location = data['populateServiceContractLocation'];
        });
    };
    AssetAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/service/asset-data', JSON.stringify({ assetId: this.assetId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.asset = data['populateData'][0];
            _this.populateLocation(_this.asset.assetCustomerId);
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
            _this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/customer-selectto?customerId=' + _this.asset.assetCustomerId, JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.asset.assetCustomer = data['results'][0].text;
                $('#customer').html('<option value=' + _this.asset.assetCustomerId + '>' + _this.asset.assetCustomer + '</option>');
            }, function (err) {
                console.log("ERROR: " + err);
            }, function () {
            });
        });
    };
    AssetAddComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/demo/default/custom/components/forms/widgets/select2.js', function () {
        });
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
        $("#customer").change(function () {
            //				alert($("#customer").val());
            $('#hidden').val($("#customer").val());
            $('#hidden').focus();
            $('#hidden').blur();
        });
    };
    AssetAddComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['service/assets-list']);
    };
    AssetAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.asset[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
            if (this.asset.assetCustomerId != undefined) {
                if (this.asset.assetCustomerId == '0') {
                    this.bootstrapMsg = this.bootstrapMsg + 'Plese Select Customer';
                    this.assetcustomermsg = "<font class='errorMsg'>Plese Select Customer</font>";
                }
                else {
                    this.assetcustomermsg = "";
                }
            }
            else {
                this.assetcustomermsg = "<font class='select2ErrorMsg'>Select Customer</font>";
            }
            if (this.bootstrapFormValues[i].name == "assetPurchaseDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter Start Date!<br>';
                    this.assetpurchasedatemsg = "<font class='errorMsg'>Select Date</font>";
                }
                else {
                    this.assetpurchasedatemsg = "";
                }
            }
        }
        if (this.bootstrapMsg != '') {
            this.msg[0] = 'Error';
            this.msg[1] = 'Enter the Mandatory Fields';
            this.toast.showtoast(this.msg);
            this.bootstrapMsg = '';
        }
        if (!this.assetForm.invalid && this.bootstrapMsg == '') {
            var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.assetId == 0) {
                this.asset['requestType'] = 'add';
            }
            else {
                this.asset['requestType'] = 'update';
                this.asset['assetId'] = this.assetId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/service/asset', JSON.stringify(this.asset), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                _this.assetForm.reset();
            }, function (err) {
                console.log(err['error']['desc']);
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    AssetAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.asset['requestType'] = 'delete';
        this.asset['assetId'] = this.assetId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/service/asset', JSON.stringify({ requestType: 'delete',
            'assetId': this.assetId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
            _this.assetForm.reset();
        }, function (err) {
            console.log(err['error']['desc']);
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return AssetAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], AssetAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], AssetAddComponent.prototype, "toast", void 0);
AssetAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/service/assets/assets-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_4__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_5__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _e || Object])
], AssetAddComponent);

var AssetData = (function () {
    function AssetData() {
        this.assetPurchaseDate = '';
    }
    return AssetData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=assets-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/assets/assets-list.component.html":
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\r\n\r\n<div class=\"m-subheader\">\r\n\t<div class=\"d-flex align-items-center\">\r\n\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tAssets List\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/service/service-dashboard\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tService\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/service/asset\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tAssets\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tAssets List:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t<div>\r\n\t\t\r\n\t\t<button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> New Asset\r\n\t\t</button>\r\n\t\t\t<a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n\t\t\t<div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\">\r\n\t\t\t\t<a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\">\r\n\t\t\t\t\t<i class=\"la la-plus m--hide\"></i>\r\n\t\t\t\t\t<i class=\"la la-ellipsis-h\"></i>\r\n\t\t\t\t</a>\r\n\t\t\t\t<div class=\"m-dropdown__wrapper\">\r\n\t\t\t\t\t<span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n\t\t\t\t\t<div class=\"m-dropdown__inner\">\r\n\t\t\t\t\t\t<div class=\"m-dropdown__body\">\r\n\t\t\t\t\t\t\t<div class=\"m-dropdown__content\">\r\n\t\t\t\t\t\t\t\t<ul class=\"m-nav\">\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__section m-nav__section--first m--hide\">\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__section-text\">\r\n\t\t\t\t\t\t\t\t\t\t\tQuick Actions\r\n\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-share\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tActivity\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-chat-1\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tMessages\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-info\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tFAQ\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-lifebuoy\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tSupport\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\">\r\n\t\t\t\t\t\t\t\t\t\t\tSubmit\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n\r\n<!--<smart-search></smart-search>-->\r\n<smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\" ></smart-search>\r\n\r\n<div class=\"m-content\">\r\n\t\r\n\t<div class=\"m-portlet__body\">\r\n\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t\r\n<!--\r\n\t\t\t\t<div class=\"m--align-right\">\r\n\t\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"btn btn-primary  m-btn m-btn--custom m-btn--icon m-btn--air m-btn--pill\">\r\n\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t<i class=\"la flaticon-user-add \"></i>\r\n\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\tNew Job Card\r\n\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<div class=\"m-separator m-separator--dashed d-xl-none\"></div>\r\n\t\t\t\t\t</div>\r\n-->\r\n\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n\t\r\n\t\r\n\t\r\n<!--</div>-->\r\n\r\n\r\n\r\n              \r\n\r\n\r\n\r\n\r\n              \r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/assets/assets-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssetListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
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








var AssetListComponent = (function () {
    function AssetListComponent(_script, http, router) {
        this._script = _script;
        this.http = http;
        this.router = router;
        this.flyInOutTrigger = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.assetId = 0;
    }
    AssetListComponent.prototype.ngOnInit = function () {
        this.smart.smartUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/service/asset-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + '/axelacrm/service/asset-list';
    };
    AssetListComponent.prototype.ngAfterViewInit = function () {
    };
    AssetListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    AssetListComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['service/assets-list/assets-add'], { queryParams: { assetId: this.assetId } });
    };
    AssetListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    AssetListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'updateAsset') {
            this.assetId = listParam[1];
            this.toggleAnimation();
        }
        if (listParam[0] == 'ticketList') {
            //			 this.asset.contactId=listParam[1];
            //			 this.asset.assetCustomerId=listParam[2];
            this.assetId = listParam[3];
            this.router.navigate(["/service/ticket-list"]);
            this.toggleAnimation();
        }
    };
    return AssetListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _a || Object)
], AssetListComponent.prototype, "smart", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], AssetListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], AssetListComponent.prototype, "list", void 0);
AssetListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/service/assets/assets-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _e || Object])
], AssetListComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=assets-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/service/assets/assets-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AssetListModule", function() { return AssetListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__assets_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/service/assets/assets-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__assets_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/service/assets/assets-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__assets_list_component__["a" /* AssetListComponent */]
            }
        ]
    }, {
        "path": "assets-add",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__assets_add_component__["a" /* AssetAddComponent */],
            }
        ]
    }
];
var AssetListModule = (function () {
    function AssetListModule() {
    }
    return AssetListModule;
}());
AssetListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_9__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_9__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_10__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_8__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_12__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__assets_list_component__["a" /* AssetListComponent */], __WEBPACK_IMPORTED_MODULE_4__assets_add_component__["a" /* AssetAddComponent */]],
    })
], AssetListModule);

//# sourceMappingURL=assets-list.module.js.map

/***/ })

});
//# sourceMappingURL=assets-list.module.chunk.js.map