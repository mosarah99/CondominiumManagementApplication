<?php

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
use PHPMailer\PHPMailer\SMTP;


// Load composure's autoloader
require 'vendor/autoload.php';

require ('vendor\phpmailer\phpmailer\src\Exception.php');
require ('vendor\phpmailer\phpmailer\src\PHPMailer.php');
require ('vendor\phpmailer\phpmailer\src\SMTP.php');






        // // Compose email
        // // email to is the $email
        // // email from gmail
        // ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // $email_from = "noreply.condominium@gmail.com";        // ENTER GMAIL ID
        // $email_from_password = "Abcd@1234";           // ENTER GMAIL PASSWORD
        // $email = "sadatrahman001@gmail.com";
        // ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // $subject = "Condominium - Password recovery";
        // $body = "<p>Dear user,</p>";
        // $body .= "<p>We have received a password reset request to reset your condominium system. Please use the following key in the app to reset your password</P><br /><br />";
        // $body .= "<p style='border: 3px solid black'><code>" . "</code></p><br /><br />";
        // $body .= "<p>Please do not share the key. The key is valid for a short time.</p>";

        // $mail = new PHPMailer();
        // try {
        //     $mail->isSMTP();                                            //Send using SMTP
        //     $mail->Host       = 'smtp.gmail.com';                     //Set the SMTP server to send through (GMAIL)
        //     $mail->SMTPAuth   = true;                                   //Enable SMTP authentication

        //     ////////////////////////////////////////////////////////////////////////////////////////////////////
        //     $mail->Username   = $email_from;                     //SMTP username
        //     $mail->Password   = $email_from_password;                               //SMTP password
        //     ////////////////////////////////////////////////////////////////////////////////////////////////////

        //     $mail->setFrom("" . $email_from, "noreply@yourcondominium.com");
        //     $mail->addAddress($email);
        //     // $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;            //Enable implicit TLS encryption
        //     $mail->Port       = 587;                                    //TCP port to connect to; use 587 if you have set `SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS`
        
        //     //Recipients
        //     $mail->addAddress($email, "Condominium User");     //Add a recipient        
        
        //     //Content
        //     $mail->isHTML(true);                                  //Set email format to HTML

        //     // SEND EMAIL
        //     $mail->send();
        //     echo 'Message has been sent';
        // } catch (Exception $e) {
        //     echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
        // }
        




$mail = new PHPMailer(true);
try {
    //Server settings
    $mail->SMTPDebug = SMTP::DEBUG_SERVER;                      //Enable verbose debug output
    $mail->isSMTP();                                            //Send using SMTP
    $mail->Host       = 'smtp.gmail.com';                     //Set the SMTP server to send through
    $mail->SMTPAuth   = true;                                   //Enable SMTP authentication
    $mail->Username   = 'noreply.condominium@gmail.com';                     //SMTP username
    $mail->Password   = 'Abcd@1234';                               //SMTP password
    // $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;
    $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;            //Enable implicit TLS encryption
    $mail->Port       = 587;                                    //TCP port to connect to; use 587 if you have set `SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS`

    //Recipients
    // $mail->setFrom('noreply.condominium@gmail.com', 'From Sadat');
    $mail->addAddress('sadatrahman001@gmail.com', 'To Sadat');     //Add a recipient
    // $mail->addAddress('ellen@example.com');               //Name is optional
    // $mail->addReplyTo('info@example.com', 'Information');
    // $mail->addCC('cc@example.com');
    // $mail->addBCC('bcc@example.com');

    //Attachments
    // $mail->addAttachment('/var/tmp/file.tar.gz');         //Add attachments
    // $mail->addAttachment('/tmp/image.jpg', 'new.jpg');    //Optional name

    //Content
    $mail->isHTML(true);                                  //Set email format to HTML
    $mail->Subject = 'Here is the subject';
    $mail->Body    = 'This is the HTML message body <b>in bold!</b>';
    $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';

    $mail->send();
    echo 'Message has been sent';
} catch (Exception $e) {
    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
}


?>