package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // Utilizado para informar que uma classe tambem sera uma entidade de banco de dados
public class Usuario {
	@Id // Utilizado para ser referenciado com chave primaria
	@GeneratedValue // Utilizado para gerar o id automaticamente(autoincremento)
	private Integer id;
	private String nome;
	private String sexo;
	private String senha;
	
	 public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Temporal(TemporalType.DATE) // Para informar que sera mapeada para bd como um tipo de data
	 @Column(name = "data_nascimento") // Usada para realizar mapeamento do campo com a coluna do bd
	private Date dataNascimento;
	 
	 //Metodos get e sets para obter um dado ou setar um dado
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
