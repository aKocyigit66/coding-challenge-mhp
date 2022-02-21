package com.mhp.coding.challenges.dependency.notifications;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class PushNotificationHandler {

    private static final Logger LOG = LoggerFactory.getLogger(PushNotificationHandler.class);
    @After("execution(* com.mhp.coding.challenges.dependency.inquiry.InquiryService.create(..))")
    public void executeAfter(JoinPoint joinPoint){
        this.sendNotification((Inquiry) joinPoint.getArgs()[0]);
    }

    public void sendNotification(final Inquiry inquiry) {
        LOG.info("Sending push notification for: {}", inquiry);
    }
}
