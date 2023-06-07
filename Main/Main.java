package Main;
import java.util.ArrayList;

import javax.crypto.spec.SecretKeySpec;

import Crypter.CrypterKey;
import Extractor.AudioBytesExtractor;
import Generate.GenerateKeys;
import Operacoes.OperacoesMatematicas;
import Thread.MinhaThread;
import carro.MotorStatus;
import ordenation.Ordenador;

public class Main {
    public static void main(String[] args) {
        String inputFile = "/home/gui/Downloads/videoplayback-_1_-_online-video-cutter.com_.wav";
        AudioBytesExtractor extractor = new AudioBytesExtractor();
        GenerateKeys generator = new GenerateKeys();
        CrypterKey crypter = new CrypterKey();
        ArrayList<MotorStatus> statusMotores = new ArrayList<MotorStatus>();
		ArrayList<MotorStatus> status = new ArrayList<MotorStatus>();
		 
		MinhaThread minhaThread = new MinhaThread(statusMotores);
		
		Thread thread = new Thread(minhaThread);
        
        extractor.extractAudioKeyBytes(inputFile);
        ArrayList<byte[]> audioKeys = extractor.getKeys();

        SecretKeySpec encryptionKey = generator.generateKeysbyBytes(audioKeys);
        
        System.out.println(encryptionKey);
        minhaThread.setEncryptionKey(encryptionKey);
        
        
        //EXEMPLO
        
        try {
        	String data = "Dados a serem encriptados";
        	System.out.println(data);
        	String encryptedData = crypter.encryptData(data, encryptionKey);
        	System.out.println("Dados encriptados: " + encryptedData);
        	
        	String decryptedData = crypter.decryptData(encryptedData, encryptionKey);
        	System.out.println("Dados desencriptados: " + decryptedData);
        }catch (Exception e) {
        	e.printStackTrace();
        }
        
        

        
        //MAIN PT.2
        
        
        thread.start();
		int id = 0;
		int contador = 0;
		
		/*
		 * Dentro do loop 'do while' é requisitado o status do motor atual que está sendo trabalhado na
		 * thread e o mesmo é mostrado no console e passado para uma nova lista 'status', para que
		 * por essa lista possam ser realizadas as operações posteriores de complexidade algoritmica.
		 * Tudo isso é realizado durante pauses de 2 segundos.
		 */
		do {
			contador++;
			id++;
			synchronized(statusMotores) {
				if (!statusMotores.isEmpty()) {
					MotorStatus motorStatus = statusMotores.remove(0);
					try {
					String decryptedData = crypter.decryptData(motorStatus.getStatus(), encryptionKey);
					System.out.println(id - 1 + ": "+ decryptedData);
					status.add(new MotorStatus(motorStatus.getTemperatura(), decryptedData));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
			
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(contador <= 10);
		minhaThread.parar();
		
		
		/*
		 * Chamada do método compararTemperaturaMotores() para realizar a comparação entre 3 mo-
		 * tores aleatórios.
		 */
		System.out.println("Comparação dos motores: \n");
		System.out.println(OperacoesMatematicas.compararTemperaturaMotores(status));

		/*
		 * Chamada do método ordenarMotoresPorTemperatura() para ordenar os motores em ordem
		 *crescente.
		 */
		Ordenador.ordenarMotoresPorTemperatura(status);
		System.out.println("Lista de Motores organizada confome a temperatura dos mesmos: \n");
		for (int i = 0; i < status.size(); i++) {
			System.out.println((1 + i) + ": " + status.get(i).getStatus());
			
		}	
        
        
      
    }
}
