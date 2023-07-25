package org.talentica.hackathon.chatgptprototype.config;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class AIConfig {

    @Value("${prototype.apikey}")
    private String apiKey;

    @Bean
    public OpenAiService openAiService() {
        return new OpenAiService(apiKey, Duration.ofSeconds(10));
    }
}
