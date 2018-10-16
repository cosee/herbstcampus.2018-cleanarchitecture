package cosee.candyshop.core.domain.pricelist;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Entry {

    private String id;
    private String name;
    private BigDecimal price;
}