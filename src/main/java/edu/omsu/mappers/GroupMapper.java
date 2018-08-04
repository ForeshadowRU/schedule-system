package edu.omsu.mappers;

import edu.omsu.model.Group;
import edu.omsu.model.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class GroupMapper implements RowMapper<Group> {

    private final JdbcTemplate template;

    public GroupMapper(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Group mapRow(ResultSet resultSet, int i) throws SQLException {
        Group group = new Group();
        group.setCode(resultSet.getString("code"));
        group.setNumber(resultSet.getInt("number"));
        group.setFullTime(resultSet.getBoolean("full_time"));
        group.setQuantityPeople(resultSet.getInt("quantity_people"));

        String sql0 = "select map.subject\n" +
                "from map_group_subject map\n" +
                "  join n_groups g\n" +
                "    on g.code = map.code and g.number = map.number and g.full_time = map.full_time\n" +
                "where g.code = ? and g.number = ? and g.full_time = ?";

        template.query(sql0, preparedStatement -> {
            preparedStatement.setString(1, group.getCode());
            preparedStatement.setInt(2, group.getNumber());
            preparedStatement.setBoolean(3, group.isFullTime());
        }, result -> {
            Set<Subject> subjects = new HashSet<>();
            Subject subject = new Subject();
            subject.setName(result.getString("name"));
            subject.setHours(result.getInt("hours"));
            subject.setDifficulty(result.getInt("difficulty"));

            subjects.add(subject);
            return subjects;
        });

        return group;
    }
}
