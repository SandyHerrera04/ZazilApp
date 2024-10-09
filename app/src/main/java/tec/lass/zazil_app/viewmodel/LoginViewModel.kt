package mx.sphr.zazil.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tec.lass.zazil_app.model.UserRepository

sealed class LoginState {
    object Success : LoginState()
    object Loading : LoginState()
    class Error(val message: String) : LoginState()
}

class LoginViewModel : ViewModel() {
    private val userRepository = UserRepository()
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Loading)
    val loginState: StateFlow<LoginState> = _loginState

    var phoneNumber: String? = null
        private set

    fun login(phone: String, password: String) {
        _loginState.value = LoginState.Loading

        viewModelScope.launch {
            userRepository.loginUser(phone, password,
                onSuccess = {
                    phoneNumber = phone
                    _loginState.value = LoginState.Success
                },
                onFailure = { error ->
                    _loginState.value = LoginState.Error(error)
                }
            )
        }
    }
}