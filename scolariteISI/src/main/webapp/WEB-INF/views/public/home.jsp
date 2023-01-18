
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
<center>
  <h1>Gestion des comptes</h1>
        <h2>
            <a href="/compte?param=add">Ajouter un nouveau compte</a><br>
            <a href="/droit">Gestion des droits</a>
        </h2>

        <h5>
            <a href="/logout" style="color:red">Se deconnecter</a>
        </h5>
 </center>
<center>
<div class="container col-sm-6 col-sm-offset-3 ">
    <div class="panel panel-primary">
      <div class="panel-heading"><h2>Liste des comptes</h2></div>
        <div class="panel-body" align="center">
         <table class="table table-stripe" align="center">
                       <tr class="text-center">
                           <th>ID</th>
                           <th>Username</th>
                           <th>Password</th>
                           <th>Actions</th>
                       </tr>
                       <c:forEach var="user" items="${listUser}">
                           <tr class="text-center">
                               <td><c:out value="${user.id}" /></td>
                               <td><c:out value="${user.firstname}" /></td>
                               <td><c:out value="${user.lastname}" /></td>
                               <td>

                                <a class="btn btn-primary" href="edit?id=<c:out value='${compte.id}'/>">Edit</a>
                                  &nbsp;&nbsp;&nbsp;&nbsp;
                                <a class="btn btn-danger" href="compte?delete?id=<c:out value='${compte.id}'/>">Delete</a>
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