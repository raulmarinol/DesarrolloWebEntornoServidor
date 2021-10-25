package org.iesalisar.servidor.bean;

import java.io.Serializable;
import java.util.List;

public class Reserva implements Serializable{
	
	private String finicio;
	private String ffin;
	private int numero;
	private List<String> estras;
	private Reserva(String finicio, String ffin, int numero, List<String> estras) {
		super();
		this.finicio = finicio;
		this.ffin = ffin;
		this.numero = numero;
		this.estras = estras;
	}
	public String getFinicio() {
		return finicio;
	}
	public void setFinicio(String finicio) {
		this.finicio = finicio;
	}
	public String getFfin() {
		return ffin;
	}
	public void setFfin(String ffin) {
		this.ffin = ffin;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<String> getEstras() {
		return estras;
	}
	public void setEstras(List<String> estras) {
		this.estras = estras;
	}
	

}
