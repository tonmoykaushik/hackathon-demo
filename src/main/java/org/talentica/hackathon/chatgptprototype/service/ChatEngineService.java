package org.talentica.hackathon.chatgptprototype.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.talentica.hackathon.chatgptprototype.dto.InterviewRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChatEngineService {

    private final OpenAiService openAiService;

    private final static String USER_ROLE = "user";
    private final static String SYSTEM_ROLE = "system";
    private final static String SYSTEM_MESSAGE = "You are an API server that responds with a list of statements. Don't say anything else. Every statement should be within 20 words.\n" +
            "Send maximum 3 statements. The user will provide you with a coding language, a role and an experience level. You must suggest a list of interview questions for that combination.";


    public List<String> generateInterviewQuestions(InterviewRequest interviewRequest) {
        ChatCompletionRequest request = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .maxTokens(200)
                .temperature(0.7)
                .messages(List.of(
                        new ChatMessage(SYSTEM_ROLE, SYSTEM_MESSAGE),
                        new ChatMessage(USER_ROLE, String.format("Give me interview questions for coding language %s for role %s and experience %s years",
                                interviewRequest.getLanguage(), interviewRequest.getRole(), interviewRequest.getExperience()))
                ))
                .build();
        // Calling Open AI API
//        openAiService.createChatCompletion(request).getChoices()
//                .forEach(chatCompletionChoice -> results.add(chatCompletionChoice.getMessage().getContent()));

        String content = openAiService.createChatCompletion(request).getChoices().get(0).getMessage().getContent();
        List<String> results = content.lines().collect(Collectors.toList());
        log.info("Obtained results : {}", results);
        return results;
    }
}
