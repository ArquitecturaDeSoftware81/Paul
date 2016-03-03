/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosdeLogueo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
}