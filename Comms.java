import java.util.Scanner;

/**
 * The Comms class acts as the communication layer between user input
 * and the Enigma encryption engine.
 *
 * It parses command-line arguments, constructs an Enigma machine
 * with the specified rotors and initial positions, and performs
 * encryption or decryption on the provided message.
 */
public class Comms {

  /**
     * Executes an encryption or decryption operation based on
     * command-line arguments.
     *
     * Expected arguments:
     * args[0] - Inner rotor ID
     * args[1] - Middle rotor ID
     * args[2] - Outer rotor ID
     * args[3] - Initial rotor positions
     * args[4] - Operation mode ("encrypt" or "decrypt")
     * args[5] - Message to be encrypted or decrypted
     *
     * @param args Command-line arguments used to configure the Enigma machine
     * @return The encrypted or decrypted message
     */
  public static String run(String[] args) {
    
    // Determine whether to encrypt or decrypt
    boolean encrypt = true;
    if( args[4].equals("decrypt") )
      encrypt = false;

    // Parse rotor IDs from arguments
    int id1 = Integer.parseInt(args[0]);
    int id2 = Integer.parseInt(args[1]);
    int id3 = Integer.parseInt(args[2]);
    
    // Retrieve the message to be processed
    // (Originally read from STDIN, now passed directly as an argument)
    String message = args[5];

    // Create an Enigma machine with the specified configuration
    Enigma enigma = new Enigma(id1, id2, id3, args[3]);

    // Perform encryption or decryption and return the result
    if( encrypt )
      return enigma.encrypt(message);
    else
      return enigma.decrypt(message);
  }
}
