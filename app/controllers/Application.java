package controllers;


import java.util.List;


import models.Meta;
import models.Sistema;
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
	private static boolean iniciando = true;

    @Transactional
    public static Result sistema() {
    	List<Meta> result = getDao().findAllByClassName("Meta");
    	Sistema sistema = new Sistema();
    	
    	sistema.setTodasAsMetas(result);
    	return ok(views.html.sistema.render(sistema,metaForm));
    	}
    
    
    
    @Transactional
	public static Result newMeta() {
		// Todos as Metas do Banco de Dados
		List<Meta> result = getDao().findAllByClassName("Meta");
		// O formulario de metas
		Form<Meta> filledForm = metaForm.bindFromRequest();
		Meta meta = filledForm.get();
		Sistema sistema = new Sistema();
    	sistema.setTodasAsMetas(result);
		
		if (filledForm.hasErrors()) {
			return badRequest(views.html.sistema.render(sistema, filledForm));
		} else {
			// Persiste a meta criada
			getDao().persist(meta);
			// Espelha no Banco de Dados
			getDao().flush();
			return redirect(routes.Application.sistema());
		}
	}
    
    @Transactional
	public static Result deleteMeta(Long id) {
		
		getDao().removeById(Meta.class, id);
		// Espelha no banco de dados
		getDao().flush();
		return redirect(routes.Application.sistema());
	}
    
    @Transactional
	public static Result mudarEstadoDaMeta(Long id) {
		Meta metaAlcancada = getDao().findByEntityId(Meta.class, id);
		metaAlcancada.setEstado("ALCANCADA");
		getDao().removeById(Meta.class, id);
		getDao().persist(metaAlcancada);
		// Espelha no banco de dados
		getDao().flush();
		return redirect(routes.Application.sistema());
	}
    
    @Transactional
    public static Result metasPorSemana() {
    	List<Meta> result = getDao().findAllByClassName("Meta");
    	Sistema sistema = new Sistema();
    	sistema.setTodasAsMetas(result);
    	return ok(views.html.ordenacao.render(sistema,sistema.metasOrdenadasPorSemana(), "Semana"));
    	}
    
    @Transactional
    public static Result metasPorPrioridade() {
    	List<Meta> result = getDao().findAllByClassName("Meta");
    	Sistema sistema = new Sistema();
    	sistema.setTodasAsMetas(result);
    	return ok(views.html.ordenacao.render(sistema,sistema.metasOrdenadasPorPrioridade(), "Prioridade"));
    	}
    
    
    	
    public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}
	
	

}
