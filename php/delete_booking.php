<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

$bookingID = $_POST["bookingID"];

$sql = "DELETE FROM booking WHERE bookingID='$bookingID'";

$result = mysqli_query($conn, $sql);

if($result){
	echo "Data Deleted";
}
else{
	echo "Failed";
}
mysqli_close($conn)
?>