package simpleapplication.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping(value="/add")
	 public Customer addCustomer(@RequestBody Customer customer) {
		 return customerService.save(customer.getFirstName(), customer.getLastName()); 
	 }
	 
	 @RequestMapping("/find-all")
	 public List<Customer> findAll() {
		 return customerService.findAll();
	 }
	 
	 @RequestMapping("/find/{id}")
	 public String findById(@PathVariable long id) {
		 return customerService.findById(id);
	 }
	 
	 @RequestMapping("/find-by-last-name")
	 public String findByLastName(@RequestParam String lastname) {
		 return customerService.findByLastName(lastname);
	 }
	 
	 @RequestMapping("/delete")
	 public void deleteById(@RequestParam long id) {
		 customerService.delete(id);
	 }
	 
	 @PutMapping("/update")
	 public String updateCustomer(@RequestParam long id, @RequestParam String firstname, @RequestParam String lastname) {
		 return customerService.updateCustomer(id, firstname, lastname);
	 }
	 
}
