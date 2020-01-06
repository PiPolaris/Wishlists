import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './errors/not-found/not-found.component';
import { ItemListComponent } from './items/item-list/item-list.component';
import { ItemListResolver } from './items/item-list/item-list.resolver';
import { SigninComponent } from './home/signin/signin.component';
import { AuthGuard } from './core/auth/auth.guard';
import { SignupComponent } from './home/signup/signup.component';
import { NewItemComponent } from './items/new-item/new-item.component';


const routes: Routes = [
    {
        path: '',
        component: SigninComponent,
        canActivate: [AuthGuard]
    },
    {
        path: 'signup',
        component: SignupComponent
    },
    {
        path: 'user/:userId',
        component: ItemListComponent,
        resolve: {
            items: ItemListResolver
        }
    },
    {
        path: 'new-item',
        component: NewItemComponent
    },
    {
        path: '**',
        component: NotFoundComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }