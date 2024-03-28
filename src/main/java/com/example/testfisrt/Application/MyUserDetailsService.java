package com.example.testfisrt.Application;

import com.example.testfisrt.Infrastructure.Repositories.RoleRepository;
import com.example.testfisrt.Infrastructure.Repositories.RoleUserLink;
import com.example.testfisrt.Infrastructure.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository users;

    @Autowired
    private RoleRepository roles;

    @Autowired
    private RoleUserLink roleUserLink;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = users.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        var link = roleUserLink.findByAccount(user);
        if (link.isEmpty()){
            throw new UsernameNotFoundException("roles not found");
        }

        var rolesId = link.get().stream().map(x -> x.role).toList();


        return new MyUserDetails(user, rolesId);
    }
}
