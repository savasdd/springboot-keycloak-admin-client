import { TestBed } from '@angular/core/testing';

import { PysService } from './pys.service';

describe('PysService', () => {
  let service: PysService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PysService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
