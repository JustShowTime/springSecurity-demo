package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

/**
 * @author czq
 * @Date 2020-06-19 16:10:39
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userMapper.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
//		String password=user.getPassword();
//		user.setPassword(password.substring(6, password.length()));

		user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
		return user;
	}
	
	private List<GrantedAuthority> generateAuthorities(String roles){
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		String[] roleArray=roles.split(";");
		
		if(roles!=null && !"".equals(roles)) {
			for(String role:roleArray) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
		}
		
		return authorities;
	}

}
