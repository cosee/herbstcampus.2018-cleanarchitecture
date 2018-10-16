package cosee.candyshop.core.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Paged<T> {

    long totalHits;
    List<T> hits;
}
