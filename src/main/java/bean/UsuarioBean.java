package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> lista = new ArrayList<Usuario>();

	public String salvar() {
		try {
			UsuarioDao.save(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario cadastrado com sucesso!"));
			usuario = new Usuario();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ops! Não foi possível realizar essa operação."));
		}
		
		return null;
	}
	
	public Usuario getUsuario() {
		usuario.setDataNascimento(new Date());
		return usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.usuario = Usuario;
	}
	
	public List<Usuario> getLista() {
		lista = UsuarioDao.listAll();
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
}
