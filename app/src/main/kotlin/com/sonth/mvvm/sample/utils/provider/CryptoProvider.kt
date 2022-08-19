package com.sonth.mvvm.sample.utils.provider

import com.sonth.mvvm.sample.utils.LogUtil
import java.security.InvalidKeyException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.util.*
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class CryptoProvider {
    companion object{
        const val AES = "AES"
        const val SHA_1 = "SHA-1"
    }

    @Throws(
        BadPaddingException::class,
        IllegalBlockSizeException::class,
        InvalidKeyException::class
    )
    fun decrypt(input: String, pin: String): String {
        val decryptionCipher = createCipherFromPin(Cipher.DECRYPT_MODE, pin)
        return String(decryptionCipher.doFinal(Base64.getDecoder().decode(input.toByteArray())))
    }

    @Throws(
        BadPaddingException::class,
        IllegalBlockSizeException::class,
        InvalidKeyException::class
    )
    fun encrypt(input: String, pin: String): String {
        val encryptionCipher = createCipherFromPin(Cipher.ENCRYPT_MODE, pin)
        return String(Base64.getEncoder().encode(encryptionCipher.doFinal(input.toByteArray())))
    }

    @Throws(InvalidKeyException::class)
    private fun createCipherFromPin(encryptMode: Int, pin: String): Cipher {
        return try {
            var key: ByteArray = pin.toByteArray()
            val sha = MessageDigest.getInstance(SHA_1)
            key = sha.digest(key)
            key = key.copyOf(16) // use only first 128 bit
            val secretKeySpec = SecretKeySpec(key, AES)
            val cipher = Cipher.getInstance(AES)
            cipher.init(encryptMode, secretKeySpec)
            cipher
        } catch (e: NoSuchAlgorithmException) {
            LogUtil.error(javaClass.simpleName, "Unable to initialize cipher: $e")
            throw InvalidKeyException("Unable to create cipher using key.")
        } catch (e: NoSuchPaddingException) {
            LogUtil.error(javaClass.simpleName, "Unable to initialize cipher: $e")
            throw InvalidKeyException("Unable to create cipher using key.")
        }
    }

}