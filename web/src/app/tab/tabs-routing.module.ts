import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: '',
    component: TabsPage,
    children: [
      {
        path: 'friends',
        loadChildren: () => import('./tabs/friends/friends.module').then(m => m.FriendsPageModule)
      },
      {
        path: 'search',
        loadChildren: () => import('./tabs/search/search.module').then(m => m.SearchModule)
      },
      {
        path: 'collections',
        loadChildren: () => import('./tabs/collections/collections.module').then(m => m.CollectionsPageModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule {}
