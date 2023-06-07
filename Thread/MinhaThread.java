package Thread;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.crypto.spec.SecretKeySpec;

import Crypter.CrypterKey;
import Operacoes.OperacoesMatematicas;
import carro.Motor;
import carro.MotorStatus;
import carro.Painel;
import carro.Sensor;

public class MinhaThread implements Runnable {
	
	private SecretKeySpec encryptionKey;

	CrypterKey crypter = new CrypterKey();
	
	
	DecimalFormat df = new DecimalFormat("#,##0.0");

    private ArrayList<MotorStatus> statusMotores;
    
    private volatile boolean isRunning = true;
    
    public MinhaThread( ArrayList<MotorStatus> statusMotores) {
        this.statusMotores = statusMotores;
    }
    Sensor sensor = new Sensor();
    Painel painel = new Painel(false);

    /*
     * O método void run() executa um loop while enquanto a variavel 'isRunning' for true. Dentro do loop
     * é gerada a temperatura aleatoria pela chamada do metodo 'gerarTemperatura(), essa mesma tem-
     * peratura é passada como parametro para a instanciação do motor juntamente com o RPM padrão.
     * Após isso é chamado o sensor para analisar o motor atual, e essa o resultado dessa analise é passa-
     * do para dentro da lista statusMotores. Tudo isso ocorre durante intervalos de 2 segundos.
     */   

    public void run() {
    	while (isRunning) {
    		int temperatura = OperacoesMatematicas.gerarTemperatura();
            Motor motor = new Motor(temperatura, 2000);
            OperacoesMatematicas.calculoDesgasteMotor(motor);
            try {
            	String status = (String) sensor.tratarTemperatura(motor, painel);
            	String ecryptedData = crypter.encryptData(status, getEncryptionKey());
            	synchronized (statusMotores) {
                	statusMotores.add(new MotorStatus(temperatura, ecryptedData));
    			}  
            } catch (Exception e) {
            	e.printStackTrace();
            }
           
            
            if(temperatura >= 110) {
            	System.out.println("\n ");
				System.out.println("====================");;
	    		System.out.println("||   ALERTA de dano ao motor!  ||");
	    		System.out.println("====================");
	    		
				System.out.println("O motor esta com a temperatura acima do normal."); 
				System.out.println("Dano de "+ df.format(motor.getDanoMotor()) + "% consideravel no motor \n");
				
				System.out.println("=================================");
				System.out.println("INFORMACOES: \n");

		}
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /*
     * Método void que determina o valor da variavel 'isRunning' para false.
     */
    public void parar() {
    	isRunning = false;
    }
    
	public SecretKeySpec getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(SecretKeySpec encryptionKey) {
		this.encryptionKey = encryptionKey;
	}
    
}