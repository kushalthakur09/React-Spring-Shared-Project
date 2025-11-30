package com.example.backend.auth.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;
		
		//Check if the header contains Bearer Token
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7); //Remove Bearer
			try {
				username = jwtTokenUtil.extractUsername(token);
			} catch (Exception e) {
				System.out.println("JWT Filter Error: "+e.getMessage());
			}
		}
		
		//Validate Token
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if(jwtTokenUtil.validateToken(token,userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
