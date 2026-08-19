package com.poll.poll_app.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VoteRequest {

    private Long pollId;
    private int optionIndex;
}
