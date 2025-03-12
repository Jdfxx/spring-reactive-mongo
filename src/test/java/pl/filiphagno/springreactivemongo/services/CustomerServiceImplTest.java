package pl.filiphagno.springreactivemongo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.filiphagno.springreactivemongo.mapper.CustomerMapper;
import pl.filiphagno.springreactivemongo.model.CustomerDTO;
import pl.filiphagno.springreactivemongo.repository.CustomerRepository;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    CustomerDTO customerDTO;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerDTO = CustomerDTO.builder()
                .customerName("test name")
                .build();
    }

    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    @Test
    void testSaveCustomer() {
        Mono<CustomerDTO> savedCustomer = customerService.save(Mono.just(customerDTO));

        savedCustomer.subscribe(
                customerDTO -> {
                    assertThat(customerDTO.getId()).isNotNull();
                    atomicBoolean.set(true);
                }
        );
        await().untilTrue(atomicBoolean);
    }
}