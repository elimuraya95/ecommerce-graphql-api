package tech.bytespot.ecommerce.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import tech.bytespot.ecommerce.domains.Customers;
import tech.bytespot.ecommerce.domains.Orders;
import tech.bytespot.ecommerce.repositories.OrdersRepository;
import tech.bytespot.ecommerce.services.OrdersService;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Controller
@RequiredArgsConstructor
public class OrdersController {
  private final OrdersService ordersService;

  @MutationMapping
  public Orders createOrder(@Argument OrderInput order) {
    return ordersService.createOrder(order);
  }

  public record OrderInput(
      String location, String deliveryDate, Long customerId, List<Long> itemIds) {}
}
