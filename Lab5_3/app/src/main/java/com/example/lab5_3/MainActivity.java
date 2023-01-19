package com.example.lab5_3;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml,  btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml, btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }

    private Animation initFadinAnimation()
    {
        AlphaAnimation Fadin = new AlphaAnimation(0f, 1f);
        Fadin.setDuration(3000);
        Fadin.setFillAfter(true);
        Fadin.setAnimationListener(animationListener);
        return Fadin;
    }
    private Animation initFadoutAnimation(){
        Animation FadeOut = new AlphaAnimation(1f,0f);
        FadeOut.setDuration(2000);
        FadeOut.setFillAfter(true);
        FadeOut.setAnimationListener(animationListener);
        return FadeOut;
    }

    private Animation initBlinkAnimation(){
        AlphaAnimation Blink = new AlphaAnimation(0f, 1f);
        Blink.setDuration(300);
        Blink.setRepeatMode(Animation.REVERSE);
        Blink.setRepeatCount(3);
        Blink.setFillAfter(true);
        Blink.setAnimationListener(animationListener);
        return Blink;
    }
    private Animation initZoomInAnimation(){
        ScaleAnimation ZoomIn = new ScaleAnimation(1,3,1,3,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ZoomIn.setDuration(1000);
        ZoomIn.setFillAfter(true);
        ZoomIn.setAnimationListener(animationListener);
        return ZoomIn;
    }
    private Animation initZoomOutAnimation(){
        ScaleAnimation ZoomOut = new ScaleAnimation(1,0.5f,1,0.5f,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ZoomOut.setDuration(1000);
        ZoomOut.setFillAfter(true);
        ZoomOut.setAnimationListener(animationListener);
        return  ZoomOut;
    }
    private Animation initRotateAnimation(){
        RotateAnimation Rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Rotate.setDuration(600);
        Rotate.setRepeatMode(Animation.RESTART);
        Rotate.setRepeatCount(2);
        Rotate.setInterpolator(new LinearInterpolator());
        Rotate.setFillAfter(true);
        Rotate.setAnimationListener(animationListener);
        return Rotate;
    }
    private Animation initMoveAnimation(){
        TranslateAnimation Move = new TranslateAnimation(0,0.75f*getScreenWidth(),0,0);
        Move.setDuration(800);
        Move.setFillAfter(true);
        Move.setAnimationListener(animationListener);
        return Move;
    }
    private Animation initSlideUpAnimation(){
        ScaleAnimation SlideUp = new ScaleAnimation(1,1,1,0);
        SlideUp.setDuration(500);
        SlideUp.setFillAfter(true);
        SlideUp.setAnimationListener(animationListener);
        return SlideUp;
    }
    private Animation initBounceAnimation(){
        ScaleAnimation Bounce = new ScaleAnimation(1,1,0,1);
        Bounce.setDuration(500);
        Bounce.setInterpolator(new BounceInterpolator());
        Bounce.setFillAfter(true);
        Bounce.setAnimationListener(animationListener);
        return Bounce;
    }
    private Animation initCombineAnimation(){
        ScaleAnimation Combine1 = new ScaleAnimation(1,3,1,3,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Combine1.setDuration(4000);
        Combine1.setFillAfter(true);
        Combine1.setAnimationListener(animationListener);
        Combine1.setInterpolator(new LinearInterpolator());

        RotateAnimation Combine2 = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Combine2.setDuration(500);
        Combine2.setRepeatMode(Animation.RESTART);
        Combine2.setRepeatCount(2);
        Combine2.setInterpolator(new LinearInterpolator());
        Combine2.setFillAfter(true);
        Combine2.setAnimationListener(animationListener);

        AnimationSet Combine = new AnimationSet(false);
        Combine.addAnimation(Combine1);
        Combine.addAnimation(Combine2);
        return Combine;
    }

    private void handleClickAnimationXml(Button btn, int animId) {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);
        animation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }


    private void handleClickAnimationCode(Button btn, final Animation animation) {
        // Handle onclickListenner to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();
        //HandleClickAnimationXML
        handleClickAnimationXml(btnFadeInXml,R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml,R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml,R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml,R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml,R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml,R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml,R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml,R.anim.anim_combine);

//        btnFadeInCode, btnFadeOutCode, btnBlinkCode, btnZoomInCode, btnZoomOutCode,
//        btnRotateCode, btnMoveCode, btnSlideUpCode, btnBounceCode,  btnCombineCode;
        handleClickAnimationCode(btnFadeInCode,initFadinAnimation());
        handleClickAnimationCode(btnFadeOutCode,initFadoutAnimation());
        handleClickAnimationCode(btnBlinkCode,initBlinkAnimation());
        handleClickAnimationCode(btnZoomInCode,initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode,initZoomOutAnimation());
        handleClickAnimationCode(btnRotateCode,initRotateAnimation());
        handleClickAnimationCode(btnMoveCode,initMoveAnimation());
        handleClickAnimationCode(btnSlideUpCode,initSlideUpAnimation());
        handleClickAnimationCode(btnBounceCode,initBounceAnimation());
        handleClickAnimationCode(btnCombineCode,initCombineAnimation());
    }
}