package com.example.springapp;

import com.example.springapp.models.SalesJDBC;
import com.example.springapp.models.SalesJPA;
import com.example.springapp.repositories.SalesJDBCRepository;
import com.example.springapp.repositories.SalesJPARepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class SpringappApplication {
    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringappApplication.class, args);
        SalesJDBCRepository jdbcRepository = context.getBean(SalesJDBCRepository.class);
        SalesJPARepository jpaRepository = context.getBean(SalesJPARepository.class);
        /*System.out.println("-------adding new row into db-------");
        System.out.println("new SalesJPA(325, new Date(), new Date())");
        jpaRepository.save(new SalesJPA(325, new Date(), new Date()));*/
        System.out.println("---------JDBC---------");
        System.out.println("count: " + jdbcRepository.rowsCount());
        System.out.print("row with id = 1: " );
        System.out.println(jdbcRepository.findByID(1).toString());
        System.out.println("Rows with sum > 100:");
        List<SalesJDBC> findSumMoreThenHundred = jdbcRepository.findSumMoreThenHundred();
        for (SalesJDBC salesJDBC : findSumMoreThenHundred)
            System.out.println(salesJDBC);

        System.out.println("---------JPA---------");
        System.out.println("count: " + jpaRepository.count());
        List<SalesJPA> findByIDJpa = jpaRepository.findById(1);
        System.out.print("row with id = 1: ");
        for (SalesJPA salesJPA : findByIDJpa)
            System.out.println(salesJPA);
        List<SalesJPA> findAllJpa = jpaRepository.findAll();
        System.out.println("Rows with sum > 100:");
        for (SalesJPA salesJPA : findAllJpa)
            if (salesJPA.getSum() > 100)
                System.out.println(salesJPA);
    }
}
