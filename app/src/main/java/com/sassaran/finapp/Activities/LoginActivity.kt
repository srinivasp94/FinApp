package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_login
    }

    override fun initialise() {


        binding.otpRl.visibility=View.GONE
        binding.getOtpbtn.visibility=View.VISIBLE

        binding.getOtpbtn.setOnClickListener(View.OnClickListener {
            binding.otpRl.visibility=View.VISIBLE
            binding.verifyOtpbtn.visibility=View.VISIBLE
            binding.getOtpbtn.visibility=View.GONE

        })
        binding.verifyOtpbtn.setOnClickListener(View.OnClickListener {
            binding.getOtpbtn.visibility=View.GONE
            changeActivity(this,Home_Activity::class.java,true);


        })


    }
}