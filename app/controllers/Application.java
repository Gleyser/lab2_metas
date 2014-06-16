package controllers;


import java.util.List;

import models.Meta;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.data.Form;
import play.db.jpa.Transactional;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	static Form<Meta> metaForm = Form.form(Meta.class);
	private static GenericDAO dao = new GenericDAOImpl();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @Transactional
    public static Result sistema() {
    	List<Meta> result = getDao().findAllByClassName("Meta");
    	return ok(views.html.sistema.render(result,	metaForm));
    	}
    
    @Transactional
	public static Result newMeta() {
		// Todos as Metas do Banco de Dados
		List<Meta> result = getDao().findAllByClassName("Sistema");
		// O formulario de metas
		Form<Meta> filledForm = metaForm.bindFromRequest();
		
		if (filledForm.hasErrors()) {
			return badRequest(views.html.sistema.render(result, filledForm));
		} else {
			// Persiste a meta criada
			getDao().persist(filledForm.get());
			// Espelha no Banco de Dados
			getDao().flush();
			return redirect(routes.Application.sistema());
		}
	}
    
   /* @Transactional
   	public static Result metas() {
    	
    }
    @Transactional
	public static Result books() {
		// Todos os Livros do Banco de Dados
		List<Livro> result = getDao().findAllByClassName("Livro");
		return ok(views.html.index.render(result, bookForm));
	}*/
    
    public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}

}
