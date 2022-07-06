/*
 * The License Plate Game is to use the three letters found on most license
 * plates and to think of a word that has those letters in the order found.
 * For example, "HLO 1234" could be "hello" because hello has h before l before
 * o! I started playing this game on the road and encountered letter that maybe
 * had no solution, so I made this to find solutions (or none) to hard letter
 * combinations.
 * 
 * Prompts user for three letter combination from license plate then searches
 * a comprehensive word list for a solution using the given rules and prints
 * all following words.
 * 
 * Word list has 466k English words (https://github.com/dwyl/english-words)
 * 
 * Just helped me find a word for "AMW" -> "flAMethroWer"
 * 
 * Runs fast!
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LicensePlateGame {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner wordScan = new Scanner(new File("src/words.txt"));
        Scanner console = new Scanner(System.in);
        
        System.out.println("Example: \"HLO\" => \"hello\"");
        System.out.print("Enter license plate letters: ");
        String letters = console.next();
        
        while (wordScan.hasNext()) {
            String word = wordScan.next();
            if (isMatch(word, letters)) {
                System.out.println(word);
            }
        }
    }
    
    // Checks whether given word matches given letters using the License Plate
    // Game rules (see above.)
    public static boolean isMatch(String word, String letters) {
        int lettersIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            char wordLetter = Character.toLowerCase(word.charAt(i));
            char lettersLetter = Character.toLowerCase(
                    letters.charAt(lettersIndex));
            if (wordLetter == lettersLetter) {
                lettersIndex++;
            }
            
            if (lettersIndex == 3) {
                return true;
            }
        }
        return false;
    }

}
