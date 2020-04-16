package com.siwanper.organization.entity.vo;

import com.siwanper.organization.entity.po.User;
import com.siwanper.web.entity.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Set;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-08 5:21 PM
 */
@Data
@NoArgsConstructor
public class UserVo extends BaseVo<User> {

    public UserVo(User user){
        BeanUtils.copyProperties(user,this);
    }

    private String username;
    private String password;
    private String name;
    private String mobile;
    private String description;
    private String deleted;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    private Set<String> roleIds;

}
