package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

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
