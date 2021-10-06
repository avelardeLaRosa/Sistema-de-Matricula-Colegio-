package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clases.Matricula;
import Clases.Retiro;

public class ArregloRetiro {
	
	private ArrayList<Retiro>retiro;
	
	public ArregloRetiro(){
		retiro=new ArrayList<>();
		cargarRetiro();
	}
	
	public int tamaño(){
		return retiro.size();
	}
	public void adicionar(Retiro r){
		retiro.add(r);
	}
	public Retiro obtener(int pos){
		return retiro.get(pos);
	}
	public void eliminar(Retiro r){
		 retiro.remove(r);
	}
	
	public Retiro buscar(int numRetiro) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getNumRetiro() == numRetiro)
				return obtener(i);
		return null;
	}
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 200001;
		else
			return obtener(tamaño()-1).getNumRetiro() + 1;
	 }
	
	/*Grabar curso en archivo txt*/
	public void grabarRetiro() {
		
		try {
			PrintWriter pw;
			String linea;
			Retiro r;
			pw=new PrintWriter(new FileWriter("retiro.txt"));
			for (int i=0; i<tamaño(); i++) {
				r = obtener(i);
				linea= 	r.getNumRetiro() + ";" +
						r.getNumMatricula()+ ";"+
						r.getFecha() + ";" +
						r.getHora() ;
				pw.println(linea);
	
			}
			pw.close();	
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
		public void cargarRetiro(){
			try {
				BufferedReader br;
				String linea;
				String[] s;
				int numMatricula,numRetiro;
				String fecha,hora;
				br = new BufferedReader(new FileReader("retiro.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					numMatricula = Integer.parseInt(s[0].trim());
					numRetiro = Integer.parseInt(s[1].trim());
					fecha = s[2].trim();
					hora = s[3].trim();
					adicionar(new Retiro(numMatricula, numRetiro, fecha, hora));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}

	
	
	
	
	
}
