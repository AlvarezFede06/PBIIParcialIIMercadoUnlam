package ar.edu.unlam.pb2;

public abstract class Tarjeta extends MedioDePago {

	protected Long numero;
	protected String fechaDeVencimiento;
	protected Integer codigoDeSeguridad;
	protected Double saldo;

	final Integer CANTIDAD_DE_DIGITOS_DE_LA_TARJETA_DE_DEBITO = 16;

	
	protected void setCodigoDeSeguridad(Integer codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}

	protected void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	protected void setTitular(String titular) {
		this.titular = titular;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;

	}

	public Long getNumero() {
		return this.numero;
	}

	
	public Integer getCodigoDeSeguridad() {
		return this.codigoDeSeguridad;
	}


	public String getFechaDeVencimiento() {
		return this.fechaDeVencimiento;
	}


	public abstract Double getSaldo();

	
	public void setNumero(Long numero) throws NumeroDeTarjetaInvalidoException{
		
		String numeroDeTarjetaEnString = numero.toString();
		if(numeroDeTarjetaEnString.length()!=CANTIDAD_DE_DIGITOS_DE_LA_TARJETA_DE_DEBITO) {
			throw new NumeroDeTarjetaInvalidoException();
		}
		
			this.numero = numero;
	}

	

	

}
