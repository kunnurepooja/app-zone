<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/validation.js"></script>
</head>
<style>
.Absolute-Center {
  position: absolute;
  top: 250; left: 330; bottom: 0; right: 0;
}


</style>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <h1 style="color:white">App Zone</h1>
</nav>

<div class="container"> 
<form class="Absolute-Center" id="loginForm" action="login.do" method="post">
<div style="color:red"> ${credentials} </div>
  
    <div class="form-group row ">
        <label class="col-sm-1 col-form-label">UserName</label>
        <div class="col-sm-5">
            <input type="text" class="form-control  input-lg" id="userName" name="userName" placeholder=" Enter UserName">
        </div>
    </div>
    <span id="#error_username"></span>
    <div class="form-group row">
        <label  class="col-sm-1 col-form-label">Password</label>
        <div class="col-sm-5">
            <input type="password" class="form-control  input-lg" id="password" name="password" placeholder=" Enter Password">
        </div>
    </div>
    <span id="#error_password"></span>
    <div class="form-group row">
        <div class="col-sm-10 offset-sm-2">
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="reset" class="btn btn-primary">Cancle</button>
        </div>
        <div class="col-sm-10 offset-sm-2">
           
        </div>
    </div>
  </div>
  </div>
</form>
</div>


</body>
</html>
