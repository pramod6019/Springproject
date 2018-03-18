webpackJsonp(["current-stock-status-list.module"],{

/***/ "../../../../../src/app/theme/pages/inventory/current-stock-status/current-stock-status-list.component.html":
/***/ (function(module, exports) {

module.exports = "<toast></toast>\r\n\t\t\r\n\t\t<div class=\"m-subheader\">\t\t\t\r\n\t\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tCurrent Stock Status\r\n\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBusiness Manager\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tCurrent Stock Status:\r\n\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title \">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t{{status}} Bin \r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\r\n\t\r\n<!--\t\t\t\t[formGroup]=\"unitOfMeasurementForm\"-->\r\n\t<form (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\"  id=\"m_form_1\">\r\n\t\t\t \r\n\t\t<div class=\"m-portlet__body row\">\r\n\t\t\t<div class=\"col-md-12  btn-row\" > \r\n\t\t\t \t<button mat-button [disabled]=\"false\" (click)=\"onSubmit()\" class=\"btn btn-primary\"> Update Current Stock Status</button> \r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</form>\t\r\n<!--<mat-card>\t</mat-card>-->\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/inventory/current-stock-status/current-stock-status-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CurrentStockStatusListComponent; });
/* unused harmony export UnitOfMeasurementData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_startWith__ = __webpack_require__("../../../../rxjs/add/operator/startWith.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_startWith___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_startWith__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_observable_merge__ = __webpack_require__("../../../../rxjs/add/observable/merge.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_observable_merge___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_rxjs_add_observable_merge__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_debounceTime__ = __webpack_require__("../../../../rxjs/add/operator/debounceTime.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_debounceTime___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_rxjs_add_operator_debounceTime__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_distinctUntilChanged__ = __webpack_require__("../../../../rxjs/add/operator/distinctUntilChanged.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_distinctUntilChanged___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_distinctUntilChanged__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_observable_fromEvent__ = __webpack_require__("../../../../rxjs/add/observable/fromEvent.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_observable_fromEvent___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_rxjs_add_observable_fromEvent__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
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














var CurrentStockStatusListComponent = (function () {
    function CurrentStockStatusListComponent(_script, http, route) {
        this._script = _script;
        this.http = http;
        this.route = route;
        // private list: ListComponent;
        this.listHide = true;
        this.addHide = false;
        this.animateAdd = 'out';
        this.animateList = 'in';
        //unitOfMeasurementForm: FormGroup;
        this.opened = false;
        this.uomId = 0;
        this.pageValue = "1";
        this.sortField = "";
        this.sortDirection = "";
        this.length = 10;
        this.pageSize = 5;
        this.pageSizeOptions = [5, 10, 25, 100];
        this.pageIndex = 1;
        this.unitofmeasurement = new UnitOfMeasurementData();
        this.tag = "Unit Of Measurment";
        this.uoms = [];
        this.msg = [];
    }
    CurrentStockStatusListComponent.prototype.ngAfterViewInit = function () {
        if (!this.addHide) {
            this.addHide = true;
        }
    };
    CurrentStockStatusListComponent.prototype.DeleteData = function () {
        $(".secondSelect option:checked").remove();
    };
    CurrentStockStatusListComponent.prototype.ngOnInit = function () {
        this.listHide = false;
        this.animateAdd = 'out';
        this.animateList = 'in';
        //this.list.listUrl = sessionStorage.getItem('requestUrl')+"/axelacrm/customer/customer-list";
        //		this.unitOfMeasurementForm = new FormGroup({			
        //			'uomName' : new FormControl('', [ Validators.required]),
        //			'uomShortname' : new FormControl('', [ Validators.required]),
        //			'uomParentId' : new FormControl(''),
        //			'uomRatio' : new FormControl(''),
        //		});
    };
    //	get uomName(){ return this.unitOfMeasurementForm.get('uomName')};
    //	get uomShortname(){ return this.unitOfMeasurementForm.get('uomShortname')};
    //	get uomParentId(){ return this.unitOfMeasurementForm.get('uomParentId')};
    //	get uomRatio(){ return this.unitOfMeasurementForm.get('uomRatio')};
    //	 toggleAnimation(){
    //		 if(this.animateAdd == 'out' || this.animateList == 'in'){
    //			this.listHide = true;
    //			this.addHide = false;
    //			if(this.uomId == 0){
    //				this.populateDropDownData();
    //				this.unitofmeasurement = new UnitOfMeasurementData();
    //				this.status = 'Add';
    //			}else{
    //				this.populateData();
    //				this.status = 'Update';
    //			}
    //			this.animateList = 'out';
    //			this.animateAdd = 'in';
    //			this.unitOfMeasurementForm.reset();
    //		}else{
    //			this.addHide = true;
    //			this.listHide = false;
    //			this.unitOfMeasurementForm.reset();
    //			this.list.getData();
    //			this.animateAdd= 'out';
    //			this.animateList = 'in';
    //		}
    //	  }
    CurrentStockStatusListComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer/customer-data ', JSON.stringify({ 'uomId': this.uomId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.unitofmeasurement = data['populatadata'][0];
            console.log("uomModifiedId==" + _this.unitofmeasurement.uomModifiedId);
        }, function (err) {
            /* this function is executed when there's an ERROR */
            console.log("ERROR: " + err);
        });
    };
    //	  populateDropDownData(){
    //			  const headers = new HttpHeaders({'Content-Type':'application/json'});
    //			  this.http.post<any[]>(sessionStorage.getItem('requestUrl')+'/axelacrm/customer-populate/branch',
    //							 			JSON.stringify({ emp_id :'0'}),
    //									{ headers, withCredentials: true }).subscribe(data =>{
    //				  														this.uoms = data['populateBranch']
    //			  															});
    //			 	  
    //	 }
    CurrentStockStatusListComponent.prototype.listClickListener = function (listParam) {
        //		if(listParam[0] == 'updateUnitOfMeasurment'){
        //			this.uomId = listParam[1];
        //			this.toggleAnimation();
        //			//this.unitOfMeasurementForm.reset();
        //		}
    };
    CurrentStockStatusListComponent.prototype.onSubmit = function () {
        console.log("Curent stock Status Clicked");
        //		 if(!this.unitOfMeasurementForm.invalid){
        //			   const headers = new HttpHeaders({'Content-Type':'application/json'});
        //		if(this.uomId == 0){
        //			 this.unitofmeasurement['requestType'] = 'add';
        //			
        ////			this.customer['tag'] = 'customer';
        //		}else{
        //			this.unitofmeasurement['requestType'] = 'update';
        //			this.unitofmeasurement['uomId'] = this.uomId+'';
        //		}
        //		 this.http.post(sessionStorage.getItem('requestUrl')+'/axelacrm/customer/customer',
        //									JSON.stringify(this.unitofmeasurement),
        //						{ headers, withCredentials: true }).subscribe(data => {
        //			 											if(data['msg'].includes('Successfully')){
        //														this.msg[0]='success';
        //			 											this.msg[1]=data['msg'];
        //														}else{
        //														this.msg[0]='Error';
        //			 											this.msg[1]=data['msg'];
        //														}
        //			 											this.toast.showtoast(this.msg);
        //			 											this.toggleAnimation();
        //			 											this.unitOfMeasurementForm.reset();
        //			 											this.list.getData();
        //														},
        //														err =>{
        //			 												console.log(err['error']['desc']);
        //			 												this.msg[0]='Error';
        //			 												this.msg[1]=err['error'];
        //			 												this.toast.showtoast(this.msg);
        //		 												});
        //		 }
    };
    CurrentStockStatusListComponent.prototype.onDelete = function () {
        //		 this.unitofmeasurement['requestType'] = 'delete';
        //		 this.unitofmeasurement['uomId'] = this.uomId+'';
        //		 const headers = new HttpHeaders({'Content-Type':'application/json'});
        //		 this.http.post(sessionStorage.getItem('requestUrl')+'/axelacrm/customer/customer',
        //									JSON.stringify({ requestType : 'delete',
        //												   'uomId' : this.uomId }),
        //						{ headers, withCredentials: true }).subscribe(data => {
        //			 											if(data['msg'].includes('Successfully')){
        //														this.msg[0]='success';
        //			 											this.msg[1]=data['msg'];
        //														}else{
        //														this.msg[0]='Error';
        //			 											this.msg[1]=data['msg'];
        //														}
        //			 											this.toast.showtoast(this.msg);
        //			 											this.toggleAnimation();
        //			 											this.unitOfMeasurementForm.reset();
        //			 											this.list.getData();
        //														},
        //														err =>{
        //			 												console.log(err['error']['desc']);
        //			 												this.msg[0]='Error';
        //			 												this.msg[1]=err['error'];
        //			 												this.toast.showtoast(this.msg);
        //														});
    };
    return CurrentStockStatusListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_4__angular_material__["D" /* MatSort */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_4__angular_material__["D" /* MatSort */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_material__["D" /* MatSort */]) === "function" && _a || Object)
], CurrentStockStatusListComponent.prototype, "sort", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _b || Object)
], CurrentStockStatusListComponent.prototype, "toast", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_12__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_12__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_12__list_list_component__["a" /* ListComponent */]) === "function" && _c || Object)
], CurrentStockStatusListComponent.prototype, "list", void 0);
CurrentStockStatusListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/inventory/current-stock-status/current-stock-status-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */]],
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_11__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_11__angular_router__["ActivatedRoute"]) === "function" && _f || Object])
], CurrentStockStatusListComponent);

