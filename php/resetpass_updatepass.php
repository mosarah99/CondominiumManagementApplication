<?php

require("conn.php");


if (isset($_POST["email"]) && isset($_POST["password"])) {

    $email = $_POST["email"];
    $newpassword = md5($_POST["password"]);

    $query_result = $conn->query("
        UPDATE users SET password = '" . $newpassword . "' WHERE email = '" . $email . "';
    ");

    echo "SUCCESS";

}
else 
    echo "FAILED CHECK";

?>