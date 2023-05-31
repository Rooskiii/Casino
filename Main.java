import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
class Main {
    public static void main(String[] args) throws IOException {
        //Scanner reader = new Scanner(System.in);
        
        Player player = new Player();
        
        //work on this later
        
        SaveData save = new SaveData("save.txt");

        if(!save.anyContents()){
            intro(player, save);
        } else {
            save.loadPlayer(player);
            casinoEntrance(player, save);
        }
        
        //file object, filewriter object and PrintWriter?
        //make a login, balance, saveData
        
    }

    //make an intro method, launch if theres not data
    //make a welcomeback method, launch if there is data present
    
    //change intro later, make welcome and start info in another method or put in main
    //make an atm to store balance

    public static void intro(Player player, SaveData save) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println(" WELCOME TO THE CASINO RIGGS ");
        System.out.println("-----------------------------");
        System.out.println("What is your name?");
        String name = reader.nextLine();

        player.setName(name); //write this to the file
        
        System.out.println("Enter a balance you want to start at below. ");
        double b = Input.changeStringToDouble(reader.nextLine());
        player.setBalance(b); //write this to the file

        save.save(player);
        
        casinoEntrance(player, save);
    }
    
    public static void casinoEntrance(Player player, SaveData save) throws IOException {
        Scanner reader = new Scanner(System.in);  

        ColorString.clearScreen();
        
        System.out.println("Hello! "+player.getName()+". You have "+player.getBalance());
        System.out.println("What Do you want to do play?");
        System.out.println("1. Blackjack");
        System.out.println("2. Texas Holdem");
        System.out.println("3. 3 Card Poker Against Dealer");
        System.out.println("4. 5 Card Poker");
        System.out.println("5. Leave Casino");
        System.out.println("Enter # input below:");
        
        int input = Input.changeStringToInt(reader.nextLine());
        
        //input validation for valid game number
        // make into a validation method in input later
        do{

            if(!Input.validGameInput(input)){
                System.out.println("Did not enter Game Number, try again below. ");
                input = Input.changeStringToInt(reader.nextLine());
            }
            
        } while(!Input.validGameInput(input));

        switch(input){

            case 1: 
                System.out.println("Entering a Blackjack Table..."); 
                Games.Blackjack(player, save); 
                break;
            case 2: 
                System.out.println("Entering a Texas Holdem Table..."); 
                Games.TexasHoldem(player); 
                break;
            case 3:
                System.out.println("Entering a 3 Card Poker Table...");
                Games.threeCardPoker(player); 
                break;
            case 4: 
                System.out.println("Entering a 5 Card Poker Table...");
                Games.fiveCardPoker(player); 
                break;
            case 5:
                //saves on exit of the casino
                System.out.println("Leaving Casino...");
                save.save(player);
                System.exit(0);
                break;
            
        }
        
    }

    
    
}


