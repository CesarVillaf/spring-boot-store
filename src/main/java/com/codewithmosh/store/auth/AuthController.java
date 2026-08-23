package com.codewithmosh.store.auth;

import com.codewithmosh.store.common.ErrorDto;
import com.codewithmosh.store.users.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController()
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public JwtResponse login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response
    ) {
        var loginResult = authService.login(request);
        var refreshToken = loginResult.refreshToken().toString();
        var accessToken = loginResult.accessToken().toString();
        var refreshTokenExpiration = loginResult.refreshTokenExpiration();

        var cooke = new Cookie("refreshToken", refreshToken);
        cooke.setHttpOnly(true);
        cooke.setPath("/auth/refresh");
        cooke.setMaxAge(refreshTokenExpiration);
        cooke.setSecure(true);
        response.addCookie(cooke);

        return new JwtResponse(accessToken);
    }

    @PostMapping("/refresh")
    public JwtResponse refreshToken(@CookieValue(value = "refreshToken") String refreshToken) {
        return authService.refreshToken(refreshToken);
    }

    @GetMapping("/me")
    public UserDto me() {
        return authService.me();
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDto> handleBadCredentialsException(Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorDto(ex.getMessage()));
    }

    @ExceptionHandler(CurrentUserNotFound.class)
    public ResponseEntity<ErrorDto> handleCurrentUserNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(ex.getMessage()));
    }
}
