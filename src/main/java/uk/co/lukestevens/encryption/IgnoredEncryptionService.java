package uk.co.lukestevens.encryption;

import java.io.IOException;


public class IgnoredEncryptionService implements EncryptionService {

	@Override
	public String encrypt(String plaintext) throws IOException {
		return plaintext;
	}

	@Override
	public String decrypt(String ciphertext) throws IOException {
		return ciphertext;
	}

}
