<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

$sql = "select * from facility";
if(!$conn->query($sql)){
	echo "Error in connecting to Database.";
}
else{
	$result = $conn->query($sql);
	if($result->num_rows > 0){
		$return_arr['facility'] = array();
		while($row = $result->fetch_array()){
			array_push($return_arr['facility'], array(
			'FacilityID'=>$row['FacilityID'],
			'FacilityName'=>$row['FacilityName']
			));
		}
		echo json_encode($return_arr);
	}
}
?>