package cosee.candyshop.core.commons.mapping;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;


@MapperConfig(
        uses = CommonMapper.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring"
)
public interface CentralConfig {
}