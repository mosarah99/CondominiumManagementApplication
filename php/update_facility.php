<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

$facilityID = $_POST['facilityID'];
$facilityName = $_POST['facilityName'];
$location = $_POST['location'];
$capacity = $_POST['capacity'];

$sql = "UPDATE facility SET facilityName = '$facilityName',location = '$location',capacity = '$capacity' WHERE facilityID = '$facilityID'";

$result = mysqli_query($conn, $sql);

if($result){
	echo "Data Updated";
}
else{
	echo "Failed";
}
mysqli_close($conn)
?>