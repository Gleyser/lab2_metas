package controllers;

import models.Meta;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class Inicio extends Controller{
	
	private static GenericDAO dao = new GenericDAOImpl();
	private static boolean iniciando = true;
	
	@Transactional
	public static Result index() {
		if (iniciando){
    		iniciando();
    		iniciando = false;
    	}
		return ok(views.html.inicio.render());
	}
	
	@Transactional
    private static void iniciando(){
    	Meta meta1 = new Meta("Estudar PLP", "ALTA", "SEMANA1");
    	Meta meta2 = new Meta("Estudar SI1", "ALTA", "SEMANA2");
    	Meta meta3 = new Meta("Estudar Probabilidade", "MEDIA", "SEMANA3");
    	Meta meta4 = new Meta("Ir no parque do povo", "BAIXA", "SEMANA3");
    	Meta meta5 = new Meta("Ir no centro", "ALTA", "SEMANA2");
    	Meta meta6 = new Meta("Imprimir a lista de metodos estatisticos", "BAIXA", "SEMANA1");
    	Meta meta7 = new Meta("Ir na casa da namorada", "ALTA", "SEMANA1");
    	Meta meta8 = new Meta("Ler o artigo de PLP", "MEDIA", "SEMANA1");
    	Meta meta9 = new Meta("Enviar email para o orientador", "MEDIA", "SEMANA3");
    	Meta meta10 = new Meta("Enviar o lab2 de si1", "MEDIA", "SEMANA1");
    	meta10.setEstado("ALCANCADA");
    	getDao().persist(meta1);
    	getDao().persist(meta2);
    	getDao().persist(meta3);
    	getDao().persist(meta4);
    	getDao().persist(meta5);
    	getDao().persist(meta6);
    	getDao().persist(meta7);
    	getDao().persist(meta8);
    	getDao().persist(meta9);
    	getDao().persist(meta10);
    	getDao().flush();
    	
    }
	
	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Inicio.dao = dao;
	}
}