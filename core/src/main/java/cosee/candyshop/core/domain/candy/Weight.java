package cosee.candyshop.core.domain.candy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Weight {

    private Integer value;
    private WeightUnit unit;
}
