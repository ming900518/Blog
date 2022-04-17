import { Component } from '@angular/core';
import {MenuItem} from 'primeng/api';
import {HttpClient} from "@angular/common/http";
import {ArticleList} from "../shared/model/ArticleList";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  items: MenuItem[] = [
    {
      label: 'Blog'
    },
    {
      label: 'About'
    }
  ];

  articleList: ArticleList[] | undefined

  constructor(
    private http: HttpClient
  ) {
  }

  ngOnInit() {
    this.http.get('http://localhost:4200/service/list').pipe().subscribe(data => {
      this.articleList = data as ArticleList[]
      console.log(this.articleList)
    })
  }

}
