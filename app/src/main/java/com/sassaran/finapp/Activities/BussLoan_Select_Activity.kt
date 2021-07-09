package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityBussloanSelectBinding

class BussLoan_Select_Activity : BaseActivity<ActivityBussloanSelectBinding>(),View.OnClickListener {

    override fun layoutRes(): Int {
        return R.layout.activity_bussloan_select
    }

    override fun initialise() {

        binding.termloanLl.setOnClickListener(this)
        binding.contfinLl.setOnClickListener(this)
        binding.vehfinLl.setOnClickListener(this)
        binding.agrifinLl.setOnClickListener(this)
        binding.devfinLl.setOnClickListener(this)
        binding.propfinLl.setOnClickListener(this)

        binding.comfinLl.setOnClickListener(this)
        binding.merchcreditLl.setOnClickListener(this)

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.termloan_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
            R.id.contfin_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
            R.id.vehfin_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
            R.id.agrifin_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
            R.id.devfin_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
            R.id.propfin_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
            R.id.comfin_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
            R.id.merchcredit_ll -> {
                changeActivity(this,AmtEntry_Activity::class.java,false);
            }
        }
    }

}


