package tech.bytespot.ecommerce.domains;

import java.time.Instant;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: eli.muraya (https://github.com/elimuraya95))
 * @date: 05/10/2022
 */
@Data
@NoArgsConstructor
@Entity
public class Customers {
  @Id @GeneratedValue private Long id;
  private String name;
  private String email;
  private String msisdn;
  private String status;
  private Instant signUpDate;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Orders> orders;

  @PrePersist
  public void preCreate() {
    this.signUpDate = Instant.now();
    this.status = "ACTIVE";
  }
}
