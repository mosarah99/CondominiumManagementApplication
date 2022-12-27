<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);


$facilityName = $_POST['facilityName'];
$bookingDate = $_POST['bookingDate'];
$bookingTime = $_POST['bookingTime'];

$Sql_Query = "INSERT INTO booking (facilityName,bookingDate,bookingTime) VALUES ('$facilityName', '$bookingDate', '$bookingTime')";

if(mysqli_query($conn,$Sql_Query)){
	echo 'Data Submit Successfully';
	}
	else{
		echo 'Try Again';
		}
mysqli_close($conn);

?>