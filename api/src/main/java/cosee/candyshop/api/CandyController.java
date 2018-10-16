package cosee.candyshop.api;

import cosee.candyshop.core.commons.Paged;
import cosee.candyshop.core.domain.candy.Candy;
import cosee.candyshop.core.domain.candy.SortBy;
import cosee.candyshop.core.usecase.candy.browse.BrowseCandyService;
import cosee.candyshop.core.usecase.candy.create.CandyCreationService;
import cosee.candyshop.core.usecase.candy.create.CreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/candy")
public class CandyController {

    private final BrowseCandyService browseCandyService;
    private final CandyCreationService candyCreationService;
    private final CandyMapper candyMapper;

    public CandyController(BrowseCandyService browseCandyService, CandyCreationService candyCreationService, CandyMapper candyMapper) {
        this.browseCandyService = browseCandyService;
        this.candyCreationService = candyCreationService;
        this.candyMapper = candyMapper;
    }

    @PostMapping("/")
    public void createNewCandy(CreateRequestDto candyRequestDto) {
        CreateRequest createRequest = candyMapper.fromDto(candyRequestDto);
        candyCreationService.createNewCandy(createRequest);
    }

    @GetMapping(value = "/")
    public CandyListResponseDto getProducts(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                                    @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
                                                                    @RequestParam(value = "sortBy", required = false) String sortByString) {
        Paged<Candy> candies = browseCandyService.getCandiesPaged(page, pageSize, SortBy.valueOf(sortByString));
        return candyMapper.toDto(candies);
    }


}
