package com.douban.util.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by ruikai.lin  on 2018/4/25 下午5:45.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
@Component
public class AsyncTask {
    private static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Value("${spring.mail.username}")
    private String fromMail;

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(String subject, String content, String[] senders) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        try {
            message.setTo(senders);
            message.setFrom(fromMail);//这里必须是配置文件中的邮箱，因为此邮箱已开启了smtp服务
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(mimeMessage);
            logger.info("发送邮件成功！");
        } catch (MessagingException e) {
            logger.info("发送邮件失败 {}", e);
        }
    }
}
