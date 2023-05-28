package mk.ukim.finki.emt.ordermanagement.domain.model;


import javax.persistence.*;

import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Product;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant date;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany
    private Set<User>users=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();



    private Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now, mk.ukim.finki.emt.sharedkernel.domain.financial.Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.date = now;
        this.currency = currency;
    }

    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Product product, int qty) {
        Objects.requireNonNull(product,"product must not be null");
        var item  = new OrderItem(product.getId(),product.getPrice(),qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }

}