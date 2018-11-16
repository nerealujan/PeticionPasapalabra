import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class EntradaSalida {

	public static int mostrarMenu() {
		boolean entrada_correcta=false;
		int opcion=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("1-Jugar");
		System.out.println("2-Mostrar partida");
		System.out.println("3-Salir");
		while(entrada_correcta==false)
		{
				try
				{
				 opcion=sc.nextInt();
				 entrada_correcta=true;
				}
				catch(InputMismatchException excecpcion)
				{
					sc.nextLine();
					System.out.println("Error");
				}
		}
		return opcion;
	}
	public static int pedirPartida() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Por favor, introduzca el número de partida");
		int opcion=sc.nextInt();
		return opcion;
	}
	public static String hacerPregunta(Pregunta pregunta) {
		Scanner sc=new Scanner(System.in);
		System.out.println(pregunta.getPosicion()+": "+pregunta.getLetra());
		System.out.println(pregunta.getDefinicion());
		String respuesta=sc.nextLine();
		return respuesta;
		
	}
	public static void mostrarPartida(ArrayList<Pregunta> lista_listar) {
		for (Pregunta pregunta : lista_listar) {
			System.out.println(pregunta.getPosicion()+": "+pregunta.getLetra());
			System.out.println(pregunta.getDefinicion()+" SOLUCIÓN:"+pregunta.getSolucion());
		}
		
	}

}
