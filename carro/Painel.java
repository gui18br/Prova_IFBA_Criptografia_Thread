package carro;

public class Painel {
	
	private boolean luzAlertaTemp;
	
	public Painel(boolean luzAlertaTemp) {
		this.luzAlertaTemp = luzAlertaTemp;
	}

	public boolean isLuzAlertaTemp() {
		return luzAlertaTemp;
	}

	public void setLuzAlertaTemp(boolean luzAlertaTemp) {
		this.luzAlertaTemp = luzAlertaTemp;
	}
	
	public void acenderluz() {
		 this.luzAlertaTemp = true;
	}
	
	public void apagarLuz() {
		this.luzAlertaTemp = false;
	}
		
}