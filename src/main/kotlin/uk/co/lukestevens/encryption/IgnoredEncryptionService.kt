package uk.co.lukestevens.encryption

import java.io.IOException

class IgnoredEncryptionService : EncryptionService {
	
	override fun encrypt(plaintext: String): String {
		return plaintext
	}

	override fun decrypt(ciphertext: String): String {
		return ciphertext
	}
}