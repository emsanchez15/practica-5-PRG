package es.upm.dit.prog.practica5;

public class SelectorAND implements SelectorLocalizacion {
	
	private SelectorLocalizacion s1;
	private SelectorLocalizacion s2;
	
	public SelectorAND (SelectorLocalizacion s1, SelectorLocalizacion s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public boolean esValida(Localizacion loc) {
		if(this.s1 != null && this.s2 != null) {
			return s1.esValida(loc) && s2.esValida(loc);
		}
		return false;
	}
}
