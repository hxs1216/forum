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
		
	document.forms[0].action="forum/forumAction!pageReply.action";
	document.forms[0].submit();
}

//点赞功能
function addPraise(){
	$.ajax( {  
	    url:'forum/forumAction!addPraise.action',// 跳转到 action  
	    data:{  
	             "record.id" : "${record.id}" 
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',  
	    success:function(data) {  	
			 if(data.solution=="true"){
	    		$("#praiseNUM").text(data.praiseNum);
	    		$("#praise").attr("src","images/praise2.png");
	    		alert("点赞成功！");
	    		
	    	}else{
	    		alert("您已点赞！");
	    	}
		     }
	});
}

//回复按钮操作
	function replyPerson(obj,id,build){
		var objAll = "回复"+obj+":";
		showPage("forum/forumAction!replyPerson.action?record.id=${record.id}&sign=1&bu="+build+"&id="+id,objAll,600,185);
	}
	

//标题图片的查看
function chakan(){
		var pic = $("#record_picture").val();
		showPage("forum/forumAction!update.action?isTopic=0&record.picture="+pic,'背景图片的查看',450,370);
	}


//屏蔽功能
	function shield(obj){
		var name = "";
		var shield ="#shield_"+obj;
		var shieldContent = $(shield).text();
		if(shieldContent.indexOf("解除")!=-1){
			name="jiechu";
		}else{
			name="pingbi";
		}
		
		$.ajax( {  
			    url:'forum/forumAction!shield.action', 
			    data:{  
			             "id" : obj ,
			             "name":name
			    },  
			    type:'post',  
			    cache:false,  
			    dataType:'text',  
			    success:function(data) {
			    	var name ="#content_"+obj;
			    	if(data=="pingbi"){
				    	$(name).text("内容已被屏蔽");
				    	$(name).css("border-bottom","1px dashed red");
				    	$(shield).text("解除");
			    	}else{
			    		$(name).text(data);
			    		$(name).css("border-bottom","none");
			    		$(shield).text("屏蔽");
			    	}
			     } 
			});
	}
</script>
</head>
<body style="background-color: #fff;font-family: 微软雅黑,宋体,Arial,sans-serif;font-size: 14px;font-style: normal;font-weight: normal;color: #000000;">
	<form action="" name="form1" method="post" enctype="multipart/form-data" id="mainForm">
		<s:hidden name="record.id"></s:hidden>
		<s:hidden name="record.draftTime"></s:hidden>
		<s:hidden name="record.nickName"></s:hidden>
		<s:hidden name="record.picture"></s:hidden>
		<s:hidden name="attachName"></s:hidden>
		<iframe src="<%=basePath%>forum/forumAction!subModuleTop.action" 
		style="padding: 0px; border-bottom-color: #008B8B" frameborder="0" width="100%" height="107px" scrolling="no" >
     	</iframe>
     	<hr color="#008B8B" width="1000px" style="margin-top: -3px;"/>
		
		<table class="maintbl" align="center" cellspacing="0" cellpadding="0" border="0" style="box-shadow: 0 0 0 #c4d1d9;">
			<tr>
				<td class="maintblTd" style="padding: 12px 13px;">
					<table class="input-table" cellspacing="0" cellpadding="0" style="border: 0 solid #bfbfbf;">
<%--	回复列表--%>
						<s:iterator value="replyList" status="st" >
						<tr>
							<th rowspan="2" colspan="1"  style="padding-bottom: 12px;border-bottom: 1px solid #DCDCDC;text-align: center;align:center;vertical-align: top;" >
								<s:if test="flag=='true'||#session.currentUser.isSuperUser||#session.currentUser.isSysManager">
								<s:if test='extend1!=null && extend1!=""'>
								<span onclick="personDetail('${replyId}');">
								<img src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${extend1}"  style="cursor: pointer; margin-top: 19px;padding: 3px;width:92px;height:115px;text-align: center;border:1px solid #DCDCDC;margin-left: 10px; " />
								</span>
								</s:if>
								<s:else>
								<span onclick="personDetail('${replyId}');">
								<img src="images/forum-default.png"  style="cursor: pointer; margin-top: 19px;padding: 3px;width:92px;height:115px;text-align: center;border:1px solid #DCDCDC;margin-left: 10px; " />
								</span>
								</s:else>
								<br>
								<span onclick="personDetail('${replyId}');" onmouseover="$(this).find('#nickhaha').attr('color','red');" onmouseout="$(this).find('#nickhaha').attr('color','black');">
								<font id="nickhaha"  style="font-size: 12px;font-weight: normal;cursor: pointer;" >${nickName}</font>
								</span>
								<br>
								<label style="height:10px;"></label>
								</s:if>
								<s:else>
								<s:if test='extend1!=null && extend1!=""'>
								<span>
								<img src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${extend1}"  style="margin-top: 19px;padding: 3px;width:92px;height:115px;text-align: center;border:1px solid #DCDCDC;margin-left: 10px; " />
								</span>
								</s:if>
								<s:else>
								<span>
								<img src="images/forum-default.png"  style="margin-top: 19px;padding: 3px;width:92px;height:115px;text-align: center;border:1px solid #DCDCDC;margin-left: 10px; " />
								</span>
								</s:else>
								<br>
								<span >
								<font id="nickhaha"  style="font-size: 12px;font-weight: normal;" >${nickName}</font>
								</span>
								<br>
								<label style="height:10px;"></label>
								
								</s:else>
							</th>
							<td colspan="4" style="padding-left: 56px; vertical-align: top;padding-top: 12px;"><s:if test='replyPublicity!=0 && replyPublicity!=null && replyPublicity!=""'><font color="red">回复${replyPublicity}楼：</font><s:if test="shieldStatus==1"><font id="content_${id}" style="border-bottom:1px dashed red;">内容已被屏蔽</font></s:if><s:else><font id="content_${id}">${replyContent}</font></s:else></s:if><s:else><s:if test="shieldStatus==1"><font id="content_${id}" style="border-bottom:1px dashed red;">内容已被屏蔽</font></s:if><s:else><font id="content_${id}">${replyContent}</font></s:else></s:else></td>	
						</tr>
						
						<tr style="border-bottom: 1px solid #DCDCDC;border-top: 1px dashed #7fffd4;height:10px;">
							<td style="border-bottom: 1px solid #DCDCDC;"></td>
							<td style="border-bottom: 1px solid #DCDCDC;" colspan="3" ><div style="float:right;">${st.count+(currentPage-1)*page.pageSize}楼 &nbsp;&nbsp;评论时间：<s:date name="replyTime" format="yyyy-MM-dd HH:mm"/>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="replyPerson('${nickName}','${id}','${st.count+(currentPage-1)*page.pageSize}');">回复</a><s:if test="#session.currentUser.isSuperUser||#session.currentUser.isSysManager"><s:if test="shieldStatus==1">&nbsp;&nbsp;<a href="javascript:void(0);" onclick="shield('${id}');" id="shield_${id}"/>解除</a></s:if><s:else>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="shield('${id}');" id="shield_${id}"/>屏蔽</a></s:else></s:if></div></td>
						</tr>
						
						</s:iterator>
						<tr style="border-bottom: 1px solid #DCDCDC;border-top: 1px dashed #7fffd4;height:10px;background-color: #DCDCDC;">
							<td style="border-bottom: 1px solid #DCDCDC;background-color: #D3D3D3;text-align: center;" colspan="6">
								<jsp:include page="/forum/forumPublish/page.jsp"></jsp:include>
							</td>
						</tr>
					</table>
					<div style="background-color:#F5F5F5;">
						<div style=" padding-top: 23px;padding-left: 62px;"><img src="images/icon1.png"/>&nbsp;&nbsp;<font style="font-family: 微软雅黑,宋体,Arial,sans-serif;font-size: 17px;font-style: normal;font-weight: normal;">发表评论</font></div>
						<div><textarea id="replyContent" name="reply.replyContent" style="height: 152px;margin-left: 61px; margin-top: 15px; resize: none;width: 90%;font-size: 14px;font-style: normal; font-family: 微软雅黑,宋体,Arial,sans-serif;" ></textarea></div>
						<div>
							<input type="button" value="发表" onclick="reply()" class="btn"  style="background-color: #3fb0f1;border: 0 none;border-radius: 4px;color: #ffffff; margin-bottom: 10px;margin-left: 60px;margin-top: 12px;width: 59px;"/>
						</div>
					
					</div>
					
				</td>
			</tr>
		</table>
	</form>
</body>
</html>