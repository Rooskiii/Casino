import java.util.Scanner;
public class Input {

    public static boolean validGameInput(int val){
        
        if(val != 1 && val != 2 && val != 3 && val != 4 && val != 5){
            return false;
        } else {
            return true;
        }
        
    }
    
    //work on this for later, if player wants to exit game
    public static boolean goBackInput(){
        return true;
    }

    //for blackjack, if user wants to use 5 decks or 7 decks
    public static int changeIfNotFiveOrSeven(int num){
        Scanner reader = new Scanner(System.in);
        do{

            if(num != 5 && num != 7){
                System.out.println("Did not choose 5 or 7, Try again below.");
                num = changeStringToInt(reader.nextLine());
            }
            
        } while(num != 5 && num != 7);

        return num;
        
    }
    
    //checks if the input is a number
    public static boolean checkIfNumber(String val){
        for(int i = 0; i < val.length(); i++){
            if(val.charAt(i) < 48 || val.charAt(i) > 57){
                return false;
            }
        }

        return true;
        
    }

    //if user enters a string, change it to int if it meets criteria
    public static int changeStringToInt(String check){
        Scanner reader = new Scanner(System.in);
        do{

            if(!Input.checkIfNumber(check)){
                System.out.println("Did not print a number. Try again below. ");
                check = reader.nextLine();
            }
            
        } while(!Input.checkIfNumber(check));
        
        return Integer.parseInt(check);
        
    }

    //if user enters a string, change it to an doubke if it meets criteria
    public static double changeStringToDouble(String check){
        Scanner reader = new Scanner(System.in);
        do{

            if(!Input.checkIfNumber(check)){
                System.out.println("Did not print a number. Try again below. ");
                check = reader.nextLine();
            }
            
        } while(!Input.checkIfNumber(check));
        
        return Double.parseDouble(check);
        
    }

    //validation method for blackjack - maybe make a class with just blackjack methods
    public static String hitOrStand(String check){
        Scanner reader = new Scanner(System.in);
        do{

            if(!check.equalsIgnoreCase("Hit") && !check.equalsIgnoreCase("Stand")){
                System.out.println("Did not enter either Hit or Stand. Try again below. ");
                check = reader.nextLine();
            }
            
        } while(!check.equalsIgnoreCase("Hit") && !check.equalsIgnoreCase("Stand"));

        return check;
        
    }

    //validation method for blackjack - maybe make a class with just blackjack methods
    //maybe called BlackjackRules
    public static String hitSplitOrStand(String check){

        Scanner reader = new Scanner(System.in);
        do{

            if(!check.equalsIgnoreCase("Hit") && !check.equalsIgnoreCase("Stand") && !check.equalsIgnoreCase("split")){
                System.out.println("Did not enter either Hit, Stand, or Split. Try again below. ");
                check = reader.nextLine();
            }
            
        } while(!check.equalsIgnoreCase("Hit") && !check.equalsIgnoreCase("Stand") && !check.equalsIgnoreCase("split"));

        return check;
        
    }

    public static double betChecker(double bet, Player player){
        Scanner reader = new Scanner(System.in);
        do {

            if(bet > player.getBalance()){
                System.out.println("Enter a bet that is less than your balance. ");
                bet = Input.changeStringToDouble(reader.nextLine());
            }
            
        } while(bet > player.getBalance());

        return bet;
        
    }
    
}