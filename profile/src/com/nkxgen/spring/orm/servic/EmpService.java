
package com.nkxgen.spring.orm.servic;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.EmpDAO;
import com.nkxgen.spring.orm.model.Employee;

@Component
public class EmpService {

	@Autowired
	private EmpDAO empdao;

	@Transactional
	public void add(Employee emp) {
		empdao.persist(emp);
	}

	@Transactional
	public void addAll(Collection<Employee> empList) {
		for (Employee emp : empList) {
			empdao.persist(emp);
		}
	}

	@Transactional
	public Employee getByEmail(String email) {
		return empdao.getDetailsByEmail(email);
	}

	@Transactional(readOnly = true)
	public List<Employee> listAll() {
		return empdao.findAll();

	}

}
