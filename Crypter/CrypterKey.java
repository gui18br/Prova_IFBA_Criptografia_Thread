package Crypter;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CrypterKey {
	private static final String ALGORITHM = "AES";
	
	/*
	 * metodo responsavel por realizar a encriptacao pelo algoritmo 'AES' de determinados dados passados
	 *  como parametros, alem da chave de codificacao. E criado um objeto 'Cipher' usando o algoritmo 
	 *  especificado 'AES'. O objeto 'Cipher' e inicializado no modo de criptografia 'ENCRYPT_MODE'
	 *  com a chave secreta fornecida. Os dados fornecidos sao convertidos em um array de bytes usando
	 *  'data.getBytes()'. O metodo 'doFinal' e chamado para criptografar os bytes dos dados. A string
	 *  codificada em 'Base64' e retornada como resultado.
	 */
	public static String encryptData(String data, SecretKeySpec secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] encryptedBytes = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	
	
	/*
	 * metodo responsavel por realizar a decodificacao pelo algoritmo 'AES' de determinados dados passados
	 * como parametros, alem da chave para decodificacao. E criado um objeto 'Cipher' usando o algoritmo
	 * especificado 'AES'. O objeto 'Cipher' e inicializado no modo de criptografia 'DECRYPT_MODE' com a 
	 * chave secreta fornecida. Os dados fornecidos sao decodificados e armazenados em um novo String re-
	 * tornados como sao originalmente.
	 */
	public static String decryptData(String encryptedData, SecretKeySpec secretKey) throws Exception{
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
		byte[] decryptedBytes = cipher.doFinal(decodedBytes);
		return new String(decryptedBytes);
	}
}
