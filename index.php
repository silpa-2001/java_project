<?php
    include('c_conn.php');
?>
<html lang="en">
<link rel="stylesheet" href="styles.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">GadgetGrove</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
</nav>
<center>
<form action="" method="post">
        <br><br><input type="text" name="username" placeholder="UserName"><br><br>
        <input type="password" name="password" placeholder="Password"><br><br>
        <input type="submit" name="login" value="Login">
   </form>
    <font size="4">New User? <a href="c_register.php">Register</a></font>
</center>
   <?php
        if($_SERVER['REQUEST_METHOD']=="POST")
        {
            $username= $_POST['username'];
            $password= $_POST['password'];

            $check= $con->query("select * from profile where username ='$username' and password='$password'");
            if($check->num_rows>0)
            {
                session_start();
                $_SESSION['username']= $username;
                header('Location: profile.php');
            }
            else
            {
                echo '<script type="text/javascript">
                alert("Invalid Username/Password...")
                </script>';
            }
        }
   ?>
</body>
</html>
