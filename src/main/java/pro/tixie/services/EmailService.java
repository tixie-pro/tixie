package pro.tixie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pro.tixie.model.Ticket;
import pro.tixie.model.User;

@Service("mailService")
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Value("admin@example.com")
    private String from;

    public void prepareAndSend(Ticket ticket, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(ticket.getAuthorId().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}
