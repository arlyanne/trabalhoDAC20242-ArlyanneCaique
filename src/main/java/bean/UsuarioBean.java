package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

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
	
	public String excluir() {
		try {
			UsuarioDao.delete(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario " + usuario.getId() + " removido com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ops! Não foi possível realizar essa operação."));
		}
		
		return null;
	}
	
	public String editar() {
		try {
			Usuario usuarioExistente = UsuarioDao.find(usuario.getId());
			usuarioExistente.setNome(usuario.getNome());
			usuarioExistente.setSenha(usuario.getSenha());
			usuarioExistente.setSexo(usuario.getSexo());
			usuarioExistente.setDataNascimento(usuario.getDataNascimento());
			
			UsuarioDao.update(usuario);
			PrimeFaces.current().ajax().update("formulario:tabela");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario " + usuario.getId() + " editado com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ops! Não foi possível realizar essa operação."));
		}
		
		return null;
	}
	
	public void contar() {
		int contagem = UsuarioDao.count();
		FacesMessage message = new FacesMessage("Contagem de registros: " + contagem);
	    FacesContext.getCurrentInstance().addMessage(null, message);
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
