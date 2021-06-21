package com.kfy.multipledatasource.dynamicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/read")
    @MultipleDataSource(value = DataSourceType.READ)
    public List<Map<String, Object>> local(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        return maps;
    }

    @GetMapping("/write")
    @MultipleDataSource(value = DataSourceType.WRITE)
    public List<Map<String, Object>> remote(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        return maps;
    }
    @GetMapping("/default")
    public List<Map<String, Object>> defaultGet(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        return maps;
    }

}
