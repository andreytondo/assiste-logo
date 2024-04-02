import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { Observable, combineLatest, map, merge, of } from 'rxjs';
import { CoverService } from 'src/app/shared/services/cover.service';
import { ProxyService } from 'src/app/shared/services/proxy.service';
import { UserService } from 'src/app/shared/services/user.service';

@Component({
    selector: 'app-details',
    templateUrl: 'details-page.component.html',
    styleUrls: ['details.page.scss']
})

export class DetailsPage implements OnInit {

    userMedia$: Observable<any>;
    mediaType: 'movie' | 'show';
    modalOpen = false;

    constructor(
        private _route: ActivatedRoute,
        private _proxyService: ProxyService,
        private _coverService: CoverService,
        private _userService: UserService
    ) { }

    ngOnInit(): void {
        const mediaType = this._route.snapshot.paramMap.get('media');
        this.mediaType = mediaType as 'movie' | 'show';
        const mediaId = this._route.snapshot.paramMap.get('id');

        this.userMedia$ = combineLatest([
            this._getMediaDetails(this.mediaType, mediaId),
            this._getUserMediaDetails(mediaId)
        ]).pipe(
            map(([mediaDetails, userDetails]) => ({
                mediaDetails, userDetails,
                friends: [
                    {
                        name: 'sthefani',
                        review: 'gostei muito pricnipal mente naquelas parata asoijafaosif aosfkaoko',
                        rating: 4,
                    }
                 ]

            }))
        );
    }

    private _getMediaDetails(mediaType: 'movie' | 'show', mediaId: string): Observable<any> {
        let obs$ = this._proxyService.getMediaDetails(mediaType, mediaId);
        return obs$.pipe(
            map((res: any) => {
                res.imagePath = this._coverService.getImageUrl('w500', res.cover);
                res.backdropPath = this._coverService.getImageUrl('w1280', res.backdrop);
                return res;
            }));
    }

    private _getUserMediaDetails(mediaId: string): Observable<any> {
        return this._userService.getMedia(mediaId);
    }

    toggleFavorite(media: any): void {
        media.favorite = !media.favorite;
    }

    showfavoriteDialog(bool: boolean): void {
        this.modalOpen = bool;
    }

    saveReview(review: any) {
        console.log(review);
        this.showfavoriteDialog(false);        
    }

    rotateStatus(media: any): void {
        switch (media.status) {
            case 'watched':
                media.status = 'watching';
                break;
            case 'watching':
                media.status = 'planned';
                break;
            case 'planned':
                media.status = 'dropped';
                break;
            case 'dropped':
                media.status = 'watched';
                break;
            default:
                media.status = 'watched';
        }
    }

    getColor(status: string): string {
        switch (status) {
            case 'watched':
                return 'success';
            case 'watching':
                return 'primary';
            case 'planned':
                return 'warning';
            case 'dropped':
                return 'danger';
            default:
                return 'medium';
        }
    }
}