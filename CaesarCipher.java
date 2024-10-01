/**
 * @purpose Provide static methods to create an alphabet after being shifted
 *          by a chosen amount, encrypt messages with the Caesar cipher by the
 *          chosen shift, and decrypt messages using a known shift.
 *
 * @author Aidan Guenther
 * @date 03/20/2023
 */
public class CaesarCipher{
    public static String cipherAlphabet;
    public static void getCipherAlphabet(int shift, String ALPHABET){
        // Add all letters from the shift index onwards
        cipherAlphabet = ALPHABET.substring(shift);
        // Add all letters before the shift index
        cipherAlphabet += ALPHABET.substring(0, shift);
    }
    public static String encrypt(String ALPHABET, String input){
        String output = "";
        int index;
        input = input.toUpperCase();
        // For each character in the input,
        for(int i = 0; i < input.length(); i++){
            // Find the index of the character in the original alphabet
            index = ALPHABET.indexOf(input.charAt(i));
            // If the character is a letter,
            if(index != -1){
                // Add the character from the cipher alphabet at the same index
                output += cipherAlphabet.charAt(index);
            }
            // If the character is not a letter,
            else{
                // Add a space to the output
                output += " ";
            }
        }
        return output;
    }
    public static String decrypt(String ALPHABET, String input){
        String output = "";
        int index;
        input = input.toUpperCase();
        // For each character in the input,
        for(int i = 0; i < input.length(); i++){
            // Find the index of the character in the cipher alphabet
            index = cipherAlphabet.indexOf(input.charAt(i));
            // If the character is a letter,
            if(index != -1){
                // Add the character from the original alphabet at the same index
                output += ALPHABET.charAt(index);
            }
            // If the character is not a letter
            else{
                // Add a space to the output
                output += " ";
            }
        }
        return output;
    }
}
