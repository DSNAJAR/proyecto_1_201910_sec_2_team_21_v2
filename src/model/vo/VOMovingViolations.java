package model.vo;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations implements Comparable<VOMovingViolations>{

	private int objectId;
	private String location;
	private int sumaFINEAMT;
	private String ticketIssueDate;
	private int totalPaid;
	private String accidentIndicator;
	private String violationCode;
	private String violationDescription;
	
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
	
	/**
	 * @return id - Identificador único de la infracción
	 */
	public int objectId() {
		// TODO Auto-generated method stub
		return objectId;
	}	
	
	
	/**
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	
	public int getSumaFINEAMT() {
		return sumaFINEAMT;
	}

	/**
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return ticketIssueDate;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pagó el que recibió la infracción en USD.
	 */
	public int getTotalPaid() {
		// TODO Auto-generated method stub
		return totalPaid;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}
	
	public String  getViolationCode() {
		return violationCode;
	}
		
	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() {
		// TODO Auto-generated method stub
		return violationDescription;
	}
	
	public String getDate() {
		return ticketIssueDate;
	}


	@Override
	public int compareTo(VOMovingViolations arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
