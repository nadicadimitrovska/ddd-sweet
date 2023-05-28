package mk.ukim.finki.emt.productcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_recipe")
@Getter
public class Recipe extends AbstractEntity<RecipeId> {

    private String ingredients;
    private String name;

    private Recipe() {
        super(RecipeId.randomId(RecipeId.class));
    }
}
