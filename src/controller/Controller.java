package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Nodo;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;
import model.vo.VOViolationCode;
import sun.reflect.generics.tree.VoidDescriptor;
import view.MovingViolationsManagerView;

/**
 * Esta clase representa el controlador de los datos
 */
public class Controller {
	
	//---------------------------------------------------------------------------------------------------
	// Constantes
	// --------------------------------------------------------------------------------------------------

	/**
	 * Constante que representa los datos de las infracciones realizadas en Enero
	 */
	public static final String DATOS_ENERO = "./data/Moving_Violations_Issued_in_January_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Febrero
	 */
	public static final String DATOS_FEBRERO = "./data/Moving_Violations_Issued_in_February_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Marzo
	 */
	public static final String DATOS_MARZO = "./data/Moving_Violations_Issued_in_March_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Abril
	 */
	public static final String DATOS_ABRIL = "./data/Moving_Violations_Issued_in_April_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Mayo
	 */
	public static final String DATOS_MAYO = "./data/Moving_Violations_Issued_in_May_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Junio
	 */
	public static final String DATOS_JUNIO = "./data/Moving_Violations_Issued_in_June_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Julio
	 */
	public static final String DATOS_JULIO = "./data/Moving_Violations_Issued_in_July_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Agosto
	 */
	public static final String DATOS_AGOSTO = "./data/Moving_Violations_Issued_in_August_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Septiembre
	 */
	public static final String DATOS_SEPTIEMBRE = "./data/Moving_Violations_Issued_in_September_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Octubre
	 */
	public static final String DATOS_OCTUBRE = "./data/Moving_Violations_Issued_in_Octomber_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Noviembre
	 */
	public static final String DATOS_NOVIEMBRE = "./data/Moving_Violations_Issued_in_November_2018.csv";
	
	/**
	 * Constante que representa los datos de las infracciones realizadas en Diciembre
	 */
	public static final String DATOS_DICIEMBRE = "./data/Moving_Violations_Issued_in_December_2018.csv";
	
	//--------------------------------------------------------------------------------------------------
	// Atributos
	//--------------------------------------------------------------------------------------------------
	
	/**
	 * Es el formato que se usara para las fechas
	 */
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	/**
	 * Es la referencia al view
	 */
	private MovingViolationsManagerView view;
	
	/**
	 * Cola donde se van a cargar los datos de los archivos
	 */
	private Queue<VOMovingViolations> movingViolationsQueue;
	
	/**
	 * Pila donde se van a cargar los datos de los archivos
	 */
	private Stack<VOMovingViolations> movingViolationsStack;
	
	/**
	 * Cautrimestre del cual se subiran los datos - 1(Enero - Abril), 2(Mayo - Agosto) o 3(Septiembre - Diciembre)
	 */
	public int cuatrimestre;
	
	//-----------------------------------------------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------------------------------------------
	
	/**
	 * Construye un nuevo controlador con una pila y una cola.
	 * <b>post:</b> se construyo  un nuevo controlador con una cola y una pila
	 * La pila esta vacía <br>
	 * La cola esta vacía <br> 
	 */
	public Controller() {
		view = new MovingViolationsManagerView();
		
		//TODO, inicializar la pila y la cola
		movingViolationsQueue = null;
		movingViolationsStack = null;
	}
	
