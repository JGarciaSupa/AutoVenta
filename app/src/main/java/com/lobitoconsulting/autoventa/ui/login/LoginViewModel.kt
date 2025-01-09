package com.lobitoconsulting.autoventa.ui.login

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lobitoconsulting.autoventa.data.common.Constants
import com.lobitoconsulting.autoventa.domain.usecase.shared.GetPreferenceUseCase
import com.lobitoconsulting.autoventa.domain.usecase.shared.SetPreferenceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    val context: Context,
    private val getPreferenceUseCase: GetPreferenceUseCase,
    private val setPreferenceUseCase: SetPreferenceUseCase
) : ViewModel() {

    // Cambiamos el tipo de _loginResult a Long? para manejar el ID del usuario
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult


    val visiblePermissionDialogQueue = mutableStateListOf<String>()


    init{
        autoLogin()
    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        if(!isGranted && !visiblePermissionDialogQueue.contains(permission)) {
            visiblePermissionDialogQueue.add(permission)
        }
    }

//    fun loginUser(username: String, password: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val isValidUser = validateUserUseCase(username, password)
//                if (isValidUser) {
//                    setPreferenceUseCase(PreferenceKeys.USER_LOGGED_IN, username)
//                    setPreferenceUseCase(PreferenceKeys.USER_PASSWORD_IN, password)
//                    _loginResult.postValue(true)  // Login exitoso
//                } else {
//                    _loginResult.postValue(false)  // Login fallido
//                    withContext(Dispatchers.Main) {
//                        context.toast("Usuario o contraseña incorrectos")
//                    }
//                }
//            } catch (e: Exception) {
//                _loginResult.postValue(false)
//                withContext(Dispatchers.Main) {
//                    context.toast("Error al intentar iniciar sesión: ${e.message}")
//                }
//            }
//        }
//    }




    fun autoLogin(){
        val username = getPreferenceUseCase(Constants.USER_LOGGED_IN)
        val password = getPreferenceUseCase(Constants.USER_PASSWORD_IN)
        if(!username.isNullOrBlank() && !password.isNullOrBlank()){
//            loginUser(username, password)
        }
    }
}