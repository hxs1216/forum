<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.nuchina.abroad.proEnum.AbroadEnum"%>
<%@page import="com.nuchina.common.util.SysConfigUtil"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="f" uri="/WEB-INF/tlds/SysUpload"%>
<%@ taglib prefix="uc" uri="myControl.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>" />

<title>人力论坛</title>		
	<link rel="stylesheet" type="text/css" href="cmuc/css/processlogs.css" />
	<link rel="stylesheet" type="text/css" href="css/editPageStyle.css" media="all"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/editor/kindeditor.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/utils/SimpleValidater.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/editor/kindeditor-min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/editor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgcore.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgdialog.min.js"></script>
	<script src="<%=basePath%>js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=basePath%>js/baseuploadfilebyjs.js"></script>
	<style type="text/css">
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
.input-table tr td{
	min-width: 36px;
	border: 0 solid #e1e1e1;
	line-height: 2.429;
}
.input-table tr th{
	min-width: 36px;
	border: 0 solid #e1e1e1;
}
</style>
<script type="text/javascript">
	
$(function(){
	if("${praise}"=="yes"){
		$("#praise").attr("src","images/praise2.png");
	}else{
		$("#praise").attr("src","images/praise1.png");
	}
	
	
})

//发表评论
var reply = function(){
	
	if($.trim($("#replyContent").val())==""){
		alert("请输入评论内容再提交");
		$("#replyContent").focus();
		$("#replyContent").css("border","1px solid red");
		return false;
		}
		
	document.forms[0].action="forum/forumAction!reply.action?isTopic=0";
	document.forms[0].submit();
}



//回复按钮操作
	function replyPerson(obj,id,build){
		var objAll = "回复"+obj+":";
		showPage("forum/forumAction!replyPerson.action?record.id=${record.id}&bu="+build+"&id="+id,objAll,600,185);
	}
	

//标题图片的查看
function chakan(){
		var pic = $("#record_picture").val();
		showPage("forum/forumAction!update.action?isTopic=0&record.picture="+pic,'背景图片的查看',450,370);
	}

//回车事件搜寻帖子
	function EnterPress(e){
		var e=e || window.event;
		if(e.keyCode==13){
			var condition = $("#uname").val();
			var url = encodeURI(encodeURI("forum/forumAction!search.action?page.pageSize=5&&condition="+condition));
			showPage(url,"搜帖、找人",730,400);
		}
	}

	//搜寻帖子
	function search(){
		var condition = $("#uname").val();
		var url = encodeURI(encodeURI("forum/forumAction!search.action?page.pageSize=5&&condition="+condition));
		showPage(url,"搜帖、找人",730,400);
	}
