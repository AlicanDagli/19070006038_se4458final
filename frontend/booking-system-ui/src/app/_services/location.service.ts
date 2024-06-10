import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Location} from "../_models/location";

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private axios: AxiosService) { }

  async getLocations(): Promise<Location[]> {
    const resp = await this.axios.request(
      "GET",
      "/api/v1/locations/all",
      {});
    return resp.data;
  }


  async searchLocations(search: string): Promise<Location[]> {
    const resp = await this.axios.request(
      "GET",
      "/api/v1/locations?search=" + search,
      {});
    return resp.data;
  }
}
