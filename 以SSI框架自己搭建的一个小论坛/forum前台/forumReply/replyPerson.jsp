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
		<title>回复评论</title>
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
	function reply(){
		var a = $("#reply_content").val();
		var b = $("#reply_replyPublicity").val();
		
		if($("#reply_content").val().length ==0){
			alert("评论内容不能为空！");
			return false;
		}
		 $.ajax({
			 url:'forum/forumAction!alreadyReplyPerson.action',
			 data : {
			 	'reply.selfId':'${reply.selfId}',
			 	'reply.infoId':'${reply.infoId}',
			 	'reply.replyPublicity':b,
			 	'reply.replyContent':a
			 },
			 type : 'post',
			 dataType : 'json',
			 success : function(data) {
				 alert("发表成功！");
				 var DGChild = frameElement.lhgDG;
				 var sign = "${sign}";
				 if(sign=="" || sign==null){
					 alert("${reply.infoId}");
					
					 DGChild.curWin.document.forms[0].action="forum/forumAction!detail.action";
				 	  DGChild.curWin.document.forms[0].submit();
				 }else{
					  alert(2);
					  DGChild.curWin.document.forms[0].action="forum/forumAction!moreReply.action?page.pageSize=20&&record.id="+${reply.infoId};
				 	  DGChild.curWin.document.forms[0].submit();
				 }
				 
				
				 DGChild.cancel();
				}
			 
		 });
	 };
	
</script>
<style>
.hiddenClass{
	display:none;
}
</style>
	</head>
	<body>
		<form action="" method="post" id="myform" enctype="multipart/form-data" style="margin-top: -15px;" target="_self">
			<s:hidden name="reply.selfId"/>
			<s:hidden name="reply.infoId"/>
			<s:hidden name="reply.replyPublicity"/>
			
			<table class="input-table" align="center" cellspacing="0" cellpadding="0" style="border:0px solid #fff;">
				<tr>
					<td style="border: 0 dotted #dbdad8;">
						<s:textarea name="reply.content" style="width:105%;height: 74px;resize:none"></s:textarea>
					</td>
				</tr>
				<tr>
			       <td colspan="2" align="center" style="text-align: center;border: 0 dotted #dbdad8;">
			       		<input type="button" id="btnAddRow" class="btn" value="发布评论" onclick="reply();" />
			       </td>
			     </tr>
			</table>
		</form>
	</body>
</html>
