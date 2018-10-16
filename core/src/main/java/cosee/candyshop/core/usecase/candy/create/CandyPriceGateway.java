package cosee.candyshop.core.usecase.candy.create;

import cosee.candyshop.core.domain.candy.Price;

public interface CandyPriceGateway {

    Price getCurrentPriceForCandy(String candyId);
}
