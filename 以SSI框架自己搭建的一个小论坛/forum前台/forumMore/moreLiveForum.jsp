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
    <title>分享生活查询</title>
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

	//发帖
	function publish(){
		document.forms[0].action="forum/forumAction!draftLive.action";
		document.forms[0].target='_self';
		document.forms[0].submit();
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
</script>
  </head>
  
	<body>
		<iframe src="<%=basePath%>forum/forumAction!subModuleTop.action" 
		style="padding: 0px; border-bottom-color: #008B8B" frameborder="0" width="100%" height="107px" scrolling="no" >
     	</iframe>
     	<hr color="#dcdcdc" width="1000px" style="margin-top: -3px;"/>
     	
     	<%-- 导航条--%>
     	<div style="margin-top: 0px;">
			<table width="1000"  align="center" cellpadding="0" cellspacing="0" border="0">
				<tr style="background-color: rgb(47,97,156); height: 40px;color: #ffffff;text-align: center;font-size: 15px;">
					<td id="index" style="width:100px;"  onmouseover="$(this).css('background-color','#3fb0f1');$('#live').css('background-color','rgb(47,97,156)');" onmouseout="$(this).css('background-color','rgb(47,97,156)');$('#live').css('background-color','#3fb0f1');" onclick="window.location.href='<%=basePath %>forum/forumAction!home.action'">首页</td>
					<td id="job" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');$('#live').css('background-color','rgb(47,97,156)');" onmouseout="$(this).css('background-color','rgb(47,97,156)');$('#live').css('background-color','#3fb0f1');" onclick="window.location.href='<%=basePath %>forum/forumAction!jobItems.action'">分享工作</td>
					<td id="live" style="width:100px;background-color:#3fb0f1;" onmouseout="$(this).css('background-color','#3fb0f1'); ">分享生活</td>
					<td id="live" style="width:100px;" onmouseover="$(this).css('background-color','#3fb0f1');$('#live').css('background-color','rgb(47,97,156)');" onmouseout="$(this).css('background-color','rgb(47,97,156)');$('#live').css('background-color','#3fb0f1');" onclick="window.location.href='<%=basePath %>forum/forumAction!personPage.action'">个人信息</td>
					<td  style="text-align: right;margin-right: 12px;"><input type="text" name="xiao" style="display: none;"> <input type="text" id="uname" name="condition" style="height:20px;width:238px;vertical-align:middle;margin-right: 12px;" placeholder="搜帖、找人" onkeypress="EnterPress(event)" /><img src="images/sousou.png" style="position: relative;vertical-align:middle;right: 34px;vertical-align:middle;" onclick="search();"></td>
				</tr>
			</table>
		</div>
     	<!-- body -->
		<form action="forum/forumAction!liveItems.action"  method="post">
		<div style="width: 1000px;margin: 0 auto;padding-top: 5px;">
			<div style="border: 1px solid #ace;padding-top: 5px;font-size: 14px;padding-left: 20px;padding-right: 20px;">
				<table width="100%" cellpadding="0" cellspacing="0" style="">
					<tr style="min-height: 36px;">
						<th style="width: 120px;text-align: right;padding-right: 10px;border-bottom:1px dashed #dedede;color:#636363;font-family: 微软雅黑;">标题/拟稿人：</th>
						<td style="border-bottom:1px dashed #dedede;width:250px;">
						<div style="height:36px;line-height: 36px;">
							<s:textfield name="title" cssStyle="width:220px;"></s:textfield>
						</div>	
						</td>
						<th style="width: 140px;border-bottom:1px dashed #dedede;color:#636363;font-family: 微软雅黑;text-align:right">创建时间：</th>
						<td style="border-bottom:1px dashed #dedede;width: %;">
							<input id="bdate" type="text" readonly="readonly" value="${begintime}" 
								onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'edate\')}',dateFmt:'yyyy-MM-dd'})" 
								name="begintime" class="Wdate short-width" style="width:45%"/>&nbsp;&nbsp;至&nbsp;&nbsp;
							<input id="edate" type="text" readonly="readonly" value="${endtime}"
								onfocus="WdatePicker({minDate:'#F{$dp.$D(\'bdate\')}',dateFmt:'yyyy-MM-dd'})"
								name="endtime" class="Wdate short-width" style="width:45%" />
								
						</td>
					</tr>
					<tr >
						<th style="width: 90px;text-align: right;padding-right: 10px;border-bottom:1px dashed #dedede;color:#636363;font-family: 微软雅黑;">
							排序：
						</th>
						<td>
							<s:select list="#{'':'请选择','评论时间':'评论时间','发帖时间':'发帖时间','回复数':'回复数','浏览量':'浏览量'}"   name="orderLive"  cssStyle="width: 223px;" ></s:select>	
						</td>
						<th></th>
						<td colspan="3" style="padding-top: 6px;padding-bottom: 6px;text-align:right;">
						<input type="submit" value="查询" class="btn"  style="margin-right: 10px;"/>
						<input type="button" value="发帖" class="btn" onclick="publish();" style="margin-right: 10px;"/>
						
						</td>
					</tr>
				</table>
			</div>
			
			<table id='tbmain' class="tbmain" cellpadding="0" cellspacing="0" style="margin-top: 15px;border: 1px solid #ace;">
				<thead>
					<tr>
						<th style="width: 350px;" align="center" >
							标题
						</th>
						<th style="width: 56px;align:center;" >
							作者/拟稿时间
						</th>
						<th style="width: 34px;align:center;">
							回复/查看
						</th>
						<th style="width: 56px;align:center;">
							最后发表
						</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.forumLives" var="obj" status="status">
					<tr  bgcolor="<s:property value="%{#status.count%2==0?'#F6F6F6':'#ffffff'}"/>">
						<td title="${obj.title}" style="line-height: 1.6;">
							<a href="forum/forumAction!detail.action?record.id=${id}&isTopic=0" target="_blank"><s:if test="#obj.sortDetail=='' || #obj.sortDetail==null" >${obj.title}</s:if><s:else>[<s:property value="#obj.sortDetail"/>]<s:property value="#obj.title"/></s:else></a>
						</td>
						<td style="line-height: 1.6;color:#999999;">
							<s:property value="#obj.nickName" />
							<br/>
							<s:date name="#obj.draftTime" format="yyyy-MM-dd HH:mm"/>
						</td>
						<td style="text-align:center;line-height: 1.6;color:#999999;">
							<s:property value="#obj.replyNum" />
							<br/>
							<s:property value="#obj.viewNum" />
						</td>
						<td style="line-height: 1.6;color:#999999;">
							<s:if test='#obj.nickName1!=null && #obj.nickName1!=""'>
							
							<s:property value="#obj.nickName1" />
							<br/>
							<s:date name="#obj.replyTime" format="yyyy-MM-dd HH:mm"/>
							
							</s:if>
							<s:else>
							<s:property value="#obj.nickName" />
							<br/>
							<s:date name="#obj.draftTime" format="yyyy-MM-dd HH:mm"/>
							
							</s:else>
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