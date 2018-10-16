package cosee.candyshop.core.domain.candy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Candy {

    private String id;
    private String name;
    private String imageUrl;
    private String producer;
    private Price price;

    private Integer kcal;
    private Weight weight;

    private List<Ingredient> ingredients;
    private List<Nutrient> nutrients;

}
