package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
