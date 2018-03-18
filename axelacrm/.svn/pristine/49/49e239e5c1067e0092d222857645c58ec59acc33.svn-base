webpackJsonp(["knowledge-base.module"],{

/***/ "../../../../../src/app/theme/pages/helpdesk/knowledge-base/knowledge-base.component.html":
/***/ (function(module, exports) {

module.exports = "<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br><div style=\"padding-left:40em\"class=\"col-md-12\"><span>Knowledge Base Work In Progress</span></div>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>\r\n<br>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/knowledge-base/knowledge-base.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return KnowledgeBaseComponent; });
/* unused harmony export TicketData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.component.ts");
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









var NUM_REGEX = /[0-9]/;
var WORD_REGEX = /w{5,}/;
var KnowledgeBaseComponent = (function () {
    function KnowledgeBaseComponent(http, route, router) {
        this.http = http;
        this.route = route;
        this.router = router;
        this.flyInOutTrigger = 'in';
        this.listHide = true;
        this.animateList = 'in';
        this.smartHide = true;
        this.animateSmart = 'out';
        this.contractId = 0;
        this.ticket = new TicketData();
        this.msg = [];
        this.branches = [];
        this.bootstrapFromValues = [];
        this.ticketSummaryData = [];
        this.reporttypes = [
            { key: '1', name: 'Contract Details' }
        ];
        this.exportformats = [
            { key: '1', name: 'MS Excel' },
            { key: '12', name: 'HTML' }
        ];
    }
    KnowledgeBaseComponent.prototype.ngOnInit = function () {
        this.listHide = true;
        this.animateList = 'out';
        this.populateDropDownData();
        //		this.populateData();
        if (this.ticketSummaryData.length > 0) {
            this.listHide = false;
        }
        this.ticketForm = new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormGroup"]({
            'branchsIds': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'exportformat': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
            'reporttype': new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(KnowledgeBaseComponent.prototype, "branchsIds", {
        get: function () { return this.ticketForm.get('branchsIds'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(KnowledgeBaseComponent.prototype, "exportformat", {
        get: function () { return this.ticketForm.get('exportformat'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(KnowledgeBaseComponent.prototype, "reporttype", {
        get: function () { return this.ticketForm.get('reporttype'); },
        enumerable: true,
        configurable: true
    });
    ;
    KnowledgeBaseComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branches = data['populateBranch'];
        });
    };
    KnowledgeBaseComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    KnowledgeBaseComponent.prototype.onSubmit = function () {
        var _this = this;
        this.listHide = false;
        this.bootstrapFromValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFromValues.length; i++) {
            this.ticket[this.bootstrapFromValues[i].name] = this.bootstrapFromValues[i].value;
        }
        this.ticket['requestType'] = 'landing';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket', JSON.stringify(this.ticket), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.ticketSummaryData = data['populateLandingDetails'];
            _this.grandTotal = data['grandTotal'];
        });
        console.log(this.ticket);
    };
    KnowledgeBaseComponent.prototype.populateData = function () {
        var _this = this;
        this.ticket['requestType'] = 'landing';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/ticket', JSON.stringify(this.ticket), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.ticketSummaryData = data['populateData'];
            _this.grandTotal = data['grandTotal'];
        });
        console.log(this.ticket);
    };
    return KnowledgeBaseComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _a || Object)
], KnowledgeBaseComponent.prototype, "smart", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], KnowledgeBaseComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], KnowledgeBaseComponent.prototype, "list", void 0);
KnowledgeBaseComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/knowledge-base/knowledge-base.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _e || Object])
], KnowledgeBaseComponent);

var TicketData = (function () {
    function TicketData() {
    }
    return TicketData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=knowledge-base.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/knowledge-base/knowledge-base.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KnowledgeBaseModule", function() { return KnowledgeBaseModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__knowledge_base_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/knowledge-base/knowledge-base.component.ts");
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
        "component": __WEBPACK_IMPORTED_MODULE_4__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_7__knowledge_base_component__["a" /* KnowledgeBaseComponent */],
            }
        ]
    }
];
var KnowledgeBaseModule = (function () {
    function KnowledgeBaseModule() {
    }
    return KnowledgeBaseModule;
}());
KnowledgeBaseModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_5__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_6__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_6__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_9__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_11__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["w" /* MatRadioModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_11__angular_material__["H" /* MatTabsModule */]
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_7__knowledge_base_component__["a" /* KnowledgeBaseComponent */]]
    })
], KnowledgeBaseModule);

//# sourceMappingURL=knowledge-base.module.js.map

/***/ })

});
//# sourceMappingURL=knowledge-base.module.chunk.js.map