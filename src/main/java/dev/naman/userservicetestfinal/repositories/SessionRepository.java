package dev.naman.userservicetestfinal.repositories;

import dev.naman.userservicetestfinal.models.Session;
import dev.naman.userservicetestfinal.models.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Optional<Session> findByTokenAndUser_Id(String token, Long userId);
}
