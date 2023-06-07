package carro;

import java.text.DecimalFormat;

public class Modulo{
	
	DecimalFormat df = new DecimalFormat("#,##0.0");
	
	/*
	 * Método para realizar o tratamento da temperatura alta quando chamado pelo sensor de temperatura.
	 * Se o requesito do primeiro if for atendido, ou seja, se a temperatura do motor for maior ou igual a 104
	 * quer dizer que o motor está sobreaquecido e necessita de um tratamento específico para essa situação,
	 * que envolve a chamada do método ventoinhaLigada() para tentar controlar a temperatura e ancederLuz()
	 * para acender a luz do painel, pois com a temperatura maior ou igual a 104 o motor é prejudicado.
	 * 
	 * Se o primeiro if não for atendido o segundo é chamado apenas para ligar a ventoinha, pois a temperatura
	 * se torna realmente prejucial ao motor apenas a partir de 104ºC.
	 */
	public Object tratarTemperaturaAlta(Motor motor, Painel painel) {
		
		if (motor.getTemperatura() >= 104) {
			motor.ventoinhaLigada();
			painel.acenderluz();
			return "Temperatura do motor: " + motor.getTemperatura() + "ºC"+ "\n" + 
			"Ventoinha:  " + motor.ventoinhaLigada() + "\n" +
			"Luz do Painel: " + painel.isLuzAlertaTemp() +"\n"+ "Dano no motor: "+df.format(motor.getDanoMotor()) +"%" +"\n"; 
		} else  if (motor.getTemperatura() > 90) {
			painel.apagarLuz();
			return "Temperatura do motor: " + motor.getTemperatura() +"ºC"+ "\n" + 
					"Ventoinha:  " + motor.ventoinhaLigada() + "\n" +
					"Luz do Painel: " + painel.isLuzAlertaTemp()+"\n"+ "Dano no motor: "+df.format(motor.getDanoMotor()) +"%" +"\n"; 
		}
		return "" ;
	}
	
	/*
	 * Método para realizar o tratamento da temperatura baixa quando chamado pelo sensor. O método em sí
	 * apenas irá retornar um aumento no RPM de 2000 (RPM padrão) para 2500, pois como a temperatura 
	 * está baixa o motor necessita apenas de aumentar o RPM para gerar um aquecimento no mesmo.
	 */
	public Object tratarTemperaturaBaixa(Motor motor, Painel painel) {
		
		return "Temperatura do motor: " + motor.getTemperatura()+ "ºC"+"\n"
		+ "Giro RPM: " + motor.aumentoDoRPM()+"\n"+ "Dano no motor: "+df.format(motor.getDanoMotor()) +"%" +"\n";

	}

	/*
	 * Método para realizar o tratamento da temperatura quando a mesma se encontra normal. O retorno desse
	 * método não retornará nada além da sua temperatura, pois como a mesma se encontra em estado normal
	 * nada necessita ser feito.
	 */
	public Object tratarTemperaturaNormal(Motor motor, Painel painel) {
		return  "Temperatura do motor: " + motor.getTemperatura() +"ºC"+"\n"+ "Dano no motor: "+df.format(motor.getDanoMotor()) +"%" +"\n";
	}

}