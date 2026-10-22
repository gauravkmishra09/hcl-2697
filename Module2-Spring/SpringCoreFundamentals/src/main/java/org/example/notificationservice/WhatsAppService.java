package org.example.notificationservice;

import org.springframework.stereotype.Component;

@Component
public class WhatsAppService implements NotificationService {
    @Override
    public void sendMsg(String msg) {
        System.out.println("WhatsApp Service: " + msg);
    }
}