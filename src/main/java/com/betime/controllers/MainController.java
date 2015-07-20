package com.betime.controllers;


import com.betime.dao.TopicDAO;
import com.betime.services.NameService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private TopicDAO topicDAO;

    @RequestMapping(value = "/index.html")
    public String index(Model model) {
        model.addAttribute("topic", topicDAO.listAllTopics());
        return "hello";
    }

    @RequestMapping(value = "/viewtopic.html")
    public String viewTopic(Model model, @RequestParam("id") int id) {
        model.addAttribute("topic", topicDAO.findById(id));
        return "viewtopic";
    }

    @RequestMapping(value = "/submittopic.html", method = RequestMethod.POST)
    public String submitTopic(Model model,
                              @RequestParam("name") String name,
                              @RequestParam(value = "topic") String topic,
                              @RequestParam("content") String content
                              ) {
        Topic request = new Topic();
        request.setContent(content);
        request.setTopic(topic);
        request.setName(name);
        topicDAO.save(request);
        return "redirect:index.html";
    }






}
