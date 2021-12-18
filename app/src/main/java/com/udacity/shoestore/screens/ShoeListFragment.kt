package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.udacity.shoestore.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ShoeDetailsViewBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        var oldShoeLayout : ViewGroup = binding.shoeListContainer

        var shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.fab.setOnClickListener(Navigation.
        createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailsFragment))

        if(shoeViewModel.shoeListData == null){
            binding.emptyListText.setVisibility(View.VISIBLE)
        }

        shoeViewModel.shoeListData.observe(viewLifecycleOwner,{
            for(item in it) {

                val view: ShoeDetailsViewBinding = DataBindingUtil.inflate(
                    inflater, R.layout.shoe_details_view, container, false
                )

                view.shoeName.text = item.name
                view.shoeCompany.text = getString(R.string.company_text_list,item.company)
                view.shoeSize.text = getString(R.string.shoe_size_list, item.size.toString())
                view.shoeDescription.text = getString(R.string.description_text_list, item.description)
                view.shoeImages.text = getString(R.string.images_text_list, item.images)

                oldShoeLayout.addView(view.root)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
        super.onOptionsItemSelected(item)
    }

}

