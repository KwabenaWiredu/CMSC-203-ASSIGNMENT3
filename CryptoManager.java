/*
 * Class: CMSC203 32723
 * Instructor:Professor Eivazi
 * Description: (This is a utility class that encrypts and decrypts a phrase
 * using two different approaches. The first approach is called the Caesar's Cipher and the second is Bellaso's Cipher)
 * Due: 3/23/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here:Kwabena Wiredu
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi&Kwabena Wiredu
 * @version 3/23/2025
 */

import java.util.Scanner;

public class CryptoManager {
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		  for (int i = 0; i < plainText.length(); i++) {
		        char ch = plainText.charAt(i);
		        if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
		            return false;  
		        }
		  }
		        return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String encryptedPlainText="";
		char character = 0;
		int newKey=key-((UPPER_RANGE-LOWER_RANGE)+1);
		if(key>UPPER_RANGE) {
			for(int i=0;i<plainText.length();i++) {
				character=plainText.charAt(i);
				character+=newKey;		
				encryptedPlainText+=character;	
			}
			key=newKey;
		}
		else {
			for(int i=0;i<plainText.length();i++) {
			character=plainText.charAt(i);
			character+=key;
			encryptedPlainText+=character;
		}
		}
		return encryptedPlainText;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String encryptedPlainText="";
		
		if(bellasoStr.length()<plainText.length()) 
		{
			int fixedKey=plainText.length()-bellasoStr.length();
		for(int i=0;i<fixedKey;i++) 
		{
			bellasoStr+=bellasoStr.charAt(i);
				}
		
		for(int count=0;count<bellasoStr.length();count++) {
			int characterToBeShifted=bellasoStr.charAt(count)+plainText.charAt(count);
			if(characterToBeShifted>UPPER_RANGE) {
				characterToBeShifted-=RANGE;
			}
				char character = 0;
				character+=characterToBeShifted;
				encryptedPlainText+=character;
			}
		}
		return encryptedPlainText ;
		}
		

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */

	public static String caesarDecryption (String encryptedText, int key) {
		String decryptedText="";
		char character=0;
		
		int newKey=key-((UPPER_RANGE-LOWER_RANGE)+1);
		if(key>UPPER_RANGE) {
			for(int i=0;i<encryptedText.length();i++) {
				character=encryptedText.charAt(i);
				character-=newKey;
				decryptedText+=character;
			}
			}
		else 
		{
		for(int i=0;i<encryptedText.length();i++) {
			character=encryptedText.charAt(i);
			character-=key;
			decryptedText+=character;
			}
			}
		return decryptedText;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decryptedText="";
		int characterToBeShifted;
		if(bellasoStr.length()<encryptedText.length()) 
		{
			int fixedKey=encryptedText.length()-bellasoStr.length();
		for(int i=0;i<fixedKey;i++) 
		{
			bellasoStr+=bellasoStr.charAt(i);
				}
		}
		for(int count=0;count<encryptedText.length();count++) {
			int check=bellasoStr.charAt(count)+encryptedText.charAt(count);
			if(check>UPPER_RANGE) {
			    characterToBeShifted=encryptedText.charAt(count)-bellasoStr.charAt(count);;
				characterToBeShifted+=RANGE;
				char character = 0;
				character+=characterToBeShifted;
				decryptedText+=character;
			}
		}
		return decryptedText;
		}
}