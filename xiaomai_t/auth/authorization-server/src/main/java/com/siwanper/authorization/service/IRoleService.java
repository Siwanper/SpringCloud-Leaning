package com.siwanper.authorization.service;

import com.siwanper.authorization.entity.po.Role;

import java.util.List;

public interface IRoleService {

    List<Role> getRolesByUserId(String userId);

}
