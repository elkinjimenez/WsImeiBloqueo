/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.ws;

import co.com.claro.imeiBloqueo.entity.GarCav;
import co.com.claro.imeiBloqueo.facade.GarCavFacade;
import co.com.claro.imeiBloqueo.model.DataResponse;
import co.com.claro.imeiBloqueo.model.GenericResponse;
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

    @EJB
    private GarCavFacade garCavFacade;

    public imeiBloqueoService() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("queryCav")
    public DataResponse queryCav(@QueryParam("codeCav") String codeCav) {
        DataResponse responseEnd = new DataResponse();
        try {
            if ("".equals(codeCav) || codeCav == null) {
                GenericResponse response = new GenericResponse(false, "Por favor enviar el código del CAV (codeCav).");
                responseEnd.setCavs(null);
                responseEnd.setResponse(response);
            } else {
//                List<GarCav> list = garCavFacade.findAll();
                List<GarCav> list = garCavFacade.queryCodeCav(codeCav);
                if (list != null) {
                    GenericResponse response = new GenericResponse(true, "Consulta exitosa.");
                    responseEnd.setCavs(list);
                    responseEnd.setResponse(response);
                } else {
                    GenericResponse response = new GenericResponse(false, "No se encontraron registros con el código de CAV: " + codeCav);
                    responseEnd.setCavs(null);
                    responseEnd.setResponse(response);
                }
            }
        } catch (Exception e) {
            GenericResponse response = new GenericResponse(false, "Ocurrió un error al consultar los CAVs. Detalle: " + e.getMessage());
            responseEnd.setCavs(null);
            responseEnd.setResponse(response);
        }
        return responseEnd;
    }

}
