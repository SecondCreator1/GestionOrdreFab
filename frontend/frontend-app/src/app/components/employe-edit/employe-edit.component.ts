import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeService } from '../../services/employe.service';
import { MachineService } from '../../services/machine.service';

@Component({
  selector: 'app-employe-edit',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './employe-edit.component.html',
  styleUrls: ['./employe-edit.component.css'],
})
export class EmployeEditComponent implements OnInit {
  employeForm: FormGroup;
  employeId!: number;
  machines: any[] = [];

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private employeService: EmployeService,
    private machineService: MachineService
  ) {
    this.employeForm = this.fb.group({
      nom: ['', Validators.required],
      poste: ['', Validators.required],
      machine: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.employeId = +this.route.snapshot.params['id'];
    this.loadMachines();
    this.loadEmploye(this.employeId);
  }

  loadMachines(): void {
    this.machineService.getAllMachines().subscribe(
      (data) => {
        // Assuming each machine has a 'status' field, filter out machines with 'maintenance' status
        this.machines = data.filter((machine: any) => machine.etat !== 'En maintenance');
      },
      (error) => {
        console.error('Error loading machines:', error);
      }
    );
  }
  

  loadEmploye(id: number): void {
    this.employeService.getEmployeById(id).subscribe(
      (employe) => {
        this.employeForm.patchValue({
          nom: employe.nom,
          poste: employe.poste,
          machine: employe.machine?.nom || '' // Set machine ID if available
        });
      },
      (error) => {
        console.error('Error loading employee:', error);
      }
    );
  }

  onSubmit(): void {
    if (this.employeForm.valid) {
      const formValues = this.employeForm.value;
      const updatedEmploye = {
        nom: formValues.nom,
        poste: formValues.poste,
        machineAssignee: {
          id: formValues.machine
        }
      };
  
      this.employeService.updateEmploye(this.employeId, updatedEmploye).subscribe(
        () => {
          alert('Employee updated successfully!');
          this.router.navigate(['/employes']);
        },
        (error) => {
          console.error('Error updating employee:', error);
        }
      );
    }
  }
}
