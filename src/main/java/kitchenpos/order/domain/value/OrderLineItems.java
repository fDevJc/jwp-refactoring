package kitchenpos.order.domain.value;

import kitchenpos.order.domain.entity.Order;
import kitchenpos.order.domain.entity.OrderLineItem;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

@Embeddable
public class OrderLineItems {
    @OneToMany(mappedBy = "order")
    private List<OrderLineItem> orderLineItems;

    public OrderLineItems() {
    }

    public OrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public void toOrder(Order order) {
        orderLineItems.forEach(orderLineItem -> orderLineItem.toOrder(order));
    }

    public List<OrderLineItem> getValue() {
        return Collections.unmodifiableList(orderLineItems);
    }
}
