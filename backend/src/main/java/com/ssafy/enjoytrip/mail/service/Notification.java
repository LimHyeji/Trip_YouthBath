package com.ssafy.enjoytrip.mail.service;

import com.ssafy.enjoytrip.mail.dto.Message;

import javax.mail.MessagingException;
import java.util.List;

public interface Notification {
    public void sendNotification(Message message) throws MessagingException;
}
