package com.example.demo.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter extends OncePerRequestFilter {

    private static final String VALID_TOKEN = "ABC123";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();

        // Only enforce custom Token validation on /api/tourists
        if (path.startsWith("/api/tourists")) {
            String token = request.getHeader("Token");
            if (token == null || !VALID_TOKEN.equals(token)) {
                throw new RuntimeException("Unauthorized : Invalid Token Provided");
            }
        }

        filterChain.doFilter(request, response);
    }
}
