package cosee.candyshop.database.gatewayimpl.pricelist;

import cosee.candyshop.core.domain.pricelist.PriceList;
import cosee.candyshop.database.entity.pricelist.PriceListEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PriceListMapper {

    PriceListEntity toEntity(PriceList priceList);

    PriceList toDomain(PriceListEntity priceListEntity);
}
