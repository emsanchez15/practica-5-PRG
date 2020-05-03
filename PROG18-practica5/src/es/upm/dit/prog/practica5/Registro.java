package es.upm.dit.prog.practica5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registro {
	
	private List<Localizacion> locs;
	
	public Registro () {
		this.locs = new ArrayList<Localizacion> (); 
	}
	
	@Override
	public String toString() {
		return "Registro [locs=" + locs + "]";
	}

	public boolean add(Localizacion l) {
		if(l != null) {
			for (int i=0; i<locs.size(); i++) {
				locs.add(l);
			}
		}
		return false;
	}
	
	public Localizacion getLocalizacion(int n) {
			if(n>=0 && n<=locs.size() && this.locs != null) {
				return locs.get(n);
			}
		return null;
	}
	
	
	List<Localizacion> getLocalizaciones (SelectorLocalizacion s){
			List<Localizacion> locs2 = new ArrayList<Localizacion> ();
			if (s != null) {
				for (int i=0; i< locs.size(); i++) {
					if (s.esValida(locs.get(i))) {
						locs2.add(locs.get(i));
					}
				}
			}
		return locs2;
	}
	
}
