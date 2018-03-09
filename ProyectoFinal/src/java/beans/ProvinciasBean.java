/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author user
 */
@Named(value = "provincias")
@SessionScoped
public class ProvinciasBean implements Serializable {

    
    private int codProvincia;
    private String provincia;
    
    
    public ProvinciasBean() {
    }

    public void setCodProvincia(int codProvincia) {
        this.codProvincia = codProvincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public int getCodProvincia() {
        return codProvincia;
    }
    
    public String getProvincia() {
        return provincia;
    }
    
}
