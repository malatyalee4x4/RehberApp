/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.btk.rehberapp.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.btk.rehberapp.entity.Giris;

/**
 *
 * @author cumali.gurgun
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {
    @PersistenceContext(unitName = "RehberAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }
    
    public boolean giriseYetkilimi(Giris p_giris)
    {
        Giris g=em.createNamedQuery("Giris.girisKontrol",Giris.class)
                .setParameter("ad", p_giris.getAd())
                .setParameter("sifre",p_giris.getSifre() )
                .getSingleResult();
        
        if(g!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
}
