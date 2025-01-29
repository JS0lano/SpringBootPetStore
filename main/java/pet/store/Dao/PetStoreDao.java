package pet.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.PetStore;

public interface PetStoreDao extends JpaRepository<PetStore, Long> {

}
