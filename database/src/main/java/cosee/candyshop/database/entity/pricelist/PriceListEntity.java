package cosee.candyshop.database.entity.pricelist;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Getter
@Setter
public class PriceListEntity implements Persistable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    //... fields + relations...

    @Transient
    private boolean isNew;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
