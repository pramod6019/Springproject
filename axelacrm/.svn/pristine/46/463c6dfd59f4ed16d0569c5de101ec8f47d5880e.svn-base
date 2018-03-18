webpackJsonp(["branch-list.module"],{

/***/ "../../../../../src/app/theme/pages/portal/branch-list/branch-add.component.html":
/***/ (function(module, exports) {

module.exports = "\t<toast></toast>\r\n\t\r\n\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tBranch {{status}}\r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tPortal\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBranch List: \r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tBranch {{status}}\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n    \t\t<form class=\"m-form m-form--fit m-form--label-align-right\" (ngSubmit)=\"onSubmit()\"  id=\"m_form_1\" [formGroup]=\"branchForm\">\r\n\t\t\t \r\n\t\t<div class=\"m-portlet__body row\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Name*\" [(ngModel)]=\"branch.branchName\" formControlName=\"branchName\"\r\n\t\t\t\t\t maxlength=\"255\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchName.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter name\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchName.hasError('minLength')\">\r\n\t\t\t\t\t\t\tEnter  Minimum of 3 characters\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>(Enter Minimum of 3 characters)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Name on Invoice*\" [(ngModel)]=\"branch.branchInvoiceName\" formControlName=\"branchInvoiceName\" maxlength=\"50\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchInvoiceName.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Name on Invoice\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Code*\" [(ngModel)]=\"branch.branchCode\" formControlName=\"branchCode\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchCode.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter code\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>(Only alphanumeric characters) are allowed!</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"GST*\" [(ngModel)]=\"branch.branchGst\" formControlName=\"branchGst\"\r\n\t\t\t\t\t maxlength=\"15\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchGst.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter GST\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchGst.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid GST\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>Example:22AAAAA0000A1Z5</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"VAT*\" [(ngModel)]=\"branch.branchVat\" formControlName=\"branchVat\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchVat.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter VAT\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"CST*\" [(ngModel)]=\"branch.branchCst\" formControlName=\"branchCst\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchCst.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter CST\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"type*\" [(ngModel)]=\"branch.branchBranchtypeId\" \r\n\t\t\t\t\t\tformControlName=\"branchBranchtypeId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let branch of branchtype\" [value]=\"branch.key\">{{ branch.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<mat-error *ngIf=\"branchBranchtypeId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect type\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t  \t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"Franchisee*\" [(ngModel)]=\"branch.branchFranchiseeId\" \r\n\t\t\t\t\t\tformControlName=\"branchFranchiseeId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let franch of franchisee\" [value]=\"franch.key\">{{ franch.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<mat-error *ngIf=\"branchFranchiseeId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Franchisee\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t  \t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"Rate Class*\" [(ngModel)]=\"branch.branchRateclassId\" \r\n\t\t\t\t\t\tformControlName=\"branchRateclassId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let rate of rateclass\" [value]=\"rate.key\">{{ rate.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t<mat-error *ngIf=\"branchRateclassId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Rate Class\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"branchId!='0'\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Inventory Location*\" [(ngModel)]=\"branch.branchLocationId\" formControlName=\"branchLocationId\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let loc of location\" [value]=\"loc.key\" selected>{{ loc.name}}</mat-option>\r\n\t\t\t\t\t</mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Mobile 1*\" [(ngModel)]=\"branch.branchMobile1\" formControlName=\"branchMobile1\"\r\n\t\t\t\t\t maxlength=\"13\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchMobile1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Mobile 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchMobile1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Mobile 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-9999999999)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Mobile 2\" [(ngModel)]=\"branch.branchMobile2\" formControlName=\"branchMobile2\"\r\n\t\t\t\t\t maxlength=\"13\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchMobile1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Mobile 2\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-9999999999)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Phone 1*\" [(ngModel)]=\"branch.branchPhone1\" formControlName=\"branchPhone1\"\r\n\t\t\t\t\t maxlength=\"14\" >\r\n\t\t\t\t\t <mat-error *ngIf=\"branchPhone1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Phone 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPhone1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter Phone 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-80-33333333)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Phone 2\" [(ngModel)]=\"branch.branchPhone2\" formControlName=\"branchPhone2\"\r\n\t\t\t\t\t maxlength=\"14\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchPhone2.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter Phone 2\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t <mat-hint>(91-80-33333333)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Email 1*\" [(ngModel)]=\"branch.branchEmail1\" formControlName=\"branchEmail1\"\r\n\t\t\t\t\t maxlength=\"100\">\r\n\t\t\t\t\t <mat-error *ngIf=\"branchEmail1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Email 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchEmail1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Email 1\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Email 2\" [(ngModel)]=\"branch.branchEmail2\" formControlName=\"branchEmail2\"\r\n\t\t\t\t\t maxlength=\"100\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchEmail2.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Email 2\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<textarea matInput placeholder=\"Address*\" [(ngModel)]=\"branch.branchAdd\" formControlName=\"branchAdd\" \r\n\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\"></textarea>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchAdd.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Address\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-hint>max char 255</mat-hint>\r\n\t\t\t\t</mat-form-field >\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\" style=\"padding: 1em;\">\r\n\t\t\t\t<select class='form-control txt-align' id='city' name='branchCityId'></select>\r\n\t\t\t\t<span [innerHtml]=\"branchCityIdMsg\"></span>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Pin/Zip*\" [(ngModel)]=\"branch.branchPin\" formControlName=\"branchPin\"\r\n\t\t\t\t\t maxlength=\"6\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPin.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Pin/Zip\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPin.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Pin/Zip\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"PAN\" [(ngModel)]=\"branch.branchPanNo\" formControlName=\"branchPanNo\"\r\n\t\t\t\t\t maxlength=\"10\">\r\n\t\t\t\t\t<mat-error *ngIf=\"branchPanNo.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid PAN No.\r\n\t\t\t\t\t</mat-error> \r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"TAN\" [(ngModel)]=\"branch.branchTanNo\" formControlName=\"branchTanNo\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"TIN\" [(ngModel)]=\"branch.branchTinNo\" formControlName=\"branchTinNo\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Service Tax No.\" [(ngModel)]=\"branch.branchServiceTaxNo\" formControlName=\"branchServiceTaxNo\"\r\n\t\t\t\t\t maxlength=\"25\">\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<span class=\"row\" style=\"padding: 0 1em;\" *ngIf=\"compModulePos=='1'\">\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Bill Header:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchBillHeader\" formControlName=\"branchBillHeader\" \r\n\t\t\t\t\t\t\t maxlength=\"1000\">{{ branch.branchBillHeader }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Bill Footer:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchBillFooter\" formControlName=\"branchBillFooter\" \r\n\t\t\t\t\t\t\t maxlength=\"1000\">{{ branch.branchBillFooter }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t</span>\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<div class=\"row\" style=\"padding: 0 1em;\" *ngIf=\"compModuleInvoice=='1'\">\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Quote Description:</label>\r\n\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchQuoteDesc\" formControlName=\"branchQuoteDesc\">\r\n\t\t\t\t\t\t{{ branch.branchQuoteDesc }}\r\n\t\t\t\t\t</textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t\t<label>Quote Terms & Conditions:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchQuoteTerms\" \r\n\t\t\t\t\t\tformControlName=\"branchQuoteTerms\" maxlength=\"1000\">{{ branch.branchQuoteTerms }}</textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Sales Order Description:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchSoDesc\" \r\n\t\t\t\t\t\tformControlName=\"branchSoDesc\"  maxlength=\"1000\"> {{ branch.branchSoDesc }} </textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Invoice Description:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchInvoiceDesc\" \r\n\t\t\t\t\t\t\tformControlName=\"branchInvoiceDesc\" maxlength=\"1000\">{{ branch.branchInvoiceDesc }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Invoice Terms & Conditions:</label>\r\n\t\t\t\t\t\t<textarea  cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchInvoiceTerms\" \r\n\t\t\t\t\t\tformControlName=\"branchInvoiceTerms\" matAutosizeMinRows=\"2\" maxlength=\"1000\">{{ branch.branchInvoiceTerms }}</textarea>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<label>Receipt Description:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchReceiptDesc\" \r\n\t\t\t\t\t\tformControlName=\"branchReceiptDesc\" maxlength=\"1000\">{{ branch.branchReceiptDesc }}</textarea>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\" *ngIf=\"compModuleSales=='1'\">\r\n\t\t\t\t\t\t<label>Sales Order Terms & Conditions:</label>\r\n\t\t\t\t\t\t<textarea cols=\"70\" rows=\"4\" class=\"form-control\" [(ngModel)]=\"branch.branchSoTerms\" \r\n\t\t\t\t\t\t formControlName=\"branchSoTerms\" maxlength=\"1000\">{{ branch.branchSoTerms }}</textarea> \r\n\t\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\" style=\"margin-top: 2em;\">\r\n\t\t\t\t<label>Active:</label>\r\n\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(branch.branchActive)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:branch, objKey:'branchActive'})\" formControlName=\"branchActive\"></mat-checkbox>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<textarea matInput placeholder=\"Notes\" [(ngModel)]=\"branch.branchNotes\" formControlName=\"branchNotes\" \r\n\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"5000\"></textarea>\r\n\t\t\t\t</mat-form-field >\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-12 row' *ngIf=\"this.branch.branchEntryBy\" style=\"margin-top: 2em;\">\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Entry By:</label> <a href=\"\">{{branch.branchEntryBy}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t\t<label>Entry Date:</label> {{branch.branchEntryDate}}\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-12 row' *ngIf=\"this.branch.branchModifiedBy\"  style=\"margin-top: 2em;\">\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<label>Modified By:</label> <a href=\"\">{{branch.branchModifiedBy}}</a>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<label>Modified Date:</label> {{branch.branchModifiedDate}}\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.branchId=='0'\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Add </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" id=\"reset\" type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\r\n\t\t\t \r\n\t\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.branchId!='0'\">\r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button> \r\n\t\t\t\t\t <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button> \r\n\t\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\"  type=\"button\"> Cancel </button>\r\n\t\t\t\t</div>\t\r\n\t</div>\t\t\r\n\t\r\n\t\t</form>\r\n\t</div>\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/branch-list/branch-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BranchAddComponent; });
/* unused harmony export branchData */
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















var EMAIL_REGEX = /^[a-zA-Z0-9.!#$%'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var MOBILE_REGEX = /^[91]{2}-\d{10}$/;
var GST_REGEX = /^\d{2}[a-zA-Z]{5}\d{4}[a-zA-Z]{1}[a-zA-Z0-9]{3}$/;
var PAN_REGEX = /^[A-Za-z]{5}\d{4}[A-Za-z]{1}$/;
var PHONE_REGEX = /^[91]{2}-[80]{2}-[0-9]{8}$/;
var PIN_REGEX = /^\d{6}$/;
var BranchAddComponent = (function () {
    function BranchAddComponent(http, router, route, globalValid) {
        var _this = this;
        this.http = http;
        this.router = router;
        this.route = route;
        this.globalValid = globalValid;
        this.flyInOutTrigger = 'in';
        this.branch = new branchData();
        this.branchId = 0;
        this.msg = [];
        this.bootstrapFormValues = [];
        this.franchisee = [];
        this.rateclass = [];
        this.branchtype = [];
        this.location = [{ key: '0', name: 'Select' }];
        this.compModuleInvoice = sessionStorage.getItem('compModuleInvoice');
        this.compModuleSales = sessionStorage.getItem('compModuleSales');
        this.compModulePos = sessionStorage.getItem('compModulePos');
        this.route.queryParams.filter(function (params) { return params.branchId; }).subscribe(function (params) {
            if (params.branchId != undefined) {
                _this.branchId = params.branchId;
            }
        });
        if (this.branchId == 0) {
            this.status = "Add";
            this.populateDropDownData();
        }
        else {
            this.status = "Update";
            this.populateData();
        }
    }
    BranchAddComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/app/ckeditor/ckeditor.js', function () {
        });
        $.getScript('assets/demo/default/custom/components/forms/widgets/select2.js', function () {
        });
    };
    BranchAddComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['portal/branch-list']);
    };
    BranchAddComponent.prototype.getCheckValues = function (temp) {
        return this.globalValid.getCheckValue(temp);
    };
    BranchAddComponent.prototype.ngOnInit = function () {
        this.branchForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'branchName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].minLength(3)]),
            'branchInvoiceName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchCode': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchGst': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(GST_REGEX)]),
            'branchVat': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchCst': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchFranchiseeId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchBranchtypeId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchRateclassId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchLocationId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchPhone1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'branchPhone2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'branchMobile1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'branchMobile2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'branchEmail1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'branchEmail2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'branchAdd': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'branchPin': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(PIN_REGEX)]),
            'branchPanNo': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(PAN_REGEX)]),
            'branchTanNo': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchTinNo': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchServiceTaxNo': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchQuoteDesc': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchQuoteTerms': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchSoDesc': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchSoTerms': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchInvoiceDesc': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchInvoiceTerms': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchReceiptDesc': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchBillHeader': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchBillFooter': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchMailServer': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchMailUsername': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchMailPassword': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchMailPort': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchMailSsl': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchActive': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchNotes': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchEntryId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchEntryDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchModifiedId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchModifiedDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(BranchAddComponent.prototype, "branchName", {
        get: function () { return this.branchForm.get('branchName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchInvoiceName", {
        get: function () { return this.branchForm.get('branchInvoiceName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchCode", {
        get: function () { return this.branchForm.get('branchCode'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchGst", {
        get: function () { return this.branchForm.get('branchGst'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchVat", {
        get: function () { return this.branchForm.get('branchVat'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchCst", {
        get: function () { return this.branchForm.get('branchCst'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchFranchiseeId", {
        get: function () { return this.branchForm.get('branchFranchiseeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchBranchtypeId", {
        get: function () { return this.branchForm.get('branchBranchtypeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchRateclassId", {
        get: function () { return this.branchForm.get('branchRateclassId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchLocationId", {
        get: function () { return this.branchForm.get('branchLocationId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchPhone1", {
        get: function () { return this.branchForm.get('branchPhone1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchPhone2", {
        get: function () { return this.branchForm.get('branchPhone2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchMobile1", {
        get: function () { return this.branchForm.get('branchMobile1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchMobile2", {
        get: function () { return this.branchForm.get('branchMobile2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchEmail1", {
        get: function () { return this.branchForm.get('branchEmail1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchEmail2", {
        get: function () { return this.branchForm.get('branchEmail2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchAdd", {
        get: function () { return this.branchForm.get('branchAdd'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchPin", {
        get: function () { return this.branchForm.get('branchPin'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchPanNo", {
        get: function () { return this.branchForm.get('branchPanNo'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchTanNo", {
        get: function () { return this.branchForm.get('branchTanNo'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchTinNo", {
        get: function () { return this.branchForm.get('branchTinNo'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchServiceTaxNo", {
        get: function () { return this.branchForm.get('branchServiceTaxNo'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchQuoteDesc", {
        get: function () { return this.branchForm.get('branchQuoteDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchQuoteTerms", {
        get: function () { return this.branchForm.get('branchQuoteTerms'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchSoDesc", {
        get: function () { return this.branchForm.get('branchSoDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchSoTerms", {
        get: function () { return this.branchForm.get('branchSoTerms'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchInvoiceDesc", {
        get: function () { return this.branchForm.get('branchInvoiceDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchInvoiceTerms", {
        get: function () { return this.branchForm.get('branchInvoiceTerms'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchReceiptDesc", {
        get: function () { return this.branchForm.get('branchReceiptDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchBillHeader", {
        get: function () { return this.branchForm.get('branchBillHeader'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchBillFooter", {
        get: function () { return this.branchForm.get('branchBillFooter'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchMailServer", {
        get: function () { return this.branchForm.get('branchMailServer'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchMailUsername", {
        get: function () { return this.branchForm.get('branchMailUsername'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchMailPassword", {
        get: function () { return this.branchForm.get('branchMailPassword'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchMailPort", {
        get: function () { return this.branchForm.get('branchMailPort'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchMailSsl", {
        get: function () { return this.branchForm.get('branchMailSsl'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchActive", {
        get: function () { return this.branchForm.get('branchActive'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchNotes", {
        get: function () { return this.branchForm.get('branchNotes'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchEntryId", {
        get: function () { return this.branchForm.get('branchEntryId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchEntryDate", {
        get: function () { return this.branchForm.get('branchEntryDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchModifiedId", {
        get: function () { return this.branchForm.get('branchModifiedId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(BranchAddComponent.prototype, "branchModifiedDate", {
        get: function () { return this.branchForm.get('branchModifiedDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    BranchAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branchtype', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branchtype = data['populateBranchType'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/franchisee', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.franchisee = data['populateFranchisee'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/rateclass', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.rateclass = data['populateRateClass'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/location', JSON.stringify({ branchId: this.branchId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.location = data['populateLocation'];
        });
    };
    BranchAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/branch-data', JSON.stringify({ branchId: this.branchId,
            requestType: "update" }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branch = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
            _this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/city?cityId=' + _this.branch.branchCityId, JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.branch.branchCity = data['results'][0].text;
                $('#city').html('<option value=' + _this.branch.branchCityId + '>' + _this.branch.branchCity + '</option>');
            });
        });
    };
    BranchAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.branch[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
        }
        if (this.branch.branchCityId != undefined) {
            if (this.branch.branchCityId == '0') {
                this.errorMsg = 'Fill all the Mandatory Fields';
                this.branchCityIdMsg = "<font class='select2ErrorMsg'>Please Select City</font>";
            }
            else {
                this.errorMsg = '';
                this.branchCityIdMsg = "";
            }
        }
        else {
            this.errorMsg = 'Fill all the Mandatory Fields';
            this.branchCityIdMsg = "<font class='select2ErrorMsg'>Plese Select City</font>";
        }
        console.log(this.branch);
        if (!this.branchForm.invalid && this.errorMsg == '') {
            console.log("valid");
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.branchId == 0) {
                this.branch['requestType'] = 'add';
            }
            else {
                this.branch['requestType'] = 'update';
                this.branch['branchId'] = this.branchId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/branch', JSON.stringify(this.branch), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.branchForm.reset();
                    _this.toggleAnimation();
                }
            }, function (err) {
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    BranchAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.branch['requestType'] = 'delete';
        this.branch['empId'] = this.branchId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/branch', JSON.stringify({ requestType: 'delete',
            'branchId': this.branchId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                _this.branchForm.reset();
                _this.toggleAnimation();
            }
        }, function (err) {
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return BranchAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], BranchAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], BranchAddComponent.prototype, "toast", void 0);
BranchAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/branch-list/branch-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_1__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_14__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__services_validate_service__["a" /* GlobalValidate */]) === "function" && _e || Object])
], BranchAddComponent);

var branchData = (function () {
    function branchData() {
        this.branchCityId = '0';
        this.branchActive = "1";
    }
    return branchData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=branch-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/branch-list/branch-list.component.html":
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\r\n\t  \r\n<div class=\"m-subheader\">\r\n    <div class=\"d-flex align-items-center\">\r\n      <div class=\"mr-auto\">\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\"> Branch List </h3>\r\n        <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n          <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/home\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/manager\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Portal </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/branch-list\" class=\"m-nav__link\"><span class=\"m-nav__link-text\"> Branch List:</span></a> </li>\r\n        </ul>\r\n      </div>\r\n      <div>  \r\n       \r\n         \r\n\t\t\t\t<button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add Branch\r\n\t\t\t\t</button>\r\n         \r\n        <a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n        <div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\"> <a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\"> <i class=\"la la-plus m--hide\"></i> <i class=\"la la-ellipsis-h\"></i> </a>\r\n          <div class=\"m-dropdown__wrapper\"> <span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n            <div class=\"m-dropdown__inner\">\r\n              <div class=\"m-dropdown__body\">\r\n                <div class=\"m-dropdown__content\">\r\n                  <ul class=\"m-nav\">\r\n                    <li class=\"m-nav__section m-nav__section--first m--hide\"> <span class=\"m-nav__section-text\"> Quick Actions </span> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-share\"></i> <span class=\"m-nav__link-text\"> Activity </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-chat-1\"></i> <span class=\"m-nav__link-text\"> Messages </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-info\"></i> <span class=\"m-nav__link-text\"> FAQ </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-lifebuoy\"></i> <span class=\"m-nav__link-text\"> Support </span> </a> </li>\r\n                    <li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n                    <li class=\"m-nav__item\"> <a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\"> Submit </a> </li>\r\n                  </ul>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  \r\n  \r\n<smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\"></smart-search>\r\n  \r\n  \r\n<div class=\"m-content\">\r\n\t<div class=\"m-portlet__body\">\r\n\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>  "

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/branch-list/branch-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BranchListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
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








var BranchListComponent = (function () {
    function BranchListComponent(http, router) {
        this.http = http;
        this.router = router;
        this.flyInOutTrigger = 'in';
        this.branchId = 0;
        this.smartHide = true;
        this.animateSmart = 'out';
    }
    BranchListComponent.prototype.ngOnInit = function () {
        this.smart.smartUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/portal/branch-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + '/axelacrm/portal/branch-list';
    };
    BranchListComponent.prototype.ngAfterViewInit = function () {
    };
    BranchListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    BranchListComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['portal/branch-list/branch-add'], { queryParams: { branchId: this.branchId } });
    };
    BranchListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'updateBranch') {
            this.branchId = listParam[1];
            this.toggleAnimation();
        }
    };
    BranchListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    return BranchListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _a || Object)
], BranchListComponent.prototype, "smart", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], BranchListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], BranchListComponent.prototype, "list", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _c || Object)
], BranchListComponent.prototype, "toast", void 0);
BranchListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/branch-list/branch-list.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]]
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _e || Object])
], BranchListComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=branch-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/branch-list/branch-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BranchListModule", function() { return BranchListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__branch_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/branch-list/branch-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__branch_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/branch-list/branch-add.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__branch_list_component__["a" /* BranchListComponent */]
            }
        ]
    }, {
        "path": "branch-add",
        "component": __WEBPACK_IMPORTED_MODULE_6__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__branch_add_component__["a" /* BranchAddComponent */],
            }
        ]
    }
];
var BranchListModule = (function () {
    function BranchListModule() {
    }
    return BranchListModule;
}());
BranchListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_5__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["c" /* HttpClientModule */], __WEBPACK_IMPORTED_MODULE_8__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_8__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_9__list_list_module__["a" /* ListModule */],
            __WEBPACK_IMPORTED_MODULE_12__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["E" /* MatSortModule */],
            __WEBPACK_IMPORTED_MODULE_12__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_12__angular_material__["w" /* MatRadioModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */]
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__branch_list_component__["a" /* BranchListComponent */], __WEBPACK_IMPORTED_MODULE_4__branch_add_component__["a" /* BranchAddComponent */]],
    })
], BranchListModule);

//# sourceMappingURL=branch-list.module.js.map

/***/ })

});
//# sourceMappingURL=branch-list.module.chunk.js.map