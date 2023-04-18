package com.bilgeadam.service;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.repository.enums.ERole;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService extends ServiceManager<User,Long> {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public RegisterResponseDto register(RegisterRequestDto dto) {
        User user= IUserMapper.INSTANCE.toUser(dto);
      //  user.setRoles(new HashSet<>());
        user.getRoles().add(ERole.STUDENT);
        save(user);
        return IUserMapper.INSTANCE.toRegisterResponseDto(user);
    }
}
