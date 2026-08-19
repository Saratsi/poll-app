package com.poll.poll_app.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class VoteOption {

    private String optionText;
    private Long votes= 0L;
}
