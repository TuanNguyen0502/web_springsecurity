package vn.loh.web_springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.loh.web_springsecurity.entities.UserInfor;

import java.util.Optional;

public interface UserInforRepository extends JpaRepository<UserInfor, Long> {
    Optional<UserInfor> findByName(String username);
}
