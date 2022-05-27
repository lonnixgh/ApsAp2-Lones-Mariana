package bean;

import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDAO;
import entidade.Jogo;


@ManagedBean
public class JogoBean {
	
	private Jogo jogo = new Jogo();
	private List<Jogo> jogos;

	public String salvar() {
		try {
			
			JogoDAO.salvar(jogo);
			jogo = new Jogo();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Contato salvo com sucesso"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar"));
		}	
			return null;
	}
	
	public String editar() {
		try {
			JogoDAO.editar(jogo);
			jogo = new Jogo();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Contato editado com sucesso"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao editar"));
		}
		return null;
	}
	
	
	public String excluir() {
		try {
			JogoDAO.excluir(jogo);
			jogos.remove(jogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Deletado com sucesso"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao deletar"));
		}
		return null;
	}
	
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getJogos() {
		if (jogos == null) {
			jogos = JogoDAO.listar();
		}
		
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
}
