package com.thiago.marvelapp.viewmodel.viewModelTest

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.thiago.marvelapp.model.HeroesEntity
import com.thiago.marvelapp.viewmodel.DetailViewModel
import com.thiago.marvelapp.viewmodel.util.getOrAwaitValue
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailViewModelTest{

    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun setUpViewModel(){
        detailViewModel = DetailViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun detailViewModel_insertHeroDetail(){

        val heroEntity = HeroesEntity(
            id = 0,
            name = "",
            description = "",
            image = ""
        )

        detailViewModel.insertValue(heroEntity)

        assertEquals(heroEntity, detailViewModel.heroes.getOrAwaitValue())
    }
}
