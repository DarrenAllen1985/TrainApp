package com.darren.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security/roles")
public class RoleController {

    @PostMapping("/create/{role}")
    public ResponseEntity create(@PathVariable String role){
        return ResponseEntity.ok("Role created: " + role);
    }

    @GetMapping("getall")
    public ResponseEntity getall(){
        return ResponseEntity.ok("Dampies is EMOTIONAL");
    }
}
