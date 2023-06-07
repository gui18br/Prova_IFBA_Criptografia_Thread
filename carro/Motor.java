package carro;

public class Motor{

	private int temperatura;
	private int rpm;
	private double danoMotor;
	
	public Motor() {
		
	}
	
	public Motor(int temperatura, int rpm) {
		this.temperatura = temperatura;
		this.rpm = rpm;
	}
	
	
	public boolean ventoinhaLigada() {
		return true;
	}

	public int getTemperatura() {
		return temperatura;
	}
	
	public int aumentoDoRPM() {
		return setRpm(getRpm() + 500);
		
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getRpm() {
		return rpm;
	}

	public int setRpm(int rpm) {
		return this.rpm = rpm;
	}

	@Override
	public String toString() {
		return "Motor [temperatura=" + temperatura + ", rpm=" + rpm + "]";
	}

	public double getDanoMotor() {
		return danoMotor;
	}

	public void setDanoMotor(double danoMotor) {
		this.danoMotor = danoMotor;
	}
}