package com.example.springboot.service;

import com.example.springboot.domain.IdAndCurrCompany;
import com.example.springboot.domain.Person;
import com.example.springboot.exceptionHandler.DataQueryException;
import com.example.springboot.exceptionHandler.ProjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FirstService {

    static String INSERT_QUERY = "INSERT INTO Persons(name, age, college, curr_company) " +
            "values(?, ?, ?, ?)";
    static String GET_QUERY = "select * from Persons";

    static String UPDATE_QUERY = "UPDATE PERSONS SET curr_company = ? where id = ?";


//    @Qualifier("jdbcFriendsService")
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertPerson(Person user) {
        try {
            return jdbcTemplate.update(INSERT_QUERY, user.getName(), user.getAge(), user.getCollege(), user.getCurr_company());
        } catch(DataAccessException dae) {
            throw new DataQueryException("Data Insertion Failed!", dae.getCause());
        }
    }

    public Optional<List<Person>> userDetails() {
        try {
            List<Map<String, Object>> hmList = jdbcTemplate.queryForList(GET_QUERY);
            List<Person> persons = new ArrayList<>();
            for(Map<String, Object> hm : hmList) {

                Person p = Person.builder()
                        .name((String) hm.get("name"))
                        .age((int) hm.get("age"))
                        .college((String) hm.get("college"))
//                        .curr_company((String) hm.get("curr_company"))
                        .build();

                persons.add(p);
            }
            return Optional.of(persons);

        } catch(Exception ex) {
            ex.getStackTrace();
            System.out.println("Exception Occurred while SQL Data fetch!");
        }
        return Optional.empty();
    }

    public int updateCurrCompanyInPersonsTable(IdAndCurrCompany idAndCurrCompany) {
        try {
            return jdbcTemplate.update(UPDATE_QUERY, idAndCurrCompany.getCurr_company(), idAndCurrCompany.getId());
        } catch(DataAccessException dae) {
            throw new DataQueryException("Data Update Failed!", dae.getCause());
        }
    }

}
