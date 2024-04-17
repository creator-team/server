package com.openpms.server.users;

import com.openpms.server.users.dto.CreateParam;
import com.openpms.server.users.dto.UpdateParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UserMapper userMapper;

    public User findById(Long id) {
        return userMapper.findById(id);
    }

    public Long create(CreateParam param) {
        User user = new User();
        user.setEmail(param.getEmail());
        Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        user.setPassword(encoder.encode(param.getPassword()));
        user.setName(param.getName());
        user.setAvatar(param.getAvatar());
        return this.userMapper.create(user);
    }

    public int updateById(Long id, UpdateParam param) {
        User user = new User();
        user.setId(id);
        user.setEmail(param.getEmail());
        user.setName(param.getName());
        user.setAvatar(param.getAvatar());
        user.setStatus(param.getStatus());
        return this.userMapper.updateById(user);
    }

    public int deleteById(Long id) {
        return this.userMapper.deleteById(id);
    }
}
