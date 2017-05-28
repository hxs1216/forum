<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.nuchina.common.consts.BaseConst"%>
<%@page import="com.nuchina.system.model.SysUserInfo"%>
<%@page import="com.nuchina.forum.model.ForumPersonalDetailExample"%>
<%@page import="com.nuchina.forum.dao.IForumPersonalDetailDAO"%>
<%@page import="com.nuchina.forum.dao.impl.ForumPersonalDetailDAOImpl"%>
<%@page import="com.nuchina.forum.model.ForumPersonalDetail"%>





<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="mc" uri="myControl.tld"%>
<%
	String path = request.getContextPath();
	String port = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort();
	String basePath = port + path + "/";
	String systemId = BaseConst.SYSTEM_人力资源管理平台.toString();
	SysUserInfo user = (SysUserInfo)request.getSession().getAttribute("currentUser");
	
	
%>

<!DOCTYPE>
<html>
	<head>
	<base href="<%=basePath%>" />

	<title>头部菜单页面</title>

	<meta http-equiv="pragma" content="no-cache" /><!--是用于设定禁止浏览器从本地机的缓存中调阅页面内容，设定后一旦离开网页就无法从Cache中再调出-->
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" /><!--可以用于设定网页的到期时间，一旦过期则必须到服务器上重新调用。需要注意的是必须使用GMT时间格式-->
	<meta http-equiv="keywords" content="" /><!--向搜索引擎说明你的网页的关键词-->
	<meta http-equiv="description" content="" /><!--告诉搜索引擎你的站点的主要内容-->
	<!-- 
	要为网页指定文本模式，请使用 META 元素，以在该网页中包含 X-UA-Compatible http-equiv 标头。以下示例指定了 EmulateIE7 模式兼容性。
	 -->
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
	<link rel="stylesheet" href="<%=basePath%>css/homeStyle.css">
	<style type="text/css">
		.disabledLi a:hover{
			font-weight: normal;
			color: grey;
			cursor: default;
		}
	</style>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>

	<script type="text/javascript">
		$(document).ready(function(){
			var d, s = "";
			var x = new Array("星期日", "星期一", "星期二","星期三","星期四", "星期五","星期六");
			d = new Date();
			s+=d.getFullYear()+"年"+(d.getMonth() + 1)+"月"+d.getDate()+"日　";
			s+=x[d.getDay()];
			$("#dateInfo").text(s);
		})
		var ind = 0;
		$(function(){
			$("#menu .menuLi").bind('mouseover', function() // 顶级菜单项的鼠标移入操作 
			{
				$(this).children('ul').slideDown('fast');
				var navname = $(this).children('.menuA').find(".nav").html();
				if(navname=='服务中心'){
					//alert(navigator.appVersion);
					//alert(document.documentMode);
					if(isIE7()){
						$(this).children('ul').css("left","-40px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_1.png') no-repeat");
				}else if(navname=='人员选用'){
					if(isIE7()){
						$(this).children('ul').css("left","72px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_2.png') no-repeat");
				}else if(navname=='薪酬绩效'){
					if(isIE7()){
						$(this).children('ul').css("left","184px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_3.png') no-repeat");
				}else if(navname=='学习发展'){
					if(isIE7()){
						$(this).children('ul').css("left","296px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_4.png') no-repeat");
				}else if(navname=='干部之家'){
					if(isIE7()){
						$(this).children('ul').css("left","408px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_5.png') no-repeat");
				}else if(navname=='离退休园地'){
					if(isIE7()){
						$(this).children('ul').css("left","632px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_7.png') no-repeat");
				}else if(navname=='规划配置'){
					if(isIE7()){
						$(this).children('ul').css("left","744px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_8.png') no-repeat");
				}else if(navname=='我的移动人生'){
					if(isIE7()){
						$(this).children('ul').css("left","856px"); //后面依次+112px;
					}
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_green_9.png') no-repeat");
				}
				
				$(this).children('.menuA').css("color", "#FFFFFF");
			}).bind('mouseleave', function() // 顶级菜单项的鼠标移出操作 
			{
				$(this).children('ul').slideUp('fast');
				var navname = $(this).children('.menuA').find(".nav").html();
				if(navname=='服务中心'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_1.png') no-repeat");
				}else if(navname=='人员选用'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_2.png') no-repeat");
				}else if(navname=='薪酬绩效'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_3.png') no-repeat");
				}else if(navname=='学习发展'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_4.png') no-repeat");
				}else if(navname=='干部之家'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_5.png') no-repeat");
				}else if(navname=='离退休园地'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_7.png') no-repeat");
				}else if(navname=='规划配置'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_8.png') no-repeat");
				}else if(navname=='我的移动人生'){
					$(this).children('.menuA').css("background", "url('images/index/nav/nav_9.png') no-repeat");
				}
				$(this).children('.menuA').css("color", "white");
			});
			$('#menu .sub li').bind('mouseover', function() // 子菜单的鼠标移入操作 
			{
				$(this).css("font-weight", "bold");
			}).bind('mouseleave', function() // 子菜单的鼠标移出操作 
			{
				$(this).css("background-color", "#FAF6F5");
				$(this).css("font-weight", "normal");
			});
			var _scrolling=setInterval("AutoScroll()",5000);
			$("#slide>ul").hover(function(){
				//鼠标移动DIV上停止
				clearInterval(_scrolling);
			},function(){
				//离开继续调用
				_scrolling=setInterval("AutoScroll()",5000);
			});
			$('#slide>ul>li>div').bind('mouseover', function() // 子菜单的鼠标移入操作 
			{
				$(this).animate({marginTop:"-60px"},500);
			}).bind('mouseleave', function() // 子菜单的鼠标移出操作 
			{
				$(this).animate({marginTop:"-30px"},500);
			});
		});
//重新登录
function reLogin() {
	if(confirm("您是否确定要退出本系统？")) {
		window.location.href = "<%=basePath%>system/loginAction!loginOut.action";
	}
}
	</script>
	</head>

	<body style="margin: 0px;padding: 0;">
		<!-- 顶部 -->
		<div class="top_div">
			<div>
				<%if(user.isSuperUser() || user.isSysManager(Integer.valueOf(systemId))) {%>
				<p><a target="_blank" href="<%=basePath %>subModule/index.jsp?systemId=<%=BaseConst.SYSTEM_人力资源管理平台 %>">进入后台管理</a></p>
				<%} %>
				<p style="width:180px;" id="dateInfo">
						
				</p>
				<p class="userinfo" style="width:138px">
					${requestScope.nickName}，您好！
				</p>
			</div>
		</div>
		<div class="backg" style="height:80px;">
			<table width="1000" height="80" align="center" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td style="width:70px;">
						<img src="images/index/logo.png" />
					</td>
					<td nowrap="nowrap" valign="middle" style="width:135px;color: #0084CE;">
						<label style="font-size: 25px;font-family: 微软雅黑, Arial, sans-serif;">中国移动</label><br/>
						<label style="font-size: 17px;font-family: Arial, 宋体, sans-serif;letter-spacing: 1px;">China Mobile</label>
					</td>
					<td align="center"><img src="images/index/backline.png" style="vertical-align: middle;"/></td>
					<td valign="middle" align="left" style="padding-left: 17px;">
						<label style="font-size:26px;color:#134961;font-family: 微软雅黑, Arial, sans-serif;letter-spacing: 5px;">分享精彩论坛</label>
					</td>
					<td style="width:70px;">
						<img src="images/index/forum.png" style="width:455px;height: 81px;"/>
					</td>
				</tr>
			</table>
		</div>	
<%--		<div id="menu" class="menuBar">--%>
<%--		</div>--%>
	</body>
</html>
