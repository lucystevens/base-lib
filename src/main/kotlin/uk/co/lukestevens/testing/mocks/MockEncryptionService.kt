package uk.co.lukestevens.testing.mocks

import java.io.IOException
import uk.co.lukestevens.encryption.EncryptionService

class MockEncryptionService : EncryptionService {
	
	override fun encrypt(plaintext: String): String {
		return plaintext + SUFFIX
	}

	override fun decrypt(ciphertext: String): String {
		return ciphertext.substring(0, ciphertext.length - SUFFIX.length)
	}

	companion object {
		private val SUFFIX = " (encrypted)"
	}
}