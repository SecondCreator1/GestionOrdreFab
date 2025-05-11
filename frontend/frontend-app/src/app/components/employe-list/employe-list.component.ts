import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { EmployeService } from '../../services/employe.service';

@Component({
  selector: 'app-employe-list',
  imports: [CommonModule, RouterModule],
  templateUrl: './employe-list.component.html',
  styleUrls: ['./employe-list.component.css'],
})
export class EmployeListComponent implements OnInit {
  employes: any[] = [];

  constructor(private employeService: EmployeService) {}

  ngOnInit(): void {
    this.loadEmployes();
  }

  loadEmployes(): void {
    this.employeService.getAllEmployes().subscribe(
      (data) => {
        this.employes = data;
      },
      (error) => {
        console.error('Error fetching employes:', error);
      }
    );
  }

  deleteEmploye(id: number): void {
    if (confirm('Are you sure you want to delete this employee?')) {
      this.employeService.deleteEmploye(id).subscribe(
        () => {
          this.loadEmployes(); // Refresh the list after deletion
        },
        (error) => {
          console.error('Error deleting employee:', error);
        }
      );
    }
  }
}