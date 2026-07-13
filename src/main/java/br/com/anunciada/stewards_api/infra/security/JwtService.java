package br.com.anunciada.stewards_api.infra.security;

import br.com.anunciada.stewards_api.infra.persistence.entity.GroupEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtService {

    private static final String SECRET = "stewards-secret-key";

    public String generateToken(GroupEntity group) {
        return JWT.create()
                .withSubject(group.getUsername())
                .withClaim("groupId", group.getId().toString())
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.DAYS))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public String validateToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}
