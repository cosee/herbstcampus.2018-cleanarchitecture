package cosee.candyshop.database.gatewayimpl.pricelist;

import cosee.candyshop.core.domain.pricelist.PriceList;
import cosee.candyshop.core.domain.pricelist.PriceLists;
import cosee.candyshop.database.entity.pricelist.PriceListEntity;
import cosee.candyshop.database.entity.pricelist.PriceListRepository;
import org.springframework.stereotype.Service;

@Service
public class PriceListsImpl implements PriceLists {

    private final PriceListRepository priceListRepository;
    private final PriceListMapper priceListMapper;

    public PriceListsImpl(PriceListRepository priceListRepository, PriceListMapper priceListMapper) {
        this.priceListRepository = priceListRepository;
        this.priceListMapper = priceListMapper;
    }

    @Override
    public PriceList get() {
        PriceListEntity priceListEntity = priceListRepository.findAll().get(0);
        return priceListMapper.toDomain(priceListEntity);
    }

    @Override
    public void update(PriceList priceList) {
        PriceListEntity priceListEntity = priceListMapper.toEntity(priceList);
        priceListEntity.setNew(false);
        priceListRepository.save(priceListEntity);
    }

    @Override
    public void insert(PriceList priceList) {
        PriceListEntity priceListEntity = priceListMapper.toEntity(priceList);
        priceListEntity.setNew(false);
        PriceListEntity savedEntity = priceListRepository.save(priceListEntity);
        priceList.setId(savedEntity.getId());
    }
}
