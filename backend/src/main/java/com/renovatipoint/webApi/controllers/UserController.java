package com.renovatipoint.webApi.controllers;

import com.renovatipoint.business.abstracts.*;
import com.renovatipoint.business.concretes.UserManager;
import com.renovatipoint.business.requests.*;
import com.renovatipoint.business.responses.*;
import com.renovatipoint.security.auth.AuthenticationService;
import com.renovatipoint.business.requests.RegisterRequest;
import com.renovatipoint.security.jwt.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserDetailsService userDetailsServiceImpl;

    private final UserManager userServiceManager;
    private final AuthenticationService service;
    private final JwtService jwtService;

    public UserController(UserService userService, UserDetailsService userDetailsServiceImpl, UserManager userServiceManager, AuthenticationService service, JwtService jwtService) {
        this.userService = userService;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userServiceManager= userServiceManager;
        this.service= service;
        this.jwtService = jwtService;
    }

    @GetMapping
    public List<GetUsersResponse> getAllUsers(){
        return userService.getAll();
    }


    @GetMapping("/{id}")
    public GetUsersByIdResponse getUsersById(@PathVariable int id){
        return userService.getById(id);
    }



    @GetMapping("/response")
    public ResponseEntity<GetUsersResponse> retrieveUserProfileWithResponse(@RequestHeader("Authorization") String authorizationHeader) {
        // Extract the token from the Authorization header (remove "Bearer " prefix)
        String jwt = authorizationHeader.substring(7).trim();

        String email = jwtService.extractUsername(jwt);
        return ResponseEntity.ok(userService.getByEmail(email));
    }


    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request, Principal connectedUser
    ){

        return userServiceManager.changePassword(request, connectedUser);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody RegisterRequest createUserRequest){
        this.userService.add(createUserRequest);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateUserRequest updateUserRequest){
       return this.userServiceManager.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.userService.delete(id);
    }
}
