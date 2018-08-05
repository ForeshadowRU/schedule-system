package edu.omsu.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TeacherDaoTest {
    private JdbcTemplate template;

    @Before
    public void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("spring.datasource.url");
        dataSource.setUsername("spring.datasource.username");
        dataSource.setPassword("spring.datasource.password");
        template = new JdbcTemplate(dataSource);
    }

    @Test
    public void get() {
    }

    @Test
    public void get1() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}