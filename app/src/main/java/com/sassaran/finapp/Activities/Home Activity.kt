package com.sassaran.finapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityHomeScreenBinding

class Home_Activity : BaseActivity<ActivityHomeScreenBinding>() {



    val textnames = ArrayList<String>()
    val images = ArrayList<Int>()

    override fun layoutRes(): Int {
        return R.layout.activity_home_screen
    }

    override fun initialise() {

    }


}