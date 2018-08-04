package edu.omsu.mappers;

import edu.omsu.model.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet resultSet, int i) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setFirstName(resultSet.getString("firstname"));
        teacher.setSecondName(resultSet.getString("secondname"));
        teacher.setPatronymic(resultSet.getString("patronymic"));
        return teacher;
    }
}
