package cosee.candyshop.api;

import lombok.Data;

import java.util.List;

@Data
class CandyListResponseDto {

    private long totalHits;
    private List<CandyDto> hits;
}
