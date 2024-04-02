import { NgModule } from '@angular/core';

import { LoginPage } from './login.page';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    {
        path: '',
        component: LoginPage
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(routes),
        IonicModule,
        CommonModule,
        FormsModule,
    ],
    declarations: [LoginPage],
})
export class LoginPageModule { }
