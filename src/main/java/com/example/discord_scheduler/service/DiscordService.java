package com.example.discord_scheduler.service;

import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscordService {

    @Value("${discord.token}")
    private String token;

    private JDA jda;

    @PostConstruct
    public void init() throws Exception {
        jda = JDABuilder.createDefault(token).build();
    }

    public void sendMessage(String channelId, String message) {
        jda.getTextChannelById(channelId).sendMessage(message).queue();
    }
}
