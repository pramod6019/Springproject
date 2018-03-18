webpackJsonp(["config-inventory.module"],{

/***/ "../../../../../src/app/theme/pages/portal/manager/inv/configure-inventory/config-inventory.component.html":
/***/ (function(module, exports) {

module.exports = "\t<toast></toast>\r\n\t<div class=\"m-subheader mr-auto\" >\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tConfigure Inventory\r\n\t\t\t</h3>\r\n         <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBusiness Manager\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tInventory\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/configure-inventory\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tConfigure Inventory:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\t\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t\r\n\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tConfigure Inventory\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\t\r\n    \t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\"\tid=\"m_form_1\"    [formGroup]=\"configureInventoryForm\">\r\n     \r\n     <div class=\"m-portlet__body row\">\r\n     \r\n      <div class='col-md-3'></div>\r\n        <div class='col-md-6' style=\"padding:.5em\">\r\n\t\t  <label>Maintain Currrent Stock:</label> \r\n\t\t <mat-checkbox [ngModel]=\"globalValid.getCheckValue(configureinventory.configInventoryCurrentStock)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configureinventory, objKey:'configInventoryCurrentStock'})\" formControlName=\"configInventoryCurrentStock\"></mat-checkbox>\r\n\t\t</div>\r\n       <div class='col-md-3'></div>\r\n       \r\n        <div class='col-md-3'></div>\r\n         <div class='col-md-6' style=\"padding:.5em\">\r\n\t\t  <label>Purchase Order Ref. No.:</label> \r\n\t\t  <mat-checkbox [ngModel]=\"globalValid.getCheckValue(configureinventory.configInventoryPoRefno)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:configureinventory, objKey:'configInventoryPoRefno'})\" formControlName=\"configInventoryPoRefno\">\r\n            </mat-checkbox>\t\r\n       </div>\r\n      <div class='col-md-3'></div> \r\n        \r\n         <div class='col-md-3'></div>\r\n          <div class='col-md-6' style=\"margin-left: -0.77em;\">\r\n            <mat-form-field>\r\n            <input required matInput placeholder=\"Location Name\"  [(ngModel)]=\"configureinventory.configInventoryLocationName\" formControlName=\"configInventoryLocationName\" maxlength=\"255\">\r\n           </mat-form-field>\r\n\t\t</div>\r\n       <div class='col-md-3'></div>\r\n       \r\n        <div class=\"col-md-12 btn-row\">\r\n\t\t  <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button> \r\n\t\t</div>\r\n\t\t\r\n\t</div>\r\n      </form>\r\n\t</div>\r\n\t\t\r\n\t\t\t\r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/inv/configure-inventory/config-inventory.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ConfigureInventoryComponent; });
/* unused harmony export configureInventoryData */
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__services_validate_service__ = __webpack_require__("../../../../../src/app/_services/validate.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};















var ConfigureInventoryComponent = (function () {
    function ConfigureInventoryComponent(globalValid, http, _router, route) {
        this.globalValid = globalValid;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.bootstrapFromValues = [];
        this.jcId = "0";
        this.configId = "1";
        this.configureinventory = new configureInventoryData();
        this.msg = [];
        this.status = "Update";
        this.populateData();
    }
    ConfigureInventoryComponent.prototype.ngOnInit = function () {
        this.configureInventoryForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'configInventoryCurrentStock': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'configInventoryPoRefno': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'configInventoryLocationName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(ConfigureInventoryComponent.prototype, "configInventoryCurrentStock", {
        get: function () { return this.configureInventoryForm.get('configInventoryCurrentStock'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigureInventoryComponent.prototype, "configInventoryPoRefno", {
        get: function () { return this.configureInventoryForm.get('configInventoryPoRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ConfigureInventoryComponent.prototype, "configInventoryLocationName", {
        get: function () { return this.configureInventoryForm.get('configInventoryLocationName'); },
        enumerable: true,
        configurable: true
    });
    ;
    ConfigureInventoryComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/inventory/inventory-configuration-data', { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configureinventory = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        });
    };
    ConfigureInventoryComponent.prototype.getCheckValues = function (temp) {
        return this.globalValid.getCheckValue(temp);
    };
    ConfigureInventoryComponent.prototype.onSubmit = function () {
        var _this = this;
        console.log(this.configureinventory);
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.configureinventory[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        if (!this.configureInventoryForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.configureinventory['requestType'] = 'update';
            this.configureinventory['configId'] = this.configId + '';
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/inventory/inventory-configuration', JSON.stringify(this.configureinventory), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.configureInventoryForm.reset();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    return ConfigureInventoryComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ConfigureInventoryComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ConfigureInventoryComponent.prototype, "toast", void 0);
ConfigureInventoryComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/manager/inv/configure-inventory/config-inventory.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_14__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__services_validate_service__["a" /* GlobalValidate */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _e || Object])
], ConfigureInventoryComponent);

var configureInventoryData = (function () {
    function configureInventoryData() {
    }
    return configureInventoryData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=config-inventory.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/inv/configure-inventory/config-inventory.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ConfigureInventoryModule", function() { return ConfigureInventoryModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__config_inventory_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/manager/inv/configure-inventory/config-inventory.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__config_inventory_component__["a" /* ConfigureInventoryComponent */]
            }
        ]
    }
];
var ConfigureInventoryModule = (function () {
    function ConfigureInventoryModule() {
    }
    return ConfigureInventoryModule;
}());
ConfigureInventoryModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */],
            __WEBPACK_IMPORTED_MODULE_10__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_3__config_inventory_component__["a" /* ConfigureInventoryComponent */]
            //		,SmartSearchComponent
        ],
    })
], ConfigureInventoryModule);

//# sourceMappingURL=config-inventory.module.js.map

/***/ })

});
//# sourceMappingURL=config-inventory.module.chunk.js.map