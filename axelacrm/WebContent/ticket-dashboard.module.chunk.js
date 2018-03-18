webpackJsonp(["ticket-dashboard.module"],{

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket-dashboard/ticket-dashboard.component.html":
/***/ (function(module, exports) {

module.exports = "\t\r\n\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t Ticket Dashboard\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/home\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/mis\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tMIS\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tTicket Dashboard:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\r\n\t<div class=\"row\">\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t\tTickets for Today\r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"m-portlet__body row\" id=\"m_form_1\">\t\r\n\t\t\t\t\t<table>\r\n\t\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t\t<tr *ngFor=\"let tickets of tickets\">\r\n\t\t\t\t\t\t\t\t<td align=\"left\">{{opentickets.ticketstatusName}}</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr>\t\r\n\t\t\t\t\t\t\t\t<td align=\"right\"><a routerLink=\"/helpdesk/\">{{opentickets.ticketstatusId}}</a></td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</tbody>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\t\t\r\n\t\t\t\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tClosed Tickets for Today\r\n\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\r\n\t\t\t<div class=\"m-portlet__body row\" id=\"m_form_1\">\t\r\n\t\t\t\t\t<table>\r\n\t\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t\t<tr *ngFor=\"let tickets of tickets\">\r\n\t\t\t\t\t\t\t\t<td align=\"left\">{{ticketsfortoday.name}}</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr>\t\r\n\t\t\t\t\t\t\t\t<td align=\"right\"><a routerLink=\"/helpdesk/\">{{ticketsfortoday.count}}</a></td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</tbody>\r\n\t\t\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tOpen Tickets\r\n\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t<div class=\"m-portlet__body row\" id=\"m_form_1\">\t\r\n\t\t\t\t<table class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t\t<tr *ngFor=\"let opentickets of opentickets\">\r\n\t\t\t\t\t\t\t\t<td style=\"text-align: left\">{{opentickets.ticketstatusName}}</td>\r\n\t\t\t\t\t\t\t\t<td style=\"text-align: left;padding-left: 3em;\"><a routerLink=\"/helpdesk/\">{{opentickets.ticketstatusId}}</a></td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</tbody>\r\n\t\t\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\r\n\t\t\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\tQueues\r\n\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\r\n\t\t\t<div class=\"m-portlet__body row\" id=\"m_form_1\">\t\r\n\t\t\t\t<table class=\"table table-bordered table-hover data-filter=#filter\">\r\n\t\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t\t<tr *ngFor=\"let queues of queues\" align=center>\r\n\t\t\t\t\t\t\t\t<td style=\"text-align: left;\">{{queues.ticketstatusName}}</td>\r\n\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 3em;\" width=20% ><a routerLink=\"/helpdesk/\">{{queues.ticketstatusId}}</a></td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr rowspan=\"1\">\r\n\t\t\t\t\t\t\t\t<td style=\"text-align: right;\">Total</td>\r\n\t\t\t\t\t\t\t\t<td style=\"text-align: right;padding-left: 3em;\" width=20% >{{totalReportQueueOpen}}</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</tbody>\r\n\t\t\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tTickets Traffic \r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div class=\"m-portlet__body row\" id=\"m_form_1\">\t\r\n\t\t<table style='' class=\"table table-responsive table-striped table-bordered\">\r\n\t\t\t<thead>         \r\n\t\t\t</thead>\r\n\t\t\t<tbody>\r\n\t\t\t<tr align=\"center\">\r\n\t\t\t\t<td *ngFor=\"let daysDetails of daysDetails\">{{daysDetails.dayName}}<br><a routerLink=\"\">{{daysDetails.count}}</a></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr align=\"center\">\r\n\t\t\t\t<td colspan=\"8\">&nbsp;</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr align=\"center\">\r\n\t\t\t\t<td colspan=\"2\" *ngFor=\"let weeksDetails of weeksDetails\">{{weeksDetails.weekName}}<br><a routerLink=\"\">{{weeksDetails.count}}</a></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr align=\"center\">\r\n\t\t\t\t<td colspan=\"8\">&nbsp;</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr align=\"center\">\r\n\t\t\t\t<td  colspan=\"2\" *ngFor=\"let monthsDetails of monthsDetails\">{{monthsDetails.monthName}}<br><a routerLink=\"\">{{monthsDetails.count}}</a></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr align=\"center\">\r\n\t\t\t\t<td colspan=\"8\">&nbsp;</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr align=\"center\">\r\n\t\t\t\t<td colspan=\"2\" *ngFor=\"let quartersDetails of quartersDetails\">{{quartersDetails.qtrName}}<br><a routerLink=\"\">{{quartersDetails.count}}</a></td>\r\n\t\t\t</tr>\r\n\t\t\t</tbody>\r\n\t\t</table>\r\n\t\t</div>\r\n\t</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket-dashboard/ticket-dashboard.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TicketDashboardComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var TicketDashboardComponent = (function () {
    function TicketDashboardComponent(http, router, route) {
        this.http = http;
        this.router = router;
        this.route = route;
        this.ticketsfortoday = [];
        this.closedticketfortoday = [];
        this.opentickets = [];
        this.queues = [];
        this.traffic = [];
        this.daysDetails = [];
        this.weeksDetails = [];
        this.monthsDetails = [];
        this.quartersDetails = [];
    }
    TicketDashboardComponent.prototype.ngOnInit = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/helpdesk/report-ticket-dashboard', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.daysDetails = data['day'];
            _this.weeksDetails = data['week'];
            _this.monthsDetails = data['month'];
            _this.quartersDetails = data['quarter'];
            _this.ticketsfortoday = data['populateTicketReportStatus'];
            _this.closedticketfortoday = data['quarter'];
            _this.opentickets = data['populateTotalOpenRecordStatus'];
            _this.queues = data['populateTotalOpenRecordQueue'];
            _this.totalReportQueueOpen = data['TotalReportQueueOpen'];
        });
        console.log(this.daysDetails.length);
    };
    return TicketDashboardComponent;
}());
TicketDashboardComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket-dashboard/ticket-dashboard.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _c || Object])
], TicketDashboardComponent);

var _a, _b, _c;
//# sourceMappingURL=ticket-dashboard.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/helpdesk/ticket-dashboard/ticket-dashboard.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TicketDashboardModule", function() { return TicketDashboardModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ticket_dashboard_component__ = __webpack_require__("../../../../../src/app/theme/pages/helpdesk/ticket-dashboard/ticket-dashboard.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__ticket_dashboard_component__["a" /* TicketDashboardComponent */]
            }
        ]
    }
];
var TicketDashboardModule = (function () {
    function TicketDashboardModule() {
    }
    return TicketDashboardModule;
}());
TicketDashboardModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */],
            __WEBPACK_IMPORTED_MODULE_9__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["w" /* MatRadioModule */]
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__ticket_dashboard_component__["a" /* TicketDashboardComponent */]],
    })
], TicketDashboardModule);

//# sourceMappingURL=ticket-dashboard.module.js.map

/***/ })

});
//# sourceMappingURL=ticket-dashboard.module.chunk.js.map