/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jimenezelkg
 */
public class UpdateImeiBloqueo {

    @Getter
    @Setter
    private String imei;

    @Getter
    @Setter
    private String status;

    public UpdateImeiBloqueo() {
    }

    public UpdateImeiBloqueo(String imei, String status) {
        this.imei = imei;
        this.status = status;
    }

}
