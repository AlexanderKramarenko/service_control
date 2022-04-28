package ru.alexander_kramarenko.service_control_system.configs;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.alexander_kramarenko.service_control_system.utils.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

//        String login = null;
        String username = null;
        String jwt = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            try {
//                login = jwtTokenUtil.getUsernameFromToken(jwt);
                username = jwtTokenUtil.getUsernameFromToken(jwt);
            } catch (ExpiredJwtException e) {
                log.debug("The token is expired");
            }
        }

//        if (login != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, null, jwtTokenUtil.getRoles(jwt).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//            SecurityContextHolder.getContext().setAuthentication(token);
//        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, jwtTokenUtil.getRoles(jwt).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
            SecurityContextHolder.getContext().setAuthentication(token);
        }

        filterChain.doFilter(request, response);
    }


}