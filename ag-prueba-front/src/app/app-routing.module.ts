import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AuthorizedComponent } from "./components/authorized/authorized.component";
import { HomeComponent } from "./components/home/home.component";

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'authorized', component: AuthorizedComponent },
    { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule { }
