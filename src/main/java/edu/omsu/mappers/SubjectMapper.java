package edu.omsu.mappers;

import edu.omsu.model.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements RowMapper<Subject> {

    @Override
    public Subject mapRow(ResultSet resultSet, int i) throws SQLException {
        Subject subject = new Subject();
        subject.setName(resultSet.getString("name"));
        subject.setHours(resultSet.getInt("hours"));
        subject.setDifficulty(resultSet.getInt("difficulty"));
        return subject;
    }
}