package es.upm.dit.prog.practica5;

public class SelectorDistancia implements SelectorLocalizacion {
	
	private double d;
	private Coordenada c;
	
	public SelectorDistancia(Coordenada c, double d) {
		this.d = d;
		this.c = c;
	}
	
	public boolean esValida(Localizacion loc) {
		if(loc != null && loc.getC() != null && this.c != null && loc.getC().distancia(c)<= d) {
			return true;
		}
		return false;
	}
}
