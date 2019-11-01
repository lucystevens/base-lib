package uk.co.lukestevens.mocks;

import java.io.IOException;
import uk.co.lukestevens.encryption.EncryptionService;


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
