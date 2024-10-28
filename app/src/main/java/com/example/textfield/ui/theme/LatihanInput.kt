package com.example.textfield.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var datagender = listOf("Laki-Laki","Perempua")

    var confnama by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var confemail by remember { mutableStateOf("") }
    var confnotelpon by remember { mutableStateOf("") }
    var confgender by remember { mutableStateOf("") }

    Column (
        modifier = modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text("Isi nama anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Row (modifier = Modifier.fillMaxWidth()){
            datagender.forEach{selectedgender->
                Row(verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = gender == selectedgender,
                        onClick = {gender = selectedgender}
                    )
                    Text(text = selectedgender)
                }
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text("Isi email anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)


        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text("Isi alamat anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)

        )

        TextField(
            value = notelpon,
            onValueChange = {notelpon = it},
            label = {
                Text(text = "No.Telpon")
            },
            placeholder = {
                Text("Isi no.telpon anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            confnama = nama
            confalamat = alamat
            confemail = email
            confnotelpon = notelpon
            confgender = gender
        }) {
            Text(text = "Simpan")
        }
        Tampildata(
            Param = "nama",
            Argu = confemail,
        )
        Tampildata(
            Param = "email",
            Argu = confemail,
        )
        Tampildata(
            Param = "alamat",
            Argu = confalamat,
        )
        Tampildata(
            Param = "notelpon",
            Argu = confnotelpon,
        )
        Tampildata(
            Param = "gender",
            Argu = confgender,
        )


    }
}

@Composable
fun Tampildata(
    Param: String, Argu: String
){
    Column (
        modifier = Modifier.padding(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = Param,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = Argu,
                modifier = Modifier.weight(2f))
        }
    }
}
