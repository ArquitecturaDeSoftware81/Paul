/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosdeLogueo;

import com.sun.xml.ws.transport.tcp.server.glassfish.ServletFakeArtifactSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author paulj
 */
@ManagedBean
@RequestScoped
public class Logueo {

    private String nombre;
    private String contraseña;
    private HttpServletRequest responde;
    private final FacesContext acceder;
    private FacesMessage facesmensaje;
    
    public Logueo() {
        
        acceder = FacesContext.getCurrentInstance();
        responde = (HttpServletRequest)acceder.getExternalContext().getRequest();
    }

public String Login ()
    {
        if(nombre.equals("upt") && contraseña.equals("12345"))
        {
           responde.getSession().setAttribute("Sesion Usuario", nombre);
           facesmensaje= new FacesMessage(FacesMessage.SEVERITY_INFO,"Acceso Correcto", null);
           acceder.addMessage(null, facesmensaje);
           return "menuP";
        }
        else
        {
           responde.getSession().setAttribute("Sesión Usuario", nombre);
           facesmensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acceso Incorrecto", null);
           acceder.addMessage(null, facesmensaje);
           return "error";
        }
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}