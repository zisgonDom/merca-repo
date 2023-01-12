package com.merca.project.mercaproject.repository.role;

import com.merca.project.mercaproject.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
