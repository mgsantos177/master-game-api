package com.example.master.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.master.entity.Card;
import com.example.master.entity.Category;

public interface CardRepository extends MongoRepository<Card, String> {

    @Query(value = "{'category': ?0, 'isAnswered': false}")
    List<Card> findRandomUnansweredByCategory(Category category);

    @Query("{'_id' : ?0}")
    void markCardAsAnswered(String cardId);
}
