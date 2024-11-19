package vn.loh.web_springsecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.loh.web_springsecurity.entities.UserInfor;
import vn.loh.web_springsecurity.services.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    public String addUser(@RequestBody UserInfor userInfor) {
        return userService.addUser(userInfor);
    }
}
