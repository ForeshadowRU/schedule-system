package edu.omsu.mappers;

import edu.omsu.model.Classroom;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassroomMapper implements RowMapper<Classroom> {
    @Override
    public Classroom mapRow(ResultSet resultSet, int i) throws SQLException {
        Classroom classroom = new Classroom();
        classroom.setNumberClass(resultSet.getString("class_number"));
        classroom.setCapacity(resultSet.getInt("capacity"));
        classroom.setParameter(resultSet.getInt("parameter"));
        return classroom;
    }
}
