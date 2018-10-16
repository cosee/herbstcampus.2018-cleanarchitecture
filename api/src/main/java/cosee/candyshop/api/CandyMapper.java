package cosee.candyshop.api;

import cosee.candyshop.core.commons.Paged;
import cosee.candyshop.core.commons.mapping.CentralConfig;
import cosee.candyshop.core.domain.candy.Candy;
import cosee.candyshop.core.domain.candy.Ingredient;
import cosee.candyshop.core.domain.candy.Nutrient;
import cosee.candyshop.core.domain.candy.Price;
import cosee.candyshop.core.domain.candy.Weight;
import cosee.candyshop.core.domain.candy.WeightUnit;
import cosee.candyshop.core.usecase.candy.create.CreateRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.math.BigDecimal;
import java.util.List;

@Mapper(config = CentralConfig.class)
public interface CandyMapper {

    @Mappings({
            @Mapping(target = "weight", ignore = true)
    })
    CreateRequest fromDto(CreateRequestDto candyRequestDto);

    @AfterMapping
    default void toWeight(@MappingTarget CreateRequest createRequest, CreateRequestDto createRequestDto) {
        Integer weightValue = Integer.valueOf(createRequestDto.getWeightValue());
        WeightUnit weightUnit = WeightUnit.valueOf(createRequestDto.getWeightUnit());
        createRequest.setWeight(new Weight(weightValue, weightUnit));
    }

    List<Ingredient> fromDto(List<String> ingredients);

    Ingredient fromDto(String ingredient);

    Nutrient fromDto(CreateRequestDto.NutrientDto nutrientDto);

    CandyListResponseDto toDto(Paged<Candy> candies);

    CandyDto toDto(Candy candy);

    /**
     * Format a price value.
     */
    default Integer formatPrice(Price price) {
        BigDecimal b = price.getSellingPrice();
        return b != null ? b.movePointRight(2).intValueExact() : null;
    }

}
