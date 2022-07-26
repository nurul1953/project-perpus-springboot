package com.example.coba.service;

import com.example.coba.dto.AdminDto;
import com.example.coba.dto.MailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;
    @Autowired
    public EmailService(JavaMailSender mailSender){
        this.sender = mailSender;
    }
    public MailResponse sendEmail(AdminDto request){
        MailResponse response = new MailResponse();
        MimeMessage message = sender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(request.getEmail());
            helper.setText("Hai "+request.getNama()+" (@"+request.getUsername()+")"+", terimakasih, pendaftaran kamu di web "+"<b>"+"My Library"+"</b>"+ " telah sukses dilakukan. Selamat bergabung bersama kami! Salam hangat.",true);
            helper.setSubject("Pendaftaran My Library Sukses");
            helper.setFrom("nushnna1953@gmail.com");
            sender.send(message);
            response.setPesan("Email terkirim ke : " + request.getEmail());
            response.setStatus(Boolean.TRUE);
        }catch (MessagingException e){
            e.printStackTrace();
            response.setPesan("Email gagal dikirim ke : " + request.getEmail());
            response.setStatus(Boolean.FALSE);
        }return response;
    }
}
