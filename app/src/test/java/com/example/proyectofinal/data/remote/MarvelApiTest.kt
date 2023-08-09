package com.example.proyectofinal.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyectofinal.di.BaseURL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class MarvelApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()


    private lateinit var api: MarvelAPI

    @Before
    fun setup() {
        api = retrofit.create(MarvelAPI::class.java)
    }

    @Test
    fun `WHEN request hero list EXPECT result`() = runTest {
        val result = api.getCharacterList(APIKEY, TS, HASH, 100, )

        assertThat(result.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request whit search EXPECT item`() = runTest {
        val result = api.getCharacterList(SearchDto("Goku"))

        assertThat(result.size, `is`(1))
    }

    @Test
    fun `WHEN request whit random text EXPECT empty list`() = runTest {
        val result = api.getCharacterList(SearchDto("asdf asdf"))

        assertThat(result.isEmpty(), `is`(true))
    }




    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                // lo ideal es probar contra un entorno estable
                // entorno de QA
                .baseUrl(BaseURL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}