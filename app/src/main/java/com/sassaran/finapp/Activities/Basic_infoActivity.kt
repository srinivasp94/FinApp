package com.sassaran.finapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityBasicInfoBinding

class Basic_infoActivity : BaseActivity<ActivityBasicInfoBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_basic_info
    }

    override fun initialise() {

    }
}