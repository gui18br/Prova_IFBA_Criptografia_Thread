package Crypter;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CrypterKey {
	private static final String ALGORITHM = "AES";
	
	public static String encryptData(String data, SecretKeySpec secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] encryptedBytes = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	
	public static String decryptData(String encryptedData, SecretKeySpec secretKey) throws Exception{
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
		byte[] decryptedBytes = cipher.doFinal(decodedBytes);
		return new String(decryptedBytes);
	}
}
