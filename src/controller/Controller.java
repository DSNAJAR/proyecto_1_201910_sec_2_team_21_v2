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
import sun.reflect.generics.tree.VoidDescriptor;
import view.MovingViolationsManagerView;

public class Controller {

	public static final String DATOS_ENERO = "./data/Moving_Violations_Issued_in_January_2018.csv";
	
	public static final String DATOS_FEBRERO = "./data/Moving_Violations_Issued_in_February_2018.csv";
	
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
					this.loadMovingViolations();
					break;
					
				case 2:
					IQueue<VODaylyStatistic> dailyStatistics = this.getDailyStatistics();
					view.printDailyStatistics(dailyStatistics);
					break;
					
				case 3:
					view.printMensage("Ingrese el número de infracciones a buscar");
					int n = sc.nextInt();

					IStack<VOMovingViolations> violations = this.nLastAccidents(n);
					view.printMovingViolations(violations);
					break;
											
				case 4:	
					fin=true;
					sc.close();
					break;
			}
		}
	}

	

	public void loadMovingViolations() throws Exception{
		// TODO
		movingViolationsQueue = new Queue<VOMovingViolations>();
		movingViolationsStack = new Stack<VOMovingViolations>();
		String mes = null;
		int i = 0;
		
		while(i != 2)
		{
			if(i == 0)
			{
				mes = DATOS_ENERO;
				i++;
			}
			else
			{
				mes = DATOS_FEBRERO;
				i++;
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
				
				if(i == 1)
				{
					movingViolationsQueue.enqueue(new VOMovingViolations(Integer.parseInt(objectId), location, Integer.parseInt(fineAMT), ticketIssueDate, Integer.parseInt(totalPaid), accidentIndicator, violationCode, violationDescription));
				}
				else
				{
					movingViolationsStack.push(new VOMovingViolations(Integer.parseInt(objectId), location, Integer.parseInt(fineAMT), ticketIssueDate, Integer.parseInt(totalPaid), accidentIndicator, violationCode, violationDescription));
				}
			}
			if(i!=1)
			{
				lector.close();
				fr.close();	
			}	
		}
	}
	
	public IQueue <VODaylyStatistic> getDailyStatistics () throws ParseException {
		// TODO
		Queue<VODaylyStatistic> statistics = new Queue<VODaylyStatistic>();
		Queue<VOMovingViolations> base = movingViolationsQueue;
		
		Iterator<VOMovingViolations> it = base.iterator();
		
		String fecha = null;
		int nAccidentes = 0;
		int nInfracciones = 0;
		int suma = 0;

		VOMovingViolations indicador = it.next();

		while(it.hasNext()) {
			VOMovingViolations movingViolation = it.next();
			fecha = indicador.getDate();
			String fechaCurrent = movingViolation.getDate();
			Date fechaFormat = format.parse(fecha);
			Date fechaCurrentFormat = format.parse(fechaCurrent);
			
			if(fechaFormat.compareTo(fechaCurrentFormat) == 0) {
				nInfracciones++;
				suma += movingViolation.getSumaFINEAMT();
				if(movingViolation.getAccidentIndicator().equals("Yes")) {
					nAccidentes++;
				}
				
			}
			else {
				statistics.enqueue(new VODaylyStatistic(fecha, nAccidentes, nInfracciones, suma));
				fecha = movingViolation.getDate();
				nAccidentes = 0;
				nInfracciones = 0;
				suma = 0;
			}
		}
		
		return statistics;
	}
	
	public IStack <VOMovingViolations> nLastAccidents(int n) {
		// TODO
		Stack<VOMovingViolations> nAccidents = new Stack<VOMovingViolations>();
		Stack<VOMovingViolations> base = new Stack<VOMovingViolations>();
		int i = 0;
		Iterator<VOMovingViolations> it = base.iterator();
		
		while(i != n)
		{
			VOMovingViolations movingViolation = it.next();
			if(movingViolation.getAccidentIndicator().equals("Yes"))
			{
				nAccidents.push(movingViolation);
				i++;
			}
		}
		return nAccidents;
	}
}
