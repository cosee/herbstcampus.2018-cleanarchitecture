package cosee.candyshop.core.domain.candy;

import cosee.candyshop.core.commons.Paged;
import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CandiesTestStub implements Candies {

    public Map<String, Candy> store = new HashMap<>();
    public Set<String> updated = new HashSet<>();
    public Set<String> inserted = new HashSet<>();

    public void fillWithTestData(Candy... candies) {
        for (Candy candy : candies) {
            store.put(candy.getId(), candy);
        }
    }

    @Override
    public Paged<Candy> findCandiesPaged(int page, int pageSize, SortBy sortBy) {
        return new Paged<>(store.size(), Lists.newArrayList(store.values()));
    }

    @Override
    public Candy findById(String candyId) {
        return store.get(candyId);
    }

    @Override
    public void insert(Candy candy) {
        if (store.containsKey(candy.getId())) {
            throw new RuntimeException("Candy already exists.");
        }
        store.put(candy.getId(), candy);
        inserted.add(candy.getId());
    }

    @Override
    public void update(Candy candy) {
        if (!store.containsKey(candy.getId())) {
            throw new RuntimeException("Candy does not exist.");
        }
        store.put(candy.getId(), candy);
        updated.add(candy.getId());
    }
}
