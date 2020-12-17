import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditHotelComponent } from './add-edit-hotel.component';

describe('AddEditHotelComponent', () => {
  let component: AddEditHotelComponent;
  let fixture: ComponentFixture<AddEditHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditHotelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
