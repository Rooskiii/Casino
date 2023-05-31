public class Person {

    private double balance;
    private Hand hand;
    private Hand secondHand; //for black jack, splitting
    private String name;
    
    public Person(String n, double b) {
        name = n;
        balance = b;
        hand = new Hand();
        secondHand = new Hand();
    }

    public Person(String n) {
        name = n;
        balance = 0;
        hand = new Hand();
        secondHand = new Hand();
    }
    
    public Person(double b) {
        balance = b;
        hand = new Hand();
        secondHand = new Hand();
    }
    
    public Person() {
        balance = 0;
        hand = new Hand();
        secondHand = new Hand();
    }

    public void setBalance(double b){
        balance = b;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }
    
    public void lost(double bet){
        this.balance -= bet;
    }

    public void won(double bet){
        this.balance += bet;
    }
    
    //method to display face score, for bj
    public int handScore(){
        hand.handScore();
        return hand.getFaceValueScore();
    }

    public int secondHandScore(){
        secondHand.handScore();
        return secondHand.getFaceValueScore();
    }
    
    //puts the hand back into deck
    //going to confict with blackjack, make new method
    public void returnHandToDeck(Deck deck){
        deck.addHand(hand);
    }

    public void returnHandToDeck(MultipleDecks deck){
        deck.addHand(hand);
    }

    public void returnHandsToDeck(MultipleDecks deck){
        deck.addHand(hand);
        deck.addHand(secondHand);
    }

    public void returnSecondHandToDeck(MultipleDecks deck){
        deck.addHand(secondHand);
    }
    
    public Hand getHand(){
        return hand;
    }

    public Hand getSecondHand(){
        return secondHand;
    }

    public String toString(){
        String total = ""+getHand();

        if(hand.anyFaceDown()){
            return name+": "+total;
        } else {
            return name+" "+handScore()+": "+total;
        }
        
    }

    public void showBothHands(){
        String first = ""+getHand();
        String second = ""+getSecondHand();

        System.out.println("1) "+name+" "+handScore()+": "+first);
        System.out.println("2) "+name+" "+secondHandScore()+": "+second);
        
    }

    //add a card from deck to a hand
    public void drawFaceUp(Deck deck){
        hand.addCard(deck.drawCardFaceUp());
    }

    public void drawFaceDown(Deck deck){
        hand.addCard(deck.drawCardFaceDown());
    }

    //overloaded method for the multiple deck object
    public void drawFaceUp(MultipleDecks deck){
        hand.addCard(deck.drawCardFaceUp());
    }

    public void drawFaceDown(MultipleDecks deck){
        hand.addCard(deck.drawCardFaceDown());
    }

    //for the second hand
    public void drawSecondFaceUp(MultipleDecks deck){
        secondHand.addCard(deck.drawCardFaceUp());
    }

    public void drawSecondFaceDown(MultipleDecks deck){
        secondHand.addCard(deck.drawCardFaceDown());
    }

    //overloaded method for the multiple deck object
    public void drawCardsFaceUp(int numCards, MultipleDecks deck){
        for(int i = 0; i < numCards; i++){
            hand.addCard(deck.drawCardFaceUp());
        }
    }

    public void drawCardsFaceDown(int numCards, MultipleDecks deck){
        for(int i = 0; i < numCards; i++){
            hand.addCard(deck.drawCardFaceDown());
        }
    }
    
    public void drawCardsFaceUp(int numCards, Deck deck){
        for(int i = 0; i < numCards; i++){
            hand.addCard(deck.drawCardFaceUp());
        }
    }

    public void drawCardsFaceDown(int numCards, Deck deck){
        for(int i = 0; i < numCards; i++){
            hand.addCard(deck.drawCardFaceDown());
        }
    }

    public void showYourHand(){
        hand.showHand();
    }

    public void showSecondHand(){
        secondHand.showHand();
    }

    public void addCardToSecond(){
        secondHand.addCard(hand.removeCard(0));
    }
    
}