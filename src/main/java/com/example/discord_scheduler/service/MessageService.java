package com.example.discord_scheduler.service;

import com.example.discord_scheduler.model.Message;
import com.example.discord_scheduler.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
