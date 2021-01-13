/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.model;

import co.com.claro.imeiBloqueo.entity.Imeibloqueo;

/**
 *
 * @author jimenezelkg
 */
public class Validaciones {

    public Validaciones() {
    }

    public boolean campoLleno(String campo) {
        try {
            return !(campo.isEmpty() || campo == null);
        } catch (Exception e) {
            return false;
        }
    }

    public GenericResponse objetoLleno(Imeibloqueo objeto) {
        GenericResponse response = new GenericResponse(true, "");
        try {
            if ((!campoLleno(objeto.getMsisdn() + "") || objeto.getMsisdn() == Long.parseLong("0"))) {
                response.setIsValid(false);
                response.setDescription(response.getDescription() + ", msisdn");
            }
            if ((!campoLleno(objeto.getImei() + "") || objeto.getImei() == Long.parseLong("0"))) {
                response.setIsValid(false);
                response.setDescription(response.getDescription() + ", imei");
            }
            if (!campoLleno(objeto.getReportType())) {
                response.setIsValid(false);
                response.setDescription(response.getDescription() + ", reportType");
            }
            if (!campoLleno(objeto.getOperation())) {
                response.setIsValid(false);
                response.setDescription(response.getDescription() + ", operation");
            }
            if (!campoLleno(objeto.getStatus())) {
                response.setIsValid(false);
                response.setDescription(response.getDescription() + ", status");
            }
        } catch (Exception e) {
            response.setDescription("Error inesperado: " + e.getMessage());
            response.setIsValid(null);
        }
        return response;
    }

}
