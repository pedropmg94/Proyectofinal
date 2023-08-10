package com.example.proyectofinal.data.presentation.CharacterViewModelTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyectofinal.data.testutil.CharacterTestDataBuilder
import com.example.proyectofinal.domain.usecase.FavUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import com.example.proyectofinal.presentation.characterlist.CharacterListViewModel
import com.example.proyectofinal.presentation.characterlist.UICharacterListState
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import com.keepcoding.androidsuperpoderes.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterListViewModelTest {
   /* @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getCharacterListUseCase: GetCharacterListUseCase

    @MockK(relaxed = true)
    private lateinit var favUseCase: FavUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        // Liberar recursos del test
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest {
        coEvery { getCharacterListUseCase.invoke() } returns CharacterTestDataBuilder()
            .withNumElements(15)
            .buildList()

        val viewModel = CharacterListViewModel(getCharacterListUseCase, favUseCase)

        val res = viewModel.ui.getOrAwaitValue()
        val loadedState = res as UICharacterListState.Loaded
        val list = loadedState.items.toMutableList()

        //assertThat(res, instanceOf(UICharacterListState.Loaded::class.java))
        assertThat(list.size, `is`(15))
    }*/
}
