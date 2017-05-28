<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<script type="text/javascript" src="js/page/jquery.tablesorter.min.js">
</script>
<script type="text/javascript" src="js/page/jquery.metadata.js">
</script>
<link href="js/page/theme/blue/style.css" rel="stylesheet"
	type="text/css" media="print, projection, screen" />
<style type="text/css">
</style>
<script type="text/javascript">
//页面加载时，在内容页显示第一个子菜单的页面
$(document).ready(function() {	
	$("input[type=text]").keypress(function (e) {
		var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		if (keyCode == 13){
		 document.forms[0].submit();
		}
    });
	
	if($("#tbmain").attr("class")!='tablesorter'){
		return;
    }
	$("#tbmain").tablesorter({
		widthFixed : true,
		widgets : [ 'zebra' ],
		debug : false
    });
	 <s:if test="sortcolumn!=null&&sortcolumn!=''">
           var sorting=[[<s:property value="sortcolumn" />]];
			$("#tbmain").trigger("sorton",[sorting]); 			        
     </s:if>
});

              function doSubmitForm(value) {
            	  
                  if(isNaN(value)){
	                  alert("请输入0-9的数字!");
	                  document.getElementById('page').value = "";
	                  return false;
	              }else if(value==null||value==""||value<0){
		   			  document.getElementById("currentPage").value = 1;
		   		  }else if(value>${page.totalPage==null?0:page.totalPage}){
		   			  document.getElementById("currentPage").value = ${page.totalPage==null?0:page.totalPage};
		   		  }else{
		   			  document.getElementById("currentPage").value = value;	
		   		  }	
		   	      document.forms[0].submit();
			  }
              
			   function chageSize(){
			      $('#currentPage').val('1');
			      document.forms[0].submit();
			   }
		  </script>

<s:hidden name="sortCode" />
<s:hidden name="sortcolumn" />

<table align="right">
	<tr>
		<s:if test="page.totalRecord>0">
			<td style="border: 0;background-color:#d3d3d3;" align="center">
				共<s:property value="page.totalRecord" />条记录&nbsp;&nbsp;每页
				<s:select name="page.pageSize" onchange="chageSize()"
					list="#{5:'5',10:'10',15:'15',20:'20',30:'30',50:'50',100:'100'}">
				</s:select>

				条&nbsp;&nbsp;第<s:property value="page.currentPage" />页/共<s:property value="page.totalPage" />页

				<input type="button" class="pagebtn" value="首页"
					onclick="<s:if test="page.totalPage>1">doSubmitForm(getElementById('firstPage').value);</s:if>" />
				<input type="hidden" value="<s:property value="1"/>" id="firstPage" />

				<s:if test="page.currentPage>1&&page.currentPage<=page.totalPage">
					<input type="button" class="pagebtn" value="上一页"
						onclick="doSubmitForm(getElementById('upPage').value);" />
					<input type="hidden" value="<s:property value="page.upPage"/>"
						id="upPage" />
				</s:if>

				<s:if test="page.currentPage>=1&&page.currentPage<page.totalPage">
					<input type="button" class="pagebtn" value="下一页"
						onclick="doSubmitForm(getElementById('downPage').value);" />
					<input type="hidden" value="<s:property value="page.downPage"/>"
						id="downPage" />
				</s:if>

				<input type="button" class="pagebtn" value="末页"
					onclick="<s:if test="page.totalPage>1">doSubmitForm(getElementById('endPage').value);</s:if>" />
				<input type="hidden" value="<s:property value="page.totalPage"/>"
					id="endPage" />
				转到<input type="text" style="width:30px;height: 22px;" id="page" size="2">页
				<input type="button" value="GO" class="pagebtn"
					onclick="<s:if test="page.totalPage>1">doSubmitForm(getElementById('page').value);</s:if>">
				<input type="hidden" name="currentPage" id="currentPage"
					value="<s:property value="page.currentPage"/>" />
			</td>
		</s:if>
		<s:if test="page.totalRecord==0">
			<input type="hidden" name="page.pageSize" value="<s:property value="page.pageSize"/>" />
			<td colspan="99" style="border: 0;">
				<div align="left">
					<font color="red">没有符合条件的记录，请输入条件后重试!</font>
				</div>
			</td>
		</s:if>
	</tr>
</table>

