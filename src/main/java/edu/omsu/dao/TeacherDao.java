package edu.omsu.dao;

import edu.omsu.dao.interfaces.ITeacherDao;
import edu.omsu.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherDao implements ITeacherDao {

    private final JdbcTemplate template;
    private String sql;


    @Autowired
    public TeacherDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Teacher> get() {
        sql = "SELECT * FROM teachers";
        return template.query(sql, new RowMapper<Teacher>() {
            @Override
            public Teacher mapRow(ResultSet resultSet, int i) throws SQLException {
                Teacher teacher = new Teacher();
                teacher.setFirstName(resultSet.getString("firstname"));
                teacher.setSecondName(resultSet.getString("secondname"));
                teacher.setPatronymic(resultSet.getString("patronymic"));
                return teacher;
            }
        });
    }

    @Override
    public Teacher get(UUID id) {
        return null;
    }

    @Override
    public void save(Teacher teacher) {

    }

    @Override
    public void update(UUID id, Teacher teacher) {

    }

    @Override
    public void delete(UUID id) {

    }
}
