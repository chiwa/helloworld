package com.betime.Managers;

import com.betime.dao.ReplyDAO;
import com.betime.dao.TopicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TopicManager implements ITopicManager {
    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private ReplyDAO replyDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer id) {
        topicDAO.delete(id);
        replyDAO.delete(id);
        return true;
    }
}
