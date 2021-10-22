package app.netlify.gledyson.restaurant.model;

import java.util.List;
import java.util.UUID;

public class OrderForm {

    private UUID customerId;
    private List<Item> items;
    private String observation;

    public OrderForm() {
    }

    public OrderForm(UUID customerId, List<Item> items, String observation) {
        this.customerId = customerId;
        this.items = items;
        this.observation = observation;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "customerId=" + customerId +
                ", items=" + items +
                ", observation='" + observation + '\'' +
                '}';
    }
}
