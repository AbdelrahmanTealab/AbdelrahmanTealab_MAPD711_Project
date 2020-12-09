package com.example.abdelrahmantealab_mapd711_project

import androidx.room.*

@Dao
public interface CustomersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(customers: Customers)

    @Query("SELECT * FROM customers WHERE username = :username")
    fun getByUsername(username: String):Customers

    @Query("SELECT * FROM customers WHERE firstname=:firstname AND lastname=:lastname AND username = :username AND email=:email LIMIT 1")
    fun getByDetails(firstname: String, lastname: String, username: String, email: String):Customers

    @Query("UPDATE customers SET firstname = :newfirstname WHERE id = :id")
    fun updateFname(newfirstname: String, id: Int)
    @Query("UPDATE customers SET lastname = :newlastname WHERE id = :id")
    fun updateLname(newlastname: String, id: Int)
    @Query("UPDATE customers SET username = :newusername WHERE id = :id")
    fun updateUsername(newusername: String, id: Int)
    @Query("UPDATE customers SET address = :newaddress WHERE id = :id")
    fun updateAddress(newaddress: String, id: Int)
    @Query("UPDATE customers SET city = :newcity WHERE id = :id")
    fun updateCity(newcity: String, id: Int)
    @Query("UPDATE customers SET postal = :newpostal WHERE id = :id")
    fun updatePostal(newpostal: String, id: Int)
    @Query("UPDATE customers SET email = :newemail WHERE id = :id")
    fun updateEmail(newemail: String, id: Int)
    @Query("UPDATE customers SET phone = :newphone WHERE id = :id")
    fun updatePhone(newphone: String, id: Int)

    @Query("SELECT * FROM customers WHERE firstname = :firstname")
    fun getByName(firstname: String):List<Customers>

    @Query("SELECT * FROM customers")
    fun getAllCustomers():List<Customers>

    @Query("SELECT * FROM customers WHERE id = :id")
    fun getById(id: Int):Customers

    @Delete
    fun delete(customer: Customers)
}