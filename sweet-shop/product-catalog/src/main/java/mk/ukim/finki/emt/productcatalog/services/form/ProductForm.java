package mk.ukim.finki.emt.productcatalog.services.form;


import lombok.Data;
import mk.ukim.finki.emt.productcatalog.domain.models.Recipe;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class ProductForm {

    private String productName;
    private Money price;
    private int sales;

    @Valid
    @NotEmpty
    private Recipe recipe;
}
