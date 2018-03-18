webpackJsonp(["opprlist.module"],{

/***/ "../../../../../src/app/theme/pages/sales/opprlist/oppr-add.component.html":
/***/ (function(module, exports) {

module.exports = "\t\t<toast></toast>\r\n\t\t\t\t\t\r\n\t\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tAdd {{config.configSalesOpprName}} \r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tSales\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t{{config.configSalesOpprName}} List\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\r\n\t\t\t<div class=\"m-portlet m-portlet--head-solid-bg m-portlet--rounded m-portlet--bordered\">\r\n\t\t\t\t<div class=\"m-portlet__head\">\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t\tAdd {{config.configSalesOpprName}} \r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t<form  (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"opprForm\">\r\n\t\t<div class=\"m-portlet__body\">\r\n\t\t\r\n\t\t<mat-card>\r\n\t\t<div class=\"col-md-12 row\">\r\n\t\t\r\n\t\t<h3 class=\"col-md-12 text-center\">\r\n\t\t\t<label>{{ config.configCustomerName }} Details</label>\r\n\t\t</h3><br><br>\r\n\t\t\r\n\t\t<div class=\"row\" [hidden]=\"opportunity.opprContactId != '0'\" ><!--  [hidden]=\"opportunity.opprContactId != '0'\" -->\r\n\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t  <mat-select placeholder=\"Select Branch\" [(ngModel)]=\"opportunity.opprBranchId\" formControlName=\"opprBranchId\" (change)=\"populateTeam(opprBranchId.value)\">\r\n\t\t\t\t<mat-option *ngFor=\"let branch of branchs\" [value]=\"branch.key\">\r\n\t\t\t\t  {{ branch.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Customer\" [(ngModel)]=\"opportunity.customerName\" formControlName=\"customerName\">\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t\t<div class='col-md-4'> \r\n\t\t\t  \t  <mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"Contact\" [(ngModel)]=\"opportunity.titleId\" formControlName=\"titleId\" required>\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let contactTitle of contactTitle\" [value]=\"contactTitle.key\">{{ contactTitle.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t<mat-hint>Title</mat-hint>\r\n\t\t\t\t\t\t<mat-error *ngIf=\"opprTitle.hasError('required')\">\r\n\t\t\t\t\t\tPlease select Contact Title\r\n\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class='col-md-4'> \r\n\t\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t\t<input matInput placeholder=\"First Name\" [(ngModel)]=\"opportunity.contactFname\" formControlName=\"contactFname\" maxlength=\"255\">\r\n\t\t\t\t\t\t<mat-error *ngIf=\"contactFname.hasError('required')\">\r\n\t\t\t\t\t\tPlease Enter First Name\r\n\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t  </div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-4'> \r\n\t\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t\t<input matInput placeholder=\"Last Name\" maxlength=\"255\" [(ngModel)]=\"opportunity.contactLname\" formControlName=\"contactLname\">\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t</div> \r\n\t\t\t</div>\t\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t <input matInput placeholder=\"Job Title\" [(ngModel)]=\"opportunity.leadJobtitle\" formControlName=\"leadJobtitle\">\t\t  \r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-3'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Mobile 1\" maxlength=\"13\" [(ngModel)]=\"opportunity.contactMobile1\" formControlName=\"contactMobile1\" (blur)=\"mobile1FocusOut()\"  (keyup)=\"showHintcontactMobile1(contactMobile1.value)\" required>\r\n\t\t\t\t\t<mat-error *ngIf=\"contactMobile1.hasError('required')\"> Please enter Mobile 1 </mat-error>\r\n\t    \t\t\t<mat-error *ngIf=\"contactMobile1.hasError('pattern')\" > Please enter valid Mobile 1 </mat-error>\r\n\t\t\t\t\t<mat-hint>(91-9999999999)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t\t <span *ngFor=\"let mobile of contactMobile\"><a href=\"\" (click)=\"onClick(mobile)\">{{ mobile.contactName }},{{mobile.contactMobile1}}</a><br></span>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-3'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Mobile 2\" maxlength=\"13\"[(ngModel)]=\"opportunity.contactMobile2\" formControlName=\"contactMobile2\" (blur)=\"mobile1FocusOut()\"  (keyup)=\"showHintcontactMobile2(contactMobile2.value)\">\r\n\t\t\t\t\t\t<mat-hint>(91-9999999999)</mat-hint>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t\t<span *ngFor=\"let mobile of contactmobile2\"><a href=\"\" (click)=\"onClick(mobile)\">{{ mobile.contactName }},{{mobile.contactMobile1}}</a><br></span>\r\n\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-3'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Phone 1\"  maxlength=\"14\" [(ngModel)]=\"opportunity.contactPhone1\" formControlName=\"contactPhone1\">\r\n\t\t\t\t\t<mat-hint>(91-80-33333333)</mat-hint>\r\n\t\t\t\t\t<mat-error *ngIf=\"contactPhone1.hasError('required')\"> Please Enter Phone 1 </mat-error>\r\n\t    \t\t\t<mat-error *ngIf=\"contactPhone1.hasError('pattern')\" > Please Enter valid Phone 1 </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-3'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Phone 2\"  maxlength=\"14\" [(ngModel)]=\"opportunity.contactPhone2\" formControlName=\"contactPhone2\">\r\n\t\t\t\t\t<mat-hint>(91-80-33333333)</mat-hint>\r\n\t\t\t\t\t<mat-error *ngIf=\"contactPhone2.hasError('pattern')\" > Please Enter valid Phone 2 </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t<div class='col-md-3'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Email 1\"  [(ngModel)]=\"opportunity.contactEmail1\" formControlName=\"contactEmail1\" maxlength=\"25\" (blur)=\"mobile1FocusOut()\"  (keyup)=\"showHintcontactEmail(contactEmail1.value)\">\r\n\t\t\t\t\t<mat-error *ngIf=\"contactEmail1.hasError('pattern')\"> Please Enter valid Email Address </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t\t<span *ngFor=\"let email of contactEmail\"><a href=\"\" (click)=\"onClick(email)\">{{ email.contactName }},{{email.contactEmail}}</a><br></span>\r\n\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-3'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Email 2\" [(ngModel)]=\"opportunity.contactEmail2\" formControlName=\"contactEmail2\" maxlength=\"25\" (blur)=\"mobile1FocusOut()\"  (keyup)=\"showHintcontactEmail2(contactEmail2.value)\">\r\n\t            \t<mat-error *ngIf=\"contactEmail2.hasError('pattern')\"> Please Enter valid Email Address </mat-error>\r\n\t             </mat-form-field>\r\n\t             <span *ngFor=\"let email of contactemail2\"><a href=\"\" (click)=\"onClick(email)\">{{ email.contactName }},{{email.contactEmail}}</a><br></span>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.configCustomerAddress == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<textarea matInput placeholder=\"Address\" matAutosizeMinRows=\"2\" maxlength=\"255\" [(ngModel)]=\"opportunity.contactAddress\" formControlName=\"contactAddress\" required>\t\r\n\t\t\t\t\t</textarea>\r\n\t\t\t\t\t<mat-hint>(255 Characters)</mat-hint>\r\n\t\t\t\t\t<mat-error *ngIf=\"contactAddress.hasError('required')\"> Please Enter Address </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"!config.configCustomerAddress == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<textarea matInput placeholder=\"Address\" matAutosizeMinRows=\"2\" maxlength=\"255\" [(ngModel)]=\"opportunity.contactAddress\" formControlName=\"contactAddress\">\t\r\n\t\t\t\t\t</textarea>\r\n\t\t\t\t\t<mat-hint>(255 Characters)</mat-hint>\r\n\t\t\t\t\t<mat-error *ngIf=\"contactAddress.hasError('required')\"> Please Enter Address </mat-error>\r\n\t\t\t\t </mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<select class='form-control txt-align' id='city' name='contactCityId'>\r\n\t\t\t\t\t<option *ngIf=\"opportunity.contactCityId !='0'\" [value]='opportunity.contactCityId'>{{opportunity.contactCityId}} </option>\r\n\t\t\t\t</select>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.configCustomerAddress=='1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Pin/Zip\" [(ngModel)]=\"opportunity.contactPin\" formControlName=\"contactPin\" maxlength=\"6\" required>\r\n\t           \t\t<mat-error *ngIf=\"contactPin.hasError('required')\"> Please Enter Pin/Zip </mat-error>\r\n\t            \t\t<mat-error *ngIf=\"contactPin.hasError('pattern')\"> Please Enter Pin/Zip </mat-error> \r\n\t             </mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"!config.configCustomerAddress=='1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Pin/Zip\" [(ngModel)]=\"opportunity.contactPin\" formControlName=\"contactPin\" maxlength=\"6\" >\r\n           \t\t<mat-error *ngIf=\"contactPin.hasError('required')\"> Please Enter Pin/Zip </mat-error>\r\n            \t\t<mat-error *ngIf=\"contactPin.hasError('pattern')\"> Please Enter Pin/Zip </mat-error> \r\n             </mat-form-field>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class=\"col-md-12 row\" *ngIf=\"opportunity.opprContactId != '0'\">\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<div>{{ config.configCustomerName}}: <a href=\"\" >{{ opportunity.opprCustomerName}}</a></div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\t<div>Contact : <a href=\"\">{{ opportunity.opprContactName}}</a><br>\r\n\t\t\t\t\t\t\t\t{{ opportunity.contactMobile1}}\r\n\t\t\t\t\t\t\t\t{{ opportunity.contactEmail1}} </div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\t\r\n\t\t\t\r\n\t\t</div>\t\t\r\n\t</mat-card>\r\n\t\r\n\t<mat-card>\r\n\t\t<h3 class=\"col-md-12 text-center\">\r\n\t\t\t<label>\r\n\t\t\t\t{{config.configSalesOpprName}} Details\r\n\t\t\t</label>\r\n\t\t</h3>\r\n\t\t<div class=\"row\">\r\n\t\t\r\n\t\t\t<div class='col-md-6'><!-- *ngIf=\"config.empOpportunityEdit != '1'\"-->\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<input matInput class='datepicker' name='opprDate' placeholder=\"Date\" [value]='opportunity.opprDate' >\r\n          \t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput class=\"datepicker\" name=\"opprCloseDate\" placeholder=\"Close Date\" [value]='opportunity.opprCloseDate' >\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Title\" maxlength=\"25\" [(ngModel)]=\"opportunity.opprTitle\" formControlName=\"opprTitle\">\r\n\t\t\t\t\t<mat-error *ngIf=\"opprTitle.hasError('required')\"> Please Enter Title </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Description\" matAutosizeMinRows=\"2\" [(ngModel)]=\"opportunity.opprDesc\" formControlName=\"opprDesc\">\t\t\t\t\t\t\t\t\t\t\t\r\n    \t\t\t</textarea>\r\n    \t\t\t<mat-hint>(8000 Characters)</mat-hint>\r\n    \t\t\t\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.configSalesOpprModel == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t  <mat-select placeholder=\"Select Model\" (change)=\"populateItem(opprModelId.value)\" [(ngModel)]=\"opportunity.opprModelId\" formControlName=\"opprModelId\" required>\r\n\t\t\t\t\t<mat-option  *ngFor=\"let model of model\" [value]=\" model.key\">\r\n\t\t\t\t\t   {{ model.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  \r\n\t\t\t\t  <mat-error *ngIf=\"opprModelId.hasError('required')\"> Please Select Model </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.configSalesOpprModel != '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t <mat-select placeholder=\"Select Model\"  [(ngModel)]=\"opportunity.opprModelId\" formControlName=\"opprModelId\" (change)=\"populateItem(opprModelId.value)\">\r\n\t\t\t\t\t<mat-option  *ngFor=\"let model of model\" [value]=\" model.key\">\r\n\t\t\t\t\t   {{ model.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.configSalesOpprItem == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t  <mat-select placeholder=\"Select Item\"  [(ngModel)]=\"opportunity.opprItemId\" formControlName=\"opprItemId\" required>\r\n\t\t\t\t\t<mat-option *ngFor=\"let item of item\" [value]=\"item.key\">\r\n\t\t\t\t\t  {{ item.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  \r\n\t\t\t\t   <mat-error *ngIf=\"opprItemId.hasError('required')\"> Please Select Item </mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<!-- <div class='col-md-6' *ngIf=\"!config.configSalesOpprItem == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t <mat-select placeholder=\"Select Item\"  [(ngModel)]=\"opportunity.opprItemId\" formControlName=\"opprItemId\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let item of item\" [value]=\"item.key\">\r\n\t\t\t\t\t  {{ item.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div> -->\r\n\t\t\t\r\n\t\t  </div>\t\t\t\r\n\t\t</mat-card>\r\n\t\t\r\n\t<mat-card>\r\n\t\t<h3 class=\"col-md-12 text-center\">\r\n\t\t  <label>\r\n\t\t\t{{config.configSalesOpprName}} Status\r\n\t\t  </label>\t\r\n\t\t</h3><br><br>\r\n\t\t\r\n\t\t<div class=\"row\">\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Team\" [(ngModel)]=\"opportunity.opprTeamId\" (change)=\"populateTeamExecutives(opprTeamId.value)\" formControlName=\"opprTeamId\">\r\n\t\t\t\t<mat-option *ngFor=\"let  team of  team\" [value]=\" team.key\">\r\n\t\t\t\t  {{  team.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Executive\" [(ngModel)]=\"opportunity.opprEmpId\" formControlName=\"opprEmpId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let exe of exe\" [value]=\" exe.key\">\r\n\t\t\t\t  {{ exe.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t\r\n\t\t<div class='col-md-6' *ngIf=\"config.configSalesSoe == '1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Source of Enquiry\" [(ngModel)]=\"opportunity.opprSoeId\" formControlName=\"opprSoeId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  soe of  soe\" [value]=\" soe.key\">\r\n\t\t\t\t  {{  soe.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n  \t\t\t<mat-error *ngIf=\"opprSoeId.hasError('required')\"> Please Select Source of Enquiry</mat-error>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\r\n\r\n\t\t<div class='col-md-6' *ngIf=\"config.configSalesSob == '1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Source of Business\" [(ngModel)]=\"opportunity.opprSobId\" formControlName=\"opprSobId\" required>\r\n\t\t\t\t\t<mat-option *ngFor=\"let  sob of  sob\" [value]=\" sob.key\">\r\n\t\t\t\t\t  {{  sob.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t            <mat-error *ngIf=\"opprSobId.hasError('required')\"> Please Select Source of Business </mat-error>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\r\n\t\t\r\n\t\t\t<div class='col-md-6'*ngIf=\"config.configSalesCampaign == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t  <mat-select placeholder=\"Campaign\" [(ngModel)]=\"opportunity.opprCampaignId\" formControlName=\"opprCampaignId\" required>\r\n\t\t\t\t\t<mat-option *ngFor=\"let campaign of campaign\" [value]=\"campaign.key\">\r\n\t\t\t\t\t {{ campaign.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t   <mat-error *ngIf=\"opprCampaignId.hasError('required')\"> Please Select Campaign </mat-error>\r\n\t\t\t\t </mat-form-field>\r\n\t\t\t</div>\r\n\r\n\t\t<div class='col-md-6' *ngIf=\"config.compModulePm == '1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t  <mat-select placeholder=\"Project Management\"  [(ngModel)]=\"opportunity.opprpmId\" formControlName=\"opprpmId\">\r\n\t\t\t\t<mat-option *ngFor=\"let pm of pm\" [value]=\"pm.key\"> {{ pm.name}} </mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\t\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6' *ngIf=\"config.configSalesOpprRefno == '1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Refference No.\" [(ngModel)]=\"opportunity.opprRefno\" formControlName=\"opprRefno\" maxlength=\"20\" required>\t\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\t\t\r\n\t\t\t\t<textarea matInput placeholder=\"Notes\" matAutosizeMinRows=\"2\"  [(ngModel)]=\"opportunity.opprNotes\" formControlName=\"opprNotes\" maxlength=\"255\">\t</textarea>\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t\t\r\n\t  </div>\t\r\n\t</mat-card>\r\n\t\r\n\t\r\n\t\t<div class='col-md-12 btn-row'>\r\n\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Add </button> \r\n\t\t\t<button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\" type=\"button\"> Cancel </button>\r\n\t\t</div>\r\n\t</div>\r\n</form>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/oppr-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OpprAddComponent; });
/* unused harmony export OpprtunityData */
/* unused harmony export ConfigDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_filter__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








//import { TimerWrapper } from '@angular/core/src/facade/async';
var EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&â€™*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var MOBILE_REGEX = /^[91]{2}-\d{10}$/;
var PHONE_REGEX = /^[91]{2}-[80]{2}-\d{8}$/;
var PIN_REGEX = /\d{6}$/;
var OpprAddComponent = (function () {
    function OpprAddComponent(http, router, route) {
        this.http = http;
        this.router = router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.contactMobile = [];
        this.contactmobile2 = [];
        this.contactEmail = [];
        this.contactemail2 = [];
        this.msg = [];
        this.opprId = 0;
        this.opportunity = new OpprtunityData();
        this.config = new ConfigDetails();
        this.customerDetailsAjax = "1";
        this.bootstrapFormValues = [];
        this.bootstrapMsg = '';
        this.branchs = [];
        this.team = [];
        this.campaign = [];
        this.configdetails = [];
        this.pm = [];
        this.soe = [];
        this.sob = [];
        this.empcount = [];
        this.type = [];
        this.exe = [];
        this.item = [];
        this.model = [];
        this.contactTitle = [];
    }
    OpprAddComponent.prototype.ngOnInit = function () {
        this.opprForm = new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormGroup"]({
            'opprBranchId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'leadBranchId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprCustomerId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprContactId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'contactFname': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'contactLname': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'leadJobtitle': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'contactMobile1': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'contactMobile2': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'contactPhone1': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'contactPhone2': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'contactEmail1': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'contactEmail2': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'contactAddress': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'opprTitle': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'contactPin': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].pattern(PIN_REGEX)]),
            'opprDesc': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprModelId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'opprItemId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'opprDate': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprCloseDate': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprEmpId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_1__angular_forms__["Validators"].required]),
            'opprSoeId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprSobId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprCampaignId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprpmId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprNotes': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprTeamId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprRefno': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprAvpresent': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'opprManagerAssist': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'titleId': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
            'customerName': new __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormControl"](''),
        });
        this.populateDropDownData();
    };
    Object.defineProperty(OpprAddComponent.prototype, "opprCustomerId", {
        get: function () { return this.opprForm.get('opprCustomerId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprContactId", {
        get: function () { return this.opprForm.get('opprContactId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprTitle", {
        get: function () { return this.opprForm.get('opprTitle'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactFname", {
        get: function () { return this.opprForm.get('contactFname'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactLname", {
        get: function () { return this.opprForm.get('contactLname'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprBranchId", {
        get: function () { return this.opprForm.get('opprBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "leadBranchId", {
        get: function () { return this.opprForm.get('leadBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "leadJobtitle", {
        get: function () { return this.opprForm.get('leadJobtitle'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactMobile1", {
        get: function () { return this.opprForm.get('contactMobile1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactMobile2", {
        get: function () { return this.opprForm.get('contactMobile2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactPhone1", {
        get: function () { return this.opprForm.get('contactPhone1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactPhone2", {
        get: function () { return this.opprForm.get('contactPhone2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactEmail1", {
        get: function () { return this.opprForm.get('contactEmail1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactEmail2", {
        get: function () { return this.opprForm.get('contactEmail2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactAddress", {
        get: function () { return this.opprForm.get('contactAddress'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "contactPin", {
        get: function () { return this.opprForm.get('contactPin'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprDesc", {
        get: function () { return this.opprForm.get('opprDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprModelId", {
        get: function () { return this.opprForm.get('opprModelId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprItemId", {
        get: function () { return this.opprForm.get('opprItemId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprDate", {
        get: function () { return this.opprForm.get('opprDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprCloseDate", {
        get: function () { return this.opprForm.get('opprCloseDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprTeamId", {
        get: function () { return this.opprForm.get('opprTeamId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprEmpId", {
        get: function () { return this.opprForm.get('opprEmpId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprSoeId", {
        get: function () { return this.opprForm.get('opprSoeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprSobId", {
        get: function () { return this.opprForm.get('opprSobId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprCampaignId", {
        get: function () { return this.opprForm.get('opprCampaignId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprpmId", {
        get: function () { return this.opprForm.get('opprpmId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprNotes", {
        get: function () { return this.opprForm.get('opprNotes'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprRefno", {
        get: function () { return this.opprForm.get('opprRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprAvpresent", {
        get: function () { return this.opprForm.get('opprAvpresent'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "opprManagerAssist", {
        get: function () { return this.opprForm.get('opprManagerAssist'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "titleId", {
        get: function () { return this.opprForm.get('titleId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprAddComponent.prototype, "customerName", {
        get: function () { return this.opprForm.get('customerName'); },
        enumerable: true,
        configurable: true
    });
    ;
    OpprAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branchSelectedKey = data['selectedKey'];
            _this.branchs = data['populateBranch'];
            if (_this.branchSelectedKey == '0') {
                _this.opportunity.opprBranchId = "1";
            }
            else {
                _this.opportunity.opprBranchId = _this.branchSelectedKey;
            }
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/soe ', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.soe = data['populateSoe'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/sob ', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.sob = data['populateSob'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/opportunitymodel ', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.model = data['populateOpportunityModel'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/contact ', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.contactTitle = data['populateContactTitle'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.teamSelectedKey = data['selectedKey'];
            _this.team = data['populateTeam'];
            if (_this.teamSelectedKey == '0') {
                _this.opportunity.opprTeamId = "1";
            }
            else {
                _this.opportunity.opprTeamId = _this.teamSelectedKey;
            }
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/campaign', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.campaign = data['populateCampaign'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.config = data['populateconfigdetails'][0]; /*populateConfigDetails*/
            console.log(_this.config);
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/projectmanager', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.pm = data['populateProjectManager'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/currentdate', JSON.stringify({ requestType: 'shortDate' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.opportunity.date = data['date'];
            console.log(_this.opportunity.date);
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.exe = data['populateExecutive'];
            _this.teamExecutiveSelectedKey = data['selectedKey'];
            if (_this.teamExecutiveSelectedKey == '0') {
                _this.opportunity.opprEmpId = "1";
            }
            else {
                _this.opportunity.opprEmpId = _this.teamExecutiveSelectedKey;
            }
        });
    };
    OpprAddComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/demo/default/custom/components/forms/widgets/select2.js', function () {
        });
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    OpprAddComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['sales/oppr-list']);
    };
    OpprAddComponent.prototype.mobile1FocusOut = function () {
        var _this = this;
        this.customerDetailsAjax = "0";
        setTimeout(function () {
            //			$('customerDetailsSpan').html('');
            _this.contactMobile = [];
            _this.contactmobile2 = [];
            _this.contactEmail = [];
            _this.contactemail2 = [];
        }, 500);
    };
    OpprAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.opportunity[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
            if (this.opportunity.contactCityId != undefined) {
                if (this.opportunity.contactCityId == '0') {
                    this.bootstrapMsg = this.bootstrapMsg + 'Plese Select City';
                    this.opportunitycitymsg = "<font class='errorMsg'>Plese Select City</font>";
                }
                else {
                    this.bootstrapMsg = '';
                    this.opportunitycitymsg = "";
                }
            }
            else {
                this.opportunitycitymsg = "<font class='select2ErrorMsg'>Plese Select City</font>";
            }
            if (this.bootstrapFormValues[i].name == "opprDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter Date!<br>';
                    this.opportunitydatemsg = "<font class='errorMsg'>Enter Date</font>";
                }
                else {
                    this.bootstrapMsg = '';
                    this.opportunitydatemsg = "";
                }
            }
            if (this.bootstrapFormValues[i].name == "opprCloseDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter Close Date!<br>';
                    this.opportunitycloseddatemsg = "<font class='errorMsg'>Enter Close Date</font>";
                }
                else {
                    this.bootstrapMsg = '';
                    this.opportunitycloseddatemsg = "";
                }
            }
        }
        if (this.bootstrapMsg != '') {
            this.msg[0] = 'Error';
            this.msg[1] = 'Enter the Mandatory Fields';
            this.toast.showtoast(this.msg);
            this.bootstrapMsg = '';
        }
        //  OpprListComponent.customValidate1 = "1";
        console.log(this.opprForm.invalid);
        if (!this.opprForm.invalid && this.bootstrapMsg == '') {
            var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.opprId == 0) {
                this.opportunity['requestType'] = 'add';
                this.opportunity['customerId'] = this.opportunity.opprCustomerId + '';
                this.opportunity['contactId'] = this.opportunity.opprContactId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity', JSON.stringify(this.opportunity), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.opprForm.reset();
                }
            }, function (err) {
                console.log(err['error']['desc']);
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    /*customValidate(form:FormControl): ValidationErrors{
       if(OpprListComponent.customValidate1 == '0'){
           if(form.value == null || form.value == undefined || form.value == ''){
           const message = {
           'customValidate':{
               'message':'required'
           }
       }
        return message;
       }else{
           return null;
       }
       }else{
           return null;
       }
    }*/
    OpprAddComponent.prototype.showHintcontactMobile1 = function (value) {
        var _this = this;
        this.customerDetailsAjax = "1";
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-search', JSON.stringify({ 'contactMobile': value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (_this.customerDetailsAjax == "1") {
                _this.contactMobile = data['contactMobile'];
            }
        });
    };
    OpprAddComponent.prototype.showHintcontactMobile2 = function (value) {
        var _this = this;
        this.customerDetailsAjax = "1";
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-search', JSON.stringify({ 'contactMobile': value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (_this.customerDetailsAjax == "1") {
                _this.contactmobile2 = data['contactMobile'];
            }
        });
    };
    OpprAddComponent.prototype.showHintcontactEmail = function (value) {
        var _this = this;
        this.customerDetailsAjax = "1";
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-search', JSON.stringify({ 'contactEmail': value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (_this.customerDetailsAjax == "1") {
                _this.contactEmail = data['contactEmail'];
            }
        });
    };
    OpprAddComponent.prototype.showHintcontactEmail2 = function (value) {
        var _this = this;
        this.customerDetailsAjax = "1";
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-search', JSON.stringify({ 'contactEmail': value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (_this.customerDetailsAjax == "1") {
                _this.contactemail2 = data['contactEmail'];
            }
        });
    };
    OpprAddComponent.prototype.populateItem = function (value) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/item ', JSON.stringify({ modelId: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.item = data['populateItem'];
        });
    };
    OpprAddComponent.prototype.populateTeam = function (value) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', JSON.stringify({ branchId: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.team = data['populateTeam'];
        });
    };
    OpprAddComponent.prototype.populateTeamExecutives = function (value) {
        var _this = this;
        this.opportunity.opprEmpId = '0';
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({ teamId: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.exe = data['populateExecutive'];
        });
    };
    OpprAddComponent.prototype.onClick = function (value) {
        this.opportunity.contactMobile1 = value.contactMobile1;
        this.opportunity.opprContactId = value.contactId;
        this.opportunity.opprCustomerName = value.customerName;
        this.opportunity.opprCustomerId = value.customerId;
        this.opportunity.opprContactName = value.contactName;
        this.opportunity.contactEmail1 = value.contactEmail;
        this.opportunity.contactFname = "first Name";
        this.opportunity.contactPhone1 = "91-80-33333333";
        this.opportunity.opprBranchId = '1';
        this.opportunity.contactPin = '123456';
        this.opportunity.contactAddress = '123456';
        this.opportunity.titleId = '1';
        this.opportunity.contactCityId = '12';
    };
    return OpprAddComponent;
}());
OpprAddComponent.customValidate1 = "0";
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], OpprAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], OpprAddComponent.prototype, "toast", void 0);
OpprAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/oppr-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_3__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_4__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["ActivatedRoute"]) === "function" && _d || Object])
], OpprAddComponent);

