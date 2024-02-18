package com.example.springboot.resource;

import com.example.springboot.domain.IdAndCurrCompany;
import com.example.springboot.domain.Person;
import com.example.springboot.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FirstController {

    @Autowired
    FirstService firstService;

    @GetMapping("/stringValue")
    public String getStringValue(HttpServletRequest httpRequest) {
        return "<h1>Hi Amresh!\nWelcome!!</h1>";
    }

    @GetMapping("/squareRoot/{n}")
    public Double getSquareRoot(HttpServletRequest httpRequest,
                                 @PathVariable @NonNull Integer n) {
        System.out.println("Inside getSquareRoot!");

        System.out.println("User: " + httpRequest.getRemoteUser());
        return Math.sqrt(n);
    }

    @PostMapping(value = "/insertUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> insertUser(HttpServletRequest httpRequest, @RequestBody Person user) {
        System.out.println("Inside insertUser!");
        return ResponseEntity.ok().body(firstService.insertPerson(user));
    }

    @GetMapping(value = "/userDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<List<Person>> userDetails(HttpServletRequest httpRequest) {
        System.out.println("Inside userDetails!");

        System.out.println("Remote Host: " + httpRequest.getRemoteHost());
        return firstService.userDetails();
    }

    @PostMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateCurrCompanyInPersonsTable(HttpServletRequest httpRequest,
                                                      @RequestBody IdAndCurrCompany idCurr_company) {
        System.out.println("Inside insertUser!");
        return ResponseEntity.ok().body(firstService.updateCurrCompanyInPersonsTable(idCurr_company));
    }
}
