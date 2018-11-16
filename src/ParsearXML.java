import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class ParsearXML {

	public static ArrayList<Pregunta> parsear(String xml_respuesta) {
		ArrayList<Pregunta> lista_preguntas=new ArrayList<Pregunta>();
		
		SAXBuilder builder=new SAXBuilder();
		InputStream stream;
		try {
			stream = new ByteArrayInputStream(xml_respuesta.getBytes("UTF-8"));
			Document documento=builder.build(stream);
			Element raiz=documento.getRootElement();
			List<Element> lista_jugadores=raiz.getChildren("jugador");
			Element elemento_jugador=lista_jugadores.get(0);
			List<Element> lista_elementos_pregunta=elemento_jugador.getChildren("pregunta");
			
			for (Element element : lista_elementos_pregunta) {
				Element elemento_letra=element.getChild("letra");
				Element elemento_posicion=element.getChild("posicion");
				Element elemento_definicion=element.getChild("definicion");
				Element elemento_solucion=element.getChild("solucion");
				String letra=elemento_letra.getText();
				String posicion=elemento_posicion.getText();
				String definicion=elemento_definicion.getText();
				String solucion=elemento_solucion.getText();
				Pregunta p=new Pregunta(letra, posicion, definicion, solucion);	
				lista_preguntas.add(p);
			}
			System.out.println(raiz.getName());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_preguntas;
	}

}
