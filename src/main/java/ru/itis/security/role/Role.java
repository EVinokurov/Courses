package ru.itis.security.role;

public enum Role {
    ADMIN,
    TEACHER,
    STUDENT;

    public static Role getRoleByOrdinal(int id) {
        return Role.values()[id];
    }
}
