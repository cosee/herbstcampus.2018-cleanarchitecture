package cosee.candyshop.core.domain.stock;

public interface Stocks {

    Stock findStockByCandyId(String candyId);

    void update(Stock stock);

    void insert(Stock stock);
}
