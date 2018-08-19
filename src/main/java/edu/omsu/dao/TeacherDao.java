package edu.omsu.dao;


import edu.omsu.dao.interfaces.ITeacherDao;
import edu.omsu.mappers.TeacherMapper;
import edu.omsu.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
        sql = "SELECT * FROM `schedule-system`.teachers";
        return template.query(sql, new TeacherMapper());
    }

    @Override
    public Teacher get(UUID id) {
        sql = "SELECT * FROM `schedule-system`.teachers where id = ?";
        List<Teacher> query = template.query(sql, new TeacherMapper(), id.toString());
        return (query.isEmpty()) ? null : query.get(0);
    }

    @Override
    public void save(Teacher teacher) {
        sql = "insert into `schedule-system`.teachers (firstname, secondname, patronymic, id)\n" +
                "values (?, ?, ?, ?)";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, teacher.getFirstName());
            preparedStatement.setString(2, teacher.getSecondName());
            preparedStatement.setString(3, teacher.getPatronymic());
            preparedStatement.setString(4, UUID.randomUUID().toString());
        });
    }

    @Override
    public void update(UUID id, Teacher teacher) {
        sql = "update `schedule-system`.teachers " +
                "set firstname = ?, secondname = ?, patronymic = ? " +
                "where id = ?";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, teacher.getFirstName());
            preparedStatement.setString(2, teacher.getSecondName());
            preparedStatement.setString(3, teacher.getPatronymic());
            preparedStatement.setString(4, id.toString());
        });
    }

    @Override
    public void delete(UUID id) {
        sql = "delete from `schedule-system`.teachers where id = ?";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, id.toString());
        });
    }
}
