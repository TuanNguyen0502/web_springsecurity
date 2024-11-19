package vn.loh.web_springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.loh.web_springsecurity.entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT u FROM Role u WHERE u.name = :name")
    public Role getUserByName(@Param("name") String name);
    Optional<Role> findByName(String name);
}
