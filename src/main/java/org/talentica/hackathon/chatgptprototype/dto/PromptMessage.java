package org.talentica.hackathon.chatgptprototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptMessage {
    private String role;
    private String content;
}
