<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>查询用户</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<!-- _self代表的是当前页面的相对地址 -->
	<li id="save"><a href="#" onclick="window.history.back();">确定</a></li>
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
		<td>用户名称：</td>
		<td>${user.username }</td>
		<td>用户ID</td>
		<td>${user.userId }</td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td>${user.userInfo.name }</td>
		<td>证件号：</td>
		<td>${user.userInfo.cardNo }</td>
	</tr>
	<tr>
		<td>性别：</td>
		<td>${user.userInfo.gender }</td>
		<td>工资：</td>
		<td>${user.userInfo.salary }</td>
	</tr>
	<tr>
		<td>入职日期：</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.userInfo.joinDate}"/></td>
		<td>生日：</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.userInfo.birthday}"/></td>
	</tr>
	<tr>
		<td>描述：</td>
		<td>${user.userInfo.station }</td>
		<td>用户级别：</td>
		<td>
			<c:if test="${user.userInfo.userLevel==4 }">普通用户</c:if>
			<c:if test="${user.userInfo.userLevel==3 }">部门经理</c:if>
			<c:if test="${user.userInfo.userLevel==2 }">总管</c:if>
			<c:if test="${user.userInfo.userLevel==1 }">总经理</c:if>
			<c:if test="${user.userInfo.userLevel==0 }">超级管理员</c:if>
		</td>
	</tr>
	<tr>
		<td>员工状态：</td>
		<td>
			<c:if test="${user.state==1 }">启用</c:if>
			<c:if test="${user.state==0 }">关闭</c:if>
		</td>
		<td>电话：</td>
		<td>${user.userInfo.telephone}</td>
	</tr>
	<tr>
		<td>上级领导：</td>
		<td>${user.userInfo.manager.name}
		</td>
		<td>直属部门：</td>
		<td>${user.dept.deptName }
		</td>
	</tr>
	<tr>
		<td>备注信息：</td>
		<td colspan="3">
			<textarea style="width: 100%;height: 100px" name="userInfo.remark" readonly="readonly">
			${user.userInfo.remark }
			</textarea>
		</td>
	</tr>
	
</table>
 
</form>
</body>
</html>

