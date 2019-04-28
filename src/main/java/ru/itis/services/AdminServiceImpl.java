package ru.itis.services;

import ru.itis.entities.Admin;
import ru.itis.repository.AdminRepository;

import java.util.Optional;

public class AdminServiceImpl implements AdminService {

    static AdminRepository adminRepository;

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public static Admin save(Admin admin) {
        return adminRepository.save(admin);
    }
}
