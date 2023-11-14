/**
 * Clase principal de la aplicación que gestiona la actividad principal y la navegación mediante un NavigationDrawer.
 */
package com.example.meeteducation

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.meeteducation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

/**
 * Clase principal que extiende AppCompatActivity y gestiona la actividad principal de la aplicación con un NavigationDrawer.
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding

    /**
     * Método llamado cuando se crea la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_navigation)
        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("user", "Nombre Predeterminado")

        val headerView = navigationView.getHeaderView(0)
        val usernameTextView: TextView = headerView.findViewById(R.id.textViewUsername)
        usernameTextView.text = username
    }

    /**
     * Método llamado cuando se selecciona un elemento del NavigationDrawer.
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_btn_saved -> Toast.makeText(this, "Elemento guardado", Toast.LENGTH_SHORT).show()
            R.id.nav_btn_config -> Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show()
            R.id.nav_btn_help -> Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show()
            R.id.nav_btn_logout -> Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    /**
     * Método llamado después de que se ha creado la actividad para sincronizar el estado del toggle.
     */
    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        toggle.syncState()
    }

    /**
     * Método llamado cuando la configuración de la actividad cambia.
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    /**
     * Método llamado cuando se selecciona un elemento del menú de opciones.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Método para actualizar el TextView de la barra de herramientas.
     */
    fun updateToolBarTextView(text: String) {
        val usernameTextView: TextView = findViewById(R.id.textViewUsername)
        usernameTextView.text = text
    }
}
