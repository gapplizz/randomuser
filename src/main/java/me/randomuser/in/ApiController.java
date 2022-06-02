package me.randomuser.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.randomuser.business.user.User;
import me.randomuser.business.user.UserUseCase;

@RestController
@RequestMapping("api")
public class ApiController {
    
    private final UserUseCase userUseCase;

    public ApiController(UserUseCase userUseCase){
        this.userUseCase = userUseCase;
    }

    @GetMapping()
    public User random(@RequestParam(value = "seed", required = false) String seed){
        return userUseCase.randomUser(seed);
    }

}
