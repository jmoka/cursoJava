package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department depObj);
	void updade(Department depObj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}
