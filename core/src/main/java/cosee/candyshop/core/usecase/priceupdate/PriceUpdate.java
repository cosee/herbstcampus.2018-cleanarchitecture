package cosee.candyshop.core.usecase.priceupdate;

import cosee.candyshop.core.domain.candy.Price;
import lombok.Data;

@Data
class PriceUpdate {

    private String candyId;
    private Price price;
}