</script>
</head>
<body style="background-color: #fff;font-family: 微软雅黑,宋体,Arial,sans-serif;font-size: 14px;font-style: normal;font-weight: normal;color: #000000;">
	<form action="" name="form1" method="post" enctype="multipart/form-data" id="mainForm">
		<s:hidden name="record.id"></s:hidden>
		<s:hidden name="record.draftTime"></s:hidden>
		<s:hidden name="record.nickName"></s:hidden>
		<s:hidden name="record.picture"></s:hidden>
		<s:hidden name="record.replyNum"></s:hidden>
		<s:hidden name="attachName"></s:hidden>
		<iframe src="<%=basePath%>forum/forumAction!subModuleTop.action" 
		style="padding: 0px; border-bottom-color: #008B8B" frameborder="0" width="100%" height="107px" scrolling="no" >
     	</iframe>
     	<hr color="#dcdcdc" width="1000px" style="margin-top: -3px;"/>
		
		<%--导航条--%>
     	<div style="margin-top: 0px;">
			<table width="1000"  align="center" cellpadding="0" cellspacing="0" border="0">
				<tr style="background-color: rgb(47,97,156); height: 40px;color: #ffffff;text-align: center;font-size: 15px;">
					<td id="index" style="width:100px;"  onmouseover="$(this).css('background-color','#3fb0f1');" onmouseout="$(this).css('background-color','rgb(47,97,156)');" onclick="window.location.href='<%=basePath %>forum/forumAction!home.action'">首页</td>
					<td id="job" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');" onmouseout="$(this).css('background-color','rgb(47,97,156)');" onclick="window.location.href='<%=basePath %>forum/forumAction!jobItems.action'">分享工作</td>
					<td id="live" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');" onmouseout="$(this).css('background-color','rgb(47,97,156)');" onclick="window.location.href='<%=basePath %>forum/forumAction!liveItems.action'">分享生活</td>
					<td id="live" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');" onmouseout="$(this).css('background-color','rgb(47,97,156)');" onclick="window.location.href='<%=basePath %>forum/forumAction!personPage.action'">个人信息</td>
					<td  style="text-align: right;margin-right: 12px;"><input type="text" name="xiao" style="display: none;"> <input type="text" id="uname" name="condition" style="height:20px;width:238px;vertical-align:middle;margin-right: 12px;" placeholder="搜帖、找人" onkeypress="EnterPress(event)" /><img src="images/sousou.png" style="position: relative;vertical-align:middle;right: 34px;vertical-align:middle;" onclick="search();"></td>
				</tr>
			</table>
		</div>
		<table class="maintbl" align="center" cellspacing="0" cellpadding="0" border="0" style="box-shadow: 0 0 0 #c4d1d9;">
			<tr>
				<td class="maintblTd" style="padding: 12px 13px;">
					<table class="input-table" cellspacing="0" cellpadding="0" style="border: 0 solid #bfbfbf;">
						<tr>
							<th rowspan="4" colspan="1" style="border-bottom: 1px solid #DCDCDC;text-align: center;align:center;vertical-align: top;" >
								<img src="images/building.png"  style="width:39px;height: 39px;float: right;margin-right: -4px;"/>
								<br>
								<img src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${person.picture}"  style=" padding: 3px;width:92px;height:115px;text-align: center;border:1px solid #DCDCDC;margin-left: 10px; margin-top: -16px;" />
								<br>
								<font color="red" style="font-size: 12px;font-weight: normal;">${person.nickName}</font>
								
							</th>
							<td style="padding-left: 32px;border-bottom: 1px dashed #7FFFD4;">类型：<s:property value="record.postSort"/></td>
							<td style="border-bottom: 1px dashed #7FFFD4;">发表时间：<s:date name="record.draftTime" format="yyyy-MM-dd"/></td>
							<td colspan="2" style="border-bottom: 1px dashed #7FFFD4;">&nbsp;浏览量：<s:if test='record.viewNum==null || record.viewNum==""'>0</s:if><s:else>${record.viewNum}</s:else>&nbsp;
								回复数：<s:if test='record.replyNum==null || record.replyNum==""'>0</s:if><s:else>${record.replyNum}</s:else>&nbsp;&nbsp;
								<a href="javascript:void(0);" onclick="addPraise();">
									<img id="praise" src=""  style="height:20px;width:20px;outline:none;border:none;"/>
								</a>&nbsp;<font id="praiseNUM"><s:if test='record.praiseNum==null || record.praiseNum==""'>0</s:if><s:else>${record.praiseNum}</s:else></font>
							</td>
						</tr>
						<tr>
							<td colspan="3" style="font-weight: 600;font-size: 15px;width:500px;border-bottom: 1px dashed #7FFFD4;padding-left: 30px;">标题：<s:property value="record.title"/></td>
							<td style="border-bottom: 1px dashed #7FFFD4;">
								<input type="button" value="标题图片" class="btn"  style="background-color: #3fb0f1;border: 0 none;border-radius: 4px;color: #ffffff;float: right;" onclick="chakan();"/>
							</td>
						</tr>
						<tr>
							<td colspan="4" style="padding-left: 56px;border-bottom: 1px dashed #7FFFD4;"><label style="padding-top: 10px;margin-top: 10px;font-family:message-box;"><s:property value="content"  escape="false"/></label></td>
						</tr>
						<tr>
							<s:if test='attachName=="" || attachName==null'>
								<td colspan="4" style="padding-left: 33px;border-bottom: 1px solid #DCDCDC;">附件信息：<a href="javascript:void(0);">无</a></td>
							</s:if>
							<s:else>
								<td colspan="4" style="padding-left: 33px;border-bottom: 1px solid #DCDCDC;">附件信息：<a href="javascript:downloadFile('${attachPath}','${attachName}')"><s:property value="attachName"/></a></td>
							</s:else>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>