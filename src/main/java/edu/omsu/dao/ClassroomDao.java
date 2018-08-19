package edu.omsu.dao;

import edu.omsu.dao.interfaces.IClassroomDao;
import edu.omsu.mappers.ClassroomMapper;
import edu.omsu.model.Classroom;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class ClassroomDao implements IClassroomDao {

    private final JdbcTemplate template;
    private String sql;

    public ClassroomDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Classroom> get() {
        sql = "select * from `schedule-system`.classroom";
        return template.query(sql, new ClassroomMapper());
    }

    @Override
    public Classroom get(UUID id) {
        sql = "select * from `schedule-system`.classroom where class_number = ?";
        List<Classroom> query = template.query(sql, new ClassroomMapper(), id.toString());
        return (query.isEmpty() ? null : query.get(0));
    }

    @Override
    public void save(Classroom classroom) {
        sql = "insert into `schedule-system`.classroom (class_number, capacity, parameter) " +
                "values (?, ?, ?)";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1,classroom.getNumberClass());
            preparedStatement.setInt(2,classroom.getCapacity());
            preparedStatement.setInt(3,classroom.getParameter());
        });
    }

    @Override
    public void update(UUID id, Classroom classroom) {
        sql = "update `schedule-system`.classroom " +
                "set class_number = ?, capacity = ?, parameter = ? " +
                "where class_number = ?";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, classroom.getNumberClass());
            preparedStatement.setInt(2, classroom.getCapacity());
            preparedStatement.setInt(3, classroom.getParameter());
            preparedStatement.setString(4, id.toString());
        });
    }

    @Override
    public void delete(UUID id) {
        sql = "delete from `schedule-system`.classroom where class_number = ?";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, id.toString());
        });
    }
}
