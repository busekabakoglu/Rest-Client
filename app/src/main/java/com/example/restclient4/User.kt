package com.example.restclient4

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(author : String, name : String, avatar1 : String, url : String, description : String, language : String, stars : String, forks : String, currentPeriodStars : String, builtBy : List<Builder>,username : String, href : String, avatar2:String ){
    @SerializedName("author")
    val author : String = author
    @SerializedName("name")
    val name : String = name
    @SerializedName("avatar")
    val avatar1 : String = avatar1
    @SerializedName("url")
    val url : String = url
    @SerializedName("description")
    val description : String = description
    @SerializedName("language")
    val language : String = language
    @SerializedName("stars")
    val stars : String = stars
    @SerializedName("forks")
    val forks : String = forks
    @SerializedName("currentPeriodStars")
    val currentPeriodStars : String = currentPeriodStars
    @SerializedName("builtBy")
    val builders : List<Builder> = builtBy//JSON objesi

    class Builder(username: String,href: String,avatar2: String){
        @SerializedName("username")
        @Expose
        val username : String = username
        @SerializedName("href")
        @Expose
        val href : String = href
        @SerializedName("avatar")
        @Expose
        val avatar2 : String = avatar2


    }

}