package cosee.candyshop.core.usecase.priceupdate;

import cosee.candyshop.core.domain.candy.Candies;
import cosee.candyshop.core.domain.candy.Candy;
import cosee.candyshop.core.domain.pricelist.PriceList;
import cosee.candyshop.core.domain.pricelist.PriceLists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PriceUpdateService {

    private final Candies candies;
    private final PriceLists priceLists;

    public PriceUpdateService(Candies candies, PriceLists priceLists) {
        this.candies = candies;
        this.priceLists = priceLists;
    }

    @Transactional
    public void processPriceUpdate(PriceUpdate priceUpdate) {
        Candy candy = candies.findById(priceUpdate.getCandyId());
        candy.setPrice(priceUpdate.getPrice());
        candies.update(candy);

        PriceList priceList = priceLists.get();
        priceList.addCandy(candy);
        priceLists.update(priceList);
    }
}
