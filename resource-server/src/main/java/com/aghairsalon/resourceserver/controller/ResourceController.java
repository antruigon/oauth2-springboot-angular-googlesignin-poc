package com.aghairsalon.resourceserver.controller;

import com.aghairsalon.resourceserver.dto.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'OIDC_USER')")
    public ResponseEntity<MessageDTO> user(Authentication authentication) {
        return ResponseEntity.ok(new MessageDTO("Hola " + authentication.getName()));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MessageDTO> admin(Authentication authentication) {
        return ResponseEntity.ok(new MessageDTO("Hola Mr." + authentication.getName()));
    }

}
