package vn.loh.web_springsecurity.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
