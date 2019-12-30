package com.thiago.marvelapp.util

class OnClickListener<T>(val clickListener: (model: T) -> Unit){
    fun onClick(model: T) = clickListener(model)
}