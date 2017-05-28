<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="uc" uri="myControl.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>" />

		<title>搜帖、找人</title>

		<meta http-equiv="pragma" content="no-cache" />
		<!--是用于设定禁止浏览器从本地机的缓存中调阅页面内容，设定后一旦离开网页就无法从Cache中再调出-->
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<!--可以用于设定网页的到期时间，一旦过期则必须到服务器上重新调用。需要注意的是必须使用GMT时间格式-->
		<meta http-equiv="keywords" content="" />
		<!--向搜索引擎说明你的网页的关键词-->
		<meta http-equiv="description" content="" />
		<!--告诉搜索引擎你的站点的主要内容-->

		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/listPageStyle.css" media="all" />
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	
	</script>
	</head>

	<body>
	<form action="forum/forumAction!search.action" name="myform" method="post">
		<s:hidden name="condition"/>
		<table class="mainTbl" align="center" cellpadding="0" cellspacing="0">
			<tr><td>
			<table id='tbmain' class="tbmain" cellpadding="0" cellspacing="1">
				<thead>
					<tr>
						<th style="width: 30px;align:center;" >
							编号
						</th>
						<th style="width: 180px;" align="center" >
							标题
						</th>
						<th style="width: 70px;align:center;" >
							拟稿人
						</th>
						<th style="width: 120px;align:center;">
							拟稿时间
						</th>
						<th style="width: 70px;align:center;">
							帖子类别
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
						<td>
							<s:property value="#obj.nickName" />
						</td>
						<td style="text-align:center;">
							<s:date name="#obj.draftTime" format="yyyy-MM-dd HH:mm"/>
						</td>
						<td style="text-align:center;">
							<s:property value="#obj.postSort" />
						</td>
						</tr>
				</s:iterator>
				</tbody>
			</table>
			<!-- 分页插件，共用Jsp页面 -->
			<jsp:include page="/common/page.jsp"></jsp:include>
			</td></tr>
		</table>
	</form>
	</body>
</html>
