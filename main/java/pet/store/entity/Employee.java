package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long EmployeeId;
	private String employeeFirstName;
	private String employeeLastName;
    private String employeePhone;
    private String employeeJobTitle;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_store_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PetStore petStore;


}
	