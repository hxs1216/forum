<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.nuchina.common.util.SysConfigUtil"%>
<%@ taglib prefix="uc" uri="myControl.tld"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>标题图片上传</title>
		<link rel="stylesheet" type="text/css" href="css/editPageStyle.css" media="all"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/dialogStyle.css" media="all" />
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/utils/SimpleValidater.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/editor/kindeditor-min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/editor/lang/zh_CN.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/utils/SimpleValidater.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/dialog/lhgcore.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/dialog/lhgdialog.min.js"></script>
<style type="text/css">
.uc {
	width: 130px;
	
}
.tbl {
	width: 100%;
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}
.tbl .btn{
	background: url('images/index/button_inx.png');
	border: 0px;
	width:86px;
	height:32px;
	color:white;
	font-weight: bold;
}
.d-button .btn{
	background: url('images/index/button_inx.png');
	border: 0px;
	width:86px;
	height:32px;
	color:white;
	font-weight: bold;
}
.tbl th {
	min-height: 20px;
	font-size: 13px;
	line-height: 1.4285;
	vertical-align: middle;
	text-align: left;
	border: 1px solid #E1E1E1;
	padding-right: 1px;
	background-color: #F6F6F6;
	font-weight: normal;
	height:30px;
	font-family: 微软雅黑;
	letter-spacing: 1px;
}
.tbl td {
	background-color: #FFFFFF;
	font-size: 13px;
	line-height: 1.4285;
	vertical-align: middle;
	border: 1px solid #E1E1E1;
	
	text-align: center;
	color: #000000;
}

</style>

<script type="text/javascript">

//上传图片
var imgType="gif,jpg,jpeg,bmp,png,psd";
function uploadPhono(){
	var fileName=$("#uploadFile").val();
	if(-1==imgType.indexOf(fileName.substring(fileName.lastIndexOf(".")+1))){
		alert("请上传图片类型：gif,jpg,jpeg,bmp,png,psd");
		return ;
	}
	//异步提交文件表单
	$.ajaxFileUpload({
		url :'forum/forumAction!updateImg.action', //需要链接到服务器地址
		secureuri : false,
		fileElementId : 'uploadFile', //文件选择框的id属性
		dataType : 'text', //服务器返回的格式，可以是json
		success : function(data, status) //相当于java中try语句块的用法
		{
			//绑定一个时间的参数，可以解除浏览器的缓存问题
			$("#phonoImg").attr("src","<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>"+data);
			$(":hidden[name='record.picture']").val(data);
		},
		error : function(data, status, e) 
		{
			alert("上传失败");
		}
	});
}

//删除图片
function deleteImg(){
	var picture = $(":hidden[name='record.picture']").val();
	if(picture==""){
			alert("请先上传图片！");
	}else{
		if(!confirm("确定删除？")){return false;}
		//异步提交文件表单
		 $.ajax({
			 url:'forum/forumAction!deleteImg.action',
			 data : {
				 'filePath':picture
			 },
			 type : 'post',
			 dataType : 'json',
			 success : function(data) {
					$("#phonoImg").attr("src","");
					$(":hidden[name='record.picture']").val("");
				}
			 
		 });
	}
}

//保存
function addRow(){
	var pic=$.trim($(":hidden[name='record.picture']").val());
	if(pic==""){
		alert("请上传标题图片！");
		$("#phonoImg").select();
		$("#phonoImg").css("border","1px solid red");
		return false;
	}
	var DGChild = frameElement.lhgDG;
	DGChild.curWin.window.showPicture(pic);
	DGChild.cancel();
}

$(function(){
	var obj = $("#record_picture").val();
	if(obj!="" || obj!=null){
		$("#phonoImg").attr("src","<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>"+obj);
	}
})
</script>
<style>
.hiddenClass{
	display:none;
}
</style>
	</head>
	<body>
		<form action="" method="post" id="myform" enctype="multipart/form-data" style="margin-top: -15px;" target="_self">
			<s:hidden name="record.picture"></s:hidden>
			<table class="input-table" align="center" cellspacing="0" style="border: 0 solid #bfbfbf;">
				<tr>
					<s:if test="isTopic!=0">
					<td style="text-align: center;border: 0 solid #bfbfbf;">
						<img id="phonoImg" src="" height="211px" width="362px" style="border:1px solid #bfbfbf;"/>
						<div>   
						<font color="red">(说明：请上传350*600像素范围内的图片)</font>
						</div>
						<br>
						<div style="float: center;">
							<s:file id="uploadFile" name="file" cssClass="photo"  cssStyle="width: 66px;height:25px;" onchange="uploadPhono();"/>	 
						</div>
					</td>
					</s:if>
					<s:else>
						<td style="text-align: right;border: 0 solid #bfbfbf;">
	                    	<img id="phonoImg" src="" height="211px" width="362px" style="border:1px solid #bfbfbf; margin-left:20px;"/>
	                    	<div>   
							<font color="red">标题图片</font>
							</div>
						</td>
					</s:else>
				</tr>
			</table>
			<s:if test="isTopic!=0">
			<div style="margin-top: 11px;">
			       		<input type="button" id="btnAddRow" class="btn"  style="width: 89px;height:28px;line-height: 11px; margin-left: -32px;" value="保存" onclick="addRow()"/>
			</div>
			</s:if>
		</form>
	</body>
</html>
