package tec.lass.zazil_app.viewmodel

import androidx.lifecycle.ViewModel

class SessionViewModel : ViewModel() {
    var phoneNumber: String? = null
        private set

    fun setPhoneNumber(phone: String) {
        phoneNumber = phone
    }
}
