package cosee.candyshop.core.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AutoIdentifier<T> {

    private T id;
}
