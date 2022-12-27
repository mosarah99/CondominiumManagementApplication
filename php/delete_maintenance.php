<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

$maintenanceID = $_POST["maintenanceID"];

$sql = "DELETE FROM maintenance WHERE maintenanceID='$maintenanceID'";

$result = mysqli_query($conn, $sql);

if($result){
	echo "Data Deleted";
}
else{
	echo "Failed";
}
mysqli_close($conn)
?>