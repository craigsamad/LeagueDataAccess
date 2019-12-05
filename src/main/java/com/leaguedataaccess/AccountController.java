package com.leaguedataaccess;

import javax.validation.Valid;

import com.leaguedataaccess.authentication.AuthProvider;
import com.leaguedataaccess.authentication.JwtTokenHandler;
import com.leaguedataaccess.authentication.RegistrationResult;
import com.leaguedataaccess.authentication.UnauthorizedException;
import com.leaguedataaccess.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountController {
    @Autowired
    private AuthProvider auth;

    @Autowired
    private JwtTokenHandler tokenHandler;

    @PostMapping("/login")
    public String login(@RequestBody User user) throws UnauthorizedException {
        if(auth.signIn(user.getUsername(), user.getPassword())) {
            User currentUser = auth.getCurrentUser();
            return tokenHandler.createToken(user.getUsername(), currentUser.getRole());
        } else {
            throw new UnauthorizedException();
        }
    }

    @PostMapping("/register")
    public RegistrationResult register(@Valid @RequestBody User user, BindingResult result) {
    	RegistrationResult registrationResult = new RegistrationResult();
    	if(result.hasErrors()) {
            for(ObjectError error : result.getAllErrors()) {
                registrationResult.addError(error.getDefaultMessage());
            }
        }
    	else {
    		auth.register(user.getUsername(), user.getPassword(), user.getRole());
    		registrationResult.setSuccess(true);
    	}
    	return registrationResult;
    }

}