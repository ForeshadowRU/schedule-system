package edu.omsu.mappers;

import edu.omsu.model.Group;
import edu.omsu.model.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupMapperTest {

    private JdbcTemplate template;

    @Before
    public void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://omsu-projects.mysql.database.azure.com:3306/recruiting-server?useSSL=true&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("jesper@omsu-projects");
        dataSource.setPassword("Iey4waetie6geen");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setSchema("schedule-system");
        template = new JdbcTemplate(dataSource);
    }

    @Test
    public void mapRow() {
        String sql = "SELECT * from `schedule-system`.n_groups g where g.code = 'МПБ' and g.number = '602' and g.full_time = '1'";
        List<Group> query = template.query(sql, new GroupMapper(template));
        Group group = query.get(0);

        Subject[] subjects = new Subject[3];
        for (int i = 0; i < 3; i++) {
            subjects[i] = new Subject();
        }
        subjects[0].setName("Math");
        subjects[0].setHours(144);
        subjects[0].setDifficulty(6);
        subjects[1].setName("Line Algebra");
        subjects[1].setHours(156);
        subjects[1].setDifficulty(4);
        subjects[2].setName("Physical culture");
        subjects[2].setHours(176);
        subjects[2].setDifficulty(1);

        Group test = new Group();
        Set<Subject> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(subjects[i]);
        }
        test.setCode("МПБ");
        test.setNumber(602);
        test.setFullTime(true);
        test.setQuantityPeople(23);
        test.setSubjects(set);

        for (int i = 0; i < 3; i++) {
            System.out.println(group);
            Assert.assertTrue(group.getSubjects().contains(subjects[i]));
        }
        Assert.assertEquals(test, group);
    }
}