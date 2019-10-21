import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './errors/not-found/not-found.component';
import { ItemListComponent } from './items/item-list/item-list.component';
import { ItemListResolver } from './items/item-list/item-list.resolver';
import { SigninComponent } from './home/signin/signin.component';


const routes: Routes = [
    {
        path: '',
        component: SigninComponent
    },
    {
        path: 'user/:userId',
        component: ItemListComponent,
        resolve: {
            items: ItemListResolver
        }
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