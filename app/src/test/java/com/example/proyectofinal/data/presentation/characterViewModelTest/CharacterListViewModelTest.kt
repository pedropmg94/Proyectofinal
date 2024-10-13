package com.example.proyectofinal.data.presentation.characterViewModelTest

import kotlinx.coroutines.ExperimentalCoroutinesApi

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
