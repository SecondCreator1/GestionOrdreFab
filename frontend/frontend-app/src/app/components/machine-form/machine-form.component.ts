import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { MachineService } from '../../services/machine.service';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-machine-form',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule], // Ensure ReactiveFormsModule is imported
  templateUrl: './machine-form.component.html',
  styleUrls: ['./machine-form.component.css']
})
export class MachineFormComponent {
  machineForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private machineService: MachineService) {
    this.machineForm = this.fb.group({
      nom: ['', Validators.required],
      etat: ['', Validators.required],
      derniereMaintenance: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.machineForm.valid) {
      const newMachine = this.machineForm.value;
      this.machineService.createMachine(newMachine).subscribe(
        () => {
          this.router.navigate(['/machines']);
        },
        (error) => {
          console.error('Error creating machine:', error);
        }
      );
    }
  }

  goBack(): void {
    this.router.navigate(['/machines']);
  }
}