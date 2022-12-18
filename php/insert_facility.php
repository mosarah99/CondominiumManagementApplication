<?php
error_reporting(0);

include 'DatabaseConfig.php' ;

// Create connection
$conn = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);


$facilityName = $_POST['facilityName'];
$location = $_POST['location'];
$capacity = $_POST['capacity'];


$Sql_Query = "INSERT INTO facility (facilityName,location,capacity) VALUES ('$facilityName', '$location', '$capacity')";

// an array to display response
 //$response = array();
 
 /*if($_POST['facilityName'] && $_POST['location'] &&$_POST['capacity']){
	 
	 $facilityName = $_POST['facilityName'];
	 $location = $_POST['location'];
	 $capacity = $_POST['capacity'];
	 
	 $stmt = $conn->prepare("INSERT INTO 'facility' ('facilityName','location','capacity') VALUES (?,?,?)");
	 $stmt->bind_param("sss",$facilityName,$location,$capacity);
	 
	 if($stmt->execute() == TRUE){
			// if the script is executed successfully we are
			// passing data to our response object
			// with a success message.
			 $response['error'] = false;
			 $response['message'] = "data insert successfully!";
		 } else{
			 // if we get any error we are passing error to our object.
			 $response['error'] = true;
			 $response['message'] = "failed\n ".$conn->error;
		 }
	 } else{
		 // this method is called when user
		 // donot enter sufficient parameters.
		 $response['error'] = true;
		 $response['message'] = "Insufficient parameters";
	 }
	 // at last we are printing our response which we get.
	 echo json_encode($response);*/

if(mysqli_query($conn,$Sql_Query)){
	echo 'Data Submit Successfully';
	}
	else{
		echo 'Try Again';
		}
mysqli_close($conn);

 


//if(isset($_POST['FacilityName'] && isset($_POST['Location']&& isset($_POST['Capacity'])){
	/*require "conn.php";
	$FacilityName = $_POST['FacilityName'];
	$Location = $_POST['Location'];
	$Capacity = $_POST['Capacity'];
	
	$sql = "INSERT INTO facility VALUES(NULL, '$FacilityName', '$Location', '$Capacity');";
	
	if(!$conn->query($sql)){
		echo "failure";
	}else{
		echo "success";
	}
}*/

?>
