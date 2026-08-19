package com.rly.springjdbctx.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加 修改 删除
    @Test
    public void testJdbcTemplate() {

        //添加操作
        String sql = "INSERT INTO t_emp VALUES (NULL,?,?,?)";
        int rows = jdbcTemplate.update(sql, "Tom", 18, "M");
        System.out.println(rows);

        //修改操作
        sql = "UPDATE t_emp SET name = ?, age = ?, sex = ? WHERE id = ?";
        int rows2 = jdbcTemplate.update(sql, "Jerry", 20, "M", 1);
        System.out.println(rows2);

        //删除操作
        String sql3 = "DELETE FROM t_emp WHERE id = ?";
        int rows3 = jdbcTemplate.update(sql3, 2);
        System.out.println(rows3);
    }

    //查询返回对象
    @Test
    public void testQueryForObject() {
        //写法一
       /* String sql = "SELECT * FROM t_emp WHERE id = ?";
        Emp empResult = jdbcTemplate.queryForObject(sql, (rs,rowNum)->{
            Emp emp = new Emp();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            return emp;
        },1);
        System.out.println(empResult);*/
        //写法二
        String sql = "SELECT * FROM t_emp WHERE id = ?";
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp);

    }
    //查询返回list集合
    @Test
    public void testSelectList(){
        String sql = "SELECT * FROM t_emp";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(empList);
    }

    //查询单个值
    @Test
    public void testQueryForSingleValue(){
        String sql = "SELECT COUNT(*) FROM t_emp";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }


}
