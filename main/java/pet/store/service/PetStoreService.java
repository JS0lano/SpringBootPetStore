package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pet.store.Dao.PetStoreDao;
import pet.store.controller.model.PetStoreData;
import pet.store.entity.PetStore;

public class PetStoreService {
	@Autowired
	private PetStoreDao petStoreDao;
	
	//inserts or modifies pet store data
	@Transactional(readOnly = false)
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		Long petStoreId = petStoreData.getPetStoreId();
		
		PetStore petStore = findOrCreatePetStore(petStoreId);
		
		copyPetStoreFields(petStore, petStoreData);
		
		return new PetStoreData(petStoreDao.save(petStore));
		
	}
	private void copyPetStoreFields(PetStore petStore,
			PetStoreData petStoreData) {
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
		petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		petStore.setPetStoreState(petStoreData.getPetStoreState());
		petStore.setPetStoreZip(petStoreData.getPetStoreZip());
	}
	private PetStore findOrCreatePetStore(Long petStoreId) {	
		if(Objects.isNull(petStoreId)) {	
			return new PetStore();
		} 
		else {
			return findPetStoreById(petStoreId);
		}
	}
	private PetStore findPetStoreById(Long petStoreId) {
		return petStoreDao.findById(petStoreId)
			.orElseThrow(() -> new NoSuchElementException(
				"Pet Store with ID="+ petStoreId + " not found."));
	}
}
