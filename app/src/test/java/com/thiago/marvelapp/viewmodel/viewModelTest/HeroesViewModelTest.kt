package com.thiago.marvelapp.viewmodel.viewModelTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.thiago.marvelapp.model.HeroesEntity
import com.thiago.marvelapp.viewmodel.HeroesViewModel
import com.thiago.marvelapp.viewmodel.util.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HeroesViewModelTest{

    private lateinit var heroesViewModel: HeroesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUpViewModel(){
        // GIVEN
        heroesViewModel = HeroesViewModel(
            ApplicationProvider.getApplicationContext(),
            null,
            null
        )
    }

    @Test
    fun heroesViewModel_insertHero(){

        val heroesEntity = HeroesEntity(
            id = 0,
            name = "name",
            description = "description",
            image = "image"
        )

        // WHEN
        heroesViewModel.displayPropertyDetail(heroesEntity)

        // THEN
        assertEquals(heroesEntity, heroesViewModel.navigateToHero.getOrAwaitValue())
    }

    @Test
    fun heroesViewModel_checkNullableValue(){

        // WHEN
        heroesViewModel.heroesDetailCompleted()

        // THEN
        assertEquals(null, heroesViewModel.navigateToHero.getOrAwaitValue())
    }
}