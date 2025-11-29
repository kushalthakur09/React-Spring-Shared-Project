package com.example.backend.auth.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.backend.auth.entity.UserEntity;

public class UserPrincple implements UserDetails {

private UserEntity user;
	
	public UserPrincple(UserEntity user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(user.getRoleEntity().getName())) ; //COllection with single object
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;// by default for testing true
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;// by default for testing true
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;// by default for testing true
	}

	@Override
	public boolean isEnabled() {
		return true; // by default for testing true
	}


}
