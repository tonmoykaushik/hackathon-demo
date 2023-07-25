package org.talentica.hackathon.chatgptprototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talentica.hackathon.chatgptprototype.dto.CommonResponse;
import org.talentica.hackathon.chatgptprototype.dto.InterviewRequest;
import org.talentica.hackathon.chatgptprototype.dto.InterviewResponse;
import org.talentica.hackathon.chatgptprototype.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/landing")
    public ResponseEntity<CommonResponse> welcome() {
        CommonResponse response = new CommonResponse("SUCCESS", "Welcome to Prototype!!", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<CommonResponse> getInterviewQuestions(@RequestBody InterviewRequest interviewRequest) {
        InterviewResponse interviewResponse = chatService.getInterviewQuestions(interviewRequest);
        CommonResponse response = new CommonResponse("SUCCESS", "Welcome to Prototype!!", interviewResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