var OpprtunityData = (function () {
    function OpprtunityData() {
        this.opprCloseDate = '';
        this.opprDate = '';
        this.opprContactId = "0";
        this.contactCityId = "0";
        this.leadId = "0";
        this.leadBranchId = "0";
    }
    return OpprtunityData;
}());

var ConfigDetails = (function () {
    function ConfigDetails() {
        this.empOpportunityEdit = "0";
    }
    return ConfigDetails;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=oppr-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprlist.component.html":
/***/ (function(module, exports) {

module.exports = "\t<router-outlet></router-outlet>\r\n\t  \r\n\t<div class=\"m-subheader\">\r\n    <div class=\"d-flex align-items-center\">\r\n      <div class=\"mr-auto\">\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\"> List {{configSalesopprName}} </h3>\r\n        <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n          <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Sales </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> List {{configSalesopprName}} </span> </a> </li>\r\n        </ul>\r\n      </div>\r\n      <div>  \r\n        <button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add {{configSalesopprName}}\r\n\t\t</button>\r\n        <a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n        <div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\"> <a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\"> <i class=\"la la-plus m--hide\"></i> <i class=\"la la-ellipsis-h\"></i> </a>\r\n          <div class=\"m-dropdown__wrapper\"> <span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n            <div class=\"m-dropdown__inner\">\r\n              <div class=\"m-dropdown__body\">\r\n                <div class=\"m-dropdown__content\">\r\n                  <ul class=\"m-nav\">\r\n                    <li class=\"m-nav__section m-nav__section--first m--hide\"> <span class=\"m-nav__section-text\"> Quick Actions </span> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-share\"></i> <span class=\"m-nav__link-text\"> Activity </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-chat-1\"></i> <span class=\"m-nav__link-text\"> Messages </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-info\"></i> <span class=\"m-nav__link-text\"> FAQ </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-lifebuoy\"></i> <span class=\"m-nav__link-text\"> Support </span> </a> </li>\r\n                    <li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n                    <li class=\"m-nav__item\"> <a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\"> Submit </a> </li>\r\n                  </ul>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  \r\n\t<smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\"></smart-search>\r\n  \r\n  \r\n<div class=\"m-content\">\r\n\t<div class=\"m-portlet__body\">\r\n\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>  \r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprlist.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OpprListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_startWith__ = __webpack_require__("../../../../rxjs/add/operator/startWith.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_startWith___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_rxjs_add_operator_startWith__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_observable_merge__ = __webpack_require__("../../../../rxjs/add/observable/merge.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_rxjs_add_observable_merge___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_rxjs_add_observable_merge__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_debounceTime__ = __webpack_require__("../../../../rxjs/add/operator/debounceTime.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_debounceTime___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_rxjs_add_operator_debounceTime__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_distinctUntilChanged__ = __webpack_require__("../../../../rxjs/add/operator/distinctUntilChanged.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_distinctUntilChanged___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_rxjs_add_operator_distinctUntilChanged__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_observable_fromEvent__ = __webpack_require__("../../../../rxjs/add/observable/fromEvent.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_add_observable_fromEvent___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_rxjs_add_observable_fromEvent__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__layouts_smart_search_smart_search_component__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};














var OpprListComponent = (function () {
    function OpprListComponent(_script, http, router) {
        this._script = _script;
        this.http = http;
        this.router = router;
        this.flyInOutTrigger = 'in';
        this.configSalesopprName = sessionStorage.getItem('configSalesopprName');
        this.smartHide = true;
        this.animateSmart = 'out';
        this.opprId = 0;
        console.log("sessionStorage.getItem('configSalesopprName')");
        console.log(sessionStorage.getItem('configSalesopprName'));
    }
    OpprListComponent.prototype.ngOnInit = function () {
        this.smart.smartUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/sales/opportunity-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-list';
    };
    OpprListComponent.prototype.toggleAnimation = function () {
        this.router.navigate(['sales/oppr-list/Oppradd'], { queryParams: { opprId: this.opprId } });
    };
    OpprListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    OpprListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this._script.load('.m-grid__item.m-grid__item--fluid.m-wrapper', 'assets/demo/default/custom/components/forms/widgets/bootstrap-select.js');
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    OpprListComponent.prototype.ngAfterViewInit = function () {
    };
    OpprListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'customerList') {
            this.router.navigate(['/customer/customerlist/'], { queryParams: { customerId: listParam[1] } });
        }
        if (listParam[0] == 'contactList') {
            this.router.navigate(['/customer/customercontactlist/'], { queryParams: { contactId: listParam[1] } });
        }
        if (listParam[0] == 'updateOpportunity') {
            this.opprId = listParam[1];
            this.router.navigate(['sales/oppr-list/Opprupdate'], { queryParams: { opprId: this.opprId } });
        }
        if (listParam[0] == 'addQuote') {
            this.opprId = listParam[1];
            this.toggleAnimation();
        }
        if (listParam[0] == 'addSalesOrder') {
            this.opprId = listParam[1];
            this.toggleAnimation();
        }
        if (listParam[0] == 'addSalesOrder') {
            this.opprId = listParam[1];
            this.toggleAnimation();
        }
        if (listParam[0] == 'opportunityDash') {
            this.opprId = listParam[1];
            this.router.navigate(['/sales/oppr-dash/'], { queryParams: { opprId: this.opprId } });
            var navigationExtras = {
                queryParams: {
                    "opprId": this.opprId,
                }
            };
            this.router.navigate(['/sales/oppr-dash/'], navigationExtras);
        }
    };
    return OpprListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_13__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_13__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__layouts_smart_search_smart_search_component__["b" /* SmartSearchComponent */]) === "function" && _a || Object)
], OpprListComponent.prototype, "smart", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], OpprListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], OpprListComponent.prototype, "list", void 0);
OpprListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/opprlist.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _e || Object])
], OpprListComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=opprlist.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprlist.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OpprListModule", function() { return OpprListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__opprlist_component__ = __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/opprlist.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__opprupdate_component__ = __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/opprupdate.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__oppr_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/oppr-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};














