package com.poll.poll_app.service;

import com.poll.poll_app.entity.Poll;
import com.poll.poll_app.entity.VoteOption;
import com.poll.poll_app.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PollService {

    private final PollRepository pollRepository;

    public List<Poll> getAllPolls(){

        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id){

        return pollRepository.findById(id);
    }

    public Poll createPoll(Poll poll){

        return pollRepository.save(poll);
    }

    public void vote(Long pollId, int optionIndex){

        Poll poll = pollRepository.findById(pollId)
                .orElseThrow( () -> new RuntimeException("Error: Poll not found"));

        List<VoteOption> options = poll.getOptions();

        if(optionIndex < 0 || optionIndex >= options.size()){

            throw new IllegalArgumentException("Invalid option index");
        }

        VoteOption selectedVoteOption = options.get(optionIndex);

        selectedVoteOption.setVotes( selectedVoteOption.getVotes() + 1 );

        pollRepository.save(poll);
    }
}
