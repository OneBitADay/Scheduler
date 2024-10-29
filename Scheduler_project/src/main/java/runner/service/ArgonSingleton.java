package runner.service;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class ArgonSingleton {
    private static AtomicReference<Argon2PasswordEncoder> INSTANCE = new AtomicReference<>();

    public ArgonSingleton () {
        final Argon2PasswordEncoder previous = INSTANCE.getAndSet(new Argon2PasswordEncoder(64,32,1,12288,3));
        if(previous != null) {
            throw new IllegalStateException("Second singleton " + this + " created after " + previous);
        }
    }

    public static Argon2PasswordEncoder getInstance( ) {
        return INSTANCE.get();
    }
}
