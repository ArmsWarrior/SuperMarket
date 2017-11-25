<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
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
    新增部门
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr>
		<td>部门名称：</td>
		<td><input type="text" name="deptName"/></td>
	</tr>
	<tr>
		<td>部门ID：</td>
		<td><input type="text" name="deptId"/></td>
	</tr>
	<tr>
		<td>上级部门：</td>
		<td>
			<select name="parentDept.deptId">
				<option selected="selected"/>-无上级- 
					<c:forEach var="dept" items="${depts }">
						<option value="${dept.deptId }">${dept.deptName}</option>
					</c:forEach> 
			</select>
		</td>
	</tr>
	<tr>
		<td>部门状态：</td>
		<td>
			<input type="radio" name="state" value="1"/>启用
			<input type="radio" name="state" value="0"/>关闭
		</td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

