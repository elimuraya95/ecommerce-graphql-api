package tech.bytespot.ecommerce.services;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.bytespot.ecommerce.controllers.OrdersController.OrderInput;
import tech.bytespot.ecommerce.domains.Items;
import tech.bytespot.ecommerce.domains.Orders;
import tech.bytespot.ecommerce.repositories.CustomersRepository;
import tech.bytespot.ecommerce.repositories.ItemsRepository;
import tech.bytespot.ecommerce.repositories.OrdersRepository;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Service
@RequiredArgsConstructor
public class OrdersService {
  private final CustomersRepository customersRepository;
  private final ItemsRepository itemsRepository;
  private final OrdersRepository ordersRepository;

  /**
   * Create a new customer order
   *
   * @param ordersInput
   * @return
   */
  public Orders createOrder(OrderInput ordersInput) {
    var customer = customersRepository.findById(ordersInput.customerId()).orElseThrow();
    var items = itemsRepository.findAllById(ordersInput.itemIds());
    Orders order = new Orders();
    order.setLocation(ordersInput.location());
    // todo - do the necessary calculations
    order.setOrderCost(0.0);
    order.setDeliveryCost(0.0);
    order.setTotalCost(0.0);
    order.setDeliveryDate(ordersInput.deliveryDate());
    order.setCustomer(customer);
    order.setItems(new HashSet((Collection) items));
    return ordersRepository.save(order);
  }
}
