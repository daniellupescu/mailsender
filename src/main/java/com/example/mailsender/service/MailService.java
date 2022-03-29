package com.example.mailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * MailService
 */
@Service
public class MailService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MailService.class);

    @Value("${mail.encoding}")
    private String encoding;

    @Value("${mail.from}")
    private String from;

    @Value("${mail.recipient}")
    private String recipient;

    @Value("${mail.subject}")
    private String subject;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * Send email to recipient declared in application.yml
     */
    public void sendMail() {
        Context context = new Context();
        context.setVariable("recipient", recipient);
        String process = templateEngine.process("emails/email_template", context);

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, encoding);
            messageHelper.setFrom(from);
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(process, true);
        };

        mailSender.send(messagePreparator);
        LOGGER.info("Email sent to {}", recipient);
    }
}