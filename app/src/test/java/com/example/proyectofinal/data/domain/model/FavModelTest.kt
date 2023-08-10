package com.example.proyectofinal.data.domain.model

import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Test

class FavModelTest {

    private val favModel = FavModel(
        id = 1,
        favorite = true
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        assertThat(favModel, instanceOf(FavModel::class.java))
        assertThat(favModel, notNullValue())
    }

    @Test
    fun `WHEN favModel id is 1 EXPECT id = 1`() {
        assertThat(favModel.id, `is`(1))
    }

    @Test
    fun `WHEN favModel favorite is true EXPECT favorite = true`() {
        assertThat(favModel.favorite, `is`(true))
    }
}