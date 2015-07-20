package com.betime.Managers;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface ITopicManager {

    @Transactional(propagation= Propagation.REQUIRED)
    public boolean deleteById(Integer id);
}
