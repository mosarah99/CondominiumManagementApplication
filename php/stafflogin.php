<?php
include_once 'conn.php';

$username = $_POST['username'];
$pass = $_POST['password'];

$query = "SELECT * FROM staff WHERE username = '$username' AND password = '$pass'";
$result = mysqli_query($con,$query);
if (mysqli_num_rows($result) > 0) {
    $resp['code'] = "200";
    $resp["msg"] = "Login Success!";
}else{
    $resp['code'] = "202";
    $resp["msg"] = "Login Faild!";
}
    
echo json_encode($resp);
mysqli_close($con);
?>