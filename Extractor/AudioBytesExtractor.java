package Extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AudioBytesExtractor {
    private static final int NUM_KEY_NUMBERS = 10;
    
    private ArrayList<byte[]> keys = new ArrayList<>();

    public void extractAudioKeyBytes(String inputFile) {
        try (FileInputStream inputStream = new FileInputStream(new File(inputFile))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int keyNumbersCaptured = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1 && keyNumbersCaptured < NUM_KEY_NUMBERS) {
                // Extrair chaves a partir dos bytes do arquivo de áudio
                for (int i = 0; i < bytesRead; i++) {
                    if (keyNumbersCaptured >= NUM_KEY_NUMBERS) {
                        break;
                    }

                    byte[] keyNumber = {buffer[i]};
                    keys.add(keyNumber);
                    keyNumbersCaptured++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int keyNumbers() {
    	return NUM_KEY_NUMBERS;
    }
    
    public ArrayList<byte[]> getKeys() {
        return keys;
    }
}
