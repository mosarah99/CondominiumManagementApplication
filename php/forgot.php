<?php

include_once 'conn.php';
require 'PHPMailer/src/Exception.php';
require 'PHPMailer/src/PHPMailer.php';
require 'PHPMailer/src/SMTP.php';

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;
use PHPMailer\PHPMailer\Exception;


$email = $_POST['email'];

$checkQuery = "SELECT * FROM residents WHERE email = '$email'";
$result = mysqli_query($con,$checkQuery);

if (mysqli_num_rows($result) < 1) {
    $resp['code'] = "102";
    $resp['msg'] = "email not exist";
}else {
    while ($row = mysqli_fetch_assoc($result)) {
        $msg = '<div>
        <h2>Your Password and Username is: </h2>
        <ol>
            <li>Username: '.$row['username'].'</li>
            <li>Password: '.$row['password'].'</li>
        </ol>
    </div>';

        $mail = new PHPMailer(true);

        try {                  
            $mail->isSMTP();                                           
            $mail->Host       = 'smtp.gmail.com';                    
            $mail->SMTPAuth   = true;                                 
            $mail->Username   = 'isratjahan335599@gmail.com';                
            $mail->Password   = 'hyyhebpvaggeigvr';                             
            $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;          
            $mail->Port       = 465;                                   

            //Recipients
            $mail->setFrom('isratjahan335599@gmail.com', 'No-reply');
            $mail->addAddress($email);               
            $mail->addReplyTo('no-reply@gmail.com', 'no-reply');
        

            //Content
            $mail->isHTML(true);                                
            $mail->Subject = 'Forgot Password';
            $mail->Body    = $msg;

            $mail->send();
            $resp['code'] = "100";
            $resp['msg'] = 'e-mail has been sent check your mailbox!';
        } catch (Exception $e) {
            $resp['code'] = "101";
            $resp['msg'] = "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
        }
    }
}
echo json_encode($resp);
mysqli_close($con);

?>