package com.example.api_test_1


import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("todos")
   fun getToDoList(): Observable<List<ToDoModel>>

    @GET("comments")
    fun getcomments() : Observable<List<comments>>

    @GET("photos")
    fun getphotos() : Observable<List<Photos>>

    @GET("albums")
    fun getalbums() : Observable<List<Albums>>

    @GET("posts")
    fun getposts() : Observable<List<Posts>>

    @GET("users")
    fun getusers() : Observable<List<Users>>


}