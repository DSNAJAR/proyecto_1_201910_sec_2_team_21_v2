package view;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.vo.VOMovingViolations;

public class MovingViolationsManagerView 
{
	public MovingViolationsManagerView() {
		
	}
	
	/**
	 * Imprime el menu al iniciar el programa con las diferentes opciones a escoger.
	 */
	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Proyecto 1--------------------");
		System.out.println("--------------David Ruiz & David Najar-------------");
		System.out.println("1.  Cree una nueva coleccion de infracciones en movimiento, a partir de un cuatrimestre");
		System.out.println("2.  Verificar que todas las infracciones poseen un unico id");
		System.out.println("3.  Consultar infracciones ocurridas en cierto rango de fecha");
		System.out.println("4.  Consultar FINEAMT promedio cuando hubo o no accidente");
		System.out.println("5.  Consultar las infracciones en una dirección y en un rango de fecha");
		System.out.println("6.  Consultar los tipos de de infracciones con su valor FINEAMT promedio en un rango");
		System.out.println("7.  Consultar infracciones donde la cantidad pagada está en un rango dado");
		System.out.println("8.  Consultar infracciones por hora inicial	y hora final");
		System.out.println("9.  Consultar el FINEAMT promedio y su desviación estándar según el tipo de infracción");
		System.out.println("10. Consultar el número de infracciones que ocurrieron en un rango de horas del día");
		System.out.println("11. Ver grafica ASCII con el porcentaje de infracciones que tuvieron accidentes por hora del día");
		System.out.println("12. La deuda total por infracciones que se dieron en un rango de fechas");
		System.out.println("13. Grafica ASCII con la deuda acumulada total por infracciones");
		System.out.println("14. Salir");
		System.out.println("Digite el nï¿½mero de opciï¿½n para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
	
	/**
	 * Imprime el menu con las opciones de cuatrimestre a cargar para que el programa corra.
	 */
	public void printMenu2() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Proyecto 1--------------------");
		System.out.println("--------------David Ruiz & David Najar-------------");
		System.out.println("1. Enero - Abril");
		System.out.println("Mayo - Agosto");
		System.out.println("Septiembre - Diciembre");
	}
	
	/**
	 * Imprime un mensaje
	 * @param mensaje Mensaje a imprimir. mensaje != null && mensaje != ""
	 */
	public void printMensage(String mensaje) {
		System.out.println(mensaje);
	}
}
