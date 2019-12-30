package com.thiago.marvelapp.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.thiago.marvelapp.databinding.FragmentDetailBinding
import com.thiago.marvelapp.model.HeroesEntity
import com.thiago.marvelapp.viewmodel.DetailViewModel
import org.koin.android.ext.android.inject

class DetailFragment : Fragment() {

    val viewModel: DetailViewModel by inject()
    lateinit var heroesEntity: HeroesEntity
    lateinit var binding: FragmentDetailBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        heroesEntity = DetailFragmentArgs.fromBundle(
            arguments!!
        ).actionHero
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.insertValue(heroesEntity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initLayout()
    }

    private fun initLayout(){
        viewModel.heroes.observe(this, Observer {
            if(null != it){
                binding.descriptionView.visibility = if(!it.description.equals("")) View.VISIBLE else View.GONE
                binding.descriptionView.text = it.description
                binding.titleView.text = it.name
                Glide.with(this).load(it.image).into(binding.imageArticle)
            }
        })
    }
}
