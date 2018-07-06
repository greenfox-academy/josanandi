package com.greenfoxacademy.reddit.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;
    private LocalDateTime timestamp;
    private Long score;
    private String owner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    public List<Vote> vote;

    public Post() {
        this.timestamp = LocalDateTime.now();
        this.score = 0L;
        vote = new ArrayList<>();
    }



    public void setTimeStamp(LocalDateTime now) {
        this.timestamp = now;
    }


    public void setScoreUpvote() {
        this.score += 1;
    }

    public void setScoreDownVote() {
        this.score -= 1;
    }

}
