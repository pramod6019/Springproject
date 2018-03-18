var Select2 = function() {
	var e = function() {
		
				
				$("#city, .city").select2({
									placeholder : "Search City",
									allowClear : !0,
									delay : 250,
									ajax : {
										url : sessionStorage.getItem('requestUrl')+"/axelacrm/customer-populate/city",
										type : 'POST',
										dataType : "json",
										data:function(e){
											return{
												cityName:e.term
												  }
										},
									},
									minimumInputLength : 2,
//									multiple :  true,
									dropdownAutoWidth: true,
									width:'100%',
									
								}),
								
					$("#customer").select2({
									placeholder : "Search Customer",
									allowClear : !0,
									delay : 250,
									ajax : {
										url : sessionStorage.getItem('requestUrl')+"/axelacrm/customer-populate/customer-selectto",
										type : 'POST',
										dataType : "json",
										data:function(e){
											return{
												customerName:e.term
												  }
										},
									},
									minimumInputLength : 2,
//									multiple :  true,
									dropdownAutoWidth: true,
									width:'100%',
									
								})
								
	}, t = function() {
		console.log('inside select2');
		$("#m_select2_modal").on("shown.bs.modal", function() {
			console.log('inside show');
			$("#m_select2_1_modal").select2({placeholder : "Select a state"
			}), $("#m_select2_2_modal").select2({placeholder : "Select a state"
			}), $("#m_select2_3_modal").select2({placeholder : "Select a state"
			}), $("#m_select2_4_modal").select2({placeholder : "Select a state",allowClear : !0
			})
		})
	};
	return {
		init : function() {
			e(), t()
		}
	}
}();
jQuery(document).ready(function() {
	Select2.init()
});