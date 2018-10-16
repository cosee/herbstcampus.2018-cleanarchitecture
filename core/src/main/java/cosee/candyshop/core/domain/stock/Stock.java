package cosee.candyshop.core.domain.stock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Stock {

    private String candyId;
    private Integer amount;

    public void addAmount(Integer amount) {
        this.amount += amount;
    }

    public void decreaseAmount() {
        this.amount--;
    }

    public static Stock createNewStock(String candyId, Integer amount) {
        Stock stock = new Stock();
        stock.setCandyId(candyId);
        stock.setAmount(amount);
        return stock;
    }
}
