package com.poll.poll_app.controller;

import com.poll.poll_app.entity.Poll;
import com.poll.poll_app.request.VoteRequest;
import com.poll.poll_app.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class PollController {

    private final PollService pollService;

    @GetMapping
    public List<Poll> getAllPolls(){

        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id){

        return pollService.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){

        return pollService.createPoll(poll);
    }

    @PostMapping("/vote")
    public void vote(@RequestBody VoteRequest vote){

        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}
