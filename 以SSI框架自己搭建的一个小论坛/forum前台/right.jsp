<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.nuchina.common.util.SysConfigUtil"%>
<%@page import="java.util.Date"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页的右侧部门</title>
    
	<link rel="stylesheet" type="text/css" href="<%=basePath%>business/expertmanage/home.css"/>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgcore.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgdialog.min.js"></script>
<style type="text/css">
*{
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
}
a:link {
	text-decoration: none;
	color:black;
}
a:hover {
	text-decoration: underline;
	
}
*{
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
	font-size: 14px;
	padding:0px;
	margin:1px;
}
.about-mine-div{
	padding-top: 6px;
}
.about-mine-div li{
	list-style: none;
	height: 27px;
	line-height: 40px;
	font-size: 13px;
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
	padding-left: 10px;
	cursor: pointer;
	color:#6B6B6B;
}
.ulAsk li a{
	color: black;
	font-size:13px;
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
}
.tt{
-webkit-border-radius: 50em;
-ms-border-radius: 50em;
-moz-border-radius: 50em;
-moz-border-radius: 50em;
border-radius: 50em;
}
</style>
<script type="text/javascript">
	$(function(){
		//我要发帖
		$("#paster").bind({
			mouseover:function(){$(this).css("background-color","red");},
			click:function(){
				document.forms[0].action="forum/forumAction!draft.action";
				document.forms[0].submit();
			},
			mouseout:function(){$(this).css("background-color","#3fb0f1");}
		});
		var h1 = document.body.scrollHeight;
		window.frameElement.style.height = h1+"px";
		
	});

	//个人信息修改
	function itemDetail(id) {
			showPage("forum/forumAction!alterInformation.action?id="+id,'个人信息修改',460,400);
	}
	
	
	//搜寻我的帖子
	function searchComment(){
		showPage('forum/forumAction!searchComment.action?page.pageSize=5',"我的帖子",730,400);
	}
	
	//搜寻我的消息
	function searchNews(){
		showPage('forum/forumAction!alreadyRelation.action',"已看信息",730,400);
	}
	
	//相关数据
	function relation(){
		showPage('forum/forumAction!myRelation.action?page.pageSize=5',"我的相关信息",730,400);
	}
	
	function startTime(){
		//头像的回复量数据须不要刷新页面显示实时数据
		$.ajax( {  
			    url:'forum/forumAction!timeRefresh.action',// 跳转到 action  
			    data:{  
			             "id" : "$('#person_id')"
			    },  
			    type:'post',  
			    cache:false,  
			    dataType:'json',  
			    success:function(data) {  
			    	$("#extend").text(data.myRelation);
			    	$("#aaaaa").text(data.myNews);
			     } 
			});
		
<%--	t=setTimeout('startTime()',2000);--%>
		
	}
	
</script>
  </head>
  
  <body style="padding-left: 5px;" onload="startTime()">	
  <form action=""  target="_blank" onsubmit="return false;">
  	<s:hidden name="person.id"/>
	<div style="width: 220px;padding-bottom:1px;margin-bottom:1px;">
		<div style="height: 34px;line-height: 34px;padding-left: 5px;background-color: #3FB0F1;">
			<div style="color:white;display:inline-block;font-size: 14px;">个人信息 </div>
		</div>
		<div class="about-mine-div" style="text-align: center;border: 1px solid rgb(237,237,237);">
		<label style="cursor: pointer;float:right;background:url('images/comments.png') no-repeat;margin-left: -43px;width: 35px; height: 38px;" onclick="relation();">
				<font id="extend" style="font-family: 微软雅黑, 宋体, Arial, sans-serif;font-size:12px;color:white;"><s:property value="person.extend1"/></font>
			</label>
			<s:if test="person.picture==null">
				<img src="images/forum-default.png" class="tt" style="width: 45%;height:100px;" />
			</s:if>
			<s:else>
				<img src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${person.picture}" class="tt" style="width: 45%;height:100px;" />
			</s:else>
			
			<div style="height:30px">
				<span onmouseover="this.style.color='red';" onclick="itemDetail(${person.id});" onmouseout="this.style.color='#6b6b6b';"><font style="font-weight: bold;">昵称：</font><label><s:property value="person.nickName"/></label></span>
				
			</div>
			<div style="text-align: left; margin-top: 5px;height: 25px;" >
				<img src="images/business/expertmanage/mine-topic.png" style="vertical-align: middle;">
				<label onclick="searchComment();" onmouseover="this.style.color='red';" onmouseout="this.style.color='#6b6b6b';">我的发帖：<s:property value="person.myComment"/></label></img>
			</div>
			<div style="text-align: left;margin-top: 5px;height: 25px;">
				<img src="images/business/expertmanage/mine-subject.png" style="vertical-align: middle;">
				<label id="myNews" onclick="searchNews();"  onmouseover="this.style.color='red';" onmouseout="this.style.color='#6b6b6b';" >我的消息：<font id="aaaaa"><s:property value="person.myPost"/></font></label></img>
			</div>
			<div style="padding:1px;margin-top: 6px;margin-bottom: 15px;"><input style="border: 0 none;border-radius: 4px;color: #ffffff;height:30px;width:129px;background-color:#3fb0f1;" type="button" value="我要发帖" id="paster">
			</div>
			
		</div>
	</div>
	</form>
  </body>
</html>
