<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

$bookingID = $_POST['bookingID'];
$facilityName = $_POST['facilityName'];
$bookingTime = $_POST['bookingTime'];
$bookingDate = $_POST['bookingDate'];

$sql = "UPDATE booking SET facilityName = '$facilityName',bookingTime = '$bookingTime',bookingDate = '$bookingDate' WHERE bookingID = '$bookingID'";

$result = mysqli_query($conn, $sql);

if($result){
	echo "Data Updated";
}
else{
	echo "Failed";
}
mysqli_close($conn)
?>