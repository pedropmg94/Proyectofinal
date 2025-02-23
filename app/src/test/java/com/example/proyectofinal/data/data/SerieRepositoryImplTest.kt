package com.keepcoding.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.data.remote.dto.Item
import com.example.proyectofinal.data.remote.dto.ItemXX
import com.example.proyectofinal.data.remote.dto.ItemXXX
import com.example.proyectofinal.data.remote.dto.Next
import com.example.proyectofinal.data.remote.dto.SerieCharacters
import com.example.proyectofinal.data.remote.dto.SerieComics
import com.example.proyectofinal.data.remote.dto.SerieCreators
import com.example.proyectofinal.data.remote.dto.SerieDTO
import com.example.proyectofinal.data.remote.dto.SerieData
import com.example.proyectofinal.data.remote.dto.SerieEvents
import com.example.proyectofinal.data.remote.dto.SerieResult
import com.example.proyectofinal.data.remote.dto.SerieStories
import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.example.proyectofinal.data.remote.dto.Url
import com.example.proyectofinal.data.repository.SerieRepositoryImpl
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SerieRepositoryImplTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getSerieList EXPECT remote data`() = runTest {
        coEvery { remoteDataSource.getSerieList() } returns getSerieRemote()

        val repo = SerieRepositoryImpl(
            remoteDataSource = remoteDataSource
        )

        val res = repo.getSeries()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(1))
    }
}

fun getSerieRemote() =
    SerieDTO(
        data = SerieData(
            results = listOf(
                SerieResult(
                    characters = SerieCharacters(
                        available = 5,
                        collectionURI = "characters-uri",
                        items = listOf(Item(name = "Character 1", resourceURI = "character-uri")),
                        returned = 3
                    ),
                    comics = SerieComics(
                        available = 2,
                        collectionURI = "comics-uri",
                        items = listOf(Item(name = "Comic 1", resourceURI = "comic-uri")),
                        returned = 1
                    ),
                    creators = SerieCreators(
                        available = 2,
                        collectionURI = "creators-uri",
                        items = listOf(ItemXX(name = "Creator 1", resourceURI = "creator-uri", type = "Type 1")),
                        returned = 1
                    ),
                    description = "Description",
                    endYear = 2023,
                    events = SerieEvents(
                        available = 1,
                        collectionURI = "events-uri",
                        items = listOf(Any()),
                        returned = 1
                    ),
                    id = 1,
                    modified = "2023-08-01",
                    next = Next(name = "Next 1", resourceURI = "next-uri"),
                    previous = null,
                    rating = "rating",
                    resourceURI = "resource-uri",
                    startYear = 2020,
                    stories = SerieStories(
                        available = 3,
                        collectionURI = "stories-uri",
                        items = listOf(ItemXXX(name = "Story 1", resourceURI = "story-uri", type = "Type 1")),
                        returned = 2
                    ),
                    thumbnail = Thumbnail(extension = "jpg", path = "thumbnail-path"),
                    title = "Serie 1",
                    type = "type",
                    urls = listOf(Url(type = "wiki", url = "wiki-url"))
                )
            )
        )
    )