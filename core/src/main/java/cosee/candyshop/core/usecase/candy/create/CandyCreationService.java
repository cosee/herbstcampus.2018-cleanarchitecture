package cosee.candyshop.core.usecase.candy.create;

import cosee.candyshop.core.domain.candy.Candies;
import cosee.candyshop.core.domain.candy.Candy;
import cosee.candyshop.core.domain.candy.Price;
import cosee.candyshop.core.domain.pricelist.PriceList;
import cosee.candyshop.core.domain.pricelist.PriceLists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CandyCreationService {

    private final Candies candies;
    private final PriceLists priceLists;
    private final CandyPriceGateway candyPriceGateway;

    public CandyCreationService(Candies candies, PriceLists priceLists, CandyPriceGateway candyPriceGateway) {
        this.candies = candies;
        this.priceLists = priceLists;
        this.candyPriceGateway = candyPriceGateway;
    }

    @Transactional
    public void createNewCandy(CreateRequest createRequest) {
        validate(createRequest);
        Price price = candyPriceGateway.getCurrentPriceForCandy(createRequest.getId());
        Candy candy = createNewCandy(createRequest, price);
        candies.insert(candy);

        PriceList priceList = priceLists.get();
        priceList.addCandy(candy);
        priceLists.update(priceList);
    }

    private Candy createNewCandy(CreateRequest createRequest, Price price) {
        Candy candy = new Candy();
        candy.setId(createRequest.getId());
        candy.setName(createRequest.getName());
        candy.setImageUrl(createRequest.getImageUrl());
        candy.setProducer(createRequest.getProducer());
        candy.setKcal(createRequest.getKcal());
        candy.setWeight(createRequest.getWeight());
        candy.setNutrients(createRequest.getNutrients());
        candy.setIngredients(createRequest.getIngredients());
        candy.setPrice(price);
        return candy;
    }

    private void validate(CreateRequest createRequest) {
      // use manual validation or bean validation
    }
}