	public void run() throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		
		while(fin == false)
		{
			view.printMenu();
			
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					view.printMensage("Ingrese el número del cuatrimestre a cargar");
					view.printMenu2();
					cuatrimestre = sc.nextInt();
					switch(cuatrimestre) {
					case 1:
						this.loadMovingViolations(1);
						view.printMensage("Se cargo la información de los meses Enero - Abril");
						break;
					case 2:
						this.loadMovingViolations(2);
						view.printMensage("Se cargo la información de los meses mayo - Agosto");
						break;
					case 3:
						this.loadMovingViolations(3);
						view.printMensage("Se cargo la información de los meses Septiembre - Diciembre");
						break;
					}
					break;
					
				case 2:
					IQueue<VOMovingViolations> sameObjectID = this.getSameObjectId();
					view.prin
					view.printDailyStatistics(dailyStatistics);
					break;
					
				case 3:
					view.printMensage("Ingrese el nÃºmero de infracciones a buscar");
					int n = sc.nextInt();

					IStack<VOMovingViolations> violations = this.nLastAccidents(n);
					view.printMovingViolations(violations);
					break;
											
				case :	
					fin=true;
					sc.close();
					break;
			}
		}
	}

	

	public void loadMovingViolations(int pCuatrimestre) throws Exception{
		// TODO
		movingViolationsQueue = new Queue<VOMovingViolations>();
		int nCuatrimestre = pCuatrimestre;
		boolean cargaCompleta = false;
		int i = 0;
		String mes = null;
		
		while(cargaCompleta)
		{
			if(nCuatrimestre == 1)
			{
				if(i == 0)
				{
					mes = DATOS_ENERO;
					i++;
				}
				if(i == 1)
				{
					mes = DATOS_FEBRERO;
					i++;
				}
				if(i == 2)
				{
					mes = DATOS_MARZO;
					i++;
				}
				if(i == 3)
				{
					mes = DATOS_ABRIL;
					i = 0;
					cargaCompleta = true;
				}
			}
			if(nCuatrimestre == 2)
			{
				if(i == 0)
				{
					mes = DATOS_MAYO;
					i++;
				}
				if(i == 1)
				{
					mes = DATOS_JUNIO;
					i++;
				}
				if(i == 2)
				{
					mes = DATOS_JULIO;
					i++;
				}
				if(i == 3)
				{
					mes = DATOS_AGOSTO;
					i = 0;
					cargaCompleta = true;
				}
			}
			if(nCuatrimestre == 3)
			{
				if(i == 0)
				{
					mes = DATOS_SEPTIEMBRE;
					i++;
				}
				if(i == 1)
				{
					mes = DATOS_OCTUBRE;
					i++;
				}
				if(i == 2)
				{
					mes = DATOS_NOVIEMBRE;
					i++;
				}
				if(i == 3)
				{
					mes = DATOS_DICIEMBRE;
					i = 0;
					cargaCompleta = true;
				}
			}
			
			File flMovingViolations = new File(mes);
			FileReader fr = new FileReader(flMovingViolations);
			BufferedReader lector = new BufferedReader(fr);
			lector.readLine();
			
			String info = lector.readLine();
			
			while(info != null)
			{
				String[] mv = info.split(",");
				
				String objectId = mv[0].trim();
				String row = mv[1].trim();
				String location = mv[2].trim();
				String addressId = mv[3].trim();
				String streetsegId = mv[4].trim();
				String xCoord = mv[5].trim();
				String yCoord = mv[6].trim();
				String ticketType= mv[7].trim();
				String fineAMT = mv[8].trim();
				String totalPaid = mv[9].trim();
				String penalty1 = mv[10].trim();
				String penalty2 = mv[11].trim();
				String accidentIndicator = mv[12].trim();
				String ticketIssueDate = mv[13].trim();
				String violationCode = mv[14].trim();
				String violationDescription = mv[15].trim();
				String rowId = mv[16].trim();
				
				movingViolationsQueue.enqueue(new VOMovingViolations(Integer.parseInt(objectId), location, Integer.parseInt(fineAMT), ticketIssueDate, Integer.parseInt(totalPaid), accidentIndicator, violationCode, violationDescription));
				movingViolationsStack.push(new VOMovingViolations(Integer.parseInt(objectId), location, Integer.parseInt(fineAMT), ticketIssueDate, Integer.parseInt(totalPaid), accidentIndicator, violationCode, violationDescription));
			}
			if(cargaCompleta == true)
			{
				lector.close();
				fr.close();	
			}	
		}
	}
	
	/**
	 * Compara si dos objetos tienen el mismo ObjectId
	 * @return null
	 */
	public IQueue <VOMovingViolations> getSameObjectId () {
		return null;
	}
	
	/**
	 * Busca las infracciones dentro del rango de fecha inicial y final establecido.
	 * @param pFecha1 Fecha inicial para establecer la busqueda.
	 * @param pFecha2 Fecha final paara terminar la busqueda.
	 * @return null
	 */
	public IQueue <VOMovingViolations> searchMovingViolations (String pFecha1, String pFecha2) {
		return null;
	}
	
	/**
	 * Busca la infraccion con el codigo recibido y retorna el FINEAMT promedio de esta
	 * @param pViolationCode Codigo de la infracción a buscar. pViolationCode != null && pViolationCode != ""
	 * @return 0
	 */
	public int getFINEAMTPromedio (String pViolationCode) {
		return 0;
	}
	
	/**
	 * Busca las infracciones que se cometieron en una dirección, dentro de un rango de fechas y las retorna en una pila.
	 * @param pAddressId Dirección en la que se desea hacer realizar la busqueda.
	 * @param pFecha1 Fecha inicial en la que se desea realizar la busqueda. pFecha1 != null && pFecha2 != ""
	 * @param pFecha2 Fecha final en la que se desea realizar la busqueda. pFecha2 != null && pFecha2 != ""
	 * @return null
	 */
	public IStack <VOMovingViolations> searchMVAddress (String pAddressId, String pFecha1, String pFecha2) {
		return null;
	}
	
	/**
	 * Busca las infracciones que se encuentran dentro del rango de FINEAMT y las agrega a la cola.
	 * @param minFINEAMT FINEAMT minimo para agregar la infracción en la cola. minFINEAMT > 0
	 * @param maxFINEAMT FINEAMT maximo para agregar la infracción en la cola. maxFINEAMT > minFINEAMT
	 * @return null
	 */
	public IQueue <VOViolationCode> getViolationsCode (int minFINEAMT, int maxFINEAMT) {
		return null;
	}
	
	/**
	 * Busca las infracciones por el total pagado, dentro de un rango de pago.
	 * @param minTotalPaid Cantidad minima del TOTALPAID para agregar la infraccion en la pila. minTotalPaid > 0
	 * @param maxTotalPaid Cantidad máxima del TOTALPAID para agregar la infracción en la pila. maxTotalPaid > minTotalPaid
	 * @return null
	 */
	public IStack <VOMovingViolations> getMVByTotalPaid (int minTotalPaid, int maxTotalPaid) {
		return null;
	}
	
	/**
	 * Busca las infracciones realizadas en un rango de hora final e inicial y las agrega en una cola.
	 * @param horaInicial Hora inicial del rango. horaInicial >= 0
	 * @param horaFinal Hora final del rango. horaFinal > horaInicial && horaInicial <= 24
	 * @return null
	 */
	public IQueue <VOMovingViolations> getMVBySpecificHour (String horaInicial, String horaFinal) {
		return null;
	}
	
	/**
	 * Busca una infracción por su codigo y retorna su FINEAMT promedio con la desviación estandar de este.
	 * @param pViolationCode Codigo de la infracción a buscar. pViolationCode != null && pViolationCode != ""
	 * @return 0
	 */
	public int getFINEAMTPromNdesviation (String pViolationCode) {
		return 0;
	}
	
	/**
	 * Retorna el numero de infracciones cometidas dentro de un rango de horas.
	 * @param pHora1 Hora en la que se inicia la búsqueda. pHora1 >= 0
	 * @param pHora2 Hora en la que se termina la búsqueda. pHora2 > pHora1 && pHora2 <= 24
	 * @return 0
	 */
	public int getNInfraccionesAtDay (int pHora1, int pHora2) {
		return 0;
	}
	
	/**
	 * 
	 * @param args
	 */
	public void getGraficaASCII (String[] args) {
		
	}
	
	public double getDeudaTotal (String pFecha1, String pFecha2) {
		return 0.0;
	}
	
	public void geGraficaASCIIdeudaAcumuladaTotal () {
		
	}
}
