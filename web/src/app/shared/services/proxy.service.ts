import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { SearchRequest } from '../models/search-request';

@Injectable({ providedIn: 'root' })
export class ProxyService {

    private readonly _url = `${environment.api}/v1/proxy`;

    constructor(private _http: HttpClient) { }

    getMediaDetails(mediaType: 'movie' | 'show', mediaId: string): Observable<any> {
        if (mediaType === 'movie') {
            return this.getMovie(mediaId);
        }
        return this.getShow(mediaId);
    }

    searchMovies(request: SearchRequest): Observable<any> {
        const headers: HttpHeaders = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        return this._http.post(`${this._url}/search/movie`, request, { headers });
    }

    getMovie(externalId: string): Observable<any> {
        const params: HttpParams = new HttpParams().set('externalId', externalId);
        const headers: HttpHeaders = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        return this._http.get(`${this._url}/details/movie`, { params });
    }

    searchShows(request: SearchRequest): Observable<any> {
        const headers: HttpHeaders = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        return this._http.post(`${this._url}/search/show`, request, { headers });
    }

    getShow(externalId: string): Observable<any> {
        const params: HttpParams = new HttpParams().set('externalId', externalId);
        const headers: HttpHeaders = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        return this._http.get(`${this._url}/details/show`, { params, headers });
    }
}