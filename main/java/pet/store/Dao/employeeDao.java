package pet.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.Employee;

	public interface employeeDao extends JpaRepository<Employee, Long> {

	}

