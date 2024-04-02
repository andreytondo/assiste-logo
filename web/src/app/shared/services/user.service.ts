import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { of } from 'rxjs';

@Injectable({providedIn: 'root'})
export class UserService {
    
    private readonly _url = `${environment.api}/v1/users`;

    constructor(private httpClient: HttpClient) { }
    
    getFeed() {
        return this.httpClient.get('https://jsonplaceholder.typicode.com/users');
    }

    getMedia(mediaId: string) {
        return of({
            id: 123,
            mediaType: 'MOVIE',
            mediaId: mediaId,
            status: 'WATCHING',
            rating: 5,
            review: 'muito bao, muito bao mesmo',
            favorite: true
        })
        // return this.httpClient.get(`${this._url}/1/media/${mediaId}`);
    }

}