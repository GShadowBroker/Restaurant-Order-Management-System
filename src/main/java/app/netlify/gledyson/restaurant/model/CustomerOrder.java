package app.netlify.gledyson.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class CustomerOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    private String observation;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.IN_QUEUE;

    public CustomerOrder() {
    }

    public CustomerOrder(Long id, Customer customer, List<Item> items, String observation) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.observation = observation;
    }

    public CustomerOrder(Customer customer, List<Item> items, String observation) {
        this.customer = customer;
        this.items = items;
        this.observation = observation;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", customer=" + customer +
                ", items=" + items +
                ", observation='" + observation + '\'' +
                ", status=" + status +
                '}';
    }
}
