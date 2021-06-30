package com.sassaran.finapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inspirenetz.netzapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initialise() {

    }

}