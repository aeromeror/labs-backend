package co.edu.unal.software_engineering.labs.repository;

import co.edu.unal.software_engineering.labs.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRole.UserRolePK> {
}
