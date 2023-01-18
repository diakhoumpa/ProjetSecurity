<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  <h1>Gestion des users</h1>
        <h2>
            <a href="/users?param=add">Ajouter un nouveau user</a><br>
            <a href="/roles">Gestion des roles</a>
        </h2>

        <h5>
            <a href="/logout" style="color:red">Se deconnecter</a>
        </h5>
 </center>
<center>
<div class="container col-sm-6 col-sm-offset-3 ">
    <div class="panel panel-primary">
      <div class="panel-heading"><h2>Liste des roles</h2></div>
        <div class="panel-body" align="center">
         <table class="table table-stripe" align="center">
                       <tr class="text-center">
                           <th>ID</th>
                           <th>Firstname</th>
                           <th>Lastname</th>
                           <th>Email</th>
                           <th>Actions</th>
                       </tr>
                       <c:forEach var="user" items="${listUser}">
                           <tr class="text-center">
                               <td><c:out value="${user.id}" /></td>
                               <td><c:out value="${user.firsName}" /></td>
                               <td><c:out value="${user.lastName}" /></td>
                               <td><c:out value="${user.email}" /></td>
                               <td>
                                <a class="btn btn-primary" href="edit?id=<c:out value='${user.id}'/>">Edit</a>
                                  &nbsp;&nbsp;&nbsp;&nbsp;
                                <a class="btn btn-danger" href="compte?delete?id=<c:out value='${user.id}'/>">Delete</a>
                               </td>
                           </tr>
                       </c:forEach>
         </table>
        </div>
    </div>
</div>
</center>
</body>
</html>