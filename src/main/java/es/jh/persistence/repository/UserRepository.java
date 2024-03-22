package es.jh.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jh.persistence.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	
	Optional<UserEntity> findByUsername(String username);
}
