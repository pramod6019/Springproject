webpackJsonp(["manager.module"],{

/***/ "../../../../../src/app/theme/pages/portal/manager/manager.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\r\n.mat-expansion-panel-header-title {\r\n    color: white;\r\n}\r\n\r\nmat-panel-title{\r\n\ttext-align: center;\r\n\tfont-size: 21px;\r\n\tfont-weight: bold;\r\n}\r\n\r\nmat-expansion-panel-header{\r\n\tbackground-color: darkkhaki;\r\n}\r\n\r\nmat-expansion-panel ul\r\n{\r\n\tpadding: 13px;\r\n}\r\n\r\nmat-expansion-panel li\r\n{\r\n\tpadding: 5px;\r\n\tfont-size:16px;\r\n\tmargin-left: 2px;\r\n}\r\n\r\nmat-expansion-panel .row\r\n{\r\n\tmargin-right: 0px;\r\n}\r\n\r\n.text-center\r\n{\r\n\tfont-size: 17px;\r\n\tfont-weight: bold;\r\n\tcolor: #676c7b;\r\n}\r\n\r\nmat-panel-description\r\n{\r\n\tmargin-right: 18em;\r\n\tcolor: white;\r\n\tfont-size: 18px;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/manager.component.html":
/***/ (function(module, exports) {

module.exports = "<base href = \"/\">\r\n   \r\n <div class=\"example-scrolling-content\">\r\n  <div class=\"m-subheader\">\r\n\t<div class=\"d-flex align-items-center\">\r\n\t\t<div class=\"mr-auto\">\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tBusiness Manager\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBusiness Manager:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t<div>\r\n\t\t\t\r\n\t\t\t<div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\">\r\n\t\t\t\t<a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\">\r\n\t\t\t\t\t<i class=\"la la-plus m--hide\"></i>\r\n\t\t\t\t\t<i class=\"la la-ellipsis-h\"></i>\r\n\t\t\t\t</a>\r\n\t\t\t\t<div class=\"m-dropdown__wrapper\">\r\n\t\t\t\t\t<span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n\t\t\t\t\t<div class=\"m-dropdown__inner\">\r\n\t\t\t\t\t\t<div class=\"m-dropdown__body\">\r\n\t\t\t\t\t\t\t<div class=\"m-dropdown__content\">\r\n\t\t\t\t\t\t\t\t<ul class=\"m-nav\">\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__section m-nav__section--first m--hide\">\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__section-text\">\r\n\t\t\t\t\t\t\t\t\t\t\tQuick Actions\r\n\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-share\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tActivity\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-chat-1\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tMessages\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-info\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tFAQ\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"m-nav__link-icon flaticon-lifebuoy\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t\t\t\t\t\tSupport\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n\t\t\t\t\t\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\">\r\n\t\t\t\t\t\t\t\t\t\t\tSubmit\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div> \r\n </div>\r\n<div class=\"m-content\">\r\n<mat-accordion>\r\n \r\n  <mat-expansion-panel [expanded]=\"expanded==true\">\r\n    <mat-expansion-panel-header style=\"background-color: darkkhaki;\">\r\n      <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tBussiness Manager\r\n\t\t  </mat-panel-title>\r\n\t\t</div>\r\n    </mat-expansion-panel-header>\r\n\r\n   <ul>\r\n   \t<li><a routerLink=\"/portal/executive-list\">Manage Executives</a></li>\r\n   \t<li><a routerLink=\"/portal/manager-configure\">Configure Axela</a></li>\r\n   </ul>\r\n   \r\n    \r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleActivity=='1'\" >\r\n<!--\r\n                      (opened)=\"panelOpenState = true\"\r\n                       (closed)=\"panelOpenState = false\"\r\n-->\r\n    <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n      <div class=\"col-md-5\">\r\n      <mat-panel-title>\r\n        Activity\r\n      </mat-panel-title>\r\n\t\t</div>\r\n      <div class=\"col-md-3\">\r\n\t\t   <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-activity\">Configure Activity</a>\r\n\t\t  </mat-panel-description>\r\n       </div>\r\n\t\t<div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   <ul>\r\n   \t<li><a routerLink=\"/portal/activity-status-list\">Activity Status</a></li>\r\n   \t<li><a routerLink=\"/portal/activity-type-list\">Activity Type</a></li>\r\n<!--<li><a routerLink=\"/service/jobcard-list/jobcard-dash\">JobCard Dash</a></li>-->\r\n   </ul>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleCustomer=='1'\">\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n      <mat-panel-title>\r\n        Customer\r\n      </mat-panel-title>\r\n\t\t </div>\r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-customer\">Configure Customer</a>\r\n\t\t  </mat-panel-description>\r\n\t</div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <ul>\r\n   \t<li><a routerLink=\"/portal/source-of-enquiry-list\">Source of Enquiry</a></li>\r\n   \t<li><a routerLink=\"/portal/source-of-business-list\">Source of Business</a></li>\r\n   \t<li><a routerLink=\"/portal/customer-group-list\">Groups</a></li>\r\n   \t<li><a routerLink=\"/portal/customer-title-list\">Title</a></li>\r\n   </ul>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModulePm=='1'\" >\r\n  <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tProject\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n       <div class=\"col-md-3\">\r\n\t\t   <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-project\">Configure Project</a>\r\n\t\t  </mat-panel-description>\r\n\t  </div>\r\n\t  <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   <ul>\r\n   \t<li><a routerLink=\"/portal/project-type-list\">Project Type</a></li>\r\n   </ul>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleMarketing=='1'\">\r\n  <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tMarketing\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n      <div class=\"col-md-3\">\r\n\t\t   <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-marketing\">Configure Marketing</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   <ul>\r\n   \t<li><a routerLink=\"/portal/project-type-list\">Project Type</a></li>\r\n   </ul>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleSales=='1'\" >\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tSales\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-sales\">Configure Sales</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">Opportunity</div>\r\n\t\t\t\t<li><a routerLink=\"/portal/source-of-enquiry-list\">Source of Enquiry</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/source-of-business-list\">Source of Business</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/campaign-type-list\">Campaign Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/stage-list\">Stage</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/follow-up-description-list\">Follow-up Description</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/crmdays-list\">CRM Days</a></li>\r\n\t\t\t</ul>\r\n\t   </div>\r\n\t   \r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">Priority</div>\r\n\t\t\t\t<li><a routerLink=\"/portal/priority-list\">Priority</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/brochure-list\">Brochure</a></li>\r\n\t\t\t\t\r\n\t\t   </ul>\r\n\t   </div>   \r\n\t\t \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<div class=\"text-center\">Others</div>\r\n\t\t\t\t<li><a routerLink=\"/portal/destination-list\">Destination</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/delivery-status-list\">Delivery Status</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/work-flow-doc-list\">Work Flow Documents</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/genwebenqfrm-list\">Generate Website Enquiry Form</a></li>\r\n\t\t\t</ul>\r\n\t\t</div>     \r\n   </div>\r\n   \r\n<!--\r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">Item</div>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-list\">Items</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-group-list\">Item Group</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/cat-list\">Categories</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/sales-list\">Sales Categories</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/model-list\">Model</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/uom-list\">Unit Of Measurement</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">Sales Order</div>\r\n\t\t\t<li><a routerLink=\"/portal/finance-company-list\">Head</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t</div>      \t\r\n-->\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleService=='1'\" >\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tService\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-service\">Configure Service</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">Contract</div>\r\n\t\t\t\t<li><a routerLink=\"/portal/service-type-list\">Service Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/contract-type-list\">Contract Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/contract-priority-list\">Contract Priority</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/asset-type-list\">Asset Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/asset-brand-list\">Asset Brand</a></li>\r\n\t\t   </ul>\r\n\t   </div>   \r\n\t\t \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<div class=\"text-center\">Job Card</div>\r\n\t\t\t\t<li><a routerLink=\"/service/jc-priority-list\">Priority</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/jc-category-list\">Category</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/jc-type-list\">Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/jc-bay-list\">Bay</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/jc-status-list\">Status</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/jc-psf-days-list\">PSF Days</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/jc-check-list\">Check List</a></li>\r\n\t\t\t</ul>\r\n\t\t</div>     \r\n   </div>\r\n   \r\n<!--\r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t  <div class=\"text-center\">Item</div>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-list\">Items</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/item-model-list\">Model</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/cat-list\">Categories</a></li>\r\n\t\t\t\t<li><a routerLink=\"/service/manage-uom-list\">Unit Of Measurement</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t</div>      \t\r\n-->\r\n  </mat-expansion-panel>\r\n    \r\n  <mat-expansion-panel *ngIf=\"compModuleInventory=='1'\">\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\"> \r\n\t\t  <mat-panel-title>\r\n\t\t\tInventory\r\n\t\t  </mat-panel-title>\r\n      </div>\r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-inventory\">Configure Inventory</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">Others</div>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">Tax</div>\r\n\t\t\t   <li><a routerLink=\"/portal/work-in-progress\">Item Group</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/categories-list\">Categories</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-model-list\">Item Model</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/unit-of-measurement-list\">Unit Of Measurement</a></li>\r\n\t\t   </ul>\r\n\t   </div>   \r\n\t\t \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<div class=\"text-center\">&nbsp;</div>\r\n\t\t\t\t<li><a routerLink=\"/inventory/current-stock-status-list\">Current Stock Status</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/tax-list\">Tax</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/work-in-progress\">Item Batch</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/work-in-progress\">Voucher Type</a></li>\r\n\t\t\t</ul>\r\n\t\t</div>     \r\n   </div>\r\n   \r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleAccounting=='1'\" >\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\"> \r\n\t\t  <mat-panel-title>\r\n\t\t\tAccounting\r\n\t\t  </mat-panel-title>\r\n      </div>\r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-accounting\">Configure Accounting</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\"></div>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <li><a routerLink=\"/accounting/voucher-type\">Voucher Type</a></li>\r\n\t\t   </ul>\r\n\t   </div>   \r\n\t\t \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<li><a routerLink=\"/accounting/managetax\">List Taxes</a></li>\r\n\t\t\t</ul>\r\n\t\t</div>     \r\n   </div>\r\n   \r\n  </mat-expansion-panel>\r\n\r\n  <mat-expansion-panel *ngIf=\"compModuleInvoice=='1'\" >\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tInvoice\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/invoice/configure-Invoice\">Configure Invoice</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t\t<li><a routerLink=\"/portal/tax-list\">Tax</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-list\">Items</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/cat-list\">Categories</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-model\">Model</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/uom-list\">Unit Of Measurement</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div>     \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleProduction=='1'\" >\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tProduction\r\n\t\t  </mat-panel-title>\r\n    </div> \r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/production/configure-Production\">Configure Production</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t\t<li><a routerLink=\"/production/joborder-machinet\">Machine</a></li>\r\n\t\t\t\t<li><a routerLink=\"/production/joborder-priority\">Priority</a></li>\r\n\t\t\t\t<li><a routerLink=\"/production/jobcard-type\">Job Card Type</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<li><a routerLink=\"/production/production-stage\">Production Stage</a></li>\r\n\t\t\t\t<li><a routerLink=\"/production/joborder-type\">Job Order Type</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-list\">Items</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/cat-list\">Categories</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-model\">Model</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/uom-list\">Unit Of Measurement</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleAsset=='1'\">\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\"> \r\n\t\t  <mat-panel-title>\r\n\t\t\tAsset\r\n\t\t  </mat-panel-title>\r\n     </div>\r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/asset/configure-asset\">Configure Asset</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t\t<li><a routerLink=\"/asset/cat-list\">Category</a></li>\r\n\t\t\t\t<li><a routerLink=\"/asset/type-list\">Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/asset/asset-priority\">Priority</a></li>\r\n\t\t\t\t<li><a routerLink=\"/asset/location-list\">Location</a></li>\r\n\t\t\t\t<li><a routerLink=\"/asset/ownership-list\">Ownership</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<li><a routerLink=\"/asset/contract-type\">Contract Type</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<li><a routerLink=\"/asset/insurance-type\">Insurance Type</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div>    \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModuleHcm=='1'\" >\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tHCM\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/hcm/configure-hcm\">Configure HCM</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\">PIM</div>\r\n\t\t\t\t<li><a routerLink=\"/hcm/relationship-type\">Relationship Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/reportmethod-type\">Reporting Method Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/social\">Social Media Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/education\">Education Level</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/skill\">Skill Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/license\">License Type</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\"></div>\r\n\t\t\t\t<li><a routerLink=\"/hcm/langtype\">Language Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/langskill\">Language Skill</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/langfluency\">Language Fluency</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/leavetype\">Leave Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/disaction\">Discipline Action</a></li>\r\n\t\t   </ul>\r\n\t   </div>   \r\n\t\t \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<div class=\"text-center\"></div>\r\n\t\t\t\t<li><a routerLink=\"/hcm/delivery\">Delivery Method</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/training\">Training Status</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/appraisal-question\">List Appraisal Question</a></li>\r\n\t\t\t</ul>\r\n\t\t</div>     \r\n   </div>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t   <div class=\"text-center\"></div>\r\n\t\t\t\t<li><a routerLink=\"/hcm/asset-vendor\">Asset Vende</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/asset-brand\">Asset Brand</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/entitlement-year\">Entitlement Year</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/assetcategory-\">Asset Category</a></li>\r\n\t\t\t\t<li><a routerLink=\"/hcm/header-template\">Header Template</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t</div>      \t\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel *ngIf=\"compModulePos=='1'\" >\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\"> \r\n\t\t  <mat-panel-title>\r\n\t\t\tPOS\r\n\t\t  </mat-panel-title>\r\n      </div>\r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/pos/configure-pos\">Configure POS</a>\r\n\t\t  </mat-panel-description>\r\n\t </div>\r\n   <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t\t\t<li><a routerLink=\"/pos/bill\">Bill Counter</a></li>\r\n\t\t\t\t<li><a routerLink=\"/pos/tax-list\">Tax</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-list.\">Items</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/cat-list\">Categories</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/item-model\">Model</a></li>\r\n\t\t\t\t<li><a routerLink=\"/inventory/uom-list\">Unit Of Measurement</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel>\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tHelp Desk\r\n\t\t  </mat-panel-title>\r\n     </div> \r\n       <div class=\"col-md-3\">\r\n\t\t\t<mat-panel-description>\r\n\t\t\t\t<a routerLink=\"\">Configure Help Desk</a>\r\n\t\t  \t</mat-panel-description>\r\n\t\t </div>\r\n\t\t <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t    <ul>\r\n\t\t\t   <div class=\"text-center\">Ticket</div>\r\n\t\t\t\t<li><a routerLink=\"/helpdesk/queue-list\">Queue</a></li>\r\n\t\t\t\t<li><a routerLink=\"/helpdesk/ticket-category-list\">Category</a></li>\r\n\t\t\t\t<li><a routerLink=\"/helpdesk/ticket-type-list\">Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/helpdesk/ticket-status-list\">Status</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n<!--   *ngIf=\"compModuleWebsite=='1'\"-->\r\n  <mat-expansion-panel>\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tWebsite\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n      <div class=\"col-md-3\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-Production\">Configure Website</a>\r\n\t\t  </mat-panel-description>\r\n       </div>\r\n       <div class=\"col-md-4\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n   </div>\r\n  </mat-expansion-panel>\r\n<!--   *ngIf=\"compModuleProductcatalogue='1'\"-->\r\n  <mat-expansion-panel>\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tProduct Catalogue\r\n\t\t  </mat-panel-title>\r\n    </div> \r\n      <div class=\"col-md-4\">\r\n\t\t  <mat-panel-description>\r\n\t\t\t<a routerLink=\"/portal/configure-product-catalogue\">Configure Product Catalogue</a>\r\n\t\t  </mat-panel-description>\r\n       </div>\r\n       <div class=\"col-md-3\"></div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel>\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\">\r\n\t\t  <mat-panel-title>\r\n\t\t\tBranch\r\n\t\t  </mat-panel-title>\r\n      </div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t   \t\t<li><a routerLink=\"/portal/branch-list\">List Branches</a></li>\r\n\t\t   \t\t<li><a routerLink=\"/portal/branchclass-list\">Branch Class</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/branchtype-list\">Branch Type</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/rateclass-list\">Rate Class</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel>\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     <div class=\"col-md-5\"> \r\n\t\t  <mat-panel-title>\r\n\t\t\tFranchisee\r\n\t\t  </mat-panel-title>\r\n\t</div>\r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t   \t\t<li><a routerLink=\"/portal/franchisee-list\">List Franchisee</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/franchisee-type\">Franchisee Type</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n  <mat-expansion-panel>\r\n    \r\n     <mat-expansion-panel-header  style=\"background-color: darkkhaki;\">\r\n     \t<div class=\"col-md-5\">\t\r\n\t\t  <mat-panel-title>\r\n\t\t\tOthers\r\n\t\t  </mat-panel-title>\r\n\t\t </div> \r\n    </mat-expansion-panel-header>\r\n   \r\n   <div class=\"row\">\r\n\t   <div class=\"col-md-3\">\r\n\t\t   <ul>\r\n\t\t    <div class=\"text-center\">Region</div>\r\n\t\t\t\t<li><a routerLink=\"/portal/custom-fields-list\">Custom Fields</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/jobtitle-list\">Job Title</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/department-list\">Department</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/active-users-list\">Active Users</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/user-access-list\">User Access</a></li>\r\n\t\t   </ul>\r\n\t   </div>\r\n\t   \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t<div class=\"text-center\">Others</div>\r\n\t\t\t\t<li><a routerLink=\"/portal/access-log1\">Access Log1</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/access-log2\">Access Log2</a></li>\r\n\t\t\t\t<li><a routerLink=\"/portal/company-logo\">Company Logo</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div> \r\n\t\t<div class=\"col-md-3\">\r\n\t\t\t<ul>\r\n\t\t\t<div class=\"text-center\">Executive</div>\r\n\t\t\t\t<li><a routerLink=\"/portal/module-report-list\">Module Report</a></li>\r\n\t\t\t</ul>\t\r\n\t\t</div>    \r\n   </div>\r\n  </mat-expansion-panel>\r\n  \r\n</mat-accordion>\r\n\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/manager.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MangerComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var MangerComponent = (function () {
    function MangerComponent() {
        this.expanded = true;
        this.compModulePortal = sessionStorage.getItem('compModulePortal');
        this.compModuleAsset = sessionStorage.getItem('compModuleAsset');
        this.compModuleInventory = sessionStorage.getItem('compModuleInventory');
        this.compModuleProductcatalogue = sessionStorage.getItem('compModuleProductcatalogue');
        this.compModuleCustomer = sessionStorage.getItem('compModuleCustomer');
        this.compModuleInvoice = sessionStorage.getItem('compModuleInvoice');
        this.compModulePayroll = sessionStorage.getItem('compModulePayroll');
        this.compModulePm = sessionStorage.getItem('compModulePm');
        this.compModuleProduction = sessionStorage.getItem('compModuleProduction');
        this.compModuleHcm = sessionStorage.getItem('compModuleHcm');
        this.compModuleSales = sessionStorage.getItem('compModuleSales');
        this.compModuleService = sessionStorage.getItem('compModuleService');
        this.compModuleSocial = sessionStorage.getItem('compModuleSocial');
        this.compModuleActivity = sessionStorage.getItem('compModuleActivity');
        this.compModuleAccounting = sessionStorage.getItem('compModuleAccounting');
        this.compModuleMarketing = sessionStorage.getItem('compModuleMarketing');
        this.compModulePos = sessionStorage.getItem('compModulePos');
        this.empMisAccess = sessionStorage.getItem('empMisAccess');
    }
    return MangerComponent;
}());
MangerComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/manager/manager.component.html"),
        styles: [__webpack_require__("../../../../../src/app/theme/pages/portal/manager/manager.component.css")],
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */]]
    })
], MangerComponent);

//# sourceMappingURL=manager.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/manager/manager.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ManagerModule", function() { return ManagerModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__manager_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/manager/manager.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
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
                "component": __WEBPACK_IMPORTED_MODULE_5__manager_component__["a" /* MangerComponent */]
            }
        ]
    }
];
var ManagerModule = (function () {
    function ManagerModule() {
    }
    return ManagerModule;
}());
ManagerModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_3__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_6__angular_material__["l" /* MatExpansionModule */]
            //       MatInputModule, MatNativeDateModule, MatSelectModule, MatSidenavModule, 
            //		MatTableModule, MatSortModule, MatPaginatorModule,MatDatepickerModule, MatCheckboxModule, MatRadioModule,
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_5__manager_component__["a" /* MangerComponent */]]
    })
], ManagerModule);

//# sourceMappingURL=manager.module.js.map

/***/ })

});
//# sourceMappingURL=manager.module.chunk.js.map