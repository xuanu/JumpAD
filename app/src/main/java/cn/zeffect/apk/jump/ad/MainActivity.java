package cn.zeffect.apk.jump.ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import cn.zeffect.apk.jump.ad.service.JumpADService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Switch jumpAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JumpADService.getInstance().init(this);
        boolean status = JumpADService.getInstance().checkAccessibilityEnabled(JumpADService.class.getName());
        jumpAd = findViewById(R.id.jump_status_switch);
        jumpAd.setChecked(status);
        jumpAd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == jumpAd) {
            JumpADService.getInstance().goAccess();
        }
    }
}
