package com.example.firebasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.firebasesample.model.UserInfo
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dbReference: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase

    private var userId: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseDatabase = FirebaseDatabase.getInstance()
        dbReference = firebaseDatabase.getReference("users")

        userId = dbReference.push().key.toString()

        update_user_btn.setOnClickListener{
        var name: String = editname.text.toString()
            var mobile: String = editphone.text.toString()

            if(TextUtils.isEmpty(userId)){
                createUser(name, mobile)
            } else{
                updateUser(name, mobile)
            }
        }
    }

    private fun updateUser(name: String, mobile: String) {

        if (!TextUtils.isEmpty(name))
            dbReference.child(userId).child("name").setValue(name)

        if (!TextUtils.isEmpty(mobile))
            dbReference.child(userId).child("mobile").setValue(mobile)

        addUserChangeListener()
    }

    private fun createUser(name: String, mobile: String) {
        val user = UserInfo(name, mobile)
        dbReference.child(userId).setValue(user)
    }

    private fun addUserChangeListener() {
        dbReference.child(userId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(UserInfo::class.java)

                if (user == null) {
                    return
                }

                username.setText(user?.name).toString()
                usermobile.setText(user?.mobile).toString()

                editname.setText("")
                editphone.setText("")

               changeButtonText()

    }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun changeButtonText(){
        if (TextUtils.isEmpty(userId)) {
            update_user_btn.text = "Save";
        } else {
            update_user_btn.text = "Update";
        }
    }
}















