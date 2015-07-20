package com.betime.controllers;


import com.betime.services.NameService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    static Logger log = Logger.getLogger(MainController.class);

    @Autowired
    private NameService nameService;

    @RequestMapping(value = "/index.html")
    public String index() {
        return "index";
    }

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;
    /*public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    @Transactional
    @RequestMapping(value = "/hello.html")
    public String hello(Model model, @RequestParam("age") int age) {
        log.debug("=====Hello.html====");
        String name = nameService.getName();
        String message = nameService.getAgeMessage(age);
        model.addAttribute("name" , name);
        model.addAttribute("age", age);
        model.addAttribute("message" , message);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        String SQL = "select * from topics";
        List<Topic> topic = jdbcTemplate.query(SQL,
                new TopicMapper());
        System.out.println("===>> " + topic);
        model.addAttribute("topic", topic);
        return "hello";
    }

    public class TopicMapper implements RowMapper<Topic> {
        public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
            Topic topic = new Topic();
            topic.setId(rs.getInt("id"));
            topic.setName(rs.getString("name"));
            topic.setTopic(rs.getString("topic"));
            topic.setContent(rs.getString("content"));
            return topic;
        }
    }
}
