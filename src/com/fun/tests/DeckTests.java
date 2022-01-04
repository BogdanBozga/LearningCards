package com.fun.tests;

import com.fun.Card;
import com.fun.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTests {

    Deck deckTest;

    @BeforeEach
    void setUp() {

        deckTest = new Deck("Deck test");
    }


    @Test
    void getInfoFrontTest() {

        assertEquals(deckTest.getTotalCardsNumber(),0,"Number cards equal 0");
//        assertThat(testCard.getFrontInfo().getTextInfo()).isEqualToComparingFieldByFieldRecursively(new CardLearnInfo("Front test card"));
//        assertThat(testCard.getFrontInfo()).usingRecursiveComparison().isEqualTo(new CardLearnInfo("Front test card"));
    }


}
