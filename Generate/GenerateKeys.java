package Generate;

import java.util.ArrayList;

import javax.crypto.spec.SecretKeySpec;

public class GenerateKeys {
	
	
	/*
	 * O metodo 'generateKeys' e responsavel por gerar a chave para encriptar dados posteriores.
	 * Ele recebe um ArrayList de bytes 'audioBytes', que se nao for nula e realizada a operacao
	 * de criacao da chave para encriptacao posterior. Um array de bytes chamado 'encryptionKeyBytes'
	 * e criado com um tamanho de 16 bytes. Essa e a quantidade padrao de bytes necessaria para 
	 * uma chave AES de 128 bits. Apos o loop, e craido um objeto 'SecretKeySpec' chamado 'secretKey',
	 * usando o array 'encryptionKeyBytes' como chave e o algoritmo 'AES'.
	 */
	public SecretKeySpec generateKeys(ArrayList<byte[]> audioBytes) {
		if (audioBytes != null) {
			byte[] encryptionKeyBytes = new byte[16]; //128 bits = 16 bytes
			for (int i = 0; i < audioBytes.size(); i++) {
				byte[] key = audioBytes.get(i);
				encryptionKeyBytes[i] = key[0];
			}
			
			SecretKeySpec secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
			
			return secretKey;
		 }
		
		return null;
	}
}
	            
