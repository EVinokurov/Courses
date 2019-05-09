package ru.itis.security;

public enum Role {

    ADMIN,
    TEACHER,
    STUDENT;

    public static Role getRoleByOrdinal(int id) {
        return Role.values()[id];
    }
}
