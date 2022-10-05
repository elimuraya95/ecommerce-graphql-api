package tech.bytespot.ecommerce.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tech.bytespot.ecommerce.domains.Customers;
import tech.bytespot.ecommerce.services.CustomersService;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Controller
@RequiredArgsConstructor
public class CustomersController {
  private final CustomersService customersService;

  /**
   * Fetch customers from DB
   *
   * @return
   */
  @QueryMapping
  public List<Customers> fetchCustomers() {
    return customersService.fetchAllCustomers();
  }

  /**
   * Create a new customer
   *
   * @param customer
   * @return
   */
  @MutationMapping
  public Customers createCustomer(@Argument CustomerInput customer) {
    return customersService.createCustomer(customer);
  }

  public record CustomerInput(String name, String email, String msisdn) {}
}
