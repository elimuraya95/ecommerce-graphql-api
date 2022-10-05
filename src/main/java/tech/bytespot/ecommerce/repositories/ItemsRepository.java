package tech.bytespot.ecommerce.repositories;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.repository.CrudRepository;
import tech.bytespot.ecommerce.domains.Items;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
public interface ItemsRepository extends CrudRepository<Items, Long> {}
