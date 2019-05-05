package ru.itis.admin;

import java.util.Optional;

public interface AdminService {

    Optional<Admin> getAdminById(Long id);
}
