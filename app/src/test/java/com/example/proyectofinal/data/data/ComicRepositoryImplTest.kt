package com.keepcoding.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.data.remote.dto.CollectedIssue
import com.example.proyectofinal.data.remote.dto.ComicCharacters
import com.example.proyectofinal.data.remote.dto.ComicCreators
import com.example.proyectofinal.data.remote.dto.ComicDTO
import com.example.proyectofinal.data.remote.dto.ComicData
import com.example.proyectofinal.data.remote.dto.ComicEvents
import com.example.proyectofinal.data.remote.dto.ComicResult
import com.example.proyectofinal.data.remote.dto.ComicsSeries
import com.example.proyectofinal.data.remote.dto.ComicsStories
import com.example.proyectofinal.data.remote.dto.Date
import com.example.proyectofinal.data.remote.dto.Image
import com.example.proyectofinal.data.remote.dto.Item
import com.example.proyectofinal.data.remote.dto.ItemX
import com.example.proyectofinal.data.remote.dto.ItemXX
import com.example.proyectofinal.data.remote.dto.Price
import com.example.proyectofinal.data.remote.dto.TextObject
import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.example.proyectofinal.data.remote.dto.Url
import com.example.proyectofinal.data.remote.dto.Variant
import com.example.proyectofinal.data.repository.ComicRepositoryImpl
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

class ComicRepositoryImplTest {
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
    fun `WHEN getComicList EXPECT remote data`() = runTest {
        coEvery { remoteDataSource.getComicList() } returns getRemote()

        val repo = ComicRepositoryImpl(
            remoteDataSource = remoteDataSource
        )

        val res = repo.getComicList()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(1))
    }
}

fun getRemote() =
    ComicDTO(
        data = ComicData(
            results = listOf(
                ComicResult(
                    characters = ComicCharacters(
                        available = 5,
                        collectionURI = "characters-uri",
                        items = listOf(Item(name = "Character 1", resourceURI = "character-uri")),
                        returned = 3
                    ),
                    collectedIssues = listOf(CollectedIssue(name = "Collected Issue 1", resourceURI = "collected-issue-uri")),
                    collections = listOf(),
                    creators = ComicCreators(
                        available = 2,
                        collectionURI = "creators-uri",
                        items = listOf(ItemX(name = "Creator 1", resourceURI = "creator-uri", role = "Role 1")),
                        returned = 1
                    ),
                    dates = listOf(Date(date = "2023-08-01", type = "Type 1")),
                    description = "Description",
                    diamondCode = "diamondCode",
                    digitalId = 1,
                    ean = "ean",
                    events = ComicEvents(
                        available = 2,
                        collectionURI = "events-uri",
                        items = listOf(Item(name = "Event 1", resourceURI = "event-uri")),
                        returned = 1
                    ),
                    format = "format",
                    id = 1,
                    images = listOf(Image(extension = "jpg", path = "image-path")),
                    isbn = "isbn",
                    issn = "issn",
                    issueNumber = 123,
                    modified = "2023-08-01",
                    pageCount = 10,
                    prices = listOf(Price(price = 9.99, type = "type")),
                    resourceURI = "resource-uri",
                    series = ComicsSeries(name = "Series 1", resourceURI = "series-uri"),
                    stories = ComicsStories(
                        available = 4,
                        collectionURI = "stories-uri",
                        items = listOf(ItemXX(name = "Story 1", resourceURI = "story-uri", type = "Type 1")),
                        returned = 2
                    ),
                    textObjects = listOf(TextObject(language = "language", text = "text", type = "type")),
                    thumbnail = Thumbnail(extension = "jpg", path = "thumbnail-path"),
                    title = "Comic 1",
                    upc = "upc",
                    urls = listOf(Url(type = "wiki", url = "wiki-url")),
                    variantDescription = "variantDescription",
                    variants = listOf(Variant(name = "Variant 1", resourceURI = "variant-uri"))
                )
            )
        )
    )