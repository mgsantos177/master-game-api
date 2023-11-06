package com.example.master.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@AllArgsConstructor
@Document(collection = "cards")
public class Card {

    @Id
    private String id;

    private String question;

    private String[] options;

    private String answer;

    private Category category;

    private Boolean isAnswered;

    public Card() {

    }

}
