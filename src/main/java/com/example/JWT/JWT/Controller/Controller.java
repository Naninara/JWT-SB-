package com.example.JWT.JWT.Controller;

import com.example.JWT.JWT.JWT.Util;
import com.example.JWT.JWT.JwtApplication;
import com.example.JWT.JWT.Model.AuthenticationRequest;
import com.example.JWT.JWT.Model.AuthenticationResponse;
import com.example.JWT.JWT.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Util jwtTokenUtil;

    @Autowired
    private UserService userService;

    @GetMapping("/visit")
    public String student() {
        return "access by every one no worries";
    }

    @GetMapping(value = "/user" )
    public String firstPage(HttpServletRequest request) {
//        System.out.println(request.getHeader("Authorization"));
//        System.out.println(request.getCookies());
//        System.out.println(request.getAuthType());
        return "Hello Users";
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest request) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
            );

        }

        catch (BadCredentialsException e){
            throw new Exception("Bad credicials",e);
        }

        final UserDetails details =userService.loadUserByUsername(request.getUsername());
        final String jwt = jwtTokenUtil.generateToken(details);
        return new AuthenticationResponse(jwt);
    }
}
