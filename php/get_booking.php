<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);


$result = array();
$result['item'] = array();
$select = "SELECT *from booking";
$response = mysqli_query($conn, $select);

while ($row = mysqli_fetch_array($response)){
	
	$index['bookingID'] = $row['0'];
	$index['facilityName'] = $row['1'];
	$index['bookingTime'] = $row['2'];
	$index['bookingDate'] = $row['3'];
	
	array_push($result['item'], $index);
}

	$result["success"] = "1";
	echo json_encode($result);
	mysql_close($conn);


?>