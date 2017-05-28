<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.nuchina.common.consts.BaseConst"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
    <base href="<%=basePath%>"/>
    <title>我的帖子</title>
    <style type="text/css">
    	*{
    		font-family: 微软雅黑;
    	}
    	a:hover{
    		text-decoration: underline;
    		color: red;
    	}
    	.a-div a{
    		text-decoration: none;
    		font-size: 14px;
    		color:black;
    	}
    </style>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/listPageStyle.css" media="all" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js">	</script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgcore.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/dialog/lhgdialog.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function(){
		//点击浏览器 回退时，还原之前的页面效果
		$("#homeRight",parent.document).parent().show();
		parent.changeColor($(".menuA:eq(2)",parent.document),2);
	});

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
  
	<body>
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
     	<!-- body -->
		<form action=""  method="post">
		<div style="width: 1000px;margin: 0 auto;padding-top: 5px;">
			<table id='tbmain' class="tbmain" cellpadding="0" cellspacing="0" style="margin-top: 15px;border: 1px solid #ace;">
				<thead>
					<tr>
						<th style="width: 40px;align:center;" >
							编号
						</th>
						<th style="width: 200px;" align="center" >
							标题
						</th>
						<th style="width: 100px;align:center;">
							拟稿时间
						</th>
						<th style="width: 70px;align:center;">
							帖子类别
						</th>
						<th style="width: 60px;align:center;">
							浏览量
						</th>
						<th style="width: 60px;align:center;">
							点赞数
						</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.resultList" var="obj" status="status">
					<tr  bgcolor="<s:property value="%{#status.count%2==0?'#F6F6F6':'#ffffff'}"/>">
						<td style="text-align:center;">
							<s:property value="#status.count" />
						</td>
						<td title="${obj.title}">
							<a href="forum/forumAction!detail.action?record.id=${id}&isTopic=0" target="_blank">${obj.title}</a>
						</td>
						<td style="text-align:center;">
							<s:date name="#obj.draftTime" format="yyyy-MM-dd HH:mm"/>
						</td>
						<td style="text-align:center;">
							<s:property value="#obj.postSort" />
						</td>
						<td style="text-align:center;">
							<s:property value="#obj.viewNum" />
						</td>
						<td style="text-align:center;">
							<s:property value="#obj.praiseNum" />
						</td>
						</tr>
				</s:iterator>
				</tbody>
			</table>
			<!-- 分页插件，共用Jsp页面 -->
			<jsp:include page="/common/page.jsp"></jsp:include>
		</div>
		</form>
	</body>
</html>