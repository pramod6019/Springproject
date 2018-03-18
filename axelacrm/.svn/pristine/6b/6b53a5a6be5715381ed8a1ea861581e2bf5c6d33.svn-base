webpackJsonp(["executive-list.module"],{

/***/ "../../../../../src/app/theme/pages/portal/executive-list/ececutive-list.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/* CSS Document */\r\n\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/executive-list/executive-add.component.html":
/***/ (function(module, exports) {

module.exports = "\t<toast></toast>\r\n\t\r\n\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\t{{status}} Executive \r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/manager\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tBussiness Manager\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a (click)=\"toggleAnimation()\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tExecutive List:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row theme\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\t{{status}} Executive\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<form class=\"m-form m-form--fit m-form--label-align-right\" (ngSubmit)=\"onSubmit()\"  id=\"m_form_1\" [formGroup]=\"empForm\">\r\n\t\t\t \r\n\t<div class=\"m-portlet__body row\">\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Name*\" [(ngModel)]=\"emp.empName\" formControlName=\"empName\" maxlength=\"255\">\r\n\t\t\t\t\t <mat-error *ngIf=\"empName.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Name\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class='col-md-6'>\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<input matInput placeholder=\"Reference No.*\" [(ngModel)]=\"emp.empRefNo\" formControlName=\"empRefNo\" maxlength=\"50\">\r\n\t\t\t\t\t <mat-error *ngIf=\"empRefNo.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Refference No.\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t \r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Role*\" [(ngModel)]=\"emp.empRoleId\" formControlName=\"empRoleId\" (change)=\"branchselect(empRoleId.value);\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let roleData of role\" [value]=\"roleData.key\">\r\n\t\t\t\t\t  {{ roleData.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  \r\n\t\t\t\t\t<mat-error *ngIf=\"empRoleId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Role\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Department*\" [(ngModel)]=\"emp.empDepartmentId\" formControlName=\"empDepartmentId\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let dept of department\" [value]=\"dept.key\">\r\n\t\t\t\t\t  {{ dept.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  <mat-error *ngIf=\"empDepartmentId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Department\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t \r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Job Title*\" [(ngModel)]=\"emp.empJobtitleId\" formControlName=\"empJobtitleId\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let job of jobtitle\" [value]=\"job.key\">\r\n\t\t\t\t\t  {{ job.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  <mat-error *ngIf=\"empJobtitleId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Job Title\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6 row\">\r\n\t\t\t  <div class=\"col-md-4\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<mat-select placeholder=\"Day\" [(ngModel)]=\"emp.dropDay\" formControlName=\"dropDay\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let day of day\" [value]=\"day.key\">\r\n\t\t\t\t\t\t  {{ day.name }}\r\n\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t  </mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t  </div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-4\">\t\t \t\t \r\n\t\t\t\t<mat-form-field> \t  \t  \r\n\t\t\t\t\t <mat-select placeholder=\"Month\" [(ngModel)]=\"emp.dropMonth\" formControlName=\"dropMonth\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let Month of month\" [value]=\"Month.key\">\r\n\t\t\t\t\t\t  {{ Month.name }}\r\n\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t  </mat-select>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\t\r\n\t\t\t\t\r\n\t\t\t<div class=\"col-md-4\">\t  \r\n\t\t\t\t<mat-form-field>  \t   \t  \r\n\t\t\t\t\t  <mat-select placeholder=\"Year\" [(ngModel)]=\"emp.dropYear\" formControlName=\"dropYear\">\r\n\t\t\t\t\t\t<mat-option *ngFor=\"let Year of year\" [value]=\"Year.name\">\r\n\t\t\t\t\t\t  {{ Year.name }}\r\n\t\t\t\t\t\t</mat-option>\r\n\t\t\t\t\t  </mat-select> \r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\t\t\r\n\t\t\t</div>\r\n\t\t\t\t \r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Marital Status*\" [(ngModel)]=\"emp.empMarried\" formControlName=\"empMarried\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let marrie of married\" [value]=\"marrie.key\">\r\n\t\t\t\t\t  {{ marrie.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  <mat-error *ngIf=\"empMarried.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Marital Status\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<mat-select placeholder=\"Gender*\" [(ngModel)]=\"emp.empGender\" formControlName=\"empGender\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let gen of gender\" [value]=\"gen.key\">\r\n\t\t\t\t\t  {{ gen.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  <mat-error *ngIf=\"empGender.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Gender\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field >\r\n\t\t\t\t\t<textarea matInput placeholder=\"Certification\" [(ngModel)]=\"emp.empCertification\" formControlName=\"empCertification\" \r\n\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\">{{ emp.empCertification }}</textarea>\r\n\t\t\t\t\t<mat-hint>max char 255</mat-hint>\r\n\t\t\t\t</mat-form-field >\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<textarea matInput placeholder=\"Qualification\" [(ngModel)]=\"emp.empQualification\" formControlName=\"empQualification\" \r\n\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\">{{ emp.empQualification }}</textarea>\r\n\t\t\t\t\t<mat-hint>max char 255</mat-hint>\r\n\t\t\t\t</mat-form-field>\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Phone 1\" [(ngModel)]=\"emp.empPhone1\" formControlName=\"empPhone1\" maxlength=\"14\">\r\n\t\t\t\t<mat-error *ngIf=\"empPhone1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter Valid Phone 1\r\n\t\t\t\t</mat-error>\r\n\t\t\t\t<mat-hint>(91-80-33333333)</mat-hint>\t\r\n\t\t\t  </mat-form-field>\t \r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Phone 2\" [(ngModel)]=\"emp.empPhone2\" formControlName=\"empPhone2\" maxlength=\"14\">\r\n\t\t\t\t<mat-error *ngIf=\"empPhone2.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter Valid Phone 2\r\n\t\t\t\t</mat-error>\r\n\t\t\t\t<mat-hint>(91-80-33333333)</mat-hint>\t \r\n\t\t\t  </mat-form-field>\t\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Mobile 1*\" [(ngModel)]=\"emp.empMobile1\" formControlName=\"empMobile1\" maxlength=\"13\">\r\n\t\t\t\t<mat-error *ngIf=\"empMobile1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Mobile 1\r\n\t\t\t\t</mat-error>\r\n\t\t\t\t<mat-error *ngIf=\"empMobile1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Mobile 1\r\n\t\t\t\t</mat-error>\r\n\t\t\t\t<mat-hint>(91-9999999999)</mat-hint>\t \r\n\t\t\t  </mat-form-field>\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Mobile 2\" [(ngModel)]=\"emp.empMobile2\" formControlName=\"empMobile2\" maxlength=\"13\">\r\n\t\t\t\t<mat-hint>(91-9999999999)</mat-hint>\r\n\t\t\t\t<mat-error *ngIf=\"empMobile2.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Mobile 2\r\n\t\t\t\t</mat-error>\t \r\n\t\t\t  </mat-form-field>\t\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Email 1*\" [(ngModel)]=\"emp.empEmail1\" formControlName=\"empEmail1\" maxlength=\"100\">\r\n\t\t\t\t<mat-error *ngIf=\"empEmail1.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter email 1\r\n\t\t\t\t</mat-error>\r\n\t\t\t\t<mat-error *ngIf=\"empEmail1.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Email 1\r\n\t\t\t\t</mat-error>\r\n\t\t\t  </mat-form-field>\t\t \r\n\t\t\t</div>\r\n\t\t\t   \r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Email 2\" [(ngModel)]=\"emp.empEmail2\" formControlName=\"empEmail2\" maxlength=\"100\">\r\n\t\t\t  </mat-form-field>\t\r\n\t\t\t  <mat-error *ngIf=\"empEmail2.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid Email 2\r\n\t\t\t\t</mat-error>\r\n\t\t\t</div>\r\n\t\t   \r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Address*\" #empaddress [(ngModel)]=\"emp.empAddress\" formControlName=\"empAddress\" \r\n\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\">\r\n<!--\t\t\t\t\t\t(keypress)=\"charcount(empaddress, empaddresscount,'<font color=red>({CHAR} characters left)</font>', '255')\"-->\r\n\t\t\t\t\t {{ emp.empAddress }}</textarea>\r\n\t\t\t\t\t<mat-hint #empaddresscount>max char 255</mat-hint>\r\n\t\t\t  </mat-form-field >\t\t\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<textarea matInput placeholder=\"Landmark\" [(ngModel)]=\"emp.empLandmark\" formControlName=\"empLandmark\" \r\n\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\">{{ emp.empLandmark }}</textarea>\r\n\t\t\t\t\t<mat-hint>max char 255</mat-hint>\r\n\t\t\t  </mat-form-field>\t\t\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class=\"col-md-6\" style=\"padding:1em;\">\r\n\t\t\t\t<select class='form-control txt-align' id=\"city\" name=\"empCityId\"></select>\r\n\t\t\t\t <span [innerHtml]=\"customerCityIdMsg\"></span>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  <mat-form-field>\r\n\t\t\t\t<input matInput placeholder=\"Pin/Zip*\" [(ngModel)]=\"emp.empPin\" formControlName=\"empPin\" maxlength=\"6\">\r\n\t\t\t\t<mat-error *ngIf=\"empPin.hasError('required')\">\r\n\t\t\t\t\t\t\tEnter Pin/Zip\r\n\t\t\t\t</mat-error>\r\n\t\t\t\t<mat-error *ngIf=\"empPin.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter Valid Pin/Zip\r\n\t\t\t\t</mat-error>\r\n\t\t\t  </mat-form-field>\t\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t<mat-select [disabled]=\"branchDiasble\" placeholder=\"Branch*\" [(ngModel)]=\"emp.empBranchId\" formControlName=\"empBranchId\" (change)=\"branchchange(empBranchId.value, empRoleId.value);\">\r\n\t\t\t\t\t<mat-option *ngFor=\"let branch of branch\" [value]=\"branch.key\">\r\n\t\t\t\t\t  {{ branch.name }}\r\n\t\t\t\t\t</mat-option>\r\n\t\t\t\t  </mat-select>\r\n\t\t\t\t  <mat-error *ngIf=\"empBranchId.hasError('required')\">\r\n\t\t\t\t\t\t\tSelect Branch\r\n\t\t\t\t\t</mat-error>\r\n\t\t\t\t</mat-form-field>\r\n\t\t\t</div>\t\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t<label>Active:</label>\r\n\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empActive)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empActive'})\" formControlName=\"empActive\"></mat-checkbox>\r\n\t\t\t</div>\r\n\t</div>\t\r\n\t\r\n\t<br><br>\r\n\t<div [hidden]=\"branchPortlet\" class=\"m-portlet m-portlet--head-solid-bg m-portlet--bordered\">\r\n\t\t<div class=\"m-portlet__head\">Select Branches </div>\r\n\t\t<div class=\"m-portlet__body\">\r\n\r\n\t\t\t\t<div class=\"row\">All Branches:\r\n\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empAllBranches)\" (change)=\"allBranches(empAllBranches.value);globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empAllBranches'})\" formControlName=\"empAllBranches\"></mat-checkbox>  \r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"col-md-12 row\" [hidden]=\"allBranch\">\r\n\t\t\t\t\t<div class=\"col-md-5\">\r\n\t\t\t\t\t\t<select size=\"10\" class=\"form-control firstSelect\" multiple>\r\n\t\t\t\t\t\t\t<option *ngFor=\"let branch of branch\" [value]=\"branch.key\">{{ branch.name}}</option>\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"col-md-2 text-center\"><br><br>\r\n\t\t\t\t\t\t<input name=\"Input3\" type=\"button\" class=\"btn btn-success\" value=\" Add &gt;&gt;\" (click)=\"AddData1()\"/> \r\n\t\t\t\t\t\t<br><br> \r\n\t\t\t\t\t\t<input name=\"Input3\" type=\"button\" class=\"btn btn-success\"  value=\"&lt;&lt; Delete\" (click)=\"DeleteData1();\" />\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"col-md-5\">\r\n\t\t\t\t\t\t<select size=\"10\" class=\"form-control secondSelect\" multiple name=\"empAllBranch\">\r\n\t\t\t\t\t\t\t<option *ngFor=\"let branc of selectedbranch\"\r\n\t\t\t\t\t\t\t[value]=\"branc.key\">{{ branc.name }}</option>\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n\r\n\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--head-solid-bg m-portlet--bordered\">\r\n\t\t<div class=\"m-portlet__head\">Select Executives for Reporting \r\n\t\t</div>\r\n\t\t<div class=\"m-portlet__body\">\r\n\r\n\t\t\t<div class=\"row\">\r\n\t\t\t\tAll Executives:\r\n\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empAllExe)\" (change)=\"allExecutives(empAllExe.value);globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empAllExe'})\" formControlName=\"empAllExe\"></mat-checkbox>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t\t<div class=\"row\" [hidden]=\"allExe\">\r\n\t\t\t\t\t<div class=\"col-md-5\">\r\n\t\t\t\t\t\t<select  size=\"10\" class=\"form-control thirdSelect\" multiple>\r\n\t\t\t\t\t\t\t<option *ngFor=\"let executive of executive\" \r\n\t\t\t\t\t\t\t[value]=\"executive.key\">{{ executive.name }}</option>\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"col-md-2 text-center\"><br><br>\r\n\t\t\t\t\t\t<input name=\"Input3\" type=\"button\" class=\"btn btn-success\" value=\" Add &gt;&gt;\" (click)=\"AddData2()\"/> \r\n\t\t\t\t\t\t<br><br> \r\n\t\t\t\t\t\t<input name=\"Input3\" type=\"button\" class=\"btn btn-success\"  value=\"&lt;&lt; Delete\" (click)=\"DeleteData2();\" />\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"col-md-5\">\r\n\t\t\t\t\t\t<select  size=\"10\" class=\"form-control fourthSelect\" multiple name=\"empAllExecutive\">\r\n\t\t\t\t\t\t\t<option *ngFor=\"let exec of selectedexecutive\" [value]=\"exec.key\">{{ exec.name }}</option>\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t</div>\r\n\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--head-solid-bg m-portlet--bordered\">\r\n\t\t<div class=\"m-portlet__head\">Access Rights\r\n\t\t</div>\r\n\t\t<div class=\"m-portlet__body\">\r\n\r\n\t\t\t\t<table class=\"container-fluid\">\r\n\t\t\t\t\r\n\t\t\t\t\t<tr *ngIf=\"compModuleSales=='1' || compModuleInvoice=='1' || compModulePos=='1'\">\r\n\t\t\t\t\t\t<td align=right>Sales Executive:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empSales)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empSales'})\"  formControlName=\"empSales\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Close Opportunity:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empCloseOppr)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empCloseOppr'})\"  formControlName=\"empCloseOppr\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr *ngIf=\"compModulePos=='1'\">\r\n\t\t\t\t\t\t<td align=right>Update Bill Price:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empBillPriceupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empBillPriceupdate'})\" formControlName=\"empBillPriceupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Update Bill Discount:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empBillDiscountupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empBillDiscountupdate'})\" formControlName=\"empBillDiscountupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr *ngIf=\"compModuleSales=='1'\">\r\n\t\t\t\t\t\t<td align=right>Update Quote Price:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empQuotePriceupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empQuotePriceupdate'})\" formControlName=\"empQuotePriceupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Update Quote Discount:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empQuoteDiscountupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empQuoteDiscountupdate'})\" formControlName=\"empQuoteDiscountupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=right>Update SO Price:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empSoPriceupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empSoPriceupdate'})\" formControlName=\"empSoPriceupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Update SO Discount:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empSoDiscountupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empSoDiscountupdate'})\" formControlName=\"empSoDiscountupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=right>Update Invoice Price:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empInvoicePriceupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empInvoicePriceupdate'})\" formControlName=\"empInvoicePriceupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Update Invoice Discount:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empInvoiceDiscountupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empInvoiceDiscountupdate'})\" formControlName=\"empInvoiceDiscountupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr *ngIf=\"compModuleProduction=='1'\">\r\n\t\t\t\t\t\t<td align=right>Production Job Card Executive:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empProdJcExe)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empProdJcExe'})\" formControlName=\"empProdJcExe\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right></td>\r\n\t\t\t\t\t\t<td align=left></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<tr *ngIf=\"compModuleService=='1'\">\r\n\t\t\t\t\t\t<td align=right>Service Executive:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empService)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empService'})\" formControlName=\"empService\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Service Technician:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empTechnician)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empTechnician'})\" formControlName=\"empTechnician\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr *ngIf=\"compModuleService=='1'\">\r\n\t\t\t\t\t\t<td align=right>Service PSF:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empServicePsf)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empServicePsf'})\" formControlName=\"empServicePsf\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Service CRM:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empCrm)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empCrm'})\" formControlName=\"empCrm\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr *ngIf=\"compModuleService=='1'\">\r\n\t\t\t\t\t\t<td align=right>Update Job Card Price:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empJcPriceupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empJcPriceupdate'})\" formControlName=\"empJcPriceupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Update Job Card Discount:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empJcDiscountupdate)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empJcDiscountupdate'})\" formControlName=\"empJcDiscountupdate\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr *ngIf=\"compModuleService=='1'\">\r\n\t\t\t\t\t\t<td align=right>Ticket Owner:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empTicketOwner)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empTicketOwner'})\" formControlName=\"empTicketOwner\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Ticket Close:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empTicketClose)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empTicketClose'})\" formControlName=\"empTicketClose\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=right>MIS:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empMisAccess)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empMisAccess'})\" formControlName=\"empMisAccess\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Export:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empExportAccess)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empExportAccess'})\" formControlName=\"empExportAccess\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=right>Report:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empReportAccess)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empReportAccess'})\" formControlName=\"empReportAccess\"></mat-checkbox></td>\r\n\t\t\t\t\t\t<td align=right>Browser Copy:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empCopyAccess)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empCopyAccess'})\" formControlName=\"empCopyAccess\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=right>Device ID:</td>\r\n\t\t\t\t\t\t<td align=left><mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empDeviceId)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empDeviceId'})\" formControlName=\"empDeviceId\"></mat-checkbox></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=right>IP Access:</td>\r\n\t\t\t\t\t\t<td align=left>\r\n\t\t\t\t\t\t<mat-form-field style=\"margin-left: 31px;\">\r\n\t\t\t\t\t\t\t<input matInput placeholder=\"IP access\" [(ngModel)]=\"emp.empIpAccess\" formControlName=\"empIpAccess\" maxlength=\"15\" />\r\n\t\t\t\t\t\t\t<mat-error *ngIf=\"empIpAccess.hasError('pattern')\">\r\n\t\t\t\t\t\t\t\tEnter valid IP Address\r\n\t\t\t\t\t\t\t</mat-error>\r\n\t\t\t\t\t\t</mat-form-field></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=center></td>\r\n\t\t\t\t\t\t<td align=center>(comma and space seperated for each IP Address) <br /> Eg.: 192.168.0.1, 192.168.1.6</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\r\n\t\t</div>\r\n\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--head-solid-bg m-portlet--bordered\">\r\n\t\t<div class=\"m-portlet__head\">\r\n\t\t\tPriority\r\n\t\t</div>\r\n\t\t<div class=\"m-portlet__body\">\r\n<!--   -------------alignment testing---------------\r\n\t\t\t<div class=\"row\">\r\n\t\t\t\t <div class=\"col-md-2 col-xs-6 text-right\">\r\n\t\t\t\t\tActivity:\r\n\t\t\t\t </div>\r\n\t\t\t  \r\n\t\t\t  <div class=\"col-md-10 col-xs-6\" [style.display]=\"display\">\r\n\t\t\t\t<div class=\"col-md-2 col-xs-6\">\r\n\t\t\t\t\t<mat-checkbox [(ngModel)]=\"emp.empPriorityactivityLevel1\" formControlName=\"empPriorityactivityLevel1\">\r\n\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2 col-xs-6\">\r\n\t\t\t\t\t<mat-checkbox [(ngModel)]=\"emp.empPriorityactivityLevel2\" formControlName=\"empPriorityactivityLevel2\">\r\n\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2 col-xs-6\">\r\n\t\t\t\t\t<mat-checkbox [(ngModel)]=\"emp.empPriorityactivityLevel3\" formControlName=\"empPriorityactivityLevel3\">\r\n\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2 col-xs-6\">\r\n\t\t\t\t\t<mat-checkbox [(ngModel)]=\"emp.empPriorityactivityLevel4\" formControlName=\"empPriorityactivityLevel4\">\r\n\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"col-md-2 col-xs-6\">\r\n\t\t\t\t\t<mat-checkbox [(ngModel)]=\"emp.empPriorityactivityLevel5\" formControlName=\"empPriorityactivityLevel5\">\r\n\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t  </div>\r\n\t\t\t  \t\r\n\t\t\t</div>\r\n\t\t\t-->\t\t\t\r\n\t\t\t<div class=\"row\">\r\n\t\t\t\t<table class=\"container\">\r\n\t\t\t\t\t<tbody>\r\n\t\t\t\t\t <span *ngIf=\"compModuleActivity=='1'\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2 col-xs-5\">\r\n\t\t\t\t\t\t\t\t\tActivity:\r\n\t\t\t\t\t\t\t\t</div>\t\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityactivityLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityactivityLevel1'})\" formControlName=\"empPriorityactivityLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityactivityLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityactivityLevel2'})\" formControlName=\"empPriorityactivityLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityactivityLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityactivityLevel3'})\" formControlName=\"empPriorityactivityLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityactivityLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityactivityLevel4'})\" formControlName=\"empPriorityactivityLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityactivityLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityactivityLevel5'})\" formControlName=\"empPriorityactivityLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</span>\t\r\n\t\t\t\t\t\r\n\t\t\t\t\t<span *ngIf=\"compModulePm=='1'\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\tProject:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityprojectLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityprojectLevel1'})\" formControlName=\"empPriorityprojectLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityprojectLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityprojectLevel2'})\" formControlName=\"empPriorityprojectLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityprojectLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityprojectLevel3'})\" formControlName=\"empPriorityprojectLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityprojectLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityprojectLevel4'})\" formControlName=\"empPriorityprojectLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityprojectLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityprojectLevel5'})\" formControlName=\"empPriorityprojectLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\tTask:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritytaskLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritytaskLevel1'})\" formControlName=\"empPrioritytaskLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritytaskLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritytaskLevel2'})\" formControlName=\"empPrioritytaskLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritytaskLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritytaskLevel3'})\" formControlName=\"empPrioritytaskLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritytaskLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritytaskLevel4'})\" formControlName=\"empPrioritytaskLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritytaskLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritytaskLevel5'})\" formControlName=\"empPrioritytaskLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</span>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<span *ngIf=\"compModuleSales=='1'\">\t\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\t{{this.configdetails}} follow-up:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprfollowupLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprfollowupLevel1'})\" formControlName=\"empPriorityopprfollowupLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprfollowupLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprfollowupLevel2'})\" formControlName=\"empPriorityopprfollowupLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprfollowupLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprfollowupLevel3'})\" formControlName=\"empPriorityopprfollowupLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprfollowupLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprfollowupLevel4'})\" formControlName=\"empPriorityopprfollowupLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprfollowupLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprfollowupLevel5'})\" formControlName=\"empPriorityopprfollowupLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\tOpportunity:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprLevel1'})\" formControlName=\"empPriorityopprLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprLevel2'})\" formControlName=\"empPriorityopprLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprLevel3'})\" formControlName=\"empPriorityopprLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprLevel4'})\" formControlName=\"empPriorityopprLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityopprLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityopprLevel5'})\" formControlName=\"empPriorityopprLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\tBalance:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritybalanceLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritybalanceLevel1'})\" formControlName=\"empPrioritybalanceLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritybalanceLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritybalanceLevel2'})\" formControlName=\"empPrioritybalanceLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritybalanceLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritybalanceLevel3'})\" formControlName=\"empPrioritybalanceLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritybalanceLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritybalanceLevel4'})\" formControlName=\"empPrioritybalanceLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPrioritybalanceLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPrioritybalanceLevel5'})\" formControlName=\"empPrioritybalanceLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</span>\t\r\n\t\t\t\t\t\r\n\t\t\t\t\t<span *ngIf=\"compModuleService=='1'\">\t\t\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\tJob Card:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityjcLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityjcLevel1'})\" formControlName=\"empPriorityjcLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityjcLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityjcLevel2'})\" formControlName=\"empPriorityjcLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityjcLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityjcLevel3'})\" formControlName=\"empPriorityjcLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityjcLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityjcLevel4'})\" formControlName=\"empPriorityjcLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityjcLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityjcLevel5'})\" formControlName=\"empPriorityjcLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"3\" align=\"right\">\r\n\t\t\t\t\t\t\t\tTicket:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityticketLevel1)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityticketLevel1'})\" formControlName=\"empPriorityticketLevel1\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 1\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityticketLevel2)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityticketLevel2'})\" formControlName=\"empPriorityticketLevel2\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 2\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityticketLevel3)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityticketLevel3'})\" formControlName=\"empPriorityticketLevel3\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 3\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityticketLevel4)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityticketLevel4'})\" formControlName=\"empPriorityticketLevel4\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 4\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"col-md-2\">\r\n\t\t\t\t\t\t\t\t\t<mat-checkbox [ngModel]=\"globalValid.getCheckValue(emp.empPriorityticketLevel5)\" (change)=\"globalValid.fetchCheckValue({event:$event, obj:emp, objKey:'empPriorityticketLevel5'})\" formControlName=\"empPriorityticketLevel5\">\r\n\t\t\t\t\t\t\t\t\t\tLevel 5\r\n\t\t\t\t\t\t\t\t\t</mat-checkbox>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</span>\r\n\t\t\t\t\t\r\n\t\t\t\t\t</tbody>\r\n\t\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t</div>\r\n\t</div>\r\n\t\r\n\t<div class=\"m-portlet m-portlet--head-solid-bg m-portlet--bordered\">\r\n\t\t<div class=\"m-portlet__head\">\r\n\t\t\tPayroll Details\r\n\t\t</div>\r\n\t\t<div class=\"m-portlet__body\">\r\n\t\t\t<div class=\"row\">\r\n\t\t\t  <div class=\"col-md-6\">\r\n\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Bank Name\" [(ngModel)]=\"emp.empBankName\" formControlName=\"empBankName\" maxlength=\"255\">\r\n\t\t\t    </mat-form-field>\t\r\n\t\t\t  </div>\r\n\t\t\t\t\r\n\t\t\t  <div class=\"col-md-6\">\r\n\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Branch Name\" [(ngModel)]=\"emp.empBankBranchname\" formControlName=\"empBankBranchname\" \r\n\t\t    \t\t\tmaxlength=\"255\">\r\n\t\t\t    </mat-form-field>\t\r\n\t\t\t  </div>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-6\">\r\n\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Account No.\" [(ngModel)]=\"emp.empBankAccno\" formControlName=\"empBankAccno\" maxlength=\"20\">\r\n\t\t    \t\t<mat-error *ngIf=\"empBankAccno.hasError('pattern')\">\r\n\t\t\t\t\t\t\tEnter valid A/C No.\r\n\t\t\t\t</mat-error>\r\n\t\t\t    </mat-form-field>\t\r\n\t\t\t </div>\r\n\t\t\t  <div class=\"col-md-6\">\r\n\t\t\t  \t<mat-form-field>\r\n\t\t\t\t\t<input matInput placeholder=\"Account Holder Name\" [(ngModel)]=\"emp.empBankAccholdername\" formControlName=\"empBankAccholdername\" \r\n\t\t   \t\t\t\t maxlength=\"255\">\r\n\t\t\t    </mat-form-field>\t\r\n\t\t\t  </div>\r\n\t\t\t\r\n\t\t  \t  <div class=\"col-md-6\">\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<input matInput class=\"datepicker\" name=\"empDateOfJoin\" placeholder=\"Date of Join*\" maxlength=\"10\" [value]='emp.empDateOfJoin'>\r\n\t\t\t\t\t\t<span [innerHtml]=\"empDateOfJoinMsg\"></span>\r\n\t\t\t\t\t</mat-form-field>\t\r\n\t\t\t\t </div>\r\n\t\t\t\t \r\n\t\t\t  <div class=\"col-md-6\">\r\n\t\t\t    <mat-form-field>\r\n\t\t\t\t\t<input matInput class=\"datepicker\" name=\"empDateOfRelieve\" placeholder=\"Date of Relieve\" maxlength=\"10\" [value]='emp.empDateOfRelieve'>\r\n\t\t\t    </mat-form-field>\r\n\t\t\t  </div>\r\n\t\t\t\t\r\n\t\t\t\r\n\t\t\t\t<div class=\"col-md-6\">\r\n\t\t\t\t\t<mat-form-field>\r\n\t\t\t\t\t\t<input matInput placeholder=\"Reason Of Leaving\" [(ngModel)]=\"emp.empReasonOfLeaving\" formControlName=\"empReasonOfLeaving\" \r\n\t\t\t\t\t\t\tmaxlength=\"255\">\r\n\t\t\t\t\t</mat-form-field>\t\r\n\t\t\t\t </div>\r\n\t\t\t\t <div class=\"col-md-6\">\r\n\t\t\t\t\t  <mat-form-field>\r\n\t\t\t\t\t\t<textarea matInput placeholder=\"Notes\" [(ngModel)]=\"emp.empNotes\" formControlName=\"empNotes\" \r\n\t\t\t\t\t\tmatAutosizeMinRows=\"2\" maxlength=\"255\">{{ emp.empNotes }}</textarea>\r\n\t\t\t\t\t\t<mat-hint>max char 255</mat-hint>\r\n\t\t\t\t\t  </mat-form-field>\t\r\n\t\t\t\t </div>\r\n\t\t\t\r\n\t\t</div>\r\n\t    </div>\r\n\t</div>\r\n\t\r\n\t \t\t<div class='col-md-12 row' *ngIf=\"emp.empEntryBy\" style=\"margin-top: 2em;\">\r\n\t\t  \t  <div class=\"col-md-6\">\r\n\t\t\t\t  <label>Entry By:</label> <a href=\"\">{{emp.empEntryBy}}</a>\r\n\t\t\t  </div>\r\n\t\t\t\t \r\n\t\t\t  <div class=\"col-md-6\">\r\n\t\t\t  \t\t<label>Entry Date:</label>{{emp.empEntryDate}}\r\n\t\t\t  </div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t  \t  <div class='col-md-12 row' *ngIf=\"emp.empModifiedBy\"  style=\"margin-top: 2em;\">\r\n\t\t  \t  <div class=\"col-md-6\">\r\n\t\t\t\t  <label>Modified By: </label><a href=\"\">{{emp.empModifiedBy}}</a>\r\n\t\t\t  </div>\r\n\t\t\t\t \r\n\t\t\t  <div class=\"col-md-6\">\r\n\t\t\t  \t<label>Modified Date: </label>{{emp.empModifiedDate}}\r\n\t\t\t  </div>\r\n\t\t </div>\t\r\n\t\t\t \r\n\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.status == 'Add'\">\r\n\t\t\t\t<button mat-button class=\"btn btn-primary\" [disabled]=\"false\"> Add </button> \r\n\t\t\t\t<button mat-button class=\"btn btn-primary\" type=\"reset\" (click)=\"toggleAnimation()\"> Cancel </button>\r\n\t\t\t</div>\r\n\t\t\t<br>\r\n\t\t\t\r\n\t\t\t<div class=\"col-md-12 btn-row\" *ngIf=\"this.status == 'Update'\">\r\n\t\t\t\t <button mat-button [disabled]=\"false\" class=\"btn btn-primary\"> Update </button> \r\n\t\t\t\t <button mat-button [disabled]=\"false\" (click)=\"onDelete()\" class=\"btn btn-primary\" type=\"button\"> Delete </button> \r\n\t\t\t\t <button mat-button class=\"btn btn-primary\" (click)=\"toggleAnimation()\"  type=\"reset\"> Cancel </button>\r\n\t\t\t</div>\r\n\t\t\t<br>\r\n\t</form>\r\n\t</div>\t         "

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/executive-list/executive-add.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ExecutiveAddComponent; });
/* unused harmony export empData */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__services_validate_service__ = __webpack_require__("../../../../../src/app/_services/validate.service.ts");
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
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_14_rxjs_add_operator_filter__);
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
var PHONE_REGEX = /^[91]{2}-[80]{2}-[0-9]{8}$/;
var PIN_REGEX = /\d{6}/;
var IP_REGEX = /\b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b/;
var NUM_REGEX = /[0-9]/;
var ExecutiveAddComponent = (function () {
    function ExecutiveAddComponent(http, _router, route, globalValid) {
        var _this = this;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.globalValid = globalValid;
        this.flyInOutTrigger = 'in';
        this.allBranch = false;
        this.branchPortlet = false;
        this.branchDiasble = false;
        this.allExe = false;
        this.listHide = false;
        this.addHide = true;
        this.animateAdd = 'out';
        this.animateList = 'in';
        this.errorMsg = '';
        this.empCityIdMsg = '';
        this.empDateOfJoinMsg = '';
        this.empId = 0;
        this.emp = new empData();
        this.bootstrapFormValues = [];
        this.compModuleActivity = sessionStorage.getItem('compModuleActivity');
        this.compModulePm = sessionStorage.getItem('compModulePm');
        this.compModuleSales = sessionStorage.getItem('compModuleSales');
        this.compModuleService = sessionStorage.getItem('compModuleService');
        this.compModuleInvoice = sessionStorage.getItem('compModuleInvoice');
        this.compModulePos = sessionStorage.getItem('compModulePos');
        this.compModuleProduction = sessionStorage.getItem('compModuleProduction');
        this.day = [
            { key: '01', name: '1' },
            { key: '02', name: '2' },
            { key: '03', name: '3' },
            { key: '04', name: '4' },
            { key: '05', name: '5' },
            { key: '06', name: '6' },
            { key: '07', name: '7' },
            { key: '08', name: '8' },
            { key: '09', name: '9' },
            { key: '10', name: '10' },
            { key: '11', name: '11' },
            { key: '12', name: '12' },
            { key: '13', name: '13' },
            { key: '14', name: '14' },
            { key: '15', name: '15' },
            { key: '16', name: '16' },
            { key: '17', name: '17' },
            { key: '18', name: '18' },
            { key: '19', name: '19' },
            { key: '20', name: '20' },
            { key: '21', name: '21' },
            { key: '22', name: '22' },
            { key: '23', name: '23' },
            { key: '24', name: '24' },
            { key: '25', name: '25' },
            { key: '26', name: '26' },
            { key: '27', name: '27' },
            { key: '28', name: '28' },
            { key: '29', name: '29' },
            { key: '30', name: '30' },
            { key: '31', name: '31' },
        ];
        this.month = [
            { key: '01', name: 'January' },
            { key: '02', name: 'Febraury' },
            { key: '03', name: 'March' },
            { key: '04', name: 'April' },
            { key: '05', name: 'May' },
            { key: '06', name: 'June' },
            { key: '07', name: 'July' },
            { key: '08', name: 'August' },
            { key: '09', name: 'September' },
            { key: '10', name: 'October' },
            { key: '11', name: 'November' },
            { key: '12', name: 'December' },
        ];
        this.year = [];
        this.married = [
            { key: '1', name: 'Married' },
            { key: '2', name: 'Unmarried' }
        ];
        this.gender = [
            { key: '1', name: 'Male' },
            { key: '2', name: 'Female' }
        ];
        this.role = [
            { key: '1', name: 'Administrator' },
            { key: '2', name: 'User' }
        ];
        this.department = [];
        this.jobtitle = [];
        this.executive = [];
        this.branch = [];
        this.msg = [];
        //branch multiselect 
        this.allBranche = [];
        this.selectedbranch = [];
        //executive multiselect 
        this.selectedexecutive = [];
        this.allexe = [];
        this.route.queryParams.filter(function (params) { return params.empId; }).subscribe(function (params) {
            if (params.empId != undefined) {
                _this.empId = params.empId;
            }
        });
        if (this.empId == 0) {
            this.populateDropDownData();
            this.status = "Add";
        }
        else {
            this.populateData();
            this.status = "Update";
        }
    }
    ExecutiveAddComponent.prototype.ngAfterViewInit = function () {
        $.getScript('assets/demo/default/custom/components/forms/widgets/select2.js', function () {
        });
        $.getScript('assets/app/js/bootstrap-material-datetimepicker.js', function () {
        });
        if (this.status == "Update" && this.emp['empBranchId'] != "0")
            this.branchPortlet = true;
    };
    ExecutiveAddComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/executive-list']);
    };
    ExecutiveAddComponent.prototype.branchselect = function (role) {
        if (role == '1') {
            this.emp['empBranchId'] = '0';
            this.allBranch = false;
            this.branchDiasble = true;
        }
        else {
            this.emp['empBranchId'] = '';
            this.allBranch = true;
            this.branchDiasble = false;
        }
    };
    ExecutiveAddComponent.prototype.branchchange = function (branch, role) {
        var _this = this;
        if (branch == '0')
            this.branchPortlet = false;
        else
            this.branchPortlet = true;
        this.allBranche[0] = this.emp['empBranchId'];
        this.emp['empAllBranch'] = this.allBranche;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamaddexecutives', JSON.stringify({ 'branch.branchId': this.emp['empAllBranch'], 'requestType': "filter" }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executive = data['populateExecutive'];
        });
        if (role == '2' && branch == '0') {
            this.branchPortlet = false;
            this.allBranch = false;
        }
        else if (role == '2' && branch != '0')
            this.branchPortlet = true;
    };
    ExecutiveAddComponent.prototype.allBranches = function (checked) {
        var _this = this;
        if (checked == '1') {
            this.allBranch = true;
            $(".secondSelect option:checked").remove();
        }
        else
            this.allBranch = false;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamaddexecutives', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executive = data['populateExecutive'];
        });
    };
    ExecutiveAddComponent.prototype.allExecutives = function (checked) {
        if (checked == '1')
            this.allExe = true;
        else
            this.allExe = false;
    };
    ExecutiveAddComponent.prototype.AddData1 = function () {
        var _this = this;
        var $srcOption = $(".firstSelect option:checked").clone();
        var $destOption = $(".secondSelect option").clone();
        var duplicate = 0;
        $($srcOption).each(function () {
            var source = this;
            if ($(".secondSelect option").length) {
                $($destOption).each(function () {
                    var dest = this;
                    if (dest.innerHTML == source.innerHTML)
                        duplicate = 1;
                });
                if (duplicate.toString() == "0")
                    $('.secondSelect').prepend(source);
                duplicate = 0;
            }
            else
                $('.secondSelect').prepend($srcOption);
        });
        $(".secondSelect option").prop('selected', true);
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0, j = 0; i < this.bootstrapFormValues.length; i++) {
            if (this.bootstrapFormValues[i].name != 'empAllBranch') {
                if (this.bootstrapFormValues[i].name.includes('check_')) {
                    this.emp[this.bootstrapFormValues[i].name.split('_')[1]] = "1";
                }
                else {
                    this.emp[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
                }
            }
            else {
                this.allBranche[j] = this.bootstrapFormValues[i].value;
                j++;
            }
            this.emp['empAllBranch'] = this.allBranche;
        }
        //	console.log(this.emp);
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamaddexecutives', JSON.stringify({ 'branch.branchId': this.emp['empAllBranch'], 'requestType': "filter" }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executive = data['populateExecutive'];
        });
    };
    ExecutiveAddComponent.prototype.DeleteData1 = function () {
        var _this = this;
        $(".secondSelect option:checked").remove();
        $(".secondSelect option").prop('selected', true);
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        for (var i = 0, j = 0; i < this.bootstrapFormValues.length; i++) {
            if (this.bootstrapFormValues[i].name != 'empAllBranch') {
                if (this.bootstrapFormValues[i].name.includes('check_')) {
                    this.emp[this.bootstrapFormValues[i].name.split('_')[1]] = "1";
                }
                else {
                    this.emp[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
                }
            }
            else {
                this.allBranche[j] = this.bootstrapFormValues[i].value;
                j++;
            }
            this.emp['empAllBranch'] = this.allBranche;
        }
        console.log(this.emp);
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/teamaddexecutives', JSON.stringify({ 'branch.branchId': this.emp['empAllBranch'], 'requestType': "filter" }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executive = data['populateExecutive'];
        });
    };
    ExecutiveAddComponent.prototype.AddData2 = function () {
        var $srcOption = $(".thirdSelect option:checked").clone();
        var $destOption = $(".fourthSelect option").clone();
        var duplicate = 0;
        $($srcOption).each(function () {
            var source = this;
            if ($(".fourthSelect option").length) {
                $($destOption).each(function () {
                    var dest = this;
                    if (dest.innerHTML == source.innerHTML)
                        duplicate = 1;
                });
                if (duplicate.toString() == "0")
                    $('.fourthSelect').prepend(source);
                duplicate = 0;
            }
            else
                $('.fourthSelect').prepend($srcOption);
        });
    };
    ExecutiveAddComponent.prototype.DeleteData2 = function () {
        $(".fourthSelect option:checked").remove();
        //this.emp['empAllExecutive'] = [];
    };
    ExecutiveAddComponent.prototype.ngOnInit = function () {
        this.empForm = new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormGroup"]({
            'empName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empRefNo': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empRoleId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empDepartmentId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empJobtitleId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empMarried': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empGender': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empQualification': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empCertification': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'dropDay': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'dropMonth': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'dropYear': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPhone1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'empPhone2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(PHONE_REGEX)]),
            'empMobile1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'empMobile2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(MOBILE_REGEX)]),
            'empEmail1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'empEmail2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(EMAIL_REGEX)]),
            'empAddress': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empLandmark': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPin': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required, __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(PIN_REGEX)]),
            'empBranchId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].required]),
            'empActive': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empAllBranches': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empAllExe': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empBankName': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empBankBranchname': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empBankAccno': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', __WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(NUM_REGEX)),
            'empBankAccholdername': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empReasonOfLeaving': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empNotes': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empEntryid': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empEntryDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empModifiedid': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empModifiedDate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityactivityLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityactivityLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityactivityLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityactivityLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityactivityLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityprojectLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityprojectLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityprojectLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityprojectLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityprojectLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritytaskLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritytaskLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritytaskLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritytaskLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritytaskLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprfollowupLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprfollowupLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprfollowupLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprfollowupLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprfollowupLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityopprLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritybalanceLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritybalanceLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritybalanceLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritybalanceLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPrioritybalanceLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityjcLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityjcLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityjcLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityjcLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityjcLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityticketLevel1': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityticketLevel2': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityticketLevel3': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityticketLevel4': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empPriorityticketLevel5': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empSales': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empCloseOppr': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empBillPriceupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empBillDiscountupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empQuotePriceupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empQuoteDiscountupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empSoPriceupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empSoDiscountupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empInvoicePriceupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empInvoiceDiscountupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empService': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empProdJcExe': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empServicePsf': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empCrm': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empJcPriceupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empJcDiscountupdate': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empTicketOwner': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empTechnician': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empTicketClose': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empMisAccess': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empExportAccess': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empReportAccess': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empCopyAccess': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
            'empIpAccess': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"]('', [__WEBPACK_IMPORTED_MODULE_5__angular_forms__["Validators"].pattern(IP_REGEX)]),
            'empDeviceId': new __WEBPACK_IMPORTED_MODULE_5__angular_forms__["FormControl"](''),
        });
    };
    Object.defineProperty(ExecutiveAddComponent.prototype, "empName", {
        get: function () { return this.empForm.get('empName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empRefNo", {
        get: function () { return this.empForm.get('empRefNo'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empRoleId", {
        get: function () { return this.empForm.get('empRoleId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empDepartmentId", {
        get: function () { return this.empForm.get('empDepartmentId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empJobtitleId", {
        get: function () { return this.empForm.get('empJobtitleId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empMarried", {
        get: function () { return this.empForm.get('empMarried'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empGender", {
        get: function () { return this.empForm.get('empGender'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "dropDay", {
        get: function () { return this.empForm.get('dropDay'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "dropMonth", {
        get: function () { return this.empForm.get('dropMonth'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "dropYear", {
        get: function () { return this.empForm.get('dropYear'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empQualification", {
        get: function () { return this.empForm.get('empQualification'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empCertification", {
        get: function () { return this.empForm.get('empCertification'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPhone1", {
        get: function () { return this.empForm.get('empPhone1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPhone2", {
        get: function () { return this.empForm.get('empPhone2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empMobile1", {
        get: function () { return this.empForm.get('empMobile1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empMobile2", {
        get: function () { return this.empForm.get('empMobile2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empEmail1", {
        get: function () { return this.empForm.get('empEmail1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empEmail2", {
        get: function () { return this.empForm.get('empEmail2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empAddress", {
        get: function () { return this.empForm.get('empAddress'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empLandmark", {
        get: function () { return this.empForm.get('empLandmark'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPin", {
        get: function () { return this.empForm.get('empPin'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empBranchId", {
        get: function () { return this.empForm.get('empBranchId'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empActive", {
        get: function () { return this.empForm.get('empActive'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empAllBranches", {
        get: function () { return this.empForm.get('empAllBranches'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empAllExe", {
        get: function () { return this.empForm.get('empAllExe'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empBankName", {
        get: function () { return this.empForm.get('empBankName'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empBankBranchname", {
        get: function () { return this.empForm.get('empBankBranchname'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empBankAccno", {
        get: function () { return this.empForm.get('empBankAccno'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empBankAccholdername", {
        get: function () { return this.empForm.get('empBankAccholdername'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empReasonOfLeaving", {
        get: function () { return this.empForm.get('empReasonOfLeaving'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empNotes", {
        get: function () { return this.empForm.get('empNotes'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empEntryid", {
        get: function () { return this.empForm.get('empEntryid'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empEntryDate", {
        get: function () { return this.empForm.get('empEntryDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empModifiedid", {
        get: function () { return this.empForm.get('empModifiedid'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empModifiedDate", {
        get: function () { return this.empForm.get('empModifiedDate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityactivityLevel1", {
        get: function () { return this.empForm.get('empPriorityactivityLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityactivityLevel2", {
        get: function () { return this.empForm.get('empPriorityactivityLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityactivityLevel3", {
        get: function () { return this.empForm.get('empPriorityactivityLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityactivityLevel4", {
        get: function () { return this.empForm.get('empPriorityactivityLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityactivityLevel5", {
        get: function () { return this.empForm.get('empPriorityactivityLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityprojectLevel1", {
        get: function () { return this.empForm.get('empPriorityprojectLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityprojectLevel2", {
        get: function () { return this.empForm.get('empPriorityprojectLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityprojectLevel3", {
        get: function () { return this.empForm.get('empPriorityprojectLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityprojectLevel4", {
        get: function () { return this.empForm.get('empPriorityprojectLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityprojectLevel5", {
        get: function () { return this.empForm.get('empPriorityprojectLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritytaskLevel1", {
        get: function () { return this.empForm.get('empPrioritytaskLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritytaskLevel2", {
        get: function () { return this.empForm.get('empPrioritytaskLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritytaskLevel3", {
        get: function () { return this.empForm.get('empPrioritytaskLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritytaskLevel4", {
        get: function () { return this.empForm.get('empPrioritytaskLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritytaskLevel5", {
        get: function () { return this.empForm.get('empPrioritytaskLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprfollowupLevel1", {
        get: function () { return this.empForm.get('empPriorityopprfollowupLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprfollowupLevel2", {
        get: function () { return this.empForm.get('empPriorityopprfollowupLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprfollowupLevel3", {
        get: function () { return this.empForm.get('empPriorityopprfollowupLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprfollowupLevel4", {
        get: function () { return this.empForm.get('empPriorityopprfollowupLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprfollowupLevel5", {
        get: function () { return this.empForm.get('empPriorityopprfollowupLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprLevel1", {
        get: function () { return this.empForm.get('empPriorityopprLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprLevel2", {
        get: function () { return this.empForm.get('empPriorityopprLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprLevel3", {
        get: function () { return this.empForm.get('empPriorityopprLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprLevel4", {
        get: function () { return this.empForm.get('empPriorityopprLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityopprLevel5", {
        get: function () { return this.empForm.get('empPriorityopprLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritybalanceLevel1", {
        get: function () { return this.empForm.get('empPrioritybalanceLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritybalanceLevel2", {
        get: function () { return this.empForm.get('empPrioritybalanceLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritybalanceLevel3", {
        get: function () { return this.empForm.get('empPrioritybalanceLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritybalanceLevel4", {
        get: function () { return this.empForm.get('empPrioritybalanceLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPrioritybalanceLevel5", {
        get: function () { return this.empForm.get('empPrioritybalanceLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityjcLevel1", {
        get: function () { return this.empForm.get('empPriorityjcLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityjcLevel2", {
        get: function () { return this.empForm.get('empPriorityjcLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityjcLevel3", {
        get: function () { return this.empForm.get('empPriorityjcLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityjcLevel4", {
        get: function () { return this.empForm.get('empPriorityjcLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityjcLevel5", {
        get: function () { return this.empForm.get('empPriorityjcLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityticketLevel1", {
        get: function () { return this.empForm.get('empPriorityticketLevel1'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityticketLevel2", {
        get: function () { return this.empForm.get('empPriorityticketLevel2'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityticketLevel3", {
        get: function () { return this.empForm.get('empPriorityticketLevel3'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityticketLevel4", {
        get: function () { return this.empForm.get('empPriorityticketLevel4'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empPriorityticketLevel5", {
        get: function () { return this.empForm.get('empPriorityticketLevel5'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empSales", {
        get: function () { return this.empForm.get('empSales'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empCloseOppr", {
        get: function () { return this.empForm.get('empCloseOppr'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empBillPriceupdate", {
        get: function () { return this.empForm.get('empBillPriceupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empBillDiscountupdate", {
        get: function () { return this.empForm.get('empBillDiscountupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empQuotePriceupdate", {
        get: function () { return this.empForm.get('empQuotePriceupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empQuoteDiscountupdate", {
        get: function () { return this.empForm.get('empQuoteDiscountupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empSoPriceupdate", {
        get: function () { return this.empForm.get('empSoPriceupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empSoDiscountupdate", {
        get: function () { return this.empForm.get('empSoDiscountupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empInvoicePriceupdate", {
        get: function () { return this.empForm.get('empInvoicePriceupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empInvoiceDiscountupdate", {
        get: function () { return this.empForm.get('empInvoiceDiscountupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empService", {
        get: function () { return this.empForm.get('empService'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empProdJcExe", {
        get: function () { return this.empForm.get('empProdJcExe'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empServicePsf", {
        get: function () { return this.empForm.get('empServicePsf'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empCrm", {
        get: function () { return this.empForm.get('empCrm'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empJcPriceupdate", {
        get: function () { return this.empForm.get('empJcPriceupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empJcDiscountupdate", {
        get: function () { return this.empForm.get('empJcDiscountupdate'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empTicketOwner", {
        get: function () { return this.empForm.get('empTicketOwner'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empTechnician", {
        get: function () { return this.empForm.get('empTechnician'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empTicketClose", {
        get: function () { return this.empForm.get('empTicketClose'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empMisAccess", {
        get: function () { return this.empForm.get('empMisAccess'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empExportAccess", {
        get: function () { return this.empForm.get('empExportAccess'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empReportAccess", {
        get: function () { return this.empForm.get('empReportAccess'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empCopyAccess", {
        get: function () { return this.empForm.get('empCopyAccess'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empIpAccess", {
        get: function () { return this.empForm.get('empIpAccess'); },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(ExecutiveAddComponent.prototype, "empDeviceId", {
        get: function () { return this.empForm.get('empDeviceId'); },
        enumerable: true,
        configurable: true
    });
    ;
    ExecutiveAddComponent.prototype.populateDropDownData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/department', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.department = data['populateDepartment'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/jobtitle', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.jobtitle = data['populateJobtitle'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/year', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.year = data['populateYear'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/configdetails', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.configdetails = data['populateConfigDetails'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/selectbranch', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branch = data['populateBranch'];
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/selectexecutive', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.executive = data['populateExecutive'];
        });
    };
    ExecutiveAddComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/executive-data', JSON.stringify({ empId: this.empId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.emp = data['populateData'][0];
        }, function (err) {
            console.log("ERROR: " + err);
        }, function () {
            _this.populateDropDownData();
            _this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/city?cityId=' + _this.emp.empCityId, JSON.stringify({}), { headers: headers, withCredentials: true }).subscribe(function (data) {
                _this.emp.empCity = data['results'][0].text;
                $('#city').html('<option value=' + _this.emp.empCityId + '>' + _this.emp.empCity + '</option>');
            }, function (err) {
                console.log("ERROR: " + err);
            }, function () {
            });
            if (_this.emp['empAllBranches'].length != 0) {
                _this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/selectbranch', JSON.stringify({ 'allBranche': _this.emp['empAllBranches'] }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                    _this.selectedbranch = data['populateBranch'];
                }, function (err) {
                    console.log("ERROR: " + err);
                }, function () {
                });
            }
            if (_this.emp['empAllExecutive'].length != 0) {
                _this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/selectexecutive', JSON.stringify({ 'allexe': _this.emp['empAllExecutive'] }), { headers: headers, withCredentials: true }).subscribe(function (data) {
                    _this.selectedexecutive = data['populateExecutive'];
                    console.log("this.selectedexecutive====" + _this.selectedexecutive);
                }, function (err) {
                    console.log("ERROR: " + err);
                }, function () {
                });
            }
        });
    };
    ExecutiveAddComponent.prototype.getCheckValues = function (temp) {
        return this.globalValid.getCheckValue(temp);
    };
    ExecutiveAddComponent.prototype.onSubmit = function () {
        var _this = this;
        console.log(this.emp);
        $(".secondSelect option,.fourthSelect option").prop('selected', true);
        this.bootstrapFormValues = $('#m_form_1').serializeArray();
        console.log(this.bootstrapFormValues);
        var j = 0;
        for (var i = 0; i < this.bootstrapFormValues.length; i++) {
            if (this.bootstrapFormValues[i].name == "empDateOfJoin") {
                if (this.bootstrapFormValues[i].value == "") {
                    this.errorMsg = 'Fill all the Mandatory Fields';
                    this.empDateOfJoinMsg = "<font class='errorMsg'>Enter Employee Date Of Join</font>";
                }
                else {
                    this.empDateOfJoinMsg = "";
                }
            }
            if (this.emp.empCityId != undefined) {
                if (this.emp.empCityId == '0') {
                    this.errorMsg = 'Fill all the Mandatory Fields';
                    this.empCityIdMsg = "<font class='select2ErrorMsg'>Plese Select City</font>";
                }
                else {
                    this.errorMsg = '';
                    this.empCityIdMsg = "";
                }
            }
            else {
                this.errorMsg = 'Fill all the Mandatory Fields';
                this.empCityIdMsg = "<font class='select2ErrorMsg'>Plese Select City</font>";
            }
            if (this.bootstrapFormValues[i].name != 'empAllBranch') {
                if (this.bootstrapFormValues[i].name.includes('check_')) {
                    this.emp[this.bootstrapFormValues[i].name.split('_')[1]] = "1";
                }
                else {
                    this.emp[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
                }
            }
            else {
                this.allBranche[j] = this.bootstrapFormValues[i].value;
                j++;
            }
            this.emp['empAllBranch'] = this.allBranche;
            if (this.bootstrapFormValues[i].name != 'empAllExecutive') {
                if (this.bootstrapFormValues[i].name.includes('check_')) {
                    this.emp[this.bootstrapFormValues[i].name.split('_')[1]] = "1";
                }
                else {
                    this.emp[this.bootstrapFormValues[i].name] = this.bootstrapFormValues[i].value;
                }
            }
            else {
                this.allexe[j] = this.bootstrapFormValues[i].value;
                j++;
            }
            this.emp['empAllExecutive'] = this.allexe;
        }
        if (!this.empForm.invalid) {
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
            if (this.empId == 0) {
                this.emp['requestType'] = 'add';
            }
            else {
                this.emp['requestType'] = 'update';
                this.emp['empId'] = this.empId + '';
            }
            this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/executive', JSON.stringify(this.emp), { headers: headers, withCredentials: true }).subscribe(function (data) {
                if (data['successmsg'].includes('Successfully')) {
                    _this.msg[0] = 'success';
                    _this.msg[1] = data['successmsg'];
                }
                else {
                    _this.msg[0] = 'Error';
                    _this.msg[1] = data['errormsg'];
                }
                _this.toast.showtoast(_this.msg);
                _this.empId = data['empId'];
                if (_this.status == 'Add')
                    _this._router.navigate(['/portal/executive-access-add'], { queryParams: { empId: _this.empId } });
                else
                    _this.toggleAnimation();
                _this.empForm.reset();
            }, function (err) {
                console.log(err['error']['desc']);
                _this.msg[0] = 'Error';
                _this.msg[1] = err['error'];
                _this.toast.showtoast(_this.msg);
            });
        }
    };
    ExecutiveAddComponent.prototype.onDelete = function () {
        var _this = this;
        this.emp['requestType'] = 'delete';
        this.emp['empId'] = this.empId + '';
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/executive', JSON.stringify({ requestType: 'delete',
            empId: this.empId }), { headers: headers, withCredentials: true }).subscribe(function (data) {
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
            _this.empForm.reset();
        }, function (err) {
            console.log(err['error']['desc']);
            _this.msg[0] = 'Error';
            _this.msg[1] = err['error'];
            _this.toast.showtoast(_this.msg);
        });
    };
    return ExecutiveAddComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ExecutiveAddComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ExecutiveAddComponent.prototype, "toast", void 0);
ExecutiveAddComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/executive-list/executive-add.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]]
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__services_validate_service__["a" /* GlobalValidate */]) === "function" && _e || Object])
], ExecutiveAddComponent);

var empData = (function () {
    function empData() {
        this.empCityId = "0";
        this.empActive = "1";
        this.empAllExe = '0';
        this.empAllBranches = '0';
        this.allBranche = '';
        this.allexe = '';
        this.empDateOfJoin = '';
        this.empDateOfRelieve = '';
    }
    return empData;
}());

var _a, _b, _c, _d, _e;
//# sourceMappingURL=executive-add.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/executive-list/executive-list.component.html":
/***/ (function(module, exports) {

module.exports = "\t<router-outlet></router-outlet>\r\n\t  \r\n\t<div class=\"m-subheader\">\r\n    <div class=\"d-flex align-items-center\">\r\n      <div class=\"mr-auto\">\r\n        <h3 class=\"m-subheader__title m-subheader__title--separator\"> Executive List </h3>\r\n        <ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n          <li class=\"m-nav__item m-nav__item--home\"> <a href=\"#\" class=\"m-nav__link m-nav__link--icon\"> <i class=\"m-nav__link-icon la la-home\"></i> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/home\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Home </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/manager\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> Bussiness Manager </span> </a> </li>\r\n          <li class=\"m-nav__separator\"> > </li>\r\n          <li class=\"m-nav__item\"> <a routerLink=\"/portal/executive-list\" class=\"m-nav__link\"> <span class=\"m-nav__link-text\"> List Executive:  </span> </a> </li>\r\n        </ul>\r\n      </div>\r\n      <div>  \r\n         <button type=\"button\" (click)=\"toggleAnimation()\"  class=\"btn m-btn--pill m-btn--air btn-secondary add-btn\">\r\n\t\t\t\t\t<i class=\"fa fa-plus\" style=\"font-size: 16px;padding-right: 5px;\"></i> Add Executive\r\n\t\t</button>\r\n        <a (click)=\"smartToggle();\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-search\"></i></a>\r\n\t\t<a href=\"javascript:void(0);\" class=\"btn btn-lg btn-secondary m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill\"><i class=\"fa fa-share\"></i></a>\r\n\t\t\t\r\n        <div class=\"m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push\" data-dropdown-toggle=\"hover\" aria-expanded=\"true\"> <a href=\"#\" class=\"m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--outline-2x m-btn--air m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle\"> <i class=\"la la-plus m--hide\"></i> <i class=\"la la-ellipsis-h\"></i> </a>\r\n          <div class=\"m-dropdown__wrapper\"> <span class=\"m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust\"></span>\r\n            <div class=\"m-dropdown__inner\">\r\n              <div class=\"m-dropdown__body\">\r\n                <div class=\"m-dropdown__content\">\r\n                  <ul class=\"m-nav\">\r\n                    <li class=\"m-nav__section m-nav__section--first m--hide\"> <span class=\"m-nav__section-text\"> Quick Actions </span> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-share\"></i> <span class=\"m-nav__link-text\"> Activity </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-chat-1\"></i> <span class=\"m-nav__link-text\"> Messages </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-info\"></i> <span class=\"m-nav__link-text\"> FAQ </span> </a> </li>\r\n                    <li class=\"m-nav__item\"> <a href=\"\" class=\"m-nav__link\"> <i class=\"m-nav__link-icon flaticon-lifebuoy\"></i> <span class=\"m-nav__link-text\"> Support </span> </a> </li>\r\n                    <li class=\"m-nav__separator m-nav__separator--fit\"></li>\r\n                    <li class=\"m-nav__item\"> <a href=\"#\" class=\"btn btn-outline-danger m-btn m-btn--pill m-btn--wide btn-sm\"> Submit </a> </li>\r\n                  </ul>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\t\t\r\n\t\t\r\n\t<!--<smart-search [hidden]=\"smartHide\" [@roundAntiClockTrigger]=\"animateSmart\" (smartClickEvent)=\"smartClickListener($event)\"></smart-search>\r\n  -->\r\n  \r\n\t<div class=\"m-content\">\r\n\t\t<div class=\"m-portlet__body\">\r\n\t\t\t\t<div class=\"m-form m-form--label-align-right  m--margin-bottom-30\">\r\n\t\t\t\t\t<div class=\"row align-items-center\">\r\n\t\t\t\t\t\t<div class=\"col-xl-12 order-2 order-xl-1\">\r\n\t\t\t\t\t\t<div class=\"example-container mat-elevation-z8\"> \r\n\t\t\t\t\t\t\t<listTable (listClickEvent)=\"listClickListener($event)\"></listTable>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>  \r\n\r\n\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/executive-list/executive-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ExecutiveListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__list_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.component.ts");
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

var ExecutiveListComponent = (function () {
    function ExecutiveListComponent(_router, http) {
        this._router = _router;
        this.http = http;
        this.flyInOutTrigger = 'in';
        //	@ViewChild(SmartSearchComponent)smart: SmartSearchComponent;
        this.smartHide = true;
        this.animateSmart = 'out';
        this.empId = 0;
    }
    ExecutiveListComponent.prototype.ngOnInit = function () {
        //		this.smart.smartUrl = sessionStorage.getItem('requestUrl')+"/axelacrm/portal/executive-smartsearch";
        this.list.listUrl = sessionStorage.getItem('requestUrl') + "/axelacrm/portal/executive-list";
    };
    ExecutiveListComponent.prototype.smartClickListener = function (event) {
        this.list.listParam['requestType'] = 'filter';
        this.list.listParam['smartParam'] = event;
        this.list.getData();
    };
    ExecutiveListComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/executive-list/executive-add'], { queryParams: { empId: this.empId } });
    };
    ExecutiveListComponent.prototype.smartToggle = function () {
        if (this.smartHide) {
            this.animateSmart = 'in';
            this.smartHide = false;
        }
        else {
            this.animateSmart = 'out';
            this.smartHide = true;
        }
    };
    ExecutiveListComponent.prototype.listClickListener = function (listParam) {
        if (listParam[0] == 'updateExecutive') {
            this.empId = listParam[1];
            this.toggleAnimation();
        }
        if (listParam[0] == 'accessRights') {
            this.empId = listParam[1];
            this._router.navigate(['portal/executive-access-add'], { queryParams: { empId: this.empId } });
        }
        if (listParam[0] == 'listDocuments') {
            this.empId = listParam[1];
            this._router.navigate(['portal/document-list'], { queryParams: { empId: this.empId } });
        }
        if (listParam[0] == 'updatePhoto') {
            this.empId = listParam[1];
            this._router.navigate(['portal/executive-photo'], { queryParams: { empId: this.empId } });
        }
        if (listParam[0] == 'updateEmailSettings') {
            this.empId = listParam[1];
            this._router.navigate(['portal/executive-email'], { queryParams: { empId: this.empId } });
        }
    };
    return ExecutiveListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ExecutiveListComponent.prototype, "flyInOutTrigger", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__layouts_toast_notification_toast_component__["a" /* ToastComponent */]) === "function" && _a || Object)
], ExecutiveListComponent.prototype, "toast", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__list_list_component__["a" /* ListComponent */]) === "function" && _b || Object)
], ExecutiveListComponent.prototype, "list", void 0);
ExecutiveListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/executive-list/executive-list.component.html"),
        styles: [__webpack_require__("../../../../../src/app/theme/pages/portal/executive-list/ececutive-list.component.css")],
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]]
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _d || Object])
], ExecutiveListComponent);

var _a, _b, _c, _d;
//# sourceMappingURL=executive-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/executive-list/executive-list.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ExecutiveListModule", function() { return ExecutiveListModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__executive_list_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/executive-list/executive-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__executive_add_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/executive-list/executive-add.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__executive_component__ = __webpack_require__("../../../../../src/app/theme/pages/portal/executive-list/executive.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__layouts_layout_module__ = __webpack_require__("../../../../../src/app/theme/layouts/layout.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__default_component__ = __webpack_require__("../../../../../src/app/theme/pages/default.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__ = __webpack_require__("../../../../../src/app/theme/layouts/smart-search/smart-search.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__list_list_module__ = __webpack_require__("../../../../../src/app/theme/pages/list/list.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__layouts_toast_notification_toast_module__ = __webpack_require__("../../../../../src/app/theme/layouts/toast-notification/toast.module.ts");
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
                "component": __WEBPACK_IMPORTED_MODULE_3__executive_list_component__["a" /* ExecutiveListComponent */]
            }
        ]
    }, {
        "path": "executive-add",
        "component": __WEBPACK_IMPORTED_MODULE_7__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_4__executive_add_component__["a" /* ExecutiveAddComponent */],
            }
        ]
    },
    {
        "path": "executive",
        "component": __WEBPACK_IMPORTED_MODULE_7__default_component__["a" /* DefaultComponent */],
        "children": [
            {
                "path": "",
                "component": __WEBPACK_IMPORTED_MODULE_5__executive_component__["a" /* ExecutiveComponent */],
            }
        ]
    }
];
var ExecutiveListModule = (function () {
    function ExecutiveListModule() {
    }
    return ExecutiveListModule;
}());
ExecutiveListModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"].forChild(routes), __WEBPACK_IMPORTED_MODULE_6__layouts_layout_module__["a" /* LayoutModule */], __WEBPACK_IMPORTED_MODULE_8__angular_common_http__["c" /* HttpClientModule */],
            __WEBPACK_IMPORTED_MODULE_9__angular_forms__["FormsModule"], __WEBPACK_IMPORTED_MODULE_9__angular_forms__["ReactiveFormsModule"], __WEBPACK_IMPORTED_MODULE_11__list_list_module__["a" /* ListModule */], __WEBPACK_IMPORTED_MODULE_12__layouts_toast_notification_toast_module__["a" /* ToastModule */], __WEBPACK_IMPORTED_MODULE_10__layouts_smart_search_smart_search_module__["a" /* SmartSearchModule */],
            __WEBPACK_IMPORTED_MODULE_13__angular_material__["p" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["s" /* MatNativeDateModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["e" /* MatCardModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["y" /* MatSelectModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["z" /* MatSidenavModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["G" /* MatTableModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["E" /* MatSortModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["t" /* MatPaginatorModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["h" /* MatDatepickerModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["f" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_13__angular_material__["w" /* MatRadioModule */],
        ],
        exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["RouterModule"]],
        declarations: [__WEBPACK_IMPORTED_MODULE_3__executive_list_component__["a" /* ExecutiveListComponent */], __WEBPACK_IMPORTED_MODULE_4__executive_add_component__["a" /* ExecutiveAddComponent */], __WEBPACK_IMPORTED_MODULE_5__executive_component__["a" /* ExecutiveComponent */]],
    })
], ExecutiveListModule);

//# sourceMappingURL=executive-list.module.js.map

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/executive-list/executive.component.html":
/***/ (function(module, exports) {

module.exports = "\t<div class=\"m-subheader mr-auto\" >\r\n\t\t\t<h3 class=\"m-subheader__title m-subheader__title--separator\">\r\n\t\t\t\tExecutive \r\n\t\t\t</h3>\r\n\t\t\t<ul class=\"m-subheader__breadcrumbs m-nav m-nav--inline\">\r\n\t\t\t\t\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a href=\"\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tHome\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__separator\">\r\n\t\t\t\t\t>\r\n\t\t\t\t</li>\r\n\t\t\t\t<li class=\"m-nav__item\">\r\n\t\t\t\t\t<a routerLink=\"/portal/executive\" class=\"m-nav__link\">\r\n\t\t\t\t\t\t<span class=\"m-nav__link-text\">\r\n\t\t\t\t\t\t\tExecutive:\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</a>\t\t\r\n\t\t\t\t</li>\r\n\t\t\t</ul>\r\n\t\t</div>\r\n\t\t\t\r\n\t<div class=\"m-portlet m-portlet--mobile\">\r\n\t\t<div class=\"m-portlet__head col-md-12 btn-row theme\" >\r\n\t\t\t<div class=\"m-portlet__head-caption\">\r\n\t\t\t\t<div class=\"m-portlet__head-title\">\r\n\t\t\t\t\t<h2 class=\"m-portlet__head-text\">\r\n\t\t\t\t\t\tExecutive Status\r\n\t\t\t\t\t</h2>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t\r\n\t\t<div class=\"m-portlet__body row\" id=\"m_form_1\">\t\r\n\t\t\t<div class=\"col-md-1\">Type:</div>\r\n\t\t\t<div class=\"col-md-4\">\r\n\t\t\t\t<select size=\"10\" class=\"form-control\" multiple>\r\n<!-- \t\t\t\t\t<option *ngFor=\"let type of type\" [value]=\"type.key\">{{ type.name}}</option> -->\r\n\t\t\t\t</select>\r\n\t\t\t</div>\t\t\r\n\t\t\t<div class=\"col-md-1\">Branches:</div>\r\n\t\t\t<div class=\"col-md-4\">\r\n\t\t\t\t<select size=\"10\" class=\"form-control\" multiple>\r\n<!-- \t\t\t\t\t<option *ngFor=\"let branch of branch\" [value]=\"branch.key\">{{ branch.name}}</option> -->\r\n\t\t\t\t</select>\r\n\t\t\t</div>\t\r\n\t\t\t<div class=\"col-md-2\"></div>\r\n\t\t\t\r\n\t\t\t<div class=\"container-fluid\">\r\n\t\t\t<br>\r\n\t\t\t\t<table class=\"table table-responsive table-striped table-bordered\">\r\n\t\t\t\t\t<thead>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th></th>\r\n\t\t\t\t\t\t<th class=\"text-center\">Total</th>\r\n\t\t\t\t\t\t<th class=\"text-center\">Active</th>\r\n\t\t\t\t\t\t<th class=\"text-center\">InActive</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t</thead>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>Executive</td>\r\n\t\t\t\t\t\t\t<td class=\"text-right\"></td>\r\n\t\t\t\t\t\t\t<td class=\"text-right\"></td>\r\n\t\t\t\t\t\t\t<td class=\"text-right\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</tbody>\r\n\t\t\t\t</table>\r\n\t\t\t</div>\t\r\n\t\t\t\r\n\t\t\t<div class=\"container-fluid\">\r\n\t\t\t<br>\r\n\t\t\t\t<table class=\"table table-responsive table-striped table-bordered\">\r\n\t\t\t\t\t<thead>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th class=\"text-center\">#</th>\r\n\t\t\t\t\t\t<th class=\"text-center\">Executive</th>\r\n\t\t\t\t\t\t<th class=\"text-center\">Branch</th>\t\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t</thead>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<tbody>\r\n\t\t\t\t\t\t<!-- <tr *ngFor=\"let tdata of data\">\r\n\t\t\t\t\t\t\t<td>{{tdata.slno}}</td>\r\n\t\t\t\t\t\t\t<td>{{tdata.exe}}</td>\t\r\n\t\t\t\t\t\t\t<td>{{tdata.branch}}</td>\t\r\n\t\t\t\t\t\t</tr> -->\r\n\t\t\t\t\t</tbody>\r\n\t\t\t\t</table>\r\n\t\t\t</div>\t\t\t\t\r\n\t\t</div>\r\n\t</div>\t"

/***/ }),

/***/ "../../../../../src/app/theme/pages/portal/executive-list/executive.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ExecutiveComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__ = __webpack_require__("../../../../../src/app/animations/fly-in-out.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__ = __webpack_require__("../../../../../src/app/animations/round-anticlock.animation.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/@angular/common/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_filter__ = __webpack_require__("../../../../rxjs/add/operator/filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_filter___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_filter__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var ExecutiveComponent = (function () {
    function ExecutiveComponent(http, _router, route) {
        var _this = this;
        this.http = http;
        this._router = _router;
        this.route = route;
        this.flyInOutTrigger = 'in';
        this.empId = 0;
        this.route.queryParams.filter(function (params) { return params.empId; }).subscribe(function (params) {
            if (params.empId != undefined) {
                _this.empId = params.empId;
            }
        });
        this.populateData();
    }
    ExecutiveComponent.prototype.ngAfterViewInit = function () {
    };
    ExecutiveComponent.prototype.toggleAnimation = function () {
        this._router.navigate(['portal/executive-list']);
    };
    ExecutiveComponent.prototype.ngOnInit = function () {
    };
    ExecutiveComponent.prototype.populateData = function () {
        var _this = this;
        var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["d" /* HttpHeaders */]({ 'Content-Type': 'application/json' });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/portal/executive-landing', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            //this.access = data;
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/type', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.type = data;
        });
        this.http.post(sessionStorage.getItem('requestUrl') + '/axelacrm/customer-populate/branch', {}, { headers: headers, withCredentials: true }).subscribe(function (data) {
            _this.branch = data;
        });
    };
    return ExecutiveComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["HostBinding"])('@flyInOutTrigger'),
    __metadata("design:type", Object)
], ExecutiveComponent.prototype, "flyInOutTrigger", void 0);
ExecutiveComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: ".m-grid__item.m-grid__item--fluid.m-wrapper",
        template: __webpack_require__("../../../../../src/app/theme/pages/portal/executive-list/executive.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        animations: [__WEBPACK_IMPORTED_MODULE_1__animations_fly_in_out_animation__["a" /* FLY_IN_OUT_ANIMATION */], __WEBPACK_IMPORTED_MODULE_2__animations_round_anticlock_animation__["a" /* ROUND_ANTICLOCK_ANIMATION */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["b" /* HttpClient */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["ActivatedRoute"]) === "function" && _c || Object])
], ExecutiveComponent);

var _a, _b, _c;
//# sourceMappingURL=executive.component.js.map

/***/ })

});
//# sourceMappingURL=executive-list.module.chunk.js.map