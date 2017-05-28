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
	
	function detail(obj){
				document.forms[0].action="forum/forumAction!relation.action?record.id="+obj;
				document.forms[0].target="_blank";
				document.forms[0].submit();
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
				<tbody>
				<s:iterator value="#request.relations" var="obj" status="status">
					<tr  bgcolor="<s:property value="%{#status.count%2==0?'#F6F6F6':'#ffffff'}"/>">
						<s:if test='#obj.alrealysee!="1"'>
							<s:if test="#obj.extend=='评论'"> 
								<td style="text-align:left;padding-left: 33px;" >
									<img src="images/letter1.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="detail('${publishId}');"><s:property value="#obj.herNickName" />评论了我的帖子(<s:property value="#obj.title" />)</a>
								</td>
							</s:if>
							<s:else>
								<td style="text-align:left;padding-left: 33px;" >
									<img src="images/letter1.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="detail('${publishId}');"><s:property value="#obj.herNickName" />回复了我的评论(<s:property value="#obj.title" />)</a>
								</td>
							</s:else>
						</s:if>
						<s:if test='#obj.alrealysee=="1"'>
							<s:if test="#obj.extend=='评论'"> 
								<td style="text-align:left;padding-left: 33px;" >
									<img src="images/letter2.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="detail('${publishId}');"><s:property value="#obj.herNickName" />评论了我的帖子(<s:property value="#obj.title" />)</a>
								</td>
							</s:if>
							<s:else>
								<td style="text-align:left;padding-left: 33px;" >
									<img src="images/letter2.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="detail('${publishId}');"><s:property value="#obj.herNickName" />回复了我的评论(<s:property value="#obj.title" />)</a>
								</td>
							</s:else>
						</s:if>
						
						<td style="text-align:right;padding-right: 81px;">
							<s:date name="#obj.relationTime" format="yyyy-MM-dd HH:mm"/>
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