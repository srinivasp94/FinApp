package com.sassaran.finapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityPersonalInfoBinding

class PersonalInfo_Activity : BaseActivity<ActivityPersonalInfoBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_personal_info
    }

    override fun initialise() {

    }
}