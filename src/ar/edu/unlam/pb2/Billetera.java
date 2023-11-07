package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Billetera {

	private String nombre;
	private Set<Comercio> comercios;
	private Set<Consumidor> consumidores;
	private Map<MedioDePago, Integer> mediosDePago;
	private List<Compra> compras;
	
	
	public Billetera(String nombre) {
		this.nombre = nombre;
		this.comercios = new HashSet<>();
		this.consumidores = new TreeSet<>();
		this.mediosDePago = new HashMap<>();
		this.compras = new ArrayList<>();
	}

	public void agregarComercio(Comercio nuevo) {
		
		comercios.add(nuevo);
		
		
	}

	public Integer getCantidadDeComercios() {
			return this.comercios.size();
	}

	public void agregarConsumidor(Consumidor nuevo) {
		this.consumidores.add(nuevo);
	}

	public Integer getCantidadDeConsumidores() {
		return this.consumidores.size();
	}

	public void agregarMedioDePago(Integer dniDelconsumidor, MedioDePago nuevo) throws DniInvalidoException, NoCoincideTitularException {
		Consumidor consumidor = buscarConsumidor(dniDelconsumidor);
		if(consumidor == null) {
			throw new DniInvalidoException();
		}
		
		if(!consumidor.getNombre().equalsIgnoreCase(nuevo.getTitular())) {
			throw new NoCoincideTitularException();
		} 
		
		mediosDePago.put(nuevo, dniDelconsumidor);
	}

	private Consumidor buscarConsumidor(Integer dni) {
		for(Consumidor actual: consumidores) {
			if(actual.getDni().equals(dni)) {
				return actual;
			}
		}
		return null;
	}

	public Integer getCantidadDeMediosDePago(Integer dni) {
	
		Integer cantidadDeMedioDePago = 0;
		for (Map.Entry<MedioDePago, Integer> actual : mediosDePago.entrySet()) {
		 if(dni.equals(actual.getValue())){
			 cantidadDeMedioDePago++;
		 }
		
	}
	
		return cantidadDeMedioDePago;
	}

	public Compra generarCodigoQR(Long cuitDelComercio, Double importeCompra) {
		
		Comercio buscado = buscarComercio(cuitDelComercio);
		Compra nueva = new Compra(buscado, importeCompra);
		compras.add(nueva);
		
		return nueva;
	}
	
	private Comercio buscarComercio(Long cuitDelComercio) { 
		for(Comercio actual: comercios) {
			if(actual.getCuit().equals(cuitDelComercio)) { 
				return actual;
			}
		}
		return null;
	}

	public Object getConsumidor(Integer dni) {
		return buscarConsumidor(dni);
	}

	
}
