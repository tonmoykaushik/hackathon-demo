package org.talentica.hackathon.chatgptprototype.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.talentica.hackathon.chatgptprototype.dto.InterviewRequest;
import org.talentica.hackathon.chatgptprototype.dto.InterviewResponse;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChatService {

    private final ChatEngineService chatEngineService;
    public InterviewResponse getInterviewQuestions(InterviewRequest interviewRequest) {

        if (Objects.isNull(interviewRequest)) {
            log.error("No input obtained to generate interview questions");
            throw null;
        }
        log.info("Fetching interview questions for role : {}, language : {} and experience: {}",
                interviewRequest.getRole(), interviewRequest.getLanguage(), interviewRequest.getExperience());
        return new InterviewResponse(chatEngineService.generateInterviewQuestions(interviewRequest));
    }
}
