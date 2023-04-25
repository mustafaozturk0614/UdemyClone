package com.bilgeadam.controller;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDto dto){
        return  ResponseEntity.ok(userService.register(dto));
    }


    @GetMapping("/findall")
    public  ResponseEntity<List<User>> findAll(){
        return  ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/addrole/{id}")
    public  ResponseEntity<Boolean> addRole(@PathVariable Long id){
        return  ResponseEntity.ok(userService.addRole(id));
    }

    @PostMapping("/isteacher/{id}")
    public ResponseEntity<Boolean> isTeacher(@PathVariable Long id){

        return  ResponseEntity.ok(userService.isTeacher(id));
    }

}
