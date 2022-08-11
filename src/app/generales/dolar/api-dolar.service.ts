import { HttpClient } from '@angular/common/http';
import { EnvironmentInjector, Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ApiDolarService {
  private url: string = environment.dolarApiURL;
  constructor(
    private http: HttpClient
  ) { }

public precioActual(){
  return this.http.get(this.url);
}
}
