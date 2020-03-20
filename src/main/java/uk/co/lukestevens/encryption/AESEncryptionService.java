package uk.co.lukestevens.encryption;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * A service to manage the encryption and decryption of strings using AES
 * 
 * @author luke.stevens
 */
@Singleton
public class AESEncryptionService implements EncryptionService {
	
	private static final int IV_LENGTH = 12;
	
	private final String key;
	
	@Inject
	public AESEncryptionService(@EncryptionKey String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String plaintext) throws IOException {
		try {
			
			// Create a random initialisation vector
			byte[] iv = new byte[IV_LENGTH];
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.nextBytes(iv);
			
			// Convert the system key into a secret key
			SecretKeySpec key = new SecretKeySpec(this.key.getBytes(), "AES");
			GCMParameterSpec ivSpec = new GCMParameterSpec(128, iv);

			// Get the cipher
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
			
			// Encrypt the string
			byte[] decrypted = plaintext.getBytes();
			byte[] encrypted = cipher.doFinal(decrypted);
			
			// Append the initialisation vector to the beginning of the string
			ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + encrypted.length);
		    byteBuffer.put(iv);
		    byteBuffer.put(encrypted);
		    
		    // Return Base64 representation of string
		    byte[] cipherMessage = byteBuffer.array();
			return Base64.getEncoder().encodeToString(cipherMessage);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	@Override
	public String decrypt(String ciphertext) throws IOException {
		try {
			
			byte[] encrypted = Base64.getDecoder().decode(ciphertext.getBytes());
			
			// Split out the encrypted String and the initialisation vector
			// from the given bytes
			ByteBuffer byteBuffer = ByteBuffer.wrap(encrypted);
		    byte[] iv = new byte[IV_LENGTH];
		    byteBuffer.get(iv);
		    byte[] cipherText = new byte[byteBuffer.remaining()];
		    byteBuffer.get(cipherText);
		    
		    // Convert the system key into a secret key
		    SecretKeySpec key = new SecretKeySpec(this.key.getBytes(), "AES");
		    GCMParameterSpec ivSpec = new GCMParameterSpec(128, iv);
		    
		    // Get the cipher
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
			
			// Decrypt the string
			byte[] decrypted = cipher.doFinal(cipherText);
			return new String(decrypted);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

}
