package cosee.candyshop.core.domain.candy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Price {

    private BigDecimal uvpPrice;
    private BigDecimal sellingPrice;
}
