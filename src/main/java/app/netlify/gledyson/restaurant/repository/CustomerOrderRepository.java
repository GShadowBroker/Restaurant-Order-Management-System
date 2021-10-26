package app.netlify.gledyson.restaurant.repository;

import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Modifying
    @Query("UPDATE CustomerOrder o SET o.status = ?2 WHERE o.id = ?1")
    void updateStatus(long orderId, OrderStatus status);

    @Modifying
    @Query("DELETE FROM CustomerOrder o WHERE o.id = ?1")
    void deleteById(long orderId);
}
