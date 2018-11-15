package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.dao.UserDocument;
import com.uxpsystems.assignment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Main Controller
 */
@Controller
@RequestMapping("/assignment/")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserDocument> getUser(@PathVariable("userId") long user) {
        LOGGER.debug("Get user entity - {} ", user);
        UserDocument userDocument;
        try {
            userDocument = userService.findById(user);
        }catch(Exception e){
            LOGGER.error("Exception occurred: ",e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userDocument, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity postUser(@RequestBody UserDocument user) {
        LOGGER.debug("Post user entity - {}", user);
        try{
            userService.save(user);
        }catch(Exception e){
            LOGGER.error("Exception occurred: ",e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity putUser(@RequestBody UserDocument user) {
        LOGGER.debug("Put user entity - {}", user);
        try{
            userService.save(user);
        }catch(Exception e){
            LOGGER.error("Exception occurred: ",e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("userId") long user) {
        LOGGER.debug("Delete user entity - {}", user);
        try{
            userService.deleteById(user);
        }catch(Exception e){
            LOGGER.error("Exception occurred: ",e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
