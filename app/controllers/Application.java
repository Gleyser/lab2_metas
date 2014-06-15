package controllers;

import models.Meta;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private static GenericDAO dao = new GenericDAOImpl();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result sobre() {
    	return ok(views.html.sistema.render(
    			"Sistema de Controle de Metas",
    			play.core.PlayVersion.current())
    			);
    	}

}
