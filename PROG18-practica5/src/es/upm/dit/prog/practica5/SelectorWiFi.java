package es.upm.dit.prog.practica5;

import java.util.List;

public class SelectorWiFi implements SelectorLocalizacion {
	
	private WiFi red;
	private double umbral;
	
	public SelectorWiFi( WiFi red, double umbral) {
		this.red = red;
		this.umbral = umbral;
	}
	
	public boolean esValida(Localizacion loc) {
	if (loc != null && red != null) {
		List<Lectura> lecturas = loc.copiaDeLecturas();
		for (int i=0; i< lecturas.size(); i++) {
			if(lecturas.get(i).getPotencia() >= umbral && this.red.equals(lecturas.get(i).getRed())) {
				return true;
			}
		}
	}
	return false;
}
	
}
