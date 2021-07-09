package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityAmtEntryBinding

class AmtEntry_Activity: BaseActivity<ActivityAmtEntryBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_amt_entry
    }

    override fun initialise() {

        binding.proceedBtn.setOnClickListener(View.OnClickListener {

            changeActivity(this,Home_Activity::class.java,true);

        })

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })

    }

}