var UnitOfMeasurementData = (function () {
    function UnitOfMeasurementData() {
    }
    return UnitOfMeasurementData;
}());

var _a, _b, _c, _d, _e, _f;
//export class configDetails {
//	configCustomerSob:string;
//	configCustomerSoe:string;
//	configCustomerAddress:string;
//}
//# sourceMappingURL=current-stock-status-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/inventory/current-stock-status/current-stock-status-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CurrentStockStatusListModule", function() { return CurrentStockStatusListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__current_stock_status_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/inventory/current-stock-status/current-stock-status-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
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
                "component": __WEBPACK_IMPORTED_MODULE_0__current_stock_status_list_component__["a" /* CurrentStockStatusListComponent */]
            }
        ]
    }
];
var CurrentStockStatusListModule = (function () {
    function CurrentStockStatusListModule() {
    }
    return CurrentStockStatusListModule;
}());
CurrentStockStatusListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_3__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */],
            __WEBPACK_IMPORTED_MODULE_10__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_3__angular_router__["RouterModule"]],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_0__current_stock_status_list_component__["a" /* CurrentStockStatusListComponent */]
            //		,SmartSearchComponent
        ],
    })
], CurrentStockStatusListModule);

//# sourceMappingURL=current-stock-status-list.module.js.map

/***/ })

});
//# sourceMappingURL=current-stock-status-list.module.chunk.js.map