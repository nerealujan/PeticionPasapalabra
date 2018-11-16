import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class ConexionURL {

	public static String pedirXML(int partida)  {
		// TODO Auto-generated method stub
		String ruta_peticion="http://formadorestic.com/pasapalabra/carga.php?entorno=1&IDpartida="+partida;
		
			URL url;
			String aux="";
			try {
				url = new URL(ruta_peticion);
				URLConnection conn = url.openConnection();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String linea=rd.readLine();
				while(linea!=null)
				{
					aux+=linea;
					linea=rd.readLine();
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return aux;
	}

}
