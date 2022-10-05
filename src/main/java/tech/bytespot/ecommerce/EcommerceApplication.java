package tech.bytespot.ecommerce;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.bytespot.ecommerce.domains.Customers;
import tech.bytespot.ecommerce.domains.Items;
import tech.bytespot.ecommerce.domains.Orders;
import tech.bytespot.ecommerce.repositories.CustomersRepository;
import tech.bytespot.ecommerce.repositories.ItemsRepository;
import tech.bytespot.ecommerce.repositories.OrdersRepository;

@SpringBootApplication
public class EcommerceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
  }

  /**
   * Create some test data into the H2 DB on application start-up
   *
   * @param customersRepository
   * @param ordersRepository
   * @param itemsRepository
   * @return
   */
  @Bean
  ApplicationRunner applicationRunner(
      CustomersRepository customersRepository,
      OrdersRepository ordersRepository,
      ItemsRepository itemsRepository) {
    return args -> {
      // Create the sample data
      Items cookingOil = new Items();
      cookingOil.setItemCode("SKU-10");
      cookingOil.setItemName("Awesome Cooking Oil");
      cookingOil.setItemDescription("This is the best cooking oil in the world");
      cookingOil.setCost(10.00);
      cookingOil.setCurrency("USD");

      Items noodles = new Items();
      noodles.setItemCode("SKU-11");
      noodles.setItemName("Awesome Noodles");
      noodles.setItemDescription("These are just noodles, nothing much.");
      noodles.setCost(3.00);
      noodles.setCurrency("USD");
      var items = itemsRepository.saveAll(List.of(cookingOil, noodles));

      Customers johnDoe = new Customers();
      johnDoe.setName("John Doe");
      johnDoe.setEmail("john.doe@test.app");
      johnDoe.setMsisdn("+254700112244");
      var customer = customersRepository.save(johnDoe);

      Orders johnOrder = new Orders();
      johnOrder.setLocation("Test Street, Nairobi, Kenya");
      johnOrder.setOrderCost(13.0);
      johnOrder.setDeliveryCost(0.0);
      johnOrder.setTotalCost(13.0);
      johnOrder.setDeliveryDate("09/11/2022");
      johnOrder.setItems(new HashSet((Collection) items));
      johnOrder.setCustomer(customer);
      var order = ordersRepository.save(johnOrder);
    };
  }
}
