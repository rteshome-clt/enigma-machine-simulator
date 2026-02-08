/**
 * The Rotor class represents a single rotor used in the Enigma machine.
 *
 * A rotor contains a circular character mapping that rotates to change
 * encryption behavior. Each rotor starts at a specified character and
 * rotates in a clockwise direction.
 */
public class Rotor {

    /** String representing the current rotor character mapping */
    private String rotorValues;
    /** Character that represents the initial starting position of the rotor */
    private char startChar;

    /**
     * Constructs a Rotor with a given character mapping and starting position.
     * The rotor rotates until the starting character is aligned correctly.
     *
     * @param v the rotor wiring configuration
     * @param c the initial starting character
     */
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());        // Rotate the rotor until the starting character reaches the correct position        
    }

    /**
     * Rotates the rotor one position clockwise.
     *
     * @return true if the rotor reaches its starting character position
     *         after rotation, false otherwise
     */
    public boolean rotate(){        
        // Shift the rotor mapping clockwise by one position
        rotorValues = rotorValues.substring(rotorValues.length() -1) + rotorValues.substring(0,rotorValues.length() -1);     //shifts clockwise

        // Check if the rotor has reached its starting position
        if (rotorValues.charAt(0) == startChar){    
            return true;
        }

        return false;
    }
    
    /**
     * Returns the index of a given character in the rotor mapping.
     *
     * @param c the character to locate
     * @return the index of the character within the rotor mapping
     */
    public int indexOf(char c){             
        return rotorValues.indexOf(c);
    }

    /**
     * Returns the character at a specified index in the rotor mapping.
     *
     * @param idx the index of the desired character
     * @return the character at the given index
     */
    public char charAt(int idx){            
        return rotorValues.charAt(idx);
    }
}
    
