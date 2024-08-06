package com.team4.team4.user;

import com.team4.team4.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.File;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password, String bio, String contactNumber, String socialMediaHandles) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setBio(bio);
        user.setContactNumber(contactNumber);
        user.setSocialMediaHandles(socialMediaHandles);
        this.userRepository.save(user);
        return user;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if(siteUser.isPresent()) {
            return siteUser.get();
        }
        else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

    public void modify(SiteUser siteUser, String bio, String contactNumber, String socialMediaHandle) {
        siteUser.setBio(bio);
        siteUser.setContactNumber(contactNumber);
        siteUser.setSocialMediaHandles(socialMediaHandle);
        this.userRepository.save(siteUser);
    }
}