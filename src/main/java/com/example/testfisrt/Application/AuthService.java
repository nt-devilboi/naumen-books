package com.example.testfisrt.Application;


import com.example.testfisrt.Contollers.RestContoller.Dto.UserSingUp;
import com.example.testfisrt.Infrastructure.ApiResults.ResultAuth;
import com.example.testfisrt.Infrastructure.Repositories.RoleRepository;
import com.example.testfisrt.Infrastructure.Repositories.RoleUserLink;
import com.example.testfisrt.Infrastructure.Repositories.UserRepository;
import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.Infrastructure.Result.Succeed;
import com.example.testfisrt.domain.entities.Account;
import com.example.testfisrt.domain.entities.Role;
import com.example.testfisrt.domain.entities.RoleAccount;
import com.example.testfisrt.infrastucture.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IUserManager {

    @Autowired
    private UserRepository _users;
    @Autowired
    private RoleRepository _roles;
    @Autowired
    private RoleUserLink _roleUserLinks;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Result<Account> GetUserById(Long id) {

            var result = _users.findById(id);
            if (result.isEmpty()) {
                // Возвращаем ошибку, если пользователь не найден
                return new Result<Account>("user not found", "you need authorization. i don't know how you did it"); // вывести отсюда если не будет лень.
            }

            return new Result<>(result.get());
        }


    public Result<Succeed> SingUp(UserSingUp user) { // здесь бы паттерн резалт, а не это всё
        var accountFromData = _users.findByUsername(user.Username);

        if (accountFromData.isPresent())
        {
            return ResultAuth.UserExistedYet;
        }

        var account = Account.From(user, passwordEncoder);
        _users.save(account);

        var result = _roles.findByName("ADMIN");// вот бы это вынести в более приемлемое место в инициализатор при запуске проекта
        if (result.isEmpty()) {
            _roles.save(new Role("ADMIN"));
        }
        var role  = _roles.findByName("ADMIN");

        var roleUser = new RoleAccount();
        roleUser.setRole(role.get());
        roleUser.setAccount(account);

        _roleUserLinks.save(roleUser);

        return ResultAuth.UserCreated;
    }
}
