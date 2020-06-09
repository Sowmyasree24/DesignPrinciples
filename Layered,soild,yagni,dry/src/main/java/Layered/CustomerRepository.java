package Layered;
import Layered.Objects.CustomerEntity;
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	    
	    CustomerEntity findByUsername(String username);
}
