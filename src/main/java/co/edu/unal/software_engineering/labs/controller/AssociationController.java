package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.model.Association;
import co.edu.unal.software_engineering.labs.model.User;
import co.edu.unal.software_engineering.labs.pojo.EnrolledCoursePOJO;
import co.edu.unal.software_engineering.labs.pojo.LoginUserPOJO;
import co.edu.unal.software_engineering.labs.service.AssociationService;
import co.edu.unal.software_engineering.labs.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssociationController {
    private final AssociationService associationService;
    private final UserService userService;

    public AssociationController(AssociationService associationService, UserService userService) {
        this.associationService = associationService;
        this.userService = userService;
    }

    @GetMapping("/mipapel")
    public List<Association> getCoursesByUser(){
        String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
        User user = userService.findByUsername( username );
        List<Association> associations = associationService.getAssociationsByUser( user );
        return associations;
        /*List<EnrolledCoursePOJO> enrolledCourses = new ArrayList<>( );
        for( Association association : associations ){
            enrolledCourses.add( new EnrolledCoursePOJO( association ) );
        }
        return enrolledCourses;*/
    }

}
