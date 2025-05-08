import { Routes } from '@angular/router';
import { FournisseurListComponent } from './components/fournisseur-list/fournisseur-list.component';
import { FournisseurFormComponent } from './components/fournisseur-form/fournisseur-form.component';
import { FournisseurEditComponent } from './components/fournisseur-edit/fournisseur-edit.component';
import { ProduitListComponent } from './components/produit-list/produit-list.component';
import { ProduitFormComponent } from './components/produit-form/produit-form.component';
import { ProduitEditComponent } from './components/produit-edit/produit-edit.component';
import { MachineListComponent } from './components/machine-list/machine-list.component';
import { MachineFormComponent } from './components/machine-form/machine-form.component';
import { MachineEditComponent } from './components/machine-edit/machine-edit.component';

export const routes: Routes = [
  { path: '', redirectTo: '/fournisseurs', pathMatch: 'full' },
  { path: 'fournisseurs', component: FournisseurListComponent }, 
  { path: 'fournisseurs/add', component: FournisseurFormComponent } ,
  { path: 'fournisseurs/edit/:id', component: FournisseurEditComponent },
  { path: 'produits', component: ProduitListComponent }, 
  { path: 'produits/add', component: ProduitFormComponent }, 
  { path: 'produits/edit/:id', component: ProduitEditComponent },
  { path: 'machines', component: MachineListComponent},
  { path: 'machines/add', component: MachineFormComponent},
  { path: 'machines/edit/:id', component: MachineEditComponent},

];