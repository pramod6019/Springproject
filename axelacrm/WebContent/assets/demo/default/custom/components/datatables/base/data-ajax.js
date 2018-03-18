$.ajaxSetup({
//	dataType: 'json',
//	xhrFields:{ withCredentials : true },
	beforeSend:function(xhr,option){
		alert("option.url==="+option.url);
		xhrFields:{ withCredentials : true };
		xhr.withCredentials=true;
//		document.cookie="jsessionid=5555555555555555555555";
		xhr.setRequestHeader("Cookie","jsessionid=5555555555555555555555");
		Cookies.set("jsessionid","5555555555555555555555");
		alert(document.cookie);
	}
});

var DatatableRemoteAjaxDemo = function() {
	var t = function() {
		var t = $(".m_datatable")
				.mDatatable(
						{
							data : {
								type : "remote",
								source : {
									read : {
										url : "http://localhost:8030/axelacrm/customer/customer-list/1/0/0"
									}
								},
								pageSize : 10,
								saveState : {
									cookie : true,
									webstorage : !0
								},
								serverPaging : !0,
								serverFiltering : !0,
								serverSorting : !0
							},
							layout : {
								theme : "default",
								class : "",
								scroll : !1,
								footer : !1
							},
							sortable : !0,
							pagination : !0,
							columns : [
									{
										field : "customer_id",
										title : "Id",
										sortable : !1,
										width : 40,
										selector : !1,
										textAlign : "center"
									},
									{
										field : "customer_name",
										title : "Customer",
										filterable : !1,
										width : 150,
									},
									{
										field : "customer_mobile1",
										title : "Contacts",
										width : 150,
									},
									{
										field : "customer_address",
										title : "Address"
									},
									{
										field : "customer_type",
										title : "Type",
										width : 100
									},
									{
										field : "customer_executive",
										title : "Executive",
										sortable : "asc",
									},
									{
										field : "customer_branch",
										title : "Branch",
										type : "number"
									},
									{
										field : "Actions",
										width : 110,
										title : "Actions",
										sortable : !1,
										overflow : "visible",
										template : function(t) {
											return '\t\t\t\t\t\t<div class="dropdown '
													+ (t.getDatatable()
															.getPageSize()
															- t.getIndex() <= 4 ? "dropup"
															: "")
													+ '">\t\t\t\t\t\t\t<a href="#" class="btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" data-toggle="dropdown">                                <i class="la la-ellipsis-h"></i>                            </a>\t\t\t\t\t\t  \t<div class="dropdown-menu dropdown-menu-right">\t\t\t\t\t\t    \t<a class="dropdown-item" href="#"><i class="la la-edit"></i> Edit Details</a>\t\t\t\t\t\t    \t<a class="dropdown-item" href="#"><i class="la la-leaf"></i> Update Status</a>\t\t\t\t\t\t    \t<a class="dropdown-item" href="#"><i class="la la-print"></i> Generate Report</a>\t\t\t\t\t\t  \t</div>\t\t\t\t\t\t</div>\t\t\t\t\t\t<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" title="Edit details">\t\t\t\t\t\t\t<i class="la la-edit"></i>\t\t\t\t\t\t</a>\t\t\t\t\t\t<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="Delete">\t\t\t\t\t\t\t<i class="la la-trash"></i>\t\t\t\t\t\t</a>\t\t\t\t\t'
										}
									} ]
						}), e = t.getDataSourceQuery();
		$("#m_form_search").on(
				"keyup",
				function(e) {
					var a = t.getDataSourceQuery();
					a.generalSearch = $(this).val().toLowerCase(), t
							.setDataSourceQuery(a), t.load()
				}).val(e.generalSearch), $("#m_form_status").on(
				"change",
				function() {
					var e = t.getDataSourceQuery();
					e.Status = $(this).val().toLowerCase(), t
							.setDataSourceQuery(e), t.load()
				}).val(void 0 !== e.Status ? e.Status : ""), $("#m_form_type")
				.on(
						"change",
						function() {
							var e = t.getDataSourceQuery();
							e.Type = $(this).val().toLowerCase(), t
									.setDataSourceQuery(e), t.load()
						}).val(void 0 !== e.Type ? e.Type : ""), $(
				"#m_form_status, #m_form_type").selectpicker()
	};
	return {
		init : function() {
			t()
		}
	}
}();
jQuery(document).ready(function() {
	DatatableRemoteAjaxDemo.init()
});