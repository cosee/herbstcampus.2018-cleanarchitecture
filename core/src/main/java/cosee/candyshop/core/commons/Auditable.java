package cosee.candyshop.core.commons;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class Auditable {

    private Instant insertDate;

    private Instant updateDate;

}
