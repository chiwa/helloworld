package com.betime.controllers;


import com.betime.dao.ReplyDAO;
import com.betime.dao.TopicDAO;
import com.betime.model.Reply;
import com.betime.model.Topic;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    static Logger log = Logger.getLogger(MainController.class);

    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private ReplyDAO replyDAO;

    @RequestMapping(value = "/index.html")
    public String index(Model model) {
        model.addAttribute("topic", topicDAO.listAllTopics());
        return "hello";
    }

    @RequestMapping(value = "/viewtopic.html")
    public String viewTopic(Model model, @RequestParam("id") int id) {
        model.addAttribute("topic", topicDAO.findById(id));
        model.addAttribute("reply", replyDAO.findByTopicId(id));
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

    @RequestMapping(value = "/reply.html", method = RequestMethod.POST)
    public String reply(Model model,
                              @RequestParam("name") String name,
                              @RequestParam(value = "id") Integer id,
                              @RequestParam("comment") String comment
    ) {
        Reply reply = new Reply();
        reply.setName(name);
        reply.setComment(comment);
        reply.setTopicId(id);
        replyDAO.save(reply);
        return "redirect:viewtopic.html?id=" + id;
    }






}
