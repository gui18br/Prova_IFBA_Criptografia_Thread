package Extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AudioBytesExtractor {
    private static final int NUM_BYTES_NUMBERS = 10;
    
    private ArrayList<byte[]> bytes = new ArrayList<>();
    
    /*
     * O metodo 'extractAudioBytes' e responsavel por extrair de um determinado arquivo de audio que e passado como
     * parametro para ele os seus bytes. O mesmo apos receber o arquivo de audio le byte a byte e armazena os bytes
     * lidos em uma lista chamada 'bytes'. Dentro do loop 'while', um loop 'for' itera os bytes lidos do arquivo no
     * buffer. A variavel 'i' controla a posicao autal no buffer.
     */

    public void extractAudioBytes(String inputFile) {
        try (FileInputStream inputStream = new FileInputStream(new File(inputFile))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int bytesNumbersCaptured = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1 && bytesNumbersCaptured < NUM_BYTES_NUMBERS) {
                for (int i = 0; i < bytesRead; i++) {
                    if (bytesNumbersCaptured >= NUM_BYTES_NUMBERS) {
                        break;
                    }

                    byte[] bytesNumber = {buffer[i]};
                    bytes.add(bytesNumber);
                    bytesNumbersCaptured++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int bytesNumbers() {
    	return NUM_BYTES_NUMBERS;
    }
    
    /*
     * metodo responsavel por retornar os bytes lidos que estao armazenados na lista.
     */
    public ArrayList<byte[]> getBytes() {
        return bytes;
    }
}
