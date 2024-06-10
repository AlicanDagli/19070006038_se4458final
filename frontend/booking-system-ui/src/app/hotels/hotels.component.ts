import { Component } from '@angular/core';
import {RoomService} from "../_services/room.service";
import {Room} from "../_models/room";
import {LocationService} from "../_services/location.service";
import {Location} from "../_models/location";
import Swal from "sweetalert2";

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrl: './hotels.component.css'
})
export class HotelsComponent {

  rooms!: Room[];
  locations!: Location[];
  searchTerm: string = '';
  checkInDate!: string;
  checkOutDate!: string;
  selectedLocation!: Location;
  roomCapacity!: number;
  loggedIn: boolean = false;

  constructor(private roomService: RoomService, private locationService: LocationService) { }

  ngOnInit() {
    this.roomService.getRooms()
      .then(rooms => {
        this.rooms = rooms;
      })
    this.locationService.getLocations()
      .then(locations => {
        this.locations = locations;
      })

    if (window.localStorage.getItem("auth_token") !== null) {
      this.loggedIn = true;
    }
  }

  filterOptions() {
    this.locationService.searchLocations(this.searchTerm)
      .then(locations => {
        this.locations = locations;
      })
  }

  onSelectRoomCapacity($event: any) {
    this.roomCapacity = Number($event.target.value.split(" ")[0]);
  }

  selectLocation(location: Location) {
    this.selectedLocation = location;
    this.searchTerm = location.country + ", " + location.city + ", " + location.district;
  }

  booking(id: number, split: string, string: string) {
    if (window.localStorage.getItem("auth_token") !== null) {
      this.roomService.bookRoom(id, split, string)
        .then(response => {
          this.successAlert();
        })
    } else {
      this.errorAlert();
    }
  }

  successAlert() {
    Swal.fire({
      title: "İşlem Başarılı",
      html: "Rezarvasyon Kayıt Edildi.",
      icon: 'success',
    });
  }

  errorAlert() {
    Swal.fire({
      title: "Giriş Yapılamadı",
      html: "Rezervasyon yapabilmek için oturum açmanız gerekmektedir...",
      icon: 'error',
    });
  }

  search() {
      this.roomService.filterRooms(this.selectedLocation.id, this.checkInDate, this.checkOutDate, this.roomCapacity)
        .then(rooms => {
          this.rooms = rooms;
        })
  }
}
