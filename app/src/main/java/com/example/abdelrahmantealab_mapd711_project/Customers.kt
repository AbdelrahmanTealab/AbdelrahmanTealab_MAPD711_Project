package com.example.abdelrahmantealab_mapd711_project

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
class Customers{
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    var firstname:String
    var lastname:String
    private var username:String
    private var address:String
    private var city:String
    private var postal:String
    private var email:String
    private var password:String
    private var phone:String

    constructor(
        id: Int,
        firstname: String,
        lastname: String,
        username: String,
        address: String,
        city: String,
        postal: String,
        email: String,
        password: String,
        phone: String
    ) {
        this.id = id
        this.firstname = firstname
        this.lastname = lastname
        this.username = username
        this.address = address
        this.city = city
        this.postal = postal
        this.email = email
        this.password = password
        this.phone = phone
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
    fun getAddress(): String? {
        return address
    }

    fun setAddress(address: String) {
        this.address = address
    }
    fun getCity(): String? {
        return city
    }

    fun setCity(city: String) {
        this.city = city
    }
    fun getPostal(): String? {
        return postal
    }

    fun setPostal(postal: String) {
        this.postal = postal
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getPhone(): String? {
        return phone
    }
    fun setPhone(phone: String){
        this.phone = phone
    }

}