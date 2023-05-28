package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_user")
@Getter
public class User extends AbstractEntity<UserId> {


    private String username;
    private String name;
    private String surname;
    private String password;

    private User() {
        super(DomainObjectId.randomId(UserId.class));
    }
}
