package com.sassaran.finapp.base


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sassaran.finapp.R
import java.io.Serializable


public abstract class BaseActivity<D : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding : D


    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun initialise()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )*/



        binding = DataBindingUtil.setContentView(this,layoutRes())

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {


            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }

        hideKeyboard(this)



        initialise()

    }

    fun loadFragment(
        fragmentContainerID: Int,
        fragment: Fragment,
        addTobackstack: Boolean,
        add: Boolean
    ) {

        try {


            val fragmentManager: FragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()

            if (!fragment.isAdded) {
                if (add) {
                    fragmentTransaction.add(
                        fragmentContainerID,
                        fragment, fragment.javaClass.simpleName
                    )
                } else {
                    fragmentTransaction.replace(
                        fragmentContainerID,
                        fragment, fragment.javaClass.simpleName
                    )
                }
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up)
                if (addTobackstack) {
                    fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
                }
                fragmentTransaction.commitAllowingStateLoss()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    open fun hideKeyboard(activity: Activity) {
        val view: View = activity.findViewById(android.R.id.content)
        if (view != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }
    }

    open fun changeActivity(
        activity: Activity,
        newActivityClass: Class<Activity?>?,
        isFinish: Boolean
    ) {
        val intent = Intent(activity, newActivityClass)
        startActivity(intent)
        if (isFinish) {
          finish()
        }
    }

    fun Activity.changeActivityWithAnimation(newActivityClass: Class<Activity>, enteringAnimation: Int, exitingAnimation: Int, extras: Map<String, Serializable>?=null) {
        val intent = Intent(this , newActivityClass)

        extras?.let { it.forEach{ pair -> intent.putExtra(pair.key, pair.value)} }

        overridePendingTransition(enteringAnimation, exitingAnimation)

        finish()
        startActivity(intent)
    }

}