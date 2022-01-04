package com.fun.tests;

import com.fun.Card;
import com.fun.CardLearnInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTests {
    Card testCard;

    @BeforeEach
    void setUp() {
        testCard = new Card("Front test card", "Back test card");
    }


    @Test
    void getInfoFrontTest() {
        // do the actual test
        assertEquals(testCard.getFrontInfo().getTextInfo(),"Front test card","Get text info from the front of the card");
        assertEquals(testCard.getBackInfo().getTextInfo(),"Back test card","Get text info from the back of the card");
//        assertThat(testCard.getFrontInfo().getTextInfo()).isEqualToComparingFieldByFieldRecursively(new CardLearnInfo("Front test card"));
//        assertThat(testCard.getFrontInfo()).usingRecursiveComparison().isEqualTo(new CardLearnInfo("Front test card"));
    }


}
