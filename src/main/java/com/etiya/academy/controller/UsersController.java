package com.etiya.academy.controller;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.user.*;
import com.etiya.academy.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<ListUserResponseDto> getAll() {

        return userService.getAll();
    }

    @PostMapping()
    public ResponseEntity<CreateUserResponseDto> add(@RequestBody @Valid CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto createUserResponseDto = userService.add(createUserRequestDto);

        if (createUserRequestDto != null) {
            return new ResponseEntity<>(createUserResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(createUserResponseDto, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetUserByIdResponseDto> getById(@PathVariable @Valid int id) {
        GetUserByIdResponseDto getUserByIdResponseDto = userService.getById(id);

        if (getUserByIdResponseDto != null) {
            return new ResponseEntity<>(getUserByIdResponseDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(getUserByIdResponseDto, HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<UpdateUserResponseDto> update(@RequestBody @Valid UpdateUserRequestDto updateUserRequestDto) {
        UpdateUserResponseDto userResponseDto = userService.update(updateUserRequestDto);

        if (userResponseDto != null) {
            return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(userResponseDto, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetUserByIdResponseDto deletedUser = userService.getById(id);
        if (deletedUser != null) {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
