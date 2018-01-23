package com.sample.mvc.dao;
import com.sample.mvc.model.EmployeeCommand;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


// Class started
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	public EmployeeDAOImpl() {
		super();
		// Auto-generated constructor stub
	}

	@Override
	public void addEmployee(EmployeeCommand employee) {
		 this.sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		EmployeeCommand employee = (EmployeeCommand) sessionFactory.getCurrentSession().load(EmployeeCommand.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
	}
	
	@Override
	public List<EmployeeCommand> listContact() {
		  return sessionFactory.getCurrentSession().createQuery("from EmployeeCommand").list();
	}

	@Override
	public EmployeeCommand getEmployeebyId(Integer employeeId) {
		EmployeeCommand empCmd = (EmployeeCommand) this.sessionFactory.getCurrentSession().get(EmployeeCommand.class, employeeId);
		return empCmd;
	}

	@Override
	public void updateEmployee(EmployeeCommand employeeCommand) {
		this.sessionFactory.getCurrentSession().update(employeeCommand);
	}

	

}
