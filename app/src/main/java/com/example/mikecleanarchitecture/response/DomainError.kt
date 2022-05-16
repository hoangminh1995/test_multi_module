package com.example.mikecleanarchitecture.response

interface DomainErrorInterface {
    val errorCode: String
    val errorMessage: String
}

sealed class DomainError : DomainErrorInterface {

}
