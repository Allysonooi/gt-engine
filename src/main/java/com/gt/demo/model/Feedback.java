package com.gt.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Feedback {
    private String sentiment;

    private String feedback;

    private String status;

    private Integer time;
}
