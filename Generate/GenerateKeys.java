package Generate;

import java.util.ArrayList;

import javax.crypto.spec.SecretKeySpec;

public class GenerateKeys {
	
	public SecretKeySpec generateKeysbyBytes(ArrayList<byte[]> audioKeys) {
		if (audioKeys != null) {
			byte[] encryptionKeyBytes = new byte[16]; //128 bits = 16 bytes
			for (int i = 0; i < audioKeys.size(); i++) {
				byte[] key = audioKeys.get(i);
				encryptionKeyBytes[i] = key[0];
			}
			
			SecretKeySpec secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
			
			return secretKey;
		 }
		
		return null;
	}
}
	            
