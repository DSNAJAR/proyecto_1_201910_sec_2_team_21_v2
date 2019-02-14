package model.vo;

public class VODaylyStatistic implements Comparable<VODaylyStatistic>{
	
	private String fechaDelDia;
	private int numeroAccidentes;
	private int numeroInfracciones;
	private int sumaFINEAMT;
	
	public VODaylyStatistic(String pFechaDelDia, int pNumeroAccidente, int pNumeroInfracciones, int pSumaFINEMAT) {
		fechaDelDia = pFechaDelDia;
		numeroAccidentes = pNumeroAccidente;
		numeroInfracciones = pNumeroInfracciones;
		sumaFINEAMT = pSumaFINEMAT;
	}
	
	public String getFechaDelDia() {
		return fechaDelDia;
	}
	
	public int getNumeroAccidentes() {
		return numeroAccidentes;
	}
	
	public int getNumeroInfracciones() {
		return numeroAccidentes;
	}
	
	public int getsumaFINEAMT() {
		return sumaFINEAMT;
	}
	
	@Override
	public int compareTo(VODaylyStatistic arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	//TODO
}
