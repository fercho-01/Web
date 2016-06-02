package co.udea.edu.iw.ws;
/*
 * Esta clase provee un servicio web para obtener datos de los clientes
 * @athor LUIS FERNANDO OROZCO
 */

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.service.ClienteService;
import co.udea.edu.iw.dto.ClienteDtoWs;
import javassist.tools.rmi.RemoteException;

//@Component para que spring injecte los bean

@Component
@Path("Cliente")
public class ClienteWs {
	@Autowired
	ClienteService clienteService;
	
	//@Produces(MediaType.APPLICATION_XML) produce xml
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("Obtener")
	public List<ClienteDtoWs> obtener() throws RemoteException{
		List<ClienteDtoWs> lista = new ArrayList<ClienteDtoWs>();
		try {
			for(Cliente cliente:clienteService.obtener()){
				ClienteDtoWs clientews= new ClienteDtoWs();
				clientews.setCedula(cliente.getCedula());
				clientews.setNombre(cliente.getNombres());
				clientews.setApellido(cliente.getApellidos());
				clientews.setEmail(cliente.getCorreoElectronico());
				lista.add(clientews);
			}
		} catch (IWDaoException e) {
			throw new RemoteException(e);
		}
		return lista;
	}
	
	//retorna json diciendo si o no
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String guardar(){
		return "no";
	}
	
	@DELETE
	public void eliminar(){
		
	}
	
	@PUT
	public void modificar(){
		
	}

}
