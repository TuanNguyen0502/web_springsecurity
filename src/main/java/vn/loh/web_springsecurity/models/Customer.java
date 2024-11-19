package vn.loh.web_springsecurity.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
}
