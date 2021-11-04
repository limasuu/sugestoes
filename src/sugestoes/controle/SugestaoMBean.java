package sugestoes.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import sugestoes.modelo.Sugestao;

@ManagedBean
@SessionScoped
public class SugestaoMBean {
	
	Sugestao sugestao;
	
	public SugestaoMBean() {
		
		this.sugestao= new Sugestao();
	}

	public Sugestao getSugestao() {
		return sugestao;
	}

	public void setSugestao(Sugestao sugestao) {
		this.sugestao = sugestao;
	}
	
	public String enviar() {
		
		if(sugestao.getMensagem().equals("")){
			
			FacesMessage msg= new FacesMessage("Mensagem: Campo obrigatório");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			FacesContext.getCurrentInstance().addMessage("", msg);
			
			return "/index.jsf";
		}
		
		return "/concluido.jsf";
	}
}
