package vn.loh.web_springsecurity.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.loh.web_springsecurity.entities.UserInfor;
import vn.loh.web_springsecurity.repositories.UserInforRepository;

@Service
public record UserService(UserInforRepository userInforRepository,
                          PasswordEncoder passwordEncoder) {
    public String addUser(UserInfor userInfor) {
        userInfor.setPassword(passwordEncoder.encode(userInfor.getPassword()));
        userInforRepository.save(userInfor);
        return "User added successfully";
    }
}
