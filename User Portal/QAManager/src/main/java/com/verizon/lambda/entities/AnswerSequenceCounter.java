package com.verizon.lambda.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AnswerSequenceCounter")
public class AnswerSequenceCounter {
    @Id
    private String id;
    private int seq;

    public String getId() {
        return id;
    }

    public int getSeq() {
        return seq;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

}