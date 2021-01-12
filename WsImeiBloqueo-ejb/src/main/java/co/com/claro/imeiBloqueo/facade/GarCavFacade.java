/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.facade;

import co.com.claro.imeiBloqueo.entity.GarCav;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jimenezelkg
 */
@Stateless
public class GarCavFacade extends AbstractFacade<GarCav> {

    @PersistenceContext(unitName = "co.com.claro.imeiBloqueo_WsImeiBloqueo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GarCavFacade() {
        super(GarCav.class);
    }

    public List<GarCav> queryCodeCav(String codeCav) {
        List<GarCav> list = (List<GarCav>) em.createQuery("SELECT g FROM GarCav g WHERE g.codeCav='" + codeCav + "'").getResultList();
        if (!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

}
