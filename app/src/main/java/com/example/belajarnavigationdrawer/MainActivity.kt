package com.example.belajarnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.example.belajarnavigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var mainConten: HalamanMainConten
    lateinit var tambahProduk: HalamanTambahProduk
    lateinit var sendFragment: HalamanSend
    lateinit var settingFragment: HalamanSetting
    lateinit var helpFragment: HalamanHelp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_content -> {
                mainConten = HalamanMainConten()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, mainConten)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "ini Halaman Inbox", Toast.LENGTH_SHORT)
                    .show()
            }

            R.id.tambah_produk -> {
                tambahProduk = HalamanTambahProduk()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, tambahProduk)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Draft", Toast.LENGTH_SHORT)
                    .show()
            }

            R.id.send -> {
                sendFragment = HalamanSend()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, sendFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Send", Toast.LENGTH_SHORT)
                    .show()
            }

            R.id.setting -> {
                settingFragment = HalamanSetting()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, settingFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Setting", Toast.LENGTH_SHORT)
                    .show()
            }

            R.id.help -> {
                helpFragment = HalamanHelp()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, helpFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Help", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.drawerLayout.closeDrawers()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
    }
        return super.onOptionsItemSelected(item)
    }
}