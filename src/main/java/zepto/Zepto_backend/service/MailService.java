package zepto.Zepto_backend.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import zepto.Zepto_backend.enums.UserType;
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

    public void sendMailToInviteAdmin(User appAdmin, String invitername, String role){
        Context context = new Context();
        context.setVariable("adminName", appAdmin.getUserName());
        context.setVariable("mainUserName", invitername );
        context.setVariable("role", appAdmin.getUserType());
        if(role.equals(UserType.ZEPTO_APP_ADMIN.toString())){
            context.setVariable("acceptUrl","http://localhost:8080/api/v1/admin/invite/accept"  + appAdmin.getId());
        }
        else {
            context.setVariable("acceptUrl","http://localhost:8080/api/v1/warehouse-admin/invite/accept"  + appAdmin.getId());
        }
        context.setVariable("appName", "Zepto");

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
