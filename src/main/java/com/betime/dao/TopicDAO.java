package com.betime.dao;

import com.betime.controllers.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class TopicDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Topic> listAllTopics() {
        String SQL = "select * from topics";
        List<Topic> topic = jdbcTemplate.query(SQL,
                new TopicMapper());
        return topic;
    }

    public Topic findById(Integer id) {
        try {
            String sql = "SELECT * FROM topics WHERE id = ?";
            Topic result  =  jdbcTemplate.queryForObject(sql, new TopicMapper(), new Object[]{id});
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       return null;
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
