package edu.omsu.dao.interfaces;

import edu.omsu.model.Classroom;

import java.util.List;
import java.util.UUID;

public interface IClassroomDao {
    List<Classroom> get();
    Classroom get(UUID id);
    void save(Classroom classroom);
    void update(UUID id, Classroom classroom);
    void delete(UUID id);
}
