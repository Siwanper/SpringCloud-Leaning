package com.siwanper.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.organization.dao.UserRoleMapper;
import com.siwanper.organization.entity.po.UserRole;
import com.siwanper.organization.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述:
 * 用户和角色关系服务
 *
 * @outhor ios
 * @create 2020-04-16 2:56 PM
 */
@Service
@Slf4j
public class UserRoleService extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Transactional
    @Override
    public boolean saveBatch(String userId, Set<String> roles) {
        if (CollectionUtils.isEmpty(roles)) {
            return false;
        }
        // 删除之前保存的数据
        deleteByUserId(userId);
        Set<UserRole> userRoles = roles.stream().map(roleId -> new UserRole(userId, roleId)).collect(Collectors.toSet());
        return this.saveBatch(userRoles);
    }

    @Transactional
    @Override
    public boolean deleteByUserId(String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        return this.remove(queryWrapper);
    }

    @Transactional
    @Override
    public boolean deleteByRoleId(String roleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        return this.remove(queryWrapper);
    }

    @Override
    public Set<String> queryRoleIdsByUserId(String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        List<UserRole> userRoles = this.list(queryWrapper);
        Set<String> roleIs = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toSet());
        return roleIs;
    }
}
