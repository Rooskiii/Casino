import java.util.ArrayList;
public class Hand {

    private ArrayList<Card> cards;
    private int faceValueScore;

    public Hand(int size){
        cards = new ArrayList<>(size);
        faceValueScore = 0;
    }

    public Hand(){
        cards = new ArrayList<>();
        faceValueScore = 0;
    }

    //scores the hand
    public void handScore(){
        resetFaceValueScore();
        for(int i = 0; i < cards.size(); i++){
            //make if else
            // if card.getFaceValue == 1, if value score is less than or
            // equals to 11, add 11, anything above 11 add 1

            if(cards.get(i).getFaceValue() == 1 && faceValueScore < 11){
                faceValueScore += 11;
            } else if(cards.get(i).getFaceValue() == 1 && faceValueScore >= 11){
                faceValueScore += 1;
            } else {
                faceValueScore += cards.get(i).getFaceValue();    
            }
            
        }
        
    }

    public boolean anyFaceDown(){

        for(Card card : cards){
            if(card.isFaceDown()){
                return true;
            }
        }

        return false;
        
    }
    
    public void resetFaceValueScore(){
        faceValueScore = 0;
    }
    
    //returns the face value score of the cards
    public int getFaceValueScore(){
        return faceValueScore;
    }
    
    //returns the size of the hand
    public int getSize(){
        return cards.size();
    }

    //return a Card Object at the specified location
    public Card getCard(int x){
        return cards.get(x);
    }

    //adds a card to the end of the hand
    public void addCard(Card card){
        cards.add(card);
    }

    //returns true if the card has been set at specified index
    public boolean setCard(int x, Card card){
        cards.set(x, card);
        return true;
    }

    //returns hand in string format
    public String toString(){
        String total = "";
        for(int i = 0; i < cards.size(); i++){
            total += cards.get(i);
            total += " ";
        }

        return total;
    }

    //remove card at specified location
    public Card removeCard(int i){
        return cards.remove(i);
    }

    public void showHand(){
        for(int i = 0; i < cards.size(); i++){
            cards.get(i).flipFaceUp();
        }
    }
    
}