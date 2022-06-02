package me.randomuser.business.user;

import java.util.Objects;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.randomuser.out.user.UserInterface;
import me.randomuser.out.user.UserRepository;

@Service
public class UserService implements UserUseCase{

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User randomUser(String seed) {
        seed = validateSeed(seed);
        String seedInNumberFormat = formatSeedAsNumber(seed);
        Random random = createRandomFromSeed(seedInNumberFormat);
        int id = random.nextInt(1000);
        UserInterface userInterface = userRepository.get(id);

        return new User(userInterface.getName(), userInterface.getGender(), userInterface.getAddress());
    }

    private String validateSeed(String seed){
        return Objects.requireNonNullElseGet(seed, () -> "");
    }

    private String formatSeedAsNumber(String seed){
        StringBuilder seedInNumberFormat = new StringBuilder();
        for(int i=0; i<seed.length(); i++){
            seedInNumberFormat.append(Character.getNumericValue(seed.charAt(i)));
        }

        return seedInNumberFormat.toString();
    }

    private Random createRandomFromSeed(String seed){
        if(seed.isBlank()){
            return new Random();
        }

        return new Random(Long.valueOf(seed));
    }
    
}
