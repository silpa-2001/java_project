<?php
session_start();
if(!isset($_SESSION['username']))
{
    header('Location: index.php');
}
$uname= $_SESSION ['username'];
include('c_conn.php');


$qury= $con->query("select * from profile where username='$uname'");
$row= $qury->fetch_assoc();
$id= $row['id'];
$name= $row['name'];

$cartItems = $con->query("SELECT * FROM cart WHERE username='$uname'");

?>
<html lang="en">
<link rel="stylesheet" href="styles.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>
<body>
    <h1>Hello <?php echo $name;?></h1>  
    <a href="product.php">Product Page</a><br>
    <h2>Your Cart</h2>
    <table>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <?php
            while($cartItem= $cartItems->fetch_assoc())
            {
                $pId=$cartItem['pid'];
                $productInfo=$con->query("SELECT pname FROM product WHERE pid=$pId")->fetch_assoc();
                $productName=$productInfo['pname'];
                echo "<tr><td>$productName</td><td>{$cartItem['quantity']}</td><td>{$cartItem['price']}</td></tr>";
            }
        ?>
    </table>
    <h2>Add to Cart</h2>
    <form action="" method="post">
        <label for="pid">Product ID:</label>
        <input type="text" name="pid" required>
        <label for="quantity">Quantity:</label>
        <input type="number" name="quantity" required>
        <button type="submit" name="addToCart"> Add To Cart</button>
    </form>
    <form action="payment.php" method="post">
        <button type="submit" name="pay">Pay</button>
    </form>
    <a href="index.php">HomePage</a><br>
    <a href="logout.php">Logout</a> <br>
    
    <?php
           if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['addToCart'])) 
           {
            $pId = $_POST['pid'];
            $quantity = $_POST['quantity'];
            $priceInfo = $con->query("SELECT price FROM product WHERE pid=$pId")->fetch_assoc();
            $price = $priceInfo['price'];
            $productExists = $con->query("SELECT * FROM product WHERE pid=$pId")->num_rows > 0;
            if ($productExists) 
            {
                $con->begin_transaction();
                try 
                {
                    $con->query("UPDATE product SET quantity = quantity - $quantity WHERE pid=$pId");
                    $con->query("INSERT INTO cart (username,pid,quantity,price) VALUES ('$uname', $pId, $quantity, $price)");
                    $con->commit();  
                    header("Location: {$_SERVER['PHP_SELF']}");
                    exit();
                } 
                catch (Exception $e) 
                {
                    $con->rollback();
                    echo "Error: " . $e->getMessage();
                }
            } 
            else 
            {
                echo "Product does not exist.";
            }
        }
    ?>
</body>
</html>