package com.ssafy.enjoytrip.mail.service;

import com.ssafy.enjoytrip.mail.dto.Message;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class HtmlEmailNotification implements Notification {

    private static final String SUBJECT="[EnjoyTrip] 인증 메일이 도착했습니다.";

    private final JavaMailSender javaMailSender;

    public HtmlEmailNotification(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Transactional
    public void sendNotification(Message message) throws MessagingException {
        String TEMPLATE = String.format("<a href='%s'>인증하기</a>","http://localhost:9999/member/auth/".concat(message.getUuid()));
        MimeMessage htmlEmail= javaMailSender.createMimeMessage();
        try {
            System.out.println("TEMPLATE = " + TEMPLATE);
            System.out.println("message.getEmail() = " + message.getEmail());
            System.out.println("message.getUuid() = " + message.getUuid());
//            htmlEmail.setSubject(SUBJECT,"UTF-8");
//            htmlEmail.setText(TEMPLATE,"UTF-8","html");
//            htmlEmail.addRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(message.getEmail()));
//            javaMailSender.send(htmlEmail);
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(htmlEmail,false,"UTF-8");
            mimeMessageHelper.setTo(message.getEmail());
            mimeMessageHelper.setSubject(SUBJECT);
            mimeMessageHelper.setText(TEMPLATE,true);

            javaMailSender.send(htmlEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw e;
        } catch(Exception e){
            e.printStackTrace();
            throw new MessagingException("전송 오류");
        }
    }
}