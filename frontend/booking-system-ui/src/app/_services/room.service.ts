import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Location} from "../_models/location";
import {Room} from "../_models/room";

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private axios: AxiosService) { }

  async getRooms(): Promise<Room[]> {
    const resp = await this.axios.request(
      "GET",
      "/api/v1/rooms",
      {});
    return resp.data;
  }

  async bookRoom(roomId: number, checkInDate: string, checkOutDate: string): Promise<Room[]> {
    const resp = await this.axios.request(
      "POST",
      "/api/v1/rooms/booking",
      {
        id: roomId,
        checkInDate: checkInDate,
        checkOutDate: checkOutDate
      });
    return resp.data;
  }

  async filterRooms(locationId: number, checkInDate: string, checkOutDate: string, roomCapacity: number): Promise<Room[]> {
    const resp = await this.axios.request(
      "POST",
      "/api/v1/rooms/find",
      {
        locationId,
        checkInDate,
        checkOutDate,
        roomCapacity
      });
    return resp.data;
  }

  async saveRoom(hotelId: number, checkInDate: string, checkOutDate: string, roomCapacity: number, dailyPrice: number, roomNumber: number): Promise<Room[]> {
    const resp = await this.axios.request(
      "POST",
      "/api/v1/rooms",
      {
        checkInDate: checkInDate,
        checkOutDate: checkOutDate,
        roomCapacity: roomCapacity,
        dailyPrice: dailyPrice,
        roomNumber: roomNumber,
        hotelId: hotelId
      });
    return resp.data;
  }
}
