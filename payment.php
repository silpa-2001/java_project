<?php
session_start();
if (!isset($_SESSION['username'])) {
    header('Location: index.php'); 
    exit();
}
include('c_conn.php');

$uname = $_SESSION['username'];

$cartItems = $con->query("SELECT * FROM cart WHERE username='$uname'");
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['payment'])) {
    $con->query("DELETE FROM cart WHERE username='$uname'");

    echo '<script type="text/javascript">
            alert("Payment successful. Your cart is now empty.");
            window.location.href = "profile.php"; 
          </script>';
    exit();
}

?>

<html lang="en">
<link rel="stylesheet" href="styles.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Page</title>
</head>
<body>
    <h1>Payment Page</h1>

    <h2>Your Cart</h2>
    <table>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <?php
        while ($cartItem = $cartItems->fetch_assoc()) {
            $pId = $cartItem['pid'];
            $productInfo = $con->query("SELECT pname,price FROM product WHERE pid=$pId")->fetch_assoc();
            $productName = $productInfo['pname'];
            $price=$productInfo['price'];
            $quantity=$cartItem['quantity'];
            $total=$price*$quantity;
            echo "<tr><td>$productName</td><td>{$cartItem['quantity']}</td><td>$price</td></tr><tr><td></td><td>TOTAL</td><td>$total</td>";
        }
        ?>
    </table>

    <form method="post" action="">
        <button type="submit" name="payment">Payment</button>
    </form>
    <a href="profile.php">Profile</a>
</body>
</html>
