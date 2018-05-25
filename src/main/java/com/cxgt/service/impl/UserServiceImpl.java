package com.cxgt.service.impl;

import com.cxgt.entity.User;
import com.cxgt.mapper.UserMapper;
import com.cxgt.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
}
