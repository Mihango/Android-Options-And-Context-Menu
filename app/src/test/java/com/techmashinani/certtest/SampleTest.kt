package com.techmashinani.certtest

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.techmashinani.certtest.models.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Before

@RunWith(JUnit4::class)
class SampleTest {

    private lateinit var user: User

    @Before
    fun initialize() {
        user = User("Ryan")
    }

    @Test
    fun isNameNull() {
        assertThat(user.name, not(nullValue()))
    }

    @Test
    fun isNameRyan() {
        assertThat(user.name, `is`(equalTo("Ryan")))
    }
}