import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from '../../../shared/services/user.service';

@Component({
  selector: 'app-friends',
  templateUrl: 'friends.page.html',
  styleUrls: ['friends.page.scss']
})
export class FriendsPage implements OnInit {

  friends$: Observable<any>

  constructor(
    private _userService: UserService
  ) {}

  ngOnInit(): void {
    this.friends$ = this._userService.getFeed()
  }

}
