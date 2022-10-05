package tech.bytespot.ecommerce.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.bytespot.ecommerce.controllers.CustomersController.CustomerInput;
import tech.bytespot.ecommerce.domains.Customers;
import tech.bytespot.ecommerce.repositories.CustomersRepository;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Service
@RequiredArgsConstructor
public class CustomersService {
  private final CustomersRepository customersRepository;

  /**
   * Create a new customer
   *
   * @param customerInput
   * @return
   */
  public Customers createCustomer(CustomerInput customerInput) {
    Customers customer = new Customers();
    customer.setName(customerInput.name());
    customer.setEmail(customerInput.email());
    customer.setMsisdn(customerInput.msisdn());
    return customersRepository.save(customer);
  }

  /**
   * Fetch all customers present
   *
   * @return
   */
  public List<Customers> fetchAllCustomers() {
    return (List<Customers>) customersRepository.findAll();
  }

  /**
   * Fetch a customer record with a given ID
   *
   * @param id
   * @return
   */
  public Customers fetchCustomerById(Long id) {
    return customersRepository.findById(id).orElseThrow();
  }

  /**
   * Update a customer given their ID
   *
   * @param customer
   * @return
   */
  public Customers updateCustomer(Customers customer) {
    customersRepository.findById(customer.getId()).orElseThrow();
    return customersRepository.save(customer);
  }

  /**
   * Delete/De-activate a customer
   *
   * @param id
   * @return
   */
  public Customers deactivateCustomer(Long id) {
    var customer = customersRepository.findById(id).orElseThrow();
    customer.setStatus("INACTIVE");
    return customersRepository.save(customer);
  }
}
