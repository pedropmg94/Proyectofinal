package com.example.proyectofinal.data.data.mappers

import com.example.proyectofinal.data.mappers.toCharacterModel
import com.example.proyectofinal.data.mappers.toComicModel
import com.example.proyectofinal.data.remote.dto.CharacterDTO
import com.example.proyectofinal.data.remote.dto.CharacterResult
import com.example.proyectofinal.data.remote.dto.CollectedIssue
import com.example.proyectofinal.data.remote.dto.ComicCharacters
import com.example.proyectofinal.data.remote.dto.ComicCreators
import com.example.proyectofinal.data.remote.dto.ComicEvents
import com.example.proyectofinal.data.remote.dto.ComicResult
import com.example.proyectofinal.data.remote.dto.Comics
import com.example.proyectofinal.data.remote.dto.ComicsSeries
import com.example.proyectofinal.data.remote.dto.ComicsStories
import com.example.proyectofinal.data.remote.dto.Data
import com.example.proyectofinal.data.remote.dto.Date
import com.example.proyectofinal.data.remote.dto.Events
import com.example.proyectofinal.data.remote.dto.Image
import com.example.proyectofinal.data.remote.dto.Item
import com.example.proyectofinal.data.remote.dto.ItemX
import com.example.proyectofinal.data.remote.dto.ItemXX
import com.example.proyectofinal.data.remote.dto.ItemXXX
import com.example.proyectofinal.data.remote.dto.Price
import com.example.proyectofinal.data.remote.dto.Series
import com.example.proyectofinal.data.remote.dto.Stories
import com.example.proyectofinal.data.remote.dto.TextObject
import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.example.proyectofinal.data.remote.dto.Url
import com.example.proyectofinal.data.remote.dto.Variant
import com.example.proyectofinal.domain.model.FavModel
import com.squareup.moshi.Json
import junit.framework.TestCase.assertNull
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CharacterDtoMapperTest {

    @Test
    fun `WHEN toCharacterModel with values EXPECT model has value`() {
        val favModel = FavModel(id = 1, favorite = true)
        val characterResult = CharacterResult(
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


            val result = characterResult.toCharacterModel(favModel)

        assertThat(result.id, `is`(1))
        assertThat(result.name, `is`("Character 1"))
        assertThat(result.description, `is`("Description"))
        assertThat(result.photoURL, `is`("thumbnail-path.jpg"))
        assertThat(result.favModel, `is`(favModel))

    }

    @Test
    fun `WHEN toCharacterModel with null EXPECT empty string`() {
        val characterResult = CharacterResult(
            comics = null,
            description = null,
            events = null,
            id = null,
            modified = null,
            name = null,
            resourceURI = null,
            series = null,
            stories = null,
            thumbnail = null,
            urls = null
        )

        val result = characterResult.toCharacterModel(FavModel(id = 0, favorite = false))

        assertThat(result.id, `is`(0))
        assertThat(result.name, `is`(""))
        assertThat(result.description, `is`("No description"))
        assertThat(result.photoURL, `is`(""))
        assertThat(result.favModel.id, `is`(0))
        assertThat(result.favModel.favorite, `is`(false))
    }



    @Test
    fun `WHEN toComicModel with values EXPECT model has value`() {
        val comicResult = ComicResult(
            characters = ComicCharacters(5, "collectionURI", listOf(Item("Item 1", "item-uri")), 3),
            collectedIssues = listOf(CollectedIssue("Collected Issue name", "Collected Issue resource")),
            collections = listOf(),
            creators = ComicCreators(2, "collectionURI", listOf(ItemX("Creator 1", "creator-uri", "Role 1")), 1),
            dates = listOf(Date("date", "type")),
            description = "Description",
            diamondCode = "diamondCode",
            digitalId = 1,
            ean = "ean",
            events = ComicEvents(2, "collectionURI", listOf(), 1),
            format = "format",
            id = 1,
            images = listOf(Image("jpg", "image-path")),
            isbn = "isbn",
            issn = "issn",
            issueNumber = 123,
            modified = "2023-08-01",
            pageCount = 10,
            prices = listOf(Price(9.99, "type")),
            resourceURI = "resource-uri",
            series = ComicsSeries("Series 1", "series-uri"),
            stories = ComicsStories(4, "stories-uri", listOf(ItemXX("Story 1", "story-uri", "Type 1")), 2),
            textObjects = listOf(TextObject("language", "text", "type")),
            thumbnail = Thumbnail("jpg", "thumbnail-path"),
            title = "Comic 1",
            upc = "upc",
            urls = listOf(Url("wiki", "wiki-url")),
            variantDescription = "variantDescription",
            variants = listOf(Variant("Variant 1", "variant-uri"))
        )

        val result = comicResult.toComicModel()

        assertThat(result.id, `is`(1))
        assertThat(result.title, `is`("Comic 1"))
        assertThat(result.description, `is`("Description"))
        assertThat(result.photoURL, `is`("thumbnail-path.jpg"))
    }

    @Test
    fun `WHEN toComicModel with null EXPECT empty string`() {
        val comicResult = ComicResult(
            characters = null,
            collectedIssues = null,
            collections = null,
            creators = null,
            dates = null,
            description = null,
            diamondCode = null,
            digitalId = null,
            ean = null,
            events = null,
            format = null,
            id = null,
            images = null,
            isbn = null,
            issn = null,
            issueNumber = null,
            modified = null,
            pageCount = null,
            prices = null,
            resourceURI = null,
            series = null,
            stories = null,
            textObjects = null,
            thumbnail = null,
            title = null,
            upc = null,
            urls = null,
            variantDescription = null,
            variants = null
        )

        val result = comicResult.toComicModel()

        assertThat(result.id, `is`(0))
        assertThat(result.title, `is`(""))
        assertThat(result.description, `is`("No description"))
        assertThat(result.photoURL, `is`(""))
    }
}

