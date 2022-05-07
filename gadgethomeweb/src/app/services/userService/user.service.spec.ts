import { flush, TestBed } from '@angular/core/testing';
import { UserService } from './user.service';

import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { User } from 'src/app/models/user';
import { mockLoginSuccess, mockRegisterSuccess } from 'src/mocks/apiMock';
import { HttpClient } from '@angular/common/http';

describe('UserService', () => {
  let service: UserService;
  let httpClient: HttpClient;
  let httpController: HttpTestingController;

  let url = 'http://localhost:8080/auth';

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    service = TestBed.inject(UserService);
    httpClient = TestBed.inject(HttpClient);
    httpController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpController.verify();
  });

  it('should be created', () => {
    const service: UserService = TestBed.get(UserService);
    expect(service).toBeTruthy();
  });

  it('It should call the register and the api response should be Account created successfully', () => {
    let user = new User("tshiamo", "Tshiamo", "Lephale", "tshiamo.lephale@gmail.com", "0632170392", "password");

    service.register(user).subscribe((response) => {
      expect(response).toEqual(mockRegisterSuccess(user));
    });

    const req = httpController.expectOne({
      method: 'POST',
      url: `${url}/register`,
    });

    req.flush(mockRegisterSuccess(user));
  });

  it('It should call login and the api response should be Logged In', () => {
    let userName:string  = "tshiamo";
    let password:string = "password";

    service.login(userName, password).subscribe((response) => {
      expect(response).toEqual(mockLoginSuccess(userName, password));
    });

    const req = httpController.expectOne({
      method: 'POST',
      url: `${url}/login`,
    });

    req.flush(mockLoginSuccess(userName, password));
  });
});
