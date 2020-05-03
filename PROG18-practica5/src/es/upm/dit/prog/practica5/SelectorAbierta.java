package es.upm.dit.prog.practica5;

import java.util.List;

public class SelectorAbierta implements SelectorLocalizacion {
	private double umbral;
	
	public SelectorAbierta(double umbral) {
		this.umbral=umbral;
	}
	
	public boolean esValida(Localizacion loc) {
		if(loc != null) {
			List<Lectura> lecturas= loc.copiaDeLecturas();
			for(int i=0;i<lecturas.size();i++) {
				if(lecturas != null && lecturas.get(i).getPotencia() >= umbral && lecturas.get(i).getRed().getSeguridad() == Seguridad.ABIERTA) {
					return true;
				}
			}
		}
		return false;
	}

}
