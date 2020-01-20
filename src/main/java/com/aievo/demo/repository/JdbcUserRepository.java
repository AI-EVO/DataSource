package com.aievo.demo.repository;

import com.aievo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class JdbcUserRepository implements UserRrepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from Users", Integer.class);
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update(
                "insert into Users (Name, Password) values(?,?)",
                user.getName(), user.getPassword().getBytes());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "update Users set Name = ?, Password = ? where id = ?",
                user.getName(), user.getName(), user.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete Users where id = ?",
                id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from Users",
                (rs, rowNum) ->
                        new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                new String(rs.getBytes("password"))
                        )
        );
    }

    @Override
    public List<User> findByName(String name) {
        return jdbcTemplate.query(
                "select * from Users where name like ?",
                new Object[]{"%" + name + "%"},
                (rs, rowNum) ->
                        new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                new String(rs.getBytes("password"))
                        )
        );
    }

    @Override
    public Optional<User> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from Users where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                new String(rs.getBytes("password"))
                        ))
        );
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from Users where id = ?",
                new Object[]{id},
                String.class
        );
    }
}
