package com.example.proyectofinal.data.domain.model

import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Test

class CharacterModelTest {

    private val characterModel = CharacterModel(
        id = 1,
        name = "Pedro",
        description = "Description",
        photoURL = "https://photo-url",
        favModel = FavModel(1, false)
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        assertThat(characterModel, instanceOf(CharacterModel::class.java))
        assertThat(characterModel, notNullValue())
    }

    @Test
    fun `WHEN characterModel id is 1 EXPECT id = 1`() {
        assertThat(characterModel.id, `is`(1))
    }

    @Test
    fun `WHEN characterModel name is Pedro EXPECT name = Pedro`() {
        assertThat(characterModel.name, `is`("Pedro"))
    }

    @Test
    fun `WHEN characterModel description is Description EXPECT description = Description`() {
        assertThat(characterModel.description, `is`("Description"))
    }

    @Test
    fun `WHEN characterModel photoURL is httpsphoto-url EXPECT photoURL starts with https`() {
        assertThat(characterModel.photoURL.startsWith("https"), `is`(true))
    }

    @Test
    fun `WHEN characterModel favModel id is  1 EXPECT id = 1`() {
        assertThat(characterModel.favModel.id, `is`(1))
    }

    @Test
    fun `WHEN characterModel favModel favorite is false EXPECT favorite = false`() {
        assertThat(characterModel.favModel.favorite, `is`(false))
    }

}