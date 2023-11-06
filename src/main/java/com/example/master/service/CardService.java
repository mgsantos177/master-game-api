package com.example.master.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.master.dto.CardCreationDTO;
import com.example.master.entity.Card;
import com.example.master.entity.Category;
import com.example.master.repository.CardRepository;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void createCard(CardCreationDTO cardDTO) {

        Card card = cardDTO.createCard();
        cardRepository.save(card);
    }

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public Card findRandomUnansweredCardByCategory(Category category) {
        List<Card> cards = cardRepository.findRandomUnansweredByCategory(category);

        if (!cards.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(cards.size());
            Card randomCard = cards.get(randomIndex);

            return randomCard;
        }

        return null;
    }

    public void markCardAsAnswered(String _id) {
        Card findCard = cardRepository.findById(_id).orElse(null);
        findCard.setIsAnswered(true);
        cardRepository.save(findCard);
    }

}
