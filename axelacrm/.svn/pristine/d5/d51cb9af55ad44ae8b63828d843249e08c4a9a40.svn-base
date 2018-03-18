webpackJsonp(["image.module"],{

/***/ "../../../../../src/app/theme/pages/portal/image/image.component.html":
/***/ (function(module, exports) {

module.exports = "\r\n\r\n<div class=\"m-subheader mr-auto\" >\r\n\t\r\n\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tImages\r\n\t\t</h3>\r\n\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tHome\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\tService\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"service/jobcard-list\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t Job Card Dash \r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"service/jobcard-list\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t List Images\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\r\n\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t<a href=\"service/jobcard-list\" class=\"m-nav__link\">\r\n\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t Add Images:\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</a>\r\n\t\t\t</li>\r\n\t\t</ul>\r\n\t</div>\r\n\r\n<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\tAdd Image\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\r\n\t<form [formGroup]=\"fileuploadForm\" (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" encryptTpye=\"multipart/formData\" id=\"m_form_1\">\r\n\t\t<div class=\"m-portlet__body row\">\r\n\t\t\t<div class=\"col-md-4\"></div>\r\n\t\t\t<div class=\"col-md-4\">\r\n\t\t\t\t<input class=\"form-control\" placrholder=\"Upload Image\" id=\"avatar\" (change)=\"onFileChange($event)\" #fileInput type=\"file\">\r\n\t\t\t\t<font size=\"1\">Click the Browse button to select the\r\n\t\t\t\t\t\t\t\t\t\t\t\t\timage from your computer!</font>\r\n\t\t\t</div>\r\n\t\t\t<div class=\"col-md-4\"></div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-12 btn-row\">\r\n\t\t\t <button mat-button [disabled]=\"false\" type=\"button\"(click)=\"onSubmit()\" class=\"btn btn-primary\"> Add </button> \r\n\t\t</div>\r\n\t\t</div>\r\n\t</form>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/image/image.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ImageComponent; });
/* unused harmony export ImageAdd */
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__services_validate_service__ = __webpack_require__("../../../../../src/app/_services/validate.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};










var ImageComponent = (function () {
    function ImageComponent(_script, http, _router, route, globalValid, formBuilder) {
        this._script = _script;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.globalValid = globalValid;
        this.formBuilder = formBuilder;
        this.flyInOutTrigger = 'in';
        this.msg = [];
        this.imageAdd = new ImageAdd();
        this.loading = false;
        this.creatForm();
    }
    ImageComponent.prototype.creatForm = function () {
        this.fileuploadForm = this.formBuilder.group({
            avatar: null
        });
    };
    ImageComponent.prototype.ngOnInit = function () {
    };
    ImageComponent.prototype.onFileChange = function (event) {
        var _this = this;
        var reader = new FileReader();
        if (event.target.files && event.target.files.length > 0) {
            var file_1 = event.target.files[0];
            reader.readAsDataURL(file_1);
            reader.onload = function () {
                _this.fileuploadForm.get('avatar').setValue({
                    filename: file_1.name,
                    filetype: file_1.type,
                    empId: '2',
                    jcId: '1023',
                    requestType: 'add',
                    file: reader.result.split(',')[1]
                });
            };
        }
    };
    ImageComponent.prototype.ngAfterViewInit = function () {
    };
    ImageComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['service/jobcard-list']);
    };
    ImageComponent.prototype.selectFile = function (event) {
        this.selectedFiles = event.target.files;
    };
    // 
    // private prepareSave():any{
    //	 let input =new FormData();
    //	 input.append('avatar' this.form.get('avatar').value);
    //	 return input;
    // }
    ImageComponent.prototype.onSubmit = function () {
        var _this = this;
        var formModel = this.fileuploadForm.value;
        //	 const formModel= this.prepareSave;
        //	 this.loading=true;
        console.log(formModel.avatar.file);
        var binaryImageData = atob(formModel.avatar.file);
        console.log("00000000" + binaryImageData);
        console.log(formModel.avatar.file.length);
        console.log(formModel);
        //	 setTimeout(()=>{console.log(formModel)
        //					alert('done!');
        //					 this.loading=false
        //					},1000);
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'multipart/form-data' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/app-sales/uploadjobcardimg?imageTitle=xyz.txt & jcId=1023 & requestType=add & file=' + formModel.avatar.file, {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
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
            //			  											this.toast.showtoast(this.msg);
            if (_this.msg[0] != 'Error') {
                //			 											this.fileForm.reset();
                _this.toggleAnimation();
            }
        }, function (err) {
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            //			 												this.toast.showtoast(this.msg);
        });
    };
    return ImageComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ImageComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ImageComponent.prototype, "toast", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])('fileInput'),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["ElementRef"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["ElementRef"]) === "function" && _b || Object)
], ImageComponent.prototype, "fileInput", void 0);
ImageComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/image/image.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_4__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_5__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _f || Object, typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_9__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_9__services_validate_service__["a" /* GlobalValidate */]) === "function" && _g || Object, typeof (_h = typeof __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormBuilder"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormBuilder"]) === "function" && _h || Object])
], ImageComponent);

var ImageAdd = (function () {
    function ImageAdd() {
    }
    return ImageAdd;
}());

var _a, _b, _c, _d, _e, _f, _g, _h;
//# sourceMappingURL=image.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/image/image.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageModule", function() { return ImageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__image_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/image/image.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__image_component__["a" /* ImageComponent */]
            }
        ]
    }
];
var ImageModule = (function () {
    function ImageModule() {
    }
    return ImageModule;
}());
ImageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */],
            __WEBPACK_IMPORTED_MODULE_10__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["E" /* MatSortModule */],
            __WEBPACK_IMPORTED_MODULE_10__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_10__angular_material__["w" /* MatRadioModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */]
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__image_component__["a" /* ImageComponent */]
        ],
    })
], ImageModule);

//# sourceMappingURL=image.module.js.map

/***/ })

});
//# sourceMappingURL=image.module.chunk.js.map