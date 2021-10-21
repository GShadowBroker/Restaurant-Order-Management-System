package app.netlify.gledyson.restaurant.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Item> items;

    public CustomerOrder() {
    }

    public CustomerOrder(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    public CustomerOrder(Long id, Customer customer, List<Item> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}
