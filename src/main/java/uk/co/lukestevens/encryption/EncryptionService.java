package uk.co.lukestevens.encryption;

import java.io.IOException;

/**
 * A service for encrypting and decrypting sensitive
 * strings such as passwords and secret keys
 * 
 * @author luke.stevens
 */
public interface EncryptionService {
	
	/**
	 * Encrypt a plaintext String
	 * @param plaintext The plaintext String to encrypt
	 * @return The encrypted String, encoded in Base64
	 * @throws IOException If there is an error during encryption.
	 */
	public String encrypt(String plaintext) throws IOException;
	
	/**
	 * Decrypt a String encrypted using the same implementation
	 * of this service
	 * @param ciphertext The encrypted String
	 * @return The plaintext value of the encrypted String
	 * @throws IOException If there is an error during encryption.
	 */
	public String decrypt(String ciphertext) throws IOException;

}
