<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

$facilityID = $_POST["facilityID"];

$sql = "DELETE FROM facility WHERE facilityID='$facilityID'";

$result = mysqli_query($conn, $sql);

if($result){
	echo "Data Deleted";
}
else{
	echo "Failed";
}
mysqli_close($conn)
?>