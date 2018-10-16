package cosee.candyshop.core.usecase.ordering;

import cosee.candyshop.core.domain.employee.Employee;
import cosee.candyshop.core.domain.stock.Stock;
import cosee.candyshop.core.domain.stock.Stocks;
import org.springframework.stereotype.Service;

@Service
public class OrderingService {

    private final Stocks stocks;
    private final OrderingNotificationGateway orderingNotificationGateway;

    public OrderingService(Stocks stocks, OrderingNotificationGateway orderingNotificationGateway) {
        this.stocks = stocks;
        this.orderingNotificationGateway = orderingNotificationGateway;
    }

    public void consumeCandy(Employee employee, String candyId) {
        Stock stock = stocks.findStockByCandyId(candyId);
        stock.decreaseAmount();
        stocks.update(stock);
        orderingNotificationGateway.submit(new OrderingNotification(employee, candyId));
    }
}
