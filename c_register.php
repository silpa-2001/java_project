<?php
include('c_conn.php');
?>
<html lang="en">
<link rel="stylesheet" href="styles.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<h1>Register</h1>
<body>
    <form action="" method="post">
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="username" placeholder="UserName">
        <input type="password" name="password" placeholder="Password">
        <input type="submit" name="register" value="Register">
   </form>
   <a href="index.php">Login</a>
    <?php
        if($_SERVER['REQUEST_METHOD']=="POST")
        {
            $name= $_POST['name'];
            $username= $_POST['username'];
            $password= $_POST['password'];
            
            $ins= $con->query("insert into profile(name,username,password)values('$name','$username','$password')");
            if($ins)
            {
                echo '<script type="text/javascript">
                alert("Registration Successful")
                </script>';
            }
        }
    ?>
</body>
</html>