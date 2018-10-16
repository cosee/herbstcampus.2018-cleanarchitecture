package cosee.candyshop.core.usecase.ordering;

import cosee.candyshop.core.domain.employee.Employee;
import lombok.Data;

@Data
class OrderingNotification {

    private final Employee employee;
    private final String candyId;

}
