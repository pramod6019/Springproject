webpackJsonp(["opprdash.module"],{

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprdash.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\t\r\nstyles: ['\r\n.mat-form-field-underline{ bottom: 0.25em } \r\n.mat-form-field-wrapper{ padding-bottom: 0.25em } \r\n.mat-form-field{ padding-top: 15px } \r\n.mat-form-field{ line-height: 2.5 }'\r\n],\r\n ", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprdash.component.html":
/***/ (function(module, exports) {

module.exports = "<!-- BEGIN: Subheader -->\r\n\r\n      <base href = \"/\">\r\n         \r\n\r\n  <div class=\"col-xl-4 order-1 order-xl-2 m--align-left\">\r\n\t\t<a (click)=\"listData()\" class=\"btn btn-primary m-btn m-btn--custom m-btn--icon m-btn--air m-btn--pill\">\r\n\t\t\t\t<span>\r\n\t\t\t\t\t<i class=\"la flaticon-user\"></i>\r\n\t\t\t\t\t<span>\r\n\t\t\t\t\t\tList {{config.configSalesOpprName}} \r\n\t\t\t\t\t</span>\r\n\t\t\t\t</span>\r\n\t\t\t</a>\r\n\t\t\t<div class=\"m-separator m-separator--dashed d-xl-none\"></div>\r\n\t\t</div>\r\n\t\t\t\t\t\r\n\t\t<div class=\"mr-auto\" style=\"margin: 25px\">\r\n\t\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t\t{{config.configSalesOpprName}} Dash\r\n\t\t\t\t</h3>\r\n\t\t</div>\r\n\t<form (ngSubmit)=\"onSubmit()\" [formGroup]=\"opprForm\" class=\"m-form m-form--fit m-form--label-align-right\" id=\"m_form_1\" [formGroup]=\"opprForm\">\r\n\t  <div class=\"m-portlet__body\">\r\n\r\n\t\t<mat-tab-group color=\"primary\" (selectedTabChange)=\"onLinkClick($event)\">\r\n\t\t<mat-tab label='Opportunity Details'>\r\n\t\t\r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\r\n\t\t<div class='col-md-12 row'>\r\n\t\t<div class='col-md-4'>\r\n\t\t\t{{config.configSalesOpprName}} ID : <a href=\"\">{{opportunity.opprId}}</a>\r\n\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-4'>\r\n\t\t\t\tBranch : <a href=\"\">{{opportunity.branchName}}</a>\r\n\t\t\t</div>\r\n\t\r\n\t\t<div class='col-md-4'>\r\n\t\t\tDate : <a href=\"\">{{opportunity.opprDate}}</a>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput [matDatepicker]=\"picker2\" placeholder=\"Close Date\">\r\n\t\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"picker2\"></mat-datepicker-toggle>\r\n\t\t\t\t\t<mat-datepicker #picker2></mat-datepicker>\r\n\t\t\t  </mat-form-field>\r\n\t\t\t   <span>{{this.closedatemsg}}</span>\r\n\t\t\t\t\t\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Title\" [(ngModel)]=\"opportunity.opprTitle\" formControlName=\"opprTitle\" name=\"opprTitle\" [value]=\"opportunity.opprTitle\" (change)=\"securityCheck(opprTitle.value, 'opprTitle')\">\r\n\t\t\t</mat-form-field>\r\n\t\t\t<span>{{this.titlemsg}}</span>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Description\" matAutosizeMinRows=\"2\" [(ngModel)]=\"opportunity.opprDesc\" formControlName=\"opprDesc\" [value]=\"opportunity.opprDesc\"  (change)=\"securityCheck(opprDesc.value, 'opprDesc')\">\t\t\t\t\t\t\t\t\t\t\t\r\n    \t\t\t</textarea>\r\n\t\t\t</mat-form-field>\r\n\t\t\t<span>{{this.descmsg}}</span>\r\n\t\t\t</div>\r\n\t\r\n\t\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Executive\" [(ngModel)]=\"opportunity.opprEmpId\" formControlName=\"opprEmpId\" required (change)=\"securityCheck(opprEmpId.value, 'opprEmpId')\">\r\n\t\t\t\t<mat-option *ngFor=\"let exe of exe\" [value]=\" exe.key\">\r\n\t\t\t\t  {{ exe.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              <span>{{this.exemsg}}</span>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n            \r\n            <div class='col-md-12 row'>\r\n             <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Model\" [(ngModel)]=\"opportunity.opprModelId\" formControlName=\"opprModelId\" required (change)=\"populateItem(opprModelId.value); securityCheck(opprModelId.value, 'opprModelId')\">\r\n\t\t\t\t<mat-option  *ngFor=\"let model of model\" [value]=\"model.key\">\r\n\t\t\t\t   {{ model.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t  \t</mat-form-field>\r\n\t\t\t  \t <span>{{this.modelmsg}}</span>\r\n\t\t\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Item\"  [(ngModel)]=\"opportunity.opprItemId\" formControlName=\"opprItemId\" required (change)=\"securityCheck(opprItemId.value, 'opprItemId')\">\r\n\t\t\t\t<mat-option *ngFor=\"let item of item\" [value]=\"item.key\">\r\n\t\t\t\t  {{ item.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t\t <span>{{this.itemmsg}}</span>\r\n\t\t\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t\tAV Presentation:<mat-checkbox [(ngModel)]=\"opportunity.opprAvpresent\" formControlName=\"opprAvpresent\" name=\"opprAvpresent\" [value]=\"opportunity.opprAvpresent\" #avpresent (change)=\"securityCheck(avpresent.value, avpresent.name)\"></mat-checkbox><br>\r\n\t\t\t\t\t<span>{{this.avpresentationmsg}}</span>\r\n\t\t\t\t</div>\r\n\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\tManager Assistance:<mat-checkbox [(ngModel)]=\"opportunity.opprManagerAssist\" formControlName=\"opprManagerAssist\" name=\"opprManagerAssist\" [value]=\"opportunity.opprManagerAssist\" #managerAssist (change)=\"securityCheck(managerAssist.value, managerAssist.name)\"></mat-checkbox><br>\r\n\t\t\t\t<span>{{this.managerassistancemsg}}</span>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</mat-card>\r\n\t\t\r\n\r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t\t<h5 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t{{config.configCustomerName}}\r\n\t\t\t</h5>\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'> \r\n\t\t\t<mat-form-field>\r\n\t\t\t<input matInput placeholder=\"Customer\" [(ngModel)]=\"opportunity.customerName\" formControlName=\"customerName\" name=\"customerName\" [value]=\"opportunity.customerName\" (change)=\"securityCheck(customerName.value, 'customerName')\">\r\n\t\t\t</mat-form-field>\r\n\t\t\t\t<span>{{this.customernamemsg}}</span>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t\t<div class='col-md-4'> \r\n\t\t\t  \t  <mat-form-field>\r\n\t\t\t\t\t\t<mat-select placeholder=\"Contact Name\" [(ngModel)]=\"opportunity.contactTitleId\" formControlName=\"contactTitleId\" (change)=\"securityCheck(contactTitleId.value, 'contactTitleId')\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let contactTitle of contactTitle\" [value]=\"contactTitle.key\">{{ contactTitle.name}}</mat-option>\r\n\t\t\t\t\t\t</mat-select>\r\n\t\t\t\t\t\t<mat-hint>Title</mat-hint>\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t <span>{{this.contacttitlemsg}}</span>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class='col-md-4'> \r\n\t\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t\t<input matInput placeholder=\"First Name\" [(ngModel)]=\"opportunity.contactFname\" formControlName=\"contactFname\" maxlength=\"255\" [value]=\"opportunity.contactFname\"  (change)=\"securityCheck(contactFname.value, 'contactFname')\">\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t</mat-form-field>\t\r\n\t\t\t\t\t<span>{{this.contactfnamemsg}}</span>\r\n\t\t\t\t  </div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-4'> \r\n\t\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t\t<input matInput placeholder=\"Last Name\" maxlength=\"255\" [(ngModel)]=\"opportunity.contactLname\" formControlName=\"contactLname\"[value]=\"opportunity.contactLname\"  (change)=\"securityCheck(contactLname.value, 'contactLname')\">\r\n\t\t\t\t\t</mat-form-field>\r\n\t\t\t\t\t\t<span>{{this.contactlnamemsg}}</span>\r\n\t\t\t\t</div> \r\n\t\t\t</div>\t\r\n\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Mobile 1\"  maxlength=\"13\" [(ngModel)]=\"opportunity.contactMobile1\" formControlName=\"contactMobile1\" name=\"contactMobile1\" [value]=\"opportunity.contactMobile1\" (change)=\"securityCheck(contactMobile1.value,'contactMobile1')\">\r\n\t\t\t</mat-form-field>\r\n\t\t\t\t<span>{{this.mobile1msg}}</span>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Mobile 2\" maxlength=\"13\"[(ngModel)]=\"opportunity.contactMobile2\" formControlName=\"contactMobile2\" name=\"contactMobile2\"  [value]=\"opportunity.contactMobile2\" (change)=\"securityCheck(contactMobile2.value,'contactMobile2')\">\r\n\t\t\t</mat-form-field>\r\n\t\t\t\t\t<span>{{this.mobile2msg}}</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t<div class='col-md-12 row'>\r\n\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Phone 1\"  maxlength=\"13\" [(ngModel)]=\"opportunity.contactPhone1\" formControlName=\"contactPhone1\" name=\"contactPhone1\"  [value]=\"opportunity.contactPhone1\" (change)=\"securityCheck(contactPhone1.value, 'contactPhone1')\">\r\n\t\t\t\t\r\n\t\t\t</mat-form-field>\r\n\t\t\t\t\t<span>{{this.phone1msg}}</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field >\r\n\t\t\t\t<input matInput placeholder=\"Phone 2\"  maxlength=\"13\" [(ngModel)]=\"opportunity.contactPhone2\" formControlName=\"contactPhone2\" name=\"contactPhone2\" #phone2 [value]=\"opportunity.contactPhone2\" (change)=\"securityCheck(contactPhone2.value, 'contactPhone2')\">\r\n\r\n\t\t\t</mat-form-field>\r\n\t\t\t\t<span>{{this.phone2msg}}</span>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Email 1\"[(ngModel)]=\"opportunity.contactEmail1\" formControlName=\"contactEmail1\" name=\"contactEmail1\" [value]=\"opportunity.contactEmail1\"  (change)=\"securityCheck(contactEmail1.value, 'contactEmail1')\" maxlength=\"255\">\r\n\t\t\t</mat-form-field>\r\n\t\t\t\t<span>{{this.email1msg}}</span>\r\n\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Email 2\" [(ngModel)]=\"opportunity.contactEmail2\"  formControlName=\"contactEmail2\" [value]=\"opportunity.contactEmail2\" (change)=\"securityCheck(contactEmail2.value, 'contactEmail2')\" maxlength=\"255\">\r\n             </mat-form-field>\r\n             <span>{{this.email2msg}}</span>\r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-12 row'>\r\n\t\t\t\t\t<div class='col-md-6' *ngIf=\"config.configCustomerAddress == '1'\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<textarea matInput placeholder=\"Address\" matAutosizeMinRows=\"2\" maxlength=\"255\" [(ngModel)]=\"opportunity.contactAddress\" formControlName=\"contactAddress\" name=\"contactAddress\" #address [value]=\"opportunity.contactAddress\" (change)=\"securityCheck(contactAddress.value, 'contactAddress')\">\t\r\n\t\t\t\t\t</textarea>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t\t <span>{{this.addressmsg}}</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class='col-md-6' *ngIf=\"!config.configCustomerAddress == '1'\">\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<textarea matInput placeholder=\"Address\" matAutosizeMinRows=\"2\" maxlength=\"255\" [(ngModel)]=\"opportunity.contactAddress\" formControlName=\"contactAddress\" name=\"contactAddress\" [value]=\"opportunity.contactEmail1\" #address (change)=\"securityCheck(contactAddress.value, 'contactAddress')\">\t\r\n\t\t\t\t\t\t</textarea>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t\t <span>{{this.addressmsg}}</span>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select City\"  [(ngModel)]=\"opportunity.contactCityId\" formControlName=\"contactCityId\" (change)=\"securityCheck(contactCityId.value, 'contactCityId')\">\r\n\t\t\t\t<mat-option *ngFor=\"let  city of  city\" [value]=\" city.key\">\r\n\t\t\t\t  {{  city.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t</mat-form-field>\r\n\t\t\t <span>{{this.citymsg}}</span>\r\n\t\t</div>\r\n\t</div>\r\n\t\t\t\r\n\t\t<div class='col-md-12 row'>\r\n\t\t<div class='col-md-6' *ngIf=\"config.configCustomerAddress=='1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Pin/Zip\" [(ngModel)]=\"opportunity.contactPin\" formControlName=\"contactPin\" maxlength=\"6\" name=\"contactPin\" [value]=\"opportunity.contactPin\" #contactpin (change)=\"securityCheck(contactPin.value, 'contactPin')\">\r\n             </mat-form-field>\r\n              <span>{{this.contactpinmsg}}</span>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t<div class='col-md-6' *ngIf=\"!config.configCustomerAddress=='1'\">\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Pin/Zip\" [(ngModel)]=\"opportunity.contactPin\" formControlName=\"contactPin\" maxlength=\"6\" name=\"contactPin\" [value]=\"opportunity.contactPin\" #contactpin (change)=\"securityCheck(contactPin.value, 'contactPin')\">\r\n             </mat-form-field>\r\n              <span>{{this.contactpinmsg}}</span>\r\n\t\t\t</div>\r\n\t\t\t\t<div class='col-md-6'></div>\r\n\t\t\t</div>\r\n\t\t</mat-card>\r\n\r\n\t\t\r\n\t\t\r\n\r\n\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<h5 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\tStatus\r\n\t\t</h5>\r\n\t\t\r\n\t\t<div class='col-md-12 row'>\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Stage\" [(ngModel)]=\"opportunity.opprStageId\" formControlName=\"opprStageId\" (change)=\"securityCheck(opprStageId.value, 'opprStageId')\">\r\n\t\t\t\t<mat-option *ngFor=\"let  stage of  stage\" [value]=\" stage.key\">\r\n\t\t\t\t  {{  stage.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n             <span>{{this.stagemsg}}</span>\r\n              </div>\r\n              <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Select Status\" [(ngModel)]=\"opportunity.opprStatusId\"  formControlName=\"opprStatusId\" (change)=\"onChangeStatus(opprStatusId.value, 'opprStatusId',statusdesc.value, lostCase1.value, lostCase2.value, lostCase3.value)\">\r\n\t\t\t\t<mat-option *ngFor=\"let  status of  status\" [value]=\" status.key\">\r\n\t\t\t\t  {{ status.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              <span>{{this.statusmsg}}</span>\r\n              <span>{{this.errormsg}}</span>\r\n              </div>\r\n\t\t</div>\r\n           \r\n           <div class='col-md-12 row' >\r\n            <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Status Comments\" matAutosizeMinRows=\"2\" [(ngModel)]=\"opportunity.opprStatusDesc\" formControlName=\"opprStatusDesc\" name=\"opprStatusDesc\" #statusdesc  [value]=\"opportunity.opprStatusDesc\" (change)=\"securityCheck(opprStatusDesc.value, 'opprStatusDesc');onChangeStatus(opprStatusId.value, 'opprStatusId', statusdesc.value, lostCase1.value,lostCase2.value,lostCase3.value);\">\t\t\r\n    \t\t\t</textarea>\r\n    \t\t\t\r\n\t\t\t</mat-form-field>\r\n\t\t\t <span>{{this.statusdescmsg}}</span>\r\n\t\t\t</div>\r\n          \r\n          <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"LostCase1\" [(ngModel)]=\"opportunity.opprLostcase1Id\"  formControlName=\"opprLostcase1Id\" #lostCase1 (change)=\"onChangeStatus(opprStatusId.value, 'opprStatusId', statusdesc.value,lostCase1.value,lostCase2.value,lostCase3.value);onChangeLostCase1(opprLostcase1Id.value)\">\r\n\t\t\t\t<mat-option *ngFor=\"let  lostcase1 of  lostcase1\" [value]=\" lostcase1.key\">\r\n\t\t\t\t  {{  lostcase1.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              <span>{{ this.lostcase1msg }}</span>\r\n              </div> \r\n           </div>\r\n           \r\n            <div class='col-md-12 row'>\r\n\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"LostCase2\"  #lostCase2 [(ngModel)]=\"opportunity.opprLostcase2Id\" formControlName=\"opprLostcase2Id\" (change)=\"onChangeLostCase2(opprLostcase2Id.value);onChangeStatus(opprStatusId.value, 'opprStatusId', statusdesc.value, lostCase1.value, lostCase2.value, lostCase3.value)\">\r\n\t\t\t\t<mat-option *ngFor=\"let  lostcase2 of  lostcase2\" [value]=\" lostcase2.key\">\r\n\t\t\t\t  {{ lostcase2.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              <span>{{this.lostcase2msg}}</span>\r\n              </div>\r\n\r\n              <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"LostCase3\" #lostCase3 [(ngModel)]=\"opportunity.opprLostcase3Id\" formControlName=\"opprLostcase3Id\" (change)=\"onChangeStatus(opprStatusId.value, 'opprStatusId', statusdesc.value, lostCase1.value, lostCase2.value, lostCase3.value)\">\r\n\t\t\t\t<mat-option *ngFor=\"let  lostcase3 of  lostcase3\" [value]=\" lostcase3.key\">\r\n\t\t\t\t  {{ lostcase3.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              <span>{{this.lostcase3msg}}</span>\r\n              </div>\r\n              \r\n\t\t</div>\r\n\t\t\r\n\t\t<div class='col-md-12 row'>\r\n\t\t    \r\n           <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Opportunity Priority\" [(ngModel)]=\"opportunity.opprPriorityopprId\" formControlName=\"opprPriorityopprId\" (change)=\"securityCheck(opprPriorityopprId.value, 'opprPriorityopprId')\">\r\n\t\t\t\t<mat-option *ngFor=\"let  priority of  priority\" [value]=\" priority.key\">\r\n\t\t\t\t  {{  priority.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\r\n              <span>{{this.prioritymsg}}</span>\r\n              </div>\r\n              \r\n              <div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t <mat-select placeholder=\"Project\"  [(ngModel)]=\"opportunity.opprProjectId\" formControlName=\"opprProjectId\" (change)=\"securityCheck(opprProjectId.value, 'opprProjectId')\">\r\n\t\t\t\t<mat-option *ngFor=\"let project of project\" [value]=\"project.key\">\r\n\t\t\t\t {{ project.name}}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n             </mat-form-field>\t\r\n              <span>{{this.projectmsg}}</span>\r\n\t\t</div>\r\n\t\t</div>\r\n\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6'>\r\n\t\t   <mat-form-field>\t\t\r\n\t\t\t<textarea matInput placeholder=\"Notes\" matAutosizeMinRows=\"2\"  [(ngModel)]=\"opportunity.opprNotes\" formControlName=\"opprNotes\" name=\"opprNotes\"  [value]=\"opportunity.opprNotes\" #notes (change)=\"securityCheck(opprNotes.value, 'opprNotes')\">\t</textarea>\r\n\t\t\t</mat-form-field>\r\n\t\t\t <span>{{this.notesmsg}}</span>\r\n\t\t</div>\r\n\t\t\r\n\r\n\t\t\r\n\t\t</div>\r\n\t\t<div class='col-md-12 row'>\r\n\t\t\t<div class='col-md-6' style=\"padding-top:30px;\">\r\n\t\t\t\tEntry By : <a href=\"\">{{opportunity.opprEntryBy}}</a>\r\n\t\t\t</div>\r\n\t\t\t<div class='col-md-6' style=\"padding-top:30px;\">\r\n\t\t\t\tEntry Date : <a href=\"\">{{opportunity.opprEntryDate}}</a>\r\n\t\t\t</div>\r\n\t\t</div>\r\n       \r\n </mat-card>\r\n\t\t</mat-tab>\r\n\t\t\r\n\t\t<mat-tab label='Follow-up'>\r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<br><h3>Follow-Up</h3>\r\n\t\t\t\t<br><br><table class=\"table table-bordered\">\r\n\t\t\t  <thead>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t\t<td>Client : <a href=\"\">{{ this.customer.customerName }}</a></td>\r\n\t\t\t\t\t\t<td>Contact : <a href=\"\">{{ this.customer.contactName }}</a></td>\r\n\t\t\t  \t\t\t<td>Mobile : {{ this.customer.contactMobile1}} </td>\t\t\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<td>Model :  {{ this.customer.modelName }}</td>\r\n\t\t\t  \t\t\t<td>Item :  {{ this.customer.itemName }}</td>\r\n\t\t\t  \t\t\t<td></td>\t\t\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\r\n\t\t<br><br><table class=\"table table-bordered\">\r\n\t\t\t  <thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<th>#</th>\r\n\t\t\t  \t\t\t<th>Time</th>\r\n\t\t\t  \t\t\t<th>Follow-up Type</th>\r\n\t\t\t  \t\t\t<th>Follow-up Description</th>\r\n\t\t\t  \t\t\t<th>Executive</th>\r\n\t\t\t  \t\t\t<th>Feedback By</th>\r\n\t\t\t  \t\t\t<th>Entry By</th>\r\n\t\t\t  \t\t\t\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t\t<tr *ngFor=\"let followup of followupData; let i = index;\">\r\n\t\t\t  \t\t\t<td>{{ i+1 }}</td>\r\n\t\t\t  \t\t\t<td>{{ this.followup.followupTime }}</td>\r\n\t\t\t  \t\t\t<td>{{ this.followup.followupType }}<br><a href=\"\">Delete Follow-up</a></td>\r\n\t\t\t  \t\t\t<td>{{ this.followup.followupDesc }}</td>\r\n\t\t\t\t\t\t<td><a href=\"\">{{ this.followup.followupEmpName }}</a></td>\r\n\t\t\t  \t\t\t<td>{{ this.followup.followupModifiedBy }}</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t<a href=\"#\" class=\"m-nav__link m-dropdown__toggle\">\r\n\t\t\t\t\t\t\t<span class=\"m-topbar__userpic\">\r\n\t\t\t\t\t\t\t\t<img [(src)]=\"imgUrl\" class=\"m--img-rounded m--marginless m--img-centered\" alt=\"\"/>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</a><br>\r\n\t\t\t\t\t\t<a href=\"\">{{ this.followup.followupEntryBy }}</a><br>{{ this.followup.followupTime }}</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  \r\n\t\t\t  \r\n\t\t\t\t<br><br><br><div class=\"m-portlet__body\" align=\"center\">\r\n\t\t\t  <div class='col-md-6'>\r\n\t\t\t  <mat-form-field>\r\n\t\t\t   <mat-select placeholder=\"Description\" [(ngModel)]=\"followup.followupFeedbacktypeId\" formControlName=\"followupFeedbacktypeId\">\r\n\t\t\t\t<mat-option *ngFor=\"let followupdesc of followupdesc\" [value]=\"followupdesc.key\">\r\n\t\t\t\t  {{ followupdesc.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t  </mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div *ngIf=\"opportunity.opprStatusId == '1'\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t<mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Feedback\"  [(ngModel)]=\"followup.followupDesc\" formControlName=\"followupDesc\">\t\t\t\t\t\t\t\t\t\t\t\r\n    \t\t\t</textarea>\r\n\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<input matInput [matDatepicker]=\"picker4\" placeholder=\"Next Follow-up Time\">\r\n\t\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"picker4\"></mat-datepicker-toggle>\r\n\t\t\t\t\t<mat-datepicker #picker4></mat-datepicker>\r\n\t\t\t   </mat-form-field>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class='col-md-6'>\r\n\t\t   <mat-form-field>\r\n\t\t\t   <mat-select placeholder=\"Next Follow-up Type\" [(ngModel)]=\"followup.followupFollowuptypeId\" formControlName=\"followupFollowuptypeId\">\r\n\t\t\t\t<mat-option *ngFor=\"let followuptype of followuptype\" [value]=\"followuptype.key\">\r\n\t\t\t\t {{ followuptype.name }}\r\n\t\t\t\t</mat-option>\r\n\t\t\t  </mat-select>\r\n\t\t\t  </mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-12 text center\">\r\n\t\t\t<div class=\"btn-row\">\r\n\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Submit </button> \r\n\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t</div>\r\n\t\t</mat-card>\r\n\t</mat-tab>\r\n\t\t\r\n\t<mat-tab label='CRM Follow-up'>\r\n\t\t\r\n\t\t <mat-card style=\"margin-left:25px;\">\r\n\t\t<br><h3>PSF Details</h3>\r\n\t\t\t\t<br><br><table class=\"table table-bordered\">\r\n\t\t\t  <thead>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<td>Client :  <a href=\"\">{{ this.customer.customerName }}</a></td>\r\n\t\t\t  \t\t\t<td>Contact : <a href=\"\">{{ this.customer.contactName }}</a></td>\r\n\t\t\t  \t\t\t<td>Mobile : <a href=\"\">{{ this.customer.contactMobile1}}</a></td>\t\r\n\t\t\t  \t\t\t<td>Item : {{ this.customer.itemName }} </td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  \r\n\t\t\t  <br><br><table class=\"table table-bordered\">\r\n\t\t\t  <thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<th>#</th>\r\n\t\t\t  \t\t\t<th>Time</th>\r\n\t\t\t  \t\t\t<th>Type</th>\r\n\t\t\t  \t\t\t<th>Days</th>\r\n\t\t\t  \t\t\t<th>Feedback Type</th>\r\n\t\t\t  \t\t\t<th>Description</th>\r\n\t\t\t  \t\t\t<th>Executive</th>\r\n\t\t\t  \t\t\t<th>Entry by</th>\r\n\t\t\t  \t\t\t<th>Update</th>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t\r\n\t\t\t  \t<tbody>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"center\" colspan=\"9\">CRM Follow-Up</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t  \t\t\t<tr *ngFor=\"let crmfollowup of crmfollowupData\">\r\n\t\t\t  \t\t\t<td>{{crmfollowup.crmOpprId}}</td>\r\n\t\t\t  \t\t\t<td>{{crmfollowup.crmFollowupTime}}</td>\r\n\t\t\t  \t\t\t<td>{{crmfollowup.crmtypeName}}</td>\r\n\t\t\t  \t\t\t<td>{{crmfollowup.crmdaysDaycount}}</td>\r\n\t\t\t  \t\t\t<td>{{crmfollowup.crmfeedbacktypeName}}</td>\r\n\t\t\t  \t\t\t<td>{{crmfollowup.crmDesc}}</td>\r\n\t\t\t  \t\t\t<td>{{crmfollowup.empName}}</td>\r\n\t\t\t  \t\t\t<td>{{crmfollowup.empName}}</td> \r\n\t\t\t\t\t\t<td><a href=\"\">Update CRM Follow-up</a></td>\t  \t\t\t\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  </mat-card>\r\n\t\t\t </mat-tab>\r\n\t\t\t \r\n\t\t<mat-tab label='Customer'> \r\n\t\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t\t<h3 align=\"center\">Customer Details</h3><br><br>\r\n\t\t\t\r\n\t\t\t<table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\" align=\"center\"><b><a href=\"\">{{ this.customer.customerName }}({{ this.customer.customerId }})</a></b></td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td width='200px'>Communication :</td>\r\n\t\t  \t\t\t<td>{{this.customer.customerMobile}}</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td>Address :</td>\r\n\t\t  \t\t\t<td>{{this.customer.customerAddress}}</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td>Landmark :</td>\r\n\t\t  \t\t\t<td>{{this.customer.customerLandmark}}</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td>Executive :</td>\r\n\t\t\t\t\t\t<td><a href=\"\">{{this.customer.executive}}</a></td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td>Branch :</td>\r\n\t\t\t\t\t\t<td><a href=\"\">{{this.customer.branchName}}</a></td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td>Since :</td>\r\n\t\t  \t\t\t<td>{{this.customer.customerSince}}</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td>Active :</td>\r\n\t\t  \t\t\t<td>{{this.customer.customerActive}}</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t<tr>\r\n\t\t\t\t\t<td>Notes :</td>\r\n\t\t  \t\t\t<td>{{this.customer.customerNotes}}</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  \r\n\t\t<br><br><table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<th>#</th>\r\n\t\t\t  \t\t\t<th>ID</th>\r\n\t\t\t  \t\t\t<th>Contact Person</th>\r\n\t\t\t  \t\t\t<th>Commuication</th>\r\n\t\t\t  \t\t\t<th>Address</th>\r\n\t\t\t  \t\t\t<th>Action</th> \r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t\r\n\t\t\t  \t\t<tr *ngFor=\"let contact of contactData; let i = index;\">\r\n\t\t\t\t\t\t<td>{{ i+1 }}</td>\r\n\t\t\t\t\t\t<td><a href=\"\">{{contact.contactId}}</a></td>\r\n\t\t\t  \t\t\t<td>{{contact.contactName}}</td>\r\n\t\t\t  \t\t\t<td>{{contact.contactMobile1}} {{contact.contactEmail1}}</td>\r\n\t\t\t  \t\t\t<td>{{contact.contactAddress}}</td>\r\n\t\t\t  \t\t\t<td><a href=\"\">Update Contact Person</a></td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  </mat-card>\r\n\t\t</mat-tab>\r\n\t\t\r\n\t\t<mat-tab label='Documents'>\r\n\t\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<th >#</th>\r\n\t\t\t  \t\t\t<th>ID</th>\r\n\t\t\t  \t\t\t<th>Document Details</th>\r\n\t\t\t  \t\t\t<th>Action</th> \r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n<!--\r\n\t\t\t  \t\t<tr *ngFor=\"let doc of ajaxData; let i = index;\">\r\n\t\t\t  \t\t\t<td>{{i+1}}</td>\r\n\t\t\t  \t\t\t<td>{{doc.docId}}</td>\r\n\t\t\t  \t\t\t<td>{{doc.docName}}</td>\r\n\t\t\t  \t\t\t<td>Action</td>\r\n\t\t\t  \t\t\t \r\n\t\t\t  \t\t</tr>\r\n-->\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t   </mat-card>\r\n\t\t\t  \r\n\t\t  </mat-tab>\r\n\t\t<mat-tab label='Quotes'> \r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr >\r\n\t\t\t  \t\t\t<th>#</th>\r\n\t\t\t  \t\t\t<th>ID</th>\r\n\t\t\t  \t\t\t<th>No</th>\r\n\t\t\t  \t\t\t<th>Voucher</th>\r\n\t\t\t  \t\t\t<th>Customer</th>\r\n\t\t\t  \t\t\t<th>Date</th> \r\n\t\t\t  \t\t\t<th>Narration</th>\r\n\t\t\t  \t\t\t<th>Amount</th>\r\n\t\t\t  \t\t\t<th>Executive</th>\r\n\t\t\t  \t\t\t<th>Branch</th> \r\n\t\t\t  \t\t\t<th>Action</th> \r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t \r\n\t\t\t  \t\t<tr *ngFor=\"let voucher of voucherData; let i = index;\">\r\n\t\t\t  \t\t\t<td>{{i+1}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNo}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.vouchertypeName}}<br>{{voucher.voucherAuthorize}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherCustomerId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherDate}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNarration}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherAmount}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.empName}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.branchName}}</td>\r\n\t\t\t  \t\t\t <td>update</td>\r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t\t\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\r\n\t\t </mat-card>\r\n\t\t</mat-tab>\r\n\t\t<mat-tab label='Sales Orders'> \r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<th>#</th>\r\n\t\t\t  \t\t\t<th>ID</th>\r\n\t\t\t  \t\t\t<th>No</th>\r\n\t\t\t  \t\t\t<th>Voucher</th>\r\n\t\t\t  \t\t\t<th>Customer</th>\r\n\t\t\t  \t\t\t<th>Date</th> \r\n\t\t\t  \t\t\t<th>Narration</th>\r\n\t\t\t  \t\t\t<th>Amount</th>\r\n\t\t\t  \t\t\t<th>Executive</th>\r\n\t\t\t  \t\t\t<th>Branch</th> \r\n\t\t\t  \t\t\t<th>Action</th> \r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n<!--\r\n\t\t\t  \t \r\n\t\t\t  \t\t<tr *ngFor=\"let voucher of ajaxData; let i = index;\">\r\n\t\t\t  \t\t\t<td>{{i+1}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNo}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.vouchertypeName}}<br>{{voucher.voucherAuthorize}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherCustomerId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherDate}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNarration}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherAmount}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.empName}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherBranchId}}</td>\r\n\t\t\t  \t\t\t <td>update</td>\r\n\t\t\t  \t\t</tr>\r\n-->\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  </mat-card>\r\n\t\t</mat-tab>\r\n\t\t<mat-tab label='Invoice'>\r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<th>#</th>\r\n\t\t\t  \t\t\t<th>ID</th>\r\n\t\t\t  \t\t\t<th>No</th>\r\n\t\t\t  \t\t\t<th>Voucher</th>\r\n\t\t\t  \t\t\t<th>Customer</th>\r\n\t\t\t  \t\t\t<th>Date</th> \r\n\t\t\t  \t\t\t<th>Narration</th>\r\n\t\t\t  \t\t\t<th>Amount</th>\r\n\t\t\t  \t\t\t<th>Executive</th>\r\n\t\t\t  \t\t\t<th>Branch</th> \r\n\t\t\t  \t\t\t<th>Action</th> \r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n<!--\r\n\t\t\t  \t \r\n\t\t\t  \t\t<tr *ngFor=\"let voucher of voucherData; let i = index;\">\r\n\t\t\t  \t\t\t<td>{{i+1}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNo}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.vouchertypeName}}<br>{{voucher.voucherAuthorize}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherCustomerId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherDate}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNarration}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherAmount}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.empName}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherBranchId}}</td>\r\n\t\t\t  \t\t\t <td>update</td>\r\n\t\t\t  \t\t</tr>\r\n-->\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  </mat-card>\r\n\t\t  </mat-tab>\r\n\t\t<mat-tab label='Receipt'> \r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr>\r\n\t\t\t  \t\t\t<th>#</th>\r\n\t\t\t  \t\t\t<th>ID</th>\r\n\t\t\t  \t\t\t<th>No</th>\r\n\t\t\t  \t\t\t<th>Voucher</th>\r\n\t\t\t  \t\t\t<th>Customer</th>\r\n\t\t\t  \t\t\t<th>Date</th> \r\n\t\t\t  \t\t\t<th>Narration</th>\r\n\t\t\t  \t\t\t<th>Amount</th>\r\n\t\t\t  \t\t\t<th>Executive</th>\r\n\t\t\t  \t\t\t<th>Branch</th> \r\n\t\t\t  \t\t\t<th>Action</th> \r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n<!--\r\n\t\t\t  \t \r\n\t\t\t  \t\t<tr *ngFor=\"let voucher of voucherData; let i = index;\">\r\n\t\t\t  \t\t\t<td>{{i+1}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNo}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.vouchertypeName}}<br>{{voucher.voucherAuthorize}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherCustomerId}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherDate}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherNarration}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherAmount}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.empName}}</td>\r\n\t\t\t  \t\t\t<td>{{voucher.voucherBranchId}}</td>\r\n\t\t\t  \t\t\t <td>Update Voucher</td>\r\n\r\n\t\t\t  \t\t</tr>-->\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t\t  </mat-card>\r\n\t\t  </mat-tab>\r\n\t\t<mat-tab label='History'>\r\n\t\t<mat-card style=\"margin-left:25px;\">\r\n\t\t<table class=\"table table-bordered table-responsive\">\r\n\t\t\t  \t<thead class=\"bg-primary\">\r\n\t\t\t  \t\t<tr> \r\n\t\t\t  \t\t\t<th>Date</th>\r\n\t\t\t  \t\t\t<th>Action By</th>\r\n\t\t\t  \t\t\t<th>Type of Action</th>\r\n\t\t\t  \t\t\t<th>New Value</th> \r\n\t\t\t  \t\t\t<th>Old Value</th>\r\n\t\t\t  \t\t\t</tr>\r\n\t\t\t  \t</thead>\r\n\t\t\t  \t<tbody>\r\n\t\t\t  \t  <tr *ngFor=\"let history of historyData\">\r\n\t\t\t  \t\t\t<td>{{history.historyDatetime}}</td>\r\n\t\t\t  \t\t\t<td>{{history.historyEmpName}}</td>\r\n\t\t\t  \t\t\t<td>{{history.historyActiontype}}</td>\r\n\t\t\t  \t\t\t<td>{{history.historyNewvalue}}</td>\r\n\t\t\t  \t\t\t<td>{{history.historyOldvalue}}</td> \r\n\t\t\t  \t\t</tr>\r\n\t\t\t  \t</tbody>\r\n\t\t\t  </table>\r\n\t\t </mat-card>\r\n\t\t </mat-tab>\r\n\t</mat-tab-group>\r\n</div>\r\n</form>\r\n\r\n\r\n\r\n          \r\n"

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprdash.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OpprDashComponent; });
/* unused harmony export OpprtunityDashData */
/* unused harmony export ConfigDetails */
/* unused harmony export FollowUp */
/* unused harmony export CustomerDetails */
/* unused harmony export voucherData */
/* unused harmony export ContactDetails */
/* unused harmony export OpprHistoryData */
/* unused harmony export Crmfollowup */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__ = __webpack_require__("../../../../../src/app/_services/script-loader.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_13_rxjs_add_operator_filter__);
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
var OpprDashComponent = (function () {
    function OpprDashComponent(_script, http, router, route) {
        this._script = _script;
        this.http = http;
        this.router = router;
        this.route = route;
        this.opened = false;
        this.opprId = 0;
        this.opportunity = new OpprtunityDashData();
        this.config = new ConfigDetails();
        this.voucher = new voucherData();
        this.followup = new FollowUp();
        this.crmfollowup = new Crmfollowup();
        this.customer = new CustomerDetails();
        this.tab = 1;
        this.branchs = [];
        this.team = [];
        this.campaign = [];
        this.configdetails = [];
        this.city = [
            { key: '1', name: 'Bangalore' },
            { key: '2', name: 'Mysore' },
            { key: '3', name: 'Manglore' }
        ];
        this.project = [];
        this.soe = [];
        this.sob = [];
        this.empcount = [];
        this.type = [];
        this.exe = [];
        this.item = [];
        this.model = [];
        this.contactTitle = [];
        this.lostcase1 = [];
        this.lostcase2 = [];
        this.lostcase3 = [];
        this.stage = [];
        this.status = [];
        this.priority = [];
        this.followupdesc = [];
        this.followuptype = [];
    }
    OpprDashComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.queryParams.filter(function (params) { return params.opprId; }).subscribe(function (params) {
            console.log(params);
            _this.opprId = params.opprId;
            console.log(_this.opprId);
        });
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.config = data['populateconfigdetails'][0];
            console.log(_this.config);
        });
        this.populateData();
        this.opprForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'opprBranchId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'leadBranchId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprCustomerId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprContactId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactFname': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactLname': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'leadJobtitle': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactMobile1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'contactMobile2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'contactPhone1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactPhone2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactEmail1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'contactEmail2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'contactAddress': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactCityId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprTitle': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactPin': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprDesc': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprModelId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprItemId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprCloseDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprEmpId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'opprSoeId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprSobId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprCampaignId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprPmId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprNotes': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprTeamId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprRefno': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprAvpresent': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprManagerAssist': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'contactTitleId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprCustomerName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprStageId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprStatusId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprStatusDesc': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprPriorityopprId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'branchName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprProjectId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprLostcase1Id': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprLostcase2Id': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'opprLostcase3Id': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'customerName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'followupFollowupTime': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'followupFollowuptypeId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'followupDesc': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'followupFeedbacktypeId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(OpprDashComponent.prototype, "opprCustomerName", {
        get: function () { return this.opprForm.get('opprCustomerName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprCustomerId", {
        get: function () { return this.opprForm.get('opprCustomerId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprContactId", {
        get: function () { return this.opprForm.get('opprContactId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprTitle", {
        get: function () { return this.opprForm.get('opprTitle'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactFname", {
        get: function () { return this.opprForm.get('contactFname'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactLname", {
        get: function () { return this.opprForm.get('contactLname'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprBranchId", {
        get: function () { return this.opprForm.get('opprBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "leadBranchId", {
        get: function () { return this.opprForm.get('leadBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "leadJobtitle", {
        get: function () { return this.opprForm.get('leadJobtitle'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactMobile1", {
        get: function () { return this.opprForm.get('contactMobile1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactMobile2", {
        get: function () { return this.opprForm.get('contactMobile2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactPhone1", {
        get: function () { return this.opprForm.get('contactPhone1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactPhone2", {
        get: function () { return this.opprForm.get('contactPhone2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactEmail1", {
        get: function () { return this.opprForm.get('contactEmail1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactEmail2", {
        get: function () { return this.opprForm.get('contactEmail2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactAddress", {
        get: function () { return this.opprForm.get('contactAddress'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactCityId", {
        get: function () { return this.opprForm.get('contactCityId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactPin", {
        get: function () { return this.opprForm.get('contactPin'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprDesc", {
        get: function () { return this.opprForm.get('opprDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprModelId", {
        get: function () { return this.opprForm.get('opprModelId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprItemId", {
        get: function () { return this.opprForm.get('opprItemId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprDate", {
        get: function () { return this.opprForm.get('opprDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprCloseDate", {
        get: function () { return this.opprForm.get('opprCloseDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprTeamId", {
        get: function () { return this.opprForm.get('opprTeamId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprEmpId", {
        get: function () { return this.opprForm.get('opprEmpId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprSoeId", {
        get: function () { return this.opprForm.get('opprSoeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprSobId", {
        get: function () { return this.opprForm.get('opprSobId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprCampaignId", {
        get: function () { return this.opprForm.get('opprCampaignId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprPmId", {
        get: function () { return this.opprForm.get('opprPmId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprNotes", {
        get: function () { return this.opprForm.get('opprNotes'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprRefno", {
        get: function () { return this.opprForm.get('opprRefno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprAvpresent", {
        get: function () { return this.opprForm.get('opprAvpresent'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprManagerAssist", {
        get: function () { return this.opprForm.get('opprManagerAssist'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "contactTitleId", {
        get: function () { return this.opprForm.get('contactTitleId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprStageId", {
        get: function () { return this.opprForm.get('opprStageId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprStatusId", {
        get: function () { return this.opprForm.get('opprStatusId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprStatusDesc", {
        get: function () { return this.opprForm.get('opprStatusDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprPriorityopprId", {
        get: function () { return this.opprForm.get('opprPriorityopprId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "branchName", {
        get: function () { return this.opprForm.get('branchName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprProjectId", {
        get: function () { return this.opprForm.get('opprProjectId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprLostcase1Id", {
        get: function () { return this.opprForm.get('opprLostcase1Id'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprLostcase2Id", {
        get: function () { return this.opprForm.get('opprLostcase2Id'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "opprLostcase3Id", {
        get: function () { return this.opprForm.get('opprLostcase3Id'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "customerName", {
        get: function () { return this.opprForm.get('customerName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "followupFollowupTime", {
        get: function () { return this.opprForm.get('followupFollowupTime'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "followupFollowuptypeId", {
        get: function () { return this.opprForm.get('followupFollowuptypeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "followupDesc", {
        get: function () { return this.opprForm.get('followupDesc'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(OpprDashComponent.prototype, "followupFeedbacktypeId", {
        get: function () { return this.opprForm.get('followupFeedbacktypeId'); },
        enumerable: true,
        configurable: true
    });
    ;
    OpprDashComponent.prototype.populateDropDownData = function () {
        var _this = this;
        this.opened = true;
        //		  if(this.opprId == 0){
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', JSON.stringify({ emp_id: '0' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.opportunity.selectedKey = data['selectedKey'];
            _this.branchs = data['populateBranch'];
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
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/contact ', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.contactTitle = data['populateContactTitle'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/team', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.team = data['populateteam'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/campaign', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.campaign = data['populatecampaign'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.config = data['populateconfigdetails'][0];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/populateProject', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.project = data['populateProject'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/currentdate', JSON.stringify({ requestType: 'shortDate' }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.opportunity.date = data['date'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamexecutives', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.exe = data['teamExecutives'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/item ', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.item = data['populateItem'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/stage', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.stage = data['populateStage'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/opportunitystatus', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.status = data['populateOpportunityStatus'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/opprpriority', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.priority = data['populatePriority'];
        });
        //	  			}
    };
    OpprDashComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'populateData',
            tab: this.tab,
            opprId: this.opprId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.opportunity = data['populateOpprData'][0];
            console.log(_this.opportunity + " oppr data");
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
        });
    };
    OpprDashComponent.prototype.ngAfterViewInit = function () {
    };
    OpprDashComponent.prototype.populateItem = function (value) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/item ', JSON.stringify({ modelId: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.item = data['populateItem'];
        });
    };
    OpprDashComponent.prototype.onChangeStatus = function (value, name, statusDesc, lostcase1, lostcase2, lostcase3) {
        var _this = this;
        console.log("value===" + value);
        if (!statusDesc) {
            statusDesc = "";
        }
        else {
            statusDesc = statusDesc;
        }
        if (!lostcase1) {
            lostcase1 = "";
        }
        else {
            lostcase1 = lostcase1;
        }
        if (!lostcase2) {
            lostcase2 = "";
        }
        else {
            lostcase2 = lostcase2;
        }
        if (!lostcase3) {
            lostcase3 = "";
        }
        else {
            lostcase3 = lostcase3;
        }
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'update',
            name: name,
            value: value,
            opprId: this.opprId,
            tab: this.tab,
            opprStatusDesc: statusDesc,
            opprLostcase1Id: lostcase1,
            opprLostcase2Id: lostcase2,
            opprLostcase3Id: lostcase3,
        }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.errormsg = data['statusMsg'];
            _this.statusmsg = data['msg'];
        });
        if (this.opportunity.opprStatusId != '2') {
            var headers_1 = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/lostcase1', JSON.stringify({}), { headers: headers_1, withCredentials: true }).subscribe(function (data) {
                _this.lostcase1 = data['PopulateLostCase1'];
            });
        }
    };
    OpprDashComponent.prototype.onChangeLostCase1 = function (value) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/lostcase2', JSON.stringify({ opprLostcase1Id: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.lostcase2 = data['PopulateLostCase2'];
        });
    };
    OpprDashComponent.prototype.onChangeLostCase2 = function (value) {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/lostcase3', JSON.stringify({ opprLostcase2Id: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.lostcase3 = data['PopulateLostCase3'];
        });
    };
    OpprDashComponent.prototype.onLinkClick = function (event) {
        var _this = this;
        this.tab = event.index + 1;
        console.log("tab==" + this.tab);
        if (this.tab == 2) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'populateData',
                followupOpprId: this.opprId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.followupData = data['followUpList'];
                _this.customer = data['customerDetails'];
                for (var i in _this.followupData) {
                    console.log(i);
                    _this.id = data['followUpList'][i].followupEntryId;
                    console.log(_this.id);
                    _this.imgUrl = sessionStorage.getItem('requestUrl') + '/axelacrm/portal/thumbnail?imgId=' + _this.id + '&type=empimg&width=80&height=80';
                }
            });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/followuptype', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.followuptype = data['populateFollowupType'];
            });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/followupdescription', JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.followupdesc = data['populateFollowupDescription'];
            });
        }
        else if (this.tab == 3) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'populateData',
                crmFollowupOpprId: this.opprId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.crmfollowupData = data['crmFollowUpList'];
                _this.customer = data['customerDetails'];
                console.log(_this.crmfollowupData);
            });
        }
        else if (this.tab == 4) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'populateData',
                customerOpprId: this.opprId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.customer = data['populateCustomerDetail'][0];
                _this.contactData = data['opprContactList'];
                if (_this.customer.customerActive == '1') {
                    _this.customer.customerActive = "Active";
                }
                else {
                    _this.customer.customerActive = "Inactive";
                }
            });
        }
        else if (this.tab == 5) {
        }
        else if (this.tab == 6) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'populateData',
                voucherOpprId: this.opprId,
                voucherClassId: "5",
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.voucherData = data['quoteList'];
                console.log(_this.voucherData);
            });
        }
        else if (this.tab == 7) {
        }
        else if (this.tab == 8) {
        }
        else if (this.tab == 9) {
        }
        else if (this.tab == 10) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'populateData',
                historyOpprId: this.opprId,
                tab: this.tab,
            }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.historyData = data['OpprHistory'];
                console.log(_this.historyData);
            });
        }
    };
    OpprDashComponent.prototype.listData = function () {
        this.router.navigate(["/sales/oppr-list"]);
    };
    OpprDashComponent.prototype.securityCheck = function (value, name) {
        //		alert(this.opprId+" "+value+" "+name);
        var _this = this;
        if (name == 'opprAvpresent' || name == 'opprManagerAssist') {
            if (value == true)
                value = '0';
            else
                value = '1';
        }
        var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'update',
            opprId: this.opprId,
            tab: this.tab,
            name: name,
            value: value }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            if (name == 'contactEmail1') {
                _this.email1msg = data['msg'];
            }
            else if (name == 'contactEmail2') {
                _this.email2msg = data['msg'];
            }
            else if (name == 'opprTitle') {
                _this.titlemsg = data['msg'];
            }
            else if (name == 'opprDesc') {
                _this.descmsg = data['msg'];
            }
            else if (name == 'opprAvpresent') {
                _this.avpresentationmsg = data['msg'];
            }
            else if (name == 'opprManagerAssist') {
                _this.managerassistancemsg = data['msg'];
            }
            else if (name == 'customerName') {
                _this.customernamemsg = data['msg'];
            }
            else if (name == 'contactFname') {
                _this.contactfnamemsg = data['msg'];
            }
            else if (name == 'contactLname') {
                _this.contactlnamemsg = data['msg'];
            }
            else if (name == 'opprEmpId') {
                _this.exemsg = data['msg'];
            }
            else if (name == 'opprModelId') {
                _this.modelmsg = data['msg'];
            }
            else if (name == 'opprItemId') {
                _this.itemmsg = data['msg'];
            }
            else if (name == 'contactTitleId') {
                _this.contacttitlemsg = data['msg'];
            }
            else if (name == 'contactMobile1') {
                _this.mobile1msg = data['msg'];
            }
            else if (name == 'contactMobile2') {
                _this.mobile2msg = data['msg'];
            }
            else if (name == 'contactPhone1') {
                _this.phone1msg = data['msg'];
            }
            else if (name == 'contactPhone2') {
                _this.phone2msg = data['msg'];
            }
            else if (name == 'contactAddress') {
                _this.addressmsg = data['msg'];
            }
            else if (name == 'contactCityId') {
                _this.citymsg = data['msg'];
            }
            else if (name == 'contactPin') {
                _this.contactpinmsg = data['msg'];
            }
            else if (name == 'opprStageId') {
                _this.stagemsg = data['msg'];
            }
            else if (name == 'opprStatusId') {
                _this.statusmsg = data['msg'];
                _this.errormsg = data['statusMsg'];
            }
            else if (name == 'opprStatusDesc') {
                _this.statusdescmsg = data['msg'];
            }
            else if (name == 'opprLostcase1Id') {
                _this.lostcase1msg = data['msg'];
            }
            else if (name == 'opprLostcase2Id') {
                _this.lostcase2msg = data['msg'];
            }
            else if (name == 'opprLostcase3Id') {
                _this.lostcase3msg = data['msg'];
            }
            else if (name == 'opprPriorityopprId') {
                _this.prioritymsg = data['msg'];
            }
            else if (name == 'opprProjectId') {
                _this.projectmsg = data['msg'];
            }
            else if (name == 'opprNotes') {
                _this.notesmsg = data['msg'];
            }
        });
    };
    OpprDashComponent.prototype.onSubmit = function () {
        var _this = this;
        alert("submit");
        if (!this.opprForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            this.followup['requestType'] = 'update';
            this.followup['followupOpprId'] = this.opprId + '';
            this.followup['tab'] = this.tab + '';
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify(this.followup), { headers: headers, withCredentials: true }).subscribe(function (data) {
                var headers = new __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
                _this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/sales/opportunity-dash', JSON.stringify({ requestType: 'populateData',
                    followupOpprId: _this.opprId,
                    tab: _this.tab,
                }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                    _this.followupData = data['followUpList'];
                    _this.customer = data['customerDetails'];
                    for (var i in _this.followupData) {
                        console.log(i);
                        _this.id = data['followUpList'][i].followupEntryId;
                        console.log(_this.id);
                        _this.imgUrl = sessionStorage.getItem('requestUrl') + '/axelacrm/portal/thumbnail?imgId=' + _this.id + '&type=empimg&width=80&height=80';
                    }
                });
            });
        }
        this.opprForm.reset();
    };
    return OpprDashComponent;
}());
OpprDashComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/opprdash.component.html"),
        styles: [__webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/opprdash.component.css")],
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [
            __WEBPACK_IMPORTED_MODULE_2__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */],
            __WEBPACK_IMPORTED_MODULE_3__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]
        ],
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_script_loader_service__["a" /* ScriptLoaderService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _d || Object])
], OpprDashComponent);

var OpprtunityDashData = (function () {
    function OpprtunityDashData() {
        this.opprContactId = "0";
        this.leadId = "0";
        this.leadBranchId = "0";
        this.opprStatusDesc = "";
        this.opprLostcase1Id = "";
        this.opprLostcase2Id = "";
        this.opprLostcase3Id = "";
    }
    return OpprtunityDashData;
}());

var ConfigDetails = (function () {
    function ConfigDetails() {
        this.empOpportunityEdit = "0";
        this.configSalesOpprRefno = "0";
    }
    return ConfigDetails;
}());

var FollowUp = (function () {
    function FollowUp() {
    }
    return FollowUp;
}());

var CustomerDetails = (function () {
    function CustomerDetails() {
    }
    return CustomerDetails;
}());

var voucherData = (function () {
    function voucherData() {
    }
    return voucherData;
}());

var ContactDetails = (function () {
    function ContactDetails() {
    }
    return ContactDetails;
}());

var OpprHistoryData = (function () {
    function OpprHistoryData() {
    }
    return OpprHistoryData;
}());

var Crmfollowup = (function () {
    function Crmfollowup() {
    }
    return Crmfollowup;
}());

var _a, _b, _c, _d;
//# sourceMappingURL=opprdash.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/sales/opprlist/opprdash.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OpprDashModule", function() { return OpprDashModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__opprdash_component__ = __webpack_require__("../../../../../src/app/theme/pages/sales/opprlist/opprdash.component.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__opprdash_component__["a" /* OpprDashComponent */]
            },
        ]
    }
];
var OpprDashModule = (function () {
    function OpprDashModule() {
    }
    return OpprDashModule;
}());
OpprDashModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_4__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_6__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_7__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_8__list_list_module__["a" /* ListModule */],
            __WEBPACK_IMPORTED_MODULE_9__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["w" /* MatRadioModule */], __WEBPACK_IMPORTED_MODULE_9__angular_material__["H" /* MatTabsModule */]
        ], exports: [
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]
        ], declarations: [
            __WEBPACK_IMPORTED_MODULE_3__opprdash_component__["a" /* OpprDashComponent */],
        ],
    })
], OpprDashModule);

//# sourceMappingURL=opprdash.module.js.map

/***/ })

});
//# sourceMappingURL=opprdash.module.chunk.js.map