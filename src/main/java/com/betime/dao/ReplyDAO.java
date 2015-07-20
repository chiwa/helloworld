package com.betime.dao;

import com.betime.model.Reply;
import com.betime.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ReplyDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(Reply reply) {
        String sql = "INSERT INTO reply (name, comment, topic_id) values (?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{reply.getName(), reply.getComment(), reply.getTopicId() });
    }

    public List<Reply> findByTopicId(Integer topicId) {
        String sql = "SELECT * FROM reply WHERE topic_id = ?";
        List<Reply> result  =  jdbcTemplate.query(sql, new ReplyMapper(), new Object[]{topicId});
        return result;
    }


    private class ReplyMapper implements org.springframework.jdbc.core.RowMapper<Reply> {
        public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reply reply = new Reply();
            reply.setId(rs.getInt("id"));
            reply.setName(rs.getString("name"));
            reply.setComment(rs.getString("comment"));
            return reply;
        }
    }
}
