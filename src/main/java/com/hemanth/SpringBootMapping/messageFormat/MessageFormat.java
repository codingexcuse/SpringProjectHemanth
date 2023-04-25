package com.hemanth.SpringBootMapping.messageFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageFormat
{
    private int statusCode;
    private String message;

    private Long timeStamp;
}
