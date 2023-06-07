package carro;

public class DetalhesMotores {

	public int temperatura;
	public double danoMotor;
	
	public DetalhesMotores(int temperatura, double danoMotor) {
		super();
		this.temperatura = temperatura;
		this.danoMotor = danoMotor;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public double getDanoMotor() {
		return danoMotor;
	}

	public void setDanoMotor(double danoMotor) {
		this.danoMotor = danoMotor;
	}
	
	
}
