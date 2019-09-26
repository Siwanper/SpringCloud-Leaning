package com.swp.cloud.authorizationserver.oauth;

import com.swp.cloud.authorizationserver.entity.Role;
import com.swp.cloud.authorizationserver.entity.User;
import com.swp.cloud.authorizationserver.service.impl.RoleService;
import com.swp.cloud.authorizationserver.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-19 3:49 PM
 */
@Service("userDetailsService")
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByUniqueId(username);

        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }
        log.info("load user by username :{}", user.toString());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled() ,
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked() ,
                this.obtainGrantedAuthoritys(user));
    }

    private Set<GrantedAuthority> obtainGrantedAuthoritys(User user) {
        Set<Role> roles = roleService.getRoleByUserId(user.getId());
        log.info("user : {}, roles : {}", user.getUsername(), roles);
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toSet());
    }

}
