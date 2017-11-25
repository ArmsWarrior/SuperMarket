<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>新增用户列表</title>
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
    新增用户
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr>
		<td>用户名称：</td>
		<td><input type="text" name="username"/></td>
		<td>密码：</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><input type="text" name="userInfo.name"/></td>
		<td>证件号：</td>
		<td><input type="text" name="userInfo.cardNo"/></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td><input type="text" name="userInfo.gender"/></td>
		<td>工资：</td>
		<td><input type="text" name="userInfo.salary"/></td>
	</tr>
	<tr>
		<td>入职日期：</td>
		<td><input type="date" name="userInfo.joinDate"/></td>
		<td>生日：</td>
		<td><input type="date" name="userInfo.birthday"/></td>
	</tr>
	<tr>
		<td>描述：</td>
		<td><input type="text" name="userInfo.station"/></td>
		<td>用户级别：</td>
		<td>
			<select name="userInfo.userLevel">
				<option value="4"/>普通用户
				<option value="3"/>部门经理
				<option value="2"/>总管
				<option value="1"/>总经理
				<option value="0"/>超级管理员
			</select>
		</td>
	</tr>
	<tr>
		<td>员工状态：</td>
		<td>
			<input type="radio" name="state" value="1"/>启用
			<input type="radio" name="state" value="0"/>关闭
		</td>
		<td>电话：</td>
		<td><input type="text" name="userInfo.telephone"/></td>
	</tr>
	<tr>
		<td>上级领导：</td>
		<td>
			<select name="userInfo.manager.userInfoId">
				<option selected="selected" value=null/>-无领导- 
					<c:forEach var="user" items="${users }">
						<option value="${user.userInfoId }">${user.name}</option>
					</c:forEach> 
			</select>
		</td>
		<td>直属部门：</td>
		<td>
			<select name="dept.deptId">
				<option selected="selected" value=null/>-无上级- 
					<c:forEach var="dept" items="${depts }">
						<option value="${dept.deptId }">${dept.deptName}</option>
					</c:forEach> 
			</select>
		</td>
	</tr>
	<tr>
		<td>备注信息：</td>
		<td colspan="3">
			<textarea style="width: 100%;height: 100px" name="userInfo.remark">
			</textarea>
		</td>
	</tr>
	
</table>
 
</form>
</body>
</html>

