
package tr.gov.btk.rehberapp.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tr.gov.btk.rehberapp.entity.Giris;
import tr.gov.btk.rehberapp.service.GirisService;

@ManagedBean
@SessionScoped
public class GirisBean 
{
    private Giris giris=new Giris();

    @EJB
    private GirisService girisService;
            
    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    
    public GirisBean() {
    }

    public String giriseYetkilimi()
    {
        boolean sonuc=girisService.girisKontrol(giris);
        if(sonuc)
        {
            return "menu.xhtml";
        }
        else
        {
            return "giris.xhtml";
        }
        
    }
}
