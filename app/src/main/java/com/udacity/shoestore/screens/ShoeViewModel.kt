package com.udacity.shoestore.screens

import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.User

class ShoeViewModel : ViewModel() {

    private val _eventLogIn = MutableLiveData<Boolean>()
    val eventLogIn : LiveData<Boolean>
    get()= _eventLogIn

    val shoeList = mutableListOf<Shoe>()

    private val _shoeListData = MutableLiveData(shoeList)
    val shoeListData : LiveData<MutableList<Shoe>>
    get() = _shoeListData

    init{
        _eventLogIn.value = false
        shoeList.clear()
    }

    fun addNewShoe(shoe : Shoe){
        shoeList.add(shoe)
        _shoeListData.value = shoeList
    }

    fun logInSucceed(user : User){
        _eventLogIn.value = true
    }

    fun logOut(){
        shoeList.clear()
        _eventLogIn.value = false
    }






}