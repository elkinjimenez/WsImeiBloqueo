/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.ws;

import co.com.claro.imeiBloqueo.entity.Imeibloqueo;
import co.com.claro.imeiBloqueo.facade.ImeibloqueoFacade;
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
 * @author omarMad
 */
@Path("imeiBloqueo")
@Stateless
@TransactionManagement
public class imeiBloqueoService {

    @EJB
    private ImeibloqueoFacade imeiFacade;

    public imeiBloqueoService() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("queryByImei")
    public List<Imeibloqueo> searchCode() {
        try {
            return imeiFacade.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("createImeiBloqueo")
    public DataResponse createImeiBloqueo(Imeibloqueo imeiBloqueo) {
        DataResponse responseEnd = new DataResponse();
        try {
            imeiBloqueo.setReportDate(new Date());
            imeiFacade.create(imeiBloqueo);
            responseEnd.setImeiBloqueo(null);
            GenericResponse response = new GenericResponse(true, "Registro agregado exitosamente.");
            responseEnd.setResponse(response);
        } catch (Exception e) {
            GenericResponse response = new GenericResponse(false, "Error al consultar en ImeiBloque. Detalle: " + e.getMessage());
            responseEnd.setResponse(response);
            responseEnd.setImeiBloqueo(null);
        }
        return responseEnd;
    }

}
