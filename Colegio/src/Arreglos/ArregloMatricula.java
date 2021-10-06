package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import Clases.Curso;
import Clases.Matricula;

public class ArregloMatricula {
	
	 private ArrayList<Matricula>matricula;
	 	
	 public ArregloMatricula(){
			matricula=new ArrayList<Matricula>();	
			cargarMatricula();
			}
	 
	 public void adicionar(Matricula m){
		 matricula.add(m);
	 }
	 
	 public int tamaño(){
		 return matricula.size();
	 }
	 
	 public Matricula obtener(int pos){
		 return matricula.get(pos);
	 }
	 
	 public void eliminar(Matricula m){
		 matricula.remove(m);
	 }
	 
	 public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 100001;
		else
			return obtener(tamaño()-1).getNumMatricula() + 1;
	 }
	 
	 public Matricula buscar(int nroMatricula) {
			for (int i=0; i<tamaño(); i++)
				if (obtener(i).getNumMatricula() == nroMatricula)
					return obtener(i);
			return null;
		}
	 
	 public Matricula buscarMatriculaPorCodigo(int codigo) {
			for (int i=0; i<tamaño(); i++)
				if (obtener(i).getCodAlumno() == codigo)
					return obtener(i);
			return null;
		}
	 //CREAR METODO VERIFICAR
	 public Matricula buscarCodigoCursoRegistrado(int codigo) {
			for (int i=0; i<tamaño(); i++)
				if (obtener(i).getCodCurso() == codigo)
					return obtener(i);
			return null;
		}
	 //TERMINA METODO VERIFICAR
	 
	 
	 /*Grabar curso en archivo txt*/
		public void grabarMatricula() {
			
			try {
				PrintWriter pw;
				String linea;
				Matricula m;
				pw=new PrintWriter(new FileWriter("matricula.txt"));
				for (int i=0; i<tamaño(); i++) {
					m = obtener(i);
					linea= 	m.getNumMatricula() + ";" +
							m.getCodAlumno() + ";" +
							m.getCodCurso() + ";" +
							m.getFecha() + ";" +
							m.getHora();
					pw.println(linea);
		
				}
				pw.close();	
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error");
			}
		}
			public void cargarMatricula(){
				try {
					BufferedReader br;
					String linea;
					String[] s;
					int numMatricula,codAlumno,codCurso;
					String fecha,hora;
					br = new BufferedReader(new FileReader("matricula.txt"));
					while ((linea = br.readLine()) != null) {
						s = linea.split(";");
						numMatricula = Integer.parseInt(s[0].trim());
						codAlumno = Integer.parseInt(s[1].trim());
						codCurso = Integer.parseInt(s[2].trim());
						fecha = s[3].trim();
						hora = s[4].trim();
						adicionar(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
					}
					br.close();
				}
				catch (Exception e) {
				}
			}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
