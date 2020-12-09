package com.example.abdelrahmantealab_mapd711_project

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admins")
class Admins{
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    var firstname:String
    var lastname:String
    private var username:String
    private var password:String

    constructor(
        id: Int,
        firstname: String,
        lastname: String,
        username: String,
        password: String,
    ) {
        this.id = id
        this.firstname = firstname
        this.lastname = lastname
        this.username = username
        this.password = password
    }


    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getFName(): String? {
        return firstname
    }

    fun setFName(firstname: String) {
        this.firstname = firstname
    }
    fun getLName(): String? {
        return lastname
    }

    fun setLName(lastname: String) {
        this.lastname = lastname
    }

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

}