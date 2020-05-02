/*
package be.technofuturtic.javaangularapp.config;

import be.technofuturtic.javaangularapp.utilitaires.UtilisateurEntityDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    public static final long JWT_VALIDITY = 3600; //validité du token en secondes (3600 = 1h)

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UtilisateurEntityDto utilisateurEntityDto) {
        Map<String, Object> claims = new HashMap<>();
        return generateTokenAction(claims, utilisateurEntityDto.getEmail());
    }

    private String generateTokenAction(Map<String, Object> claims, String email) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validateToken(String token, UtilisateurEntityDto userDto) {
        String username = getUsernameFromToken(token);
        return (username.equals(userDto.getEmail())) && !isExpireToken(token);
    }

    public Date getIssueAtFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public String getUsernameFromToken(String token) {
        LoggerFactory.getLogger("JwtTokenUtil").debug(token);
        return getClaimFromToken(token, Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
    }

    public boolean isExpireToken(String token) {
        Date expiration = getExpirationFromToken(token);
        return expiration.after(new Date());
    }

    public Date getExpirationFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
}
*/
