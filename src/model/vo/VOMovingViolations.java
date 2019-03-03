package model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations implements Comparable<VOMovingViolations>{
	
	//----------------------------------------------------------------------
	// Atributos
	//----------------------------------------------------------------------
	
	/**
	 * Identificador �nico de la infracci�n
	 */
	private int objectId;
	
	/**
	 * Direcci�n en formato de texto
	 */
	private String rowLocation;
	
	/**
	 * ID de la direcci�n
	 */
	private int addresId;
	
	/**
	 * ID del segmento de la calle
	 */
	private int streetSegId;
	
	/**
	 * Coordenada X donde ocurri� (No corresponde a una longitud geogr�fica)
	 */
	private double xCoord;
	
	/**
	 * Coordenada y donde ocurri� (No corresponde a una longitud geogr�fica)
	 */
	private double yCoord;
	
	/**
	 * Tipo de infracci�n
	 */
	private String ticketType;
	
	/**
	 * Cantidad a pagar por la infracci�n en USD
	 */
	private int fineAMT;
	
	/**
	 * Cuanto dinero pag� el que recibi� la multa
	 */
	private int totalPaid;
	
	/**
	 * Dinero extra que debe pagar el conductor
	 */
	private int penal1;
	
	/**
	 * Dinero extra que debe pagar el conductor
	 */
	private int penal2;
	
	/**
	 * Indicador de accidente
	 */
	private String accidentIndicator;
	
	/**
	 * Numero de la agencia
	 */
	private int agencyId;
	
	/**
	 * Fecha cuando se puso la infracci�n
	 */
	private Date ticketIssueDate;
	
	/**
	 * C�digo de la infracci�n
	 */
	private String violationCode;
	
	/**
	 * Descripci�n textual de la infracci�n
	 */
	private String violationDesc;
	
	private int rowId;
	
	/**
	 * Es el formato que se usara para las fechas
	 */
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	//--------------------------------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------------------------------
	
	/**
	 * Inicializa la clase.
	 * @param pObjectId Identificador �nico de la infracci�n.
	 * @param pLocation Direcci�n en formato de texto.
	 * @param pSumaFINEAMT Cantidad a pagar por la infracci�n en USD.
	 * @param pTicketIssueDate Fecha cuando se puso la infracci�n.
	 * @param pTotalPaid Cuanto dinero pago el que recibio la infracci�n en USD.
	 * @param pAccidentIndicator Si hubo accidente o no.
	 * @param pViolationCode Codigo de la infracci�n.
	 * @param pViolationDescription Descripci�n textual de la infracci�n.
	 */
	public VOMovingViolations( int pObjectId, String pLocation, int pAddrresId, int pStreetSegId,int pXCoord, int pYCoord, String pTicketType, int pSumaFINEAMT, int pTotalPaid, int pPenal1, int pPenal2, String pAccidentIndicator, String pTicketIssueDate, String pViolationCode, String pViolationDescription, int pRowId) throws ParseException
	{
		// TODO Implementar
		objectId = pObjectId;
		rowLocation = pLocation;
		addresId = pAddrresId;
		streetSegId = pStreetSegId;
		xCoord = pXCoord;
		yCoord = pYCoord;
		ticketType = pTicketType;
		fineAMT = pSumaFINEAMT;
		totalPaid = pTotalPaid;
		penal1 = pPenal1;
		penal2 = pPenal2;
		accidentIndicator =  pAccidentIndicator;
		agencyId = 0;
		ticketIssueDate = format.parse(pTicketIssueDate);
		violationCode = pViolationCode;
		violationDesc = pViolationDescription;
		rowId = pRowId;
	}	
	
	//-----------------------------------------------------------------------------------------
	// M�todos
	//-----------------------------------------------------------------------------------------
	
	/**
	 * @return id - Identificador unico de la infraccion
	 */
	public int getObjectId() {
		// TODO Auto-generated method stub
		return objectId;
	}	
	
	
	/**
	 * @return location - Direccion en formato de texto.
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return rowLocation;
	}
	
	/**
	 * @return address - ID de la direcci�n
	 */
	public int getAdressId(){
		return addresId;
	}
	
	/**
	 * @return street seg Id - ID del segmento de la calle
	 */
	public int getStreetSegId(){
		return streetSegId;
	}
	
	/**
	 * @return coordX - Coordenada x donde ocurri�
	 */
	public double getXCoord(){
		return xCoord;
	}
	
	/**
	 * @return coordY - Coordenada y donde ocurri�
	 */
	public double getYCoord(){
		return yCoord;
	}
	
	/**
	 *@return ticket type - Tipo de infracci�n 
	 */
	public String getTicketType(){
		return ticketType;
	}
	
	/**
	 * @return fine AMT - Cantidad a pagar por la infracci�n en USD
	 */
	public int getFineAMT(){
		return fineAMT;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente paga el que recibio la infraccion en USD.
	 */
	public int getTotalPaid() {
		// TODO Auto-generated method stub
		return totalPaid;
	}
	/**
	 * @return penal 1 - Dinero extra que debe pagar el conductor
	 */
	public int getPenalty1(){
		return penal1;
	}
	
	/**
	 * @return penal 2 - Dinero extra que debe pagar el conductor
	 */
	public int getPenalty2(){
		return penal2;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}
	
	/**
	 * @return agency ID - ID de la agencia
	 */
	public int getAgencyId(){
		return agencyId;
	}
	
	/**
	 * @return date - Fecha cuando se puso la infraccion .
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return ticketIssueDate.toString();
	}
	
	/**
	 * @return violation code - C�digo de la infracci�n
	 */
	public String getViolationCode(){
		return violationCode;
	}
		
	/**
	 * @return description - Descripcion textual de la infraccion.
	 */
	public String  getViolationDescription() {
		// TODO Auto-generated method stub
		return violationDesc;
	}
	
	/**
	 * @return rowID
	 */
	public int getRowId(){
		return rowId;
	}

	@Override
	/**
	 * Compara las infracciones por el ticketIssueDate. Si el ticketIssueDate de las infracciones comparadas es 
	 * igual, la comparaci�n se resuelve por su objectID.
	 * @return 1 si la infracci�n es mayor que la recibida
	 * @return 0 si las infracciones son iguales
	 * @return -1 si la infracci�n es menor que la recibida 
	 */
	public int compareTo(VOMovingViolations o) {
		// TODO implementar la comparacion "natural" de la clase
		int c = 0;
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd"+" T "+"kk:mm:ss");
		Date n = null;
		try{
			n = form.parse(o.getTicketIssueDate());
		} catch (java.text.ParseException ex){
			ex.printStackTrace();
		}
		if(ticketIssueDate.after(n)) c = 1;
		else if(ticketIssueDate.before(n)) c = -1;
		else if(ticketIssueDate.equals(n)){
			if (objectId < o.getObjectId()) c = -1;
			else if(objectId > o.getObjectId()) c= 1;
			else return c;};
		return c;
	}
	
	public String toString()
	{
		// TODO Convertir objeto en String (representacion que se muestra en la consola)
		return "-";
	}
}
