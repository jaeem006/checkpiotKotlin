package org.bedu.circulodeestudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

const val USER_NAME = "org.bedu.circulodeestudio.USER_NAME"

class MainActivity : AppCompatActivity() {

    private lateinit var boton : Button
    private lateinit var input : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // seteando el appbar como action bar
        val appBar = findViewById<Toolbar>(R.id.app_bar)
        this.setSupportActionBar(appBar)

        setupDrawer(appBar)

        // PASAR INFO ENTRE ACTIVITIES

        boton = findViewById(R.id.button)
        input = findViewById(R.id.nombre)

        boton.setOnClickListener{

            // empaquetamos la información que vamos a enviar 📦
            val bundle = Bundle()
            bundle.putString(USER_NAME, input.text.toString())

            // definimos el canal de comunicación 🚛
            val intent = Intent(this, ActivityTwo::class.java ).apply{
                putExtras(bundle)
            }

            startActivity(intent)
        }

    }


    //Agregar el menú de opciones al AppBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    // FUNCIONALIDAD DEL NAVIGATION DRAWER
    private fun setupDrawer(toolbar: Toolbar){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val drawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    val trans = supportFragmentManager.beginTransaction()
                    val fragmento = FragmentTwo()
                    trans.replace(R.id.fragmentContainer,fragmento)
                    trans.addToBackStack(null)
                    trans.commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_payment -> {
                    val trans = supportFragmentManager.beginTransaction()
                    val fragmento = FragmentThree()
                    trans.replace(R.id.fragmentContainer,fragmento)
                    trans.addToBackStack(null)
                    trans.commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_settings -> {
                    val trans = supportFragmentManager.beginTransaction()
                    val fragmento = FragmentOne()
                    trans.replace(R.id.fragmentContainer,fragmento)
                    trans.addToBackStack(null)
                    trans.commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_about -> {
                    val intent = Intent(this, ActivityThree::class.java).apply{}
                    startActivity(intent)
                }
            }
            true
        }
    }


}