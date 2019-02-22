package simpleapplication.customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
//	@Autowired
	private CustomerRepository customerRepository;
	
//	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository, EntityManagerFactory entityManagerFactory) {
		super();
		this.customerRepository = customerRepository;
		this.entityManagerFactory = entityManagerFactory;
	}

	public Customer save(String firstName, String lastName) {
		return customerRepository.save(new Customer(firstName, lastName));
	}

	public List<Customer> findAll() {
		
		String result = "";
		
		for (Customer customer : customerRepository.findAll()) {
			result += customer.toString() + "<br>";
		}
		
		return result;
	}
	
	public String findById(long id) {
		return customerRepository.findById(id).toString();
	}

	public String findByLastName(String lastName) {
		String result = "";
		
		for (Customer customer : customerRepository.findByLastName(lastName)) {
			result += customer.toString() + "\n";
		}
		return result;
	}
	
	public void delete(long id) {
		customerRepository.deleteById(id);
	}

	public String updateCustomer(long id, String firstName, String lastName) {
		
		EntityManager session = entityManagerFactory.createEntityManager();
		
		session.getTransaction().begin();	
		session.createNativeQuery("UPDATE customer SET firstname = ?, lastname = ? WHERE id = ?")
			.setParameter(1, firstName)
		 	.setParameter(2, lastName)
		 	.setParameter(3, id)
		 	.executeUpdate();		 
		session.getTransaction().commit();
		session.close();
		
		return findById(id);
	}
}
