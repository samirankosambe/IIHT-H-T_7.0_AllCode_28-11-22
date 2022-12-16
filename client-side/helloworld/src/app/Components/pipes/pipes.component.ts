import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  employee = {
    "name": "Lewis Hammilton",
    "baseSalary": 5500000,
    "joinedOn": Date.now(),
    "qualification": "Btech",
    "about": "Sir Lewis Carl Davidson Hamilton MBE HonFREng is a British racing driver currently competing in Formula One for Mercedes. In Formula One, Hamilton has won a joint-record seven World Drivers' Championship titles, and holds the records for the most wins, pole positions, and podium finishes, among others.",
    "winningPercentage": 35 / 100
  }

  constructor() { }

  ngOnInit(): void {
  }

}
