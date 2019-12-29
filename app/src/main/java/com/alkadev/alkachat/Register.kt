package com.alkadev.alkachat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()
    }

    private fun initView(){
        btn_register_user.setOnClickListener{
            registerUserToFirebase()
        }
    }
    private fun registerUserToFirebase(){
        auth.createUserWithEmailAndPassword(txt_email.text.toString(), txt_password.text.toString())
            .addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "User berhasil dibuat", Toast.LENGTH_LONG).show()
                    Home.launchIntent(this)
                }else{
                    Toast.makeText(this, it.result.toString(), Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener{
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_LONG).show()
            }
    }
}
