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
		<title>个人信息修改</title>
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
			$(":hidden[name='person.picture']").val(data);
		},
		error : function(data, status, e) 
		{
			alert("上传失败");
		}
	});
}

//删除图片
function deleteImg(){
	var picture = $(":hidden[name='person.picture']").val();
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
					$(":hidden[name='person.picture']").val("");
				}
			 
		 });
	}
}

//保存
function addRow(){
	
	var name=$.trim($("#person_nickName").val());
	var pic=$.trim($(":hidden[name='person.picture']").val());
	if(name==""){
		alert("请填写个人昵称！");
		return false;
	}
	if(pic==""){
		alert("请上传个人头像！");
		return false;
	}
	var id=$("#person_id").val();
	var picture=$("#person_picture").val();
	var nickName=$("#person_nickName").val();
	var extend4=$("#person_extend4").val();
	if('${person.nickName}'!=nickName){
		if(extend4=="2"){
			alert("您已修改两次，请联系管理员进行修改！");
			return false;
		}
		if(extend4=="" || extend4==null){
			var a = "还能修改2次昵称，是否修改昵称？";
		 }
		if(extend4=="1"){
			var a = "还能修改1次昵称，是否修改昵称？";
		 }
		if(confirm(a)){
		//异步提交文件表单
		 $.ajax({
			 url:'forum/forumAction!itemUpdate.action',
			 data : {
				'person.id':id,
				'person.picture':picture,
				'person.nickName':nickName,
				'person.extend4':extend4,
				'have':'true'
			 },
			 type : 'post',
			 dataType : 'json',
			 success : function(data) {
				 
				 var DGChild = frameElement.lhgDG;
				DGChild.curWin.parent.document.forms[0].submit();
				 DGChild.cancel();
				}
			 
		 });
		}
		
	}
	
	if('${person.nickName}'==nickName){
		//异步提交文件表单
		 $.ajax({
			 url:'forum/forumAction!itemUpdate.action',
			 data : {
				'person.id':id,
				'person.picture':picture,
				'person.nickName':nickName,
				'person.extend4':extend4,
				'have':'false'
			 },
			 type : 'post',
			 dataType : 'json',
			 success : function(data) {
				 
				 var DGChild = frameElement.lhgDG;
				DGChild.curWin.parent.document.forms[0].submit();
				 DGChild.cancel();
				}
			 
		 });
		
	}
	
	
}

//关闭窗口
function close1(){
	var DGChild = frameElement.lhgDG;
	DGChild.cancel();
}
</script>
<style>
.hiddenClass{
	display:none;
}
</style>
	</head>
	<body>
		<form action="" method="post" id="myform" enctype="multipart/form-data" style="margin-top: -15px;" target="_self">
			<s:hidden name="person.id"></s:hidden>
			<s:hidden name="person.picture"></s:hidden>
			<s:hidden name="person.extend4"></s:hidden>
			<div style="border:1px;">
			<table class="input-table" align="center" cellspacing="0">
				<tr>
					<th style="width:100px;text-align: right;">
						<em>*</em>个人昵称：
					</th>
					<td style="width:150px;text-align: left;">
						<s:textfield name="person.nickName"  style="width:49%;" maxLength="9"></s:textfield>
					</td>
				</tr>
				<tr>
					<th style="width:100px;text-align: right;height:260px;">
						<em>*</em>个人头像：
					</th>
					<td>
						<img src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${person.picture}" id="phonoImg" 
						style="height:160px;width:160px;border:1px solid #bfbfbf;-webkit-border-radius: 50em;-ms-border-radius: 50em;-moz-border-radius: 50em;-moz-border-radius: 50em;border-radius: 50em;" />
						<div ><font color="red">(说明：请上传550*600像素的图片)</font></div>
						<s:file id="uploadFile" name="file" cssClass="photo"  cssStyle="width: 61px;height:25px;margin-left: 54px;margin-top: 17px;" onchange="uploadPhono();"/>	 
					</td>
				</tr>
				<tr>
			       <td colspan="2" align="center" style="text-align: center; border: 0px solid #e1e1e1;">
			       		<input type="button" style="margin-left:50px;width:78px;" id="btnAddRow" class="btn" value="保存" onclick="addRow()"/>
						<input type="button"style="margin-left:40px;width:78px;" class="btn" value="关闭" onclick="javascript:close1();"/>
			       </td>
			    </tr>
			</table>
			</div>
		</form>
	</body>
</html>
