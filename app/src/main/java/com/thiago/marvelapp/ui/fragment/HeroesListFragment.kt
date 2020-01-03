package com.thiago.marvelapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.thiago.marvelapp.databinding.FragmentHeroesListBinding
import com.thiago.marvelapp.ui.adapter.MainAdapter
import com.thiago.marvelapp.util.OnClickListener
import com.thiago.marvelapp.viewmodel.HeroesViewModel
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import org.koin.android.ext.android.inject

class HeroesListFragment : Fragment() {

    val viewModel: HeroesViewModel by inject()
    lateinit var mainAdapter: MainAdapter
    lateinit var binding: FragmentHeroesListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHeroesListBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onStart(){
        super.onStart()
        mainAdapter = MainAdapter(OnClickListener{
            viewModel.displayPropertyDetail(it)
        })
    }

    override fun onResume(){
        super.onResume()
        initObserver()
    }

    override fun onStop() {
        super.onStop()
        viewModel.heroesDetailCompleted()
    }

    private fun initObserver(){
        viewModel.getDatabase()?.observe(this, Observer {
            if(null != it){
                mainAdapter.projects = it
                mainAdapter.notifyDataSetChanged()
                main_list_reycler.adapter = mainAdapter
            }
        })

        viewModel.navigateToHero.observe(this, Observer {
            if(null != it){
                this.findNavController().navigate(
                    HeroesListFragmentDirections.actionHeroesListFragmentToDetailFragment(
                        it
                    )
                )
                viewModel.heroesDetailCompleted()
            }
        })
    }
}
