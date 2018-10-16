package cosee.candyshop.core.usecase.candy.browse;

import cosee.candyshop.core.commons.Paged;
import cosee.candyshop.core.domain.candy.Candies;
import cosee.candyshop.core.domain.candy.Candy;
import cosee.candyshop.core.domain.candy.SortBy;
import org.springframework.stereotype.Service;

@Service
public class BrowseCandyService {

    private final Candies candies;

    public BrowseCandyService(Candies candies) {
        this.candies = candies;
    }

    public Paged<Candy> getCandiesPaged(int page, int pageSize, SortBy sortBy) {
        return candies.findCandiesPaged(page, pageSize, sortBy);
    }
}
