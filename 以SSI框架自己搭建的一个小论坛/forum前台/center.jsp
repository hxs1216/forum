<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.nuchina.common.util.SysConfigUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <!-- 
	要为网页指定文本模式，请使用 META 元素，以在该网页中包含 X-UA-Compatible http-equiv 标头。以下示例指定了 EmulateIE7 模式兼容性。
	 -->
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>首页的左侧部门</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/listPageStyle.css" media="all" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
	
<style type="text/css">

a:link {
	text-decoration: none;
	color:#000000;
}
a:hover {
	text-decoration: underline;
	color:#000000;
}
*{
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
	font-size: 15px;
<%--	padding:0px;--%>
}
.amain tr td{
	    line-height: 1.6;
}
.z-div{
	font-size: 13px;
	font-family: 微软雅黑, 宋体, Arial, sans-serif;
}
.z-div table td{
	border-bottom:1px #ccc dashed; 
}
</style>
<script type="text/javascript">
$(function(){
	var h1 = document.body.scrollHeight;
		window.frameElement.style.height = h1+"px";
	
	
});

</script>
  </head>
  
  <body style="font-family: 微软雅黑, 宋体, Arial, sans-serif;margin: 0px;padding: 0px;height: 723px;">
	<table id='tbmain' class="amain tbmain" cellpadding="0" cellspacing="0" style="margin-top: 10px;border: 1px solid #ace;">
			<thead>
				<tr>
					<th style="width: 350px;text-align:left;font-weight: bold;font-size: 15px;" >
						工作学习区<a href="javascript:void();" style="cursor: pointer;color:#0084ce;font-size:8px;" onclick="window.open('forum/forumAction!jobItems.action')" >>>&nbsp;MORE</a>
					</th>
					<th style="width: 90px;align:center;" >
						作者/拟稿时间
					</th>
					<th style="width: 65px;align:center;">
						回复/查看
					</th>
					<th style="width: 65px;align:center;">
						最后发表
					</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="#request.forumJobs" var="obj" begin="0" end="5"  status="status">
				<tr  bgcolor="<s:property value="%{#status.count%2==0?'#F6F6F6':'#ffffff'}"/>">
					<td title="${obj.title}" style="line-height: 1.6;">
							<s:if test="isStick==1">
		    						<img id="img1" style="border: none;" alt="" src="<%=basePath%>images/ding.gif;" >
		    				</s:if>
							<s:if test='bestTopic=="是"'>
		    						<img id="img2" style="border: none;" alt="" src="<%=basePath%>images/good.gif;" >
		    				</s:if>
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
	<table id='tbmain' class="amain tbmain" cellpadding="0" cellspacing="0" style="margin-top: 15px;margin-bottom: 15px;border: 1px solid #ace;">
			<thead>
				<tr>
					<th style="width: 350px;text-align:left;font-weight: bold;" >
						生活娱乐区<a href="javascript:void();" style="cursor: pointer;color:#0084ce;font-size:8px;" onclick="window.open('forum/forumAction!liveItems.action')" >>>&nbsp;MORE</a>
					</th>
					<th style="width: 90px;align:center;" >
						作者/拟稿时间
					</th>
					<th style="width: 65px;align:center;">
						回复/查看
					</th>
					<th style="width: 65px;align:center;">
						最后发表
					</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="#request.forumlives" var="obj" begin="0" end="5"  status="status">
				<tr  bgcolor="<s:property value="%{#status.count%2==0?'#F6F6F6':'#ffffff'}"/>">
					<td title="${obj.title}" style="line-height: 1.6;">
							<s:if test="isStick==1">
		    						<img id="img1" style="border: none;" alt="" src="<%=basePath%>images/ding.gif;" >
		    				</s:if>
							<s:if test='bestTopic=="是"'>
		    						<img id="img2" style="border: none;" alt="" src="<%=basePath%>images/good.gif;" >
		    				</s:if>
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
<!-- 
	<div style="margin-top:10px;">
	
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="height:245px;font-size: 14px;"><tr>
	<tr>
		<td width="50%" style="border-right: 1px solid rgb(237,237,237);" valign="top" align="left">
				<font style="color:#0084ce;font-size:18px;height:36px;margin-top:5px;margin-left: 12px;line-height: 30px;font-weight: bold;">分享工作</font>
				<a href="javascript:void();" style="cursor: pointer;color:#0084ce;font-size:13px;margin-left: 338px;" onclick="window.open('forum/forumAction!jobItems.action')" >>>&nbsp;MORE</a>
				<ul id="consultation" style="margin-top: 5px;">
				<div id="hhh">
					<s:iterator value="#request.forumJobs" begin="0" end="forumJobs.size()>=13?12:forumJobs.size()-1" id="iter1">
					<div onmouseover="$(this).css('border','0px solid #F5F5F5').css('background-color','#F0F8FF');$(this).find('li').css('border','0px solid #F5F5F5').css('background-color','#F0F8FF');" onmouseout="$(this).css('border','none').css('background-color','#fff');$(this).find('li').css('border','none').css('background-color','#fff');">
					<font style="float:right;color:#405d6d;height:34px;line-height:34px;margin-right: 10px;" ><s:property value="nickName"/></font>
					<li style="height:34px;line-height:34px;margin-left: -25px;font-size:15px;cursor: pointer;list-style-position: inside;color:#333;width:270px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;-o-text-overflow: ellipsis;"
							onclick="window.open('forum/forumAction!detail.action?record.id=${id}&isTopic=0')" >
							<s:if test="isStick==1">
		    						<img id="img1" style="border: none;" alt="" src="<%=basePath%>images/ding.gif;" >
		    				</s:if>
							<s:if test='bestTopic=="是"'>
		    						<img id="img2" style="border: none;" alt="" src="<%=basePath%>images/good.gif;" >
		    				</s:if>
							<font  title="<s:property value='title'/>" color='<s:if test="color=='红色'">#CD2626</s:if><s:elseif test="color==''||color=='默认'">black</s:elseif><s:elseif test="color=='蓝色'">#1874CD</s:elseif>'>
							<s:if test="sortDetail=='' || sortDetail==null" >
								<s:property value="title"/>
							</s:if>
							<s:else>
								[<s:property value="sortDetail"/>]<s:property value="title"/>
							</s:else>
							</font>
						</li>
						</div>
					</s:iterator>
					</div>
				</ul>
		</td>

		<td valign="top" align="left">
				<font style="color:#0084ce;font-size:18px;height:36px;margin-top:5px;margin-left: 12px;line-height: 30px;font-weight: bold;">分享生活</font>
				<a href="javascript:void();" style="cursor: pointer;color:#0084ce;font-size:13px;margin-left:337px;" onclick="window.open('forum/forumAction!liveItems.action')" >>>&nbsp;MORE</a>
				<div style="margin-right: 15px;" >
					<ul id="live" style="margin-top: 5px;">
						<s:iterator value="#request.forumlives" begin="0" end="forumLives.size()>=13?12:forumLives.size()-1">
						<div onmouseover="$(this).css('border','0px solid #F5F5F5').css('background-color','#F0F8FF');$(this).find('li').css('border','0px solid #F5F5F5').css('background-color','#F0F8FF');" onmouseout="$(this).css('border','none').css('background-color','#fff');$(this).find('li').css('border','none').css('background-color','#fff');">
						<font style="float:right;color:#405d6d;height:34px;line-height:34px;margin-right: 2px;"><s:property value="nickName"/></font>
						<li style="height:34px;line-height:34px;margin-left: -25px;font-size:15px;cursor: pointer;list-style-position: inside;color:#333;width:270px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;-o-text-overflow: ellipsis;" 
							onclick="window.open('forum/forumAction!detail.action?record.id=${id}&isTopic=0')" >
							<s:if test="isStick==1">
		    						<img id="img1" style="border: none;" alt="" src="<%=basePath%>images/ding.gif;" >
		    				</s:if>
		    				<s:if test='bestTopic=="是"'>
		    						<img id="img2" style="border: none;" alt="" src="<%=basePath%>images/good.gif;" >
		    				</s:if>
							<font  title="<s:property value='title'/>" color='<s:if test="color=='红色'">#CD2626</s:if><s:elseif test="color==''||color=='默认'">black</s:elseif><s:elseif test="color=='蓝色'">#1874CD</s:elseif>'>
							<s:if test="sortDetail=='' || sortDetail==null" >
								<s:property value="title"/>
							</s:if>
							<s:else>
								[<s:property value="sortDetail"/>]<s:property value="title"/>
							</s:else>
							</font>
						</li>
						</div>
						</s:iterator>
					</ul>
				</div>
			</td>
	</tr>
	<tr>
	</tr>
	
	</table>
	</div>
 -->	
  </body>
</html>
