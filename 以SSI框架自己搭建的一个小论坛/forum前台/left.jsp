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
<html >
  <head>
    <base href="<%=basePath%>">
    
    <title>首页的左侧部门</title>
    <link rel="stylesheet" type="text/css" href="css/tpcynr.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>business/expertmanage/home.css"/>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<style type="text/css">
*{
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
}
*{
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
	font-size: 16px;
	padding:4px;
	margin:1px;
}

</style>
<script type="text/javascript">
	$(function(){
		var h1 = document.body.scrollHeight;
		window.frameElement.style.height = h1+"px";
	});
	
	var objId=null;
	//鼠标悬浮功能
	function over(id,obj){
		if(objId != null){
			var d="#a_"+objId;
			$(d).find("label").css("color","black");
		}
		obj.style.color='#009999';
		$('#imgPic').attr('src',$(obj).nextAll('img').attr('src'));
		
		objId = id;
	}
	
	//点击方式
	function clickID(){
		if(objId!=null){
			window.open('forum/forumAction!detail.action?record.id='+objId+'&isTopic=0');
		}else{
			window.open('forum/forumAction!detail.action?record.id=${forumBest[0].id}&isTopic=0');
		}
	
	}
</script>
  </head>
  
  <body >
  	<div style="height: 36px;line-height: 36px;padding-left: 10px;margin-top: -25px;">
		<div style="float:left;color:#0084ce;display:inline-block;padding: 3px;font-size: 18px;font-family: 微软雅黑, 宋体, Arial, sans-serif;font-weight: bold;">精品推荐</div>	
		<a href="javascript:void();" onclick="window.open('forum/forumAction!bestItems.action?page.pageSize=15')" style="float: right;cursor: pointer;margin-right: 10px;color:#0084ce;font-size:13px;margin-top:10px;">>>&nbsp;MORE</a>
	</div>
	<div style="height:260px;">
		<div style="float:left;">
			<img onclick="clickID();" id="imgPic" src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${forumBest[0].picture}" style="cursor: pointer;height:250px;width:428px;border: 1px solid #dcdcdc;" />
		</div>
		<div style="float:left;;text-align: left;width:224px;margin-top: -8px;" id="aa" >
			<ul style="list-style: outside none none;" id="bestPosts">
				<s:iterator value="forumBest" var="pic" status="sts" begin="0" end="forumBest.size()>=6?5:forumBest.size()-1">
					<li style="border-bottom: 1px dashed #0cf;padding: 11px 10px 11px 0;width:500px;" id="a_${id}">
					<img id="img2" style="cursor: pointer;border: none;margin-bottom: -6px;" alt="" src="<%=basePath%>images/good.gif;" >
					<label style="cursor: pointer;font-size: 16px;margin-left:-11px;" onclick="window.open('forum/forumAction!detail.action?record.id=${id}&isTopic=0')" onmouseover="over('${id}',this);" >
					
					<s:if test="sortDetail=='' || sortDetail==null" >
						<s:property value="title"/>
					</s:if>
					<s:else>
						[<s:property value="sortDetail"/>]<s:property value="title"/>
					</s:else>
					</label>
					
					<img   src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${pic.picture}" style="display: none;"/>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>
  </body>
</html>
