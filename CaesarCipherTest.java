/**
 * @purpose Prompt the user to input a shift value and the option of encrypting
 *          or decrypting a desired message using the Caesar shift. Use static
 *          methods of the Encryption class to return a shifted version of the
 *          alphabet and encrypt/decrypt a message by a chosen shift.
 *
 * @author Aidan Guenther
 * @date 03/20/2023
 */
import java.util.Scanner;
public class CaesarTester{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String userInput;
        int shift = 0;
        
        boolean valid = false;
        while(!valid){
            System.out.println("Enter a shift key (0-25): ");
            // Ensure the integer is a valid integer 0-25
            try{
                userInput = input.nextLine();
                shift = Integer.parseInt(userInput);
                if(shift >= 0 && shift <= 25){
                    valid = true;
                }
                else{
                    System.out.println("Please enter a number 0-25.\n");
                }
            }
            // If the input is not an integer, catch exception
            catch(Exception e){
                System.out.println("Please enter an integer number.\n");
            }
        }
        // Create an immutable string of the original alphabet
        final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Call getCipherAlphabet() to set the shifted alphabet
        Encryption.getCipherAlphabet(shift, ALPHABET);
        // Set public static variable as package variable
        String cipherAlphabet = Encryption.cipherAlphabet;
        
        // Display both alphabets
        System.out.println("\nOriginal Alphabet: " + ALPHABET);
        System.out.println("Cipher Alphabet: " + cipherAlphabet);
        
        String output;
        valid = false;
        while(!valid){
            // Display option menu
            System.out.println("\nPlease select an option from the menu below:");
            System.out.println(" - Encrypt\n - Decrypt\n - Quit");
            userInput = input.nextLine();
            if(userInput.equalsIgnoreCase("Encrypt")){
                System.out.println("\nEnter a message to encrypt: ");
                userInput = input.nextLine();
                // Call encrypt() to encrypt user input by previous shift
                output = Encryption.encrypt(ALPHABET, userInput);
                System.out.println("Encrypted message: " + output);
            }
            else if(userInput.equalsIgnoreCase("Decrypt")){
                System.out.println("\nEnter a message to decrypt: ");
                userInput = input.nextLine();
                // Call decrypt() to decrypt user input by previous shift
                output = Encryption.decrypt(ALPHABET, userInput);
                System.out.println("Decrypted message: " + output);
            }
            else if(userInput.equalsIgnoreCase("Quit")){
                valid = true;
                System.out.println("\nEnding session.");
            }
            else{
                System.out.println("Invalid option chosen. Please try again.");
            }
        }
    }
}