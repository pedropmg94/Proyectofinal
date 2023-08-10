package com.example.proyectofinal.data.domain.model

import com.example.proyectofinal.domain.model.SerieModel
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SerieModelTest {

    private val serieModel = SerieModel(
        id = 1,
        title = "Serie 1",
        description = "Description",
        photoURL = "https://photo-url"
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        assertThat(serieModel, instanceOf(SerieModel::class.java))
        assertThat(serieModel, notNullValue())
    }

    @Test
    fun `WHEN serieModel id is 1 EXPECT id = 1`() {
        assertThat(serieModel.id, `is`(1))
    }

    @Test
    fun `WHEN serieModel title is Serie 1 EXPECT title = Serie 1`() {
        assertThat(serieModel.title, `is`("Serie 1"))
    }

    @Test
    fun `WHEN serieModel description is Description EXPECT description = Description`() {
        assertThat(serieModel.description, `is`("Description"))
    }

    @Test
    fun `WHEN serieModel photoURL is httpsphoto-url EXPECT photoURL starts with https`() {
        assertThat(serieModel.photoURL.startsWith("https"), `is`(true))
    }
}