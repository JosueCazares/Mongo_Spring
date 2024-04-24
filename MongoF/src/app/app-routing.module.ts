import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './articulo/list.component';
import { DetailComponent } from './articulo/detail.component';
import { CreateComponent } from './articulo/create.component';
import { UpdateComponent } from './articulo/update.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  {path:'',component:ListComponent},
  {path:'detail/:id',component:DetailComponent},
  {path:'create',component:CreateComponent},
  {path:'update/:id',component:UpdateComponent},
  {path:'**',redirectTo:'',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
