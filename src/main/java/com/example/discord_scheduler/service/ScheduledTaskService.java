package com.example.discord_scheduler.service;

import com.example.discord_scheduler.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduledTaskService {
    @Autowired
    private MessageService messageService;

    @Autowired
    private DiscordService discordService;

    private static final String DISCORD_CHANNEL_ID = "1000422489291227198";

    @Scheduled(fixedRate = 60000) // Check every minute
    public void sendScheduledMessages() {
        List<Message> messages = messageService.getAllMessages();
        LocalDateTime now = LocalDateTime.now();
        for (Message message : messages) {
            if (message.getScheduledDate().isBefore(now) || message.getScheduledDate().isEqual(now)) {
                // Send message to Discord
                discordService.sendMessage(DISCORD_CHANNEL_ID, message.getText());
                // Delete the message after sending
                messageService.deleteMessage(message.getId());
            }
        }
    }
}
