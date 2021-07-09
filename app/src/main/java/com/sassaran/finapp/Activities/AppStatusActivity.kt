package com.sassaran.finapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityAppStatusBinding

class AppStatusActivity : BaseActivity<ActivityAppStatusBinding>() {
    override fun layoutRes(): Int {
        return R.layout.activity_app_status
    }

    override fun initialise() {


        binding.SubmitTv.setOnClickListener(View.OnClickListener {
              changeActivity(this,Home_Activity::class.java,true);


        })

        binding.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })


    }
}