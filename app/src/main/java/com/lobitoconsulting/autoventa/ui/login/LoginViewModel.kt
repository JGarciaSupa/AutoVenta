package com.lobitoconsulting.autoventa.ui.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lobitoconsulting.autoventa.data.common.Constants
import com.lobitoconsulting.autoventa.data.common.toast
import com.lobitoconsulting.autoventa.domain.model.User
import com.lobitoconsulting.autoventa.domain.usecase.shared.GetPreferenceUseCase
import com.lobitoconsulting.autoventa.domain.usecase.shared.SetPreferenceUseCase
import com.lobitoconsulting.autoventa.domain.usecase.user.InsertUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    val context: Context,
    private val getPreferenceUseCase: GetPreferenceUseCase,
    private val setPreferenceUseCase: SetPreferenceUseCase,
    private val insertUserUseCase: InsertUserUseCase,
) : ViewModel() {

    // Cambiamos el tipo de _loginResult a Long? para manejar el ID del usuario
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult
    private val _isLoadingLogin = MutableStateFlow(false)
    val isLoadingLogin: StateFlow<Boolean> get() = _isLoadingLogin



    val visiblePermissionDialogQueue = mutableStateListOf<String>()


    init{
        registerUser()
    }

    fun registerUser() {


//        // Verificar si las contraseñas coinciden
//        if (password != confirmPassword) {
//            Toast.makeText(context, "Contraseña no coincide", Toast.LENGTH_SHORT).show()
//            return
//        }

        viewModelScope.launch(Dispatchers.IO) {
//            _registerSuccess.postValue(false)
            val user = User(username = "Lobito", password = "admin")
            val result = insertUserUseCase(user)
            if (result != null) {
                withContext(Dispatchers.Main) {
                    context.toast("Usuario registrado")
                }
//                _registerSuccess.postValue(true)

            }
        }
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