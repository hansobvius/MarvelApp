package com.thiago.marvelapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thiago.marvelapp.R
import com.thiago.marvelapp.model.HeroesEntity
import com.thiago.marvelapp.util.OnClickListener
import kotlinx.android.synthetic.main.content_main.view.*

class MainAdapter(val onClickListener: OnClickListener<HeroesEntity>?): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    var projects: List<HeroesEntity> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.content_main, parent, false)
        return MainViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return projects.count()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val project = projects[position]

        Glide.with(holder.itemView.context).load(project.image).into(holder.heroImage)
        holder.heroName.text = project.name

        holder.itemView.setOnClickListener {
            onClickListener!!.onClick(project)
        }
    }

    inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view){
        var heroImage: ImageView = view.hero_image
        var heroName: TextView = view.hero_name
    }
}