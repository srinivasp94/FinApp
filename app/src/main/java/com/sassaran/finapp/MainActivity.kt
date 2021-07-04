package com.sassaran.finapp

import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initialise() {

    }

}