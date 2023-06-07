package carro;

public class MotorStatus {

	private int temperatura;
	private String status;
	private Double danoMotor;
	
	public MotorStatus() {
		
	}
	
	public MotorStatus(int temperatura, String status) {
		super();
		this.temperatura = temperatura;
		this.status = status;
	}
	
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Double getDanoMotor() {
		return danoMotor;
	}

	public void setDanoMotor(Double danoMotor) {
		this.danoMotor = danoMotor;
	}
}