package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private Date brithDate;
	private Double baseSalary;
	
	
	
// Nesse exemplo o vendedor saller possui uma associação com departamento
	// vendedor tem um departamento
	// vamos compor os objetos
	
	private Department department;
	
		
public Seller() {
	super();
}


public Seller(Integer id, String name, String email, Date brithDate, Double baseSalary, Department department) {
	this.id = id;
	this.name = name;
	this.email = email;
	this.brithDate = brithDate;
	this.baseSalary = baseSalary;
	this.department = department;
}


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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getBrithDate() {
	return brithDate;
}

public void setBrithDate(Date brithDate) {
	this.brithDate = brithDate;
}

public Double getBaseSalary() {
	return baseSalary;
}

public void setBaseSalary(Double baseSalary) {
	this.baseSalary = baseSalary;
}


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
	Seller other = (Seller) obj;
	return Objects.equals(id, other.id);
}


@Override
public String toString() {
	return "Saller [id=" + id + ", name=" + name + ", email=" + email + ", brithDate=" + brithDate + ", baseSalary="
			+ baseSalary + ", department=" + department + "]";
};



}
