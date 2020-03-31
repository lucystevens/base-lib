package uk.co.lukestevens.testing.mocks;

import java.io.IOException;

import uk.co.lukestevens.encryption.EncryptionService;

public class MockEncryptionService implements EncryptionService {
	
	private static final String SUFFIX = " (encrypted)";

	@Override
	public String encrypt(String plaintext) throws IOException {
		return plaintext + SUFFIX;
	}

	@Override
	public String decrypt(String ciphertext) throws IOException {
		return ciphertext.substring(0, ciphertext.length() - SUFFIX.length());
	}

}
