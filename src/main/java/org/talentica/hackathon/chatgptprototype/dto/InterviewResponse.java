package org.talentica.hackathon.chatgptprototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewResponse {
    private List<String> questions;
}
