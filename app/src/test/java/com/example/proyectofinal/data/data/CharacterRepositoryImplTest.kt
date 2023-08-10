package com.keepcoding.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyectofinal.data.local.LocalDataSource
import com.example.proyectofinal.data.local.model.FavLocal
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.data.remote.dto.CharacterDTO
import com.example.proyectofinal.data.remote.dto.CharacterResult
import com.example.proyectofinal.data.remote.dto.Comics
import com.example.proyectofinal.data.remote.dto.Data
import com.example.proyectofinal.data.remote.dto.Events
import com.example.proyectofinal.data.remote.dto.Item
import com.example.proyectofinal.data.remote.dto.ItemXXX
import com.example.proyectofinal.data.remote.dto.Series
import com.example.proyectofinal.data.remote.dto.Stories
import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.example.proyectofinal.data.remote.dto.Url
import com.example.proyectofinal.data.repository.CharacterRepositoryImpl
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

class CharacterRepositoryImplTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource


    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getCharacterList EXPECT remote data`() = runTest {
        coEvery { localDataSource.getFav() } returns getCharacterLocal()
        coEvery { remoteDataSource.getCharacterList() } returns getCharacterRemote()

        val repo = CharacterRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getCharacterList()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(1))
    }
}

fun getCharacterLocal() = listOf(
    FavLocal(id = 1, favorite = false),
    FavLocal(id = 2, favorite = true)
    )

fun getCharacterRemote() =
    CharacterDTO(
        data = Data(
            results = listOf(
                CharacterResult(
                    comics = Comics(
                        available = 5,
                        collectionURI = "comics-uri",
                        items = listOf(Item(name = "Item 1", resourceURI = "item-uri")),
                        returned = 3
                    ),
                    description = "Description",
                    events = Events(
                        available = 2,
                        collectionURI = "events-uri",
                        items = listOf(Item(name = "Event 1", resourceURI = "event-uri")),
                        returned = 1
                    ),
                    id = 1,
                    modified = "2023-08-01",
                    name = "Character 1",
                    resourceURI = "character-uri",
                    series = Series(
                        available = 3,
                        collectionURI = "series-uri",
                        items = listOf(Item(name = "Series 1", resourceURI = "series-uri")),
                        returned = 2
                    ),
                    stories = Stories(
                        available = 4,
                        collectionURI = "stories-uri",
                        items = listOf(ItemXXX(name = "Story 1", resourceURI = "story-uri", type = "Type 1")),
                        returned = 2
                    ),
                    thumbnail = Thumbnail(extension = "jpg", path = "thumbnail-path"),
                    urls = listOf(Url(type = "wiki", url = "wiki-url"))
                )
            )
        )
    )