package com.nctech.aboutcanada

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nctech.aboutcanada.network.helper.CoreManager

/**
 *  Main activity
 */
class AboutCanadaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoreManager.getInstance()?.init(this)
        setSupportActionBar(findViewById(R.id.feed_toolbar))
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, AboutCanadaFragment())
            .commit()
    }
}
