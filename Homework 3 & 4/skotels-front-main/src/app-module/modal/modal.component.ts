import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  @Input() modalTitle: string;
  visible: boolean = false;
  @Input() height: number;
  @Input() width: number;

  constructor() {
    this.modalTitle = 'Modal Title';
    this.height = 300;
    this.width = 500;
  }
  show(): void {
    this.visible = true;
  }

  hide(): void {
    this.visible = false;

  }

  toggle(): void {
    this.visible = !this.visible;
  }

  ngOnInit(): void {
  }

}
