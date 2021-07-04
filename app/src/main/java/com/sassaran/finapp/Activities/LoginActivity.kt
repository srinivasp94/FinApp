package com.sassaran.finapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_login
    }

    override fun initialise() {

        changeActivity(this,Home_Activity::class.java,true);

    }
}