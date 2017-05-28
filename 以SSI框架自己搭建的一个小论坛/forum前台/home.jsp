<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.nuchina.common.consts.BaseConst"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分享精彩论坛</title>
    
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgcore.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgdialog.min.js"></script>
<style type="text/css">
/*菜单和最新、最热知识的样式*/
*{
	font-family: 微软雅黑;
}
.menuBar {
	width: 100%;
	height: 160px;
	line-height: 42px;
	margin: 0;
	text-align: center;
	color: #FFFFFF;
	font-size: 16px;
	font-weight: normal;
	font-family: 微软雅黑, 宋体;
}
.menuBar .menuUl{
	width: 1000px;
	height:160px;
	list-style: none;
	list-style-position: outside;
	margin: 0 auto 0 auto;
	padding: 0px;
	position: relative;
	background: url('images/business/zj_banner.jpg');
}
.menuBar .menuLi{
	margin: 0px;
	padding: 0px;
	float: left;
}
.menuBar .menuLi .menuA{
	width: 120px;
	line-height:42px;
	text-align: center;
	text-decoration: none;
	display: block;
}
a{
	color:#FFF;
}
</style>
<script type="text/javascript">
	$(function(){
		
		
		slideMenu();
		clickMenu();
	});
function clickMenu(){
	$(".menuA").click(function(){
		switch($(this).text()){
			case "专家在线": changeColor(this,0);$("#homeLeft").attr("src","expertManage/expertManageAction!homeLeft.action");$("#homeRight").parent().show();break;
			case "专家查找": changeColor(this,1);$("#homeLeft").attr("src","expertManage/expertManageAction!professorSearch.action?page.pageSize=4");$("#homeRight").parent().show();break;
			case "重点课题": changeColor(this,2);$("#homeLeft").attr("src","expertManage/expertManageAction!importantProject.action?page.pageSize=5");$("#homeRight").parent().show();break;
			case "专家成果": changeColor(this,3);$("#homeLeft").attr("src","expertManage/expertManageAction!professorAchievement.action?page.pageSize=5");$("#homeRight").parent().show();break;
			case "咨询论坛": changeColor(this,4);$("#homeLeft").attr("src","expertManage/professionalTopicAction!list.action");$("#homeRight").parent().hide();break;
			case "个人中心": changeColor(this,5);$("#homeLeft").attr("src","expertManage/expertManageAction!myselfCenter.action");$("#homeRight").parent().hide();break;
			$("#homeRight").reload();
		}
	});
}
function changeColor(obj,index){
	$(".menuA").each(function(){
		$(this).css("background-color","");
		$(this).css("color","rgb(255,255,255)");
		$(this).removeClass("curMenu");
	});
	$(obj).css("background-color","rgb(197, 215, 247)");
	$(obj).css("color","rgb(30,126,195)");
	$(obj).addClass("curMenu");
}
function slideMenu(){
	$(".menuA").mouseout(function(){
		if (!$(this).hasClass("curMenu")) {
			$(this).css("background-color","");
			$(this).css("color","rgb(255,255,255)");
		}
	});
	$(".menuA").mouseover(function(){
		$(this).css("background-color","rgb(197, 215, 247)");
		$(this).css("color","rgb(30,126,195)");
	});
}

//搜寻帖子
function search(){
	var condition = $("#uname").val();
	var url = encodeURI(encodeURI("forum/forumAction!search.action?page.pageSize=5&&condition="+condition));
	showPage(url,"搜帖、找人",730,400);
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
</script>
  </head>
  	
	<body style="padding: 0px;margin:0px;">
		<form action="forum/forumAction!home.action" >
		<iframe src="<%=basePath%>forum/forumAction!subModuleTop.action" 
		style="padding: 0px; border-bottom-color: #008B8B" frameborder="0" width="100%" height="107px" scrolling="no" >
     	</iframe>
     	<hr color="#dcdcdc" width="1000px" style="margin-top: -4px;"/>
<%--     	导航条--%>
     	<div style="margin-top: 0px;">
			<table width="1000"  align="center" cellpadding="0" cellspacing="0" border="0">
				<tr style="background-color: rgb(47,97,156); height: 40px;color: #ffffff;text-align: center;">
					<td id="index" style="width:100px;background-color:#3fb0f1"  onmouseout="$(this).css('background-color','#3fb0f1');">首页</td>
					<td id="job" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');$('#index').css('background-color','rgb(47,97,156)');" onmouseout="$(this).css('background-color','rgb(47,97,156)');$('#index').css('background-color','#3fb0f1');" onclick="window.location.href='<%=basePath %>forum/forumAction!jobItems.action'">分享工作</td>
					<td id="live" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');$('#index').css('background-color','rgb(47,97,156)');" onmouseout="$(this).css('background-color','rgb(47,97,156)');$('#index').css('background-color','#3fb0f1');" onclick="window.location.href='<%=basePath %>forum/forumAction!liveItems.action'">分享生活</td>
					<td id="live" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');$('#index').css('background-color','rgb(47,97,156)');" onmouseout="$(this).css('background-color','rgb(47,97,156)');$('#index').css('background-color','#3fb0f1');" onclick="window.location.href='<%=basePath %>forum/forumAction!personPage.action'">个人信息</td>
					<td  style="text-align: right;margin-right: 12px;"><input type="text" name="xiao" style="display: none;"> <input type="text" id="uname" name="condition" style="height:20px;width:238px;vertical-align:middle;margin-right: 12px;" placeholder="搜帖、找人" onkeypress="EnterPress(event)" /><img src="images/sousou.png" style="position: relative;vertical-align:middle;right: 34px;vertical-align:middle;" onclick="search();"></td>
				</tr>
			</table>
		</div>	
     	<!-- body -->
		<div style="width: 1000px;margin-left:auto;margin-right:auto;padding-top: 10px;">
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr style="border: 1px;padding-bottom:2px;">
				<td valign="top" colspan="2">
					<iframe id="homeLeft" src="<%=basePath%>forum/forumAction!left.action" 
						width="100%" frameborder="0" scrolling="no"></iframe>
				</td>
				<!-- 
				<td style="width: 228px; margin:0px" valign="top">
					<iframe id="homeRight" src="<%=basePath%>forum/forumAction!right.action?" 
						width="100%" frameborder="0" scrolling="no"></iframe>
				</td>
				 -->
			</tr>
		</table>
	   	</div>
	   	<hr color="#008B8B"/>
	   	<div style="width: 1000px;height:740px;margin-left:auto;margin-right:auto;padding-top: -9px;">
		   <iframe src="<%=basePath%>forum/forumAction!center.action" 
			 frameborder="0" width="1000px" height="720px" scrolling="no" >
	     	</iframe>
     	</div>
     	<jsp:include page="../bottom.jsp"></jsp:include>
     	</form>
	</body>
</html>
