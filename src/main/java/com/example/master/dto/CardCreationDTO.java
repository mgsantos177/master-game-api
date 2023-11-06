package com.example.master.dto;

import com.example.master.entity.Card;
import com.example.master.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardCreationDTO {

    private String question;

    private String[] options;

    private String answer;

    private String category;

    public Card createCard() {
        Card card = new Card();

        card.setQuestion(question);
        card.setAnswer(answer);
        card.setCategory(Category.valueOf(category));
        card.setIsAnswered(false);

        if (options == null) {
            card.setOptions(new String[0]);
        } else {
            card.setOptions(options);
        }

        return card;

    }
}
