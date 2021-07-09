package com.sassaran.finapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityBasicInfoBinding

class Basic_infoActivity : BaseActivity<ActivityBasicInfoBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_basic_info
    }

    override fun initialise() {

        val proceed_btn: Button = findViewById(R.id.proceed_btn)

        proceed_btn.setOnClickListener(View.OnClickListener {
          //  changeActivity(this,PersonalInfo_Activity::class.java,true);
            val intent = Intent(this, PersonalInfo_Activity::class.java)
            intent.putExtra("tag", "from_basicinfo")
            startActivity(intent)

        })

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })


    }
}