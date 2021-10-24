package app.netlify.gledyson.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;

    private String lastName;

    @JsonIgnore
    @OneToMany(
            mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<CustomerOrder> customerOrders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, List<CustomerOrder> customerOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerOrders = customerOrders;
    }

    public Customer(UUID id, String firstName, String lastName, List<CustomerOrder> customerOrders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerOrders = customerOrders;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerOrders=" + customerOrders +
                '}';
    }
}
