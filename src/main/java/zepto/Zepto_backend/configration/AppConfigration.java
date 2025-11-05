package zepto.Zepto_backend.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;

import java.util.Properties;

@Configuration
public class AppConfigration {
    @Bean
    public JavaMailSender createJavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("your-email@example.com");
        javaMailSender.setPassword("your-password");
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smpt.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return javaMailSender;
    }

    @Bean
    public TemplateEngine createTemplateEnging(){
        return new TemplateEngine();
    }
}
