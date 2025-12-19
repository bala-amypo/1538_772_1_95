@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        User user = userRepository.findByEmail(req.getEmail()).orElseThrow();
        String token = jwtProvider.generateToken(user);
        return new AuthResponse(token);
    }
}
