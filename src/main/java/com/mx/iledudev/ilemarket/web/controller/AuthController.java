package com.mx.iledudev.ilemarket.web.controller;

import com.mx.iledudev.ilemarket.domain.model.AutenticationRequest;
import com.mx.iledudev.ilemarket.domain.model.AuthenticationResponse;
import com.mx.iledudev.ilemarket.domain.service.security.IleUserDetails;
import com.mx.iledudev.ilemarket.web.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final IleUserDetails ileUserDetails;

    private final JwtUtils jwtUtils;
    @PostMapping("/authenticate-user")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AutenticationRequest autenticationRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(autenticationRequest.getUsername()
                    , autenticationRequest.getPassword()));
            UserDetails userDetails = ileUserDetails.loadUserByUsername(autenticationRequest.getUsername());
            String jwt = jwtUtils.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt) , HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

}
