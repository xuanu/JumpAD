package cn.zeffect.apk.jump.ad.service;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class JumpADService extends BaseAccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        //com.sinyee.babybus.talk2kiki
        //com.sinyee.babybus.talk2kiki:id/admanager_iv_close
        Log.e("zeffect", event.getPackageName() + "," + event.getClassName());
        if (event.getPackageName() == null) {
            return;
        }
        String packageName = event.getPackageName().toString();
        if (event.getClassName() == null) {
            return;
        }
        String className = event.getClassName().toString();
        doBabyBus(packageName, className);
        doBilibili(packageName, className);
        doAcFun(packageName, className);
    }

    @Override
    public void onInterrupt() {

    }

    /**
     * 宝宝巴士相关
     *
     * @param packageName
     * @param className
     */
    private void doBabyBus(String packageName, String className) {
        if (packageName.equals("com.sinyee.babybus.talk2kiki")) {
            if (className.equals("android.widget.FrameLayout")) {
                clickTextViewByID("com.sinyee.babybus.talk2kiki:id/admanager_iv_close");
            }
        }
    }

    /**
     * Bilibili跳转广告
     *
     * @param packageName
     * @param className
     */
    private void doBilibili(String packageName, String className) {
        if (packageName.equals("tv.danmaku.bili")) {
            if (className.equals("tv.danmaku.bili.ui.splash.SplashActivity")) {
                //广告两字的id: tv.danmaku.bili:id/label_ad  可以先检测有没有这两个字，再确定是否点击。
                clickTextViewByID("tv.danmaku.bili:id/count_down");
            }
        }
    }

    /**
     * AcFun跳过广告
     *
     * @param packageName
     * @param className
     */
    private void doAcFun(String packageName, String className) {
        if (packageName.equals("tv.acfundanmaku.video")) {
            if (className.equals("tv.acfun.core.module.splash.SplashActivity")) {
                clickTextViewByID("tv.acfundanmaku.video:id/layout_skip_ad");
            }
        }
    }
}
