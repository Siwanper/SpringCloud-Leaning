package com.swp.cloud.authorizationserver.service;

import com.swp.cloud.authorizationserver.entity.User;

public interface IUserService {

    User getByUniqueId(String unique);

}
