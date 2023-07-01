package com.example.d4_kotlin_coroutines_multitasking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.d4_kotlin_coroutines_multitasking.model.User
import com.example.d4_kotlin_coroutines_multitasking.model.UserRepository
import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRepository = UserRepository()
    var users : MutableLiveData<List<User>> = MutableLiveData()
// viewModelScope is useful for automatically clearing resources when the associated ViewModel is no longer in use.
    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }
            users.value = result
        }
    }

//    --------------------PREV METHOD----------------------------
//    private val job = Job()
//    private val scope = CoroutineScope(Dispatchers.IO)

//fun getUserData(){
//    viewModelScope.launch {
//
//    }
//}

//    override fun onCleared() {
//        super.onCleared()
//        job.cancel()// will cancel the coroutin
//    }
}