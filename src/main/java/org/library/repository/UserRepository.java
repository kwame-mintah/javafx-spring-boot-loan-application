package org.library.repository;

import org.library.dto.UserDto;
import org.library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    UserDto findByUsername(final String username);
}
