package main.java;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Send {
    public static void main(String[] args) {
        String from = "no-reply-lifelong@cmu.ac.th";
        String to = "pontagun@gmail.com";
        String content = "";
        String charset = "UTF-8";

        String name = "พนธกร สอนจันทร์";
        String nameEng = "Pontakorn Sonchan";
        String coursename = "SMTP 101";


        String host = "202.28.249.12";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props);
//                ,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication
//                    getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("แจ้งเตือนจากระบบออกประกาศณียบัตร CMU MOOC");
            content = "เรียน " + name +
                    "<br><br>วิทยาลัยการศึกษาตลอดชีวิต มหาวิทยาลัยเชียงใหม่ " +
                    "ขอแสดงความยินดีที่ท่านได้ผ่านหลักสูตร " + coursename +
                    "แล้ว" +
                    "<br>ในการนี้ วิทยาลัยการศึกษาตลอดชีวิต " +
                    "มหาวิทยาลัยเชียงใหม่ " +
                    "ได้จัดทำประกาศนียบัตรในรูปแบบเอกสารอิเล็กทรอนิกส์ซึ่งท่านสามารถทำการดาวน์โหลดได้ด้วยตัวเองผ่านบัญชีการใช้งานบนเว็บไซต์ www.lifelong.cmu.ac.th" +
                    "<br><br>หากต้องการติดต่อสอบถามข้อมูลเพิ่มเติม " +
                    "สามารถติดต่อได้ที่ โทร 053-943695, 064-9959333 หรือ " +
                    "ทางอีเมล lifelong@cmu.ac.th" +
                    "<br><br>ขอแสดงความนับถือ" +
                    "<br>วิทยาลัยการศึกษาตลอดชีวิตมหาวิทยาลัยเชียงใหม่" +
                    "<br><br><br> Dear " + nameEng +
                    "<br><br>Congratulation on your completing the " + coursename + "." +
                    "<br>The School of Lifelong Education, Chiang Mai " +
                    "University, is pleased to inform you that your " +
                    "electronic certificate has already been produced. To " +
                    "download the certificate, please login to our website at" +
                    " www.lifelong.cmu.ac.th." +
                    "<br><br>For further information, please contact " +
                    "053-943695, 064-9959333, or Email: lifelong@cmu.ac.th." +
                    "<br><br>Sincerely, yours," +
                    "<br>School of Lifelong Education, Chiang Mai University" +
                    "<br><br>Facebook: CMU School of Lifelong Education";
            message.setContent(content, "text/html;charset=utf-8");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
