<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);


$result = array();
$result['item'] = array();
$select = "SELECT *from facility";
$response = mysqli_query($conn, $select);

while ($row = mysqli_fetch_array($response)){
	
	$index['facilityID'] = $row['0'];
	$index['facilityName'] = $row['1'];
	$index['location'] = $row['2'];
	$index['capacity'] = $row['3'];
	
	array_push($result['item'], $index);
}

	$result["success"] = "1";
	echo json_encode($result);
	mysql_close($conn);


?>