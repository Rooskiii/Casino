public class Card {

    private int suit;
    private int value;
    private boolean faceDown;
    
    public Card(int s, int v){
        suit = s;
        value = v;
        faceDown = true;
    }

    public Card(){
        suit = (int)(Math.random()*4+1);
        value = (int)(Math.random()*13+1);
        faceDown = true;
    }

    public char getSuitAsChar(){
        switch(this.suit){
            case 1: return 'H';
            case 2: return 'C';
            case 3: return 'S';
            case 4: return 'D';
            default: return 'n';
        }
    }

    public String getValueAsStr(){
        switch(this.value){
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return ""+this.value;
        }
    }

    public void flipFaceDown(){
        faceDown = true;
    }

    public void flipFaceUp(){
        faceDown = false;
    }
    
    public String toString(){

        if(faceDown){
            return "Unknown";
        } else {
            return getValueAsStr()+getSuitAsChar();
        }
        
    }

    public boolean isFaceDown(){
        return faceDown;
    }
    
    public int getValue(){
        return value;
    }

    public int getFaceValue(){
        
        switch(value){
            case 11: 
            case 12: 
            case 13: return 10;
            default: return value;
        }

    }
    
}