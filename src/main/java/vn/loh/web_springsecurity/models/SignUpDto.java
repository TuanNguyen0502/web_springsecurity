package vn.loh.web_springsecurity.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
}
