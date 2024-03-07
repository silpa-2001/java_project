<?php
include('c_conn.php');
$result = $con->query("SELECT * FROM product");
?>

<html lang="en">
<link rel="stylesheet" href="styles.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
</head>
<body>
    <h1>Products</h1>
    <center>
        <table>
            <tr>
                <h2>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </h2>
            </tr>
            <?php
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    echo '<tr><td>';
                    echo $row['pid'].'</td><td>';
                    echo $row['pname'].'</td><td>';
                    echo $row['discp'].'</td><td>';
                    echo $row['price'].'</td><td>';
                    echo $row['quantity'].'</td><td>';
                    ?>
                    <?php
                    echo '</td></tr>';
                }
            } else {
                echo "No product Found...";
            }
            ?>
        </table>
    </center>
    <br>
    <a href="profile.php">Profile Page</a>
</body>
</html>
