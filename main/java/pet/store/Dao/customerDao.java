package pet.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.Customer;


public interface customerDao  extends JpaRepository<Customer, Long> {

}

