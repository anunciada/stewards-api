package br.com.anunciada.stewards_api.infra.controller;

import br.com.anunciada.stewards_api.infra.controller.request.LoginRequest;
import br.com.anunciada.stewards_api.infra.controller.response.LoginResponse;
import br.com.anunciada.stewards_api.infra.persistence.entity.GroupEntity;
import br.com.anunciada.stewards_api.infra.persistence.repository.GroupRepository;
import br.com.anunciada.stewards_api.infra.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final GroupRepository repository;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, GroupRepository repository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.username(),
                request.password())
        );
        GroupEntity group = repository
                .findByUsername(request.username())
                .orElseThrow();
        String token = jwtService.generateToken(group);
        return new LoginResponse(token);
    }
}
