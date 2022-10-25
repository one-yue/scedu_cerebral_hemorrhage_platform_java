function getdata_model(A){
	var a=A.model_param,
	b=A.model_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo01/GetParameter.do",
			dataType:"json",
			async: false,
			data:{
				param:a,
				path:b
			},
			success: function(data) {
			 // $("#createResult").html(data.msg);
			 //data1=data.msg;
			 //data1=data.msg;
			 //console.log(data.msg)
			 return t(data);
			},
			error:function(jqXHR){     
			   alert("发生错误：" + jqXHR.status);  
			}     
		});
		}
