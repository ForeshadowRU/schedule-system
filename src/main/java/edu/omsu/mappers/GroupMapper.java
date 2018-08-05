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

        String sql =
                "select map.subject, s.name, s.hours, s.difficulty\n" +
                        "from `schedule-system`.map_group_subject map\n" +
                        "  join `schedule-system`.n_groups g\n" +
                        "   join `schedule-system`.subjects s\n" +
                        "    on s.id = map.subject and g.code = map.code and " +
                        "       g.number = map.number and g.full_time = map.full_time\n" +
                        "where g.code = ? and g.number = ? and g.full_time = ?";

        Set<Subject> query = template.query(sql, preparedStatement -> {
            preparedStatement.setString(1, group.getCode());
            preparedStatement.setInt(2, group.getNumber());
            preparedStatement.setBoolean(3, group.isFullTime());
        }, result -> {
            Set<Subject> subjects = new HashSet<>();
            while (result.next()) {
                Subject subject = new Subject();
                subject.setName(result.getString("name"));
                subject.setHours(result.getInt("hours"));
                subject.setDifficulty(result.getInt("difficulty"));

                subjects.add(subject);
            }
            return subjects;
        });
        group.setSubjects(query);
        return group;
    }
}
