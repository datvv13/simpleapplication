package simpleapplication.customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
//	@Query("From Customer c Where c.lastName = ?1 AND c.firstName = ?2 LIMIT 1")
	public List<Customer> findByLastName(String lastName);
}
