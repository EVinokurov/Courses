package ru.itis.services;

import ru.itis.entities.Admin;

import java.util.Optional;

public interface AdminService {
    Optional<Admin> getAdminById(Long id);
}
