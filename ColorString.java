public class ColorString{
    public static final String RESET = "\033[0m";      // Text Color Reset
    public static final String CLEAR = "\033[H\033[2J"; // Clear Screen
    public static final String RED = "\033[0;31m";     // RED (Enemy)
    public static final String GREEN = "\033[0;32m";   // GREEN (Ally)
    public static final String YELLOW = "\033[0;33m";  // YELLOW (System)
    public static final String BLUE = "\033[0;34m";    // BLUE (Guide)
    public static final String PURPLE = "\033[0;35m";  // PURPLE (Item)
    public static final String CYAN = "\033[0;36m";    // CYAN (Player Input)
    public static final String WHITE = "\033[0;37m";   // WHITE (Event)

    public static String red(String s){
        return RED + s + RESET;
    }

    public static String green(String s){
        return GREEN + s + RESET;
    }

    public static String yellow(String s){
        return YELLOW + s + RESET;
    }

    public static String blue(String s){
        return BLUE + s + RESET;
    }

    public static String purple(String s){
        return PURPLE + s + RESET;
    }

    public static String cyan(String s){
        return CYAN + s + RESET;
    }

    public static String white(String s){
        return WHITE + s + RESET;
    }
    
    //Method to make the console input cyan
    public static void startPlayerInput(){
        System.out.print(CYAN);
    }

    //Method to reset console input color
    public static void endPlayerInput(){
        System.out.print(RESET);
    }

    //Method to clear the console
    public static void clearScreen(){
        System.out.print(CLEAR);
        System.out.flush();
    }

    //Method to make text a custum color
    public static String color(String s, String c){
        return c + s + RESET;
    }
}