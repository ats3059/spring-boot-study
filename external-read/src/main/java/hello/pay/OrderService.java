package hello.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PayClient payClient;

    public void order(int money) {
        // 주문 로직이 있다고 가정함
        payClient.pay(money);

    }
}
