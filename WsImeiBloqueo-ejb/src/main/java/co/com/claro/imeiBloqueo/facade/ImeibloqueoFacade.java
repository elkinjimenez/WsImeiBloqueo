/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.facade;

import co.com.claro.imeiBloqueo.entity.Imeibloqueo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jimenezelkg
 */
@Stateless
public class ImeibloqueoFacade extends AbstractFacade<Imeibloqueo> {

    @PersistenceContext(unitName = "jdbc/ImeiBloqueo")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImeibloqueoFacade() {
        super(Imeibloqueo.class);
    }

    public List<Imeibloqueo> queryByIMEI(String imei) {
        List<Imeibloqueo> list = (List<Imeibloqueo>) em.createQuery("SELECT i FROM Imeibloqueo i WHERE i.imei='" + imei + "' ORDER BY i.reportDate").getResultList();
        if (!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

}
