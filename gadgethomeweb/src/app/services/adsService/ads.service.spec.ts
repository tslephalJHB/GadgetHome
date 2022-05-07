import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { mockGetAdsSuccess } from 'src/mocks/apiMock';

import { AdsService } from './ads.service';

describe('AdsService', () => {
  let service: AdsService;
  let httpClient: HttpClient;
  let httpController: HttpTestingController;

  let url = 'http://localhost:8080/ads';

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    service = TestBed.inject(AdsService);
    httpClient = TestBed.inject(HttpClient);
    httpController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('It should call getAds and the api response should be a list of Ads', () => {

    service.getAllAds().subscribe((response) => {
      expect(response).toEqual(mockGetAdsSuccess());
    });

    const req = httpController.expectOne({
      method: 'GET',
      url: `${url}/posts`,
    });

    req.flush(mockGetAdsSuccess());
  });
});
