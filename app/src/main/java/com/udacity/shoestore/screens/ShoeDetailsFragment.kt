package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailsBinding
    private lateinit var shoeViewModel : ShoeViewModel
    private lateinit var shoe : Shoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details,
            container,
            false
        )

        //reference to the viewModel
        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        shoe = Shoe("","","","","")
        binding.shoe = shoe

        binding.createButton.setOnClickListener{view: View ->
            shoeValidation()
        }

        binding.cancelButton.setOnClickListener{view: View ->
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }


        return binding.root
    }


    fun shoeValidation() {
        if (shoe.name.isNotBlank() && shoe.size.isNotBlank() &&
            shoe.description.isNotBlank() && shoe.company.isNotBlank() && shoe.images.isNotBlank()
        ) {
            shoeViewModel.addNewShoe(shoe)
            findNavController()
                .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        } else {
            if (shoe.name == "") {
                binding.shoeNameEdit.setError("This field can not be blank")
            }
            if (shoe.size == "") {
                binding.shoeSizeEdit.setError("This field can not be blank")
            }
            if (shoe.company == "") {
                binding.shoeCompanyEdit.setError("This field can not be blank")
            }
            if (shoe.description == "") {
                binding.shoeDescriptionEdit.setError("This field can not be blank")
            }
            if (shoe.images == "") {
                binding.shoeDescriptionEdit.setError("This field can not be blank")
            }
        }
    }

}

