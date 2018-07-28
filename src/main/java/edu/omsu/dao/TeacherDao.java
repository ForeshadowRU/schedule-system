package edu.omsu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TeacherDao {

    private final JdbcTemplate template;


    @Autowired
    public TeacherDao(JdbcTemplate template) {
        this.template = template;
    }
}
