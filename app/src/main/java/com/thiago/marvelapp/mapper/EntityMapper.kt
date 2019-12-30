package com.thiago.marvelapp.mapper

import com.thiago.data.model.HeroesDataModel
import com.thiago.marvelapp.model.HeroesEntity

class EntityMapper(): MapperImplementation<HeroesDataModel, HeroesEntity> {

    override fun dataToPresentation(data: HeroesDataModel): HeroesEntity {
        return HeroesEntity(data.id, data.name, data.description, data.imageSource)
    }
}