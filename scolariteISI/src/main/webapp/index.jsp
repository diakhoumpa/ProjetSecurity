<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
      <div class="row">
        <div class="col-6 mt-2 py-2">
        <div class="panel-group">
          <div class="panel panel-default">
            <div class="panel-body">

            </div>
          </div>

        </div>
        </div>
        <div class="col-6 mt-3 py-2">

        <div class="panel panel-primary">
            <div class="panel-heading">Connexion</div>
            <div class="panel-body">
                 <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
                           <form action="/login" method="post">
                            <div class="form-group">
                             <label for="email">Email:</label> <input type="text"
                              class="form-control" id="email" placeholder="email"
                              name="email" required>
                            </div>
                            <div class="form-group">
                             <label for="uname">Password:</label> <input type="password"
                              class="form-control" id="password" placeholder="Password"
                              name="password" required>
                            </div>
                            <div class="mt-2" >
                            <button type="submit" class="btn btn-success">Connexion</button>
                            </div>
                            </form>
                          </div>
            </div>
            <div class="panel-footer">by Marieme</div>
        </div>
        </div>
      </div>
</div>
</body>
</html>