var routes = [
    {
        "path": "",
        "component": __WEBPACK_IMPORTED_MODULE_7__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_3__opprlist_component__["a" /* OpprListComponent */]
            },
        ]
    }, {
        "path": "Oppradd",
        "component": __WEBPACK_IMPORTED_MODULE_7__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_5__oppr_add_component__["a" /* OpprAddComponent */]
            },
        ]
    }, {
        "path": "Opprupdate",
        "component": __WEBPACK_IMPORTED_MODULE_7__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__opprupdate_component__["a" /* OpprUpdateComponent */]
            },
        ]
    }
];
var OpprListModule = (function () {
    function OpprListModule() {
    }
    return OpprListModule;
}());
OpprListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_6__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_8__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_9__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_9__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_10__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_11__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_12__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_13__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["w" /* MatRadioModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["H" /* MatTabsModule */]
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__opprlist_component__["a" /* OpprListComponent */], __WEBPACK_IMPORTED_MODULE_5__oppr_add_component__["a" /* OpprAddComponent */], __WEBPACK_IMPORTED_MODULE_4__opprupdate_component__["a" /* OpprUpdateComponent */],
        ],
    })
], OpprListModule);

//# sourceMappingURL=opprlist.module.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprupdate.component.html":
/***/ (function(module, exports) {

module.exports = "<base href = \"/\">\r\n         \r\n<toast></toast>\r\n<!--\t\t\t\t<div *ngIf=\"opprdash == flase\">-->\r\n\t\t\t\t<div [hidden]=\"addHide\" class=\"example-scrolling-content\">\r\n<!--\r\n\t\t\t  <div class=\"col-xl-4 order-1 order-xl-2 m--align-left\">\r\n\t\t\t\t\t\t<a  (click)=\"listData()\" class=\"btn btn-primary m-btn m-btn--custom m-btn--icon m-btn--air m-btn--pill\">\r\n\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t<i class=\"la flaticon-user\"></i>\r\n\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\tList  {{config.configSalesOpprName}}\r\n\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<div class=\"m-separator m-separator--dashed d-xl-none\"></div>\r\n\t\t\t\t\t</div>\r\n-->\r\n<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tAdd {{config.configSalesOpprName}} \r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tSales\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\t{{config.configSalesOpprName}} Update\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\t\t\t\t\t\r\n\t\t<div class=\"m-portlet m-portlet--head-solid-bg m-portlet--rounded m-portlet--bordered\">\r\n\t\t\t\t<div class=\"m-portlet__head\">\r\n\t\t\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t\t\tAdd {{config.configSalesOpprName}} \r\n\t\t\t\t\t\t\t</h2>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\t\t\r\n\t\t\t\r\n\r\n\t<form  (ngSubmit)=\"onSubmit()\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"opprForm\">\r\n\t\t<div class=\"m-portlet__body\">\r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n<!--\r\n\t\t<h5 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tClient Details\r\n\t\t</h5>\r\n-->\r\n\t\t<h3 class=\"text-center\"><label>Client Details</label></h3>\r\n\t\r\n\t\t<div class='col-md-12 row'>\r\n\t\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t\t<div style=\"margin-left: 5px;padding-top:30px\">\r\n\t\t\t  {{ config.configCustomerName}} : \r\n\t\t\t\t<span *ngIf=\"opportunity.opprCustomerId!='0'\">\r\n\t\t\t\t\t<a href=\"\">{{ opportunity.customerName}}</a>\r\n\t\t\t\t</span>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<div style=\"margin-left: 5px;padding-top:30px\">\r\n\t\t\t Contact:\r\n\t\t\t <span *ngIf=\"opportunity.opprContactId!='0'\">{{opportunity.titleId}}\r\n\t\t\t\t <a href=\"\">{{ opportunity.contactFname}}{{opportunity.contactLname}}</a>\r\n\t\t\t</span>\r\n\t\t\t\t</div>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.empOpportunityEdit == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput class='datepicker' name='opprDate' placeholder=\"Date\" [value]='opportunity.opprDate' >\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t\t<!--<mat-form-field>\r\n\t\t\t\t<input matInput [matDatepicker]=\"picker1\" placeholder=\"Date\">\r\n\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"picker1\"></mat-datepicker-toggle>\r\n\t\t\t\t<mat-datepicker #picker1></mat-datepicker>\r\n          \t</mat-form-field>-->\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6' *ngIf=\"config.empOpportunityEdit != '1'\" style=\"padding-top:30px;\">\r\n\t\t\t\t<div style=\"margin-left: 5px\">\r\n\t\t\t\tDate : {{opportunity.opprDate}}\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput class=\"datepicker\" name=\"opprCloseDate\" placeholder=\"Close Date\" [value]='opportunity.opprCloseDate' >\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\t<!--<mat-form-field>\r\n\t\t\t\t\t<input matInput [matDatepicker]=\"picker2\" placeholder=\"Close Date\">\r\n\t\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"picker2\"></mat-datepicker-toggle>\r\n\t\t\t\t\t<mat-datepicker #picker2></mat-datepicker>\r\n\t\t\t  </mat-form-field>-->\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Title\" [(ngModel)]=\"opportunity.opprTitle\" formControlName=\"opprTitle\">\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t  <mat-select placeholder=\"Select Branch\" [(ngModel)]=\"opportunity.opprBranchId\" formControlName=\"opprBranchId\">\r\n\t\t\t\t<mat-option *ngFor=\"let branch of branchs\" [value]=\"branch.key\">\r\n\t\t\t\t  {{  branch.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Description\" matAutosizeMinRows=\"2\" [(ngModel)]=\"opportunity.opprDesc\" formControlName=\"opprDesc\">\t\t\t\t\t\t\t\t\t\t\t\r\n    \t\t\t</textarea>\r\n    \t\t\t<mat-hint>(8000 Characters)</mat-hint>\r\n    \t\t\t\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Model\" (change)=\"populateItem(opprModelId.value)\" [(ngModel)]=\"opportunity.opprModelId\" formControlName=\"opprModelId\" required>\r\n\t\t\t\t<mat-option  *ngFor=\"let model of model\" [value]=\"model.key\">\r\n\t\t\t\t   {{ model.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t  <mat-error *ngIf=\"opprModelId.hasError('required')\">\r\n\t\t\t\tPlease select the Model\r\n\t\t\t\t</mat-error> \r\n\t\t\t</mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Item\"  [(ngModel)]=\"opportunity.opprItemId\" formControlName=\"opprItemId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let item of item\" [value]=\"item.key\">\r\n\t\t\t\t  {{ item.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t   <mat-error *ngIf=\"opprItemId.hasError('required')\">\r\n\t\t\t\t\t\tPlease select the Item\r\n\t\t\t\t\t</mat-error> \r\n\t\t\t</mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class='col-md-6' style=\"margin-top:10px;\">\r\n\t\t\t\t\t<div style=\"margin-left:5px\">\r\n\t\t\t\t\tAV Presentation:<mat-checkbox [(ngModel)]=\"opportunity.opprAvpresent\" formControlName=\"opprAvpresent\"></mat-checkbox>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6' style=\"margin-left:5px;margin-top:20px;\">\r\n\t\t\t\tManager Assistance:<mat-checkbox [(ngModel)]=\"opportunity.opprManagerAssist\" formControlName=\"opprManagerAssist\"></mat-checkbox>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t</mat-card>\r\n\t\t\t\r\n\t<mat-card style=\"margin-left:25px;\">\r\n\t<h3 class=\"text-center\"><label>{{config.configSalesOpprName}} Status</label></h3>\r\n<!--\r\n\t\t<h5 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t{{config.configSalesOpprName}} Status\r\n\t\t</h5><br>\r\n-->\r\n\t\t<div class='col-md-12 row'>\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Stage\" [(ngModel)]=\"opportunity.opprStageId\" formControlName=\"opprStageId\">\r\n\t\t\t\t<mat-option *ngFor=\"let  stage of  stage\" [value]=\" stage.key\">\r\n\t\t\t\t  {{  stage.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              </div>\r\n              <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Status\" [(ngModel)]=\"opportunity.opprStatusId\"  formControlName=\"opprStatusId\">\r\n\t\t\t\t<mat-option *ngFor=\"let  status of  status\" [value]=\" status.key\">\r\n\t\t\t\t  {{  status.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              </div>\r\n\t\t</div>\r\n            <div class='col-md-12 row' >\r\n            <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Status Comments\" matAutosizeMinRows=\"2\" [(ngModel)]=\"opportunity.opprStatusDesc\" formControlName=\"opprStatusDesc\">\t\t\r\n    \t\t\t</textarea>\r\n    \t\t\t<mat-hint>(1000 Characters)</mat-hint>\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n           <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Opportunity Priority\" [(ngModel)]=\"opportunity.opprPriorityopprId\" formControlName=\"opprPriorityopprId\">\r\n\t\t\t\t<mat-option *ngFor=\"let  priority of  priority\" [value]=\" priority.key\">\r\n\t\t\t\t  {{  priority.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              </div>\r\n           </div>\r\n           \r\n           <div class='col-md-12 row' >\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Team\" [(ngModel)]=\"opportunity.opprTeamId\" (change)=\"populateTeamExecutives(opprTeamId.value)\" formControlName=\"opprTeamId\">\r\n\t\t\t\t<mat-option *ngFor=\"let  team of  team\" [value]=\" team.key\">\r\n\t\t\t\t  {{  team.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n\r\n\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Executive\" [(ngModel)]=\"opportunity.opprEmpId\" formControlName=\"opprEmpId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let exe of exe\" [value]=\"exe.key\">\r\n\t\t\t\t  {{ exe.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t\t\t\r\n\t\t</div>\r\n</div>\r\n           \r\n         <div class='col-md-12 row'>   \r\n\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Project Management\"  [(ngModel)]=\"opportunity.opprPmId\" formControlName=\"opprPmId\">\r\n\t\t\t\t<mat-option *ngFor=\"let pm of pm\" [value]=\"pm.key\">\r\n\t\t\t\t {{ pm.name}}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\t\r\n\t\t</div>\r\n          <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\r\n\t\t\t\t <mat-select placeholder=\"Source of Enquiry\" [(ngModel)]=\"opportunity.opprSoeId\" formControlName=\"opprSoeId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  soe of  soe\" [value]=\" soe.key\">\r\n\t\t\t\t  {{  soe.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n  \r\n             </mat-form-field>\r\n\t\t</div>\r\n           </div>\r\n                     \r\n<div class='col-md-12 row'>  \r\n\t<div class='col-md-6' *ngIf=\"config.configSalesSob == '1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Source of Business\" [(ngModel)]=\"opportunity.opprSobId\" formControlName=\"opprSobId\" required>\r\n\t\t\t\t<mat-option *ngFor=\"let  sob of  sob\" [value]=\" sob.key\">\r\n\t\t\t\t  {{  sob.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n    <div class='col-md-6' *ngIf=\"config.configSalesCampaign == '1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Campaign\" [(ngModel)]=\"opportunity.opprCampaignId\" formControlName=\"opprCampaignId\">\r\n\t\t\t\t<mat-option *ngFor=\"let  campaign of  campaign\" [value]=\" campaign.key\">\r\n\t\t\t\t  {{  campaign.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n\t\t</div>\r\n     </div>\r\n           <div class='col-md-12 row'>\r\n\t<div class='col-md-6' *ngIf=\"config.configSalesOpprRefno == '1'\">\r\n\t\t<mat-form-field>\r\n\t\t<input matInput placeholder=\"Ref. No.\" [(ngModel)]=\"opportunity.opprRefno\" formControlName=\"opprRefno\" maxlength=\"3\" required>\t\r\n\t\t</mat-form-field>\r\n\t</div>\r\n\t\t<div class='col-md-6'>\r\n\t\t<mat-form-field>\t\t\r\n\t\t\t<textarea matInput placeholder=\"Notes\" matAutosizeMinRows=\"2\"  [(ngModel)]=\"opportunity.opprNotes\" formControlName=\"opprNotes\">\t</textarea>\r\n\t\t\t</mat-form-field>\r\n\t\t</div>\r\n\t</div>\r\n\t\r\n\t\t<div class='col-md-12 row' *ngIf=\"opportunity.opprId!='0'\">\r\n\t\t\t<div class='col-md-6' style=\"padding-top:30px;\">\r\n\t\t\t\tEntry By : <a href=\"\">{{opportunity.opprEntryBy}}</a>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6' style=\"padding-top:30px;\">\r\n\t\t\t\tEntry Date : <a href=\"\">{{opportunity.opprEntryDate}}</a>\r\n\t\t\t</div>\r\n\t\t</div>\r\n       \r\n         <div class='col-md-12 row' *ngIf=\"opportunity.opprModifiedId\">\r\n\t\t\t<div class='col-md-6' style=\"padding-top:30px;\">\r\n\t\t\t\tModified By : <a href=\"\">{{opportunity.opprModifiedBy}}</a>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6' style=\"padding-top:30px;\">\r\n\t\t\t\tModified Date : <a href=\"\">{{opportunity.opprModifiedDate}}</a>\r\n\t\t\t</div>\r\n\t\t</div> <br><br>\r\n         \r\n        <div class=\"col-md-12 text center\">\r\n\t\t\t<div class=\"btn-row\">\r\n\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button> \r\n\t\t\t\t <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" type=\"button\" class=\"btn btn-primary\"> Delete </button> \r\n\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"listData()\" type=\"button\"> Cancel </button>\r\n\t\t\t</div>\r\n\t\t</div>\r\n        \r\n         </mat-card> \r\n\r\n\t\t</div>\r\n\t</form>\r\n\t</div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprupdate.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OpprUpdateComponent; });
/* unused harmony export OpprtunityData */
/* unused harmony export ConfigDetails */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_16_rxjs_add_operator_filter__);
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
var PHONE_REGEX = /^[91]{2}-[80]{2}-[0-9]{8}$/;
var OpprUpdateComponent = (function () {
    function OpprUpdateComponent(_script, http, router, route) {
        this._script = _script;
        this.http = http;
        this.router = router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.opened = false;
        this.opprId = 0;
        //	opprId = 180758; 
        this.opportunity = new OpprtunityData();
        this.config = new ConfigDetails();
        this.msg = [];
        this.branchs = [];
        this.team = [];
        this.campaign = [];
        this.city = [
            { key: '1', name: 'Bangalore' },
            { key: '2', name: 'Mysore' },
            { key: '3', name: 'Manglore' }
        ];
        this.pm = [];
        this.soe = [];
        this.sob = [];
        this.exe = [];
        this.item = [];
        this.model = [];
        this.stage = [];
        this.status = [];
        this.priority = [];
        this.bootstrapFormValues = [];
        this.bootstrapMsg = '';
    }
    OpprUpdateComponent.prototype.ngOnInit = function () {
        //		this.route.queryParams.subscribe(params=>{
        //
        //			this.opprId = params["opprId"];
        //			this.contactId = params["contactId"];
        //			this.customerId= params["customerId"];
        //			
        //			console.log(this.opprId);
        //			console.log(this.contactId);
        //			console.log(this.customerId);
        //		});
        var _this = this;
        this.route.queryParams.filter(function (params) { return params.opprId; }).subscribe(function (params) {
            console.log(params);
            _this.opprId = params.opprId;
            console.log(_this.opprId);
        });
        this.populateData();
        this.opprForm = new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormGroup"]({
            'opprBranchId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'leadBranchId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprCustomerId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprContactId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'leadFname': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'leadLname': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'leadJobtitle': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'contactMobile1': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'contactMobile2': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'contactPhone1': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'contactPhone2': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'contactEmail1': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'contactEmail2': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'contactAddress': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'contactCityId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprTitle': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'contactPin': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprDesc': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprModelId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprItemId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprDate': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprCloseDate': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprEmpId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["Validators"].required]),
            'opprSoeId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprSobId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprCampaignId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprPmId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprNotes': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprTeamId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprRefno': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprAvpresent': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprManagerAssist': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprStageId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprStatusId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprStatusDesc': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'opprPriorityopprId': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
            'branchName': new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(OpprUpdateComponent.prototype, "opprCustomerId", {
        get: function () { return this.opprForm.get('opprCustomerId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprContactId", {
        get: function () { return this.opprForm.get('opprContactId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprTitle", {
        get: function () { return this.opprForm.get('opprTitle'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "leadFname", {
        get: function () { return this.opprForm.get('leadFname'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "leadLname", {
        get: function () { return this.opprForm.get('leadLname'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprBranchId", {
        get: function () { return this.opprForm.get('opprBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "leadBranchId", {
        get: function () { return this.opprForm.get('leadBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "leadJobtitle", {
        get: function () { return this.opprForm.get('leadJobtitle'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactMobile1", {
        get: function () { return this.opprForm.get('contactMobile1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactMobile2", {
        get: function () { return this.opprForm.get('contactMobile2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactPhone1", {
        get: function () { return this.opprForm.get('contactPhone1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactPhone2", {
        get: function () { return this.opprForm.get('contactPhone2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactEmail1", {
        get: function () { return this.opprForm.get('contactEmail1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactEmail2", {
        get: function () { return this.opprForm.get('contactEmail2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactAddress", {
        get: function () { return this.opprForm.get('contactAddress'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactCityId", {
        get: function () { return this.opprForm.get('contactCityId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "contactPin", {
        get: function () { return this.opprForm.get('contactPin'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprDesc", {
        get: function () { return this.opprForm.get('opprDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprModelId", {
        get: function () { return this.opprForm.get('opprModelId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprItemId", {
        get: function () { return this.opprForm.get('opprItemId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprDate", {
        get: function () { return this.opprForm.get('opprDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprCloseDate", {
        get: function () { return this.opprForm.get('opprCloseDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprTeamId", {
        get: function () { return this.opprForm.get('opprTeamId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprEmpId", {
        get: function () { return this.opprForm.get('opprEmpId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprSoeId", {
        get: function () { return this.opprForm.get('opprSoeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprSobId", {
        get: function () { return this.opprForm.get('opprSobId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprCampaignId", {
        get: function () { return this.opprForm.get('opprCampaignId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprPmId", {
        get: function () { return this.opprForm.get('opprPmId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprNotes", {
        get: function () { return this.opprForm.get('opprNotes'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprRefno", {
        get: function () { return this.opprForm.get('opprRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprAvpresent", {
        get: function () { return this.opprForm.get('opprAvpresent'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprManagerAssist", {
        get: function () { return this.opprForm.get('opprManagerAssist'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprStageId", {
        get: function () { return this.opprForm.get('opprStageId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprStatusId", {
        get: function () { return this.opprForm.get('opprStatusId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprStatusDesc", {
        get: function () { return this.opprForm.get('opprStatusDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "opprPriorityopprId", {
        get: function () { return this.opprForm.get('opprPriorityopprId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprUpdateComponent.prototype, "branchName", {
        get: function () { return this.opprForm.get('branchName'); },
        enumerable: true,
        configurable: true
    });
    ;
    OpprUpdateComponent.prototype.populateDropDownData = function () {
        var _this = this;
        this.opened = true;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', JSON.stringify({ emp_id: '0' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branchs = data['populateBranch'];
            console.log(_this.branchs);
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/soe ', JSON.stringify({ emp_id: '0' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.soe = data['populateSoe'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/sob ', JSON.stringify({ emp_id: '0' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.sob = data['populateSob'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/opportunitymodel ', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.model = data['populateOpportunityModel'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.team = data['populateTeam'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/campaign', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.campaign = data['populateCampaign'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.config = data['populateconfigdetails'][0];
            console.log(_this.config);
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/projectmanager', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.pm = data['populateProjectManager'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/stage', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.stage = data['populateStage'];
            console.log(_this.stage);
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/opportunitystatus', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.status = data['populateOpportunityStatus'];
            console.log(_this.status);
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/opprpriority', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.priority = data['populatePriority'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/item ', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.item = data['populateItem'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.exe = data['populateExecutive'];
        });
    };
    OpprUpdateComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-data', JSON.stringify({ opprId: this.opprId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.opportunity = data['populateOpprData'][0];
            console.log(_this.opportunity);
        }, function (err) {
            /* this function is executed when there's an ERROR */
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
        });
    };
    OpprUpdateComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/demo/default/custom/components/forms/widgets/select2.js', function () {
        });
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
    };
    OpprUpdateComponent.prototype.onSubmit = function () {
        var _this = this;
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            this.opportunity[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
            console.log('contactId----' + this.opportunity.opprContactId);
            if (this.bootstrapFormValues[i].name == "opprDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter Date!<br>';
                    this.opportunitydatemsg = "<font class='errorMsg'>Enter Date</font>";
                }
                else {
                    this.opportunitydatemsg = "";
                }
            }
            if (this.bootstrapFormValues[i].name == "opprCloseDate") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.bootstrapMsg = this.bootstrapMsg + 'Enter Close Date!<br>';
                    this.opportunitycloseddatemsg = "<font class='errorMsg'>Enter Close Date</font>";
                }
                else {
                    this.opportunitycloseddatemsg = "";
                }
            }
        }
        if (this.bootstrapMsg != '') {
            this.msg[0] = 'Error';
            this.msg[1] = 'Enter the Mandatory Fields';
            this.toast.showtoast(this.msg);
            this.bootstrapMsg = '';
        }
        //  OpprListComponent.customValidate1 = "1";
        if (!this.opprForm.invalid && this.bootstrapMsg == '') {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.opportunity['requestType'] = 'update';
            this.opportunity['opprId'] = this.opprId + '';
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity', JSON.stringify(this.opportunity), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
                    _this.opprForm.reset();
                    _this.router.navigate(["/sales/oppr-list"]);
                }
            });
        }
    };
    OpprUpdateComponent.prototype.onDelete = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity', JSON.stringify({ requestType: 'delete',
            opprId: this.opprId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.opprForm.reset();
            _this.router.navigate(["/sales/oppr-list"]);
        });
    };
    OpprUpdateComponent.prototype.populateItem = function (value) {
        var _this = this;
        this.opportunity.opprItemId == '0';
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/item ', JSON.stringify({ modelId: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.item = data['populateItem'];
        });
    };
    OpprUpdateComponent.prototype.populateTeamExecutives = function (value) {
        var _this = this;
        this.opportunity.opprEmpId = '0';
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({ teamId: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.exe = data['populateExecutive'];
        });
    };
    OpprUpdateComponent.prototype.listData = function () {
        this.router.navigate(["/sales/oppr-list"]);
    };
    return OpprUpdateComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_material__["D" /* MatSort */]) === "function" && _a || Object)
], OpprUpdateComponent.prototype, "sort", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_15__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_15__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_15__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _b || Object)
], OpprUpdateComponent.prototype, "toast", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], OpprUpdateComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_6__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__list_list_component__["a" /* ListComponent */]) === "function" && _c || Object)
], OpprUpdateComponent.prototype, "list", void 0);
OpprUpdateComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/opprupdate.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_14__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__angular_router__["Router"]) === "function" && _f || Object, typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_14__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_14__angular_router__["ActivatedRoute"]) === "function" && _g || Object])
], OpprUpdateComponent);

var OpprtunityData = (function () {
    function OpprtunityData() {
        this.opprCloseDate = '';
        this.opprDate = '';
        this.opprContactId = "0";
        this.leadId = "0";
        this.leadBranchId = "0";
    }
    return OpprtunityData;
}());

var ConfigDetails = (function () {
    function ConfigDetails() {
        this.empOpportunityEdit = "1";
        this.configSalesOpprRefno = "0";
    }
    return ConfigDetails;
}());

var _a, _b, _c, _d, _e, _f, _g;
//# sourceMappingURL=opprupdate.component.js.map

/***/ })

});
//# sourceMappingURL=opprlist.module.chunk.js.map