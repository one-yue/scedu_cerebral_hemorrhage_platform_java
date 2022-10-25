
var IP=GETIP();

function getresult(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://150.158.131.230/kmer/GetParameter.do",
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
function getresult1(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://150.158.131.230/xdemo1/GetParameter.do",
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
function getdata(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo/GetParameter.do",
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

function getdata_CPG(A){
	var a=A.cpg_param,
	b=A.cpg_path;
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

function getdata_CPG1(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo02/GetParameter.do",
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

function getdata_CPG2(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo03/GetParameter.do",
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

function getdata_CPG3(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo04/GetParameter.do",
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


function getdata_CPG4(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo05/GetParameter.do",
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

function getdata_CPG5(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo06/GetParameter.do",
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

function getdata_CPG6(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo07/GetParameter.do",
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

function getdata_CPG7(A){
	var a=A.cpg_param,
	b=A.cpg_path;
	var t=A.callback;
		$.ajax({ 
		    type: "POST", 	
			url: "http://120.78.69.27:8080/demo08/GetParameter.do",
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

function sendcmd(A)
	{
   var D=A.com_species,
   t=A.callback;
	$.ajax({
	url:'http://120.78.69.27/swgc/AMPSWGCJKEXT.asq',
	timeout: 10000, 
	type:'post',
	dataType:'html',
	data:'{"cmd":"1";"keys":"'+D+'"}',
	async: false,
	error: function(){alert('Error loading document');}, 
	success: function(A){
	//alert(A);
	A=eval('(' + A + ')')
				return t(A)//ajax返回格式为html 转换格式
				//alert(A);
				
				
	} 
	}) 

	}
	
 function makecmd(A)
	{
    var D=A.com_species;
	//t=A.callback;

	$.ajax({
	url:'http://120.78.69.27/swgc/AMPSWGCJKEXT.asq',
	timeout: 10000,
	 type:'post',
	 dataType:'html',
	data:'{"cmd":"0";"keys":"'+D+'";"forcerun":"0"}',
	error: function(){alert('Error loading document');}, 
	success: function(A){
	//alert(A);
			   // A=eval('(' + A + ')');
				//t(A); //ajax返回格式为html 转换格式
				//console.log(A.DataList);
	} 
	}); 

	} 

function getData(A) {//原版获取数据方法 未使用
    var D = A.request,
    t = A.callback,
    E = A.apiname,
    C = "undefined" == typeof A.async || A.async;
    $.ajax({
        url: data_source.url,
        timeout: 1e5,
        type: "post",
        dataType: "html",
        async: false,
        data: '{"databaseid": "LUAP","cmd":"1", "sqlcommand": "' + D + '"}',
        error: function(A) {
            return toastr.error("Unknown error in data acquisition, please check network connection or contact system administrator. Ignore this warning if you are refreshing the page. ", "API interface error:" + E)
        },
        success: function(A) {
			
			
            return $.inArray(E, ["4.1.3.4", "4.1.3.4.1", "4.1.3.4.2", "4.1.3.1.1"]) > -1,
            A = eval('(' + A + ')'),
            1 !== A.errcode && "1" !== A.errcode ? t(A) : toastr.error(A.errtext, "API interface error:" + E)
        }
    })
}
function getDatas(A) {  //XML模式查询数据  图形使用方法
    var D = A.request,  //拼接的where语句
    t = A.callback,    
    E = A.apiname,
    C = "undefined" == typeof A.async || A.async;
    $.ajax({
        url: REQUEST.url,  //请求地址
        timeout: 1e5,
        type: "post",
        dataType: "html",
        async: false,
        data:'{"filename":"'+D+'"}',
        error: function(A) {
			
            return toastr.error("Unknown error in data acquisition, please check network connection or contact system administrator. Ignore this warning if you are refreshing the page.", "API interface error:" + E)
        },
        success: function(A) {
			
            return $.inArray(E, ["4.1.3.4", "4.1.3.4.1", "4.1.3.4.2", "4.1.3.1.1"]) > -1,
            A = eval('(' + A + ')'),
            1 !== A.errcode && "1" !== A.errcode ? t(A) : t("")
        }
    })
}



function genFilterData0() {
   
	var species=$("#species1").val();	//文件名编号
	var classification=$("#classification1").val();
	var speciestext=$("#species1").find("option:selected").text();	//文件名
    return {
		filename:species,
		classification:classification,
		speciestext:speciestext,
    }
	

}
function genFilterData() {
   
	var species1=$("#species1").val();	//文件名编号
	var species2=$("#species2").val();
	
	var classification1=$("#classification1").val();
	var classification2=$("#classification2").val();
	
	var speciestext1=$("#species1").find("option:selected").text();	//文件名
	var speciestext2=$("#species2").find("option:selected").text();
    return {
		filename:species1,
		classification:classification1,
		speciestext:speciestext1,
		
		filename2:species2,
		classification2:classification2,
		speciestext2:speciestext2,
    }
	

}
function showTableLoading(A) {
    A ? $("#datagrid_wrapper .loading").length || $("#datagrid_wrapper").append('<div class="loading">data loading...</div>') : setTimeout(function() {
        $("#datagrid_wrapper .loading").remove()
    },
    1e3)
}

function showLoading(A) {
    A.showLoading({
        text: "loading",
        color: "#c23531",
        textColor: "#fff",
        maskColor: "transparent",
        zlevel: 0
    })
}
function hideLoading(A) {
    A.hideLoading()
}

var API = {},
data_source = {},

REQUEST = {};

REQUEST.url = "http://120.78.69.27/swgc/AMPSWGCJK.asq",
data_source.url="http://120.78.69.27/AMPCOMMONDB2JSON.asq",

API.parseData = function(A) {
    return A.DataList
},
API.luapchart = function(A) {
    var
	t=A.filename,
	F = A.callback;
	
    getDatas({
        request: t,
        apiname: "4.1.3.4",
        callback: F
    })
},


API.luaptable = function(A){
	
},
API.classificationlist = function(A){
	var
	t="select species_classification from species group by species_classification",
	F = A.callback;
    getData({
        request: t,
        apiname: "4.1.3.4",
        callback: F
    })
},
API.specieslist = function(A){
	var
	M=A.classification;
	if(M=="all"){
		M="";
	}else{
		M="where species_classification='"+M+"'";
	}
	var t="select * from species "+M+"",
	F = A.callback;
    getData({
        request: t,
        apiname: "4.1.3.4",
        callback: F
    })
},
(jQuery);
$(function() {
	
	$("#classification1").length && classification();//遍历物种分类下拉框
	$("#species1").length && species();//遍历物种下拉框
	
	$("#classification2").length && classification();//遍历物种分类下拉框
	$("#species2").length && species2();//遍历物种下拉框
	
});

	function first(){ //首页按钮点击时间
		
		var current=1;
		var options = genFilterData();
        options.update = true;
		
        renderTable(options,current);
		
	}
	function prev(){ // 上一页点击事件
		
		var current=parseInt($("#current").text())-1;
			if(current<=0){
				alert("Already the first page !");
				return false;
		}
		 var options = genFilterData();
         options.update = true;
		
         renderTable(options,current);
	}
	function next(){ //下一页点击时间
		
		var current=parseInt($("#current").text())+1;
		var total=parseInt($("#total").text());

		if(current > Math.ceil(total/10)){
				alert("Already the last page !");
				return false;
		}
		 var options = genFilterData();
         options.update = true;
		 
         renderTable(options,current);
	}
	function last(){ //尾页点击时间

		var current=Math.ceil(parseInt($("#total").text())/10);
		 var options = genFilterData();
         options.update = true;
		 
         renderTable(options,current);
	}
	
	
	function format ( d ) {  //列表 详细信息展示 方法
    // `d` is the original data object for the row
	   var tdhength = $("#datagrid").find("tr").find("th").length;
		var sOut = '<table>';
		for (var a=0; a<tdhength; a++)
		{
			sOut += '<tr><td>'+$('#datagrid th:eq('+a+')').html()+':</td><td>'+d[a]+'</td></tr>';
		}
        sOut += '</table>';
             
        return sOut;
	}
	

	
	function GETIP(){
	  var value
		$.ajax({
			url:"xml/Config.Xml",
			type:"POST",
			dataType:"XML",
			data:'',
			async:false,
			}).done(function(data){
			  $(data).find("WADO>IP").each(function(){
				  value=$(this).text();
				});
			  
		  });
		return value;
	}
	function species(){ //遍历物种下拉框方法
		API.specieslist({
			classification:$("#classification1").val(),
			callback: function(data){
				
				data=data.DataList;
				var row="<option value=\"all\">Please select species</option>";
				for(var i=0;i<data.length;i++){
					row+="<option value="+data[i]["species_id"]+">"+data[i]["species_name"]+"</option>";
				}
				$("#species1").html(row);
				
			}
		})
	}

	function species2(){ //遍历物种下拉框方法2
		API.specieslist({
			classification:$("#classification2").val(),
			callback: function(data){
				
				data=data.DataList;
				var row="<option value=\"all\">Please select species</option>";
				for(var i=0;i<data.length;i++){
					row+="<option value="+data[i]["species_id"]+">"+data[i]["species_name"]+"</option>";
				}
				$("#species2").html(row);
				
			}
		})
	}	
/*	function classification(){//遍历物种分类下拉框方法
		API.classificationlist({
		callback: function(data){
			
			data=data.DataList;
			var row="<option value=\"all\">Please select species classification</option>";
			
			for(var i=0;i<data.length;i++){
				//alert(data[i]["species_classification"]);
				row+="<option value='"+data[i]["species_classification"]+"'>"+data[i]["species_classification"]+"</option>";
			}
			
			$("#classification1").html(row);
			
		}
	});
	}
*/	
	function classification(){//遍历物种分类下拉框方法
		API.classificationlist({
		callback: function(data){
			
			data=data.DataList;
			var row="<option value=\"all\">Please select species classification</option>";
			
			for(var i=0;i<data.length;i++){
				//alert(data[i]["species_classification"]);
				row+="<option value='"+data[i]["species_classification"]+"'>"+data[i]["species_classification"]+"</option>";
			}
			
			$("#classification1,#classification2").html(row);
			
		}
	});
	} 
	
	function go_density(){
		var den_row="<option value='All'>All</option>";
		den_row+="<option value='HCGI'>HCGI</option>";
		den_row+="<option value='ICGI'>ICGI</option>";
		den_row+="<option value='LCGI'>LCGI</option>";
		if($("#CpG").val()=='CpG+'){
			$("#Density").html(den_row);
		}
		else
	    $("#Density").html("");
	}
	function go_density2(){
		var den_row="<option value='All'>All</option>";
		den_row+="<option value='HCGI'>HCGI</option>";
		den_row+="<option value='ICGI'>ICGI</option>";
		den_row+="<option value='LCGI'>LCGI</option>";
		if($("#CpG2").val()=='CpG+'){
			$("#Density2").html(den_row);
		}
		else
	    $("#Density2").html("");
	}
	function go_density3(){
		var den_row="<option value='All'>All</option>";
		den_row+="<option value='HCGI'>HCGI</option>";
		den_row+="<option value='ICGI'>ICGI</option>";
		den_row+="<option value='LCGI'>LCGI</option>";
		if($("#CpG3").val()=='CpG+'){
			$("#Density3").html(den_row);
		}
		else
	    $("#Density3").html("");
	}
	
	
	
	
