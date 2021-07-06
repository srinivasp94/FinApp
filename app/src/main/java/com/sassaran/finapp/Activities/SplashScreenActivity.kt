package com.sassaran.finapp.Activities

import android.content.Intent
import android.view.View
import com.sassaran.finapp.MainActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivitySplashScreenBinding
import java.util.*


class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {
    override fun layoutRes(): Int {
        return R.layout.activity_splash_screen
    }

    override fun initialise() {

        binding.disclaimerTv.setOnClickListener(View.OnClickListener {
            changeActivity(this@SplashScreenActivity, DiscPolicyActivity::class.java, true);

        })

        Timer().schedule(object : TimerTask() {
            override fun run() {
                changeActivity(this@SplashScreenActivity, LoginActivity::class.java, true);

            }
        }, 1500)


    }
}