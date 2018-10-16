package cosee.candyshop.core.domain.pricelist;

public interface PriceLists {

    PriceList get();

    void update(PriceList priceList);

    void insert(PriceList priceList);
}
