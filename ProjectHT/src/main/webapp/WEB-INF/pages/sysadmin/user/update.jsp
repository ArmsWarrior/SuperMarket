<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>修改用户列表</title>
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
    修改用户
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr>
		<td><input type="hidden" name="userId" value="${user.userId }"/></td>
		<td><input type="hidden" name="userInfo.userInfoId" value="${user.userId }"/></td>
	</tr>
	<tr>
		<td>用户名称：</td>
		<td><input type="text" name="username" value="${user.username }"/></td>
		<td>密码：</td>
		<td><input type="password" name="password" value="${user.password }"/></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><input type="text" name="userInfo.name" value="${user.userInfo.name }"/></td>
		<td>证件号：</td>
		<td><input type="text" name="userInfo.cardNo" value="${user.userInfo.cardNo }"/></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td><input type="text" name="userInfo.gender" value="${user.userInfo.gender }"/></td>
		<td>工资：</td>
		<td><input type="text" name="userInfo.salary" value="${user.userInfo.salary }"/></td>
	</tr>
	<tr>
		<td>入职日期：</td>
		<td><input type="date" name="userInfo.joinDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${user.userInfo.joinDate}"/>"/></td>
		<td>生日：</td>
		<td><input type="date" name="userInfo.birthday" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${user.userInfo.birthday}'/>"/></td>
	</tr>
	<tr>
		<td>描述：</td>
		<td><input type="text" name="userInfo.station" value="${user.userInfo.station }"/></td>
		<td>用户级别：</td>
		<td>
			<select name="userInfo.userLevel">
				<option value="4" <c:if test="${user.userInfo.userLevel==4 }">selected="selected"</c:if>/>普通用户
				<option value="3" <c:if test="${user.userInfo.userLevel==3 }">selected="selected"</c:if>/>部门经理
				<option value="2" <c:if test="${user.userInfo.userLevel==2 }">selected="selected"</c:if>/>总管
				<option value="1" <c:if test="${user.userInfo.userLevel==1 }">selected="selected"</c:if>/>总经理
				<option value="0" <c:if test="${user.userInfo.userLevel==0 }">selected="selected"</c:if>/>超级管理员
			</select>
		</td>
	</tr>
	<tr>
		<td>员工状态：</td>
		<td>
			<input type="radio" name="state" value="1" <c:if test="${user.state==1 }">checked="checked"</c:if>/>启用
			<input type="radio" name="state" value="0" <c:if test="${user.state==0 }">checked="checked"</c:if>/>关闭
		</td>
		<td>电话：</td>
		<td><input type="text" name="userInfo.telephone" value="${user.userInfo.telephone} "/></td>
	</tr>
	<tr>
		<td>上级领导：</td>
		<td>
			<select name="userInfo.manager.userInfoId">
				<option selected="selected" value=null/>-无领导- 
					<c:forEach var="u" items="${users }">
						<option value="${u.userInfoId }" <c:if test="${user.userInfo.manager.userInfoId==u.userInfoId }">selected="selected"</c:if>>${u.name}</option>
					</c:forEach> 
			</select>
		</td>
		<td>直属部门：</td>
		<td>
			<select name="dept.deptId">
				<option selected="selected" value=null/>-无上级- 
					<c:forEach var="d" items="${depts }">
						<option value="${d.deptId }" <c:if test="${user.dept.deptId==d.deptId }">selected="selected"</c:if>>${d.deptName}</option>
					</c:forEach> 
			</select>
		</td>
	</tr>
	<tr>
		<td>备注信息：</td>
		<td colspan="3">
			<textarea style="width: 100%;height: 100px" name="userInfo.remark" >
			${user.userInfo.remark }
			</textarea>
		</td>
	</tr>
	
</table>
 
</form>
</body>
</html>

