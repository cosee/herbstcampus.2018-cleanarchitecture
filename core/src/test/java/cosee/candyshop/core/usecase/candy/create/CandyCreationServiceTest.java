package cosee.candyshop.core.usecase.candy.create;

import cosee.candyshop.core.domain.candy.CandiesTestStub;
import cosee.candyshop.core.domain.candy.Candy;
import cosee.candyshop.core.domain.candy.Price;
import cosee.candyshop.core.domain.pricelist.Entry;
import cosee.candyshop.core.domain.pricelist.PriceList;
import cosee.candyshop.core.domain.pricelist.PriceListsTestStub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CandyCreationServiceTest {

    private CandyCreationService candyCreationService;
    private CandiesTestStub candies;
    private PriceListsTestStub priceLists;
    @Mock
    private CandyPriceGateway candyPriceGateway;

    @Before
    public void setup() {
        candies = new CandiesTestStub();
        priceLists = new PriceListsTestStub();
        candyCreationService = new CandyCreationService(candies, priceLists, candyPriceGateway);
    }

    @Test
    public void candyNotYetPresent_newCandyIsCreated_candyIsProperlyCreated() {
        priceLists.priceList = new PriceList();
        CreateRequest createRequest = new CreateRequest();
        createRequest.setId("snickers");
        createRequest.setName("The amazing Snickers");

        Price price = new Price(new BigDecimal(2), new BigDecimal(1.5));
        when(candyPriceGateway.getCurrentPriceForCandy(eq(createRequest.getId()))).thenReturn(price);

        candyCreationService.createNewCandy(createRequest);

        assertThat(candies.inserted).containsExactly(createRequest.getId());
        Candy candy = candies.store.get(createRequest.getId());
        assertThat(candy).isNotNull();
        assertThat(candy.getName()).isEqualTo(createRequest.getName());
        assertThat(candy.getPrice()).isEqualTo(price);
        // ... assert remaining fields
    }

    @Test
    public void candyNotYetPresent_newCandyIsCreated_candyIsAddedToPriceList() {
        priceLists.priceList = new PriceList();
        CreateRequest createRequest = new CreateRequest();
        createRequest.setId("snickers");
        createRequest.setName("The amazing Snickers");

        Price price = new Price(new BigDecimal(2), new BigDecimal(1.5));
        when(candyPriceGateway.getCurrentPriceForCandy(eq(createRequest.getId()))).thenReturn(price);

        assertThat(priceLists.priceList.getCandies()).hasSize(1);
        Entry priceListEntry = priceLists.priceList.getCandies().get(0);
        assertThat(priceListEntry.getId()).isEqualTo(createRequest.getId());
        assertThat(priceListEntry.getName()).isEqualTo(createRequest.getName());
        assertThat(priceListEntry.getPrice()).isEqualTo(price.getSellingPrice());
        assertThat(priceLists.updated).isTrue();
    }
}
