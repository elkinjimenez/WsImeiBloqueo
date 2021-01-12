/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.ws;

import co.com.claro.imeiBloqueo.model.DataResponse;
import co.com.claro.imeiBloqueo.model.GenericResponse;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;

/**
 *
 * @author ElkinJ
 */
@Path("imeiBloqueo")
@Stateless
@TransactionManagement
public class imeiBloqueoService {

//    @EJB
//    private ImeibloqueoFacade imeiBloqueoFacade;

    public imeiBloqueoService() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("queryByImei")
    public List<Imeibloqueo> queryByImei() {
        return imeiBloqueoFacade.findAll();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("createImeiBloqueo")
    public DataResponse createImeiBloqueo(Imeibloqueo imeiBloqueo) {
        DataResponse responseEnd = new DataResponse();
        try {
            imeiBloqueo.setReportDate(new Date());
            imeiBloqueoFacade.create(imeiBloqueo);
//            responseEnd.setImeiBloqueo(null);
            GenericResponse response = new GenericResponse(true, "Consulta exitosa.");
            responseEnd.setResponse(response);
        } catch (Exception e) {
            GenericResponse response = new GenericResponse(false, "Error al consultar en ImeiBloque. Detalle: " + e.getMessage());
            responseEnd.setResponse(response);
//            responseEnd.setImeiBloqueo(null);
        }
        return responseEnd;
    }

}
