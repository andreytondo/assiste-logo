import { NgModule } from '@angular/core';

import { DetailsPage } from './details-page.component';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    {
        path: ':media/:id',
        component: DetailsPage
    },
];

@NgModule({
    imports: [
        IonicModule,
        CommonModule,
        FormsModule,
        RouterModule.forChild(routes)
    ],
    exports: [],
    declarations: [DetailsPage],
    providers: [],
})
export class DetailsPageModule { }
