package com.example.proyectofinal.data.repository

interface LoginRepository {
    suspend fun saveCredentials()
    suspend fun makeLogin()
    suspend fun getCredentials()
    suspend fun removeCredentials()
}