package com.db.bexlibrary.BexLibrary.controllers;

import com.db.bexlibrary.BexLibrary.entities.GlobalVariables;
import com.db.bexlibrary.BexLibrary.entities.User;
import com.db.bexlibrary.BexLibrary.entities.UserPOJO;
import com.db.bexlibrary.BexLibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class LoginController{
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> getLogin(@RequestBody UserPOJO userPOJO) {

        User user = userRepository.findUserByEmail(userPOJO.getUserEmail());
        boolean ok=new BCryptPasswordEncoder().matches(userPOJO.getPassword(),user.getPassword());

        if (ok) {
            GlobalVariables.getInstance().setEmail(userPOJO.getUserEmail());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
