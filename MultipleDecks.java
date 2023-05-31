import java.util.ArrayList;
public class MultipleDecks {

    private ArrayList<Card> bigDeck;

    public MultipleDecks(int size){

        bigDeck = new ArrayList<>();
        
        for(int i = 0; i < size; i++){

            for(int j = 1; j <= 4; j++){

                for(int k = 1; k <= 13; k++){

                    bigDeck.add(new Card(j, k));
                    
                }
                
            }
            
        }
        
    }

    public void shuffle(){

        ArrayList<Card> firstHalf = new ArrayList<>();
        ArrayList<Card> secondHalf = new ArrayList<>();

        //split the deck in half and alternate
        for(int i = 0; i < bigDeck.size(); i++){
            if(i < bigDeck.size()/2){
                firstHalf.add(bigDeck.get(i));
            } else if(i >= bigDeck.size()/2){
                secondHalf.add(bigDeck.get(i));
            }       
        }

        bigDeck.clear();

        int i = 0;
        while(i < firstHalf.size()){
            bigDeck.add(firstHalf.get(i));
            bigDeck.add(secondHalf.get(i));
            i++;
        }

        //random shuffle
        ArrayList<Card> temp = new ArrayList<Card>();

        while(bigDeck.size() != 0){

            int random = (int)(Math.random()*bigDeck.size());                    
            temp.add(bigDeck.get(random));
            bigDeck.remove(random);
            
        }

        for(int j = 0; j < temp.size(); j++){
            bigDeck.add(temp.get(j));
        }
        
        //move bottom half to the top
           
    }

    public String toString(){
        String temp = "";

        for(int i = 0; i < bigDeck.size(); i++){
            temp += bigDeck.get(i).toString();
            temp += " ";
        }
        return temp;
    }

    public Card drawCardFaceUp(){
        bigDeck.get(0).flipFaceUp();
        Card returnCard = bigDeck.get(0);
        bigDeck.remove(0);
        return returnCard;
    }

    public Card drawCardFaceDown(){
        bigDeck.get(0).flipFaceDown();
        Card returnCard = bigDeck.get(0);
        bigDeck.remove(0);
        return returnCard;
    }

    public void addHand(Hand hand){
        for(int i = hand.getSize()-1; i >= 0; i--){
            bigDeck.add(hand.getCard(i));
            hand.removeCard(i);
        }
    }
    
}