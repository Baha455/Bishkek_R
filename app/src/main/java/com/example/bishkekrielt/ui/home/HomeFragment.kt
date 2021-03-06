package com.example.bishkekrielt.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bishkekrielt.data.model.Data
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.ui.RvAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(){

    var binding: FragmentHomeBinding? = null
    private val vm by viewModel<HomeViewModel>()
    private val adapter by lazy { RvAdapter(vm) }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVM()
        initRv()
        vm.getData()
    }
    private fun initVM(){
        vm.catalog.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
    }
    private fun initRv(){
        binding?.rv1?.adapter = adapter
    }


    /*private fun setupData(){
        vm.catalog.observe(viewLifecycleOwner, {
            binding?.text1Home?.text = it.
        })
        vm.catalog.observe(viewLifecycleOwner, {
            binding?.textHome?.text = it.title
        })
    }*/


}