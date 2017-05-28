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

<title>个人信息</title>
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

.input-table tr th {
	width: 0px;
	height : 35px;
	min-height: 35px;
	font-weight:bold;
	line-height: 1.4285;
	vertical-align: middle;
	text-align: right;
	border: 0 solid #e1e1e1;
	padding-right: 5px;
	background-color: #F6F6F6;
}
</style>
<script type="text/javascript">
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
		<s:hidden name="person.id"/>
		<s:hidden name="personId"/>	
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
					<td id="live" style="width:100px;"  onmouseover="$(this).css('background-color','#3fb0f1');" onmouseout="$(this).css('background-color','rgb(47,97,156)');" onclick="window.location.href='<%=basePath %>forum/forumAction!personPage.action'">个人信息</td>
					<td  style="text-align: right;margin-right: 12px;"><input type="text" name="xiao" style="display: none;"> <input type="text" id="uname" name="condition" style="height:20px;width:238px;vertical-align:middle;margin-right: 12px;" placeholder="搜帖、找人" onkeypress="EnterPress(event)" /><img src="images/sousou.png" style="position: relative;vertical-align:middle;right: 34px;vertical-align:middle;" onclick="search();"></td>
				</tr>
			</table>
		</div>
		
		<table class="maintbl" align="center" cellspacing="0" cellpadding="0" border="0" style="box-shadow: 0 0 0 #c4d1d9;">
			<tr>
				<td class="maintblTd" style="padding: 12px 13px;">
					<table class="input-table" cellspacing="0" cellpadding="0" style="border: 0 solid #bfbfbf;">
						<tr style="width:36px;">
							<th style="background-color: rgb(225,225,225);text-align: center;font-family: 微软雅黑,楷体,Arial,sans-serif;font-size: 16px;font-weight: normal;">个人资料</th>
							<th style="text-align: left;font-family: 微软雅黑,楷体,Arial,sans-serif;font-size: 16px;font-weight: normal;padding-left: 32px;"><img src="images/news.png" style="vertical-align: middle;">&nbsp;&nbsp;我的消息</th>
							<th colspan="3"><a href="javascript:void();" style="font-size:13px;font-family: 微软雅黑,宋体,Arial,sans-serif;font-weight: normal;padding-right: 38px;color:#0084ce;"  >>>&nbsp;MORE</a></th>
						</tr>
						<tr>
							<th style="border-bottom: height: 200px;1px solid #DCDCDC;text-align: center;align:center;vertical-align: top;" >
								<s:if test="person.picture==null">
									<span onmouseover="this.style.color='red';"  onmouseout="this.style.color='#6b6b6b';">
										<img src="images/forum-default.png" style=" padding: 3px; width: 92px;height:92px;text-align: center;border:1px solid #DCDCDC;margin-top: 20px;-webkit-border-radius: 50em;-ms-border-radius: 50em;-moz-border-radius: 50em;-moz-border-radius: 50em;border-radius: 50em;" />
									</span>
								</s:if>
								<s:else>
									<span onmouseover="this.style.color='red';"  onmouseout="this.style.color='#6b6b6b';">
										<img src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${person.picture}"  style=" padding: 3px; width: 92px;height:92px;text-align: center;border:1px solid #DCDCDC;margin-top: 20px;-webkit-border-radius: 50em;-ms-border-radius: 50em;-moz-border-radius: 50em;-moz-border-radius: 50em;border-radius: 50em;" />
									</span>
								</s:else>
								<br/>
									<span >
										<font style="font-weight: bold;font-size: 12px;font-weight: normal;">${person.nickName}</font>
									</span>
								<br/>
									<span>
										<font style="font-weight: bold;font-size: 11px;font-weight: normal;">${person.userName}</font>
									</span>
								<br/>
									<input style="border: 0 none;margin-top: 11px;border-radius: 4px;color: #ffffff;height: 26px; margin-bottom: 15px;width: 103px;background-color:#3fb0f1;" type="button" value="我要发帖" id="paster">
								<br/>
							</th>
							<td colspan="4"  style="vertical-align:top;">
								<ul style="margin-top:2px;margin-bottom:2px;padding-left:27px;margin-left:0px;">
								<s:iterator value="#request.relations" id="iter1"  var="obj" status="status" begin="0" end="#request.relations.size()>=6?5:#request.relations.size()-1">
								<div style="border-bottom: 1px dashed #7FFFD4;" >
								<font style="text-align:right;float: right;font-size:14px;">
									<s:date name="#obj.relationTime" format="yyyy-MM-dd HH:mm"/>
								</font>
								<li style="list-style-type:none;">
								<font style="font-size:14px;" color="black">
								<s:if test='#obj.alrealysee!="1"'>
									<s:if test="#obj.extend=='评论'"> 
											<span ><img src="images/letter1.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<span style="color:black;"><s:property value="#obj.herNickName" />评论了我的帖子(<s:if test="#obj.sortDetail!='' && #obj.sortDetail!=null">[<s:property value="#obj.sortDetail" />]<s:property value="#obj.title" /></s:if><s:else><s:property value="#obj.title" /></s:else>)</span></span>
									</s:if>
									<s:else>
											<span><img src="images/letter1.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<span style="color:black;"><s:property value="#obj.herNickName" />回复了我的评论(<s:if test="#obj.sortDetail!='' && #obj.sortDetail!=null">[<s:property value="#obj.sortDetail" />]<s:property value="#obj.title" /></s:if><s:else><s:property value="#obj.title" /></s:else>)</span></span>
									</s:else>
								</s:if>
								<s:if test='#obj.alrealysee=="1"'>
									<s:if test="#obj.extend=='评论'"> 
											<span><img src="images/letter2.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<span style="color:black;"><s:property value="#obj.herNickName" />评论了我的帖子(<s:if test="#obj.sortDetail!='' && #obj.sortDetail!=null">[<s:property value="#obj.sortDetail" />]<s:property value="#obj.title" /></s:if><s:else><s:property value="#obj.title" /></s:else>)</span></span>
									</s:if>
									<s:else>
											<span><img src="images/letter2.png" style="vertical-align: middle;"/>&nbsp;&nbsp;<span style="color:black;"><s:property value="#obj.herNickName" />回复了我的评论(<s:if test="#obj.sortDetail!='' && #obj.sortDetail!=null">[<s:property value="#obj.sortDetail" />]<s:property value="#obj.title" /></s:if><s:else><s:property value="#obj.title" /></s:else>)</span></span>
									</s:else>
								</s:if>
								</font>	
								</li>
								</div>
								</s:iterator>
								</ul>
							</td>
						</tr>
						<tr>
							<th style="background-color: rgb(225,225,225);text-align: center;font-family: 微软雅黑,楷体,Arial,sans-serif;font-size: 16px;font-weight: normal;">统计信息</th>
							<th style="text-align: left;font-family: 微软雅黑,楷体,Arial,sans-serif;font-size: 16px;font-weight: normal;padding-left: 32px;"><img src="images/post.png" style="vertical-align: middle;">&nbsp;&nbsp;我的帖子</th>
							<th colspan="3"><a href="javascript:void();" style="font-size:13px;font-family: 微软雅黑,宋体,Arial,sans-serif;font-weight: normal;color:#0084ce;padding-right: 38px;"  >>>&nbsp;MORE</a></th>
						</tr>
						<tr>
							<th style="height: 259px;width: 115px;padding-left: 40px;border-bottom: 1px solid #DCDCDC;line-height: 33px;text-align: left;align:center;vertical-align: top;padding-top: 20px;" >
							<font style="font-weight:normal;">我的发帖：<s:property value="person.myComment"/></font>
							<br>
							<font style="font-weight:normal;">已读消息：<s:property value="person.myPost"/></font>
							<br>
							<font style="font-weight:normal;">未读消息：<font style="color:#FF0000"><s:property value="person.extend1"/></font></font>
							</th>
						<td colspan="4" style="vertical-align:top;">
							<ul>
							<s:iterator value="#request.resultList" id="iter1"  var="obj" status="status" begin="0" end="#request.resultList.size()>=6?5:#request.resultList.size()-1">
							<div style="border-bottom: 1px dashed #7FFFD4;margin-left: -15px;" >
							<font style="text-align:right;float: right;font-size:14px;">
								<s:date name="#obj.draftTime" format="yyyy-MM-dd HH:mm"/>
							</font>
							<li style="list-style-type:none;">
							<font style="font-size:14px;" color="black">
								<span ><s:property value="#status.count"/>&nbsp;&nbsp;<span  style="color: black;"><s:if test="#obj.sortDetail!='' && #obj.sortDetail!=null">[${obj.sortDetail}]${obj.title}</s:if><s:else>${obj.title}</s:else></span></span>
							</font>	
							</li>
							</div>
							</s:iterator>
							</ul>
						</td>
						</tr>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>