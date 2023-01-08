<?php

require('conn.php');

if(isset($_POST["key"]) && isset($_POST["email"])) {

    $key = $_POST["key"];
    $email = $_POST["email"];
    $currDate = date("Y-m-d H:i:s");

    $query_result = $conn->query("SELECT * FROM passwordreset WHERE `key` = '" . $key . "' AND email = '" . $email . "' AND expdate >= '" . $currDate . "';");

    if($query_result->num_rows < 1) {
        echo "FAILURE";
    } else { //     if($query_result->num_rows <= 0) {
        echo "SUCCESS";
    } //     if($query_result->num_rows <= 0) {

} // if(isset($_GET["key"]) && isset($_GET["email"])) {

?>