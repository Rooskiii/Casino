import java.util.Scanner;
import java.util.ArrayList;
public class GameMethods {

    //if the player can split the cards
    public static boolean canSplit(Hand hand){
        
        if(hand.getCard(0).getValue() == hand.getCard(1).getValue()){
            return true;
        } else {
            return false;
        }
        
    }

    //winner conditions for the split
    public static void winnerWinnerSplitTheChickenDinner(Player player, Dealer dealer, MultipleDecks decks, double bet, boolean[] splitBust){

        ColorString.clearScreen();
        
        boolean didDealerBust = false; //false if stood for arr
        if(splitBust[2]){ //if split
            //if both busted - lose double their bet
            if(splitBust[0] && splitBust[1]){
                dealer.showYourHand();
                System.out.println(dealer);
                player.showBothHands();
                System.out.println("You busted both of your hands.");
                System.out.println("1) -"+(bet)+". 2) -"+bet);
                player.lost(bet*2);
            } else if(splitBust[0] && !splitBust[1]){ //if first busted, second stood
                dealer.showYourHand();

                //if the player does not get 21 - check for push, if dealer hand is greater or player hand is greater, else dealer plays for 21
                if(player.secondHandScore() != 21){
                    //make a method for the dealer to try to get 21
                    didDealerBust = GameMethods.dealerMethod(dealer, player, decks);
                    //put whats inside the conditions last
                    if(didDealerBust){
                        //dealer loses, player wins
                        System.out.println(dealer);
                        player.showBothHands();
                        System.out.println("Your first hand busted with "+player.handScore()+", but your second hand wins with "+player.secondHandScore()+" against the Dealer because they busted.");
                        System.out.println("1) -"+(bet)+". 2) +"+(bet*2));
                        player.won(bet*2);
                    } else if(!didDealerBust){
                        //if dealer pushed
                        if(player.secondHandScore() == dealer.handScore()){
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your first hand busted, and but your second hand pushed against the Dealer.");
                            System.out.println("1) -"+(bet)+". 2) 0");
                            player.lost(bet);
                        //if dealer has greater score than player
                        } else if(dealer.handScore() > player.secondHandScore()){
                            //dealer wins, player loses
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("You first hand busted and the Dealer had a better score than your second hand.");
                            System.out.println("1) -"+(bet)+". 2) -"+bet);
                            player.lost(bet*2);
                        //if player has greater score than dealer
                        } else if(player.secondHandScore() > dealer.handScore()){
                            //player wins, dealer loses
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your first hand busted with "+player.handScore()+", but your second hand had a higher score than the Dealer.");
                            System.out.println("1) -"+(bet)+". 2) +"+(bet*2));
                            player.won(bet*2);
                            player.lost(bet);
                        }
                    }
                    
                } else {
                    //change method to roll for 21 when made
                    didDealerBust = GameMethods.dealerMethod(dealer, player, decks);
                    if(!didDealerBust){
                        if(dealer.handScore() == 21){
                            //player gets pushed by dealer
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your first hand busted, but your second hand got pushed by the Dealer with 21. ");
                            System.out.println("1) -"+(bet)+". 2) 0");
                            player.lost(bet);
                        } else {
                            //player wins
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your first hand busted, but your second hand with 21 beat the Dealer.");
                            System.out.println("1) -"+(bet)+". 2) +"+(bet*2));
                            player.won(bet*2);
                            player.lost(bet);
                        }
                    } else {
                        //player wins
                        System.out.println(dealer);
                        player.showBothHands();
                        System.out.println("Your first hand busted, but your second hand with 21 beat the Dealer because the Dealer busted. ");
                        System.out.println("1) -"+(bet)+". 2) +"+(bet*2));
                        player.won(bet*2);
                        player.lost(bet);
                    }
                }     
            } else if(!splitBust[0] && splitBust[1]){ //if first stood, second busted
                dealer.showYourHand();

                if(player.handScore() != 21){
                    didDealerBust = GameMethods.dealerMethod(dealer, player, decks);
                    //put whats inside the conditions last
                    if(didDealerBust){
                        //dealer loses, player wins
                        System.out.println(dealer);
                        player.showBothHands();
                        System.out.println("Your second hand went bust when rolling, but your first hand won because the Dealer busted.");
                        System.out.println("1) +"+(bet*2)+". 2) -"+bet);
                        player.won(bet*2);
                        player.lost(bet);
                    } else if(!didDealerBust){
                        //if dealer pushed
                        if(player.handScore() == dealer.handScore()){
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your second hand initially went bust from rolling, but your first hand pushed with the Dealer. ");
                            System.out.println("1) 0. 2) -"+bet);
                            player.lost(bet);
                        //if dealer has greater score than player
                        } else if(dealer.handScore() > player.handScore()){
                            //dealer wins, player loses
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your second hand initially went bust from rolling. The Dealer won against your first hand because they had a higher score.");
                            System.out.println("1) -"+bet+". 2) -"+bet);
                            player.lost(bet*2);
                        //if player has greater score than dealer
                        } else if(player.handScore() > dealer.handScore()){
                            //player wins, dealer loses
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your second hand initially went bust from rolling. Your first hand won against the Dealer because you had a higher score.");
                            System.out.println("1) +"+(bet*2)+". 2) -"+bet);
                            player.won(bet*2);
                            player.lost(bet);
                        }
                    }
                    
                } else {
                    didDealerBust = GameMethods.dealerMethod(dealer, player, decks);
                    if(!didDealerBust){
                        if(dealer.handScore() == 21){
                            //player gets pushed by dealer
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your second hand initially went bust from rolling. Your first hand had been pushed by the Dealer because they got 21.");
                            System.out.println("1) 0. 2) -"+bet);
                            player.lost(bet);
                        } else {
                            //player wins
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Your second hand initially went bust from rolling. Your first hand won against the Dealer because they couldn't get 21.");
                            System.out.println("1) +"+(bet*2)+". 2) -"+bet);
                            player.won(bet*2);
                            player.lost(bet);
                        }
                    } else {
                        //player wins, dealer went bust
                        System.out.println(dealer);
                        player.showBothHands();
                        System.out.println("Your second hand initially went bust from rolling. Your first hand won against the Dealer because they busted trying to get 21.");
                        System.out.println("1) +"+(bet*2)+". 2) -"+bet);
                        player.won(bet*2);
                        player.lost(bet);
                    }
                }     
                
            } else if(!splitBust[0] && !splitBust[1]){

                dealer.showYourHand();

                //if both hands != 21
                if(player.handScore() != 21 && player.secondHandScore() != 21){

                    didDealerBust = GameMethods.dealerMethod(dealer, player, decks);
                    
                    //dealer pushes both hands
                    if(player.handScore() == dealer.handScore() && player.secondHandScore() == dealer.handScore()){

                        if(!didDealerBust){
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("Both of your hands pushed the Dealer.");
                            System.out.println("1) 0. 2) 0.");
                        }
                        
                    } else if(player.handScore() == dealer.handScore() && player.secondHandScore() != dealer.handScore()){ //first pushes -- another if else chain inside for second
                        //check if the dealer busted
                        if(!didDealerBust){
                            //dealer pushed first hand, check score with second
                            if(player.secondHandScore() < dealer.handScore()){
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your first hand pushed the dealer. Your second hand lost to a higher score of the Dealer.");
                                System.out.println("1) 0. 2) -"+bet);
                                player.lost(bet);
                            } else if(player.secondHandScore() > dealer.handScore()){
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your first hand pushed the dealer. Your second hand won with a higher than the Dealer.");
                                System.out.println("1) 0. 2) +"+(bet*2));
                                player.won(bet*2);
                            } else if(player.secondHandScore() == dealer.handScore()){
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your first hand pushed the dealer. Your second hand also pushed the Dealer.");
                                System.out.println("1) 0. 2) 0.");
                            }
                        }
                        
                    } else if(player.handScore() != dealer.handScore() && player.secondHandScore() == dealer.handScore()){ //second pushes -- another if else chain inside for first
                        if(!didDealerBust){
                            //dealer pushed first hand, check score with second
                            if(player.handScore() < dealer.handScore()){
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your second hand pushed the dealer. Your first hand lost to a higher score of the Dealer.");
                                System.out.println("1) -"+(bet)+". 2) 0.");
                                player.lost(bet);
                            } else if(player.handScore() > dealer.handScore()){
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your second hand pushed the dealer. Your first hand won with a higher than the Dealer.");
                                System.out.println("1) +"+(bet*2)+". 2) 0.");
                                player.won(bet*2);
                            } else if(player.handScore() == dealer.handScore()){
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your second hand pushed the dealer. Your first hand also pushed the Dealer.");
                                System.out.println("1) 0. 2) 0.");
                            }
                        }
                        
                    } else if(player.handScore() != dealer.handScore() && player.secondHandScore() != dealer.handScore()){

                        if(!didDealerBust){
                            if(player.handScore() > dealer.handScore() && player.secondHandScore() > dealer.handScore()){ // both wins
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Both of your hands had a higher score than the Dealer's hand.");
                                System.out.println("1) +"+(bet*2)+". 2) +"+(bet*2));
                                player.won(bet*4);
                            } else if(player.handScore() < dealer.handScore() && player.secondHandScore() > dealer.handScore()){ // second wins
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your first hand had a smaller score than the Dealer, but your second hand was greater.");
                                System.out.println("1) -"+(bet)+". 2) +"+(bet*2));
                                player.won(bet*2);
                                player.lost(bet);
                            } else if(player.handScore() > dealer.handScore() && player.secondHandScore() < dealer.handScore()){ //first wins
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Your first hand has a higher score than the Dealer, but your second hand a smaller score.");
                                System.out.println("1) +"+(bet*2)+". 2) -"+bet);
                                player.won(bet*2);
                                player.lost(bet);
                            } else if(player.handScore() < dealer.handScore() && player.secondHandScore() < dealer.handScore()){ //both lose
                                System.out.println(dealer);
                                player.showBothHands();
                                System.out.println("Both of your hands had a lower score than the Dealer, you lost both of your hands.");
                                System.out.println("1) -"+(bet)+". 2) -"+bet);
                                player.lost(bet*2);
                            }
                        } else { //player wins because dealer busted
                            System.out.println(dealer);
                            player.showBothHands();
                            System.out.println("You won both of your hands because the Dealer busted their hand.");
                            System.out.println("1) +"+(bet*2)+". 2) +"+(bet*2));
                            player.won(bet*4);
                        }
                    } 
                }
            }

        } else {
            winnerWinnerChickenDinner(dealer, player, decks, bet, splitBust[0]);
        }   
        
    }

