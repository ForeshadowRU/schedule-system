package edu.omsu.dao.interfaces;

import edu.omsu.model.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupDao {
    List<Group> get();
    Group get(UUID id);
    void save(Group group);
    void update(UUID id, Group group);
    void delete(UUID id);
}
