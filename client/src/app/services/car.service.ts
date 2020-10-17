import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Car } from '../models/Car'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  carsUrl: string = 'http://localhost:8762/api/cars/'

  constructor(private http: HttpClient) {}

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(this.carsUrl);
  }
   
}

