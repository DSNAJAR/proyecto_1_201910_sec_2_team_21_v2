package model.vo;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations implements Comparable<VOMovingViolations>{
	
	//----------------------------------------------------------------------
	// Atributos
	//----------------------------------------------------------------------
	
	/**
	 * Identificador único de la infracción
	 */
	private int objectId;
	
	/**
	 * Dirección en formato de texto
	 */
	private String location;
	
	/**
	 * Cantidad a pagar por la infracción en USD
	 */
	private int sumaFINEAMT;
	
	/**
	 * Fecha cuando se puso la infracción
	 */
	private String ticketIssueDate;
	
	/**
	 * Cuanto dinero pagó el que recibio la infracción en USD
	 */
	private int totalPaid;
	
	/**
	 * Si hubo acciente o no
	 */
	private String accidentIndicator;
	
	/**
	 * Código de la infracción
	 */
	private String violationCode;
	
	/**
	 * Descripción textual de la infracción
	 */
	private String violationDescription;
	
	//--------------------------------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------------------------------
	
	/**
	 * Inicializa la clase.
	 * @param pObjectId Identificador único de la infracción.
	 * @param pLocation Dirección en formato de texto.
	 * @param pSumaFINEAMT Cantidad a pagar por la infracción en USD.
	 * @param pTicketIssueDate Fecha cuando se puso la infracción.
	 * @param pTotalPaid Cuanto dinero pago el que recibio la infracción en USD.
	 * @param pAccidentIndicator Si hubo accidente o no.
	 * @param pViolationCode Codigo de la infracción.
	 * @param pViolationDescription Descripción textual de la infracción.
	 */
	public VOMovingViolations(int pObjectId, String pLocation, int pSumaFINEAMT, String pTicketIssueDate, int pTotalPaid, String pAccidentIndicator, String pViolationCode, String pViolationDescription){
		objectId = pObjectId;
		location = pLocation;
		sumaFINEAMT = pSumaFINEAMT;
		ticketIssueDate = pTicketIssueDate;
		totalPaid = pTotalPaid;
		accidentIndicator = pAccidentIndicator;
		violationCode = pViolationCode;
		violationDescription = pViolationDescription;
	}
	
	//-----------------------------------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------------------------------
	
	/**
	 * Retorna el objectId
	 * @return id - Identificador único de la infracción
	 */
	public int objectId() {
		return objectId;
	}	
	
	
	/**
	 * Retorna la dirección
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Retorna la cantidad a pagar por la  infraccióm
	 * @return sumaFINEAMT - Cantidad a pagar por la infracción
	 */
	public int getSumaFINEAMT() {
		return sumaFINEAMT;
	}

	/**
	 * Retorna la fecha en la que se puso la infracción
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() {
		return ticketIssueDate;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pagÃ³ el que recibiÃ³ la infracciÃ³n en USD.
	 */
	public int getTotalPaid() {
		return totalPaid;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		return accidentIndicator;
	}
	/**
	 * Retorna el código de la infracción
	 * @return violationCode - Código de la infracción
	 */
	public String  getViolationCode() {
		return violationCode;
	}
		
	/**
	 * Retorna la descripción textual de la infracción
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() {
		return violationDescription;
	}

	@Override
	public int compareTo(VOMovingViolations arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
