package com.sgg.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgg.admin.bean.User;
import com.sgg.admin.mapper.UserMapper;
import com.sgg.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author huangruiqing
 * @Description
 * @date 2022-10-14 16:58
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
