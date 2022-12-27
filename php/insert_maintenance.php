<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);


$facilityName = $_POST['facilityName'];
$maintenanceTime = $_POST['maintenanceTime'];
$maintenanceDate = $_POST['maintenanceDate'];


$Sql_Query = "INSERT INTO maintenance (facilityName, maintenanceTime, maintenanceDate) VALUES ('$facilityName','$maintenanceTime', '$maintenanceDate')";


if(mysqli_query($conn,$Sql_Query)){
	echo 'Data Submit Successfully';
	}
	else{
		echo 'Try Again';
		}
mysqli_close($conn);
 

?>