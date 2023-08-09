package com.example.proyectofinal.data.mappers

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
import com.squareup.moshi.Json
import junit.framework.TestCase.assertNull
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CharacterDtoMapperTest {

    @Test
    fun `WHEN toCharacterModel with values EXPECT model has value`() {
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

        val res = characterResult.toCharacterModel()

        assertThat(res.id, `is`(1))
        assertThat(res.name, `is`("Character 1"))
        assertThat(res.description, `is`("Description"))
        assertThat(res.photoURL, `is`("thumbnail-path.jpg"))
    }
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

        val res = characterResult.toCharacterModel()

        assertThat(res.id, `is`(0))
        assertThat(res.name, `is`(""))
        assertThat(res.description, `is`("No description"))
        assertThat(res.photoURL, `is`(""))
    }
}
