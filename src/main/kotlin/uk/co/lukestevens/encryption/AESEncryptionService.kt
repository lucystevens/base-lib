package uk.co.lukestevens.encryption

import java.io.IOException
import java.nio.ByteBuffer
import java.security.SecureRandom
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject
import javax.inject.Singleton

/**
 * A service to manage the encryption and decryption of strings using AES
 *
 * @author luke.stevens
 */
@Singleton
class AESEncryptionService @Inject
constructor(@EncryptionKey val key: String) : EncryptionService {

	@Throws(IOException::class)
	override fun encrypt(plaintext: String): String {
		try {
			// Create a random initialisation vector
			val iv = ByteArray(IV_LENGTH)
			val secureRandom = SecureRandom()
			secureRandom.nextBytes(iv)
			
			// Convert the system key into a secret key
			val key = SecretKeySpec(this.key.toByteArray(), "AES")
			val ivSpec = GCMParameterSpec(128, iv)
			
			// Get the cipher
			val cipher = Cipher.getInstance("AES/GCM/NoPadding")
			cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec)
			
			// Encrypt the string
			val decrypted = plaintext.toByteArray()
			val encrypted = cipher.doFinal(decrypted)
			
			// Append the initialisation vector to the beginning of the string
			val byteBuffer = ByteBuffer.allocate(iv.size + encrypted.size)
			byteBuffer.put(iv)
			byteBuffer.put(encrypted)
			
			// Return Base64 representation of string
			val cipherMessage = byteBuffer.array()
			return Base64.getEncoder().encodeToString(cipherMessage)
		} catch (e: Exception) {
			throw IOException(e)
		}
	}

	@Throws(IOException::class)
	override fun decrypt(ciphertext: String): String {
		try {
			val encrypted = Base64.getDecoder().decode(ciphertext.toByteArray())
			
			// Split out the encrypted String and the initialisation vector
			// from the given bytes
			val byteBuffer = ByteBuffer.wrap(encrypted)
			val iv = ByteArray(IV_LENGTH)
			byteBuffer.get(iv)
			val cipherText = ByteArray(byteBuffer.remaining())
			byteBuffer.get(cipherText)
			
			// Convert the system key into a secret key
			val key = SecretKeySpec(this.key.toByteArray(), "AES")
			val ivSpec = GCMParameterSpec(128, iv)
			
			// Get the cipher
			val cipher = Cipher.getInstance("AES/GCM/NoPadding")
			cipher.init(Cipher.DECRYPT_MODE, key, ivSpec)
			
			// Decrypt the string
			val decrypted = cipher.doFinal(cipherText)
			return String(decrypted)
		} catch (e: Exception) {
			throw IOException(e)
		}
	}

	companion object {
		private val IV_LENGTH = 12
	}
}