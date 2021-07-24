package com.thoughtworks.androidtrain

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val REQUEST_SELECT_PHONE_NUMBER = 1

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity Created")
    }

    fun openConstraintActivity(view: View) {
        val intent = Intent(this, ConstraintActivity::class.java)
        startActivity(intent)
    }

    fun openLoginActivity(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun openContact(view: View) {
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            .addCategory(Intent.CATEGORY_DEFAULT)
            .setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE)

        startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER)
        Log.d(TAG, "active contact intent")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d(TAG, "onActivityResult")

        if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK && data?.data != null) {
            val contactUri = data.data!!
            val projection = arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
            )
            val cursor = contentResolver.query(contactUri, projection, null, null, null)
            Log.d(TAG, cursor?.count.toString())

            if (cursor?.moveToFirst() == true) {
                val contactName =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val contactNumber =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                cursor.close()

                Log.d(TAG, "$contactName $contactNumber")
                Toast.makeText(this, "$contactName $contactNumber", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    fun openMyFragment(view: View) {
        val intent = Intent(this, MyFragmentActivity::class.java)
        startActivity(intent)
    }

    fun openRecyclerView(view: View) {
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }
}
