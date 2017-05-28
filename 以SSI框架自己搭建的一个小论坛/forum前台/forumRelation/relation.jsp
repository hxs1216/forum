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

		<title>相关信息</title>

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
			function detail(obj){
				document.forms[0].action="forum/forumAction!relation.action?record.id="+obj;
				document.forms[0].target="_blank";
				document.forms[0].submit();
				var dg = frameElement.lhgDG;
				dg.cancel();
			}
	</script>
	</head>

	<body>
	<form action="" name="myform" method="post">
		<s:hidden name="condition"/>
		<table class="mainTbl" align="center" cellpadding="0" cellspacing="0">
			<tr><td>
			<table id='tbmain' class="tbmain" cellpadding="0" cellspacing="1">
				<thead>
					<tr>
						<th style="width: 30px;align:center;" >
							序列
						</th>
						<th style="width: 180px;" align="center" >
							题目
						</th>
						<th style="width: 70px;align:center;" >
							时间
						</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.relations" var="obj" status="status">
					<tr  bgcolor="<s:property value="%{#status.count%2==0?'#F6F6F6':'#ffffff'}"/>">
						<td style="text-align:center;width:74px;">
							<s:property value="#status.count" />
						</td>
						<s:if test="#obj.extend=='评论'"> 
							<td style="text-align:left;" >
								<a href="javascript:void(0);" onclick="detail('${publishId}');"><s:property value="#obj.herNickName" />评论了我的帖子(<s:property value="#obj.title" />)</a>
							</td>
						</s:if>
						<s:else>
							<td style="text-align:left;" >
								<a href="javascript:void(0);" onclick="detail('${publishId}');"><s:property value="#obj.herNickName" />回复了我的评论(<s:property value="#obj.title" />)</a>
							</td>
						</s:else>
						<td style="text-align:center;">
							<s:date name="#obj.relationTime" format="yyyy-MM-dd HH:mm"/>
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
			</td></tr>
		</table>
	</form>
	</body>
</html>
