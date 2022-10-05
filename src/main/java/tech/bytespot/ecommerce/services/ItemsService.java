package tech.bytespot.ecommerce.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.bytespot.ecommerce.domains.Items;
import tech.bytespot.ecommerce.repositories.ItemsRepository;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Service
@RequiredArgsConstructor
public class ItemsService {
  private final ItemsRepository itemsRepository;

  /**
   * Fetch all items available on the DB
   *
   * @return
   */
  public List<Items> fetchItems() {
    return (List<Items>) itemsRepository.findAll();
  }
}
