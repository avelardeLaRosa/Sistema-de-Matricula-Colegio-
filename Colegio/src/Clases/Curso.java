package Clases;
import Arreglos.ArregloCurso;


public class Curso implements Comparable<Curso>{
	/*Encapsulamiento*/
	private String asignatura;
	private int ciclo;
	private int nroCreditos;
	private int cantHoras;
	private int codigoAsignatura;
	
	/*Metodo constructor*/
	public Curso(String asignatura, int ciclo, int nroCreditos, int cantHoras, int codigoAsignatura) {
		super();
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.nroCreditos = nroCreditos;
		this.cantHoras = cantHoras;
		this.codigoAsignatura= codigoAsignatura;
	}
	
	/*Getters & Setters*/
	public String getAsignatura() {return asignatura;}
	public void setAsignatura(String asignatura) {this.asignatura = asignatura;}
	public int getCiclo() {return ciclo;}
	public void setCiclo(int ciclo) {this.ciclo = ciclo;}
	public int getNroCreditos() {return nroCreditos;}
	public void setNroCreditos(int nroCreditos) {this.nroCreditos = nroCreditos;}
	public int getCantHoras() {return cantHoras;}
	public void setCantHoras(int cantHoras) {this.cantHoras = cantHoras;}
	public int getCodigoAsignatura(){return codigoAsignatura;}
	public void setCodigoAsignatura(int codigoAsignatura){this.codigoAsignatura=codigoAsignatura;}

	@Override
	public int compareTo(Curso o) {
		if(o.getCodigoAsignatura() > codigoAsignatura) {
			return -1;
		}
		else if(o.getCodigoAsignatura() == codigoAsignatura) {
			return 0;
		}
		else {
			return 1; 
		}
		
		}
		
	}

	

	
	
	
	
	
	
	
	

