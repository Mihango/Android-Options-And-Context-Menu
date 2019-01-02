package com.techmashinani.certtest.models

class User() {

    lateinit var name: String

    constructor(name: String): this() {
        this.name = name
    }
}