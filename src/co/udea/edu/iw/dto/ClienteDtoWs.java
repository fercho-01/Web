package co.udea.edu.iw.dto;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Dto del cliente para el servicio web
 * @author LUIS FERNANDO OROZCO
 */
//para convertir la clase a xml
@XmlRootElement
public class ClienteDtoWs {
	String cedula;
	String nombre;
	String apellido;
	String email;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
