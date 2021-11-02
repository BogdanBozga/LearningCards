package com.fun;

public class LearningStats {

//    -wellKnownCards : int
//-knownCards: int
//-almostKnownCards: int
//-unknownCards: int
//-hiddenCards : int
//-newCards : int

    private int wellKnownCards=0;
    private int knowCards=0;
    private int almostKnownCards=0;
    private int unknownCards=0;
    private int hiddenCards=0;
    private int newCards=0;

//    +increaseWKC() : void
//+decreaseWKC() : void
//+increaseKC() : void
//+decreaseKC() : void
//+increaseAKC() : void
//+decreaseAKC() : void

//+increaseUKC() : void
//+decreaseUKC() : void

//+increaseHC() : void
//+decreaseHC() : void

//+increaseNewCards() : void
//+decreaseNewCards() : void

    public void increaseWKC(){
        wellKnownCards++;
    }
    public void decreaseWKC(){
        wellKnownCards--;
    }
    public void increaseKC(){
        knowCards++;
    }
    public void decreaseKC(){
        knowCards--;
    }
    public void increaseAKC(){
        almostKnownCards++;
    }
    public void decreaseAKC(){
        almostKnownCards--;
    }
    public void increaseUKC(){
        unknownCards++;
    }
    public void decreaseUKC(){
        unknownCards--;
    }
    public void increaseHC(){
        hiddenCards++;
    }
    public void decreaseHC(){
        hiddenCards--;
    }
    public void increaseNewCards(){
        newCards++;
    }
    public void decreaseNewCards(){
        newCards--;
    }

}
