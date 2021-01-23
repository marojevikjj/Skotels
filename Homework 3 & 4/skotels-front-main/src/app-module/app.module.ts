import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app/app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AboutComponent } from './about/about.component';
import { MapComponent } from './map/map.component';
import { HotelsComponent } from './hotels/hotels.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ModalComponent } from './modal/modal.component';
import { HotelInfoComponent } from './hotel-info/hotel-info.component';
import {HttpClientModule} from '@angular/common/http';
import {ToastrModule} from 'ngx-toastr';
import { AddEditHotelComponent } from './add-edit-hotel/add-edit-hotel.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AgmCoreModule} from '@agm/core';
import { HotelMapComponent } from './hotel-map/hotel-map.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'home', pathMatch: 'full',
  },
  {
    path: 'home', component: HomeComponent,
  },
  {
    path: 'about', component: AboutComponent,
  },
  {
    path: 'map', component: MapComponent,
  },
  {
    path: 'hotels', component: HotelsComponent,
  },
  {
    path: 'login', component: LoginComponent,
  },
  {
    path: 'signup', component: SignupComponent,
  },
  {
    path: 'add-edit', component: AddEditHotelComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    AboutComponent,
    MapComponent,
    HotelsComponent,
    LoginComponent,
    SignupComponent,
    ModalComponent,
    HotelInfoComponent,
    AddEditHotelComponent,
    HotelMapComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    FormsModule,
    Ng2SearchPipeModule,
    BrowserAnimationsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDB4R7MbHUmwlExVnCjwinN4xzzGd4-C14'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
