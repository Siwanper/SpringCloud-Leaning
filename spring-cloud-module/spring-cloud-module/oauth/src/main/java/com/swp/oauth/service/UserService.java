package com.swp.oauth.service;

import com.swp.oauth.model.Authority;
import com.swp.oauth.model.User;
import com.swp.oauth.repository.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-30 11:07 AM
 */
@Component("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJPA.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("User Not Found");
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : user.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
