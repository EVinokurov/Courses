package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.entities.CourseApply;

public interface CourseApplyRepository extends JpaRepository<CourseApply, Long>{

}
