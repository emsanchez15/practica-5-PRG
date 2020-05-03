package es.upm.dit.prog.practica5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Localizacion{
	
	private Coordenada c;
	private List<Lectura> lecturas;
	
	
	public Localizacion(Coordenada c) {
		this.c = c;
		this.lecturas = new ArrayList<Lectura>();
	}
	
	@Override
	public String toString() {
		return "Localizacion [c=" + c + ", lecturas=" + lecturas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((lecturas == null) ? 0 : lecturas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localizacion other = (Localizacion) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (lecturas == null) {
			if (other.lecturas != null)
				return false;
		} else if (!lecturas.equals(other.lecturas))
			return false;
		return true;
	}



	public Coordenada getC() {
		return c;
	}

	public void setC(Coordenada c) {
		this.c = c;
	}
	
	public Lectura getLectura(int n) {
		if (n >= 0 && n <= (lecturas.size()))	{
			return lecturas.get(n) ;
		}
		return null;
	}

	public boolean addLectura(Lectura l){
		if(l!= null) {
				lecturas.add(l);
		}
		return false;	
	}
	
	//[null, 1, 13,52, null]
	
	
	List<Lectura> copiaDeLecturas() {
		return  lecturas;	
	}
	
}



	
	

