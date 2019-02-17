package model.vo;

public class VOViolationCode implements Comparable<VOViolationCode> {
	
	private String violationCode;
	private int promedioFINEAMT;
	
	public VOViolationCode(String pViolationCode, int pPromedioFINEAMT) {
		// TODO Auto-generated constructor stub
		violationCode = pViolationCode;
		promedioFINEAMT = pPromedioFINEAMT;
	}
	
	public String getViolationCode () {
		return violationCode;
	}
	
	public int getFINEAMTProm () {
		return promedioFINEAMT;
	}

	@Override
	public int compareTo(VOViolationCode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
