# Enigma Machine Simulator (GUI)

A Java-based Enigma machine simulator featuring a graphical user interface (GUI) that allows users to encrypt and decrypt messages using rotor-based substitution ciphers.

## Project Overview
This project simulates the historical Enigma encryption machine using Java. It models rotor-based encryption logic and provides a graphical user interface for user interaction. Users can input plaintext or ciphertext through the GUI and view the corresponding encrypted or decrypted output.

The project was developed as part of a computer science course to practice object-oriented programming, modular design, GUI development, and foundational cryptography concepts.

##  Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Java GUI (Swing/AWT)
- Substitution Ciphers
- Modular Program Design

##  Features
- Enigma-style rotor encryption and decryption
- Graphical user interface for user input and output
- Configurable inner, middle, and outer rotors
- Support for custom initial rotor positions
- Modular separation of encryption logic and GUI components
- Bidirectional encryption and decryption

## How to Compile and Run
### Step 1: Compile the Project
From the project directory, run: 
```
javac *.java
```
### Step 2: Run the GUI
```
java EnigmaGUI
```
The GUI window will open, allowing you to enter text and view the encrypted or decrypted result.

## Example Usage
Example 1: Encryption

Rotor Configuration

* Inner Rotor: 1
* Middle Rotor: 2
* Outer Rotor: 3
* Initial Positions: ###

Input 
```
AAA
```
Expected Output
```
NDU
```

Example 2: Decryption

Rotor Configuration

* Inner Rotor: 5
* Middle Rotor: 2
* Outer Rotor: 4
* Initial Positions: EST

Input 
```
CSHIAWDFGDCOE#EZKJHRWAZDDCBCILON#PKUJEXEXSHINZ
```
Expected Output
```
THE#NATIONAL#ANIMAL#OF#SCOTLAND#IS#THE#UNICORN
```
