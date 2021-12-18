package com.udacity.shoestore.models

 /*I have added a data class User, so I can save the email and the password for future uses. In the future,
I'd like to be able to show the current user's account*/

data class User(var email : String, var password :String) {
}