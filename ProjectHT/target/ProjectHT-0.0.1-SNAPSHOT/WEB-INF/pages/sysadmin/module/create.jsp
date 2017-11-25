<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>模块列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<!-- _self代表的是当前页面的相对地址 -->
	<li id="save"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="window.history.back();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
 	   新增模块
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr>
		<td>模块名称：</td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>模块描述：</td>
		<td><input type="text" name="remark"/></td>
	</tr>
	<tr>
		<td>模块序号：</td>
		<td><input type="text" name="orderNo"/></td>
	</tr>
	<tr>
		<td>上级模块：</td>
		<td>
			<select name="parentModule.ModuleId">
				<option selected="selected"/>-无上级模块- 
					<c:forEach var="m" items="${modules }">
						<option value="${m.moduleId }">${m.name}</option>
					</c:forEach> 
			</select>
		</td>
	</tr>
	<tr>
		<td>模块状态：</td>
		<td>
			<input type="radio" name="state" value="1"/>启用
			<input type="radio" name="state" value="0"/>关闭
		</td>
	</tr>
	<tr>
		<td>模块权限：</td>
		<td>
			<input type="radio" name="ctype" value="1"/>主菜单
			<input type="radio" name="ctype" value="2"/>左侧菜单
			<input type="radio" name="ctype" value="3"/>按钮
		</td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

