
package tr.gov.btk.rehberapp.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.btk.rehberapp.entity.Giris;
import tr.gov.btk.rehberapp.facade.GirisFacade;

@Stateless
public class GirisService {
 
    @EJB
    GirisFacade girisFacade;
    
    public boolean girisKontrol(Giris p_giris)
    {
        return girisFacade.giriseYetkilimi(p_giris);
    }
}
