package guru.sfg.beer.order.service.bootstrap;

import guru.sfg.beer.order.service.domain.Customer;
import guru.sfg.beer.order.service.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by jt on 2019-06-06.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderBootStrap implements CommandLineRunner {
    public static final String TASTING_ROOM = "Tasting Room";
    public static final String BEER_1_UPC = "063214569812";
    public static final String BEER_2_UPC = "063987103524";
    public static final String BEER_3_UPC = "008369421087";

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCustomerData();
    }

    private void loadCustomerData() {
        if (customerRepository.count() == 0) {
           Customer savedCustomer = customerRepository.save(Customer.builder()
                    .customerName(TASTING_ROOM)
                    .apiKey(UUID.randomUUID())
                    .build());
            log.debug("Tasting room Customer ID : " + savedCustomer.getId().toString());
        }
    }
}
