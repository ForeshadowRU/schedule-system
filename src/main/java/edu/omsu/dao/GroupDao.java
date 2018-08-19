package edu.omsu.dao;

import edu.omsu.dao.interfaces.IGroupDao;
import edu.omsu.mappers.GroupMapper;
import edu.omsu.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class GroupDao implements IGroupDao {

    private final JdbcTemplate template;
    private String sql;

    public GroupDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Group> get() {
        sql = "SELECT * FROM `schedule-system`.n_groups";
        return template.query(sql, new GroupMapper(template));
    }

    @Override
    public Group get(String code, int number, boolean full_time) {
        sql = "SELECT * FROM `schedule-system`.n_groups " +
                "where code = ? and number = ? and full_time = ?";
        List<Group> query = template.query(sql, new GroupMapper(template), code, number, full_time);
        return (query.isEmpty() ? null : query.get(0));
    }

    @Override
    public void save(Group group) {
        sql = "insert into `schedule-system`.n_groups (code, number, full_time, quantity_people)\n" +
                "values (?, ?, ?, ?);";// +
                //"insert into `schedule-system`.";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, group.getCode());
            preparedStatement.setInt(2, group.getNumber());
            preparedStatement.setBoolean(3, group.isFullTime());
            preparedStatement.setInt(4, group.getQuantityPeople());
        });
    }

    @Override
    public void update(String code, int number, boolean full_time, Group group) {

    }

    @Override
    public void delete(String code, int number, boolean full_time) {

    }
}
