/**
 * Represents an Enigma-style encryption machine.
 *
 * This class builds a machine using three rotors and an initial rotor
 * starting position. It can encrypt or decrypt a message by mapping each
 * character through rotor transformations and rotating rotors after each
 * character is processed.
 */
public class Enigma{

    /**
     * Rotor wiring templates.
     * Each string represents a rotor mapping using a fixed alphabet that includes '#'.
     * Rotor IDs passed to the constructor are 1-based (1..5), so we access them using (id - 1).
     */
    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};

    /** The machine's three rotors: inner (0), middle (1), outer (2). */
    private Rotor rotors[];

    /**
     * Constructs an Enigma machine with three selected rotors and a starting position.
     *
     * @param id1  inner rotor ID (1..5)
     * @param id2  middle rotor ID (1..5)
     * @param id3  outer rotor ID (1..5)
     * @param start a 3-character string representing the initial positions for each rotor
     */
    public Enigma(int id1, int id2, int id3, String start){
        rotors = new Rotor[3];
        
        // Create each rotor using the selected wiring template and its initial position character.
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));    // inner rotor
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));    // middle rotor
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));    // outer rotor
        
    }

    /**
     * Decrypts a message using the current rotor configuration.
     * Rotors rotate after each character is processed.
     *
     * @param message the encrypted text
     * @return decrypted plaintext
     */
    public String decrypt(String message){    
        
        // Convert message to a char array so we can process character-by-character.
        char[] letters = message.toCharArray();  
        // String to hold the decrypted result
        String decrypted = "";                         

        // Process each character in the message
        for(int i=0; i < letters.length; i++) {
            char c = letters[i];
            int index = rotors[2].indexOf(c);           //finds index of the current character
            char letter = rotors[1].charAt(index);          //finds the corresponding character at the index of the middle rotor

            int secIndex = rotors[2].indexOf(letter);       //finds the index of the same letter on the outer rotor
            char found = rotors[0].charAt(secIndex);        //finds the corresponding letter on the inner rotor

            decrypted += found;     //append encrpted letter to string
            rotate();               //rotates the rotors as needed

        }

        return decrypted;
        }

    /**
     * Encrypts a message using the Enigma machine.
     * Each character is encrypted sequentially, and the rotors rotate
     * after each character is processed.
     *
     * @param message The plaintext message
     * @return The encrypted ciphertext message
     */
    public String encrypt(String message){

        char[] letters = message.toCharArray();         //changes message to a character array
        String encrypted = "";                          //new string to hold encrypted message
        
        for(int i=0; i < letters.length; i++) {
            char c = letters[i];
            int index = rotors[0].indexOf(c);           //finds index of the current character
            char letter = rotors[2].charAt(index);          //finds the corresponding charater at the index of the outer rotor

            int secIndex = rotors[1].indexOf(letter);       //finds the index of the same letter in the middle rotor
            char found = rotors[2].charAt(secIndex);        //finds the corresponding letter on the outer rotor

            encrypted += found;     //append encrpted letter to string
            rotate();               //rotates the rotors as needed

        }
        
        return encrypted;
    }

    /**
     * Rotates the rotors in a cascading (odometer-style) manner.
     * The inner rotor rotates first; if it completes a full rotation,
     * the middle rotor rotates, and similarly for the outer rotor.
     */
    private void rotate(){
        if(rotors[0].rotate()){             // Rotate inner rotor; if it completes a cycle, rotate middle rotor
            if(rotors[1].rotate()){         // If middle rotor completes a cycle, rotate outer rotor
                rotors[2].rotate();
            }
        }
    }
    
}
