<?php
include_once 'conn.php';
$username = $_POST['username'];
$email = $_POST['email'];
$pass = $_POST['password'];
$unitno = $_POST['unitno'];

$checkQuery = "SELECT * FROM staff WHERE email= '$email'";
$result = mysqli_query($con,$checkQuery);
$resq = "";

if (mysqli_num_rows($result) > 0) {
    $resp['code'] = "200";
    $resp["msg"] = "User Already Registrated";
}else{
    $query = "INSERT INTO staff(username,email,password,unitno) VALUES('$username','$email','$pass','$unitno')";
    $insert = mysqli_query($con,$query);
    if ($insert) {
        $resp['code'] = "201";
        $resp["msg"] = "User Registrated!";
    }else{
        $resp['code'] = "202";
        $resp["msg"] = "Someting Went Wrong!";
    }
    
}
echo json_encode($resp);

mysqli_close($con);


?>