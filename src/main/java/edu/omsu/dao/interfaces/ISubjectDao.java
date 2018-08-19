package edu.omsu.dao.interfaces;

import edu.omsu.model.Subject;

import java.util.List;
import java.util.UUID;

public interface ISubjectDao {
    List<Subject> get();
    Subject get(UUID id);
    void save(Subject subject);
    void update(UUID id, Subject subject);
    void delete(UUID id);
}
