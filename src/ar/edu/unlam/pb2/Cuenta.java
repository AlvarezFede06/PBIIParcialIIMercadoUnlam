package ar.edu.unlam.pb2;

public class Cuenta extends MedioDePago {
	protected String entidad;
	protected String titular;
	protected Double saldo;
	
	public String getEntidad() {
		return this.entidad;
	}

	public String getTitular() {
		return this.titular;
	}
	
	public Double getSaldo() {
		return saldo;
	}

}
