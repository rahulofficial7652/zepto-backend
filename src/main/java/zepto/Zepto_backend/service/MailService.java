package zepto.Zepto_backend.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import zepto.Zepto_backend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.context.Context;

@Slf4j
@Service
public class MailService {
// Using Java Mail Sender library
// We can't use Autowired here because it is not a bean, its interface.
// first to go to congigration -> AppConfigration then create a bean of javamailsender then use @Autowired

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendMailToInviteAppAdmin(User appAdmin){
        Context context = new Context();
        context.setVariable("adminName", appAdmin.getUserName());
        context.setVariable("mainUserName", "Maint");
        context.setVariable("appName", "Zepto");
        context.setVariable("acceptUrl", "http://localhost:8080/api/v1/admin/invite/accept"+ appAdmin.getId());
        context.setVariable("rejectUrl", "https://www.google.com/");


        String htmlCode = templateEngine.process("invite-app-admin", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try{
            mimeMessageHelper.setText(htmlCode, true);
            mimeMessageHelper.setTo(appAdmin.getEmail());
            mimeMessageHelper.setSubject("Invitation Email");
        }catch (Exception e){
            log.error(e.getMessage());
        }
        javaMailSender.send(mimeMessage);


    }
}
