package com.example.proyectofinal.data.domain.model

import com.example.proyectofinal.domain.model.ComicModel
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ComicModelTest {

    private val comicModel = ComicModel(
        id = 1,
        title = "Comic 1",
        description = "Description",
        photoURL = "https://photo-url"
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        assertThat(comicModel, instanceOf(ComicModel::class.java))
        assertThat(comicModel, notNullValue())
    }

    @Test
    fun `WHEN comicModel id is 1 EXPECT id = 1`() {
        assertThat(comicModel.id, `is`(1))
    }

    @Test
    fun `WHEN comicModel title is Comic 1 EXPECT title = Comic 1`() {
        assertThat(comicModel.title, `is`("Comic 1"))
    }

    @Test
    fun `WHEN comicModel description is Description EXPECT description = Description`() {
        assertThat(comicModel.description, `is`("Description"))
    }

    @Test
    fun `WHEN comicModel photoURL is httpsphoto-url EXPECT photoURL starts with https`() {
        assertThat(comicModel.photoURL.startsWith("https"), `is`(true))
    }

}