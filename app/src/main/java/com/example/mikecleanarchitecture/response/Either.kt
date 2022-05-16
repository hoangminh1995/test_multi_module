package com.example.mikecleanarchitecture.response

sealed class Either<out V, out E : DomainError> {
    data class Value<out V>(val value: V) : Either<V, Nothing>()
    data class Failure<E : DomainError>(val error: E) : Either<Nothing, E>()
}
