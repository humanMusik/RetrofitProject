package com.example.retrofitproject.presentation

import androidx.lifecycle.ViewModel
import com.example.retrofitproject.data.User
import com.example.retrofitproject.data.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(

) : ViewModel() {

    private val _users = MutableStateFlow(emptyList<User>())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    init {
        // get users
    }
}