package Bright.AuthenticationService.controller;

import Bright.AuthenticationService.entity.AuthenticationResponse;
import Bright.AuthenticationService.entity.Login;
import Bright.AuthenticationService.entity.RegisterRequest;
import Bright.AuthenticationService.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
 //public ResponseEntity<AuthenticationResponse> register(
 public ResponseEntity<String> register(
     @Valid @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
   //return ResponseEntity.ok(service.register(request));

//      publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
//      return new ResponseEntity<>(user, HttpStatus.CREATED);
  }


  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody Login request
  ) {
    return ResponseEntity.ok(service.login(request));
  }





}
