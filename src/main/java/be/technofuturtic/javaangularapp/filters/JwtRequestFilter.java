/*
package be.technofuturtic.javaangularapp.filters;
import be.technofuturtic.javaangularapp.config.JwtTokenUtil;
import be.technofuturtic.javaangularapp.services.UtilisateurService;
import be.technofuturtic.javaangularapp.utilitaires.UtilisateurEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private UtilisateurService utilisateurService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public JwtRequestFilter(UtilisateurService utilisateurService, JwtTokenUtil jwtTokenUtil) {
        this.utilisateurService = utilisateurService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorisationHeader = request.getHeader("Authorization");
        String email = null;
        String jwtToken = null;
        if (authorisationHeader != null && authorisationHeader.startsWith("Bearer ")) {
            jwtToken = authorisationHeader.substring(7);
            email = this.jwtTokenUtil.getUsernameFromToken(jwtToken);
        }
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.utilisateurService.loadUserByUsername(email);
            if (jwtTokenUtil.validateToken(jwtToken, (UtilisateurEntityDto) userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
*/
