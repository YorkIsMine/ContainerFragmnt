package com.yorkismine.containerfragmnt

import android.app.NotificationChannel
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragment: SimpleFragment
    private var fragmentTag = "none"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editTextField = findViewById<EditText>(R.id.select_tag_et)

        add_btn.setOnClickListener {
            val text = editTextField.text.toString()
            var isTheSame = false

            for (i in supportFragmentManager.fragments) {
                if (text == i.tag) isTheSame = true
            }

            if ((text.trim().isEmpty()) or (isTheSame)){
                showToast()
                return@setOnClickListener
            }
            fragmentTag = text

            fragment = if (supportFragmentManager.backStackEntryCount != 0) {
                (supportFragmentManager
                    .findFragmentByTag(fragmentTag) as SimpleFragment? ?: SimpleFragment())
            } else SimpleFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.container_fr, fragment, fragmentTag)
                .addToBackStack(fragmentTag)
                .commit()

            editTextField.setText("")
        }

        replace_btn.setOnClickListener {
            val text = editTextField.text.toString()
            if (text.trim().isEmpty()){
                showToast()
                return@setOnClickListener
            }
            fragmentTag = text

            fragment = if (supportFragmentManager.backStackEntryCount != 0) {
                (supportFragmentManager
                    .findFragmentByTag(fragmentTag) as SimpleFragment? ?: SimpleFragment())
            } else SimpleFragment()

            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fr, fragment, fragmentTag)
                .addToBackStack(fragmentTag)
                .commit()

            editTextField.setText("")
        }
    }

    private fun showToast() {
        Toast.makeText(this, "Wrong input!", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.to_list) {
            val intent = Intent(this, ListActivity::class.java)
            val list = ArrayList<Tag>()

            for (i in supportFragmentManager.fragments) {
                val f: SimpleFragment = i as SimpleFragment
                list.add(Tag(i.tag!!, f.state))
            }

            intent.putParcelableArrayListExtra("list", list)
            startActivity(intent)
        }

        return true
    }

}
