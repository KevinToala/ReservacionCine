import { TestBed, inject } from '@angular/core/testing';

import { FuncionService } from './funcion.service';

describe('FuncionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FuncionService]
    });
  });

  it('should be created', inject([FuncionService], (service: FuncionService) => {
    expect(service).toBeTruthy();
  }));
});
