package cosee.candyshop.database.gatewayimpl.candy;

import cosee.candyshop.core.commons.Paged;
import cosee.candyshop.core.domain.candy.Candies;
import cosee.candyshop.core.domain.candy.Candy;
import cosee.candyshop.core.domain.candy.SortBy;
import cosee.candyshop.database.entity.candy.CandyEntity;
import cosee.candyshop.database.entity.candy.CandyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandiesImpl implements Candies {

    private final CandyRepository candyRepository;
    private final CandyMapper candyMapper;

    public CandiesImpl(CandyRepository candyRepository, CandyMapper candyMapper) {
        this.candyRepository = candyRepository;
        this.candyMapper = candyMapper;
    }

    @Override
    public Paged<Candy> findCandiesPaged(int page, int pageSize, SortBy sortBy) {
        Page<CandyEntity> pagedEntities = candyRepository.findAll(PageRequest.of(page, pageSize, mapSortBy(sortBy)));
        List<Candy> candies = candyMapper.toDomain(pagedEntities.getContent());
        return new Paged<>(pagedEntities.getTotalElements(), candies);
    }

    @Override
    public Candy findById(String candyId) {
        Optional<CandyEntity> candyEntity = candyRepository.findById(candyId);
        return candyEntity.map(candyMapper::toDomain).orElse(null);
    }

    @Override
    public void insert(Candy candy) {
        CandyEntity candyEntity = candyMapper.toEntity(candy);
        candyEntity.setNew(true);
        candyRepository.save(candyEntity);
    }

    @Override
    public void update(Candy candy) {
        CandyEntity candyEntity = candyMapper.toEntity(candy);
        candyEntity.setNew(false);
        candyRepository.save(candyEntity);
    }

    private Sort mapSortBy(SortBy sortBy) {
        if (sortBy == SortBy.NAME_ASC) {
            return Sort.by(Sort.Direction.ASC, "name");
        } else if (sortBy == SortBy.NAME_DESC) {
            return Sort.by(Sort.Direction.DESC, "name");
        }
        throw new IllegalArgumentException("Unable to map SortBy: " + sortBy);
    }
}
