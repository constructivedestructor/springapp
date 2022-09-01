package com.example.springapp.repositories;

import com.example.springapp.models.SalesJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesJDBCRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesJDBCRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int rowsCount(){
        return jdbcTemplate.queryForObject("select count(*) from sales", Integer.class);
    }

    public SalesJDBC findByID(int id){
        SalesJDBC finded = new SalesJDBC();
        List<SalesJDBC> list = jdbcTemplate.query(
                "select * from sales where id = ?", new Object[] {id},
                new RowMapper<SalesJDBC>(){
                    @Override
                    public SalesJDBC mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new SalesJDBC(rs.getInt("id"), rs.getFloat("sum"),
                                rs.getDate("date_income"), rs.getDate("date_sale"));
                    }
                }
        );
        for (SalesJDBC salesJDBC : list)
            finded = salesJDBC;
        return finded;
    }

    public List<SalesJDBC> findSumMoreThenHundred(){
        return jdbcTemplate.query("select * from sales where sum > 100", (rs, rowNum) ->
                new SalesJDBC(rs.getInt("id"), rs.getFloat("sum"),
                        rs.getDate("date_income"), rs.getDate("date_sale")));
    }

}
