/*************************************************************************
 *  Compilation:  javac RunLengthEncoding.java
 *  Execution:    java RunLengthEncoding
 *
 *  @author: Cyrus Majd         
 *
 *************************************************************************/

public class RunLengthEncoding {

    /* 
     * Encode the original string by finding sequences in the string
     * where the same character repeats. Replace each such sequence
     * by a token consisting of: the number of characters in the sequence
     * followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  {

	// for loop that goes through every element of the string (substring from i to i+1 is that equal to from i+1 to i+2? goes until length-1)

    char tempChar;
    char newChar;
    int counter = 1;
    StringBuilder encodedString = new StringBuilder();
    String finalEncodedString;

    if (original.length() == 1) {
        return original;
    }

        for (int i = 0; i < original.length() - 1; i++){

            tempChar = original.charAt(i);
            
            newChar = original.charAt(i+1);
            

            if (tempChar != newChar) {

                if (counter != 1){  
                    encodedString.append(counter);
                }
                encodedString.append(tempChar);
                
                counter = 1;
            }

            if (tempChar == newChar) {
                counter++;
                if (i == original.length()-2){
                    encodedString.append(counter);
                    encodedString.append(newChar);
                    finalEncodedString = encodedString.toString(); 
                    return finalEncodedString;
                }
            }

            if (i >= original.length() - 2) {
                newChar = original.charAt(i+1);
                encodedString.append(newChar);
                finalEncodedString = encodedString.toString(); 
                return finalEncodedString;
            }
        }

    finalEncodedString = encodedString.toString();

    return finalEncodedString;

    }

    /*
     * Decodes the original string encoded with the encode method.
     * Returns the decoded string.
     *
     * YOUR decode METHOD MUST BE RECURSIVE, do not use while, do/while, 
     * or for loops
     */



    public static String decode (String original)  {
	
        if (Character.isDigit(original.charAt(0)) == true){

            //also make a test case for if the char is 1 becuase if it is just return the letter.
            if (original.charAt(0) == '1'){
                //the digit is 1
                return decode(original.substring(1));
            }


            else {
                //digit aint 1
                char temp = original.charAt(0);
                char tempLetter = original.charAt(1);
                temp--;
                return decode( Character.toString(temp) + Character.toString(tempLetter) + original.substring(1));
            }
        }
        else if (original.length() == 1) {
            return original;
        }
        else {
            //it aint a digit
            char anotherTemp = original.charAt(0);
            return (Character.toString(anotherTemp) + decode(original.substring(1) ) );
        }

    }

    public static void main (String[] args) {

	System.out.println(encode("bbbaaaaaaiiiddeenaoikiknaiiii"));
    System.out.println(decode("3fg3hjkl3a7k9j3k"));

    }
}
