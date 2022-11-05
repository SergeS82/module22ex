package ru.anudx.module22ex

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import ru.anudx.module22ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        val view = bin.root
        setContentView(view)
        bin.sun.setImageDrawable(this.getDrawable(R.drawable.anim_sun))
        bin.bigCloud.alpha = 1f
        bin.smallCloud.alpha = 0.3f
        val animBigCloud = ObjectAnimator.ofFloat(bin.bigCloud, View.TRANSLATION_X,0f,900f)
        val animBigCloud2 = bin.bigCloud.animate().setStartDelay(1000).setDuration(1500).setInterpolator(OvershootInterpolator()).alpha(0.3f)
        val animBigCloudScale = ObjectAnimator.ofFloat(bin.bigCloud, View.SCALE_Y,1f,0.9f)
        val animSmallCloud = ObjectAnimator.ofFloat(bin.smallCloud,View.TRANSLATION_X,0f,-1100f)
        val animSmallCloudScale = ObjectAnimator.ofFloat(bin.smallCloud, View.SCALE_Y,1f,1.3f)
        val animSet = AnimatorSet()
        val animSun = ObjectAnimator.ofFloat(bin.sun, View.TRANSLATION_Y,0f,-950f)
        val animSun2 = bin.sun.drawable as AnimatedVectorDrawable
        animSmallCloud.duration = 500
        animSmallCloud.startDelay = 500
        animSun.duration = 500
        animSun.startDelay = 500
        animBigCloud.duration = 500
        animBigCloud.startDelay = 500
        animBigCloudScale.duration = 1500
        animBigCloudScale.startDelay = 1000
        animSmallCloudScale.duration = 1500
        animSmallCloudScale.startDelay = 1000
        animBigCloudScale.interpolator = OvershootInterpolator()
        animSmallCloudScale.interpolator = OvershootInterpolator()
        animSun.interpolator = BounceInterpolator()
        animSet.playTogether(animSun,animBigCloud,animSmallCloud,animBigCloudScale,animSmallCloudScale)
        animSun2.start()
        animSet.start()
        //animBigCloud2.start()
    }
}