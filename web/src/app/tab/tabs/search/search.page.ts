import { Component } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Observable, catchError, map } from 'rxjs';
import { ProxyService } from 'src/app/shared/services/proxy.service';
import { CollectionsPage } from '../collections/collections.page';
import { CoverService } from 'src/app/shared/services/cover.service';

@Component({
  selector: 'app-search',
  templateUrl: 'search.page.html',
  styleUrls: ['search.page.scss']
})
export class SearchPage {

  search$: Observable<any>;
  searchType: 'movie' | 'show' = 'movie';
  searchQuery: string;
  loading: boolean = false;
  customMessage: string;

  constructor(
    private _proxyService: ProxyService,
    private _coverService: CoverService
  ) {}

  changeSearchMode(value: 'movie' | 'show') {
    this.searchType = value;
    this._search();
  }

  handleSearchInput(event: any) {
    this.searchQuery = event.target.value;
    this._search();
  }

  private _search() {
    if (!this.searchQuery) return;

    this.loading = true;
    this.search$ = (this.searchType === 'movie' ?
    this._proxyService.searchMovies({ query: this.searchQuery }) :
    this._proxyService.searchShows({ query: this.searchQuery }))
    .pipe(
      map((response) => {
        if (!response.lenth) this.customMessage = 'Nenhum resultado encontrado!';
        return response.map((item: any) => {
          item.imagePath = this._coverService.getImageUrl('w154', item.cover);
          this.loading = false;
          return item;
        })
      }),
      catchError((error) => {
        this.loading = false;
        this.customMessage = 'Ocorreu um erro!';
        throw new Error(error);
      })
    )
  }
}
