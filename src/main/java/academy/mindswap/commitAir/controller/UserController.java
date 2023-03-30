package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.UserCreateDto;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = this.userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = this.userService.getAllUsers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserCreateDto userCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }

        UserDto updatedUser = userService.updateUser(id, userCreateDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-role/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDto> updateRole(@PathVariable Long id/*, BindingResult bindingResult*/) {
        /*if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }*/
        userService.updateRole(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
