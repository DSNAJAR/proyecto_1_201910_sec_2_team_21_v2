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

public class Controller {

	public static final String DATOS_ENERO = "./data/Moving_Violations_Issued_in_January_2018.csv";
	
	public static final String DATOS_FEBRERO = "./data/Moving_Violations_Issued_in_February_2018.csv";
	
	public static final String DATOS_MARZO = "./data/Moving_Violations_Issued_in_March_2018.csv";
	
	public static final String DATOS_ABRIL = "./data/Moving_Violations_Issued_in_April_2018.csv";
	
	public static final String DATOS_MAYO = "./data/Moving_Violations_Issued_in_May_2018.csv";
	
	public static final String DATOS_JUNIO = "./data/Moving_Violations_Issued_in_June_2018.csv";
	
	public static final String DATOS_JULIO = "./data/Moving_Violations_Issued_in_July_2018.csv";
	
	public static final String DATOS_AGOSTO = "./data/Moving_Violations_Issued_in_August_2018.csv";
	
	public static final String DATOS_SEPTIEMBRE = "./data/Moving_Violations_Issued_in_September_2018.csv";
	
	public static final String DATOS_OCTUBRE = "./data/Moving_Violations_Issued_in_Octomber_2018.csv";
	
	public static final String DATOS_NOVIEMBRE = "./data/Moving_Violations_Issued_in_November_2018.csv";
	
	public static final String DATOS_DICIEMBRE = "./data/Moving_Violations_Issued_in_December_2018.csv";
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
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
	 * 
	 * @return
	 */
	public IQueue <VOMovingViolations> getSameObjectId () {
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public IQueue <VOMovingViolations> searchMovingViolations (String pFecha1, String pFecha2) {
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getFINEAMTPromedio (String pViolationCode) {
		return 0;
	}
	
	/**
	 * 
	 * @param pAddressId
	 * @return
	 */
	public IStack <VOMovingViolations> searchMVAddress (String pAddressId, String pFecha1, String pFecha2) {
		return null;
	}
	
	/**
	 * 
	 * @param minFINEAMT
	 * @param maxFINEAMT
	 * @return
	 */
	public IQueue <VOViolationCode> getViolationsCode (int minFINEAMT, int maxFINEAMT) {
		return null;
	}
	
	/**
	 * 
	 * @param minTotalPaid
	 * @param maxTotalPaid
	 * @return
	 */
	public IStack <VOMovingViolations> getMVByTotalPaid (int minTotalPaid, int maxTotalPaid) {
		return null;
	}
	
	/**
	 * 
	 * @param horaInicial
	 * @param horaFinal
	 * @return
	 */
	public IQueue <VOMovingViolations> getMVBySpecificHour (String horaInicial, String horaFinal) {
		return null;
	}
	
	/**
	 * 
	 * @param pViolationCode
	 * @return
	 */
	public int getFINEAMTPromNdesviation (String pViolationCode) {
		return 0;
	}
	
	/**
	 * 
	 * @param pHora1
	 * @param pHora2
	 * @return
	 */
	public int getNInfraccionesAtDay (int pHora1, int pHora2) {
		return 0;
	}
}
