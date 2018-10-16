package cosee.candyshop.database.entity.candy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Getter
@Setter
@Entity
public class CandyEntity implements Persistable<String> {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //and all the other fields + relations

    @Transient
    private boolean isNew;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
