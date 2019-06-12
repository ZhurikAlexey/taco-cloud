package tacos.web;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco_Order")
public class Order {
    @Id
    @GeneratedValue
    private Integer Id;

    private Date placedAt;
    @PrePersist
    void placedAt(){
        this.placedAt = new Date();
    }
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public Order() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

}
