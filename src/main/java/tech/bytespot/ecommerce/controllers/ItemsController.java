package tech.bytespot.ecommerce.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.bytespot.ecommerce.domains.Items;
import tech.bytespot.ecommerce.services.ItemsService;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Controller
@RequiredArgsConstructor
public class ItemsController {
  private final ItemsService itemsService;

  /**
   * Fetch items
   *
   * @return
   */
  @QueryMapping
  public List<Items> fetchItems() {
    return itemsService.fetchItems();
  }
}
