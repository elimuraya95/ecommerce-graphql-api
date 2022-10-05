package tech.bytespot.ecommerce.domains;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Data
@NoArgsConstructor
@Entity
public class Items {
  @Id @GeneratedValue private Long id;
  private String itemCode;
  private String itemName;
  private String itemDescription;
  private Double cost;
  private String currency;
  private Instant createdAt;

  @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
  private Set<Orders> orders;

  @PrePersist
  public void preCreate() {
    this.createdAt = Instant.now();
  }
}
