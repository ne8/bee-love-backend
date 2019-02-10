package ro.ccpatrut.beelove.entities.shop;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders", schema = "beelove")
@Data
@ToString
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "postal_Code", nullable = false)
    private String postalCode;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "full_address", nullable = false)
    private String fullAddress;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrderEntity> productOrderEntityList;
}
