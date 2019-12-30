package com.thiago.data.mapper

import com.thiago.cache.model.HeroesCacheModel
import com.thiago.data.model.HeroesDataModel
import com.thiago.remote.model.submodel.HeroesRemoteModel

class ModelMapper(): MapperImplementation<HeroesRemoteModel, HeroesCacheModel, HeroesDataModel> {

    override fun remoteToCache(remote: HeroesRemoteModel): HeroesCacheModel {
        return HeroesCacheModel(
                remote.id,
                remote.name,
                remote.description,
                imageRefactor(
                        remote.imageResource.urlPath,
                        remote.imageResource.extension))
    }

    override fun cacheToData(cache: HeroesCacheModel): HeroesDataModel {
        return HeroesDataModel(cache.heroId, cache.name, cache.description, cache.image)
    }

    private fun imageRefactor(url: String, ext: String): String = ("$url.$ext")
}