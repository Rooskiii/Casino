import java.util.ArrayList;
public class Deck {

    private ArrayList<Card> deck;
    
    public Deck(int desiredDecks){
        deck = new ArrayList<>();

        for(int x = 0; x < desiredDecks; x++){
            for(int i = 1; i <= 4; i++){
                for(int j = 1; i <= 13; j++){
                    deck.add(new Card(i, j));
                }
            }
        }
    }

    public Deck(){
        deck = new ArrayList<>();
        
        for(int i = 1; i <= 4; i++){
            for(int j = 1; i <= 13; j++){
                deck.add(new Card(i, j));
            }
        }
    }

    //shuffles the deck
    //work on the shuffle method
    public void shuffle(){
        
        ArrayList<Card> tempDeck = new ArrayList<>();

        for(int i = 0; i < deck.size(); i++){
            int random = (int)(Math.random()*deck.size());

            tempDeck.add(deck.get(random));
            deck.remove(random);
        }

        for(int i = tempDeck.size()-1; i >= 0; i--){
            deck.add(tempDeck.get(i));
        }

    }
                
    //returns it into a string
    public String toString(){
        String total = "";
        
        for(int i = 0; i < this.deck.size(); i++){
            total += deck.get(i);
            total += " ";
        }

        return total;

    }

    //draws card from the top of the deck
    public Card drawCardFaceUp(){
        deck.get(0).flipFaceUp();
        Card returnCard = deck.get(0);
        deck.remove(0);
        return returnCard;
    }

    public Card drawCardFaceDown(){
        deck.get(0).flipFaceDown();
        Card returnCard = deck.get(0);
        deck.remove(0);
        return returnCard;
    }

    //adds cards from hand back into the deck;
    public void addHand(Hand hand){
        for(int i = 0; i < hand.getSize(); i++){
            hand.getCard(i).flipFaceDown();
            deck.add(hand.getCard(i));
            hand.removeCard(i);
        }
    }
    
}