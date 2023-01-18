<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
<header>
<body>
<%@ include file="../public/header.jsp"%>
<center>
  <h1>Gestion des Rôle</h1>
        <h2>
            <a href="/roles?param=add">Ajouter un nouveau role</a><br>
            <a href="/users">Gestion des users</a>
        </h2>

        <h5>
            <a href="/logout" style="color:red">Se deconnecter</a>
        </h5>
 </center>
<div class="container col-md-8 col-md-offset-1">
<c:if test="${!empty erorr}">
   <c:out value="${error}"/>
</c:if>
    <div class="panel panel-primary">
      <div class="panel-heading"><h2>Liste des roles</h2></div>
        <div class="panel-body" align="center">
         <table class="table table-stripe">
			 <tr class="text-center">
				<th>ID</th>
				<th>ROLE</th>
				<th>Actions</th>
				</tr>
			    <c:forEach var="role" items="${listRole}">
				<tr class="text-center">
				<td><c:out value="${role.id}" /></td>
				<td><c:out value="${role.name}" /></td>
				<td>
                   <a class="btn btn-primary" href="edit?id=<c:out value='${role.id}' />">Edit</a>
                                                  &nbsp;&nbsp;&nbsp;&nbsp;
                   <a class="btn btn-danger" href="delete?id=<c:out value='${role.id}' />">Delete</a>
                </td>
				</tr>
				</c:forEach>
         </table>
        </div>
    </div>
</div>
</body>
</html