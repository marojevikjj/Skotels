import { TestBed } from '@angular/core/testing';

import { HotelsServiceService } from './hotels-service.service';

describe('HotelsServiceService', () => {
  let service: HotelsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HotelsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
