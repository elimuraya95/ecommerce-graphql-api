package tech.bytespot.ecommerce.domains;

import java.time.Instant;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Orders {
  @Id @GeneratedValue private Long id;
  private String location;

  @Column(columnDefinition = "double default 0.0")
  private Double orderCost;

  @Column(columnDefinition = "double default 0.0")
  private Double deliveryCost;

  @Column(columnDefinition = "double default 0.0")
  private Double totalCost;

  private String deliveryDate;
  private Instant createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  private Customers customer;

  @ManyToMany
  @JoinTable(
      name = "order_items",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id"))
  private Set<Items> items;

  @PrePersist
  public void preCreate() {
    this.createdAt = Instant.now();
  }
}
