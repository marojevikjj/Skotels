import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelMapComponent } from './hotel-map.component';

describe('HotelMapComponent', () => {
  let component: HotelMapComponent;
  let fixture: ComponentFixture<HotelMapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelMapComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
