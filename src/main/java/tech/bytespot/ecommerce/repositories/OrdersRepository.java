package tech.bytespot.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.bytespot.ecommerce.domains.Orders;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {}
