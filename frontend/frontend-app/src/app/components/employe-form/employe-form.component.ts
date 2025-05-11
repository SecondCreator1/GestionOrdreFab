import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmployeService } from '../../services/employe.service';
import { MachineService } from '../../services/machine.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employe-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './employe-form.component.html',
  styleUrls: ['./employe-form.component.css'],
})
export class EmployeFormComponent implements OnInit {
  employeForm: FormGroup;
  machines: any[] = [];

  constructor(
    private fb: FormBuilder,
    private employeService: EmployeService,
    private machineService: MachineService,
    private router: Router
  ) {
    this.employeForm = this.fb.group({
      nom: ['', Validators.required],
      poste: ['', Validators.required],
      machine: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.loadMachines();  // Load available machines (not in maintenance)
  }

  loadMachines(): void {
    this.machineService.getAllMachines().subscribe(
      (data) => {
        // Filter machines that are not in maintenance (status !== 'maintenance')
        this.machines = data.filter((machine: any) => machine.etat !== 'En maintenance');
      },
      (error) => {
        console.error('Error loading machines:', error);
      }
    );
  }
  

  onSubmit(): void {
    if (this.employeForm.valid) {
      const formValue = this.employeForm.value;
      const newEmploye = {
        nom: formValue.nom,
        poste: formValue.poste,
        machineAssignee: { id: formValue.machine }
      };
      this.employeService.createEmploye(newEmploye).subscribe(
        () => {
          alert('Employee created successfully!');
          this.router.navigate(['/employes']);
        },
        (error) => {
          console.error('Error creating employee:', error);
        }
      );
    }
  }
}
