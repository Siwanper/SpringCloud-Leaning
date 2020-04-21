package com.siwanper.authorization.oauth2;

import com.siwanper.authorization.entity.po.Role;
import com.siwanper.authorization.entity.po.User;
import com.siwanper.authorization.service.IRoleService;
import com.siwanper.authorization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 * 自定义用户详情
 *
 * @outhor ios
 * @create 2020-04-21 4:34 PM
 */
@Service(value = "customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String uniqueId) throws UsernameNotFoundException {
        User user = userService.getUserByUniqueId(uniqueId);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                this.authorities(user.getId()));
    }

    private List<GrantedAuthority> authorities(String userId){
        List<Role> roles = roleService.getRolesByUserId(userId);
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());
    }

}
