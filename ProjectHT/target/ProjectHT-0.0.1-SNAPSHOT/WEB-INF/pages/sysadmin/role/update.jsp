<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>角色列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<!-- _self代表的是当前页面的相对地址 -->
	<li id="save"><a href="#" onclick="formSubmit('update','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="window.history.back();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    修改角色
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr>
		<td>角色名称：</td>
		<td><input type="text" name="name" value="${role.name }"/></td>
	</tr>
	<tr>
		<td>角色描述：</td>
		<td><input type="text" name="remarks" value="${role.remarks }"/></td>
	</tr>
	<tr>
		<td>角色序号：</td>
		<td><input type="text" name="orderNo" value="${role.orderNo }"/></td>
	</tr>
	<tr>
		<td><input type="hidden" name="roleId" value="${role.roleId }" readonly="readonly"/ ></td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

