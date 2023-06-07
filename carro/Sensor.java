package carro;

public class Sensor {
	Modulo modulo = new Modulo();
	
	/*
	 * Método criado para sensoriar a temperatura do motor passado na classe Main.
	 * Conforme recebido o motor como parâmetro, será chamado um método para
	 * cada condição atendida conforme a temperatura passada for indicada maior a
	 * 90ºC (Alta), menor que 90ºC (Baixa) ou igual a 90ºC (Normal).
	 */
	public Object tratarTemperatura(Motor motor, Painel painel) {
		
		if(motor.getTemperatura() > 90) {
			return modulo.tratarTemperaturaAlta(motor, painel);
		}else if(motor.getTemperatura() < 90) {
			return modulo.tratarTemperaturaBaixa(motor, painel);
		}else if(motor.getTemperatura() == 90) {
			return modulo.tratarTemperaturaNormal(motor, painel);
		}
		
		return "";
	}

}