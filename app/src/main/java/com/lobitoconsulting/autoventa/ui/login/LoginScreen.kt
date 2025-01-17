package com.lobitoconsulting.autoventa.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lobitoconsulting.autoventa.R
import com.lobitoconsulting.autoventa.ui.theme.Roboto
import com.lobitoconsulting.autoventa.ui.theme.focusedTextFieldText
import com.lobitoconsulting.autoventa.ui.theme.textFieldContainer
import com.lobitoconsulting.autoventa.ui.theme.unfocusedTextFieldText

@Composable
fun LoginScreen( onNavigate: () -> Unit) {
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()) {
            LoginScreenTablet()
//            TopSection()
//            Spacer(modifier = Modifier.height(36.dp))
//            LoginContent(viewModel, onNavigate)
        }
    }
}



@Composable
fun LoginScreenTablet() {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
//    val empresasState by viewModel.empresaState.collectAsState()
    var expanded by rememberSaveable { mutableStateOf(false) }
//    var selectedEmpresa by remember { mutableStateOf<Empresa?>(null) }
    val context = LocalContext.current
//    val navigateToHome by viewModel.navigateToHome.collectAsState()
//    val isLoadingLogin by viewModel.isLoadingLogin.collectAsState()
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.DarkGray
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEEEE))
            .padding(
                start = 32.dp, // Padding izquierdo
                end = 32.dp,   // Padding derecho
                bottom = 32.dp // Padding inferior
            ), // Aumenta el padding para tablets
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo y pestañas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp)), // Curvas más grandes
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp)) // Espaciado más amplio
            Icon(
                painter = painterResource(R.drawable.logo), // Reemplaza con tu recurso
                contentDescription = "Chef Icon",
                tint = Color.Unspecified,
                modifier = Modifier.size(150.dp) // Icono más grande
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Iniciar Sesión",
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                        .drawBehind {
                            val strokeWidth = 3f // Ancho de la línea
                            val y = size.height - strokeWidth / 2 // Posición de la línea (inferior)
                            drawLine(
                                color = Color(0xFFFF6A00), // Color de la línea
                                start = Offset(0f, y),
                                end = Offset(size.width, y),
                                strokeWidth = strokeWidth
                            )
                        },
                    style = MaterialTheme.typography.labelLarge, // Cambia a un estilo más grande
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(32.dp)) // Más espacio entre opciones
                Text(
                    text = "Registrarse",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

        Spacer(modifier = Modifier.height(32.dp)) // Más espacio entre secciones

        // Formulario de inicio de sesión
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input de usuario
            CustomTextField(
                value = username,
                onValueChange = { username = it },
                label = "Usuario",
                uiColor = uiColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                label = "Contraseña",
                uiColor = uiColor,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = if (passwordVisible) R.drawable.visibility else R.drawable.visibilityoff),
                            contentDescription = null
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Forgot passcode?",
                style = MaterialTheme.typography.labelLarge.copy(fontSize = 16.sp), // Texto ligeramente más grande
                color = Color(0xFFFF6A00),
                modifier = Modifier.align(Alignment.End)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Botón de inicio de sesión
        Button(
            onClick = { /* Acción de inicio de sesión */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6A00),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp), // Bordes más redondeados
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp) // Botón más alto
        ) {
            Text(text = "Iniciar Sesión", color = Color.White, style = MaterialTheme.typography.displayMedium.copy(fontSize = 18.sp))
        }
    }
}

@Composable
private fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    uiColor: Color,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = uiColor
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.Black, // Cambia el texto al desenfocarse
            focusedTextColor = Color.Black,  // Cambia el texto al enfocarse
            unfocusedContainerColor = Color(0xFFEFEEEE), // Fondo desenfocado
            focusedContainerColor = Color(0xFFEFEEEE),   // Fondo enfocado
            unfocusedIndicatorColor = Color.Gray,       // Línea desenfocada
            focusedIndicatorColor = uiColor             // Línea enfocada
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)) // Bordes redondeados
            .height(55.dp)
            .background(Color(0xFFEFEEEE)),  // Fondo del campo
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
    )
}

