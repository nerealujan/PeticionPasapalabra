
public class Pregunta {
private  String letra;
private  String posicion;
private  String definicion;
private  String solucion;
public Pregunta(String letra, String posicion, String definicion,
		String solucion) {
	super();
	this.letra = letra;
	this.posicion = posicion;
	this.definicion = definicion;
	this.solucion = solucion;
}
public String getLetra() {
	return letra;
}
public String getPosicion() {
	return posicion;
}
public String getDefinicion() {
	return definicion;
}
public String getSolucion() {
	return solucion;
}


}
