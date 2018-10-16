package cosee.candyshop.core.usecase.stock.refill;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
class CandyDelivery {

    private Set<CandyPack> candyPacks;

    @Data
    class CandyPack {
        private String candyId;
        private Integer amount;
    }
}
