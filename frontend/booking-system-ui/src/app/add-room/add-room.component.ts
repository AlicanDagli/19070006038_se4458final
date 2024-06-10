import { Component } from '@angular/core';
import {HotelService} from "../_services/hotel.service";
import {Hotel} from "../_models/hotel";
import {RoomService} from "../_services/room.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrl: './add-room.component.css'
})
export class AddRoomComponent {

  hotels!: Hotel[];
  hotel!: Hotel;
  checkInDate!: string;
  checkOutDate!: string;
  roomCapacity!: number;
  roomNumber!: number;
  dailyPrice!: number;

  constructor(private hotelService: HotelService, private roomService: RoomService) { }

  ngOnInit() {
    this.hotelService.getHotels()
      .then(hotels => {
        this.hotels = hotels;
      })
  }

  onSelectHotel(hotel: Hotel) {
    this.hotel = hotel;
  }

  onSelectRoomCapacity($event: any) {
    this.roomCapacity = Number($event.target.value.split(" ")[0]);
  }

  saveRoom() {
    this.roomService.saveRoom(this.hotel.id, this.checkInDate, this.checkOutDate, this.roomCapacity, +this.dailyPrice, +this.roomNumber)
      .then(response => {
        this.successAlert();
      })
  }

  successAlert() {
    Swal.fire({
      title: "İşlem Başarılı",
      html: "Oda Kayıt Işlemi Gerçekleştirildi",
      icon: 'success',
    })
  }
}
