package tacos.web;

import lombok.*;

@Data
public class Order {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    public Order() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

}
