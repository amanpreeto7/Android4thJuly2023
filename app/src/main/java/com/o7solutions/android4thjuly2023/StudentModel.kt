package com.o7solutions.android4thjuly2023

data class StudentModel(
    var name : String ? =null,
    var rollNo : Int = 0
){
    override fun toString(): String {
        return "$name"
    }
}
