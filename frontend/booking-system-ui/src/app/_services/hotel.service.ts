import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Location} from "../_models/location";
import {Hotel} from "../_models/hotel";

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private axios: AxiosService) { }

  async getHotels(): Promise<Hotel[]> {
    const resp = await this.axios.request(
      "GET",
      "/api/v1/hotels",
      {});
    return resp.data;
  }
}
