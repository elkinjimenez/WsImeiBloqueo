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
import co.com.claro.imeiBloqueo.model.Validaciones;
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
    public DataResponse searchCode(@QueryParam("imei") String imei) {
        DataResponse responseEnd = new DataResponse();
        try {
            Validaciones val = new Validaciones();
            if (val.campoLleno(imei)) {
                List<Imeibloqueo> list = imeiFacade.queryByIMEI(imei);
                if (list != null) {
                    GenericResponse response = new GenericResponse(true, "Consulta exitosa.");
                    responseEnd.setResponse(response);
                    responseEnd.setImeiBloqueo(list);
                } else {
                    GenericResponse response = new GenericResponse(false, "No se encontraron registros con el IMEI " + imei + ".");
                    responseEnd.setResponse(response);
                    responseEnd.setImeiBloqueo(null);
                }
            } else {
                GenericResponse response = new GenericResponse(false, "Campo 'imei' no encontrado. Por favor enviarlo.");
                responseEnd.setResponse(response);
                responseEnd.setImeiBloqueo(null);
            }
        } catch (Exception e) {
            GenericResponse response = new GenericResponse(false, "Error al consultar en ImeiBloqueo. Detalle: " + e.getMessage());
            responseEnd.setResponse(response);
            responseEnd.setImeiBloqueo(null);
        }
        return responseEnd;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("createImeiBloqueo")
    public DataResponse createImeiBloqueo(Imeibloqueo imeiBloqueo) {
        DataResponse responseEnd = new DataResponse();
        try {
            Validaciones val = new Validaciones();
            GenericResponse validaciones = val.objetoLleno(imeiBloqueo);
            if (validaciones.getIsValid()) {
                List<Imeibloqueo> existe = imeiFacade.queryByIMEI(imeiBloqueo.getImei() + "");
                if (existe == null) {
                    imeiBloqueo.setReportDate(new Date());
                    imeiFacade.create(imeiBloqueo);
                    responseEnd.setImeiBloqueo(null);
                    GenericResponse response = new GenericResponse(true, "Registro agregado exitosamente.");
                    responseEnd.setResponse(response);
                } else {
                    GenericResponse response = new GenericResponse(false, "IMEI " + imeiBloqueo.getImei() + " ya se encuentra registrado.");
                    responseEnd.setResponse(response);
                    responseEnd.setImeiBloqueo(null);
                }
            } else if (validaciones.getIsValid() == null) {
                responseEnd.setResponse(validaciones);
                responseEnd.setImeiBloqueo(null);
            } else {
                validaciones.setDescription("Campos obligatorios no encontados" + validaciones.getDescription() + ". Por favor agregarlos.");
                responseEnd.setResponse(validaciones);
                responseEnd.setImeiBloqueo(null);
            }

        } catch (Exception e) {
            GenericResponse response = new GenericResponse(false, "Error al insertar en ImeiBloqueo. Detalle: " + e.getMessage());
            responseEnd.setResponse(response);
            responseEnd.setImeiBloqueo(null);
        }
        return responseEnd;
    }

}
