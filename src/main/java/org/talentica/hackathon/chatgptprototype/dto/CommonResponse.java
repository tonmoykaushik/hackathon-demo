package org.talentica.hackathon.chatgptprototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private String code;
    private String message;
    private Object data;

}
