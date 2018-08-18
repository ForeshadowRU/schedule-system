package edu.omsu.dao;

import edu.omsu.dao.interfaces.ISubjectDao;
import edu.omsu.mappers.SubjectMapper;
import edu.omsu.model.Subject;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class SubjectDao implements ISubjectDao {

    private final JdbcTemplate template;
    private String sql;

    public SubjectDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Subject> get() {
        sql = "select *from `schedule-system`.subjects";
        return template.query(sql, new SubjectMapper());
    }

    @Override
    public Subject get(UUID id) {
        sql = "select * from `schedule-system`.subjects where id = '?'";
        List<Subject> query = template.query(sql, new SubjectMapper(), id.toString());
        return (query.isEmpty() ? null : query.get(0));
    }

    @Override
    public void save(Subject subject) {
        sql = "insert into `schedule-system`.subjects " +
                "(id, name, hours, difficulty)  " +
                "values (?, ?, ?, ?)";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.setInt(3, subject.getHours());
            preparedStatement.setInt(4, subject.getDifficulty());
        });
    }

    @Override
    public void update(UUID id, Subject subject) {
        sql = "update `schedule-system`.subjects " +
                "set name = ?, hours = ?, difficulty = ? " +
                "where id = ?";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getHours());
            preparedStatement.setInt(3, subject.getDifficulty());
            preparedStatement.setString(4, id.toString());
        });
    }

    @Override
    public void delete(UUID id) {
        sql = "delete from `schedule-system`.subjects where id = ?";
        template.update(sql, preparedStatement -> preparedStatement.setString(1, id.toString()));
    }
}
