package com.codecool.teamup.service;

import com.codecool.teamup.model.guild.Guild;
import com.codecool.teamup.model.guild.GuildDTO;
import com.codecool.teamup.model.user.UserEntity;
import com.codecool.teamup.repository.GuildRepository;
import com.codecool.teamup.repository.UserRepository;
import com.codecool.teamup.repository.WeaponRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GuildServiceTest {

    private GuildService guildService;
    private final GuildRepository guildRepository = Mockito.mock(GuildRepository.class);
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final WeaponRepository weaponRepository = Mockito.mock(WeaponRepository.class);

    @BeforeEach
    void setUp() {
        this.guildService = new GuildService(guildRepository, userRepository, weaponRepository);
    }

//    @Test
//    void registerGuildWhenUserExists() {
//        GuildDTO guild = Mockito.mock(GuildDTO.class);
//        UserEntity userEntity = Mockito.mock(UserEntity.class);
//        guildService.registerGuild(1L, guild);
//
//        when(userRepository.findById(userEntity.getId())).thenReturn(Optional.of(userEntity));
//    }
}