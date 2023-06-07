package Operacoes;

import java.util.ArrayList;
import java.util.Random;

import carro.Motor;
import carro.MotorStatus;

public class OperacoesMatematicas {
	
	/* Algoritmo feito para gerar números aleatórios entre
	 * 80 e 120, mas com uma probabilidade maior de 30%
	 * de ser gerado o número 90 através do if no qual gera
	 * um número Double que se for menor que 0,3 é retor-
	 * nado o número 90 no lugar do aleatório da variável
	 * número.
	 */
	public static Integer gerarTemperatura() {
		Random rand = new Random();
	    int numero = rand.nextInt(41) + 80;

	    if (rand.nextDouble() < 0.3) {
	      return numero = 90;
	    }
	    return numero;
	}

	/*
	 * Método criado para cálcular o desgaste no motor do carro conforme a sua
	 * temperatura for maior ou igual a 104ºC. Se essa condição for atendida a
	 * variável 'danoMotor' receberá a temperatura atual vezes 0,085%, que indi-
	 * cará o dano sofrido pelo motor.
	 */
	public static Double calculoDesgasteMotor(Motor motor) {
	    Double danoMotor = 0.0;
	    if (motor.getTemperatura() >= 104) {
	        motor.setDanoMotor(motor.getTemperatura() * 0.085);
	    }
	    
	    return danoMotor;
	}
	
	/*
	 * Método criado para comparar temperatura de 3 motores da lista recebida ordenada no main.
	 * Será comparada dentro da condição if qual das trẽs temperaturas é a maior e após tal com-
	 * paração será retornado em String os trẽs motores e o motor com maior temperatura será
	 * apontado como o primeiro entre os 3. O método utiliza a complexidade de algorítmos O(3^N),
	 * pois necessita comparar a temperatura de 3 motores, sendo assim um 'for' estando a frente do
	 * outro comparando-se com o seu antecessor. A consequência de se introduzir muitos dados no
	 * código é a lentidão ser a principal vilã nesse caso. O algoritmo pode gerar uma situação de bru-
	 * te force, pois ele contém três loops aninhados que percorrem uma lista de 10 elementos cada
	 * verificacndo todas as combinações possíveis de três motores para encontrar o que tem maior
	 * temperatura, sendo assim se a lista de status motores for muito grande, o número de intera-
	 * ções pode aumentar significativamente, tornando o algoriimto ineficiente e lento.
	 */
	public static String compararTemperaturaMotores(ArrayList<MotorStatus> statusMotores) {
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 10; j++) {
			for(int k = 0; k < 10; k++) {
				
				if(statusMotores.get(i).getTemperatura() > statusMotores.get(j).getTemperatura() &&
						statusMotores.get(j).getTemperatura() > statusMotores.get(k).getTemperatura()) {
					return "{ \n" +  "1: " + statusMotores.get(i).getStatus() +", \n" + "2: " + statusMotores.get(j).getStatus()
							+ ", \n" +" 3: "+statusMotores.get(k).getStatus()+ "} " +"\n" 
						+ "\nMotor com maior temperatura entre os três: \n \n1:"+ statusMotores.get(i).getStatus();
				}
				}
			}
		}
	return "";
	}
}