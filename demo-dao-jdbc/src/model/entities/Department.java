package model.entities;

import java.io.Serializable;
import java.util.Objects;

// Implementação do Serializable (para que os objetos possam serem transformados em sequencia de 
// byts, para que possam serem guardados em arquivos, rodar em rede etc.., e o e o serializable é 
// uma interfac e precisa ser implementado)

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
	// contrutor padrão
	private Department() {
		super();
	}

	// conatrutor personalizado
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// get e set
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	// hashCode and aquals ( para poder ser comparados pelo conteudo, podendo comparar somente um atrubuto ou mais de um)
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}
	
	// toString ( para termos uma facilidade de impressão nos testes)
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	

	
	

}
