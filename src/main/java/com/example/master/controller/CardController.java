package com.example.master.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.master.dto.CardCreationDTO;
import com.example.master.entity.Card;
import com.example.master.entity.Category;
import com.example.master.service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping()
    public List<Card> listCard() {
        return cardService.getCards();
    }

    @GetMapping({ "/{category}" })
    public Card findRandomUnansweredCardByCategory(@PathVariable("category") Category category) {
        return cardService.findRandomUnansweredCardByCategory(category);
    }

    @PutMapping({ "/{id}" })
    public void findRandomUnansweredCardByCategory(@PathVariable("id") String _id) {
        cardService.markCardAsAnswered(_id);
    }

    @PostMapping()
    public void createCard(@RequestBody CardCreationDTO cardDTO) {
        cardService.createCard(cardDTO);
    }

}
