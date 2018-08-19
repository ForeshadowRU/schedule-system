package edu.omsu.dao.interfaces;

import edu.omsu.model.Teacher;

import java.util.List;
import java.util.UUID;

public interface ITeacherDao {
    List<Teacher> get();
    Teacher get(UUID id);
    void save(Teacher teacher);
    void update(UUID id, Teacher teacher);
    void delete(UUID id);
}