@Composable
private fun LoginContent(viewModel: LoginViewModel, onNavigate: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        LoginSection(viewModel,onNavigate)
        Spacer(modifier = Modifier.height(30.dp))
        FooterSection()
    }
}

@Composable
private fun LoginSection(viewModel: LoginViewModel, onNavigate: () -> Unit = {}) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
//    val empresasState by viewModel.empresaState.collectAsState()
    var expanded by rememberSaveable { mutableStateOf(false) }
//    var selectedEmpresa by remember { mutableStateOf<Empresa?>(null) }
    val context = LocalContext.current
//    val navigateToHome by viewModel.navigateToHome.collectAsState()
    val isLoadingLogin by viewModel.isLoadingLogin.collectAsState()
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.DarkGray
//    val messageToast by viewModel.messageToast.collectAsState()

//    if (navigateToHome) {
//        onNavigate()
//    }

//    when (messageToast) {
//        is Resource.Error -> {
//            LaunchedEffect(messageToast) {
//                val errorMessage = (messageToast as Resource.Error).message
//                context.toast(errorMessage)
//            }
//        }
//        else -> {}
//    }

    Spacer(modifier = Modifier.height(20.dp))

// Selector de empresas
    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
//            enabled = empresasState !is Resource.Loading  // Desactivar mientras carga las empresas
        ) {
            Text(
//                text = selectedEmpresa?.razonSocial ?: "Selecciona una empresa",
                text =  "Selecciona una empresa",
                color = uiColor
            )
        }
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
//            when (empresasState) {
//                is Resource.Loading -> {
//                    DropdownMenuItem(
//                        onClick = { expanded = false },
//                        text = { Text(text = "Cargando empresas...") }
//                    )
//                }
//                is Resource.Success -> {
//                    (empresasState as Resource.Success<List<Empresa>>).data.forEach { empresa ->
//                        DropdownMenuItem(
//                            onClick = {
//                                viewModel.getEmpresas()
//                                selectedEmpresa = empresa
//                                expanded = false
//                            },
//                            text = { Text(text = empresa.razonSocial) }
//                        )
//                    }
//                }
//                is Resource.Error -> {
//                    DropdownMenuItem(
//                        onClick = { expanded = false },
//                        text = { Text(text = "No se pudieron cargar las empresas") }
//                    )
//                }
//            }
        }
    }


    Spacer(modifier = Modifier.height(16.dp))

    // Input de usuario
    CustomTextField(
        value = username,
        onValueChange = { username = it },
        label = "Usuario",
        uiColor = uiColor
    )

    Spacer(modifier = Modifier.height(16.dp))

    CustomTextField(
        value = password,
        onValueChange = { password = it },
        label = "Contraseña",
        uiColor = uiColor,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(id = if (passwordVisible) R.drawable.visibility else R.drawable.visibilityoff),
                    contentDescription = null
                )
            }
        }
    )

    Spacer(modifier = Modifier.height(25.dp))

    // Botón de login
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        onClick = {
//           viewModel.login(userName = username, password = password, idEmpresa = selectedEmpresa?.idEmpresa ?: "")
        },
        enabled = !isLoadingLogin,  // Deshabilitar mientras carga el login
        colors = ButtonDefaults.buttonColors(
//            containerColor = if (isSystemInDarkTheme()) MediumOrange else MediumOrange,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        if (isLoadingLogin) {
            CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
        } else {
            Text(
                text = "Ingresar",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium)
            )
        }
    }
}


@Composable
private fun FooterSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF94A3B8),
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("Cambiar modo : ")
                }
                withStyle(
                    style = SpanStyle(
                        color = uiColor,
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(" Controlador")
                }
            }
        )
    }
}
