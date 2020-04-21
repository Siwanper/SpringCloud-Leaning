package com.siwanper.authorization.service;

import com.siwanper.authorization.entity.po.User;

public interface IUserService {

    User getUserByUniqueId(String uniqueId);

}
