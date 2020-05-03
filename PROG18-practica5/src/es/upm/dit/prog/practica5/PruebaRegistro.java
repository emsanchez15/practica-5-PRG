package es.upm.dit.prog.practica5;

import java.util.ArrayList;
import java.util.List;

public class PruebaRegistro {
	private static void imprimeLocs (List<Localizacion> locs){
		for (Localizacion l: locs)
			System.out.println(l);		
	}
	
	public static void main (String[] args) {
		WiFi[] wifis = new WiFi[4];
		Seguridad [] segs = {
				Seguridad.ABIERTA, 
				Seguridad.WEP, 
				Seguridad.WPA2_PERSONAL,
				Seguridad.WPA2_EMPRESA
		}; 
		for (int i = 0; i < wifis.length; i++){
			wifis[i] = new WiFi("WiFi" + i, segs[i]);
		}

		List<Localizacion> locs = new ArrayList<Localizacion> ();
		for (int i = 0; i < 6; i++){
			Localizacion loc = new Localizacion(new Coordenada (i*10, i*10));
			for (int j = 0; j < wifis.length; j++) {
				double potencia = - 10 * (j + i + 3);
				if (potencia > -90)
					loc.addLectura(new Lectura(wifis[j], potencia));
			}
			locs.add(loc);
		}

		Registro r = new Registro();
		System.out.println("New Registro=" + r);

		for (int i = 0; i < locs.size(); i++){
			boolean anade= r.add(locs.get(i));
			System.out.println("add " + i  + "=" + anade);				
		}

		System.out.println("r.getLocalizacion(0)=" + r.getLocalizacion(0));
		System.out.println("r.getLocalizacion(6)=" + r.getLocalizacion(6));

		List<Localizacion> locs2 = r.getLocalizaciones(new SelectorTrue());
		System.out.println("getLocalizaciones=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorDistancia(new Coordenada (0,0), 70));
		System.out.println("getLocalizaciones distancia (0,0), 70=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorWiFi(wifis[0], -70));
		System.out.println("getLocalizaciones SelectorWiFi(wifis[0], -70)=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorWiFi(wifis[3], -100));
		System.out.println("getLocalizaciones SelectorWiFi(wifis[3], -100)=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorAbierta(-70));
		System.out.println("getLocalizaciones SelectorAbierta(-70)=");
		imprimeLocs(locs2);

		SelectorLocalizacion sAND= new SelectorAND(
				new SelectorAbierta(-70), 
				new SelectorDistancia(new Coordenada (20,20), 15));
		locs2 = r.getLocalizaciones(sAND);
		System.out.println("getLocalizaciones SelectorAND=");
		imprimeLocs(locs2);
		
		SelectorLocalizacion sOR= new SelectorOR(
				new SelectorWiFi(wifis[0], -30), 
				new SelectorWiFi(wifis[1], -50));	
		locs2 = r.getLocalizaciones(sOR);
		System.out.println("getLocalizaciones SelectorOR=");
		imprimeLocs(locs2);
		
	}
}
