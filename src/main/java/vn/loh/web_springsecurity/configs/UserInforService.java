package vn.loh.web_springsecurity.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.loh.web_springsecurity.entities.UserInfor;
import vn.loh.web_springsecurity.repositories.UserInforRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class UserInforService implements UserDetailsService {
   private final UserInforRepository userInforRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfor> userInfor = userInforRepository.findByName(username);
        return userInfor.map(UserInforUserDetail::new)
                .orElseThrow(() -> new RuntimeException("User not found" + username));
    }
}
