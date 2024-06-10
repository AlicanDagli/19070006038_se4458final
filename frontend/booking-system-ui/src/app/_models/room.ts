import {Hotel} from "./hotel";

export class Room {
  id!: number;
  checkInDate!: String;
  checkOutDate!: String;
  roomCapacity!: number;
  roomNumber!: number;
  price!: number;
  hotel!: Hotel;
}