    //winner conditions for regular hand -- maybe redo method
    public static void winnerWinnerChickenDinner(Dealer dealer, Player player, MultipleDecks decks, double bet, boolean didBust){

        ColorString.clearScreen();
        
        boolean didDealerBust = false;
            if(didBust){
                //dealer flips card, he wins with it.
                dealer.showYourHand();
                System.out.println(dealer);
                System.out.println(player);
                player.lost(bet);
                System.out.println("Dealer wins with "+(dealer.handScore())+". You lost "+bet);
            } else if(!didBust && player.handScore() == 21){ //if you didnt bust and you have 21, dealer must play to get 21, loses if he busts
                dealer.showYourHand();
                GameMethods.dealerMethod(dealer, player, decks);
                if(dealer.handScore() == 21){
                    System.out.println(dealer);
                    System.out.println(player);
                    System.out.println("The Dealer pushed, you get your "+bet+" back. ");
                } else {
                    player.won(bet*2);
                    System.out.println(dealer);
                    System.out.println(player);
                    System.out.println("You won with 21, you won "+bet);
                }
                
            } else if(!didBust && player.handScore() == dealer.handScore()){
                
                if(dealer.handScore() >= 17){
                    dealer.showYourHand();
                    System.out.println(dealer);
                    System.out.println(player);
                    System.out.println("You and the Dealer pushed with "+player.handScore()+". You get your "+bet+" back.");        
                } else if(dealer.handScore() < 17){
                    dealer.showYourHand();
                    didDealerBust = GameMethods.dealerMethod(dealer, player, decks);
                    if(didDealerBust){
                        player.won(bet*2);
                        System.out.println(dealer);
                        System.out.println(player);
                        System.out.println("The Dealer busted, you won "+bet);
                    } else if(!didDealerBust && player.handScore() > dealer.handScore()){
                        player.won(bet*2);
                        System.out.println(dealer);
                        System.out.println(player);
                        System.out.println("You had a higher score than the Dealer, you won "+bet);
                    } else if(!didDealerBust && player.handScore() < dealer.handScore()){
                        player.lost(bet);
                        System.out.println(dealer);
                        System.out.println(player);
                        System.out.println("You lost, the Dealer had a score than you, you lost "+bet);
                    }
                }
                
            } else {
                dealer.showYourHand();
                didDealerBust = GameMethods.dealerMethod(dealer, player, decks);
                if(didDealerBust){
                    player.won(bet*2);
                    System.out.println(dealer);
                    System.out.println(player);
                    System.out.println("The Dealer busted, you won "+bet);
                } else if(!didDealerBust && player.handScore() > dealer.handScore()){
                    player.won(bet*2);
                    System.out.println(dealer);
                    System.out.println(player);
                    System.out.println("You had a higher score than the Dealer, you won "+bet);
                } else if(!didDealerBust && player.handScore() < dealer.handScore()){
                    player.lost(bet);
                    System.out.println(dealer);
                    System.out.println(player);
                    System.out.println("You lost, the Dealer had a score than you, you lost "+bet);
                }
                
                //dealer method when player did not bust and standed
            }
        
    }
    
