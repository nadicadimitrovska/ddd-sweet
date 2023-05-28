package mk.ukim.finki.emt.productcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class RecipeId extends DomainObjectId {
    private RecipeId() {
        super(RecipeId.randomId(RecipeId.class).getId());
    }

    public RecipeId(@NonNull String uuid) {
        super(uuid);
    }

    public static RecipeId of(String uuid) {
        RecipeId p = new RecipeId(uuid);
        return p;
    }
}
