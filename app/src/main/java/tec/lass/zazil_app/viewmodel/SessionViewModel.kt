package tec.lass.zazil_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SessionViewModel : ViewModel() {
    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> get() = _phoneNumber

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    fun setPhoneNumber(phone: String) {
        _phoneNumber.value = phone
    }

    fun setUserName(name: String) {
        _userName.value = name
    }
}