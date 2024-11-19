package vn.loh.web_springsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.loh.web_springsecurity.models.Customer;

import java.util.List;

@RestController
@EnableMethodSecurity
@RequestMapping()
public class CustomerController {
    final private List<Customer> customers = List.of(
            Customer.builder()
                    .id("001")
                    .name("Nguyen Ha Hong Tuan")
                    .email("22110260@student.hcmute.edu.vn")
                    .build(),
            Customer.builder()
                    .id("002")
                    .name("Le Duc Minh Vuong")
                    .email("22110271@student.hcmute.edu.vn")
                    .build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello Guest!");
    }

    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> list = this.customers;
        return ResponseEntity.ok(list);
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustomerList(@PathVariable("id") String id) {
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();
        return ResponseEntity.ok(customers.get(0));
    }
}
