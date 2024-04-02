import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class CoverService {

    private readonly _url = 'https://image.tmdb.org/t/p';
    
    constructor(private httpClient: HttpClient) { }
    
    getImageUrl(width: string, path: string) {
        return `${this._url}/${width}${path}`;
    }
}