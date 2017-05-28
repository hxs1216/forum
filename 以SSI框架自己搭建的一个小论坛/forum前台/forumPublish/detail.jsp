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

</style>
<script type="text/javascript">
//显示editor编辑框 

	var editor;
	$(function(){
		
		if($("[name='record.postSort']").val()=="分享生活"){
			$("#sortDetails1").css("display","none");
			$("#sortDetails2").css("display","inline");
		}
		if($("[name='record.postSort']").val()=="分享工作"){
			$("#sortDetails2").css("display","none");
			$("#sortDetails1").css("display","inline");
		}
		if($("[name='record.postSort']").val()==""){
			$("#sortDetails2").css("display","none");
			$("#sortDetails1").css("display","none");
		}
		
		
		//提示信息
		showEditor();
		
		<s:if test="tipMessage=='false'">
			alert("您已点赞！");
		</s:if>
		<s:elseif test="tipMessage=='true'">
			alert("点赞成功！");
		</s:elseif>
		<s:elseif test="tipMessage=='comment'">
			alert("评论成功！");
		</s:elseif>
		
	});
	
	//发表评论
	var reply = function(){
		
		if($.trim($("#replyContent").val())==""){
			alert("请输入评论内容再提交");
			$("#replyContent").focus();
			$("#replyContent").css("border","1px solid red");
			return false;
			}
			
		document.forms[0].action="forum/forumAction!reply.action?isTopic=0";
		document.forms[0].submit();
	}
	
	function showEditor(){
		KindEditor.ready(function(K) {
		editor = K.create('#content', {
			resizeType : 1,//2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动
			width:'90%',
			height:'500',
			allowPreviewEmoticons : false,
			allowImageUpload : true,
			uploadJson : './js/editor/upload_json.jsp',
			fileManagerJson : './js/editor/file_manager_json.jsp',
			allowFileManager : true,
			//获取焦点之后，编辑器的提示信息。
			afterFocus : function() {
				var h = editor.html();
				if(h.indexOf("bodyzhuyaoxinxi")>0) {
					editor.html("");
				}
			},
			//光标离开之后，编辑器显示提示信息。
			afterBlur : function() {
				$("#content").val(editor.html());
			}
		});
	});
	}
	
	//校验
	function formValidate() {
		if($("#record_postSort").val().length == 0) {
			alert("请选择[帖子类别]");
			$("#record_postSort").select();
			$("#record_postSort").css("border","1px solid red");
			return false;
		}
		if($("[name='record.sortDetail']").val().length == 0) {
			alert("请为帖子类别分类");
			$("[name='record.sortDetail']").select();
			$("[name='record.sortDetail']").css("border","1px solid red");
			return false;
		}
		if($("#record_title").val().length == 0) {
			alert("请填写[标题]");
			$("#record_title").select();
			$("#record_title").css("border","1px solid red");
			return false;
		}
		if($("#content").val().length == 0) {
			alert("请填写[内容]");
			$("#record_content").select();
			$("#record_content").css("border","1px solid red");
			return false;
		}
		return true;
	}
	
	//保存操作
	function onSubmit(isValidate){
		$("#content").val($.trim(editor.text())==""?"":editor.html());
		if(isValidate && !formValidate()) {
			return;
		}
		if (!confirm("确认发布吗？")) {
			return;
		}
		document.forms[0].action = "forum/forumAction!publishPost.action";
		document.forms[0].target ="_self";
		document.forms[0].submit();
		$("#goOnBtn").attr("disabled","true");
		$("#saveBtn").attr("disabled","true");
	}
	
	//废弃操作
	function onDestroy(){
		if(confirm("确认删除该帖子吗？")){
			closeWindow();
		}
	}
	
	
	//回复按钮操作
	function replyPerson(obj,id){
		var objAll = "回复"+obj+":";
		showPage("forum/forumAction!replyPerson.action?record.id=${record.id}&id="+id,objAll,600,185);
	}
	
	//预览
	function review(){
			$("#txtComments").val(editor.html());
			document.forms[0].action="forum/forumAction!review.action";
			document.forms[0].target="_blank";
			document.forms[0].submit();
		}
	
	//上传图片
	var imgType="gif,jpg,jpeg,bmp,png,psd";
	function uploadPhono(){
		var fileName=$("#uploadFile").val();
		if(-1==imgType.indexOf(fileName.substring(fileName.lastIndexOf(".")+1))){
			alert("请上传图片类型：gif,jpg,jpeg,bmp,png,psd");
			return ;
		}
		//异步提交文件表单
		$.ajaxFileUpload({
			url :'forum/forumAction!updateImg.action', //需要链接到服务器地址
			secureuri : false,
			fileElementId : 'uploadFile', //文件选择框的id属性
			dataType : 'text', //服务器返回的格式，可以是json
			success : function(data, status) //相当于java中try语句块的用法
			{
				//绑定一个时间的参数，可以解除浏览器的缓存问题
				$("#phonoImg").attr("src","<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>"+data);
				$(":hidden[name='record.picture']").val(data);
			},
			error : function(data, status, e) 
			{
				alert("上传失败");
			}
		});
	}
	
	//删除图片
	function deleteImg(){
		var picture = $(":hidden[name='record.picture']").val();
		if(picture==""){
			alert("请先上传图片！");
		}else{
			if(!confirm("确定删除？")){return false;}
			//异步提交文件表单
			 $.ajax({
				 url:'forum/forumAction!deleteImg.action',
				 data : {
					 'filePath':picture
				 },
				 type : 'post',
				 dataType : 'json',
				 success : function(data) {
						$("#phonoImg").attr("src","");
						$(":hidden[name='record.picture']").val("");
					}
				 
			 });
		}
		
	}
	
	//标题图片的上传
	function itemDetail() {
		var pic = $("#record_picture").val();
		var dd = $("#status").text();
		if(dd.indexOf('未上传')>=0){
			showPage("forum/forumAction!update.action?isTopic=1",'标题图片的上传',450,430);
		}
		if(dd.indexOf('已上传')>=0){
			showPage("forum/forumAction!update.action?isTopic=1&record.picture="+pic,'标题图片的查看',450,430);
		}
		
	}
	
	//回显标题图片
	function showPicture(obj){
		$("#record_picture").val(obj);
		if($("#record_picture").val()!="" || $("#record_picture").val()!=null){
			$("#updatePicture").val("查看");
			$("#status").text("已上传！");
			
		}
	}
	
	function chakan(){
		var pic = $("#record_picture").val();
		showPage("forum/forumAction!update.action?isTopic=0&record.picture="+pic,'标题图片的查看',450,370);
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
	//搜寻帖子
	function search(){
		var condition = $("#uname").val();
		var url = encodeURI(encodeURI("forum/forumAction!search.action?page.pageSize=5&&condition="+condition));
		showPage(url,"搜帖、找人",730,400);
	}
	
	//帖子类别的更改
	function changeSort(obj){
		if($(obj).val()=="分享工作"){
			$("#sortDetails2").css("display","none");
			$("#sortDetails1").css("display","inline");
		}
		if($(obj).val()=="分享生活"){
			$("#sortDetails1").css("display","none");
			$("#sortDetails2").css("display","inline");
		}
		
		if($(obj).val()=="请选择" || $(obj).val()==""){
			
			$("#sortDetails1").css("display","none");
			$("#sortDetails2").css("display","none");
		}
		
		
	}
	
	function details1(){
			var a = $("#sortDetails1").val();
			$("#record_sortDetail").val(a);
	}
	
	function details2(){
			var a = $("#sortDetails2").val();
			$("#record_sortDetail").val(a);
	}
</script>
</head>
<body style="background-color: #fff; font-family: 微软雅黑,宋体,Arial,sans-serif;">
	<form action="" name="form1" method="post" enctype="multipart/form-data" id="mainForm">
		<s:hidden name="record.id"></s:hidden>
		<s:hidden name="record.draftTime"></s:hidden>
		<s:hidden name="record.nickName"></s:hidden>
		<s:hidden name="record.picture"></s:hidden>
		<s:hidden name="record.sortDetail"></s:hidden>
		
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
		
		<table class="maintbl" align="center" cellspacing="0" cellpadding="0" border="0" style="box-shadow: 0 0 0 #c4d1d9;">
			<tr>
				<td class="maintblTd" style="padding: 12px 13px;">
					<s:if test="isTopic==0">
					<table cellspacing="0" cellpadding="0" >
						<tr>
							<td colspan="4">
								<font size="2" style="float:right;margin-top:-35px;padding-left: 734px;">
									浏览数：${record.viewNum}&nbsp;
									回复量：${record.replyNum}&nbsp;
									赞：${record.praiseNum}
									<a  href="forum/forumAction!addPraise.action?record.id=<s:property value='record.id'/>" >
										<img id="img1" style="border: none;margin-top:25px;" alt="" src="<%=basePath%>images/good.png;" >
									</a>
								</font>
							</td>
						</tr>
					</table>
					</s:if>
					<table class="input-table" cellspacing="0" cellpadding="0">
						<tr>
							<th style="width:170px;">拟稿人:</th>
							<td>
								${record.nickName}
							</td>
							<th style="width:160px;">创建时间:</th>
							<td>
								<s:date name="record.draftTime" format="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th style="width:170px;"><em>*</em>帖子类别:</th>
							<s:if test="isTopic!=0">
							<td>
								<s:select list="#{'':'请选择','分享工作':'分享工作','分享生活':'分享生活'}" name="record.postSort" cssStyle="width:130px;" onchange="changeSort(this);"></s:select>
								<s:select list="#{'':'请选择','经验分享':'经验分享','读书心得':'读书心得','工作风采':'工作风采','创新展示':'创新展示','其他':'其他'}" name="sortDetails1" cssStyle="width:130px;display:none;" id="sortDetails1" onchange="details1();"></s:select>
								<s:select list="#{'':'请选择','置换信息':'置换信息','旅游户外':'旅游户外','体育动力':'体育动力','美食交流':'美食交流','文化摄影':'文化摄影','育儿天地':'育儿天地','活动邀约':'活动邀约','闲话杂谈':'闲话杂谈','其他':'其他'}" name="sortDetails2" cssStyle="width:130px;display:none;" id="sortDetails2" onchange="details2();"></s:select>
							</td>
							</s:if>
							<s:elseif test="isTopic==0">
								<td>
								<s:select  list="#{'':'请选择','分享工作':'分享工作','分享生活':'分享生活'}" name="record.postSort"  cssStyle="width:130px;" disabled="true" ></s:select>
								</td>
							</s:elseif>
							<th style="width:160px;">标题图片:</th>
							<s:if test="isTopic!=0">
								<td>
									<input type="button" id="updatePicture" value="上传" class="btn" style="width:70px;height:25px; margin-left: 4px;" onclick="itemDetail();"/>&nbsp;&nbsp;<font color="red" id="status">未上传！<font>
								</td>
							</s:if>
							<s:elseif test="isTopic==0">
								<td>
									<input type="button" id="updatePicture" value="查看" class="btn" style="width:70px;height:25px; margin-left: 4px;" onclick="chakan();"/>&nbsp;&nbsp;<font color="red" id="status"><font>
								</td>
							</s:elseif>
						</tr>
						
						
						<tr>
							<th><em>*</em>标题:</th>
							<s:if test="isTopic!=0">
								<td colspan="6">
									<s:textfield name="record.title" cssClass="long-width" style="width: 671px;" maxLength="29"></s:textfield>
								</td>
							</s:if>
							<s:elseif test="isTopic==0">
								<td colspan="6" style="text-align: center;font-family: 微软雅黑;font-size: 16px;">
									<s:property value="record.title"/>
								</td>
							</s:elseif>
						</tr>
						<tr >
							<th ><em>*</em>内容:</th>
							<s:if test="isTopic!=0">
								<td colspan="6" >
									<s:textarea  id="content" name="content" style="background-color: #F7F7F7; border: 1px solid #999999; overflow: auto;height:248px;" cssClass="long-width" ></s:textarea>
								</td>
							</s:if>
							<s:elseif test="isTopic==0">
								<td colspan="6" style="height: 329px; vertical-align:top;"> 
									<label style="padding-top: 10px;margin-top: 10px;font-family:message-box;"><s:property value="content"  escape="false"/></label>
								</td>
							</s:elseif>
						</tr>
						<table></table>
						<s:if test="isTopic!=0">
						<div class="tab-title tab-normal" style="width: 954px;margin-top: 23px;">附件上传</div>
						<f:file formid="${record.id}" canUpload="true" isdelete="true" 
						showStyle="table" tname="t_forum_will_attach"  />
						</s:if>
						<s:elseif test="isTopic==0">
						<div class="tab-title tab-normal" style="width: 954px;margin-top: 11px;">附件详情</div>
							<f:file formid="${record.id}" canUpload="" isdelete="false" 
							showStyle="table" tname="t_forum_will_attach"  />
						</s:elseif>
						
						<s:if test="isTopic==0">
						<!-- 回复列表 -->
						<table width="100%">					
						<ul style="margin: 0px;padding: 0px;list-style: none;margin-top: 10px;">					
						<s:iterator value="replyList" var="val" status="st">
						<li style="height: 82px;margin-bottom: 5px;" id="reply_${val.id}">
							<s:if test="#val.selfId==null">
							<div style="text-align: left; position: relative;top: 0px;line-height: 18px;">		
								<s:textarea value="%{#val.replyContent}" style="width:100%;resize:none;height:50px;font-family: 宋体,Arial,sans-serif;font-size: 14px;color: #656565;"  readonly="true"></s:textarea>
							</div>
							</s:if>
							<s:else>
							<div style="text-align: right; position: relative;top: 0px;line-height: 18px;">		
								<s:textarea value="%{#val.replyContent}" style="width:90%;resize:none;background-color: #dcdcdc;border:0;height:50px;font-family: 宋体,Arial,sans-serif;font-size: 14px;color: #656565;"  readonly="true"></s:textarea>
							</div>
							</s:else>
							<div style="height: 20px; width:100%;text-align: right;">						
								<font size="2">
										
										<s:if test="#val.selfId==null">
											<font><s:property value="#val.nickName"/>&nbsp;</font>
											<label style="font-family:message-box;">时间：</label>
											<s:date name="#val.replyTime" format="yyyy-MM-dd HH:mm"/>&nbsp;
									 		<input type="button" value="回复" style="width:45px;height: 21px;font-family: unset;margin-left: 12px;margin-right:15px;float:right;" onclick="replyPerson('${val.nickName}','${val.id}');"></input>
										</s:if>
										<s:elseif test="#val.selfId!=null">
											<font color="red"><s:property value="#val.nickName"/></font>回复&nbsp;
											<label style="font-family:message-box;">时间：</label>
											<s:date name="#val.replyTime" format="yyyy-MM-dd HH:mm"/>&nbsp;
										</s:elseif>
								</font>
							</div>
						</li>							
						</s:iterator>
						</ul>						
						</table>
						<div style="margin-top:12px;">
							<textarea id="replyContent" name="reply.replyContent" style="height: 57px;width: 100%;resize:none;border-color:#6495ED;" ></textarea>
						</div>
						<br>
						<div  align="center">
							<input type="button" value="发评论 " onclick="reply()"/>
							<s:if test="flag=='true'||#session.currentUser.isSuperUser||#session.currentUser.isSysManager">
								<input type="button" value="编辑 " onclick="window.open('forum/forumAction!detailManage.action?record.id=${record.id}')"/>
							</s:if>
						</div>
						</s:if>	
							
						<s:if test="isTopic!=0">
						<div style="padding-bottom: 20px;padding-top: 20px;text-align: center;" align="center">
							<input type="button" value="发布" style="width:90px;margin-right:-6px;" id="goOnBtn" class="btn" onclick="onSubmit(true);"/>
							<input type="button" value="预 览" style="width:90px;margin-right:-6px;" onclick="review();" class="btn"/>
							<input type="button" value="删除" style="width:90px;" id="saveBtn" class="btn" onclick="onDestroy();"/>
						</div>
						</s:if>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>