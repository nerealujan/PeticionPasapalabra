import java.util.ArrayList;


public class ClasePrincipal {
static int puntuacion=0;
	public static void main(String[] args) {
		//Opciones
		int opcion=EntradaSalida.mostrarMenu();
		
		//1 jugar 2 listar 3 salir
		while(opcion!=3)
		{
			switch(opcion)
			{
			case 1:
				
				//jugar
				int partida=EntradaSalida.pedirPartida();
				String xml_respuesta=ConexionURL.pedirXML(partida);
				ArrayList<Pregunta> lista=ParsearXML.parsear(xml_respuesta);
				jugar(lista);
				break;
			case 2:
				int partida_listar=EntradaSalida.pedirPartida();
				String xml_respuesta_listar=ConexionURL.pedirXML(partida_listar);
				ArrayList<Pregunta> lista_listar=ParsearXML.parsear(xml_respuesta_listar);
				EntradaSalida.mostrarPartida(lista_listar);
				
				break;
			
			}
			
			
			
			opcion=EntradaSalida.mostrarMenu();
		}
	}

	private static void jugar(ArrayList<Pregunta> lista) {
		for (Pregunta pregunta : lista) {
			String respuesta_usr=EntradaSalida.hacerPregunta(pregunta);
			if(respuesta_usr.equalsIgnoreCase(pregunta.getSolucion()))
			{
				
				puntuacion++;
				System.out.println("Correcto, llevas "+puntuacion+" puntos");
			}
			else
			{
				System.out.println("Incorrecto. Era:"+pregunta.getSolucion());
			}
		}
		
	}

}