    public static boolean hitAndStand(String input, Player player, Dealer dealer, MultipleDecks decks){
        Scanner reader = new Scanner(System.in);

        ColorString.clearScreen();

        if(player.handScore() == 21){
            return false;
        }
        
        //need to make a faceValueScore for the cards
        while(!input.equalsIgnoreCase("stand")){

            ColorString.clearScreen();
            
            player.drawFaceUp(decks);
            System.out.println(dealer);
            System.out.println(player);
            
            if(player.handScore() > 21){
                System.out.println("You busted. ");
                return true;
            }

            System.out.println("Hit or Stand? ");
            input = Input.hitOrStand(reader.nextLine());

        }

        return false;
        
    }

    //dealer plays   
    public static boolean dealerMethod(Dealer dealer, Player player, MultipleDecks decks){

        while(dealer.handScore() < 17){

            dealer.drawFaceUp(decks);
            System.out.println(dealer);
            System.out.println(player);

            ColorString.clearScreen();
            
            if(dealer.handScore() > 21){
                return true;
            }
            
        }

        return false;
        
    }

    public static boolean[] hitSplitAndStand(String input, Player player, Dealer dealer, MultipleDecks decks){
        Scanner reader = new Scanner(System.in);
        boolean [] arr = {false, false, false}; // 3rd element, #2 of index, whether the user split or not
                                                //true if split
        
        //utilize in split the hitAndStand method
        ColorString.clearScreen();
        
        if(input.equalsIgnoreCase("split")){

            arr[2] = true;
            
            player.addCardToSecond();

            System.out.println(dealer);
            player.showBothHands();
            System.out.println("1) Hit or Stand? ");
            input = Input.hitOrStand(reader.nextLine());
            
            while(!input.equalsIgnoreCase("stand")){
                
                ColorString.clearScreen();
                
                player.drawFaceUp(decks);
                System.out.println(dealer);
                player.showBothHands();

                if(player.handScore() > 21){
                    System.out.println("You busted. ");
                    arr[0] = true;
                    break;
                }

                System.out.println("1) Hit or Stand? ");
                input = Input.hitOrStand(reader.nextLine());
                
            }

            System.out.println(dealer);
            player.showBothHands();
            System.out.println("2) Hit or Stand? ");
            input = Input.hitOrStand(reader.nextLine());
            
            while(!input.equalsIgnoreCase("stand")){

                ColorString.clearScreen();
                
                player.drawSecondFaceUp(decks);
                System.out.println(dealer);
                player.showBothHands();

                if(player.secondHandScore() > 21){
                    System.out.println("You busted. ");
                    arr[1] = true;
                    break;
                }

                System.out.println("2) Hit or Stand? ");
                input = Input.hitOrStand(reader.nextLine());
                
            }

        } else {
            
            arr[0] = GameMethods.hitAndStand(input, player, dealer, decks);
            
        }
        
        return arr;
        
    }
    
}