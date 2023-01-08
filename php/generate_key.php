<?php

// required files
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
use PHPMailer\PHPMailer\SMTP;


if(isset($_POST['email'])) {
    require_once('conn.php');
    $email = $_POST['email'];
    $email = filter_var($email, FILTER_SANITIZE_EMAIL);
    $email = filter_var($email, FILTER_VALIDATE_EMAIL);
    $error = "";

    // error for invalid email
    if (!$email) {
        $error .= "Invalid email address. ";
        // echo $error;
    } 

    $email_user_sql 
        = "SELECT * FROM `users` WHERE email = '$email';";


    if ($conn->query($email_user_sql)->num_rows < 1) {
        $error .= "No user with this email address";
        echo $error;
        return;
    }

    $expFormat = mktime(
        date("H"),
        date("i"),
        date("s"),
        date("m"), 
        date("d") + 1,
        date("Y")
    );
    $expDate = date("Y-m-d H:i:s", $expFormat);
    $key = md5(rand(rand(2418 * 2, null), null) . $email);
    $addkey = substr(md5(uniqid(rand(), 1)), 3, 10);
    $key = $key . $addkey;

    // Insert new key into the table
    $sql =
        "INSERT INTO `passwordreset` (`email`, `key`, `expDate`)
        VALUES ('" . $email . "', '" . $key . "', '" . $expDate . "');";

    if (!$conn->query($sql)) {
        $error .= "Key generation unsuccessful";
        echo $error;
    }


/* 
 *
 *  ███████████  █████   █████ ███████████  ██████   ██████            ███  ████                    
 *  ░███░░░░░███░░███   ░░███ ░░███░░░░░███░░██████ ██████            ░░░  ░░███                    
 *  ░███    ░███ ░███    ░███  ░███    ░███ ░███░█████░███   ██████   ████  ░███   ██████  ████████ 
 *  ░██████████  ░███████████  ░██████████  ░███░░███ ░███  ░░░░░███ ░░███  ░███  ███░░███░░███░░███
 *  ░███░░░░░░   ░███░░░░░███  ░███░░░░░░   ░███ ░░░  ░███   ███████  ░███  ░███ ░███████  ░███ ░░░ 
 *  ░███         ░███    ░███  ░███         ░███      ░███  ███░░███  ░███  ░███ ░███░░░   ░███     
 *  █████        █████   █████ █████        █████     █████░░████████ █████ █████░░██████  █████    
 *  ░░░░░        ░░░░░   ░░░░░ ░░░░░        ░░░░░     ░░░░░  ░░░░░░░░ ░░░░░ ░░░░░  ░░░░░░  ░░░░░     
 *                                                                                                                                                                                   
 */

    // required fiels
    require_once ('vendor\phpmailer\phpmailer\src\Exception.php');
    require_once ('vendor\phpmailer\phpmailer\src\PHPMailer.php');
    require_once ('vendor\phpmailer\phpmailer\src\SMTP.php');
 
    // Compose email
    // email to is the $email
    // email from gmail
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    $email_from = "noreply.condominium@gmail.com";        // ENTER GMAIL ID 
    $email_from_password = "ypvwrblsbkncxauh";            // ENTER GMAIL PASSWORD
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    $subject = "Condominium - Password recovery";
    $body = "<p>Dear user,</p>";
    $body .= "<p>We have received a password reset request for your condominium system account. Please use the following key in the app to reset your password</P><br /><br />";
    $body .= "<p style='align:center; border: 3px solid black'><code>" . $key . "</code></p><br /><br />";
    $body .= "<p>Please do not share the key. The key is valid for a short time.</p>";

    $mail = new PHPMailer(true);
    try {
        $mail->isSMTP();                                            //Send using SMTP
        $mail->Host       = 'smtp.gmail.com';                     //Set the SMTP server to send through (GMAIL)
        $mail->SMTPAuth   = true;                                   //Enable SMTP authentication

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        $mail->Username   = $email_from;                     //SMTP username
        $mail->Password   = $email_from_password;                               //SMTP password
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        $mail->setFrom("" . $email_from, "Condominium System Management");
        $mail->addAddress($email);
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;            //Enable implicit TLS encryption
        $mail->Port       = 465;                                    //TCP port to connect to; use 587 if you have set `SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS`
    
        //Recipients
        $mail->addAddress($email, "Condominium User");     //Add a recipient        
    
        //Content
        $mail->isHTML(true);                                  //Set email format to HTML
        $mail->Subject = $subject;
        $mail->Body    = $body;

        // SEND EMAIL
        $mail->send();
        echo 'Message has been sent';
    } catch (Exception $e) {
        echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
    }
}

?>