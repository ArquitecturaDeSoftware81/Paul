
package Datos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class Ingresar {

    private String nombre;
    private String contraseña;
    private HttpServletRequest responde;
    private final FacesContext acceder;
    private FacesMessage facesmensaje;
    
    public Ingresar() {
        acceder = FacesContext.getCurrentInstance();
        responde = (HttpServletRequest)acceder.getExternalContext().getRequest();
      
    }
    
    public String Login ()
    {
        if(nombre.equals("upt") && contraseña.equals("12345"))
        {
           responde.getSession().setAttribute("Sesion Usuario", nombre);
           facesmensaje= new FacesMessage(FacesMessage.SEVERITY_INFO,"Acceso Correcto",null);
           acceder.addMessage(null, facesmensaje);
           return "menuP";
        }
        else
        {
           responde.getSession().setAttribute("Sesion Usuario", nombre);
           facesmensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o Contraseña incorrecto",null);
           acceder.addMessage(null, facesmensaje);
           return "error";
        }
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
            

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
