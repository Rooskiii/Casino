import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Games {

    //blackjack table
    public static void Blackjack(Player player, SaveData save) throws IOException {
        Scanner reader = new Scanner(System.in);
        Dealer dealer = new Dealer(100000.0);

        ColorString.clearScreen();
        
        System.out.println("Do you want to play with 5 decks or 7 decks? ");
        int numOfDecks = Input.changeStringToInt(reader.nextLine());
        numOfDecks = Input.changeIfNotFiveOrSeven(numOfDecks);
        
        int input = 0;
        while(input != 1){

            ColorString.clearScreen();
            
            //enter in bet
            System.out.println("You have $"+player.getBalance());
            System.out.println("Enter in Ante Bet. ");
            double bet = Input.betChecker(Input.changeStringToDouble(reader.nextLine()), player);
            // validation method inside validation method

            ColorString.clearScreen();
            
            MultipleDecks decks = new MultipleDecks(numOfDecks);

            //ADD HIGH LIMIT TABLES
            
            //ask user if they want to play against people or just dealer
            //make it just dealer for now
            
            decks.shuffle();
    
            //initial draw
            player.drawFaceUp(decks);
            dealer.drawFaceDown(decks);
            player.drawFaceUp(decks);
            dealer.drawFaceUp(decks);
            
            System.out.println(dealer);
            System.out.println(player);
  
            String userInput = "";
            //make blackjack table methods, if you can double
            boolean didBust = false;
            boolean[] splitBust = {false, false, false};
            if(GameMethods.canSplit(player.getHand())){
                System.out.println("Hit, Split or Stand? ");
                userInput = Input.hitSplitOrStand(reader.nextLine());
                //method with option of splitting
                splitBust = GameMethods.hitSplitAndStand(userInput, player, dealer, decks);
                GameMethods.winnerWinnerSplitTheChickenDinner(player, dealer, decks, bet, splitBust);
            } else {
                System.out.println("Hit or Stand? ");
                userInput = Input.hitOrStand(reader.nextLine());
                //method for just hitting or standing
                didBust = GameMethods.hitAndStand(userInput, player, dealer, decks);
                GameMethods.winnerWinnerChickenDinner(dealer, player, decks, bet, didBust);
            }

            if(splitBust[2] == true){
                player.returnSecondHandToDeck(decks);
            }
            
            dealer.returnHandToDeck(decks);
            player.returnHandToDeck(decks);
            
            //after the hand, if user wants to go another hand
            System.out.println("Another hand?\nEnter 0 to keep playing or 1 to go back to entrance. ");
            input = Input.changeStringToInt(reader.nextLine());
        }

        save.save(player);
        
        //call method of the entrance 
        Main.casinoEntrance(player, save);
        
    }

// _______________________________________________________________________________
// _______________________________________________________________________________
// _______________________________________________________________________________
    
    //texas holdem table
    public static void TexasHoldem(Player player) {
        
    }

    //three card poker table
    public static void threeCardPoker(Player player) {
        
    }

    //five card poker tabl
    public static void fiveCardPoker(Player player) {

    }
    
}