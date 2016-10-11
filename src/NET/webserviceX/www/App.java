package NET.webserviceX.www;

public class App {

	public static void main(String[] args) {
		System.out.println("Global service");

		final GlobalWeatherSoapProxy wsClient = new GlobalWeatherSoapProxy();
		try {

			final String sCiudades = wsClient.getCitiesByCountry("Spain");

			// limpiar xml y quedarnos con los valores
			final String sCiudadesSinXML = sCiudades.replaceAll("\\<.*?>", "");

			// trocear el string por 'Spain'
			final String[] ciudades = sCiudadesSinXML.split("Spain");

			// limpiar espacios en blanco a derecha e izquierda
			for (final String ciudad : ciudades) {
				System.out.println(ciudad.trim());
			}

		} catch (final Exception e) {
			e.printStackTrace();
			System.out.println("Excepcion llamando a webservice");
		}
	}

}
