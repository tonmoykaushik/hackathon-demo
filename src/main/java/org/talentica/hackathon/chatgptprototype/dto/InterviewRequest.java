package org.talentica.hackathon.chatgptprototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewRequest {

    private String language;
    private String role;
    private int experience;

}
