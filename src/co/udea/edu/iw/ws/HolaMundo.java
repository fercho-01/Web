package co.udea.edu.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Url al que va a responder el servicio web
@Path("Saludo")
public class HolaMundo {
	
	//especificar el tipo de dato que entrega el servicio
	@Produces(MediaType.TEXT_HTML)
	//Metodo http al cual va a responder el metodo saludar
	@GET
	public String saludar(@QueryParam("nombre")String nombreCompleto){
		return "Buenas tardes "+nombreCompleto;
	}
	
	
	//para pasar parametros por path y saludo2 es para poder referenciarlo atravez de la url
	@Path("saludar2/{nombre}/{apellido}")
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String saludar(@PathParam("nombre")String nombreCompleto,@PathParam("apellido") String apellido ){
		return "Buenas tardes "+nombreCompleto+" "+apellido;
	}

}
