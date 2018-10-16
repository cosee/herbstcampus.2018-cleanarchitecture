package cosee.candyshop.core.domain.pricelist;

import cosee.candyshop.core.domain.pricelist.PriceList;
import cosee.candyshop.core.domain.pricelist.PriceLists;

public class PriceListsTestStub implements PriceLists {

    public PriceList priceList;
    public boolean updated;

    @Override
    public PriceList get() {
        return priceList;
    }

    @Override
    public void update(PriceList priceList) {
        this.priceList = priceList;
        updated = true;
    }

}
