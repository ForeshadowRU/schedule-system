package edu.omsu.dao.interfaces;

import edu.omsu.model.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupDao {
    List<Group> get();
    Group get(String code, int number, boolean full_time);
    void save(Group group);
    void update(String code, int number, boolean full_time, Group group);
    void delete(String code, int number, boolean full_time);
}
